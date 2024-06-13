import React, { useEffect, useState } from 'react';
import { getMusicByUser } from '../api/api'; // Adjust the import path as necessary

const MusicList = ({ userId }) => {
    const [musicList, setMusicList] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchMusic = async () => {
            try {
                setLoading(true);
                const musicData = await getMusicByUser(userId);
                setMusicList(musicData);
            } catch (err) {
                setError(err);
            } finally {
                setLoading(false);
            }
        };

        fetchMusic();
    }, [userId]);

    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error fetching music: {error.message}</div>;

    return (
        <div>
            <h1>Music List for User {userId}</h1>
            <ul>
                {musicList.map((music) => (
                    <li key={music.id}>
                        {music.song} by {music.artist} from the album {music.album}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MusicList;
