package com.yazao.mybatis.mapper;

import com.yazao.mybatis.pojo.Person;
import com.yazao.mybatis.pojo.QueryVo;
import com.yazao.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 *
 * mybatis DAO层的开发方式
 *
 *  mapper代理形式（官方推荐）
 *         接口 + 映射文件
 *
 *
 *     采用mapper代理形式需要遵循的规则：
 *         1)、接口的全路径要和映射文件的namespace一致
 *         2)、接口的方法名要和映射文件的statementId一致
 *         3)、接口方法的参数类型、返回数据类型要和映射文件中的parameterType、resultType一致
 *         4)、接口和映射文件的名字最好保持一致
 *         5)、接口和映射文件最好放在同一目录下
 *
 */
public interface UserMapper {

    public User findUserById(int id);

    public Map findUserById2(int id);

    public int findUserCount();

    public List<User> findUserByUsername(String username);

    public List<User> findUserByMap(Map map);

    public List<User> findUserByQueryVo(QueryVo queryVo);

    public List<Person> findPersonById(int id);

    public void addUser(User user);

    public void updateUserById(User user);

    public void deleteUserById(int id);
}
