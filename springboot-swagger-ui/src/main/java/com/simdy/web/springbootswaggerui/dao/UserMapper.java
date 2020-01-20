package com.simdy.web.springbootswaggerui.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.simdy.web.springbootswaggerui.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Interface UserJpaDao.
 *
 * @author abel
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * Find by name.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);

    User getOne(Long id);

    List<User> findByUsernameContaining(String username);

    User getByUsernameIs(String username);

    @Select("select * from sec_user where name like '%${name}%'")
    List<User> findByNameLike(@Param("name") String name);
}