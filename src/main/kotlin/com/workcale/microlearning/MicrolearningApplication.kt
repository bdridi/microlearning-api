package com.workcale.microlearning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableFeignClients
class MicrolearningApplication

fun main(args: Array<String>) {
	runApplication<MicrolearningApplication>(*args)
}
