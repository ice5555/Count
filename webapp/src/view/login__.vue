
<template>


    <div id="app" class="container">
        <img src="./bg.jpg" alt="">
        <div class="panel">
            <div class="content login">
                <div class="switch">
                    <span :class='{"active":active === "login"}' @click="go('login')">登录</span>
                    <span>/</span>
                    <span :class='{"active":active === "register"}' @click="go('register')">注册</span>
                </div>
                <div class="form" id="fromLogin">
                    <!-- 如果按钮选择的是注册就展示这个里面的内容 -->
                    <template v-if="active === 'register'">
                        <div class="input">
                            <input :class="{hasValue : registerForm.email}" v-model="registerForm.email" type="text" name="email" id="email">
                            <label for="email">邮箱</label>
                        </div>
                        <div class="input">
                            <input :class="{hasValue : registerForm.Username}" v-model="registerForm.Username" type="text" name="Username" id="Username">
                            <label for="email">用户名</label>
                        </div>
                        <div class="input">
                            <input :class="{hasValue : registerForm.Password}" v-model="registerForm.Password" type="text" name="Password" id="Password">
                            <label for="email">密码</label>
                        </div>
                        <div class="input">
                            <input :class="{hasValue : registerForm.repeat}" v-model="registerForm.repeat" type="text" name="Passwordrepeat" id="Passwordrepeat">
                            <label for="email">重复密码</label>
                        </div>
                    </template>
                    <!-- 如果按钮选择的是登录就展示这个里面的内容 -->                
                    <template v-if="active === 'login'">
                        <div class="input">
                            <input :class="{hasValue : loginForm.Username}" v-model="loginForm.Username" type="text" name="Username" id="Username">
                            <label for="email">用户名</label>
                        </div>
                        <div class="input">
                            <input :class="{hasValue : loginForm.Password}" v-model="loginForm.Password" type="text" name="Password" id="Password">
                            <label for="email">密码</label>
                        </div>
                    </template>
                    <span>忘记密码?</span>
                    <button type="submit" @click="submit">登录</button>
                </div>
            </div>
        </div>
    </div>

</template>


<script>
    var vue = new Vue({
        el: '#app',
        data: {
            active :'login',
            registerForm:{
                email : '',
                Username : '',
                Password : '',
                repeat : ''
            },
            loginForm :{
                Username : '',
                Password : ''
            }
        },
        methods: {
            go(type){
                this.active = type;
            },
            submit(){
                if(type === 'login'){
                    console.log('login',this.loginForm)
                }
                if(type === 'register'){
                    console.log('register',this.registerForm)
                }
            }
        }
    })
</script>

<style scoped>
@font-face{
    font-family: miaowu;
    src: url(./方正-喵呜.TTF);
}

*{
    margin: 0;
    padding: 0;
}

body{
    /* 100%的窗口高度 */
    height: 100vh;
    /* 弹性布局 水平 + 垂直居中 */
    display: flex;
    justify-content: center;
    align-items: center;
    /* 引入字体 */
    font-family: miaowu;
    /* 渐变背景 */
    background: linear-gradient(45deg,rgb(181,154,254),rgb(245,189,253)) fixed;
}

.container{
    /* 相对定位 */
    position: relative;
    width: 70rem;
}

.container img{
    width: 70rem;
}

.switch span{
    color: #ccc;
    font-size: 1.4rem;
    /* 鼠标放上变小手 */
    cursor: pointer;
}
.switch span.active{
    color: rgb(181,154,254);
}

.panel{
    width: 30%;
    margin: 10rem 0 0;
    position: absolute;
    right: 0;
    top: 0;
    display: flex;
    justify-content: center;
}

.form{
    width: 12rem;
    margin: 3rem 0 0;
}

.form .input{
    position: relative;
    opacity: 1;
    height: 2rem;
    width: 100%;
    margin: 2rem 0;
    transition: 0.4s;
}

.form input{
    outline: none;
    width: 100%;
    border: none;
    border-bottom: .1rem solid rgb(181,154,254);
    position: relative;
    line-height: 35px;
    background-color: transparent;
    z-index: 1;
}

.form label{
    position: absolute;
    left: 0;
    top: 20%;
    font-size: 1.2rem;
    color: rgb(129,101,207);
    transition: 0.3s;
}

.hasValue ~ label,input:focus ~ label{
    top: -50%;
    font-size: 0.9rem;
}

.form span{
    display: block;
    color: rgb(110,89,167);
    font-size: 0.8rem;
    cursor: pointer;
}

.form button{
    border: none;
    outline: none;
    margin: 2.5rem 0 0;
    width: 100%;
    height: 3rem;
    border-radius: 3rem;
    background:linear-gradient(45deg,rgb(181,154,254),rgb(245,189,253)) ;
    box-shadow: 0 0 8px rgb(181,154,254);
    cursor: pointer;
    color: white;
    font-family: miaowu;
}

#live2dcanvas{
    border: 0 !important;
} 
</style>


