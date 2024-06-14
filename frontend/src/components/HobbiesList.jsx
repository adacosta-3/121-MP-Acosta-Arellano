import React, { useEffect, useState } from 'react';
import { getHobbiesByUser } from '../api/api';
import YoutubeEmbed from "./YoutubeEmbed.jsx";

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
            <h2>{nickname}'s Hobbies</h2>
            <ul>
                {hobbies.map((hobby) => (
                    <li key={hobby.id}>
                        <h3>{hobby.title}</h3>
                        <p>Description: {hobby.description}</p>
                        {hobby.mediaLink && (
                            <p>
                                <p>Media Link: <a href={hobby.mediaLink} target="_blank"
                                                  rel="noopener noreferrer">{hobby.mediaLink}</a></p>
                                <YoutubeEmbed embedId={extractEmbedId(hobby.mediaLink)}/>
                            </p>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default HobbiesList;
