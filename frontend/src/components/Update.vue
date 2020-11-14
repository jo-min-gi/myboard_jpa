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
                <textarea class="form-control" rows="5" v-model="post.content" placeholder="내용을 입력해 주세요" ></textarea>
            </div>
			<div >
				<button type="button" class="btn btn-primary" @click="modifyPost">수정</button>
                <router-link class="btn btn-primary" to="/board">목록</router-link>
			</div>
		</div>
</template>

<script>
import axios from 'axios'
export default {
   	name : 'Read',
	methods : {
	   modifyPost(){
           axios
                .put(`http://localhost:8080/myboard/api/board/`, this.post)
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