<template>
    <div class="container" role="main">
			<h2>READ</h2>
			<div class="mb-3">
				<label>제목</label>
				<input type="text" class="form-control" v-model="post.title" readonly>
			</div>
			<div class="mb-3">
				<label>작성자</label>
				<input type="text" class="form-control" v-model="post.writer" readonly>
			</div>
			<div class="mb-3">
				<label>내용</label>
				<textarea class="form-control" rows="5" v-model="post.content" readonly></textarea>
			</div>
			<div >
                <router-link class="btn btn-primary" to="/board">목록</router-link>
				<button class="btn btn-primary" @click="modifyPost(post.id)">수정</button>
				<button class="btn btn-primary" @click="deletePost(post.id)">삭제</button>
			</div>
		</div>
</template>

<script>
import axios from 'axios'
export default {
   	name : 'Read',
	methods : {
	   modifyPost(id){
		   this.$router.push('/update?id='+ id);
	   },
	   deletePost(id){
		   console.log(id);
		   axios
				.delete(`http://localhost:8080/myboard/api/board/${id}`)
				.then((response)=>{
					console.log(response);
					this.$router.push('/board');
				})
				.catch((error)=>{
					console.log(error);
				})
	   }
  	},
   data () {
	   return{
		   post : {}
	   }
   },
   created() {
	   const params = new URL(document.location).searchParams;
	   axios
			.get(`http://localhost:8080/myboard/api/board/${params.get('id')}`)
			.then((response)=>{
				console.log(response);
				this.post = response.data;
			})
			.catch((error)=>{
				console.log(error);
			})
   },

}
</script>