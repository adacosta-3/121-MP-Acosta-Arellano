import React, { useState, useEffect } from 'react';
import UserSwitcher from '../components/UserSwitcher';
import HobbiesList from '../components/HobbiesList';

const HobbiesPage = () => {
    const [selectedUserId, setSelectedUserId] = useState(1);

    console.log('HobbiesPage rendered with userId:', selectedUserId);

    return (
        <div>
            <h1>Hobbies Page</h1>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <HobbiesList userId={selectedUserId} />
        </div>
    );
};

export default HobbiesPage;
