<template>
    <div class="register"> 
        <el-form :model="userDto" 
                status-icon 
                :rules="rules" 
                ref="userDto" 
                label-width="100px" 
                class="register-form">

        <div class="title-container">
          <h3 class="title">用户注册</h3>
        </div>
    
        <el-form-item label="用户名" prop="username">
            <el-input v-model="userDto.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="userDto.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="passwordConfirmation">
            <el-input type="password" v-model="userDto.passwordConfirmation" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
            <el-input type="text" v-model="userDto.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="验证码" prop="img">
            <img :src="src" id="img-vcode" @click="getImage" :key="key" class="vcode-img">
            <el-input v-model="code" name="vcode" class="vcode-input"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click.native.prevent="handleRegister">注册</el-button>
            <!-- <el-button @click="backLogin('ruleForm')">返回</el-button> -->
        </el-form-item>
        </el-form>
    </div>
  </template>
  
  <script>
  export default {
    // name: "register",
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
      };
       
    },
    methods: {
        handleRegister() {
          if(!this.code || !this.key) {
          console.log("code 和 key 不能为空");
      return;
        }
          this.$axiosJava.post('/user/register?code='+this.code+"&key="+this.key,
            // "code":this.code,"key":this.key,"userDto":{
                                            {"username":this.userDto.username,
                                            "password":this.userDto.password,
                                            "email":this.userDto.email}).then((res)=>{
                console.log(res.data);
                if(res.data.states){
                    alert(res.data.mag+"点击确定跳转到登录页面！！");
                    this.$router.push({path: '/'});
                }else{
                    alert(res.data.mag);
                }
      })
    },
    getImage(){
                this.$axiosJava.get("/user/getImage").then((res)=>{
                    console.log(res.data);
                    this.src="data:image/png;base64,"+res.data.image;
                    this.key=res.data.key;
                });
            },
    created(){
            this.getImage();//获取验证码
        },
  }}
  </script>
  
  <style scoped>
    .register {
      position: absolute;
      width: 100%;
      height: 100%;
      background-color: whitesmoke;
      background: url("../../static/image/login.jpeg");
      background-size: cover;
      background-position: center;
    }
  
    .register .register-form {
      background-color: rgb(224, 224, 224);
      position: absolute;
      width: 300px;
      height: 500px;
      left: calc(50% - 250px);
      top: calc(50% - 200px);
      border: 1px solid gainsboro;
      border-radius: 20px;
      padding: 20px;
    }
    .register .register-form img {
      width: 56px;
            height: 21px;
            float:right;
            position: relative;
            top:2px;
            left:-6px
    }
  </style>