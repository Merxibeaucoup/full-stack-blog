import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { useLocation } from "react-router";
import { Link } from "react-router-dom";
//import { Context } from "../../context/Context";
import "./singlePost.css"
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import Header from "../Header";
import Navbar from "../Navbar";

export default function SinglePost() {
  const location = useLocation();
  const path = location.pathname.split("/")[2];
  const [post, setPost] = useState({});
  const PF = "";
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");
  const [updateMode, setUpdateMode] = useState(false);

  useEffect(() => {
    const getPost = async () => {
      const res = await axios.get("/blog/" + path);
      setPost(res.data);
      setTitle(res.data.title);
      setBody(res.data.body);
    };
    getPost();
  }, [path]);

  const handleDelete = async () => {
    try {
      await axios.delete(`/blog/${post.id}`, {
       // data: { username: user.username },
      });
      window.location.replace("/");
    } catch (err) {}
  };

  const handleUpdate = async () => {
    try {
      await axios.put(`/blog/${post.id}`, {
       // username: user.username,
        title,
        body,
      });
      setUpdateMode(false)
    } catch (err) {}
  };

  return (

   
    <div className="singlePost">
         <Header/>
    <Navbar/>
      <div className="singlePostWrapper">
        {post.photo && (
          <img src={PF + post.photo} alt="" className="singlePostImg" />
        )}
        {updateMode ? (
          <input
            type="text"
            value={title}
            className="singlePostTitleInput"
            autoFocus
            onChange={(e) => setTitle(e.target.value)}
          />
        ) : (
          <h1 className="singlePostTitle">
            {title}
            { (
              <div className="singlePostEdit">
                <i
                  className="singlePostIcon"
                  onClick={() => setUpdateMode(true)}
                ><EditIcon/></i>
                <i
                  className="singlePostIcon"
                  onClick={handleDelete}
                ><DeleteIcon/></i>
              </div>
            )}
          </h1>
        )}
        <div className="singlePostInfo">
          <span className="singlePostAuthor">
            Author:
           
              <b> eddie</b>
           
          </span>
          <span className="singlePostDate">
            {post.date}
          </span>
        </div>
        {updateMode ? (
          <textarea
            className="singlePostDescInput"
            value={body}
            onChange={(e) => setBody(e.target.value)}
          />
        ) : (
          <p className="singlePostDesc">{body}</p>
        )}
        {updateMode && (
          <button className="singlePostButton" onClick={handleUpdate}>
            Update
          </button>
        )}
      </div>
    </div>
  );
}