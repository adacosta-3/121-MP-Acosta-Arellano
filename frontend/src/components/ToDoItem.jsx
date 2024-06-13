import React from 'react';

const ToDoItem = ({ task, deleteTask, toggleCompleted }) => {
    const handleChange = () => {
        toggleCompleted(task.id, !task.completed);
    };

    return (
        <div className="todo-item">
            <input
                type="checkbox"
                checked={task.completed}
                onChange={handleChange}
            />
            <p>Task: {task.task}</p>
            <p>Description: {task.description}</p>
            <p>Label: {task.label}</p>
            <button onClick={() => deleteTask(task.id)}>X</button>
        </div>
    );
};

export default ToDoItem;
