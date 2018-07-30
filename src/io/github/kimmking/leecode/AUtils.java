package io.github.kimmking.leecode;

import java.util.Collection;
import java.util.List;

/**
 * Created by kimmking on 2018/7/29.
 */
public class AUtils {

    public static String toJSON(Object obj){
        StringBuilder sb = new StringBuilder();
        if(obj == null) return "null";
        Class clz = obj.getClass();

        if(clz.isPrimitive()){
            sb.append(obj);
        }else if(clz.equals(String.class)){
            return "\"" + obj + "\"";
        }else if(clz.equals(Integer.class)||clz.equals(Long.class)||clz.equals(Float.class)||clz.equals(Byte.class)){
            return obj.toString();
        }
        else if(clz.isArray()){
            sb.append('[');
            Object[] arr = (Object[]) obj;
            for (Object o : arr){
                sb.append(toJSON(o)+",");
            }
            sb.append(']');
        }else if(Collection.class.isAssignableFrom(clz)){
            sb.append('[');
            Collection arr = (Collection) obj;
            for (Object o : arr){
                sb.append(toJSON(o)+",");
            }
            sb.append(']');
        }else if(List.class.isAssignableFrom(clz)){
            sb.append('[');
            List arr = (List) obj;
            for (Object o : arr){
                sb.append(toJSON(o)+",");
            }
            sb.append(']');
        }


        return sb.toString();
    }
}
