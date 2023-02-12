<template>
  <div class="register">
    <div class="register-box">
      <div class="background"></div>
      <div class="register_box-right">
        <el-form
          :model="userDto"
          status-icon
          :rules="rules"
          ref="userDto"
          class="login-form"
        >
          <div class="title-container">
            <h3 class="title">Register</h3>
          </div>
          <div>
            <el-form-item class="label" label="用户名" prop="username">
            
            <input
              
              class="input" 
              auto-complete="on"
              name="username"
              placeholder="请输入用户名"
              ref="username"
              tabindex="1"
              type="text"
              v-model="userDto.username"
            />
          </el-form-item>
          </div> 
          
          <el-form-item class="label" label="密码" prop="password">
            <div class="password">

              <input
             
              class="input"
              auto-complete="off"
              name="password"
              placeholder="请输入密码"
              ref="password"
              tabindex="1"
              type="password"
              v-model="userDto.password"
            />
            </div>
            
            <!-- <el-input
              type="password"
              v-model="userDto.password"
              autocomplete="off"
            ></el-input> -->
          </el-form-item>
          <el-form-item
            class="label"
            label="确认密码"
            prop="passwordConfirmation"
          >
          <div class="retype">
            <input
              
              class="input"
              auto-complete="off"
              name="passwordConfirmation"
              placeholder="请再次输入密码"
              ref="passwordConfirmation"
              tabindex="1"
              type="password"
              v-model="userDto.passwordConfirmation"
            />
          </div>
            
            <!-- <el-input
              type="password"
              v-model="userDto.passwordConfirmation"
              autocomplete="off"
            ></el-input> -->
          </el-form-item>
          <el-form-item class="label" label="邮箱" prop="email">
            <div class="email">

              <input
         
              class="input"
              auto-complete="off"
              name="email"
              placeholder="请输入邮箱"
              ref="email"
              tabindex="1"
              type="text"
              v-model="userDto.email"
            />
            </div>
            
            <!-- <el-input
              type="text"
              v-model="userDto.email"
              autocomplete="off"
            ></el-input> -->
          </el-form-item>
          <el-form-item class="label" label="验证码" prop="img">
           <div>
              <input

              class="input-vertifycode"
              auto-complete="off"
              name="vertifycode"
              placeholder="请输入验证码"
              width="24%"
              ref="vertifycode"
              tabindex="1"
              type="text"
              v-model="code"
            />
            
            <img
              :src="src"
              id="img-vcode"
              @click="getImage"
              :key="key"
            
              class="img-code"
            /></div>
            <!-- <el-input
              v-model="code"
              name="vcode"
              class="vcode-input"
            ></el-input> -->
          </el-form-item>

          <el-form-item class="register-button">
            <el-button type="primary" @click.native.prevent="handleRegister" round
              >注册</el-button
            >
          </el-form-item>
          <div class="register-text">
            <!-- <el-link class="link" type="info" @click.native.prevent="register"
              >点此登录</el-link
            > -->

            <span>已有账号?</span>
            <!-- <a href="localhost:8080">点此登录</a> -->
            <!-- <a href="/login" class="link" style="color: #909399">点此登录</a> -->
            <el-link class="link" type="info" @click.native.prevent="login"
              >点此登录</el-link
            >
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>
  
  <script>
