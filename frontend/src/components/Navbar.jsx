import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
    return (
        <nav>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/todos">To-Dos</Link></li>
                <li><Link to="/hobbies">Hobbies</Link></li>
                <li><Link to="/music">Music</Link></li>
            </ul>
        </nav>
    );
};

export default Navbar;