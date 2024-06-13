import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import ToDosPage from './pages/ToDosPage';
import HobbiesPage from './pages/HobbiesPage';
import MusicPage from './pages/MusicPage';

const App = () => {
    return (
        <Router>
            <div>
                <Navbar />
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/todos" element={<ToDosPage />} />
                    <Route path="/hobbies" element={<HobbiesPage />} />
                    <Route path="/music" element={<MusicPage />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
