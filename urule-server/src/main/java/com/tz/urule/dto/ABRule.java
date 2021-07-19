package com.tz.urule.dto;

import com.bstek.urule.model.Label;
import lombok.Getter;
import lombok.Setter;

/**
 * 分流规则
 */
@Getter
@Setter
public class ABRule {

    @Label("用户的dmp标签")
    private String userDmpTag;

    @Label("跳转配置")
    private String redirectConfig;

}