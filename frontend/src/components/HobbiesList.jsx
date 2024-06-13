import React, { useState, useEffect } from 'react';
import { getHobbiesByUser } from '../api/api';

const HobbiesList = ({ userId }) => {
    const [hobbies, setHobbies] = useState([]);

    useEffect(() => {
        fetchHobbies();
    }, []);

    const fetchHobbies = async () => {
        try {
            const data = await getHobbiesByUser(userId);
            setHobbies(data);
        } catch (error) {
            console.error('Error fetching hobbies:', error);
        }
    };

    return (
        <div>
            <h1>Hobbies List</h1>
            <ul>
                {hobbies.map((hobby) => (
                    <li key={hobby.id}>
                        <span>{hobby.title}</span> - <span>{hobby.description}</span> - <span>{hobby.mediaLink}</span>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default HobbiesList;
