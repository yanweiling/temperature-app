package com.windsound.project.controller.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.windsound.project.common.AjaxResult;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * web层通用数据处理
 * 
 * @author rainy
 */
public class BaseController {
  /**
   * 响应返回结果
   * 
   * @param rows 影响行数
   * @return 操作结果
   */
  protected AjaxResult toAjax(int rows) {
    return rows > 0 ? success() : error();
  }

  /**
   * 返回成功
   */
  public AjaxResult success() {
    return AjaxResult.success();
  }

  /**
   * 返回失败消息
   */
  public AjaxResult error() {
    return AjaxResult.error();
  }

  /**
   * 返回成功消息
   */
  public AjaxResult success(String message) {
    return AjaxResult.success(message);
  }

  /**
   * 返回失败消息
   */
  public AjaxResult error(String message) {
    return AjaxResult.error(message);
  }

  /**
   * 返回错误码消息
   */
  public AjaxResult error(int code, String message) {
    return AjaxResult.error(code, message);
  }

}
