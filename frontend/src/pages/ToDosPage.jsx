import React, { useState } from 'react';
import UserSwitcher from '../components/UserSwitcher';
import ToDoList from '../components/ToDoList';
import './Page.css';

const ToDosPage = () => {
    const [selectedUserId, setSelectedUserId] = useState(1);

    return (
        <div>
            <h1>To-Dos Page</h1>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <ToDoList userId={selectedUserId} />
        </div>
    );
};

export default ToDosPage;