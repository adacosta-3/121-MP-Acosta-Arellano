import React, { useEffect, useState } from 'react';
import { getMusicByUser } from '../api/api'; // Adjust the import path as necessary

const MusicList = ({ userId }) => {
    const [musicList, setMusicList] = useState([]);

    useEffect(() => {
        const fetchMusic = async () => {
            try {
                const data = await getMusicByUser(userId);
                setMusicList(data);
                console.log('Music fetched for userId:', userId, data);
            } catch (error) {
                console.error('Error fetching music:', error);
            }
        };
        fetchMusic();
    }, [userId]);

    return (
        <div>
            <h2>User {userId}'s Music</h2>
            <ul>
                {musicList.map((music) => (
                    <li key={music.id}>
                        <h3>Song: {music.song}</h3>
                        <p>Artist: {music.artist}</p>
                        <p>Album: {music.album}</p>
                        {music.aaLink && (
                            <p>
                                YouTube Link: <a href={music.aaLink} target="_blank" rel="noopener noreferrer">{music.aaLink}</a>
                            </p>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MusicList;
