package cn.tj.baseextweb.fw.util;

import java.util.UUID;

public class UDIDUtil {

    public static String generator() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}