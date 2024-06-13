import React, { useState } from 'react';
import UserSwitcher from '../components/UserSwitcher';
import ToDoList from '../components/ToDoList';

const ToDosPage = () => {
    const [selectedUserId, setSelectedUserId] = useState(1);

    return (
        <div>
            <h1>ToDos Page</h1>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <ToDoList userId={selectedUserId} />
        </div>
    );
};

export default ToDosPage;