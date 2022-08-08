import QuestionPost from "../questionpost/QuestionPost"
import "./questionposts.css";


export default function Posts({ posts }) {
  return (
    <div className="posts">
      {posts.map((p) => (
        <QuestionPost post={p} />
      ))}
    </div>
  );
}