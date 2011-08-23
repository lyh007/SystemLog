package com.lyh.systemlog.bo;

import java.io.Serializable;

/**
 * @author kevin
 * @version Revision: 1.00 Date: 11-8-23上午11:23
 * @Email liuyuhui007@gmail.com
 */
public class SystemLog implements Serializable {
    private long id;
    /**
     * 操作模块名称
     */
    private String module;

    /**
     * 操作动作的名称
     */
    private String operateName;

    /**
     * 操作内容
     */
    private String contents;

    /**
     * 操作者的用户名
     */
    private String operator;

    /**
     * 操作者的IP
     */
    private String loginIp;

    /**
     * 执行操作的时间
     */
    private long operateTime;

    /**
     * @return Returns the id.
     * @hibernate.id column="id" generator-class="native" type="long" unsaved-value="0"
     */
    public long getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Returns the module.
     * @hibernate.property type="string"
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * @return Returns the operateName.
     * @hibernate.property type="string"
     */
    public String getOperateName() {
        return operateName;
    }

    /**
     * @param operateName the operateName to set
     */
    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    /**
     * @return Returns the contents.
     * @hibernate.property type="string" length="65535"
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * @return Returns the operator.
     * @hibernate.property type="string"
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return Returns the loginIp.
     * @hibernate.property type="string"
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp the loginIp to set
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * @return Returns the operateTime.
     * @hibernate.property type="long"
     */
    public long getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime the operateTime to set
     */
    public void setOperateTime(long operateTime) {
        this.operateTime = operateTime;
    }
}
