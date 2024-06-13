import React, { useEffect, useState } from 'react';
import { getHobbiesByUser } from '../api/api';

const HobbiesList = ({ userId }) => {
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

    return (
        <div>
            <h2>User {userId}'s Hobbies</h2>
            <ul>
                {hobbies.map((hobby) => (
                    <li key={hobby.id}>
                        <h3>{hobby.title}</h3>
                        <p>Description: {hobby.description}</p>
                        {hobby.mediaLink && (
                            <p>
                                Media Link: <a href={hobby.mediaLink} target="_blank" rel="noopener noreferrer">{hobby.mediaLink}</a>
                            </p>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default HobbiesList;
