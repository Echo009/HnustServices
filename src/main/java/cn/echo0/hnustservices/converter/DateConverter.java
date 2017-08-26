package cn.echo0.hnustservices.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/23/2017 07:15 PM
 */

public class DateConverter implements Converter<String , Date>{
    /**
     * 将String类型的数据转换成Date （yyyy-MM-dd HH:mm:ss）
     * @param source
     * @return Date parse by source
     */
    @Override
    public Date convert(String source) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //绑定失败则返回空
        return null;
    }
}
