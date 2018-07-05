import db.utiles.HibernateSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import provider.SessionProvider;
import request.AddressRequest;
import request.CommodityRequest;
import request.LoginRequest;
import request.SearchRequest;

import java.util.ArrayList;
import java.util.logging.Handler;

@Controller
@EnableAutoConfiguration
public class SampleController {

    private  static Logger logger=LoggerFactory.getLogger(SampleController.class);
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!...............";
    }

    public static void main(String[] args) throws Exception {
        SessionProvider.createSession("SandW001","890af4e26dfa446aa8d7ee7777afbfb4",50);
        logger.debug("[$$$$ Debug] init userInfo : {}","SandW000050,session is 890af4e26dfa446aa8d7ee7777afbfb4 ");
//        SpringApplication.run(LoginRequest.class, args);

        HibernateSession.getSession();
        ArrayList<Object> objects = new ArrayList<Object>();
        objects.add(AddressRequest.class);
        objects.add(LoginRequest.class);
        objects.add(SearchRequest.class);
        objects.add(CommodityRequest.class);
        SpringApplication.run(objects.toArray(), args);


    }



}

