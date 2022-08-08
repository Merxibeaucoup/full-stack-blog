import QuestionPosts from "../components/Questions/questionposts/QuestionPosts"
import axios from "axios";
import { useState,  useEffect } from "react";
import Navbar from "../components/Navbar";
import Header from "../components/Header";

const Questions = () => {
  const [posts, setPosts] = useState([]);
   
  
  useEffect(() => {
    const fetchPosts = async () => {
      const res = await axios.get("/question" );
      setPosts(res.data);
    };
    fetchPosts();
  }, []);



  return (
    <>
   
    
      <div className="home">

        <Header/>
       
        <Navbar/>

        
        <QuestionPosts posts={posts} />
       
      </div>
    </>
  );
}


export default Questions