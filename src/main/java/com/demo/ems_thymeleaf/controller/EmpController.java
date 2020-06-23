package com.demo.ems_thymeleaf.controller;

import com.demo.ems_thymeleaf.entity.Emp;
import com.demo.ems_thymeleaf.service.EmpService;
import com.demo.ems_thymeleaf.utils.JsonTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Resource
    private EmpService empService;

    //查询所有
    @GetMapping("/findAll")
    public @ResponseBody JsonTransfer findAll(){
       /*Map<String,Object> map=new HashMap<>();
       List<Emp> employ=empService.findAll();
       model.put("data",employ);
       model.put("status",0);
       model.put("message","");
       model.put("total","");
       System.out.println(employ.size());*/
       List<Emp> list=empService.findAll();
       JsonTransfer jt=new JsonTransfer();
       jt.setData(list);
       return jt;
    }
    //保存员工信息
    @PostMapping("/save")
    public String save(Emp emp){
        empService.save(emp);
        return "redirect:/empList2";
    }

    //删除员工
    @GetMapping("/delete")
    public String delete(String id){
        empService.delete(id);
        return "redirect:empList2";
    }


}
