package com.ngp.book.web.bookmanage.entity;

import lombok.Data;

import java.util.Date;
/**
 * 角色与权限对应关系
 * */
@Data
public class SysRolePermissionEntity {
  /**
   * 主键id
   * */
  private long id;
  /**
   * 角色编码
   * */
  private long roleId;
  /**
   * 权限编码
   * */
  private long permissionId;
  /**
   * 创建时间
   * */
  private Date createTime;
  /**
   * 修改时间
   * */
  private Date updateTime;
  /**
   * 权限状态
   * */
  private String deleteStatus;

}
