import React, { useState, useEffect } from 'react';
import {
    getUnfinishedToDosByUser,
    getCompletedToDosByUser,
    addToDo,
    deleteToDo,
    updateCompletion,
    getUnfinishedToDosByUserAndLabel,
    getCompletedToDosByUserAndLabel
} from '../api/api';
import ToDoItem from './ToDoItem';
import './styling/ToDoList.css';

const ToDoList = ({ userId , nickname}) => {
    const [tasks, setTasks] = useState([]);
    const [completedTasks, setCompletedTasks] = useState([]);
    const [taskText, setTaskText] = useState('');
    const [taskDescription, setTaskDescription] = useState('');
    const [taskLabel, setTaskLabel] = useState('');
    const [selectedLabel, setSelectedLabel] = useState('All');
    const [labels, setLabels] = useState([]);

    useEffect(() => {
        fetchTodos();
        fetchLabels();
    }, [userId, selectedLabel]);

    const fetchTodos = async () => {
        try {
            if (selectedLabel === 'All') {
                const unfinished = await getUnfinishedToDosByUser(userId);
                const completed = await getCompletedToDosByUser(userId);
                setTasks(unfinished);
                setCompletedTasks(completed);
            } else {
                const unfinished = await getUnfinishedToDosByUserAndLabel(userId, selectedLabel);
                const completed = await getCompletedToDosByUserAndLabel(userId, selectedLabel);
                setTasks(unfinished);
                setCompletedTasks(completed);
            }
        } catch (error) {
            console.error('Error fetching todos:', error);
        }
    };

    const fetchLabels = async () => {
        try {
            const unfinished = await getUnfinishedToDosByUser(userId);
            const completed = await getCompletedToDosByUser(userId);
            const allTasks = [...unfinished, ...completed];
            const uniqueLabels = [...new Set(allTasks.map(task => task.label))];
            setLabels(uniqueLabels);
        } catch (error) {
            console.error('Error fetching labels:', error);
        }
    };

    const handleAddTask = async () => {
        try {
            await addToDo({
                user: { id: userId },
                task: taskText,
                description: taskDescription,
                label: taskLabel,
                completed: false
            });
            fetchTodos();
            fetchLabels();
            setTaskText('');
            setTaskDescription('');
            setTaskLabel('');
        } catch (error) {
            console.error('Error adding todo:', error);
        }
    };

    const handleDeleteTask = async (id) => {
        try {
            await deleteToDo(id);
            fetchTodos();
            fetchLabels();
        } catch (error) {
            console.error('Error deleting todo:', error);
        }
    };

    const handleToggleCompleted = async (id, completed) => {
        try {
            await updateCompletion(id, completed);
            fetchTodos();
            fetchLabels();
        } catch (error) {
            console.error('Error updating todo:', error);
        }
    };

    return (
        <div>
            <h2>{nickname}'s To-Do List</h2>
            <div className="add-task">
                <input
                    value={taskText}
                    onChange={(e) => setTaskText(e.target.value)}
                    placeholder="Task"
                />
                <input
                    value={taskDescription}
                    onChange={(e) => setTaskDescription(e.target.value)}
                    placeholder="Description"
                />
                <input
                    value={taskLabel}
                    onChange={(e) => setTaskLabel(e.target.value)}
                    placeholder="Label"
                />
                <button onClick={handleAddTask}><i className="fas fa-plus"></i></button>
            </div>
            <div className="todo-list">
                <div className="todo-section">
                    <h3>To-Do List</h3>
                    <select value={selectedLabel} onChange={(e) => setSelectedLabel(e.target.value)}>
                        <option value="All">All</option>
                        {labels.map((label, index) => (
                            <option key={index} value={label}>{label}</option>
                        ))}
                    </select>
                    {tasks.map(task => (
                        <ToDoItem
                            key={task.id}
                            task={task}
                            deleteTask={handleDeleteTask}
                            toggleCompleted={handleToggleCompleted}
                        />
                    ))}
                </div>
                <div className="completed-section">
                    <h3>Completed Tasks</h3>
                    {completedTasks.map(task => (
                        <ToDoItem
                            key={task.id}
                            task={task}
                            deleteTask={handleDeleteTask}
                            toggleCompleted={handleToggleCompleted}
                        />
                    ))}
                </div>
            </div>
        </div>
    );
};

export default ToDoList;
