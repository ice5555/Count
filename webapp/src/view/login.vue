<template>
  <div class="login-container">
    <div class="main">
      <div class="loginbox">
        <div class="background"></div>
        <div class="loginbox-right">
          <el-form
            :model="loginForm"
            auto-complete="on"
            class="login-form"
            ref="loginForm"
            label-position="left"
          >
            <div class="title-container">
              <h3 class="title">Login</h3>
            </div>

            <el-form-item prop="username">
              <i class="el-icon-user-solid"></i>
              <input
                class="input"
                auto-complete="on"
                name="username"
                placeholder="Username"
                ref="username"
                tabindex="1"
                type="text"
                v-model="loginForm.username"
              />
            </el-form-item>

            <el-form-item prop="password" @keyup.enter.native="handleLogin">
              <i class="el-icon-key"></i>
              <input
                class="input"
                auto-complete="on"
                name="password"
                placeholder="Password"
                ref="password"
                tabindex="2"
                v-model="loginForm.password"
              />
              <!-- <span @click="showPwd" class="show-pwd"> -->
              <!-- </span> -->
            </el-form-item>

            <el-button @click.native.prevent="handleLogin" type="primary" round
              >登录</el-button
            >
            <!-- <el-button @click.native.prevent="register" 
                   type="primary">注册
        </el-button> -->


            <div class="register-text">
              <span>还没有账号?</span>
              <el-link class="link" type="info" @click.native.prevent="register"
                >点此注册</el-link
              >
            </div>
            <!-- 
            <el-link class="link" type="info" @click.native.prevent="register"
              >还没有账号？点此注册</el-link
            > -->
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>
  
<script>
import Cookie from "js-cookie";

export default {
  name: "login",
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
      loading: false,
    };
  },
  methods: {
    handleLogin() {
      this.$axiosJava
        .post("/user/login", this.loginForm)
        .then((res) => {
          if (res.data.states) {
            localStorage.setItem("userId", res.data.userId);
            Cookie.set("token", res.data.userId);
            // this.$store.commit('setUsername', res.data.username)
            this.$router.push({ path: "/" });
          } else {
            alert(res.data.mag);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    register() {
      this.$router.push({ path: "/register" });
    },
  },
};
</script>
  
  <style scoped>
@font-face {
  font-family: zaozi;
  src: url(../../static/fonts/Alibaba-PuHuiTi-Bold.ttf);
}

.login-container {
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: whitesmoke;
  background: url("../../static/image/login.jpg");
  background-size: cover;
  background-position: center;
}
.input {
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
.loginbox {
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
.loginbox-right {
  background-color: #ffffff;
  width: 333px;
  opacity: 0.75;
  /* animation: bounceIn 0.1s; */
}
/* @keyframes bounceIn {
  0% {
    transform: scale(0);
  }
  60% {
    transform: scale(0.5);
  }
  100% {
    transform: scale(1);
  }
} */

/* .login-container .loginbox .loginbox-right .login-form {
      background-color: rgba(255, 251, 251, 0.945);
      /* position: absolute; */
/* width: 300px;
      height: 300px;
      left: calc(50% - 250px);
      top: calc(50% - 200px);
      border: 1px solid gainsboro;
      border-radius: 20px; */
/* padding: 20px; 
    } */

.login-container .login-form button {
  border: none;
  outline: none;
  margin: 2.5rem 0 0;
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

.link {
  /* border: none;
  outline: none; */
  /* margin:2.5rem 0 0; */
  height: 3 rem;
  /* width: 10%; */

  margin: 10px;

  /* cursor: pointer; */
}
.register-text {

  margin: 10px;

  /* display: flex; */
  /* align-items: center; */
}
.register-text span{
  font-size: 14px;
  color: #909399;
  margin: auto;
}
.title {
  margin-top: 150px;
  font-family: zaozi;
  font-size: 2.5rem;
  /* font-weight: bold; */
  color: rgba(86, 126, 211, 0.918);
  /* text-shadow: 2px 2px rgba(204, 204, 204, 0.911); */
  /* margin-bottom: 0.5rem; */
}
.el-icon-user-solid {
  margin-right: 10px; /* 设置右外边距为 10px */
  font-size: 20px;
}
.el-icon-key {
  margin-right: 10px;
  font-size: 20px;
}
</style>
  