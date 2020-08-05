package com.example.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomizedUserRepositoryImpl extends NamedParameterJdbcDaoSupport
        implements CustomizedUserRepository {

    public CustomizedUserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        setJdbcTemplate(jdbcTemplate);
    }

    public List<User> findUser(String name, String mobile){
        String sql = "SELECT * FROM user";
        String where = "";
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(name)) {
            if (where == "") {
                where = " where ";
            }
            where += " name like :name";
            params.put("name", "%" + name + "%");
        }

        if (!StringUtils.isEmpty(mobile)) {
            if (where == "") {
                where = " where ";
            } else {
                where += " and ";
            }
            where += " mobile like :mobile";
            params.put("mobile", "%" + mobile + "%");
        }

        sql += where;

        System.out.println(sql);

        RowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        List userList = getNamedParameterJdbcTemplate().query(sql, params, rowMapper);
        return userList;
    }

}