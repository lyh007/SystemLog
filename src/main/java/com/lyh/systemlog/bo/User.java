package com.lyh.systemlog.bo;

import java.io.Serializable;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-19下午1:57
 * @Email liuyuhui007@gmail.com
 */
public class User implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
