package com.test.sell.utils;

import com.test.sell.VO.ResultVO;

/**
 * @file_name: ResultVOUtil
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/16 17:00
 * @version：
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
