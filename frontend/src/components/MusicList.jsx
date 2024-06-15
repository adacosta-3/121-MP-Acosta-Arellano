import React, { useEffect, useState } from 'react';
import { getMusicByUser } from '../api/api';
import './styling/MusicList.css';
import SpotifyEmbed from './SpotifyEmbed';

const MusicList = ({ userId, nickname }) => {
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
            <div className="music-heading-container">
                <h2 className="music-heading">{nickname}'s Current Top 5 Tracks</h2>
            </div>
            <div className="music-container">
                <ul className="music-list">
                    {musicList.map((music, index) => (
                        <li key={music.id} className="music-item">
                            <span className="music-number">{index + 1}.</span>
                            <img src={music.aaLink} alt="Album Artwork" />
                            <div>
                                <h3>{music.song}</h3>
                                <p>Artist: {music.artist}</p>
                                <p>Album: {music.album}</p>
                                {music.spLink && <SpotifyEmbed className={"spotify-embed-container"} link={music.spLink} />}
                            </div>
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default MusicList;
