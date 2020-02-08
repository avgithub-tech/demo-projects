package com.avtech.springcloud.springcloudtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication implements TaskExecutionListener, CommandLineRunner {

	Logger log = LoggerFactory.getLogger(SpringCloudTaskApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String str = null;
		for(int i=0;i<10;i++){
			try {
				if(i==9){
					str.toUpperCase();
				}
				log.info("Count: "+i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error("Error while executing task....");
			}
		}
	}

	@Override
	public void onTaskStartup(TaskExecution taskExecution) {
		log.info("Task Start details....");
		log.info("Task Id: "+taskExecution.getExecutionId());
		log.info("Task name: "+taskExecution.getTaskName());
		log.info("Task start time: "+taskExecution.getStartTime());
		log.info("************************");
	}

	@Override
	public void onTaskEnd(TaskExecution taskExecution) {
		log.info("Task End details....");
		log.info("Task Id: "+taskExecution.getExecutionId());
		log.info("Task name: "+taskExecution.getTaskName());
		log.info("Task end time: "+taskExecution.getEndTime());
		log.info("************************");
	}

	@Override
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		log.info("Task Failed details...."+taskExecution);
	}


}
