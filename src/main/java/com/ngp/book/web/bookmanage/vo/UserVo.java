package com.ngp.book.web.bookmanage.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author gzd
 * @date 2020/4/11 下午3:48
 */
@Data
public class UserVo {

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
     * 昵称
     * */
    private String nickname;
    /**
     * 角色编码
     * */
    private Long roleId;
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
