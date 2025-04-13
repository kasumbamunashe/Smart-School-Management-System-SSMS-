package com.zw.jimfish.Smart.School.Management.System.SSMS.controller.exceptions;

import com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zw.jimfish.Smart.School.Management.System.SSMS.service.exceptions.Error;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionHandlerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);


    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error invalidFormat(InvalidFormatException e) {
        LOGGER.info("Wrong format: {}", e.getMessage());
        return Error.of(400, e.getMessage());
    }



}
