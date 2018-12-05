package com.example.spring_rest_sample;

import static org.junit.Assert.assertEquals;

import com.example.spring_rest_sample.dao.DemoDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRestSampleApplicationTests {

	@Autowired
	DemoDao demoDao;

	@Test
	public void test_auto_increment_column() {
		int maxId = demoDao.getMaxId();

		int cnt = demoDao.save("박문수");
		assertEquals(maxId + 1, cnt);
	}

}
