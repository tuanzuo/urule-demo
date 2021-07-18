package com.tz.urule.dto;

import com.bstek.urule.model.Label;

/**
 * 分流规则
 */
public class ABRule {
    @Label("用户的dmp标签")
    private String userDmpTag;
    @Label("跳转配置")
    private String redirectConfig;

    public String getUserDmpTag() {
        return userDmpTag;
    }

    public void setUserDmpTag(String userDmpTag) {
        this.userDmpTag = userDmpTag;
    }

    public String getRedirectConfig() {
        return redirectConfig;
    }

    public void setRedirectConfig(String redirectConfig) {
        this.redirectConfig = redirectConfig;
    }
}