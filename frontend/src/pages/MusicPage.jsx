import React, {useEffect, useState} from 'react';
import UserSwitcher from '../components/UserSwitcher';
import MusicList from '../components/MusicList';
import {getUserDetails} from "../api/api.js";

const MusicPage = () => {
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

    console.log('MusicPage rendered with userId:', selectedUserId);

    return (
        <div>
            <h1>Music Page</h1>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <MusicList userId={selectedUserId} nickname={nickname}/>
        </div>
    );
};

export default MusicPage;
