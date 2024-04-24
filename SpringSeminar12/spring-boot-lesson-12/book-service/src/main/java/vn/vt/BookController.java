package vn.vt;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {


    @GetMapping("book/{id}")
    public String  getById(@PathVariable long id){
        return "Нашли книгу с id =" + id;
    }
}
