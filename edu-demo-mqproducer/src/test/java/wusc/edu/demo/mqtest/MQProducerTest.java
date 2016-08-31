package wusc.edu.demo.mqtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wusc.edu.demo.mqtest.params.MailParam;

public class MQProducerTest {
	private static final Log log = LogFactory.getLog(MQProducerTest.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:spring/spring-context.xml");
			context.start();

			MQProducer mqProducer = (MQProducer) context.getBean("mqProducer");
			for (int i = 0; i < 1000; i++) {
				// 邮件发送，收件人的邮箱
				MailParam mail = new MailParam();
				mail.setTo("******@qq.com");
				mail.setSubject("ActiveMQ测试>>>>" + i);
				mail.setContent("通过ActiveMQ异步发送邮件！");

				mqProducer.sendMessage(mail);
			}

			context.stop();
		} catch (Exception e) {
			log.error("==>MQ context start error:", e);
			System.exit(0);
		} finally {
			log.info("===>System.exit");
			System.exit(0);
		}
	}
}
