<template>
    <div>
        <h2>게시판</h2>
        <table class="table table-bordered">
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            <tr v-for="(post) in posts" v-bind:key="post.bid">
                <td>{{post.bid}}</td>
                <td>{{post.writer}}</td>
                <td><router-link :to="'/read?bid=' + post.bid">{{post.title}}</router-link></td>
                <td>{{post.createdAt}}</td>
            </tr>
        </table>
        <router-link class="btn btn-primary" to="/write">글쓰기</router-link>
    </div>
</template>

<script>
import { findAll } from "../api/board.js";

export default {
  name: 'Board',
  data () {
    return {
      posts : []
    }
  },
  created(){
    findAll(
      response => {
        this.posts = response.data;
      },
      error => {
        console.log(error);
      }
    )
  
  }
}
</script>