import React from 'react';

const currentYear = new Date().getFullYear();

const Footer = () => {
    return (
        <footer style={footerStyle}>
            <p style={textStyle}>© {currentYear} Acosta & Arellano. All rights reserved.</p>
        </footer>
    );
};

const footerStyle = {
    position: 'fixed',
    left: '0',
    bottom: '0',
    width: '100%',
    backgroundColor: '#f1f1f1',
    textAlign: 'center',
    padding: '5px 0',
    borderTop: '1px solid #e4e4e4'
};

const textStyle = {
    margin: '0',
    fontSize: '12px',
    color: '#555'
};

export default Footer;
