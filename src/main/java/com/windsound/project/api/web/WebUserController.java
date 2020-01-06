package com.windsound.project.api.web;

import com.windsound.project.controller.UserController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebUserController extends UserController {

}
