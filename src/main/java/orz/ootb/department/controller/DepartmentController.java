package orz.ootb.department.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import orz.ootb.department.dao.DepartmentRepository;
import orz.ootb.department.model.Department;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger("DepartmentController");

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(department -> departments.add(department));
        return departments;
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable String departmentId){
        LOGGER.info("Get department by id:" + departmentId);
        return departmentRepository.findById(departmentId).get();
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }
}
