<template>
    <div class="Header">
      <img class="" :src="'./static/image/logo4.png'">
      <div class="title">记账系统</div>
      <div class="user"><i class="el-icon-user-solid"></i>admin </div>
    </div>
  </template>
  
<script>
    export default {
    name: "Header"
    }
</script>
  
<style scoped>
    .Header {
      width: 100%;
      height: 60px;
      line-height: 60px;
      background-color: rgb(100, 191, 237);
      text-align: left;
      display: flex;
      
    }
  
    .Header img {
      width: 42px;
      margin-top: 9px;
      margin-bottom: 9px;
      margin-left: 9px;
      /* margin */
    }
  
    .Header .title{
      font-size: 18px;
      color: white;
      font-weight: bolder;
      width: calc(100% - 145px);
    }
  
    .Header .user{
      cursor: pointer;
      font-size: 14px;
      color: white;
      font-weight: bolder;
    }
</style>
  