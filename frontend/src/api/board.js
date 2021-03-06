import { createInstance } from "./index.js";

const instance = createInstance();

function findAll(succcess, fail){
    instance
        .get('/api/board')
        .then(succcess)
        .catch(fail)   
}

function findByBid(bid, success, fail){
    instance
        .get(`/api/board/${bid}`)
        .then(success)
        .catch(fail)
}

function update(post, success, fail){
    instance
        .put(`/api/board`, post)
        .then(success)
        .catch(fail)
}

function deleteByBid(bid, success, fail){
    instance
        .delete(`/api/board/${bid}`)
        .then(success)
        .catch(fail)
}

function save(post, success, fail){
    instance
        .post(`/api/board`, post)
        .then(success)
        .catch(fail)
}

export { findAll, findByBid, update, deleteByBid, save, }