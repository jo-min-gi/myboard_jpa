<template>
    <div class="container" role="main">
			<h2>UPDATE</h2>
            <div class="mb-3">
                <label>제목</label>
                <input type="text" class="form-control" v-model="post.title" placeholder="제목을 입력해 주세요">
            </div>
            <div class="mb-3">
                <label>작성자</label>
                <input type="text" class="form-control" v-model="post.writer" readonly>
            </div>
            <div class="mb-3">
                <label>내용</label>
                <textarea class="form-control" rows="5" v-model="post.contents" placeholder="내용을 입력해 주세요" ></textarea>
            </div>
			<div >
				<button type="button" class="btn btn-primary" @click="modifyPost">수정</button>
                <router-link class="btn btn-primary" to="/board">목록</router-link>
			</div>
		</div>
</template>

<script>
import { update, findByBid } from "../api/board.js";

export default {
   	name : 'Read',
	methods : {
	    modifyPost(){
            update(this.post,
                () => { this.$router.push('/board'); },
                error => { console.log(error) }
            )
        },
    },
   data () {
	   return{
		   post : {}
	   }
   },
   created() {
        const bid = this.$route.params.bid;
        findByBid(bid, 
            response => { this.post = response.data },
            error => { console.log(error) }
        )
   },

}
</script>