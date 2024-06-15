import React from 'react';

const SpotifyEmbed = ({ link }) => {
    const embedUrl = link.replace('https://open.spotify.com', 'https://embed.spotify.com');
    return (
        <iframe
            src={embedUrl}
            style={{ marginTop: '12px' }}
            width="470"
            height="80"
            frameBorder="0"
            allowtransparency="true"
            allow="encrypted-media"
        ></iframe>
    );
};

export default SpotifyEmbed;