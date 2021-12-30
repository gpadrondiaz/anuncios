import React, { useState } from 'react'
import AuthenticationService from '../service/AuthenticationService';
import { useNavigate } from "react-router-dom";
import {
    Box,
    Button,
    TextField
  } from "@material-ui/core";
import '../App.css';

function Login() {
    const [loginFailed, setLoginFailed] = useState(false);
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const login = () => {
        AuthenticationService
            .executeBasicAuthenticationService(username, password)
            .then(() => {
                AuthenticationService.registerSuccessfulLogin(username, password);
                navigate('/home');
            }).catch(() => {
                setLoginFailed(true);
            })
    }

    
        return (
            <div className="app-login">
                <h3>Login</h3>
                    <TextField type="text" variant="standard"  value={username} onChange={(event) => setUsername(event.target.value)} label="User name"/>
                    <TextField type="password" variant="standard"  value={password} onChange={(event) => setPassword(event.target.value)} label="Password" />
                    <Box sx={{
                        display: 'flex',
                        justifyContent: 'flex-end',
                        p: 1,
                        m: 1,
                        }}>
                        <Button sx={{ m: 30 }} onClick={login} variant="contained">Login</Button>
                    </Box>
                    {loginFailed && <div className="alert">Invalid Credentials</div>}
            </div>
        )
    
}

export default Login;
