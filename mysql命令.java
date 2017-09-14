/**连接*/
mysql -uroot -p    //本地连接
mysql –u用户名 [–h主机名或者IP地址] –p密码   //远程连接
/**创建*/
drop database if EXISTS sampledb;//建数据库之前如果存在就先删除
create database sampledb default character set utf8;//建数据库
use sampledb;//使用指定数据库
show databases; //查看数据库
show tables; //查看所所有表
show variables like '%datadir%';//查看数据库（data）存放路径
show index from tableName;//查看索引
show CREATE table t_msgcontent;//查看创建表语句（包含外键的创建;
show table status ; //查看表分区
show columns from table //查看列
SELECT CONCAT(str1,str2) FROM  table  //连接多个字段
DATE_FORMAT(crt_time,'%Y-%m-%d') //格式化日期

/**注意事项*/
设为自增的字段必须是主键


//指定表的引擎为innoDB类型（支持事物）默认为Myisam引擎
create table t_login_log(login_log_id int auto_increment primary key,user_id int,ip varchar(23),login_datetime datetime)engine=innodb;
 //插入
 insert into t_user(user_name,password) values('admin','123456');



/*查询语句*/
select count(distinct t1.msgSign,t1.msgNumber)  from t_msgsigncount t1 where t1.showCount != 0//distinct放在最前边

SELECT COUNT(*) FROM `t_msgcontent` WHERE create_time between CURDATE()-interval 1 day and CURDATE() ORDER BY `t_msgcontent`.`create_time` DESC//查询昨天的数据
SELECT * FROM t_msgsigncount WHERE TO_DAYS(create_time) = TO_DAYS(NOW());

跳出mysql命令行:查询结果导出到文件
[root@SHNHDX63-146 ~]# mysql -h 127.0.0.1 -u root -p XXXX -P 3306 -e "select * from table"  > /tmp/test/txt
[root@iZ25nvqu9h4Z ~]# mysql -uroot -p883f9c77b482483b8bdc0d54123806fd -e " SELECT msgNumber,msgContent,receive_time,id,imei FROM mklm_admin.t_msgcontent " > ~/export20170913.txt;


