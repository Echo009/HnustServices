package cn.echo0.hnustservices.services.impl;

import cn.echo0.hnustservices.pojo.StudentGradeAggregation;
import cn.echo0.hnustservices.services.IGradeServices;
import org.springframework.stereotype.Service;

import static cn.echo0.hnustservices.util.QueryGradeHelper.getGrade;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/22/2017 01:38 AM
 */
@Service("iGradeServices")
public class GradeServicesImpl implements IGradeServices {

    @Override
    public StudentGradeAggregation qureyGrade(String sessionId) {
        return getGrade(sessionId);
    }
}
