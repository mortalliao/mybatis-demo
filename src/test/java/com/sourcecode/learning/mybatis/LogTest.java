package com.sourcecode.learning.mybatis;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {

	@Test
	public void test() {
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
	}
}
