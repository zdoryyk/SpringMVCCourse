//package SpringCourse.controllers;
//
//import SpringCourse.DAO.PersonDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/test-batch-update")
//public class BatchController {
//
//    @Autowired
//    public BatchController(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }
//
//    private final PersonDAO personDAO;
//
//    @GetMapping()
//    public String index(){
//        return "batch/index";
//    }
//
//    @GetMapping("/without")
//    public String withoutBatch(){
//        personDAO.testMultipleUpdate();
//
//        return "redirect:/people";
//    }
//
//    @GetMapping("/with")
//    public String withBatch(){
//        personDAO.testBatchUpdate();
//
//        return "redirect:/people";
//    }
//}
