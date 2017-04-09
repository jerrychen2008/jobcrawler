create dababase jobcrawler;
use jobcrawler;

CREATE TABLE `t_jobs` (
  `id` int(11) NOT NULL COMMENT '主键',
  `jobname` varchar(45) NOT NULL COMMENT '工作名称',
  `companyname` varchar(45) NOT NULL COMMENT '公司名称',
  `salrange` varchar(45) DEFAULT NULL COMMENT '工资区间',
  `publicdate` date DEFAULT NULL COMMENT '工作发布时间',
  `jobdesc` mediumtext COMMENT '工作描述',
  `companydesc` mediumtext COMMENT '公司描述',
  `validated` char(1) NOT NULL DEFAULT '0' COMMENT '是否可用',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间'
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

ALTER TABLE `t_jobs`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `t_jobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',AUTO_INCREMENT=1;