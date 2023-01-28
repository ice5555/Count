<template>
    <div class="login-container">
      <el-form
        :model="loginForm"
        auto-complete="on"
        class="login-form"
        ref="loginForm"
        label-position="left"
      >
  
        <div class="title-container">
          <h3 class="title">用户登录</h3>
        </div>
  
        <el-form-item prop="username">
          <!-- <span class="svg-container">
            <svg-icon icon-class="user"/>
          </span> -->
          <el-input
            auto-complete="on"
            name="username"
            placeholder="Username"
            ref="username"
            tabindex="1"
            type="text"
            v-model="loginForm.username"
          />
        </el-form-item>
  
        <el-form-item prop="password">
          <!-- <span class="svg-container">
            <svg-icon icon-class="password"/>
          </span> -->
          <el-input
            @keyup.enter.native="handleLogin"
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
  
        <el-button :loading="loading" @click.native.prevent="handleLogin" style="width:100%;margin-bottom:30px;"
                   type="primary">登录
        </el-button>
      </el-form>
    </div>
  </template>
  
<script>
    import Cookie from "js-cookie"
  
    export default {
      name: "login",
      data() {
        return {
          loginForm: {
            username: "",
            password: ""
          },
          loading: false
        }
      },
      methods: {
    handleLogin() {
        this.$axiosJava.post('/user/login', this.loginForm)
        .then((res) => {
            if (res.data.states) {
              localStorage.setItem("userId", res.data.userId);
                Cookie.set("token", res.data.userId);
                // this.$store.commit('setUsername', res.data.username)
                this.$router.push({path: '/'});
            } else {
                alert(res.data.mag);
            }
        })
        .catch((err) => {
            console.log(err);
        });
    }
}

    }
  </script>
  
  <style scoped>
    .login-container {
      position: absolute;
      width: 100%;
      height: 100%;
      background-color: whitesmoke;
      background: url("../../static/image/login.jpeg");
      background-size: cover;
      background-position: center;
    }
  
    .login-container .login-form {
      background-color: rgb(224, 224, 224);
      position: absolute;
      width: 300px;
      height: 300px;
      left: calc(50% - 250px);
      top: calc(50% - 200px);
      border: 1px solid gainsboro;
      border-radius: 20px;
      padding: 20px;
    }
  </style>
  