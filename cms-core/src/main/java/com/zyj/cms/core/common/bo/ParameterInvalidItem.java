package com.zyj.cms.core.common.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParameterInvalidItem {
    /**
     * 无效字段的名称
     */
    private String fieldName;

    /**
     * 错误信息
     */
    private String message;
}
