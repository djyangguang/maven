package com.yangg.designPattern.FactorMethod;
//懒汉单例模式
public class lanhanSingletion {
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
	private static lanhanSingletion instance =null;
	//私有构造方法，防止被实例化
	private lanhanSingletion(){
		
		
	}
	//创建实例
	public static lanhanSingletion getInstance(){
		//		似乎解决了之前提到的问题，将synchronized关键字加在了方法内部，
		//		也就是说当调用的时候是不需要加锁的，只有在instance为null，并创建对象的时候才需要加锁，
		//		性能有一定的提升。但是，这样的情况，还是有可能有问题的。
		//Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();
		//语句并非是一个原子操作,在 JVM 中这句代码大
		//		 1给 new的对象 分配内存
		//		    2调用 Singleton 的构造函数来初始化成员变量
		//		    3将引用instance指向分配的内存空间（执行完这步 instance 就为非 null 了）
		if(instance==null){
			synchronized (instance) {
				instance = new lanhanSingletion();
			}

		}
		return instance;

	}
	
	 /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */ 
	private Object readResolve(){
		return instance;
	}
}
//2。如果是后者，则在 3 执行完毕、2 未执行之前，另外一个线程B抢夺到了CPU的执行权,这时instance已经是非null了（但却没有初始化），
//所以线程B会直接返回 instance，然后使用，结果就会出现问题了(因为对象还没有初始化)。
//
//还有另外一种解决方案:使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的(就是加载完毕后别的线程才能使用)。
//这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。
//同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。例如：
//
//public class Singleton {  
//
//    /* 私有构造方法，防止被实例化 */  
//    private Singleton() {  
//    }  
//
//    /* 此处使用一个内部类来维护单例 */  
//    private static class SingletonFactory {  
//        private static Singleton instance = new Singleton();  
//    }  
//
//    /* 获取实例 */  
//    public static Singleton getInstance() {  
//        return SingletonFactory.instance;  
//    }  
//
//    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
//    private Object readResolve() {  
//        return getInstance();  
//    }  
//}
//但是如果在构造函数中抛出异常，实例将永远得不到创建，也会出错。所以说，十分完美的东西是没有的，我们只能根据实际情况，选择最适合自己应用场景的实现方法。
//
//同时，我们还可以使用反射去创建这个类的对象，即使它的构造器是私有的，我们也是可以调用到的。那么这个时候我们就需要再次修改代码去访问别人反射调用构造器。
//
//例子:
////在构造器中控制一下，构造器只允许调用一次,之后在调用就抛出异常
//public class Singleton {  
//    private static boolean flag;
//    /* 私有构造方法，防止被实例化 */  
//    private Singleton() {  
//        if(!flag){
//            flag = false;
//        }else{
//            throw new RuntimeException("不能多次创建单例对象");
//        }
//    }  
//
//    /* 此处使用一个内部类来维护单例 */  
//    private static class SingletonFactory {  
//        private static Singleton instance = new Singleton();
//    }  
//
//    /* 获取实例 */  
//    public static Singleton getInstance() {  
//        return SingletonFactory.instance;  
//    }  
//
//    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
//    private Object readResolve() {  
//        return getInstance();  
//    }  
//}   
//反射的问题处理完了之后，这里还有一个问题，就是如果把单例对象进行序列化然后再反序列化,
//那么内存中就会出现俩个一样的单例对象，只是内存地址不同。这种情况我们可以使用readResolve方法来防止。
//
//private Object readResolve(){.....}
//ObjectInputStream 会检查对象的class是否定义了readResolve方法。如果定义了，将由readResolve方法指定返回的对象。
//返回对象的类型一定要是兼容的，否则会抛出ClassCastException 。 
//例子:
//public abstract class Singleton8 implements Serializable{  
//
//    private static final long serialVersionUID = 7863921642928237696L;
//
//    /* 此处使用一个内部类来维护单例 */  
//    private static class SingletonFactory {  
//        @SuppressWarnings("serial")
//        private static Singleton8 instance = new Singleton8(){};
//    }  
//
//    //测试方式,把单例对象序列化后再反序列化从而获得一个新的对象 就相当于复制了一个单例对象
//    public Singleton8 copy() throws Exception{  
//            （ByteArrayOutputStream在溜关闭之后，还会被调用，并且不会产生任何exception）
//            ByteArrayOutputStream os = new ByteArrayOutputStream();  
//            ObjectOutputStream oos = new ObjectOutputStream(os);  
//            oos.writeObject(Singleton8.getInstance());  
//
//            InputStream is = new ByteArrayInputStream(os.toByteArray());  
//            ObjectInputStream ois = new ObjectInputStream(is);  
//            Singleton8 obj = (Singleton8)ois.readObject();  
//            return obj;  
//    } 
//
//    /* 获取实例 */  
//    public static Singleton8 getInstance() {  
//        return SingletonFactory.instance;  
//    }  
//
//    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
//    /* 把这个方法注释前和注释后来运行测试代码观察结果 */  
//    private Object readResolve() {  
//        return getInstance();  
//    }  
//}
//
//最后再思考一个问题  :  是否可以使用枚举来实现单例模式?