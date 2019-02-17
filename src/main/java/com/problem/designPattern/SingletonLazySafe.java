/**
 * 
 */
package com.problem.designPattern;

/**
 * @author xiliang
 * @懒汉式：多线程安全，但是效率低。仅仅加了synchronized
 * @优点：第一次调用才初始化，避免内存浪费
 * @缺点：必须加锁synchronized 才能保证单例，但加锁会影响效率
 *
 */
public class SingletonLazySafe {
	private static SingletonLazySafe instance;
	private static int n = 0;
	private SingletonLazySafe(){}
	public static synchronized SingletonLazySafe getInstance(){
		if(instance == null){
			instance = new SingletonLazySafe();
		}
		n++;
		return instance;
	}
	public void showMessage(){
		System.out.println("hello world, lazy safe n:" + n);
	}
}
