import React from 'react';

const UserSwitcher = ({ selectedUserId, setSelectedUserId }) => {
    const toggleUser = () => {
        setSelectedUserId((prevUserId) => (prevUserId === 1 ? 2 : 1));
    };

    return (
        <button onClick={toggleUser}>
            Switch to User {selectedUserId === 1 ? 2 : 1}
        </button>
    );
};

export default UserSwitcher;
