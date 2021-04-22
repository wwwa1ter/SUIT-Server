package com.pose.dao;

import com.pose.pojo.Movement;

public interface MovementDao {
    //添加动作
    int addMovement(Movement movement);

    //删除动作
    int deleteMovementByName(String name);

    //获取动作详细内容
    Movement queryMovement(String name);

    //修改动作内容
    int updateMovement(Movement movement);
}
