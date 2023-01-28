<template>
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="密码" prop="pass">
      <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="确认密码" prop="checkPass">
      <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model.number="ruleForm.age"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

  <script>
    export default {
      data() {
        var checkAge = (rule, value, callback) => {
          if (!value) {
            return callback(new Error('年龄不能为空'));
          }
          setTimeout(() => {
            if (!Number.isInteger(value)) {
              callback(new Error('请输入数字值'));
            } else {
              if (value < 18) {
                callback(new Error('必须年满18岁'));
              } else {
                callback();
              }
            }
          }, 1000);
        };
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            if (this.ruleForm.checkPass !== '') {
              this.$refs.ruleForm.validateField('checkPass');
            }
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.ruleForm.pass) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        };
        return {
          ruleForm: {
            pass: '',
            checkPass: '',
            age: ''
          },
          rules: {
            pass: [
              { validator: validatePass, trigger: 'blur' }
            ],
            checkPass: [
              { validator: validatePass2, trigger: 'blur' }
            ],
            age: [
              { validator: checkAge, trigger: 'blur' }
            ]
          }
        };
      },
      methods: {
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              alert('submit!');
            } else {
              console.log('error submit!!');
              return false;
            }
          });
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }

  </script>
<script>

data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.userDto.passwordConfirmation !== '') {
          this.$refs.userDto.validateField('passwordConfirmation');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.userDto.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        // this.userDto = Object.assign({}, ruleForm);
        callback();
      }
    };
    return {
        userDto:{
        username:"",
        password:"",
        passwordConfirmation:"",
        email:"",
    },
    code:'',
    src:'',
    key:'',
    rules: {
        password: [
          { validator: validatePass, trigger: 'blur' }
        ],
        passwordConfirmation: [
          { validator: validatePass2, trigger: 'blur' }
        ]

      },
    // userDto:{},
  }

</script>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        form{
            width:270px;
        }
        input{
            width: 70%;
            background: #eee;
        }
        input:focus{
            background: #fff;
        }
        form{
            padding: 0 12px 12px;
        }
        label{
            display: block;
            padding-bottom:12px;
        }
        #img-vcode{
            width: 56px;
            height: 21px;
            float:right;
            position: relative;
            top:2px;
            left:-6px
        }
        .label-text{
            width: 30%;
            float: left;
        }
    </style>
</head>
<body>
<div id="app">
    <div id="wrap">
        <div id="header">
            <div style="float: right;padding-top: 24px">2020/06/06&emsp;</div>
            <h1>旅游信息管理系统</h1>
        </div>
        <div id="header-bar"></div>
        <div id="content" style="height: 360px">
            <img src="img/timg.jpg" style="float: right;height: 320px">
            <h2>注册</h2>
            <form action="province/provincelist.html" method="post">
                <label>
                    <div class="label-text">账&emsp;号：</div>
                    <input type="text" v-model="user.username" name="username">
                </label>
                <label>
                    <div class="label-text">密&emsp;码：</div>
                    <input type="password" v-model="user.password" name="password">
                </label>
                <label>
                    <div class="label-text">邮&emsp;箱：</div>
                    <input type="text"  v-model="user.email" name="email">
                </label>
                <img :src="src" id="img-vcode" @click="getImage" :key="key">
                <label>
                    <div class="label-text">验证码：</div>
                    <input type="text" v-model="code" name="vcode" style="width: 100px">
                </label>
                <button type="button" @click="saveUserInfo">提 交</button>&emsp;
                <a href="login.html">去登录</a>
            </form>
        </div>
        <div id="footer">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
<script src="./js/vue.js"></script>
<script src="./js/axios.min.js"></script>
<script>
    const app =  new Vue({
        el:"#app",
        data:{
            user:{},
            code:"",
            src:"",
            key:"",
        },

        methods:{
            //注册
            saveUserInfo(){
                console.log(this.user);
                console.log(this.code);
                if(!this.user.username){
                    alert("用户名不能为空！");
                    return;
                }
                if(!this.user.password){
                    alert("密码不能为空！");
                    return;
                }
                if(!this.user.email){
                    alert("邮箱不能为空！");
                    return;
                }
                //发送axios请求
                axios.post("http://localhost:8989/user/register?code="+this.code+"&key="+this.key,this.user).then((res)=>{
                    console.log(res.data);
                    if(res.data.states){
                        alert(res.data.mag+"点击确定跳转到登录页面！！");
                        location.href='./login.html';
                    }else{
                        alert(res.data.mag);
                    }
                });
            },
            //获取验证码
            getImage(){
                _this = this;
                axios.get("http://localhost:8989/user/getImage").then((res)=>{
                    console.log(res.data);
                    _this.src="data:image/png;base64,"+res.data.image;
                    _this.key=res.data.key;
                });
            },


        },
        created(){
            this.getImage();//获取验证码
        }
    });
</script>