import React, { useEffect, useState } from 'react';
import { getHobbiesByUser } from '../api/api';
import YoutubeEmbed from "./YoutubeEmbed.jsx";
import './styling/HobbiesList.css';

const HobbiesList = ({ userId, nickname }) => {
    const [hobbies, setHobbies] = useState([]);

    useEffect(() => {
        const fetchHobbies = async () => {
            try {
                const data = await getHobbiesByUser(userId);
                setHobbies(data);
                console.log('Hobbies fetched for userId:', userId, data);
            } catch (error) {
                console.error('Error fetching hobbies:', error);
            }
        };
        fetchHobbies();
    }, [userId]);

    // Extract embed ID for YouTube video embedding
    const extractEmbedId = (url) => {
        const regex = /(?:https?:\/\/)?(?:www\.)?(?:youtube\.com\/(?:[^\/\n\s]+\/\S+\/|(?:v|e(?:mbed)?)\/|\S*?[?&]v=)|youtu\.be\/)([a-zA-Z0-9_-]{11})/;
        const match = url.match(regex);
        return match ? match[1] : null;
    };

    return (
        <div>
            <div className="hobbies-heading-container">
                <h2 className="hobbies-heading">{nickname}'s Hobbies</h2>
            </div>
            <div className="hobbies-container">
                <ul className="hobbies-list">
                    {hobbies.map((hobby) => (
                        <li key={hobby.id} className="hobby-item">
                            <div className="hobby-content">
                                {hobby.mediaLink && (
                                    <div className="video-embed">
                                        <YoutubeEmbed embedId={extractEmbedId(hobby.mediaLink)} />
                                    </div>
                                )}
                                <div className="hobby-details">
                                    <h3 className="hobby-name">{hobby.title}</h3>
                                    <p className="hobby-description">Description: {hobby.description}</p>
                                    {/* Remove the media link paragraph */}
                                </div>
                            </div>
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default HobbiesList;
