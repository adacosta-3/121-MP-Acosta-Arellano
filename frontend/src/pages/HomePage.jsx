import React from 'react';
import '../components/Navbar.jsx';
import './Pages.css';
import './HomePage.css';

const HomePage = () => {
    return (
        <div>
            <h1>Amoeba Sisters</h1>
            <h2 style={{ fontSize: '36px' }}>Welcome to our site!</h2>
            <p>
                This is our final requirement for CMSC 121. It allows us to showcase who we are.
                This is being submitted to Inst. David Pasumbal.
            </p>

            <h2>Meet the Creators</h2>
            <div className="creators-container">
                <div className="creator" style={{ textAlign: 'left' }}>
                    <img src="/arianne-acosta.png" alt="Member 1" className="creator-img" />
                    <h3>Arianne Acosta</h3>
                    <p>I am Arianne Acosta, currently pursuing a Bachelor of Science in Computer Science at the University of the Philippines Manila. I am driven by a passion for learning and an insatiable curiosity that fuels my thirst for knowledge. While I immerse myself in the world of technology and computer science, I strive to balance it with my creative pursuits. I have a deep love for cooking and culinary arts, music, and artistic expression, which allows me to blend my technical skills with creativity and innovation.</p>
                </div>
                <div className="creator" style={{ textAlign: 'right' }}>
                    <p>I'm Joy Arellano, currently pursuing a degree in computer science at the University of the Philippines, Manila. I find great satisfaction in delving into complex problem-solving and mastering coding intricacies. Despite not being a coffee drinker, I enjoy the cozy ambiance of cafes, which sparks inspiration and focus during study sessions. I take pride in always looking put together, as presentation reflects my commitment to professionalism and self-confidence. Additionally, I have a deep affection for our family's dogs—they bring immense joy and comfort into my life.</p>
                    <h3>Joy Arellano</h3>
                    <img src="/joy-arellano.png" alt="Member 2" className="creator-img" />
                </div>
            </div>

            <h2>Likes & Dislikes</h2>
            <div className="likes-dislikes-container">
                <div className="likes-dislikes-column">
                    <h3>Arianne</h3>
                    <p>Likes:</p>
                    <ul className="like-dislike-list">
                        <li><i className="fas fa-thumbs-up" style={{ color: 'green' }}></i> Rainy weather</li>
                        <li><i className="fas fa-thumbs-up" style={{ color: 'green' }}></i> Sleeping in and napping</li>
                        <li><i className="fas fa-thumbs-up" style={{ color: 'green' }}></i> Tea</li>
                    </ul>
                    <p>Dislikes:</p>
                    <ul className="like-dislike-list">
                        <li><i className="fas fa-thumbs-down" style={{ color: 'red' }}></i> Waking up early (before 9am)</li>
                    </ul>
                </div>
                <div className="likes-dislikes-column">
                    <h3>Joy</h3>
                    <p>Likes:</p>
                    <ul className="like-dislike-list">
                        <li><i className="fas fa-thumbs-up" style={{ color: 'green' }}></i> The sound of rain hitting the pavement and tents</li>
                        <li><i className="fas fa-thumbs-up" style={{ color: 'green' }}></i> Reading sci-fi books</li>
                        <li><i className="fas fa-thumbs-up" style={{ color: 'green' }}></i> Sunsets</li>
                    </ul>
                    <p>Dislikes:</p>
                    <ul className="like-dislike-list">
                        <li><i className="fas fa-thumbs-down" style={{ color: 'red' }}></i> Loud noise</li>
                        <li><i className="fas fa-thumbs-down" style={{ color: 'red' }}></i> Slow walkers</li>
                    </ul>
                </div>
            </div>

            <h2>Our Pets</h2>
            <div className="pets-container">
                <div className="pet-item">
                    <img src="/shelly.png" alt="Pet 1" className="pet-img" />
                    <p className="pet-name">Shelly</p>
                </div>
                <div className="pet-item">
                    <img src="/feesh.png" alt="Pet 2" className="pet-img" />
                    <p className="pet-name">Feesh</p>
                </div>
                <div className="pet-item">
                    <img src="/sam.png" alt="Pet 3" className="pet-img" />
                    <p className="pet-name">Sam</p>
                </div>
                <div className="pet-item">
                    <img src="/shakira.png" alt="Pet 4" className="pet-img" />
                    <p className="pet-name">Shakira</p>
                </div>
            </div>

            <h2>Keep In Touch!</h2>
            <div className="keep-in-touch-container">
                <div className="keep-in-touch-column">
                    <a href="https://www.facebook.com/acostarianne/" target="_blank" rel="noopener noreferrer" className="contact-link">
                        <i className="fab fa-facebook" style={{ fontSize: '2em', color: '#6A5ACD' }}></i>
                        <span className="contact-text">Arianne Acosta</span>
                    </a>
                    <a href="https://www.instagram.com/acostarianne/" target="_blank" rel="noopener noreferrer" className="contact-link">
                        <i className="fab fa-instagram" style={{ fontSize: '2em', color: '#6A5ACD' }}></i>
                        <span className="contact-text">acostarianne</span>
                    </a>
                </div>
                <div className="keep-in-touch-column">
                    <a href="https://www.facebook.com/kristine.arellano.754/" target="_blank" rel="noopener noreferrer" className="contact-link">
                        <i className="fab fa-facebook" style={{ fontSize: '2em', color: '#1E90FF', marginRight: '10px' }}></i>
                        <span className="contact-text">Joy Arellano</span>
                    </a>
                    <a href="https://www.instagram.com/joy__are/" target="_blank" rel="noopener noreferrer" className="contact-link">
                        <i className="fab fa-instagram" style={{ fontSize: '2em', color: '#1E90FF' }}></i>
                        <span className="contact-text">joy__are</span>
                    </a>
                </div>
            </div>
        </div>
    );
};

export default HomePage;
