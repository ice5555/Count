<template>
    <div id="app">
      <div id="wrap">
          <div id="header-bar"></div>
          <div id="content" style="height: 360px">
              <h2>登录</h2>
              <form action="province/provincelist.html" method="post">
                  <label>
                      <div class="label-text">账&emsp;号：</div>
                      <input type="text" v-model="user.username" name="username">
                  </label>
                  <label>
                      <div class="label-text">密&emsp;码：</div>
                      <input type="password" v-model="user.password" name="password">
                  </label>
                  <button type="button" @click="login">提 交</button>&emsp;
                  <a href="reg.html">去注册</a>
              </form>
          </div>
          <div id="footer">
              ABC@126.com
          </div>
      </div>
    </div>
  </template>
  
<script>
  import axios from 'axios'
  export default {
    data() {
      return {
        user: {},
      }
    },
    methods: {
      login() {
        axios.post('http://localhost:8989/user/login', this.user).then((res) => {
            console.log(res.data);
            localStorage.setItem("userId", res.data.userId);
            if (res.data.states) {
            alert(res.data.mag + ",点击确定进入主页");
            location.href = './province/provincelist.html';
            } 
            else {
                alert(res.data.mag);
            }
        }              
        );
    }
    }
}
</script>
