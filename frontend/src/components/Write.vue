<template>
    <div class="container" role="main">
			<h2>WRITE</h2>
            <div class="mb-3">
                <label>제목</label>
                <input type="text" class="form-control" v-model="title" placeholder="제목을 입력해 주세요">
            </div>
            <div class="mb-3">
                <label>작성자</label>
                <input type="text" class="form-control" v-model="writer" placeholder="이름을 입력해 주세요">
            </div>
            <div class="mb-3">
                <label>내용</label>
                <textarea class="form-control" rows="5" v-model="content" placeholder="내용을 입력해 주세요" ></textarea>
            </div>
			<div >
				<button type="button" class="btn btn-primary" @click="writePost">작성</button>
                <router-link class="btn btn-primary" to="/board">목록</router-link>
			</div>
		</div>
</template>

<script>
import axios from 'axios';
export default {
    name : 'Write',
    data () {
        return {
            title : '',
            writer : '',
            content : '',
        }
    },
    methods : {
        writePost(){
            const post = {
                title : this.title,
                writer : this.writer,
                content : this.content
            };
            console.log(post);
            axios
                .post('http://localhost:8080/myboard/api/board',
                        post,
                        { headers: { 'Access-Control-Allow-Origin': '*' } }
                        )
                .then((response) => {
                    console.log(response);
                    this.$router.push('/board');
                })
                .catch((error) => {
                    console.log(error);
                })
        }
    }
}
</script>