## protobuf的总结

1.protobuf的原理

它是一种轻便高效的结构化数据存储格式，可以用于结构化数据串行化，或者说序列化。跟json类似，可以做数据存储或者数据交换格式

2.protobuf的使用方法

源码上下载对应的protoc-3.5.1-win32，以及protobuf-java-2.5.0-sources.jar包，之后解压缩protoc-3.5.1-win32，找到protoc.exe编辑器。

具体的例子

	syntax = "proto2";  //采用proto2版本的语言
	package tutorial;
 
	option java_package = "com.test.sell.Protobuf";
	option java_outer_classname = "ProtobufDemo";
 
	message Person {
 	required string name = 2; //必要字段
  	required int32 id = 1;
  	optional string email = 3; //非必要字段
 
  	enum PhoneType {
    MOBILE = 0;
    HOME = 1;
    WORK = 2;
  	}

  	enum Sex{
    MAN = 0;
    WOMAN = 1;
  	}

  	optional Sex sex = 4 [default = MAN];
 
  	message PhoneNumber {
    required string number = 1;
    optional PhoneType type = 2 [default = HOME];
  	}
 
  	repeated PhoneNumber phone = 5;
	}

解释：

* option java_package，导出的Java文件的包名

* option java_outer_classname，proto编译后生成的java类的名字

* message Person，对应到生成的java文件就是里面的一个类。所以上述文件会产生一个类Person，以及Person类的内部类PhoneNumber。

* name = 2，id = 1，其中id，name对应到java类就是Person的属性名，而标签数字1和2则表示不同的字段在序列化后的二进制数据中的布局位置，此值不能重复。

运行该文件

直接打开命令行，进入到.proto文件的所在位置，执行

	protoc -I=proto文件所在目录 --java_out=生成的java文件的存放地址 proto文件所在目录/xxx.proto

3.protobuf的总结

类似跟json差不多的一种数据交换格式，自带了一个编辑器。给我的感觉就是，你可以直接按照他的语法写好消息格式，然后通过命令行直接生成了java类文件，（也支持c++，python）。然后这些类直接放到项目中，我们可以再创个类来完成消息的序列化和反序列化的工作。

测试上面的类

	public class TestProtobuf {
    public static void main(String[] args){
            //序列化
            ProtobufDemo.Person.Builder builder = ProtobufDemo.Person.newBuilder();
            builder.setName("早上十点");
            builder.setId(1);
            builder.setEmail("1345095269@qq.com");
            builder.setSex(ProtobufDemo.Person.Sex.MAN);

            ProtobufDemo.Person.PhoneNumber.Builder builder1 = ProtobufDemo.Person.PhoneNumber.newBuilder();
            builder1.setNumber("12345678");
            builder1.setType(ProtobufDemo.Person.PhoneType.HOME);
            ProtobufDemo.Person.PhoneNumber phoneNumber = builder1.build();
            builder.addPhone(phoneNumber);

            ProtobufDemo.Person.PhoneNumber phoneNumber1 = ProtobufDemo.Person.PhoneNumber.newBuilder()
                    .setNumber("987654321")
                    .setType(ProtobufDemo.Person.PhoneType.MOBILE).build();
            builder.addPhone(phoneNumber1);
            ProtobufDemo.Person person = builder.build();
            byte[] personByte = person.toByteArray();

            //反序列化
            try{
                ProtobufDemo.Person person1 = ProtobufDemo.Person.parseFrom(personByte);
                System.out.println("学生ID:"+person1.getId());
                System.out.println("姓名："+person1.getName());
                System.out.println("性别："+(person1.getSex().getNumber()==0?"男":"女"));
                System.out.println("邮箱："+person1.getEmail());

                List<ProtobufDemo.Person.PhoneNumber> phList = person1.getPhoneList();
                for (ProtobufDemo.Person.PhoneNumber p : phList) {
                    System.out.println(p.getType().toString()+"电话:"+p.getNumber());
                }
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
    	}
	}

我理解的大致就是上面这个过程。最后测试出来的结果如图：


![](https://i.imgur.com/gBX2qQU.png)

	



