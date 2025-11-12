软件设计与体系结构(SDA)
第 3 次课外实验指导书

一、开发环境（推荐，可不限于此）
开发语言：不限（推荐使用 Java、Python）
开发环境：IntelliJ IDEA/Eclipse 等集成开发环境
服务后台运行环境：云服务平台（操作系统不限）
建模工具： Microsoft Visio/Visio/Lucidchart/Gleek.io/Diagrams.net 等 UML 绘图工具
二、实习任务要求
2.1 从以下题目中选择一个，创建服务程序
1. 一个访问 Neo4j AuraDB（图数据库）的 Java Microservice 程序
随着近年来图计算的兴起，图数据库备受关注，作为全球领先的图数据平台 Neo4j，2021
年 11 月 17 日宣布全面推出 Neo4j AuraDB FreeTM，无需信用卡即可启用，是该公司广受欢
迎的图数据库即服务 AuraDB 的永久免费版。通过发布 AuraDB 免费版，Neo4j 旨在以零阻
力和零成本为所有用户提供应用最为广泛的图数据平台，加速其变革性图技术在现代智能应
用中的部署。开发人员使用图技术可进行快速学习、原型化和开发，无需对基础设施进行管
理。免费版提供了在易于使用、完全托管的云服务中最快的图路径。
参考文档《Build a Java Microservice with AuraDB Free-From CodeProject Website.docx》
使用 Java 开发一个访问 Neo4j AuraDB（图数据库）的 Microservice 程序。
http://neo4j.com.cn/
https://research.aimultiple.com/knowledge-graph/
https://blog.csdn.net/weixin_30342639/article/details/86477556
https://blog.csdn.net/javeme/article/details/104819023
2.一个邮件服务 WebService 程序
现实生活中，存在着大量发送电子邮件通知和/或手机短信的系统需求，例如：当你登
录阿里云账号时，可以通过手机验证实现账号登入功能。这类发送通知消息的服务是可以被
其他应用程序重用的功能。
结合课堂上讲授的 SOA 架构风格，基于阿里云等服务平台的邮件服务，实现一个能发
送电子邮件消息的 Web Service 服务，包括如下三个具体服务（需提供 SOAP 和 REST 两种
协议的接口）：
 sendEmail(String _url, String _payload) //邮件地址为_url，内容为_payload
 sendEmailBatch(String[] _url, String _payload) //批量发送邮件
 validateEmailAddress(String _url) //验证是否为有效的邮件地址
注：
a. 以上三个服务，返回值为 Y 或者 N。例如在第一个服务中，发送成功则返回 Y，发
送失败则返回 N。
b. 可基于阿里云等服务平台的提供邮件推送服务（https://dm.console.aliyun.com/）来
实现上述 Web Service 邮件服务。
c. 尽量使用正则表达式完成 validateEmailAddress 方法调用。
2.2 开发服务使用者程序
对于选题 1（一个访问 Neo4j AuraDB（图数据库）的 Java Microservice 程序）编写
一个服务使用者程序，调用服务进行测试（需要预先创建图数据库）。
对于选题 2（一个邮件服务 WebService 程序）编写至少两种版本（桌面版/Web 版
/Android 或 IOS 版）的客户端软件，分别调用自己编写的邮件推送 Web Service 服务。
2.3 结合上述案例程序分析 Web Service（含微服务）软件风格的优缺点和适用场合。
结合实习题目，从软件体系结构风格的角度分析 Web Service 风格（含微服务）的主要
构件和连接件特点。
提示：可参考课堂上讲授的“3.11 SOA 风格”中面向服务的分布式软件体系结构（如
下图）
Web 窗体
DataSet
Authors1
Web 客户端
应用程序
DataGrid
Windows 窗体
DataSet
Authors1
Windows 客户端
应用程序
DataGrid
XML Web services
公共接口
GetAuthors
Update Authors
私有成员
Dataset authors1.xsd
SqlDataAdapter
SqlDataConnection
SqlCommand
通过HTTP
调用XML Web services
通过HTTP
调用XML Web services
用户界面 业务对象 数据
OLEDB
2.4 视图模型建模
参考 Kruchten 4+1 视图模型，给出实习题目中系统的视图模型（逻辑视图、开发视图、
进程视图、部署视图等不少于 3 个）。
2.5 编写实验报告
结合实习案例编写实验报告，模版见“SDA 第 3 次课外实习报告（模板）-20251106.doc”。
三、报告提交时间及要求
（1）除给出“实验概况”“实验设计”“实验过程”等内容外，还应在“实验评价”
部分结合实习题目分析 Web Service（含微服务）软件风格的优缺点和适用场合。
（2）提交时间： 2025 年 12 月 7 日截止（通过超星系统提交）。
