import Vue from "vue";
import VueRouter from "vue-router";
import Board from '@/components/Board.vue';
import Write from '@/components/Write.vue';
import Read from '@/components/Read.vue';
import Update from '@/components/Update.vue';

Vue.use(VueRouter);

const routes = [
  {
    path : '/',
    name : 'Board',
    component : Board
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
    path : '/board/:bid',
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
