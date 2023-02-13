webpackJsonp([1],{"9O00":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s={data:function(){var e=this;return{userDto:{username:"",password:"",passwordConfirmation:"",email:""},code:"",src:"",key:"",rules:{password:[{validator:function(t,a,s){""===a?s(new Error("请输入密码")):(""!==e.userDto.passwordConfirmation&&e.$refs.userDto.validateField("passwordConfirmation"),s())},trigger:"blur"}],passwordConfirmation:[{validator:function(t,a,s){""===a?s(new Error("请再次输入密码")):a!==e.userDto.password?s(new Error("两次输入密码不一致!")):s()},trigger:"blur"}]}}},methods:{handleRegister:function(){var e=this;this.code&&this.key?this.$axiosJava.post("/user/register?code="+this.code+"&key="+this.key,{username:this.userDto.username,password:this.userDto.password,email:this.userDto.email}).then(function(t){console.log(t.data),t.data.states?(alert(t.data.mag+"点击确定跳转到登录页面！！"),e.$router.push({path:"/"})):alert(t.data.mag)}):console.log("code 和 key 不能为空")},getImage:function(){var e=this;this.$axiosJava.get("/user/getImage").then(function(t){console.log(t.data),e.src="data:image/png;base64,"+t.data.image,e.key=t.data.key})},created:function(){this.getImage()},login:function(){this.$router.push({path:"/login"})}},mounted:function(){this.getImage()}},r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"register"},[a("div",{staticClass:"register-box"},[a("div",{staticClass:"background"}),e._v(" "),a("div",{staticClass:"register_box-right"},[a("el-form",{ref:"userDto",staticClass:"login-form",attrs:{model:e.userDto,"status-icon":"",rules:e.rules}},[a("div",{staticClass:"title-container"},[a("h3",{staticClass:"title"},[e._v("Register")])]),e._v(" "),a("div",[a("el-form-item",{staticClass:"label",attrs:{label:"用户名",prop:"username"}},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.userDto.username,expression:"userDto.username"}],ref:"username",staticClass:"input",attrs:{"auto-complete":"on",name:"username",placeholder:"请输入用户名",tabindex:"1",type:"text"},domProps:{value:e.userDto.username},on:{input:function(t){t.target.composing||e.$set(e.userDto,"username",t.target.value)}}})])],1),e._v(" "),a("el-form-item",{staticClass:"label",attrs:{label:"密码",prop:"password"}},[a("div",{staticClass:"password"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.userDto.password,expression:"userDto.password"}],ref:"password",staticClass:"input",attrs:{"auto-complete":"off",name:"password",placeholder:"请输入密码",tabindex:"1",type:"password"},domProps:{value:e.userDto.password},on:{input:function(t){t.target.composing||e.$set(e.userDto,"password",t.target.value)}}})])]),e._v(" "),a("el-form-item",{staticClass:"label",attrs:{label:"确认密码",prop:"passwordConfirmation"}},[a("div",{staticClass:"retype"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.userDto.passwordConfirmation,expression:"userDto.passwordConfirmation"}],ref:"passwordConfirmation",staticClass:"input",attrs:{"auto-complete":"off",name:"passwordConfirmation",placeholder:"请再次输入密码",tabindex:"1",type:"password"},domProps:{value:e.userDto.passwordConfirmation},on:{input:function(t){t.target.composing||e.$set(e.userDto,"passwordConfirmation",t.target.value)}}})])]),e._v(" "),a("el-form-item",{staticClass:"label",attrs:{label:"邮箱",prop:"email"}},[a("div",{staticClass:"email"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.userDto.email,expression:"userDto.email"}],ref:"email",staticClass:"input",attrs:{"auto-complete":"off",name:"email",placeholder:"请输入邮箱",tabindex:"1",type:"text"},domProps:{value:e.userDto.email},on:{input:function(t){t.target.composing||e.$set(e.userDto,"email",t.target.value)}}})])]),e._v(" "),a("el-form-item",{staticClass:"label",attrs:{label:"验证码",prop:"img"}},[a("div",[a("input",{directives:[{name:"model",rawName:"v-model",value:e.code,expression:"code"}],ref:"vertifycode",staticClass:"input-vertifycode",attrs:{"auto-complete":"off",name:"vertifycode",placeholder:"请输入验证码",width:"24%",tabindex:"1",type:"text"},domProps:{value:e.code},on:{input:function(t){t.target.composing||(e.code=t.target.value)}}}),e._v(" "),a("img",{key:e.key,staticClass:"img-code",attrs:{src:e.src,id:"img-vcode"},on:{click:e.getImage}})])]),e._v(" "),a("el-form-item",{staticClass:"register-button"},[a("el-button",{attrs:{type:"primary",round:""},nativeOn:{click:function(t){return t.preventDefault(),e.handleRegister.apply(null,arguments)}}},[e._v("注册")])],1),e._v(" "),a("div",{staticClass:"register-text"},[a("span",[e._v("已有账号?")]),e._v(" "),a("el-link",{staticClass:"link",attrs:{type:"info"},nativeOn:{click:function(t){return t.preventDefault(),e.login.apply(null,arguments)}}},[e._v("点此登录")])],1)],1)],1)])])},staticRenderFns:[]};var o=a("VU/8")(s,r,!1,function(e){a("Xgjb")},"data-v-f1e75b64",null);t.default=o.exports},Xgjb:function(e,t){}});
//# sourceMappingURL=1.6102944907e9e1b37faf.js.map