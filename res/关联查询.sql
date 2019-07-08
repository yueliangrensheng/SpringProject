
# 关联查询： 一对一 
# 一个订单 对应一个用户
select o.*,u.username,u.birthday,u.sex,u.address from orders o LEFT JOIN user u ON o.user_id = u.id


# 关联查询： 一对多
# 一个用户 对应 多个订单
# select  * from user u LEFT JOIN orders o on u.id = o.user_id

#  使用的是内连接 更好的体现 一对多
select  u.*,o.id oid,o.number,o.createtime,o.note from user u INNER JOIN orders o on u.id = o.user_id 
