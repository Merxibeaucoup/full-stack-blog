import React from 'react'
import styled from "styled-components"

const Header = () => {

    const NavContainer = styled.div`
    background-color:black;
    width:25%;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 5%;
    margin-top: 10%;
   
    
  `
  
        const NavHeader = styled.h1`
          color: white;
          font-size:30px; 
          margin-left: 3%;
          margin-right: auto;
  
        `


  return (
    <NavContainer>
    <NavHeader> Edgar Briandt's Blog</NavHeader>
    </NavContainer>
  )
}

export default Header