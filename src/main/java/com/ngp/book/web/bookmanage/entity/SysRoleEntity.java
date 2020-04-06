package com.ngp.book.web.bookmanage.entity;

import lombok.Data;

@Data
public class SysRoleEntity {
  /**
   * 主键id
   * */
  private long id;
  /**
   * 角色名称
   * */
  private String roleName;
  /**
   * 创建时间
   * */
  private java.sql.Timestamp createTime;
  /**
   * 修改时间
   * */
  private java.sql.Timestamp updateTime;
  /**
   * 角色状态
   * */
  private String deleteStatus;



}
