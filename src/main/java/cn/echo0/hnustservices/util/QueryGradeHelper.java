/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jun 29, 2017 10:52:17 PM
 */
package cn.echo0.hnustservices.util;

import cn.echo0.hnustservices.common.ApiUrl;
import cn.echo0.hnustservices.pojo.StudentGradeAggregation;

import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Ech0
 */
public class QueryGradeHelper {

    public static String getGradeHtml(String sessionId) {
        if(sessionId==null||sessionId.length()==0){
            return "";
        }
        Properties requestProperties = new Properties();
        requestProperties.setProperty("Cookie", sessionId);
        try {
            return HttpRequestHelper.sendGet(ApiUrl.QUERYGRADE, requestProperties, null, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static StudentGradeAggregation getGrade(String sessionId) {
        try {
            return ParseHtml.getGradeFromHtml(getGradeHtml(sessionId ));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
