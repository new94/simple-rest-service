package ru.nenahov.simplerest.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nenahov.simplerest.model.ModelUtil;

@RestController
public class SimpleErrorController implements ErrorController {

    @RequestMapping(value = ModelUtil.PATH_ERROR)
    public String error() {
        return "Oops! Something went wrong!";
    }

    @Override
    public String getErrorPath() {
        return ModelUtil.PATH_ERROR;
    }
}
