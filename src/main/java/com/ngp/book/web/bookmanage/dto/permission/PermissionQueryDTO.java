package com.ngp.book.web.bookmanage.dto.permission;

import lombok.Data;

/**
 * @author gzd
 * @date 2020/4/6 下午7:43
 */
@Data
public class PermissionQueryDTO {


    /**
     * 菜单编码
     * */
    private String menuCode;
    /**
     * 菜单名称
     * */
    private String menuName;
    /**
     * 权限编码
     * */
    private String permissionCode;
    /**
     * 权限名称
     * */
    private String permissionName;
    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     * */
    private long requiredPermission;
}
