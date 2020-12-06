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
				<textarea class="form-control" rows="5" v-model="post.contents" readonly></textarea>
			</div>
			<div >
                <router-link class="btn btn-primary" to="/board">목록</router-link>
				<button class="btn btn-primary" @click="modifyPost(post.bid)">수정</button>
				<button class="btn btn-primary" @click="deletePost(post.bid)">삭제</button>
			</div>
		</div>
</template>

<script>
import { findByBid, deleteByBid } from "../api/board.js";

export default {
   	name : 'Read',
	data () {
		return{
			post : {}
		}
	},
	created() {
		const bid = this.$route.params.bid;
		findByBid(
			bid,
			response => { this.post = response.data; },
			error => { console.log(error); }
		)
	},
   	methods : {
	   modifyPost(bid){
		   this.$router.push({ name : 'Update', params : { 'bid': bid } });
	   },
	   deletePost(bid){
		   	deleteByBid(
				bid, 
				() => { this.$router.push('/board'); },
				error => { console.log(error); }
			)
	   }
  	},

}
</script>