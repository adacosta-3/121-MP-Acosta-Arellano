import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ToDoList from "./components/ToDoList.jsx";


import React from 'react';
import MusicList from './components/MusicList';
import HobbiesList from "./components/HobbiesList.jsx";

const App = () => {
    return (
        <div>
            {/*<MusicList userId={1} />*/}
            {/*<ToDoList userId={1}/>*/}
            {/*<HobbiesList userId={1} />*/}
        </div>
    );
};

export default App;
