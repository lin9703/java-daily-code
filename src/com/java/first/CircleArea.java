package com.java.first;

/**
 * 5cm인 원의 넓이 구하기
 */
public class CircleArea {

	public static void main(String[] args) {
		int radius = 5;
		double area = radius * radius * 3.14;

		System.out.printf("반지름이 %dcm인 원의 넓이는 %.1fcm2입니다.\n", radius, area);

	}

}
