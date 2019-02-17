/**
 * 
 */
package com.problem.designPattern;

/**
 * @author xiliang
 * @登记式静态内部类方式：利用class loader 机制保证初始化时，instance只有一个实例
 * Sginleton类被加载时，instance不一定被初始化，只有调用getInstance方法时，才会装载SingletonHoder类，从而实例化
 * 
 * @java静态类：java允许在一个类里面定义静态类，不能用static修饰顶级类，但是内部类可以static
 *           静态类只能访问外部类的静态成员，不能访问外部类的非静态成员
 */
public class SingletonStaticInnerClass {
	private static class SingletonHolder{
		private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
	}
	private SingletonStaticInnerClass(){}
	public static final SingletonStaticInnerClass getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
