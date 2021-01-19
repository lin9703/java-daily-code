package com.java.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BMI 구하기
 */
public class CheckPoint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int tall = Integer.parseInt(st.nextToken());
		int weight = Integer.parseInt(st.nextToken());

		int bmi = weight + 100 - tall;

		System.out.printf("비만수치는 %d입니다.\n", bmi);

		if (bmi > 0) {
			System.out.println("당신은 비만이군요");
		}
	}
}
