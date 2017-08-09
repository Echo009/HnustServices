package cn.echo0.hnustservices.controller.backend;

import cn.echo0.hnustservices.common.CachedInfo;
import cn.echo0.hnustservices.common.Const;
import cn.echo0.hnustservices.common.ServerResponse;
import cn.echo0.hnustservices.pojo.StudentGradeAggregation;
import cn.echo0.hnustservices.services.IGradeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/22/2017 01:57 AM
 */
@Controller
@RequestMapping("/services")
@CrossOrigin(origins = "*")
public class ServicesController {
    @Autowired
    private IGradeServices iGradeServices;

    /**
     * 获取所有成绩列表
     * @return json data
     */
    @RequestMapping("/getAllGrades")
    @ResponseBody
    public ServerResponse getAllGrades(HttpSession session){
//        has logged ?
        boolean hasLogined = (boolean) session.getAttribute(Const.LOGIN_STATE);
        CachedInfo info = (CachedInfo)session.getAttribute(Const.CACHED_INFO);
        if (!hasLogined||info==null){
            return ServerResponse.createByErrorMessage("need to do login !");
        }
        StudentGradeAggregation aggregation =
                (StudentGradeAggregation) iGradeServices.qureyGrade((String) info.getInfo(Const.SESSION_ID));
        if(aggregation!=null)
            return ServerResponse.createBySuccess(aggregation);
        else return ServerResponse.createByErrorMessage("need to login again !");
    }
}
