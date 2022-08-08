import { Route, BrowserRouter, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Write from './pages/blogWrite/Write';
import Particles from './components/Particles';
import SinglePost from "./components/blogSinglePost/SinglePost";
import About from './pages/About';
import Project from './pages/Project';
import Questions from './pages/Questions';
import ProjectWrite from "./pages/projectWrite/ProjectWrite";
import QuestiontWrite from "./pages/questionWrite/QuestionWrite";
import SingleProject from "./components/Projects/singleproject/SingleProject"
import SingleQuestion from "./components/Questions/singlequestion/SingleQuestion"






  

function App() {

  return (
   

    
    <BrowserRouter>
    <Particles id="tsparticles" />
    <Routes>
      {/**Blog Routes and paths ........ */}
      {/*  Home page*/}
      <Route path="/" element={<Home/>} />
      {/*  blog write page*/}
      <Route path="/write" element={<Write/>} />
      {/*  Single post page*/}
      <Route path="/blog/:blogId" element={<SinglePost/>} />


      {/** About Page */}
      <Route path="/about" element={<About/>} />

      {/**Projects Routes and paths ........ */}
      <Route path="/projects" element={<Project/>} />
       {/*  project write page*/}
       <Route path="/projectwrite" element={<ProjectWrite/>} />
        {/*  Single project page*/}
      <Route path="/project/:projectId" element={<SingleProject/>} />



      {/**Problems/questions Routes and paths ........ */}
      <Route path="/questions" element={<Questions/>} />
       {/*  question write page*/}
       <Route path="/questionwrite" element={<QuestiontWrite/>} />
        {/*  Single Question page*/}
      <Route path="/question/:questionId" element={<SingleQuestion/>} />
      
    </Routes> 
    </BrowserRouter>

   
  
  
   
  );
}

export default App;
