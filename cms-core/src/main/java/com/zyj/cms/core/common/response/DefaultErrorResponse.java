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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorResponse implements Response {
    private static final long serialVersionUID = 874200365941306385L;
}
