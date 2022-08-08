import React from 'react'
import Header from '../components/Header'
import Navbar from '../components/Navbar'
import styled from "styled-components"



const About = () => {

const Container = styled.div`

`

const Wrapper = styled.div`
    margin:5%;
   
`
const ImageContainer = styled.div`
display: flex;
width: 10%;
height:50vh;



`

const AboutPic = styled.img`
flex:1;

    
`
const DescContainer = styled.div`
width: 65%;
`
const Desc = styled.p`
display: flex;

font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    letter-spacing: 2px;
    text-align: center;
    font-size: 22px;

    
`


 const Title = styled.h2`
 display: flex;
align-items: left;
text-align:left;
justify-content: center;
font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    letter-spacing: 2px;
    font-size: 22px;

     
 `
 const Country = styled.h5`
 display: flex;
align-items: left;
justify-content: center;
font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    letter-spacing: 2px;
    font-size: 22px;


`

const List = styled.li`
font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    letter-spacing: 2px;
    font-size: 22px;
    font-weight:350;
    margin:2%;
`
const List2 = styled.li`
margin-left: 3%;
`

const Links = styled.a`
text-decoration: none;
font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    letter-spacing: 2px;
    font-size: 22px;
    font-weight:550;
 font-size: 22px;
 color: #e11f14;
 &:hover{
    color:grey;
 }

`





  return (
    <Container>
        <Header/>
         <Navbar/>

        <Wrapper>
         <Title>
            Hi , Im Edgar Briandt &#129303;
         </Title>
         <Country>
            Ghanaian &#x1F1EC;&#x1F1ED; |  Rhode Island &#x1F1FA;&#x1F1F8; |  Computer Science &#x1F468;&#x1F3FE;&#x200D;&#x1F4BB;
         </Country>


         <ImageContainer>
            <AboutPic  src="/img/me.jpeg" />
         </ImageContainer>
         <DescContainer>
            <Desc>
            &#x1F331; im an aspiring software engineer

            
            </Desc>
         </DescContainer>
         <ul>
                <List> &#x1F468;&#x1F3FE;&#x200D;&#x1F393; I recieved my bachelors degree in Computer Science from Rhode Island College in spring 2022</List>
                <List> &#x1F3AF; My current interests and passion lie in building dynamic web apps on both frontend and/or backend</List>
                <List>&#x1F6E0;&#xFE0F; Proficient in :  <span style={{color:'blue', fontSize: '22px'}}>Java , JavaScript and   HTML - CSS</span>  </List>
                <List>&#x1F6E1;&#xFE0F; Frameworks: Spring boot, NodeJS(Express), ReactJs, VueJs</List>
            </ul>

            <h2 style={{ fontSize: '22px'}}>You can Reach me by: </h2>
            <List2>
                <Links  href="mailto: edgarbriandt@gmail.com">&#x1F4E7; Email </Links>  
            </List2>
            <List2>
                <Links href='https://www.linkedin.com/in/edgar-briandt-38046522a/'> &#x1F517; LinkedIn</Links>
            </List2>

            <h2 style={{ fontSize: '22px'}}>Working Experience: </h2>
            <ul>
               <li> <Desc>Residential counselor at Bamsi, Franklin, MA</Desc> </li>
               <Desc>(Feb 2021 ~ Aug 2021) && (June 2022 - present)</Desc>
               <li> <Desc>Fitness club Employee at Kingsbury Club, Medfield, MA</Desc> </li>
               <Desc>(Feb 2017 - present)</Desc>
               <li> <Desc> Employee at CBS Scene, Foxborough, MA</Desc> </li>
               <Desc>(Feb 2015 - Feb 2017)</Desc>
            </ul>

            <h2 style={{ fontSize: '22px'}}>Other Interests: </h2>
            <List>Fitness</List>
            <List>Photography</List>
            <List>Frozen Bluberries connoisseur</List>
            <List>Strawberry nesquik connoisseur</List>
            <List>Lover of all animals</List>

           

         </Wrapper>
        
    </Container>
  )
}

export default About