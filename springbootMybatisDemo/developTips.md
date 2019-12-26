本文档针对项目内容、注意点,向freshman/amateur 做介绍,old hand可跳过。

1.项目构建工具、框架
    (1)本项目是由Maven构建工具构建的Springboot(框架)+Mybatis(框架)+MySQL(数据库)项目
    (2)Maven介绍: 官网:https://maven.apache.org/
                       下载地址:https://maven.apache.org/download.cgi               
                        与Maven相似功能的build tool (即构建工具)有:
                                ①Gradle:
                                    Gradle是一个基于Apache Ant和Apache Maven概念的项目自动化构建开源工具。它使用一种基于Groovy的特定领域语言(DSL)来声明项目设置，目前也增加了基于Kotlin语言的kotlin-based DSL，抛弃了基于XML的各种繁琐配置。面向Java应用为主。
                                ②Gant:
                                    Gant是一个基于Ant的构建工具,它采用Groovy脚本代替XML来编写构建逻辑。
    (3)MyBatis介绍: java里面连接数据库的框架之一。
                    与MyBatis相似功能的框架有:
                    Hibernate:Hibernate是面向对象的，而MyBatis是面向关系的.Hibernate封装度更高,MyBatis写SQL更灵活
                    Spring Data JPA :作为Spring Data的子模块 JPA默认使用Hibernate作为ORM实现
    (4)MySQL介绍:     关系型数据库的代表。
                关系型数据库: Oracle MySQL SQLite SQLServer  PostgreSQL MariaDB
                              优点:
                              1、易于维护：都是使用表结构，格式一致；
                              2、使用方便：SQL语言通用，可用于复杂查询；
                              3、复杂操作：支持SQL，可用于一个表以及多个表之间非常复杂的查询。
                              缺点:
                              1、读写性能比较差，尤其是海量数据的高效率读写；
                              2、固定的表结构，灵活度稍欠；
                              3、高并发读写需求，传统关系型数据库来说，硬盘I/O是一个很大的瓶颈。 
                非关系型数据库:Redis MongoDB CouchDB HBase Memechaed Neo4j Cassandra
                              非关系型数据库严格上不是一种数据库，应该是一种数据结构化存储方法的集合，可以是文档或者键值对等。
                              优点：
                              1、格式灵活：存储数据的格式可以是key,value形式、文档形式、图片形式等等，文档形式、图片形式等等，使用灵活，应用场景广泛，而关系型数据库则只支持基础类型。
                              2、速度快：nosql可以使用硬盘或者随机存储器作为载体，而关系型数据库只能使用硬盘；
                              3、高扩展性；
                              4、成本低：nosql数据库部署简单，基本都是开源软件。
                              缺点：
                              1、不提供sql支持，学习和使用成本较高；
                              2、无事务处理；
                              3、数据结构相对复杂，复杂查询方面稍欠。
                              非关系型数据库的分类和比较：
                              1、文档型
                              2、key-value型
                              3、列式数据库
                              4、图形数据库
                    