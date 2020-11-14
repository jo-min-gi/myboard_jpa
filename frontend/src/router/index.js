import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Board from '@/components/Board.vue';
import Write from '@/components/Write.vue';
import Read from '@/components/Read.vue';
import Update from '@/components/Update.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },
  {
    path : '/board',
    name : 'Board',
    component : Board
  },
  {
    path : '/write',
    name : 'Write',
    component : Write
  },
  {
    path : '/read',
    name : 'Read',
    component : Read
  },
  {
    path : '/update',
    name : 'Update',
    component : Update
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
