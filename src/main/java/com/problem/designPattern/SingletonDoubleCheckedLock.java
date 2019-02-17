/**
 * 
 */
package com.problem.designPattern;

/**
 * @author xiliang
 * @volatile:一个变量声明为volatile，就意味着这个变量被修改时，其他所有使用到此变量的线程都立即能见到变化
 * @双重检查锁：只在临界区代码加锁：一次不加锁，一次在同步代码块加锁
 *
 */
public class SingletonDoubleCheckedLock {
	private static volatile SingletonDoubleCheckedLock instance;
	private SingletonDoubleCheckedLock(){}
	public static SingletonDoubleCheckedLock getInstance(){
		if(instance == null){          //single check
			synchronized(SingletonDoubleCheckedLock.class){
				if(instance == null){  //double check
					instance = new SingletonDoubleCheckedLock();
				}
			}
		}
		return instance;
	}
}
