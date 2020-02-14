package com.windsound.project.controller;

import com.alibaba.fastjson.JSON;
import com.windsound.project.common.AjaxResult;
import com.windsound.project.common.excel.ExcelUtil;
import com.windsound.project.controller.base.BaseController;
import com.windsound.project.entity.Userinfo;
import com.windsound.project.entity.po.UserPO;
import com.windsound.project.entity.vo.UserVo;
import com.windsound.project.service.IWxuserService;
import com.windsound.project.service.impl.UserinfoServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * 用户 信息操作处理
 * 
 * @author yanwlb
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/userinfo")
public class UserinfoController extends BaseController
{
	private static Logger log= LoggerFactory.getLogger(UserinfoController.class);
	@Autowired
	UserinfoServiceImpl userinfoService;

	@Autowired
	IWxuserService wxuserService;

	/*数据导出*/
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult exportHealthData(String userName, String idCard, String tel){
		return null;
	}

	@GetMapping("/downloadData")
	public AjaxResult downloadScoreImportFailFile(HttpServletRequest request,
											  HttpServletResponse response ,String userName, String idCard, String tel,String uploadTime){
		InputStream is=null;
		OutputStream os=null;
		try {
			response.setHeader("Content-disposition", "attachment; filename=" + new String("健康信息.xls".getBytes("UTF-8"), "iso-8859-1"));
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			UserVo userVo=new UserVo();
			userVo.setUserName(userName);
			userVo.setIdCard(idCard);
			userVo.setTel(tel);
			userVo.setUploadTime(uploadTime);
			List<UserVo> list = userinfoService.selectUserVoList(userVo);
			ExcelUtil<UserVo> util = new ExcelUtil<UserVo>(UserVo.class);
			HSSFWorkbook book= util.generateExcel(list, "health");
			 is = new ByteArrayInputStream(book.getBytes());
			os=response.getOutputStream();
			book.write(os);
			return AjaxResult.success().put("total",list.size());
		}catch(Exception e){
			log.error("下载信息发生异常",e);
			return AjaxResult.error("下载健康信息发生异常");
		}finally{
			try{
				if(os!=null){
					os.flush();
					os.close();
				}
				if(is!=null){
					is.close();
				}
			}catch(Exception e){
				log.error("when inputstream or outputstream closed occurs error",e);
			}
		}
	}




	/**
	 * 查询用户列表
	 */
	@GetMapping("/list")
	@ResponseBody
	public AjaxResult list(String userName, String idCard, String tel, String uploadTime,
						   @RequestParam(defaultValue = "1") Integer startPage,
						   @RequestParam(defaultValue = "10") Integer pageSize)
	{
		try{
			Map<String,Object> param=new HashMap<>();
			param.put("userName",userName);
			param.put("idCard",idCard);
			param.put("tel",tel);
			param.put("uploadTime",uploadTime);
			param.put("startIndex",(startPage-1)*pageSize);
			param.put("pageSize",pageSize);
			Integer total=userinfoService.selectCount(param);
			AjaxResult result= AjaxResult.success("查询成功");
			result.put("startIndex",(startPage-1)*pageSize);
			result.put("pageSize",pageSize);
			result.put("total",total);
			if(total>0){
				List<UserVo> list = userinfoService.selectUserVoList(param);
				result.put("data",list);
			}else{
				result.put("data", Collections.emptyList());
			}
			return result;
		}catch (Exception e){
			log.error("分页查询健康信息发生异常",e);
			return AjaxResult.error("查询信息发生异常");
		}
	}

	/**
	 * 新增保存用户
	 */

	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestBody UserPO userPO)
	{		
        //根据openId获得用户
		if(StringUtils.isEmpty(userPO.getOpenId())){
			return AjaxResult.error("请传入用户openId");
		}
		if(StringUtils.isEmpty(userPO.getUserName())){
			return AjaxResult.error("请输入用户名称");
		}
		if(StringUtils.isEmpty(userPO.getIdCard())){
			return AjaxResult.error("请输入身份证号");
		}
		if(StringUtils.isEmpty(userPO.getTel())){
			return AjaxResult.error("请输入手机号");
		}

		if(userPO.getUserinfo()==null || Userinfo.isAllEmpty(userPO.getUserinfo())){
			return AjaxResult.error("请补充您的健康信息");
		}
		AjaxResult result=userinfoService.insertUserPo(userPO);
        return result;

	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit/{id}")
	@ResponseBody
	public Userinfo edit(@PathVariable("id") Long id)
	{
		Userinfo userinfo = userinfoService.selectUserinfoById(id);
		return userinfo;
	}
	
	/**
	 * 修改保存用户
	 */
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(@RequestBody  Userinfo userinfo)
	{		
		return toAjax(userinfoService.updateUserinfo(userinfo));
	}
	public static void main(String[] args) {
		UserVo userVo=new UserVo();
		userVo.setCreateTime(new Date());
		userVo.setIdCard("111");
		userVo.setTel("111");
		userVo.setUserName("zhang");
		System.out.println(JSON.toJSONString(userVo));
	}

	private String initUserPoJSON(){
		UserPO userPO=new UserPO();
		userPO.setOpenId("oadnu0Gkw7XemE5yyyDpf8-pZo4U");
		userPO.setIdCard("130729198702242589");
		userPO.setTel("15932451245");
		userPO.setUserName("刘新洲");

		Userinfo userinfo=new Userinfo();
		userinfo.setIsDuty(1);
		userinfo.setTemperature(new BigDecimal(37.0));
		userinfo.setAddress("张家口柴沟堡");
		userinfo.setCurrAddress("张家口市桥东区");
		userinfo.setIsSelfFeverCough(0);
		userinfo.setIsSelfPassWuhan(0);
		userinfo.setIsSelfTouchHubei(0);
		userinfo.setIsSelfTouchWenzhou(0);
		userinfo.setIsOtherFeverCough(0);
		userinfo.setIsOtherTouchHubei(0);
		userinfo.setIsOtherPassWuhan(0);
		userinfo.setIsOtherTouchWenzhou(0);
		userinfo.setRemark("轻微感冒");
		userPO.setUserinfo(userinfo);
		String json= JSON.toJSONString(userPO);
		return json;

	}
}
