import { useState } from 'react';
import axios from "axios";
import "./questionwrite.css";
import AddAPhotoOutlinedIcon from '@mui/icons-material/AddAPhotoOutlined';

export default function ProjectWrite() {


    const [title, setTitle] = useState("");
    const [body, setBody] = useState("");
    const [file, setFile] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const newPost = {
          
          title,
          body,
        };

        if (file) {
            const data =new FormData();
            const filename =  "http://localhost:8443/images/" + file.name;
            data.append("name", filename);
            data.append("file", file);
            newPost.photo = filename;
            try {
              await axios.post("/upload", data);
            } catch (err) {}
          }
          try {
            const res = await axios.post("/question", newPost);
            window.location.replace("/question/" + res.data.id);
          } catch (err) {}
        };


    return (
        <div className="write">
          <h1 className='head'>Add A Problem/Question Section </h1>
        {file && (
          <img className="writeImg" src={URL.createObjectURL(file)} alt="" />
        )}
        <form className="writeForm" onSubmit={handleSubmit}>
          <div className="writeFormGroup">
            <label htmlFor="fileInput">
              <i className="writeIcon"><AddAPhotoOutlinedIcon/></i>
            </label>
            <input
              type="file"
              id="fileInput"
              style={{ display: "none" }}
              onChange={(e) => setFile(e.target.files[0])}
            />
            <input
              type="text"
              placeholder="Title"
              className="writeInput"
              autoFocus={true}
              onChange={e=>setTitle(e.target.value)}
            />
          </div>
          <div className="writeFormGroup">
            <textarea
              placeholder="Write Somethin, Be Creative..."
              type="text"
              className="writeInput writeText"
              onChange={e=>setBody(e.target.value)}
            ></textarea>
          </div>
          <button className="writeSubmit" type="submit">
            Publish
          </button>
        </form>
      </div>
    );
  }
