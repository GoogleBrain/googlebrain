1.生产者发送消息给activemq,消费者从activemq中读取，然后发送邮件。


2.
ativemq需要配置的地方；
需要在conf/activemq.xml  中</broker> 之前添加程序连接验证的用户名和密码；端口在61616，在activemq.xml中配置。
		<plugins>
			<simpleAuthenticationPlugin>
				<users>
					<authenticationUser username="king" password="rootroot" groups="users,admins"/>
				</users>
			</simpleAuthenticationPlugin>
		</plugins>
		
		

3.jetty-realm.properties中配置的用户名和密码是图形化登陆时候使用的；浏览器访问时候的端口为8161，在jetty.xml中配置。

