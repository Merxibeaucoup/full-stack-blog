import ProjectPosts from "../components/Projects/projectposts/ProjectPosts"
import axios from "axios";
import { useState,  useEffect } from "react";
import Navbar from "../components/Navbar";
import Header from "../components/Header";
const Project = () => {
  const [posts, setPosts] = useState([]);
   
  
    useEffect(() => {
      const fetchPosts = async () => {
        const res = await axios.get("/project" );
        setPosts(res.data);
      };
      fetchPosts();
    }, []);



    return (
      <>
     
      
        <div className="home">

          <Header/>
         
          <Navbar/>

          
          <ProjectPosts posts={posts} />
         
        </div>
      </>
    );
  }

export default Project