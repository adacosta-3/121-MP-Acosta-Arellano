import React, { useState } from 'react';
import UserSwitcher from '../components/UserSwitcher';
import MusicList from '../components/MusicList';
import './Pages.css';

const MusicPage = () => {
    const [selectedUserId, setSelectedUserId] = useState(1);

    console.log('MusicPage rendered');

    return (
        <div>
            <h1>Music Page</h1>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <MusicList userId={selectedUserId} />
        </div>
    );
};

export default MusicPage;
