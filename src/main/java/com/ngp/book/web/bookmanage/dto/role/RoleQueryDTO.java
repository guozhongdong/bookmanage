package com.ngp.book.web.bookmanage.dto.role;

import lombok.Data;

import java.util.Date;

/**
 * @author gzd
 * @date 2020/4/6 下午7:42
 */

@Data
public class RoleQueryDTO {

    /**
     * 角色名称
     * */
    private String roleName;
    /**
     * 创建时间
     * */
    private Date createTime;
    /**
     * 修改时间
     * */
    private Date updateTime;
    /**
     * 角色状态
     * */
    private String deleteStatus;

}
