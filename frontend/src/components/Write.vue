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
                <textarea class="form-control" rows="5" v-model="contents" placeholder="내용을 입력해 주세요" ></textarea>
            </div>
			<div >
				<button type="button" class="btn btn-primary" @click="writePost">작성</button>
                <router-link class="btn btn-primary" to="/board">목록</router-link>
			</div>
		</div>
</template>

<script>
import axios from 'axios';
import { API_BASE_URL } from "@/config";

export default {
    name : 'Write',
    data () {
        return {
            title : '',
            writer : '',
            contents : '',
        }
    },
    methods : {
        writePost(){
            const post = {
                title : this.title,
                writer : this.writer,
                contents : this.contents
            };
            console.log(post);
            axios
                .post(`${API_BASE_URL}/myboard/api/board`, post)
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