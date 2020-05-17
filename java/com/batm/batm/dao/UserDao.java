/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.batm.batm.dao;

import com.batm.batm.model.User;
import com.batm.batm.services.UserServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.activation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class UserDao implements UserServices {

   
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User validateUser(User user) {
        String sql = "select * from user where username='" + user.getUsername() + "' and password='" + user.getPassword()
                + "'";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }
}

class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setNama(rs.getString("nama"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
