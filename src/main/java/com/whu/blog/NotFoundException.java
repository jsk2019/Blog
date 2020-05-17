package com.whu.blog;
//自定义异常

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//将此状态定义为not_found，便于返回404页面
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
