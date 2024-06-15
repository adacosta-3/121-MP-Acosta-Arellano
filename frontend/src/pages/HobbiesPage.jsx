import React, { useState, useEffect } from 'react';
import UserSwitcher from '../components/UserSwitcher';
import HobbiesList from '../components/HobbiesList';
import { getUserDetails } from '../api/api';
import "./YT.css";
import YoutubeEmbed from "../components/YoutubeEmbed";
import './Pages.css';

const HobbiesPage = () => {
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

    console.log('HobbiesPage rendered with userId:', selectedUserId);

    return (
        <div>
            <h1>Amoeba Sisters</h1>
            <h2 style={{ fontSize: '36px' }}>Hobbies Page</h2>
            <UserSwitcher selectedUserId={selectedUserId} setSelectedUserId={setSelectedUserId} />
            <HobbiesList userId={selectedUserId} nickname={nickname} />
        </div>
    );
};

export default HobbiesPage;
