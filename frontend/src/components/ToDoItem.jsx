import React from 'react';
import './styling/ToDoItem.css';

const ToDoItem = ({ task, deleteTask, toggleCompleted }) => {
    return (
        <div className="todo-item">
            <input
                type="checkbox"
                checked={task.completed}
                onChange={() => toggleCompleted(task.id, !task.completed)}
                className="task-checkbox"
            />
            <div className="task-details">
                <div className="task">{task.task}</div>
                <div>{task.description}</div>
                <div className="label">{task.label}</div>
            </div>
            <button className="delete-task" onClick={() => deleteTask(task.id)}>
                <i className="fas fa-trash"></i>
            </button>
        </div>
    );
};

export default ToDoItem;
