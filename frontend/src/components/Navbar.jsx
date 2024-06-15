import React from 'react';
import { NavLink } from 'react-router-dom';
import './styling/Navbar.css';
import logo from '../assets/Icons/logo-icon.png';

const Navbar = () => {
    return (
        <nav className='sidebar'>
            <div className='logo-container'>
                <NavLink to="/" exact className='logo-link'>
                    <img src={logo} alt="Logo" className='logo' />
                </NavLink>
            </div>
            <ul>
                <li>
                    <NavLink to="/" exact className='nav-link' activeClassName='active'>
                        <i className="fas fa-home"></i>
                        <span>Home</span>
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/todos" className='nav-link' activeClassName='active'>
                        <i className="fas fa-tasks"></i>
                        <span>To-Dos</span>
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/hobbies" className='nav-link' activeClassName='active'>
                        <i className="fas fa-heart"></i>
                        <span>Hobbies</span>
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/music" className='nav-link' activeClassName='active'>
                        <i className="fas fa-music"></i>
                        <span>Music</span>
                    </NavLink>
                </li>
            </ul>
        </nav>
    );
};

export default Navbar;
