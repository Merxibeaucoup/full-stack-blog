import "./projectpost.css";
import TodayIcon from '@mui/icons-material/Today';
import { Link } from 'react-router-dom';

export default function Post({ post }) {
 
  return (
    <div className="post">
      {post.photo && <img className="postImg" src={post.photo} alt="" />}

      <Link to={`/project/${post.id}`} className="link" style={{ textDecoration: 'none' }}>
          <span className="postTitle">{post.title}</span>
        </Link>
        <hr />
        <span className="postDate"> <span className="postIcon"><TodayIcon style={{position: 'relative', top: '7px'}} /></span> posted on: {post.date}  </span>
        <p className="postDesc">{post.body}</p>
      
    </div>

    
    
  );
}