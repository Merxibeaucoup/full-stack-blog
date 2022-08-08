import HomeRoundedIcon from '@mui/icons-material/HomeRounded';
import AccountBoxRoundedIcon from '@mui/icons-material/AccountBoxRounded';
import TerminalIcon from '@mui/icons-material/Terminal';
import PsychologyIcon from '@mui/icons-material/Psychology';
import React from 'react'
import styled from "styled-components"
import { Link } from 'react-router-dom';




const Navbar = () => {

   


const Container = styled.div`
    display: flex;
    width: 25%;
    margin-left: auto;
  margin-right: auto;
  margin-bottom: 30px;
  
`
// Home

const IconLogo = styled.span`
    flex:1;
    margin:0;
`

const IconTitle = styled.h3`
    flex:1; 
    margin:0;
    
`

const IconContainer = styled.div`
    flex:1;
    cursor:pointer;
    align-items: center;
    text-align:center;
    &:hover {
    ${IconTitle}{color: lightblue;}
  }
  &.active{
    color:red;
  }
  
`





  return (
    
   <Container>
    <IconContainer>
        <Link to="/" style={{ textDecoration: 'none' }}>
        <IconLogo> <HomeRoundedIcon/> </IconLogo>
        <IconTitle>Home</IconTitle>
        </Link>
    </IconContainer>
    <IconContainer>
        <Link to="/about" style={{ textDecoration: 'none' }}>
        <IconLogo><AccountBoxRoundedIcon/></IconLogo>
        <IconTitle>About</IconTitle>
        </Link>
    </IconContainer>
    <IconContainer>
    <Link to="/projects" style={{ textDecoration: 'none' }}>
        <IconLogo><TerminalIcon/></IconLogo>
        <IconTitle>Projects</IconTitle>
        </Link>
    </IconContainer>
    <IconContainer>
       <Link to="/questions" style={{ textDecoration: 'none' }}>
        <IconLogo><PsychologyIcon/></IconLogo>
        <IconTitle>Problems</IconTitle>
        </Link>
    </IconContainer>
   </Container>
  )
}

export default Navbar