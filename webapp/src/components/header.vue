<template>
    <div class="header">
      <!--img :src="'./static/images/logo.png'"-->
      <div class="title">记账系统</div>
      <div class="user"><i class="el-icon-user-solid"></i>admin </div>
    </div>
  </template>
  
<script>
    export default {
    name: "header"
    }
</script>
  
<style scoped>
    .header {
      width: 100%;
      height: 60px;
      background-color: rgb(100, 191, 237);
      text-align: left;
      display: flex;
      line-height: 60px;
    }
  
    .header img {
      width: 42px;
      margin: 9px;
    }
  
    .header .title{
      font-size: 18px;
      color: white;
      font-weight: bolder;
      width: calc(100% - 145px);
    }
  
    .header .user{
      cursor: pointer;
      font-size: 14px;
      color: white;
      font-weight: bolder;
    }
</style>
  