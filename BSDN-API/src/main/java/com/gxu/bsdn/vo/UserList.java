package com.gxu.bsdn.vo;

import com.gxu.bsdn.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserList {
    private List<User> userList;
    private Long userCount;
}
