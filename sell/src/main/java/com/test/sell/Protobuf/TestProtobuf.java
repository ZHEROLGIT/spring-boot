package com.test.sell.Protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.List;

/**
 * @file_name: TestProtobuf
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/20 10:19
 * @version：
 */
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
