## java基础总结

* 构造器

	特点：

构造器与类同名。

每个类可以有一个以上的构造器。

构造器可以有0个，1个或多个参数。

构造器没有返回值。

构造器总是伴随着new操作一起调用。

当类没有提供任何构造器的时候，系统才会提供一个默认的构造器。

	class boy{
		private String sex;
		private int age;
		private String name;

		//构造器
		public boy(String name,String sex,int age){
			name = "张三"
			sex = "男";
			age = 18;
		}

		//Getter AND Setter 方法
		...
	}

* super关键字

	调用超类（父类）的方法。

	调用超类的构造器。

思路过程：

	public double getSalary(){
		return salary + bonus;
		//不起作用,因为子类的方法不能直接地访问父类的私有域。
	}


	public double getSalary(){
		double baseSalary = getSalary();
		//不起作用，因为外面也有getSalary方法，这样写会导致此语句无限调用自己，直到程序崩溃为止。
	}

	public double getSalary(){
		double baseSalary = super.getSalary();
		//可以起作用
	}

* 抽象类(absract)
	
		public abstract class Person{
		public abstract String getDescription();
		private String name;
	
		public Person(String name){
			this.name = name;
		}
	
		public String getName(){
			return name;
		}
		}

特点：

除了抽象方法之外，抽象类还可以包含具体数据和具体方法。抽象方法充当着占位的角色，他们的具体实现方法在子类中。

抽象类不能被实例化，也就是说将一个类声明为abstract，就不能创建该类的对象。但是它可以调用非抽象子类的对象。

		new Person("Z L");//error，错误

		Person p = new Student("Z L","L Z");//可以实现

* 用泛型数组列表(ArrayList)代替数组

不必指出数组的大小

使用add将任意多的元素添加到数组中

使用size()替代length计算元素的数目

使用a.get(i)替代a[i]访问元素










