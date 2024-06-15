import React, {useEffect, useState} from 'react';
import UserSwitcher from '../components/UserSwitcher';
import ToDoList from '../components/ToDoList';
import {getUserDetails} from "../api/api.js";
import './styling/Pages.css';

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
            <h1>Amoeba Sisters</h1>
            <h2 style={{ fontSize: '36px' }}>To-Dos Page</h2>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <ToDoList userId={selectedUserId} nickname={nickname} />
        </div>
    );
};

export default ToDosPage;