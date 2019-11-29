package com.sourcecode.learning.mybatis;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {

	@Test
	public void test() {
		log.debug("debug");
		log.info("info");
		log.error("error");
		log.trace("trace");
		log.warn("warn");
	}
}
