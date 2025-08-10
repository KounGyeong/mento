package com.study.mento.scheduler;

import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.study.mento.service.RandomCodeService;

@Component
public class MyScheduler {
	
	private final Random random = new Random();
	private final RandomCodeService randomCodeService;
	
	public MyScheduler(RandomCodeService randomStringService) {
        this.randomCodeService = randomStringService;
    }

	@Scheduled(fixedRate = 60000) // 1분
    public void doSomething() {
		String result = generateRandomString();
		randomCodeService.saveRandomCode(result);
        System.out.println(result);
    }
	
	private String generateRandomString() {
        String fixedStart = "001000";
        String part1 = "WATER";
        String part2 = "CHEMICAL";
        String part3 = "MAIN";

        String partA = randomHex(2); // 2자리 랜덤 16진수

        // partB: 첫 자리 랜덤 16진수, 두 번째 자리 랜덤 0~2 숫자
        // 0~100 사이 랜덤 값 생성
        int randomNum0to100 = random.nextInt(101); // 0~100
        // 16진수 문자열 변환 (대문자)
        String hexStr = Integer.toHexString(randomNum0to100).toUpperCase();
        int secondDigit = random.nextInt(3);
        String partB = "" + hexStr + secondDigit;

        String partC = randomHex(16); // 16자리 랜덤 16진수

        return fixedStart + part1 + partA + part2 + partB + part3 + partC;
    }

    private String randomHex(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int n = random.nextInt(16);
            sb.append(Integer.toHexString(n));
        }
        return sb.toString().toUpperCase();
    }
}
