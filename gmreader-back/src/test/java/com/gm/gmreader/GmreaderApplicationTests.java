package com.gm.gmreader;

import com.gm.gmreader.impl.MailService;
import com.gm.gmreader.impl.ReaderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class GmreaderApplicationTests {
    @Autowired
    MailService myMailService;
    @Autowired
    ReaderService readerService;
    @Test
    void mailtest()
    {
        myMailService.sendSimpleMail("1660079729@qq.com","title qwer","code : 111111");
    }
    @Test
    void readertest()
    {
        boolean res=readerService.addreader("读者3","123456","8426@163.com");
        System.out.println(res);
    }

    @Test
    void timetest()
    {
        Date date=new Date();
        System.out.println(date.toString());
    }

}
