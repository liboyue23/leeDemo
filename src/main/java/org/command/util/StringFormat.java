package org.command.util;

import org.command.parameter.AuthParameter;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Arrays;

/**
 * Created by lee on 16/4/7.
 */
public class StringFormat {
    public static String[] mysqlParameterFormat(AuthParameter parameter){
        MessageFormat format=new MessageFormat("-u{0} -p{1} -h{2} -P{3,number}");
        format.setFormat(3,integerFormat());
        Object[] parameterArray=new Object[]{parameter.getUser(),parameter.getPassword(),parameter.getHost(),parameter.getPort()};
        return format.format(parameterArray).split("\\s+");
    }

    private static NumberFormat integerFormat(){
        NumberFormat format=NumberFormat.getInstance();
        format.setGroupingUsed(false);
        return format;
    }

}
