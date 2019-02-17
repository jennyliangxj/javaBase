/**
 * 
 */
package com.problem.designPattern;

/**
 * @author xiliang
 * @饿汉式：较常用，基于classloader机制，类加载时就实例化，避免了多线程get的时候实例化同步，但容易产生垃圾
 * @优点：没有加锁，执行效率较高
 * @缺点：类加载时实例就初始化，浪费空间
 */
public class SingletonHungrySafe {
	private static SingletonHungrySafe instance = new SingletonHungrySafe();
	private SingletonHungrySafe(){}
	public static SingletonHungrySafe getInstance(){
		return instance;
	}
}
