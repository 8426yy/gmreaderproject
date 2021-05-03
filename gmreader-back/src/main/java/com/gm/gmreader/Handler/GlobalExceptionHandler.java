package com.gm.gmreader.Handler;

import com.gm.gmreader.utils.JsonResult;
import com.gm.gmreader.utils.ResultCode;
import com.gm.gmreader.utils.ResultTool;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class GlobalExceptionHandler {
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    /**
//     * 处理自定义的业务异常
//     * @param req
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = SelfException.class)
//    @ResponseBody
//    public ResultBody selfExceptionHandler(HttpServletRequest req, SelfException e){
//        logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
//        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
//    }
//
//    /**
//     * 处理空指针的异常
//     * @param req
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value =NullPointerException.class)
//    @ResponseBody
//    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
//        logger.error("发生空指针异常！原因是:",e);
//        return ResultBody.error(  CommonEnum.BODY_NOT_MATCH);
//    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public JsonResult exceptionHandler(HttpServletRequest req, Exception e){
        JsonResult result = null;
        if (e instanceof AccountExpiredException) {
            //账号过期
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }else if(e instanceof MyBatisSystemException || e instanceof SQLException)
        {
            result= ResultTool.fail(ResultCode.SQL_EXCUTE_ERROR);
        }else
        {
            //其他错误
            result = ResultTool.fail(ResultCode.COMMON_FAIL);
        }
        return result;
    }
}