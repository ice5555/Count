import Vue from "vue"
import Router from "vue-router"
import Cookie from "js-cookie"

Vue.use(Router)


let router = new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import( "@/view/home")
    },
    {
      path: "/login",
      name: "home",
      component: () => import( "@/view/login")
    },

  ]
})



router.beforeEach((to, from, next) => {
  if (!Cookie.get("token")) {
    if (to.path == "/login")
      next()
    else
      next("/login")
  } else {
    switch (to.path) {
      case "/":
        next()
        break
      default:
        next("/")
        break
    }
  }

})

export default router
