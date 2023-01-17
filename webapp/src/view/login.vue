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
          <span class="svg-container">
            <svg-icon icon-class="user"/>
          </span>
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
          <span class="svg-container">
            <svg-icon icon-class="password"/>
          </span>
          <el-input
            :key="passwordType"
            :type="passwordType"
            @keyup.enter.native="handleLogin"
            auto-complete="on"
            name="password"
            placeholder="Password"
            ref="password"
            tabindex="2"
            v-model="loginForm.password"
          />
          <span @click="showPwd" class="show-pwd">
          </span>
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
        const validateUsername = (rule, value, callback) => {
          if (value.trim().length < 1) {
            callback(new Error("Please enter the correct user name"))
          } else {
            callback()
          }
        }
        const validatePassword = (rule, value, callback) => {
          if (value.length < 6) {
            callback(new Error("The password can not be less than 6 digits"))
          } else {
            callback()
          }
        }
        return {
          loginForm: {
            username: "",
            password: ""
          },
          loginRules: {
            username: [{required: true, trigger: "blur", validator: validateUsername}],
            password: [{required: true, trigger: "blur", validator: validatePassword}]
          },
          loading: false,
          passwordType: "password",
          redirect: undefined
        }
      },
      methods: {
        showPwd() {
          if (this.passwordType === "password") {
            this.passwordType = ""
          } else {
            this.passwordType = "password"
          }
          this.$nextTick(() => {
            this.$refs.password.focus()
          })
        },
        handleLogin() {
          Cookie.set("token", "1111", {expires: 1,})
          location.reload()
        
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
      background: url("../../static/image/login.png");
    }
  
    .login-container .login-form {
      background-color: white;
      position: absolute;
      width: 500px;
      height: 300px;
      left: calc(50% - 250px);
      top: calc(50% - 200px);
      border: 1px solid gainsboro;
      border-radius: 20px;
      padding: 20px;
    }
  </style>
  