export default {
  //name: "register",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.userDto.passwordConfirmation !== "") {
          this.$refs.userDto.validateField("passwordConfirmation");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.userDto.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };

    return {
      userDto: {
        username: "",
        password: "",
        passwordConfirmation: "",
        email: "",
      },
      code: "",
      src: "",
      key: "",
      rules: {
        password: [{ validator: validatePass, trigger: "blur" }],
    
        passwordConfirmation: [{
validator: (rule, value, callback) => {
if (value !== this.userDto.password) {
callback(new Error("两次密码输入不一致"));
} else {
callback();
}
},
trigger: "blur"
}],

      },
      // userDto:{},
    };
  },
  methods: {
    handleRegister() {
      if (!this.code || !this.key) {
        console.log("code 和 key 不能为空");
        return;
      }
      this.$axiosJava
        .post(
          "/user/register?code=" + this.code + "&key=" + this.key,
          // "code":this.code,"key":this.key,"userDto":{
          {
            username: this.userDto.username,
            password: this.userDto.password,
            email: this.userDto.email,
          }
        )
        .then((res) => {
          console.log(res.data);
          if (res.data.states) {
            alert(res.data.mag + "点击确定跳转到登录页面！！");
            this.$router.push({ path: "/" });
          } else {
            alert(res.data.mag);
          }
        });
    },
    getImage() {
      this.$axiosJava.get("/user/getImage").then((res) => {
        console.log(res.data);
        this.src = "data:image/png;base64," + res.data.image;
        this.key = res.data.key;
      });
    },
    created() {
      this.getImage(); //获取验证码
    },
    login() {
      this.$router.push({ path: "/login" });
    },
  },
  mounted() {
    this.getImage();
  },
};
</script>
  
  <style scoped>
@font-face {
  font-family: zaozi;
  src: url(../../static/fonts/Alibaba-PuHuiTi-Bold.ttf);
}

.register-box {
  display: flex;
  position: absolute;
  width: 1114px;
  height: 600px;
  top: 48%;
  left: 50%;
  transform: translate(-50%, -50%);
  box-shadow: 0 5px 5px 0 rgba(40, 47, 58, 0.24), 0 17px 50px 0 #4e655d;
}
.background {
  width: 800px;
  background-image: url("../../static/image/home.jpg");
  background-size: cover;
  /* opacity: 0.90; */
}
.register_box-right {
  background-color: #ffffff;
  width: 333px;
  opacity: 0.75;
}

.title {
  /* margin-top: 150px; */
  font-family: zaozi;
  font-size: 2.5rem;
  /* font-weight: bold; */
  color: rgba(86, 126, 211, 0.918);
  /* text-shadow: 2px 2px rgba(204, 204, 204, 0.911); */
  /* margin-bottom: 0.5rem; */
}

.label {
  margin-left: 23px;
}

.input {
  margin-right: 19px;
  outline: none;
  /* width: 100%; */
  position: relative;
  line-height: 20px;
  background-color: transparent;
  z-index: 1;
  position: relative;
  border: none;
  border-bottom: 0.13rem solid rgb(103, 183, 248);
}

.input-vertifycode {
  margin-left: -40px;
  outline: none;
  width: 27%;
  position: relative;
  line-height: 20px;
  background-color: transparent;
  z-index: 1;
  position: relative;
  border: none;
  border-bottom: 0.13rem solid rgb(103, 183, 248);
}
.login-form button {
  border: none;
  outline: none;
  /* margin: 2.5rem 0 0; */
  height: 3 rem;
  width: 50%;
  background: linear-gradient(20deg, rgb(255, 123, 200), rgb(127, 205, 219));
  box-shadow: 0 0 3px rgb(62, 170, 156);
  border-radius: 3 rem;
  cursor: pointer;
  color: white;
  /* margin-left: 10px; */
  margin-top: 15px;
}
.register {
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: whitesmoke;
  background: url("../../static/image/login.jpg");
  background-size: cover;
  background-position: center;
}

.register-text {
  margin: 10px;

  /* display: flex; */
  /* align-items: center; */
}
.register-text span {
  font-size: 14px;
  color: #909399;
  /* margin: auto; */
}
.link {
  height: 3 rem;
  margin-bottom: 3px;
  /* margin: 10px; */
}
.password{
  margin-right: -14px;
}
.retype{
  margin-right:10px;
}
.email{
  margin-right: -14px;
}
.img-code{
  height:30px;
  width:85px;
  margin-bottom: -8px;
    padding-left: 10px;
  /* margin-left: 130px;
  margin-top: 10px; */
}
.register-button{
  margin: auto;
}
.register-form {
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
.register-form img {
  width: 56px;
  height: 21px;
  float: right;
  position: relative;
  top: 2px;
  left: -6px;
}
</style>