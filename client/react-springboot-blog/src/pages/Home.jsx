import Posts from "../components/blogPosts/Posts"
import axios from "axios";
import { useState,  useEffect } from "react";
import Navbar from "../components/Navbar";
import Header from "../components/Header";

export default function Home() {
    const [posts, setPosts] = useState([]);
   
  
    useEffect(() => {
      const fetchPosts = async () => {
        const res = await axios.get("/blog" );
        setPosts(res.data);
      };
      fetchPosts();
    }, []);



    return (
      <>
     
      
        <div className="home">

          <Header/>
         
          <Navbar/>

          
          <Posts posts={posts} />
         
        </div>
      </>
    );
  }