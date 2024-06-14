import React, { useState, useEffect } from 'react';
import { getUserDetails } from '../api/api';

const UserSwitcher = ({ selectedUserId, setSelectedUserId }) => {
    const [nicknames, setNicknames] = useState({ 1: '', 2: '' });

    // Fetching nicknames
    useEffect(() => {
        const fetchNicknames = async () => {
            try {
                const arianne = await getUserDetails(1);
                const joy = await getUserDetails(2);
                setNicknames({ 1: arianne.nickname, 2: joy.nickname });
            } catch (error) {
                console.error('Error fetching user:', error);
            }
        };
        fetchNicknames();
    }, []);

    // Switches between the users, if 1, then 2 and vice versa
    const toggleUser = () => {
        const newUserId = selectedUserId === 1 ? 2 : 1;
        setSelectedUserId(newUserId);
    };

    // Display nickname of other user
    const otherUser = nicknames[selectedUserId === 1 ? 2 : 1];

    return (
        <button onClick={toggleUser}>
            {`Switch to ${otherUser}`}
        </button>
    );
};

export default UserSwitcher;
