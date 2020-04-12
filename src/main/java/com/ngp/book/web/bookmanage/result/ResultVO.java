package com.ngp.book.web.bookmanage.result;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.exception.CommonJsonException;
import com.ngp.book.web.bookmanage.utils.StringTools;
import com.ngp.book.web.bookmanage.utils.constants.Constants;
import com.ngp.book.web.bookmanage.utils.constants.ErrorEnum;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;

/**
 * @author gzd
 * @date 2020/4/6 下午12:51
 *
 *
 */
@Data
public class ResultVO<T> implements Serializable {

    private String code;
    private String msg;
    private T info;

    /**
     * 返回一个info为空对象的成功消息的json
     */
    public static ResultVO successRes() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(Constants.SUCCESS_CODE);
        resultVO.setMsg(Constants.SUCCESS_MSG);
        resultVO.setInfo(new ResultData<>());
        return resultVO;
    }

    public static ResultVO failResultRes(ErrorEnum errorEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(errorEnum.getErrorCode());
        resultVO.setMsg(errorEnum.getErrorMsg());
        resultVO.setInfo(new ResultData<>());
        return resultVO;
    }

    @Data
    public static class ResultData<T> implements Serializable {

        private Integer pageNum;
        private Integer pageSize;
        private Integer totalPage;
        private Integer totalCount;

        private T datalist;
    }






}
