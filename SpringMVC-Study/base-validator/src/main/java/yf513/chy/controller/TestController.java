package yf513.chy.controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import yf513.chy.domain.Employee;

import javax.validation.Valid;

/**
 * @author CHY
 * @date 2020/12/17 9:40
 */
@RestController
public class TestController {
    public void addEmployee(@Valid Employee employee, Errors errors, Model model) {
    }
}
