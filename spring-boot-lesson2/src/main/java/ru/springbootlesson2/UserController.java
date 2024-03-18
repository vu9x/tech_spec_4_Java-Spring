package ru.springbootlesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller
@RequestMapping("users")   //    //http://localhost:8081/users/
public class UserController {

//    //http://localhost:8081/all
//    @RequestMapping(path= "all", method = RequestMethod.GET)
////    @ResponseBody
//    public List<User> getAll(){
//        return List.of(new User("Костя"), new User("Василий"));
//    }

//    @Autowired
    private UserRepository repository;

//    @Autowired
//    public void setRepository(UserRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping(value = "all")
    public List<User> getAll(){
        return repository.getAll();
    }

    @GetMapping("{id}")
    // http://localhost:8081/users/1
    public User getById(@PathVariable long id){
        return repository.getById(id);
    }

    @GetMapping()
    // http://localhost:8081/users?name=Костя
    public User getByName(@RequestParam String name){
        return repository.getByName(name);
    }
}
