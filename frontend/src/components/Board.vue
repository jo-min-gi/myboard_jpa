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
                <td><a href="#" @click="read(post.bid)">{{post.title}}</a></td>
                <td>{{post.createdAt}}</td>
            </tr>
        </table>

        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-center">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li v-for="page in endPage - startPage + 1" v-bind:key="page" class="page-item">
              <a class="page-link" href="#" @click="pagenate((startPage + page - 1), size)">{{startPage + page - 1}}</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next" @click="test()"> 
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>

        <router-link class="btn btn-primary" to="/write">글쓰기</router-link>
    </div>
</template>

<script>
import { findAll } from "../api/board.js";

export default {
  name: 'Board',
  data () {
    return {
      startPage : 1,
      endPage : 10,
      page : "",
      size : 10,
      paging : {},
      posts : []
    }
  },
  created(){
    // this.page = this.$route.query.page;
    // this.size = this.$route.query.size;
    this.pagenate(this.page, this.size);
  },
  methods : {
    pagenate(page, size){
      console.log(page)
      findAll(page, size,
        response => {
          var paging = response.data.data;
          this.paging = paging;
          this.posts = paging.content;

          // this.startPage = response.data.startPage;
          // this.endPage = response.data.endPage;
          console.log(paging);
        },
        error => {
          console.log(error);
        })
    },
    read(bid) {
      this.$router.push({name : 'Read', params : { 'bid' : bid }})
    },
    test(){
      console.log(this.startPage)
      console.log(this.endPage)
      this.startPage = this.endPage + 1;
      this.endPage = this.startPage + this.size; 
      console.log(this.startPage)
      console.log(this.endPage)
      
    }
  }
}
</script>