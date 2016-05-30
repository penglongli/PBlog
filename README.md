# PBlog
Version: 0.1.1-SNAPSHOT | 更新: 05/28 2016

博客预览地址: [Pelin的个人博客](http://www.pelinli.com)

[![Build Status](https://travis-ci.org/penglongli/PBlog.svg?branch=master)](https://travis-ci.org/penglongli/PBlog) [![Coverage Status](https://coveralls.io/repos/github/penglongli/PBlog/badge.svg?branch=master)](https://coveralls.io/github/penglongli/PBlog?branch=master)

[**简介**](#简介) | 
[**安装使用**](#安装使用) | 
[**项目构建**](#项目构建) | [**交流贡献**](#交流贡献) |  [**版权**](#版权)
 
---

## 简介
PBlog是一款使用Java开发的、使用markdown作为文章写作语法的单页应用blog，目的是为了作为学习交流使用。当然，你也可以将其作为个人博客网站使用，在使用的过程中如果遇到什么问题，有好的想法或者建议，可以一起互相交流。

**NOTE:**
欢迎提交 Pr 和 Issue(如果在安装过程中出现错误，可以直接提交Issue，很高兴别人能够使用)

### 使用到的开源项目:
- [Spring Framework](http://spring.io/) famework
- [MyBatis](http://www.mybatis.org/mybatis-3/) persistence framework
- [jQuery](http://jquery.com) 
- [Less](http://lesscss.org/)
- [Font Awesome](http://www.bootcss.com/p/font-awesome/)
- [AngularJS](https://angularjs.org/)
- [angular-loading-bar.js](https://github.com/chieffancypants/angular-loading-bar)
- [marked.js](https://github.com/chjj/marked)
- [highlight.js](https://highlightjs.org/)
- [gulp](http://gulpjs.com/)

### 开发环境:
- **JDK:** java version "1.7.0_80" 
- **JVM:** HotSpot(TM) 64-Bit Server VM (build 24.80-b11, mixed mode)
- **MySQL:** 5.6.24
- **IDE:** IntelliJ IDEA 15.0.2

### 项目目录结构
```
├── dbmigrate/  数据库修改记录
└── src/
    └── main/ 
      └── java/com/pblog 源代码
        └── core
          ├── orm/ MyBatis分页对象
          ├── utis/ 
        └── dao/
        └── domain/
        └── service/
        └── web/ 
          └── controller/
          └── interceptor/
            ├── GlobalInterceptor.java  Spring拦截器:获得用户IP等信息
            ├── PaginationInterceptor.java MyBatis拦截器: 重构sql语句, 实现分页
      └── resources 源配置 
      └── webapp/ 
        └── WEB-INF/ 
          ├── jsp/  视图
        └── resources/
          ├── assets/  gulp自动化构建后生成的资源文件
          ├── js/  
          ├── less/
    ├── test/ 单元测试
├── travis.yml travis-ci配置
├── deploy.sh 部署脚本(个人部署需重写)
├── gulpfile.js gulp自动化构建脚本
├── pblog.sql PBlog初始化sql
├── pom.xml 项目依赖

```
## 安装使用

**Completed**:

* 前台页面（移动端与PC端的日间、夜间模式）
* 后台管理（文章管理、书评信息、个人日志、图片管理、分类管理，有部分功能有小bug或者缺部分功能，但是不影响使用）

**TODO List:**
* 增加评论功能
* 增加移动端footer和修改移动端样式bug

**使用方式:**

1. 下载 [PBlog.war](https://github.com/penglongli/PBlog/releases/download/0.1.1/PBlog.war);
2. 下载 pblog.sql(见源码目录)， 创建数据库: pblog(默认utf8), 导入pblog.sql;
3. 移动PBog.war重命名为ROOT.war，并移动至tomcat/webapps目录下，启动tomcat。 启动后webapps目录下会生成ROOT目录;
4. 修改webapps\ROOT\WEB-INF\classes\properties\pblog-local.properties文件：
``` java
## jdbc properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://127.0.0.1:3306/pblog?useUnicode=true&characterEncoding=UTF-8
jdbc.username=root
jdbc.password=root


## imageUtils properties
## 这是图片上传目录
server.root.staticPath=E:\\pblog\\static
## 这是图片访问路径
server.root.relPath=/static/image/
```
根据实际需要修改数据库账户密码、图片上传目录。其中图片上传目录根据Mac/Linux/Windows系统做相应修改
5. 修改conf/server.xml文件，在标签下增加一行代码：
``` java
<!--  这是配置图片的访问路径虚目录 -- >
<Context path="/static/image" docBase="E:\pblog\static"></Context>
```
其中doBase根据Mac/Linux/Windows系统做相应修改
6. 重启Tomcat服务器即可打开浏览器访问。

*具体使用请参见:* [PBlog-releases](https://github.com/penglongli/PBlog/releases/)

## 项目构建
**NOTE:** 

* [Maven 3+](http://maven.apache.org/download.cgi)
* 添加Maven的bin路径到Path中

在项目根目录执行:
```
mvn package -DskipTests
```
即可在项目根目录下的/target中生成PBlog.war文件

## 交流贡献

源码下载、使用、阅读、修改请参见 [wiki文档](https://github.com/penglongli/PBlog/wiki)

## 版权
This project is open-sourced under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)


