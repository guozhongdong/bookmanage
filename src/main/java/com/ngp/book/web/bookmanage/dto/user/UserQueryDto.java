package com.ngp.book.web.bookmanage.dto.user;

import lombok.Data;

import java.util.Date;

/**
 * @author gzd
 * @date 2020/4/6 下午7:26
 *
 * 用户信息查询参数
 */
@Data
public class UserQueryDto {

    /**
     * 主键id
     * */
    private Long id;

    /**
     * 用户名
     * */
    private String username;
    /**
     * 密码
     * */
    private String password;

    /**
     * 创建时间
     * */
    private Date createTime;
    /**
     * 修改时间
     * */
    private Date updateTime;
    /**
     * 状态
     * */
    private String deleteStatus;
}
