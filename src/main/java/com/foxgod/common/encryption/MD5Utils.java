package com.foxgod.common.encryption;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description
 * @Author FoxGod
 * @Date 2020/03/29 16:59
 */
public class MD5Utils {

    private String hashName;
    private String value;
    private Object salt;
    private int hashInt;

    public MD5Utils(String hashName, String value, String salt, int hashInt) {
        this.hashName = hashName;
        this.value = value;
        this.salt = ByteSource.Util.bytes(salt);
        this.hashInt = hashInt;
    }

    public String result() {
        return new SimpleHash(hashName, value, salt, hashInt).toString();
    }
}
