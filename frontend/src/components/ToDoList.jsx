import React, { useState, useEffect } from 'react';
import { getToDosByUser, addToDo, updateToDo, deleteToDo } from '../api/api';

const ToDoList = ({ userId }) => {
    const [todos, setTodos] = useState([]);
    const [newTask, setNewTask] = useState('');
    const [newDescription, setNewDescription] = useState('');
    const [newLabel, setNewLabel] = useState('');

    useEffect(() => {
        fetchToDos();
    }, []);

    const fetchToDos = async () => {
        try {
            const data = await getToDosByUser(userId);
            setTodos(data);
        } catch (error) {
            console.error('Error fetching todos:', error);
        }
    };

    const handleAddToDo = async () => {
        if (!newTask) return;

        const newToDo = {
            task: newTask,
            description: newDescription,
            label: newLabel,
            user: { id: userId },
        };

        try {
            await addToDo(newToDo);
            fetchToDos();
            setNewTask('');
            setNewDescription('');
            setNewLabel('');
        } catch (error) {
            console.error('Error adding todo:', error);
        }
    };

    const handleUpdateToDo = async (todoId, task, description, label) => {
        try {
            await updateToDo(todoId, task, description, label);
            fetchToDos();
        } catch (error) {
            console.error('Error updating todo:', error);
        }
    };

    const handleDeleteToDo = async (todoId) => {
        try {
            await deleteToDo(todoId);
            fetchToDos();
        } catch (error) {
            console.error('Error deleting todo:', error);
        }
    };

    return (
        <div>
            <h1>ToDo List</h1>
            <div>
                <input
                    type="text"
                    placeholder="New task"
                    value={newTask}
                    onChange={(e) => setNewTask(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Description"
                    value={newDescription}
                    onChange={(e) => setNewDescription(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Label"
                    value={newLabel}
                    onChange={(e) => setNewLabel(e.target.value)}
                />
                <button onClick={handleAddToDo}>Add ToDo</button>
            </div>
            <ul>
                {todos.map((todo) => (
                    <li key={todo.id}>
                        <span>{todo.task}</span>
                        <span>{todo.description}</span>
                        <span>{todo.label}</span>
                        <button onClick={() => handleUpdateToDo(todo.id, todo.task, todo.description, todo.label)}>Update</button>
                        <button onClick={() => handleDeleteToDo(todo.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ToDoList;
