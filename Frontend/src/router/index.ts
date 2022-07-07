import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import ErrorView from "../views/ErrorView.vue";

import DailyPage from "../components/cs/DailyPage.vue";
import StudyPage from "../components/cs/StudyPage.vue";
import TestPage from "../components/cs/TestPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
      children: [
        {path: "", component:DailyPage, meta:{loginRequired: false}},
        {path: "daily", component:DailyPage , meta:{loginRequired: false}},
        {path: "study", component:StudyPage , meta:{loginRequired: false}},
        {path: "test", component:TestPage , meta:{loginRequired: false}},
        // {path: "board", component: , meta:{loginRequired: true}},
      ]
    },
    {
      path: '/:pathMatch(.*)*',
      redirect: "/404"
    },
    {
        path: '/404',
        name: 'Error',
        component: ErrorView,  
    }
  ],
});

// const isLoggedIn = function(){
//   let settings = JSON.parse(localStorage.getItem("settings"))
//   if(settings.userData.token!='' && settings.userData.url!='' && settings.userData.userEmail!='' && settings.userData.userId!='' && settings.userData.userName!=''){
//       return true
//   }
//   return false
// }

// router.beforeEach((to, from, next) => {
//   if(to.meta.loginRequired){
//       if(isLoggedIn()){
//           next()
//       }else{
//           alert('Login Needed!')
//           next("/")
//       }
//   }else{
//       next()
//   }
// })


export default router;
