package com.problem.designPattern;
/*
 * 单例模式：创建型模式
 * @一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建
 * @ 1:单例类只能有一个实例
 * @ 2:单例类必须自己创建自己的唯一实例
 * @ 3:单例类必须给所有其他对象提供这一实例，提供一个访问它的全局访问点
 * @主要解决：一个全局使用的类频繁地创建与销毁
 * @何时使用：当你想控制实例数目，节省系统资源的时候
 * @如何解决：判断系统是否已经有这个实例，如果有则返回，没有则创建
 * @关键代码：构造函数是私有的
 * @使用场景：1.要求打印生产唯一的序列号 
 * 			  2.web中的计数器，不用每次刷新都在数据库里加一次，用单例模式先缓存起来
 * 			  3.创建的一个对象，需要消耗的资源过多，比如I/O与数据库的链接
 * 	@注意事项：getInstance()方法中需要使用同步锁synchronized(Singleton.class)
 * 			   防止多线程同时进入造成instance被多次实例化
 */

/*
 * 懒汉式，多线程不安全，不支持多线程，因为没有加锁synchronized
 */
public class SingletonLazyUnsafe {
	private static SingletonLazyUnsafe instance;
	private static int n = 0;
	private SingletonLazyUnsafe(){}
	public static SingletonLazyUnsafe getInstance(){
		if(instance == null){
			instance = new SingletonLazyUnsafe();
		}
		n++;
		return instance;
	}
	public void showMessage(){
		System.out.println("hello world, n:" + n);
	}
}

