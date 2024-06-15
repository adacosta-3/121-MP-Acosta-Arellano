import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api/v1',
});

export const getUserDetails = async (userId) => {
    const response = await api.get(`/users/user/${userId}`);
    return response.data;
};

// Music APIs
export const getMusicByUser = async (userId) => {
    const response = await api.get(`/music/user/${userId}`);
    return response.data;
};

// ToDo APIs

export const getToDos = async () => {
    const response = await api.get('/todos');
    return response.data;
};

export const getToDosByUser = async (userId) => {
    const response = await api.get(`/todos/user/${userId}`);
    return response.data;
};

export const getCompletedToDosByUser = async (userId) => {
    const response = await api.get(`/todos/user/${userId}/completed`);
    return response.data;
};

export const getUnfinishedToDosByUser = async (userId) => {
    const response = await api.get(`/todos/user/${userId}/unfinished`);
    return response.data;
};

export const addToDo = async (todo) => {
    const response = await api.post('/todos', todo);
    return response.data;
};

export const updateCompletion = async (todoId, completed) => {
    const response = await api.put(`/todos/completion/${todoId}`, null, {
        params: { completed },
    });
    return response.data;
};

export const deleteToDo = async (todoId) => {
    const response = await api.delete(`/todos/${todoId}`);
    return response.data;
};

// Hobbies APIs
export const getHobbiesByUser = async (userId) => {
    const response = await api.get(`/hobbies/user/${userId}`);
    return response.data;
};

export const getUnfinishedToDosByUserAndLabel = async (userId, label) => {
    const encodedLabel = encodeURIComponent(label);
    const response = await api.get(`/todos/user/${userId}/label/${encodedLabel}/unfinished`);
    return response.data;
};

export const getCompletedToDosByUserAndLabel = async (userId, label) => {
    const encodedLabel = encodeURIComponent(label);
    const response = await api.get(`/todos/user/${userId}/label/${encodedLabel}/completed`);
    return response.data;
};
