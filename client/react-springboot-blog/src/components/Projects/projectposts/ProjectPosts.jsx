import ProjectPost from "../projectpost/ProjectPost"
import "./projectposts.css";


export default function Posts({ posts }) {
  return (
    <div className="posts">
      {posts.map((p) => (
        <ProjectPost post={p} />
      ))}
    </div>
  );
}