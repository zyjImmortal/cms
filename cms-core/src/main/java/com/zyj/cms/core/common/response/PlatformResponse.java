package com.zyj.cms.core.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouyajun
 * @date 2019/4/9
 */
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PlatformResponse implements Response {
    private static final long serialVersionUID = 874200365941306385L;

    private Integer code;
    private String message;
    private Object data;
}
