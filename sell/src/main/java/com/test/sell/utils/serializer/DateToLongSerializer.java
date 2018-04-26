package com.test.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @file_name: DateToLongSerializer
 * @Description：工具类，将Date数据转化为Long类型数据。如果要使用这个类，只需要在实体类上加个@JsonSerialize(using = DateToLongSerialize.class)这个注解。
 * @author: 张磊
 * @date: 四月 2018/4/24 13:48
 * @version：
 */
public class DateToLongSerializer extends JsonSerializer<Date>{
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
