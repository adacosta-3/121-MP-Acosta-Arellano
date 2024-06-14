import React, {useEffect, useState} from 'react';
import UserSwitcher from '../components/UserSwitcher';
import ToDoList from '../components/ToDoList';
import './Page.css';
import {getUserDetails} from "../api/api.js";

const ToDosPage = () => {
    const [selectedUserId, setSelectedUserId] = useState(1);
    const [nickname, setNickname] = useState('');

    useEffect(() => {
        const fetchNickname = async () => {
            try {
                const userDetails = await getUserDetails(selectedUserId);
                setNickname(userDetails.nickname);
            } catch (error) {
                console.error('Error fetching user details:', error);
            }
        };
        fetchNickname();
    }, [selectedUserId]);

    console.log('ToDosPage rendered with userId:', selectedUserId);

    return (
        <div>
            <h1>To-Dos Page</h1>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <ToDoList userId={selectedUserId} nickname={nickname} />
        </div>
    );
};

export default ToDosPage;