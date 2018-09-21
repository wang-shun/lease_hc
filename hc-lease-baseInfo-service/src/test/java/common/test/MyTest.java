
package common.test;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.baseInfo.service.*;
import com.hc.lease.common.core.constant.RuleType;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.file.UploadService;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/*.xml"});

   /*     LeaseCarBrandsService leaseCarBrandsService = (LeaseCarBrandsService) context.getBean("leaseCarBrandsService");

        LeaseCarSeriesService leaseCarSeriesService = (LeaseCarSeriesService) context.getBean("leaseCarSeriesService");

        LeaseContractBaseinfoService leaseContractBaseinfoService = (LeaseContractBaseinfoService) context.getBean("leaseContractBaseinfoService");

        LeaseAreaService leaseAreaService = (LeaseAreaService) context.getBean("leaseAreaService");*/

        UploadService uploadService = (UploadService) context.getBean("uploadService");

 /*       LeaseCarModelColorService leaseCarModelColorService = (LeaseCarModelColorService) context.getBean("leaseCarModelColorService");

        LeaseCarModelService leaseCarModelService = (LeaseCarModelService) context.getBean("leaseCarModelService");

        LeaseCarColorService leaseCarColorService = (LeaseCarColorService) context.getBean("leaseCarColorService");

        LeaseDealerService leaseDealerService = (LeaseDealerService) context.getBean("leaseDealerService");

        LeaseRuleService leaseRuleService = (LeaseRuleService) context.getBean("leaseRuleService");
*/

       /* List<Long> ids = new ArrayList<Long>();
        ids.add(2l);
        //leaseCarSeriesService.findByBrandsId(ids);
        leaseCarModelService.findBySeriesId(ids);*/

        //leaseContractBaseinfoService.findPage(1,3,null);

        /*
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("ruleType", RuleType.TYPE_DEFAULTINTEREST);
        List<LeaseRule> leaseRuleList = leaseRuleService.findAll(paramsMap);
        */

        /*
        LeaseDealerService leaseDealerService = (LeaseDealerService) context.getBean("leaseDealerService");
        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);
        leaseDealerService.deleteBatchById(ids);
        */

        /*
        leaseDealerService.findPage(1,2,null);
        */

        /*
        LeaseCarColor leaseCarColor = new LeaseCarColor();
        leaseCarColor.setName("棕色");
        leaseCarColorService.insertSelective(leaseCarColor);
        */

        //leaseCarModelService.findPage(1, 5, null);
        //leaseCarModelService.selectById(1l);


        /*
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("grade", 1);
        PageInfo<LeaseDealer> page = leaseDealerService.findPage(1, 5, paramsMap);
        */


        /*
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("isEnable", true);
        //paramsMap.put("model", AreaModel.MODEL_DEALER);
        leaseAreaService.findAreaByEnableAndModel(paramsMap);
        //leaseAreaService.findAll(paramsMap);
        */

        /*
        Map<String, Object> leaseCarModelMap = leaseCarModelService.selectById(26l);
        LeaseCarModel leaseCarModel = ConvertMap2Obj.toBean(LeaseCarModel.class, leaseCarModelMap);
        */

        /*
        leaseCarModelColorService.insert(new LeaseCarModelColor(1l, 1l, new BigDecimal(1000)));
        */

        //leaseCarBrandsService.findPage(1,2,null);
        //leaseCarBrandsService.selectByPrimaryKey(1l);

        /*

        //内容
        StringBuilder builder = new StringBuilder();
        builder.append("<html><body>你好！<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp附件是个人清单。<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp其中人信息；<br />");
        builder.append("</body></html>");
        EmailService emailService = (EmailService) context.getBean("emailService");
        emailService.emailManage("1392125517@qq.com", builder, "test");
*/

        /*
        System.out.println(leaseContractBaseinfoService.findPage(1, 1,null));
        */

        /*
        LeaseContractBaseinfo leaseContractBaseinfo = new LeaseContractBaseinfo();
        List<ContractPartyContactAddressVo> contractPartyContactAddressVoList = new ArrayList<ContractPartyContactAddressVo>();
        contractPartyContactAddressVoList.add(new ContractPartyContactAddressVo("广州天河区", "543100", 0));
        contractPartyContactAddressVoList.add(new ContractPartyContactAddressVo("广州白云区", "543101", 1));
        leaseContractBaseinfo.setContractPartyContactAddressVoList(contractPartyContactAddressVoList);
        int row = leaseContractBaseinfoService.insertSelective(leaseContractBaseinfo);
        */

        /*
        leaseAreaService.findPage(1, 2, null);
        */



       String filePath= uploadService.base64UploadFile("/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAUDBAQEAwUEBAQFBQUGBwwIBwcHBw8LCwkMEQ8SEhEPERETFhwXExQaFRERGCEYGh0dHx8fExciJCIeJBweHx7/2wBDAQUFBQcGBw4ICA4eFBEUHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh4eHh7/wAARCAIRAgADASIAAhEBAxEB/8QAHQABAAEEAwEAAAAAAAAAAAAAAAgBAgYHAwUJBP/EAFgQAAEDAwIEAgMICg0JCQEBAAABAgMEBREGBwgSITETQVFhcRQiMoGRk7HRFRYXGCM3VnOhsjM0NkJSU1RVcnSSweEJJCVDYmODlPAmJzVERUZkgoSi8f/EABcBAQEBAQAAAAAAAAAAAAAAAAACAQP/xAAdEQEBAAMBAAMBAAAAAAAAAAAAAQIREjETIUEi/9oADAMBAAIRAxEAPwCZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAALZHtjbzOVET0quEML1fulovS8cq3K80ySxIqrE1+XAZsCMt14rrd7oxadM1tdD5Pai9Tr3cUWo5OtPoKsXPwW+G7qBKoER3b97rXVyrbNAVLFTyWJ3RfaWS7k8RM+JItIORF9MaooEuwREt27O99oq/FvGjHSteirhsa5x8p2C8UWoLfIjbpoetjRFw53I7AEqwaE05xQ6HuCtZcGVNtk7O8aPCZ8zbWmdZ6b1HTNmtF2pqlHJlEa7r8gGQgo1UVMoVAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHyXa4UtroJa2slZFDE1XOc52EQDnqJWQRLJI5GMTu5eyGkdz9/7Pp+ofa7HFJdLiiqixxtRydzW+7O62qtf6h+1Tbts/uaR3I6pY5URU9qGxNkNkaHTMLLlqBja27SJzSOkTmRFVPLIGsJr9xB7hSPp6OmWzUMyY6orVRpkeiuGCjnVtZrK5Vdyq16yIsy4ySZgpYadiMhY1rU7IiYOdG4AxHT23WkrLQx0lFaKdrI06Zjaq/H0O6SzW6JEayjgRE/3TfqO1wHNQD4qemp4U/B00LV9KMRDmSNqr2wc6NT0FETAHG+mhcnvo2rj0odPcdN2W4Z92W6ml5u+Y0wp3xZyZ7Aa01LsvoG/RubVWSnjVevPExGqimmNY7Baq0jVfZfbe9S/g+vud71TPoTCdyWSsQo5oEWdEb/AN+0xcGWbci0y0rkwnuhrFRPjySO0rqqy6nt7K2z1sVTG5M+9cmU9qHWa50FpzV9EtPd7dBNlOj1YnMnbz+IjdqHaHcHbGukvWhbtU1Nua9ZFh51w1vsAmAi5BH/AGO39p9TV62DUUT6K6Rryr4nRHL9Zv5r0cmU7KBcAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABRy4TIFs0jY2czlT41IucReua7WWoqfbnSFV4j5JuWrfGuFYnZU/SZjxSbnJpayNsdqkR91r0WJjWr75qORUyfBw0bQRWGmZq2/I6qvFd+Gc569Wc3XHpAzrZja2zaCsUEEMKSVis5pZn9Xcy9zY6JgRs5W4zkuwBUAAAAAAAAAAAABY9pY+JsjHRyNRzHJhyL2VDmAEfd/tkorqq6j0e1KC7wJ4mIsN8XGV7J59Bw4bxuv8AUu0dqTMF7pV5MPTDnKi46m/5WI9ERU9P0EXOJ/bWXT87NxtI88FdSSJJULEmFcideoEpGqXGreHjcGLXmiaarkkRa2NiNmTPXKG0UAqAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAdBrzUtFpTT1Tdq1URkUaq324O+c5G91wRN4mNR1utdeUW3dmnd4TZEWoVi9V69U/SB12zmmq/drdGr13fMuttNI5KRr+zkRehLyljZFEyKNqNYxMIhjO22mabSWmKW00caMSONvMqea4MoYvUDmATsAAAAAHS6j1VYdPSQR3i4wUizqqRo93VVA7oHDR1NPV07KimmZLE9Mtc1coqHMAAAAAAAAAPgv8AbKe72WrtlUxHw1ESxuaqd0VD7yjkyBD7aWefaLfS46Zr5uW3XGRVpub3qLlUwTAie2SNsjFy1yZQjXxraaqUsVBrS1U6rVWyZqyOamVRuc5NrbD6tTVu3VuuDno6dsbWS+lF5UA2AAi5QAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHSa6uLbRpO5XJXcqwU73NX14I4cIdkXU95vG4V15n1E9S5sXOmcJ3z+kzfjL1I+0baLboJOSa4u8FMd1RcHecMWnXab2roKWbHjTIkz+npToBtRrfShRrffZLmdiqAVB8l4nmprbNPBH4j2NV3L6cJki1oniE1Nct0I9MXKjjbE6qfErERUVEyBLAFkb+ZiL54PiuN1oLbypXVsEKvXDEe7CuX0AdgR14utrtVa6ZQVmn8Svg6KzxOUkPDIyWNHsVFRS9eqYXqgGt+HbTt90ttzRWjUGfdcTeuX82PVk2QWNRETCF4AAAAAAAAAAAY/ryyw3/AEpcbVOxr456d6YX046EceD66zWPV2odBXCRyNp5HPga70c2CVrkRUwvZeikRYnU+nuMGRkqpGytjXlTHdVUCXYLaf8AYWnIBaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA8sAARU405nXHWWkdOJ1SSdsip/C98SO0vSMoNP0FOxnLy07PoIwbvzSas4orNaKVVlZbXM58JlEwuSWMLFaxrfQiJkDnj7HIhRiYQqBR7UexWr1Re6elDDodttHQaj+2CKzwtr8q7xUTC59JmQUC1qYTBFXjcudfbrrp2SJ06QNn55Eiz0xjquCVeDrb5ZbVeI2sudBT1TW5x4rEXAGqNiN4LRrSeOyUMdR4kESNWR7eiqnc3UYxQWXSumJnz0VDQ0TpFwrmIjV9ZkFJVU1UzngnjkRf4LkUDnAAAAAAAAAAAAACIvFfQVult0tO66pmKkSPa2VVb2w5VJdGv8AfTQke4Oip7RysSdqK6Fzkzh2OgGSaHv1PqPTNFdKZ7XNmiRVx2zg74iFsHuNc9utQrt3rNy08LZPDge9MImOmc+hSWlFVQ1cDZoHtfG9MtVFyioBzgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAfLd5/ctsqalVwkUTnr7ERT6jBd8tUUmldurlX1UzGK+F8caO/fOVOwGhOF+Fupd7NUannYkjIZVbGq9cZ8+pK9vRSNfBHp64UVouuoKtj40uM3PGjk6K30oSUTuBzJ2ATsAAAAFH/AUqFTIEcdfbJ611Xqiask1pU09C9/OyJHua5nqwbS2i0P8AaRp9LZJcp7jK12VmldlTO8dFONGrkC5ucdy8InQrgCgAAAAAAAAAAFMFQBqbfjaS27gWt0jImU10iTmiqI2oi5Tt1NR7P7p3rb7VH2g7gK9iMk8KnqH5w70dVJaKmUwpqjiB2qode6ekmp42w3anaskEzUw7KesDaFHVQ1VOyeF7XseiKjmrlPlPoQjHw0bn19FdX7e6vk5K+ncsUbpXY5sdu/mvQk23CplOwFQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACKfGFcXam1bYNEW58j5PHR00TV6LnHRST17uFNbLbLWVMjY2RtzzKuEInbCUFRr7fK76wrUdNR0UzkhVUVUXrhMASc0NZoLBpihtkEaMSGJrVRPTg71EXJViJk5FQCqdgAAAAAAAAAAAAAAAAAAAAAAAAAACplAAI3cT21kqJJuDphrortQp4jkiTHMmevYzThx3Ph13pxkNSvJcqdqMmYq9comP7ja1dAyppnwSsa+J7Va9qplFRSIGu7DetkNyZNW2JiusVZMqyxo3DWer9IExgYvt3q+h1jYILrRSxubIzK4d2XzMoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAfDfrhT2q0VNwq3oyGGNXPVVwBori911Ja9OwaUt6PS4XSTw0wnVG9E/vMx4fdEU+jNAUdM2NUqJ40kmVe6uXqaK0fBWby70Sakkgc6zUE3K1F+CmE6/pTyJesY2NjI2JhrEwiAcsPrOUsjTCF4AAAAAAAAAAAAAAAHT0gAAAAAAAAAAAAABex0estO2/Umn6q03KFssMzcYd5Kd4FTKKigQ405U3vYXcxLbVeJPp64OTwnq5eVqejPp6kurNcKe6W+GtpZGyRStRyKi5Nd7+7es1xoiroGtb7qhb4lM/zRU64Q1twi6/qI/dO398fJ9kKJ/hxI9MLyp2Ak0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABGvjG1vVx2+l0RZnuWvuT+SRY16o3p0N+6uvNPYLFVXWpkSOOCNXKq+nyIqbEWiq3R3YueubzFI+jp5MU7np73oqphEA3pw96Ig0Xt9SUXKi1Eread2MK5xsljMrkrDE2KNI2JhqIiIhyImAAAAAAAAAAAAA4K6rgoqWSpqHoyKNvM5y9kQ0hqniZ0haK99FTwzVcjFVHPjaqomAN7AxHbDX9k1/YG3a0yLy9Uex3RzV9aHXb1bi2zb/S1RXVU6R1T43Npo1T4b8dAOh3w3ptO3cbYYmNr7g/P+bxu6p39XqObYveS17mQyshj9zVcP7JC53vk7er1mm9i9A1OvNT1O4OronO8Z7n08bl6K1V6d/LqYDpTXtt2v4gbxJHS/6PlqHMc2PuiZ9QE+QdLpDUNv1NY6e7W2Vr4ZmoqIi9UO6AAAAAAAAAAAAAALZGo7opE3iP07JoDXls3EsUCo3xUWqRPRnqpLQxXdLTdNqrRtbZ6iNHJMxUauM4d5KB9egdR0uqtLUd5pHIrJo0VcLnrjqd+Rd4SNS1Nj1FddubtIiOpJnOps9M58iUKLkCoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAfNWzx0sMtRK5GxxtVzlVcYRAI9cYuq3rbKDRlse5ay4Sp4jW/wfJPpNm7G6Ti0joK329I0bL4aOkXHdcEftNMm3O4l5rxNH41qtrlSNf3vvcoifKhLqNiMjaxqYRqYRAOdFyVLWlwAAAAAAAAAAo5eViuxnCAaG4v8AV77RpGOxW+VyV9ycrWo1f3vTP0nU7V7O2Wy7XT3G60kM9yqaR8kjpW9UXGTC9XVUuvuKaitnI2Sktj054/3qJ5qSE3bfV0m2N3S2t/De5nMia1F6dFTAGieEzU1t0lpfVNTcqiGOGCsVGtc7qvfoh19ut92353WS6VsT005QSe9av7G7C+RgezuzmstTVL/si51vtU8ySTNVVR0q5Js6J0xbtK6ep7TbYUjZG3Dlx8JfSB1+qq63aH0VVzwRRQUlBTryR9s4b5fIRN2i2+ptWaa1jrO8Uz3yVPiOpVd5OTrk2BxN6iumrNVxbbWSkqEzM1KqTlVE+Enn6OuTK9Ytp9p9gKq3+9dVeCsTE5vfPcqJlUyB8HBDcamo0bcqKV6q2mm5WZ646kjsHn7sVufqDbh71q7O77H3CVHPle1cNT2+ZO7TF1gvVkprlA9rmTxo9OVenVAO1AAAAAAAAAAAAACydvOzC9i8ARA4g7bU6E3zsmrLcxI4K2ZrZEROndMovykr7HVtrbVS1bFyksaOz6cpk0pxnafSv0DHeWve2SglSTovoM42BvTb7tZZa/OZFp2sk9St6AbDQFG9ioAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADT/ABU6uTTe3dRTQyK2qrl8KNEXqvTqbgIib5PqNe8QNs0pSytlpqJWulaqLy+sDaHCro37Xtu4KyrixW12ZnuXv77qhuiNOmVPgtNLHSW6mpIWIxkUaMRE8sHZJ0TAAAAAAAAAAAAD471VsobVUVUjuVkbFcq+hEPsME36uDrZtbeaprlarYcJhcdVVEA0Twm0Tr7udqrVc8aPa6oekcn+zzKSmfTRSRrHK1HsXui+Zofgdoli2tmrnN61VQrkcvdc5JAgcMFHSwtRIoGMRO2EOV7OYuQqB09XaLVDVS3V1FClRyqss6tRXKiev4iJevr7cd6t0aXTFqhetjt1SqTS4VEznHcmPVxpLA+NyZa5qtX40wYLa9K6X0Nb7jcqakhp+ZHSyP6N9vUDTHFrQWmxbY2nTNDBD7qfKxkHKmF7m7di7bVWnbKzUdYq+K2BMovdCN2nlrN7N8lqpXPSw2WTMbVVVa53q8iYtJCynp2Qxt5WsaiInoQDlAAAAAAAABRyo1MqWxyseuGqi/GBeAAAAA13xEU3unam8sWNHo2ne5c+XQwPgjuC1e2TqRzubwJnJ7PUbX3agZU7b32GRMotG/4uhprga97pC6sTsyrwgEjgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHRa9vlPp7S1fc6mTkZDA9yelVx0QjtwpWap1Fq29bg1yc7aiVzIHO6rjK/3Hb8b+o5aXSlu09Ry5nuMqMc3OFVMmxOH3Tv2ubY22idD4cj2JJJ61UDYseGrnBzIcDU6nMnYCoAAAAAAAAKOXBiuvte6c0Xb3Vl7r4oWomUbz5c74gMnnmigjdLNIjGNTKuXshG3ii3QtNdZ5NEWZ32Qr65eVfc683Lhc46ewxfVu4uvt3Lktq0FTzUtrVvIs724VyL3+gz7Zjh+t2lquO9X+o+yN0wqq5371VyBlPC5Ya7T+1NuobhA6GdG8ytVOqG1Thga2KNsbEw1OyHMBVCpRDirKmKkgdPO5GRtTKqvkBdM9rGKrlwmM5IrcQe41Xq+/fc40o19QsjvDnmhXKNXOM9Dud9d6H1NYmkdCq+ruFQ7wZXtauI+qoqZMj4fNpKfTFEl9ujWy3mocr5Hr15VXC4AyvY3bqi0BpSGhg5XVMjUfPIvdXGxUU4movkXt8wLwAAAAAAAdbqZ0sdgrZIV/CNhcrfaaL4V9cXzVV+1FR3WqfL7knVI0X1Kb31F1sdanpgd9BF/gr/d3q/y/Du/WAleAAAAAx3ctvNoG9p/8OT9VTSfAz10jeXemtX6Dd25H7g73/U5P1VNJcDP7jrx/XV+gCRoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFry4+DUNbFbrJWVssiRpDA9/MvlhFUCKm4sT9wOJyhssj0dT2xWvdEvVPeuVVQlhSQMgpIoo2o1jGo1EIrcKUdRqfdPUurKpvMizOjje5P9rrgllhERETyA42plTlAAAAD4r3cqe0Wye41bkZTwMVz3KuMIhje3OurZreglrrUj1hildGrnL3VDD+La9utG09bHHKrJatFiYiLjmU+bhCta2/aOke+JY3zuWRUXvlQN0Nd6T5rjcaO30klVVzsiiYmXOcuENdbtbw6a0JQ/hZ21dc/KR08TsuX2pgj/AElRuXvld/DqI6i0WFzv4PLzNz2+TAGdbscQLalz9P6GpJa6skVWJUMd0YpieidktT62u8V813d53w8yO9yvVV+Lub0222i0roy3wx0tI2apRMvmf1Vy/GbJiZEjEa2NqY7YQDG9I6RtOl6SOhtVLHDExMdGmRqiIXK30IVVoFiF73Ixquc5EanpMG3l3CoNu9LSXWqj8aRy8kTPSvT6yOP2474bpypHZ2Os1ulXLZMIiY9oEktb7oaO0pRSS3S6wtkYi/gmuRXKqEdbzr7Wu9WoZLRpSOehsTU5XzJn3yZ6qZRovhhoZZ23LXN2nu9W5edzeZUaqqb10npSyaWpI6SyUbKWGNMI1qfSoGDbPbOWTR8Hu6oatddJOrppUyrXerJtaONGNwiHOi5TsUwgBidCuCoAAAAAAAAA+DUH/gtZ+Yd9BF7gqXOt9YeqoVP/AOlJNavekemri93ZKZ6r7MEbeBikc6t1TcVVXJLVO6r/AEgJUAAAAAMa3Rl8Db2+Sq3KNo5M9fUac4H4Vi0Xc35yktW5ydDYfEZXuoNpr05qdZKdzO+O6GHcFlMsW08NQ5MLPI52QN7AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaf4s73Nadp6yKnfyyVf4FPWiobgIucbdxqfdembG1fwdRUorsL2XqgGd8KGkU09trR1b2YlrmpOqr6VQ3Ohj+gqdlFo61UrU6x0zEX24Q79rsgXAAAAANLcWOib5rTRtPT2GPxamml8Xkx3waWt2tN5rRpmHTNv0tLAsLfCSdGd09JNHlQt8GHziYvtQCL+0exl7rrtHqnXiNqKt686QzKi8vXPbJJSgoYKGnbBTQMhjb0RGphD7+mMImECgcPLgqxFRyHJgYAqdFrfU9s0rZZbnc6hkMTGqvvnYVfUhTWup7ZpazTXO5TsZHE1VxzYVSJFwdq3iB1o6KFk1PpyF6NVf3vKn09gK3Os1Nv/r+nZDBIzTNJNlrlRMOwvp8+xLbTVmpbPZqa208bEjgYjUXl74TB8m3ejrdpHTlPbKKFjEY1Mq1O6mToxEQCkae8QojevYvRMFQKImEKgAAAAAAAAAAABj25TnN0Fe3NXCpRyfQaU4GYPD0ZcpsfslS/41yba3rrfcG1t/qM4xSPT9Bq7ggj5NsJJVTCzVD3r/aAkGAAAAA07xevc3Zm6o3zYifpOXhIpmRbJWGZnRZIFV3tydZxmTe59mrkufhPad5wo/iJ0566fP6VA2oAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABEriud7u300ZbV98niNVW+n3xLUiJvLJLc+LjTlJ8JkKxq1PR1UCVdqg9z26nhXCK2NPoPtanQ4XL1THblQ5ok6ZUC8AAAAAAAAAADF9xNaWfRtjmuF0q44Wo1eRFXq5fQh2Wrb7Q6bsVRd7jKkdPTsVzlVcZ9RECFuot/tx0knmfFpmjlV3K5vRyZ/vA5fC1nxB6i8WR8lDpyF6oidUSRP+kJT7b6TtmkNPwWu2xtjSNuHK3997S7Sem7dpy1QWy1UzaemhbhGonc76nTCgfSAAAAAAAAAAAAAAAAAANScWtY+j2Vu7mOxzs5V9h1vB9QPpNlrVLImHSq53tTJ1vHBdXUW1D6NmeaqmRiKhnPDtQvodndPU728qpTIuPRkDYcfVMl5RqYQqAAAGiuNRM7PV/8ATaZHwrNczY3TTV/kqL+lTFeNyqig2jqo3rhZZWtb7TO+HiNkOzumYmNwiUDPoA2CAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABEHUuXca1vy5VwjE6r61JfEQdSrjjVoF8veoBLdjcnOnY4WdjlQCoAAAAAAUVyJ3UCp8lyuVFbqKWsrKiOGCJquc57sIiIfPfr1brNQS11wqWQQRNVznOcidEQh9rjW+rd7tXO01pNtVSWFr+SZ8eUbKiL1VVT2gdjuTqnUW+mtm6M0x4kVhgkxUVLEVEdhevVMpgkftloa06K07BabdHhY0w969VevpyfNtDt1aNA6fhoaCFqVHKnjSqmXPX2mcNaqPRcAVSNEbgRN6qcmchAAAAAAAAAAAAAAAAAAAAjBx1VSrabFao0RVmqUdyr59cEgNuqb3HoezU69FZSRpj4iL/FvVyV29uj7R0SNrkVzU6ouXKSvsjUjttLG3skLUT2IgHYAAAAAIw8e1Q12l7Pa2u/CVVa1Piyb12poW2/b+yUre0dHG1Ex/soR041JHV2utJ2uNUeqVLOZqL2RVQlJpuFsFgoIW9OSnY1fiagHYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAARC13G+28YVqrKlOWGVzeV/l1yhL0jvxg6VkdaaTWdvYqVlre2RXN+EqIBISLlfG17eqKhyIa92L1tBrDQtBVI9HTtYjJevng2EAAAAA4K2rp6OB09TI2ONqZVzuyAc5jOutYWXSdpmuV2q4oo4mrhqvRHOXHZENW7scQ+nNP+Lb7LO2uuHVqMj99h3yGstI7b623gvaX/WtdPS2t6+Kyn7Jj0YX1AfDe63Wu++oXQW109Bp1kqokquVEe3z/wCvWSW2n2/s+hrFDR2+GJJORvivRqZcuO+TvdLaYtOm7PFbLTTNhhjbjoiJlfT0O3jjVFA+hvVCpaxMIXAAAAAAAAAAAAAAAAAAAAAAER+IG2VlTxRaZlipZZKZImIrmsyiLzkraRro440Xyahx1tot1ZWRVdRSxvnh6xvVvVD7XIiqgFwAAFHLgqFAh7xCc9dxM6cpvDfyxuj646fC/wACXVtby0MLc5xGh0t40dYLleobzV0EUldEiIyZWpzJj1nfwJyRoxE6IBeAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB1Wq7RT32xVVrqmI+KeJzFRfWmDtQoEMLdcdTcP+vJqavgdUaerJlcxzW55UVSUWh9wdM6ut7Km03KGVytRXM5kyiqmcH16z0lZNV0KUl4pGTsRcoqp1NC6j4ZnUVxfXaNv9TbM9WxteqIiqoEmmPa9Mt6nHU1MNNGsk8iRsRM5XsRMftvv7bpFjotWPnib0RXPVFx8pwU21++N+k9xXrVU9PSuTCuY7r9IG7Nfb66H0rC5q1yVlXnDYYUyqmibtrHcneutfQ2SlltdpVeV78Ki4zjqptXRXDhpW0Ninuqy3SrVEdI+V2cqbcsemrRZYmRW6kZAxExhqIBqPavYDTmk1bWV8LbhXPRHOfMnMiL8ZuijpYqWNI4Y2sYnZGphEPr5clVanoANToMIVAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4aydtNTSTORVRjVdhPUBzAjbrfir03YbhNb6O2z1M0Lla7K46ovmauv3F/qmofIlttMNM1ejVV2f0YAnGUV7E8yCG13EPrufVTW3meqrKWfojGt6N/QYhq/ebcaPW01PDqi4w061PvGNdhGpzdsAejyLkqRa3J4h7jo63WWlo6CWrqZaaOSZ8/Z6qidl8+5tzZbdOz7iWdk9JKyKramJYebq1fPoBskZRO64LXO5WqpCHiP3S1dZd062hsuoqunhi5fwcT/eKuewE4OnkoNf7H1t5qNu7bXagqfGqZ40e57l69TX/F3uTWaK07RU9luDqatqZUc7w1yvJleoG/1TJUjbwi671ZraOtqNQVnjQwu5WK/zXGUJFpUw/wAbGvsegFXsRFyiF0ceeqlUe169PIqq4aqgPglcmmuJjci4aK0yi2elnkqJc/hmNyjE6er1mmtneKKsS4QWzVi89O9elQqYVF9YEzEKnT2C+2q90cdXa62OqienRWLnHtO2RQLgDSXFZuhe9s9OUVfZoIZpJ3qxySdk/QBu0Hn0nFjuQ5EWOmoET0JHnH6DkZxa7kRuRX0tvX0c0X+AE/wQEXi83IRyp7mt3T0Rp9RZ991uL/JKBfZGn1AT+BgeyOpq7V+3Fsv1xRqVNTHzPRvYyTVd4g0/p2su9W1XQ0saveiL1VEA7gEZ6ri30bTScjLXVP8ASqqnRfkPnfxg6QT/ANKqk+NF/uAlACLbuMTR7cf6Kq19mA3jH0iv/pVYnxIBKQGttlN0rbubR1VXboJYUgciLz+Zm9/vdssNI2qulXHTROdyo564TIHZFFc1PMxB252g2/C1Pb0/4hFzij3nulFrimi0VqNW0zI2uc6nXLXZ8s/9dwJpIuSpHPho3mdfNNSS64vlFBUMXEXO/DlNvruZoRP/AHNb/nUAy0GILufoL8p7f86hkNlvFtvVElba6uKqp1VU541ymfQB9wAAAAAAAAOGtl8ClklVejGq5fYhCjdTfzVVDufVR6crFdRxzpFHEi+9f1wuUAm6Uc5G4yvdcGhtQ75ppDStoqtQ0iOr62Fr3MY/HLnz7GF77723er25t1+0ZVPonSzYeqonMqASuBGLgv3A1RrSovLdR3F1YlOiIxXeSEm2vaq9HAXA1pv3uU/bLTbLyyjSq8STw+VXYx6/0mh/vxp/5hb/AG/8AJh5RO6ljZYnfBejvYQt1DxbVVxtdZRR2fwXzROa2Rr+rVx08jUWnd6Na2vUzbrJf7lUQMXmdAsuUVPR2A9MUXPYqQ2g4yViiaz7XeZUREVedUz6+xe3jLfI5Gt043K+mVfqAmMDEtrNVfbloqg1B4LYVqWcyxt/emWIBUAAAAAOGsWJtLI+ZcRtTLl9RzHX6jjklslZFExXvfC5rUT0qgEVNdaA2bu+prhdavWdFBPPI5y06S4VrlXt1Io6npKGi1jWUlBUtqKKKq5WSNXuzmNsao2M3Mq7/XVEVmY6OSZzmr4ydUVVU03fbTXWq+VNrqo+WoikWNzf9rPYCfG3VbtLatG29Ya2yQ1qUzXKqvTmR2E/SQq3VqKaTda41FJJFJTrV8zXsX3qpnyO/suxO6VwtkNbSWJzoJmo6N3id0XsYLq/TN60tepbVe6ZYKuP4Tc5xnsBL3XP3N9bbSUFFU6mtEd2paVnhOWZqK16InRTpOFfS1p0/qdtaurKKerl97FSQyc3P39BoSw7Pa0vllju1HbmOpJMKj3P5UNt8PW0uurLuZarnWULWUUDlV8iPRUblAM24xdfao0xfbZT2W5zUsUsavejV6Kv/SkVaqDVWpK6W8S0ldWzTrzLM1iv6+34yQPHl01DaPVEqfpQybhv3H28sG2FPbr7XU8VwRzl5ZGZVF8gNC6U3S1zbr1a7dVahraejglZHLE9ccrE7pg5OIDWj9b608Kn56mGnYkUTm9ebovX5VMf1o2m1NuhUx2l8fg1lcrGPRenvnGy9LbZwbd68gumt6qFtqpo2zsci58RfQifEBgGn6fcq10DvsPR3alhcvN+Da5Ob19Dih1pr+O9xUVXfrnTyLIiPY965Tqehegb3p/VFigrbKyGWnXCtyxMonxEEd80aziDr4WI1rUrv3vbuB6FbeLK/RdqlnkWSV9MxXPXu5ceZ3zm5Qw+hrJbNtmytYqc1Nb0ezmTplGoRp0XxN6qvGt6PT9TR0r4amrSBzo1wvKvoAk9qldKXKhmtl4qKF7HphWPenQhzxCbB1Fqjl1LpFXV1vcqudHE1FVienp5GHcTt6ulNvPe4KeuqI42OaiNSRcdiaGw0LavaO0JUfhEmpkR/N1ynUDRXBZbtaMuEkznzQ2iNFRY5e719RL5tVGita92FXzd0OmbQRWi1TNtNMyJ7GOexrUxl2OhBfX28Ov6Lcd9Pc66bFHUYdE3omEUD0JyRb/ygSc2kbY3+DNn9Cm+9uL/AB6l0hb7vGq4nha7CrnHQ0Fx+Kq6Utv+1Nj9CgRg2i1rp3TVLOy96YhvDlX8Hz/Canct3a1VY9VSUUln07FaGRNVH+F2cnl/ec+11x2/tiSpq62VNemMtSLHT5T594Lloe41NHLou01FujY1UmbK/PMvpA7zbPcPR+mLIlvu2kYbrU5dzTPTqnXt29Zh+4V8tGob9JX2u1/Y2F/aFOydMGV7S33bC3W9I9XWWqr6znX30bkRqoYnuHWWKu1PU1WnaF9FQyOyyJy5VAPQXhSXm2TsWf4n+9TId9VxtRqD+pv+g6LhVa1uydiwn+p/vO534TO1V9T/AOK/6FA80dEWF2qtcUdjdVLAlVUcnOvXGVJQs4PoXuRq6kXqmffRIR42XraW37vWmsrZmQU8VWivkcuERMoehjN19AO/9y0HRMfsiAaFXg5o29tS/LGho7iH2nbtVd6KkbclrG1MfNnkREQnW/djQDXY+2Wh+dQiVxwarsmp9QWmWy1kdXHFAvO6NUVEyBsn/J9qn2AvDfRIn0GxeK3SepdZ6PprXpxnPUNmV7uuMJhDW/8Ak9sfYK9d/wBkb5eolNX1EFJTuqKiRsUTEVXOeuEQDzj1Lsnr3T9mnut0igighbzOc6XGTWtoo6u83OC30yOknlfyRoq5JAcXe8T9RXZumrBKnuGJHNle1fhL0/xNC6Vt95uF0YyxRyPq2LlOT4SewDacXD1uLLE2SOOHlcmUzOiKXfe5bk+SQJ/+hPrOmfb96Ecrc3rp0TD3J0OrvVTulaKZai6Vd4p4mrjmfK9EAy1OHHc1zFa1sK+yfOP0kveF7R160NttHaL4iJUrM5+EdnGTQHBDqG+XrWNfR3K7VdUxIcsbJIqonYltrW/w6Q0vVXyriWWClYr3sb3VAMha7JcRfXjE0i1zk+wld0XHdPqH35Gjv5lrvlAlACL/AN+Ro7+Za7/r4h9+PpDyslevxp9QEoARf+/G0l/Mdf8A2m/UZDt1xJ2DXeq6bT9vtdVBPOjlR8ipjp8QH38U+6tLonS8lspZOa51kbmRox2VZ5ZX0EQ+HjTb9abo061uJWU2ampc74K4XK/ScfEc+/JufdGX13M9JV5E7ojM9MGS8JEFdPqK809tejamShe2NV7Z6AdLxPaqbfty56KjevuKijbA1vdvvcov0GJ1WrK+q0dT6bfHGlLTP52u81U2bpjZLUlZu1HS6koOejkkSSWXPvXpnr+gyHi8240xo6xWussNvbTySyL4jkX2/UoGn9sdztQbdR1iWByNdVL7/mTKYN47Cb+671VuTQWa5vhWmmRUdyt7e06Hg60BpnW32Xbf6NtSkGOTPkuSUGk9nNCaVusVztVpjjqo/gPVcYAyXXGlrLq+1Nt18o2VVPnm5XdskOt66vROjNb1Nit+iKCRIVxzOc5ObsTiynI5VTOEyQg4hdC3m+7p3S40VRbEhdKioklY1q9k8lAwO8Xy21dmqvA26gpnSRripajveevKmtrG9I7vDI6nSoTv4SplHL6Da1ytm5FBpuro3Xe0LQNiVJWNqGOdy/Ea0sEVY28RMt8kbalHIrFf0TIGezX2126ijkrtuI2I5VRHua5EVfUbF4dqLQ242qJbbVaRoYmRRo/o5VXuYLqXT+5GpqGKmuF0tklOxUkY1aqNO/n3NocHekblpHXU0tzmonJLT8qJDUNeucp5IBLjTdnt9htcVstdMympIkwyNqdjtkOGNMqcyAVAAAAADq9U3NtnsVXcnxvkZTxOkc1vdceR2h8l4o47hbKmilTLJonMVPagETL1xd22CompqHTc8rkcrHOe9qIi4VM4It6mvMl81dXX6SJInVFSs6MznHXPUlZceEa3Vd2rK6a+Sx873yNjYidMrnrlCLWrbO2xa6q7EyR0rKar8Lnd3cmQNmaa311/JXWi1U9a6GljlZHyQx90z59D6OMakX7odNcnJha2kY53pVcdSSui9Nbc6W27tl+udHbIJ/czJHSSsbzOXHdM9SLnE7uRZddagpvsJTYhpWqxZlxh3XywB1M+7F1j28ptLUKSwMgTrI1/VxJvhBtmrX2V961DVVL6aVqe543uXt169SM3Ddo61a03GprZd5VbTxN8Xl5kTnVPIkfad7aHTO5k+iaimalFFOlPTLDj3uU80QDAePlGN1FaMoifglX9Jgm1/D5d9daRTUFFcYoY1Rycjs90M34852VN7ss0a5R0OU9h3XD5vVo/SW1kdnucjvdTFflvTzAjfZLRLp/dS32ioXmlprixj1b2VUcTA4stAPv+38WoLYxVq6GJr3NRFXmREXOEQik67Ut63wp7jSp+BqLox7OnXCuPShtJDWWFlJO3mjlhRHIqJ6AIR8JW5smmdTyWS5LN7krnYYx3+reuE+JDX25VT9kOISpqY1V3iV6Y6905iYlFsdonS9ZctRKx1RK7nn/DImI/PCIQztDH3XfKCSBfEWW5+89iOAnZuvX/AGK2OrZXu5c0DWovrVMEHOGqh+ye9FsjVMtZPzr8SKSz4u47tNtHHQWmnlnfIrElSNiuXDUTyNA8FOm6yo3OqKuqpJYmUbOqPYqLlUUDDeK1rY96rzy+bm/QTl4eFztJY/6uhBfiz5l3rvHKmffJ9BOTh2kYu0Fh9+39rp5gbFXoQK41dN/YndB90hYjYK2NHOwnZxuvjH11ddKW+0SWK5up5/EdzsY/HOnrwan9waw3227p6jwIHV1NUYbNlcq3HmBuLgh1V9mtupLTUSZqLc9WNyvdiY+s7ziMs2iNUUMFq1Xffsc+F3OxrVwqofDwvbPV+20VVUXK4xzvqY05mNd0api3E/tfqXXWrIa+wVFKkTI0a7xJcL0z1/SBgP3J9jUb11pMnT+E01Bvbp3RmnbzT0+kry+5Uz2Lzu5kVEcnkpnj+G7cBzE/zm3p0/jjWe6m3t50FXRU16mp1llbzNRj+boBluxWiNvdSW+qqdWagdbZY3crGI7HMnmv0GyV2l2NVE/7cv8A7TTTe2O0Wpte2t1fZaimZG1ytVJJeXGPMzGLhm3BSVM3ChT/APQoE0Njn6YpdHQWfS1ybX0VE3lR6Lk7XdS0Vd80HdLXQtR1RUQOYxF81VFNb8LujbjoTT9TbLxPAtRLJlqRuznKqbrmmZHE6SReVjequ8kA86Krhn3SWpe5lrYqK7KLzYOROGfdle9FGv8AxzffFDvvFpuFbHpeszXua5skkbs8vllFQwfhu3F3T1LqKGges9bR86LNJM1y8rfNUUDXzeGTdvH/AIdH/wAwWS8M+7UrlatuiejfJajJNjdq6aps+iJqrTsEVTWtZlei5TCeWCHOlt+dc6f1stRea6qnhWX8LTy5VGJnqiZ7ASI4P9u9S6CtVzg1FTsp3zSIrER2emC/jBg1nUaSZLpqR7aRqL7q8NV58epPPzNl7cawtOs7LHc7VUNk52p4jM++Yqp5oZJVQQ1EDoJ42yRu6K1U6KB5ffaPfZ9NVmpaiB8cET8PdL0Vy9ex12g5tSU11V2mHVCVmMr4SKq4Ju8XdvobdsnXR0FLFTIsjUXw24657kH9EV+pKG5um03461iJ3iZzK1PSBsVb7vZjve/mlMc1pct0Km0uj1J9k0oVX3yzsw3J3TdT72fvX3n/AJdTpdZXzciutKwam+ya0Sr1SWJWpkDa/wDk/WO+6HcMqn7WXz9aExt0NOS6r0PcrBDOkElXErGvVM4VUIb8AL3fdHufRv7Ud5etpOxHZAhcvBteOdXfbFTLlc/sa/WXJwb3X8pKT+w76yaClMAQv+82uv5R03zS/WPvNrr+UdN8yv1k0QBC9eDa6+Gv/aSlT2xKZdtDw2XTQGuKPUst6pqxsGU8NjVRVz8ZKIARk4wdB2aTSNfrN9MiV8bGxZ8+q91NFcJtdJR3q+TwLiaO3yKxfXglZxi8qbHXb3uffMX9JGPgcp21O4lZCrGuR1M5Fa5MtVOnRQMFue5e5rbpO9l5rmK2RUTlVcomfYYzrDWertSwxQ6juVZVxwuzGkrlVEX4z0yTQGkFRVfp62q53VfwCL1I5cb2mLFZtKWuottqo6aV8itV0UKNXoqegCLuidY6p0wk6afq6qmSZUV6w5T2djK2bubmzyxxyXi5qiuTzcbc4C7JZr4l9ZdbXTVbWK1WeKxHK3qSrdt/o1FRW6dt6YXP7CgGDVm7GntH6KsztT1krZaukRyLy5VVx+nyIkaqpNAag1RV3b7e62NKuRXo1YXLyovxkw93tmdMa9pYnXOSpgbSRqkTIVRGonfGMeohtfLftVabxUUHuK+TPp3qx6pIxEygHWXGwaFit1WtPr6qnmbGrmRrA5EeqdcdzArbDTT3WOKsqXU0LlTme1eqeszm61e2TLfUNorfd2VKsXwnyyNVqOx0yYDSPopKqNaxr3RNXLuReoGcXa0aYo7Z4tr1XUVlRjKMVqtQ7Lh71lQ6R3Gp7rf6yZlKyNzVy5VTOUOhvE2gVsyLaYLpHWMwiuke3kT1IdnsNo2h13uFTWS5VEkNPI1Xc8a9e6ekD0I0Driya0tvu+ySPkhRcZcmOvoMta7ywYRtTt5btvrY+3W2aaaJz1fmVcqir8Rm6AXAAAAAAAAh/wAWOvde6K18sFku9ZDQ1EHOjGZVGr5kdLHY9U641dHUwUNRUVE0/iyyOYqZVV79j0wvOl7Ld5kkuNupapWphPGiR/T4y616ZstsVFobdS06+mOJG/QBE7iI2t1rWWKzy2qoqaiBIGRy0aKq8jsdsfEp0u23C7dLhaHVuplWle+NfCj8+by8ibr4WYRr2Nc30KV5UVERERETsiAeYerbFqvbTVc7aSOqppIXr4dSxq9sr5/Gd5w/6a1Frbdy33OspameOOqSWqmkRVTz8/I9B9QaWsF+TF1tVJUp/txIq/KUsGmbNYWKy1UMFK1y5ckcaNyBFjjesF4ut3tDLTa6mqYyLlcsUauVF+Qxza7hhr9T6Zjut1uU1ulkcuIfCwqJ68oTekp4JlTxYmPx25mouDnjY1rOVrWtT1JgCKmnuE6ntd9orml+letNM2RGqidcLk3lu5JfaHbqsm09UPhraanykjE98qI1TOFaqnHPTxzQuimjbIxyYVrkyioB5tX7d/dCshltVffKx8cqKx7FynTt5GWcLO318uW4dHfrhA6KipXeIjpG9XO9WSbrNCaSV/iO0/bHPVUVVWlYqrj4ju6K20NEzkpKSGBuO0bEb9AHzxNZPG5Hxo5q9Fa9uUU+K1acs9tq56qgoIKaWdcyOjYiKv8A1k77kTHYtbHhQIOcY22d8drt+oLRaqqtpqmNFe6JmVauEz0Q1Par7utabeygtz79T07EwxjIpEREPTqWCOVMSRsenoc3KHD9jLf/ACGn+bb9QHmBcaLcjWFwhiuNLd6yXHKxZ2Pw3Pn1Jx8MuiKvRe3kVFX0zI6uZ/iyN5ccuU7G3mW+gY7mbRwIuO6Rt+o50jYjcIiJ8QHQaobKmnLikLntkdTSI1Wd0XHTB513yp3bW8VboE1H4bZHIxW86IqZ9R6YrG3PVMocUdDRtcq+5ofm0+oDzJSr3j5O+p16eXiHT3jT24d4lSW5Wq91kjeiOmje5U+U9UFpabGPc8PzafUU9y06/wDl4fm0+oDzA05ady7JTrDa6C+UrH9VSKJ7ep2bpd30/e6i+ST6z0tWhpXKirTwr/w0LXUFGq/taH5tPqAhRwov3Cfu3TfbE27rQpC5V8fn5c4XHc2rxbXPcO32KRNNufHbXoqSuiaquTp17dSQbKOBjuaOGJi4x0YgnpIKmNYqiKOVip1a9qOT9IHmxtjtRq/ca+RzT003ud78TVM7VTp59yfG2egrNoXT0FttccavRiJLKidXr7TLKK20FC3lo6SGnavdI2I3PyHKka5A+eSJkkbo5Go5jkwqL5ka+JfYimuttm1HpumbFXRIrnxsb8L5CT3h+gtfEjkw5M+0CAXDpQ7oWrWMSWmmqooPERlSjkVGK3PrJ5ULZfc7PFT3yNTPrUvZRUsLsxUsDF9LY0Rf0H1Mb06gaP40mNTZutRE/wBYz6SPfAtQw1G5lYyrhR8aU2cPb0zknPe7TbrzQPobpRw1lO/uyVvMmT4rHpHTdmqnVNpstDRyO+E6KFqKvyIB8upKFHWaqS3wQQ1PhOVj0jTop547ka/1xfXVVivFUtTFDUKnhti80VU8vYelklO1VVrkyimOx7e6Q90SVK2G3umldzPe6naquX09gIw8BmlLpR6huF8rKd8dMtP4bVc3uqqikyD5bfbKG3sRlFTQ07MY5Y2I1P0H14AqAAAAAAADTfGL77ZK5xp8JyphPjI38B0UjNyaxzmOREp1zlCc17tdBd6J1HcqSGqgd3jlajkU6vT+kdO2Kq91Wmz0dHMreVz4okaqgd+qIpGTj6TGirQ70TqnyohJtOvkdXqHT1n1BTtgvFspq+Ji5a2ZvMiL6QIqf5PCNWNvz3Iqcyt7p6yYC9Tp9N6Ysen2PSz2uloOf4fgRo3mO5wBZJGySN0b25a5MKhrC6bFbbVlTUVsunYn1Eqq565xzKbTQpgDzw3XqdOacvF1079odNTzRNVkc6KqKnoVMmK7A6Mn1nr2kpZ6DnoEfmVrmqjXN9p6J3vQekr1V+67pYqKqqMYWR8SKqofRaNJ6fsrWparVS0ap0zFGjVUDVGqOG7b25WRaa3WmKiqXf65idUOs2k4doNC63i1DHd5KiNjcJG5qIvckGiYTBVWgcnMi9lyVONGnIAAAAAAAC2WRsbFe9cNRMqoFwMMu+5OjaLxY5b/AEcczOZqNc/C8yIRMu/ErreHXz6WCupX2qKrVi+Ezq9mcZRQJyqmS1EwYRpvcrStzt1Gq3qmbUSxt94r+qqqHFvle66xbW3a8WyVGTxRc0b06gZ4qdfaHM6diBm1XElqynvU8+p6me40zWryxtbhM9cZwSZ2G3it249PUI7FLXQLh8Du6p6UA2vgvb5ny3Kq9y2+oqcfsUavT4kyQ2u/F1qSmvtVb6ayU8nhTPjb16qiKoE1UGCFDeLPXCd9LMT/AOriv32mtvyYZ/ZcBNdAQll4uNZxN55dNwsZnCucioiG6uGXd66bpOuUldRxUqU3Lhrcr3A3gAAAAAAAAAAAAAAAAAAAAAAACmEKgAFCAAUcmSqJgte9GKvMuERMqp0Vs1hp25V8tDQ3OCeohcrJGNd1aqeQHfgo1UXsoUCoMO1NuXo/Td3da7zdoqWpamVa70H22bXOlbxy/Y+9Uk3N8HEnVQMkBwNla9yq1yKnqOVqgXAAAqZLWtLgAAAAAAAAAAAFOVPQVwAAAAAAAAAAPmukbpbfPGxMudG5EPpCgefGuNmNVv1bcpqi5W+n8Wpe5rZp8KrVXyyvY6BNltRJ1bdLSn/6W/WZHxkVlVDvXVxR1EreaJvKjXYTPU4oNjtUSaUW+u1HRsidTeN4azJzImM479wODRW0upKLVdtqpLpb5I4Z2vexlUiqqJ1Xoim+uIbdbRs+1VysNHeYJKx8SRpGmcoqYRfIjJw8R1dVu1R25J3uerpI+qquV5V7GSbw7FXzTVrrNV3G4wLAsrnJEi5Xqq9O4GN8PMmlabVdWzVdTFT0NVA6PnkTKMXHc2Bsja9LWreF9ZBrKGOBlQqU7I0dmRF7IaU0PpiTU9yfQpcKegVOz5uzl9Bv/bzhn1ZQajtl6W50stLDM2VeVcKqJ6AJi6gVH6drVZ1RaZyov/1U8q7q+eLX1W6laj6hK1yxIvbPMeomrL7ZbRaZaS5XOnpZJoFazxXYz0PPy7bVVFVqOtr6fUtqRr5nPb/nCekDKbbVbwz0MDqez03hpGnKqsjyqH1LUb0ednpV/wCHEYuzQ2rmtRkeuqRGMTCJ7r6IhRdFauZjOvaJPbV/4gfBuvXa5dRRxamp6enjXCtSNjM59qG8f8nsio3UDevTkNI1m294rZ0Wu1jbKlXdcvq84/Sb64QYLZoWqutNdb9blfWPayDkn5udUAlkgLGP5kynmXgAAAAAHX6guUVntFVdKjPgUsLpZMd+VqZU0u7im23jcrXurOZFx0jX6jaO634udQIndbfNhPT708vJmu8V/MmPfATv++r20z3r/mV+ov8AvqdtPTcPmVIFcrvJqu9iDL/4twE9PvqdtPTcPmVH31O2npuHzKkCfffwF+RR77+CoE9vvqdtPTcPmVH31O2npuHzKkDEVVTqmCoE8vvqdtPTcPmVH31O2npuHzKkDFf0ONXdQJ7/AH1O2npuHzKlKXil27qJEjiS4ucqoiIsOCBPMc9vdy19P+cb9IHq3aLjFcrdBXQtVsc8aSNRe+FPtRcoYxtixyaHtKuTvSR/qmUIAAC9EyBhu8epmaW2+u9z5+WVsCsiX/aXoh5uw6nvlvvzrvR3CaGuWVZVka5Uyqr1yhJvjd17G6ppNI0MzV5U8Socxeqr5Iv6SJ0dPJVVLYo0V8kiojWomVVQJx8IW4+qtd26vS+va6CiRGMlROrl9H6Tf9wq4qKjkqZlwyNquX2Iax4atHR6R2woKZzESoqGNlmXHXKpnr8p1PFtrmPSO3E1LBOjbhcFWCFEX0gQ5311JJqrcq63J0iOYk7o4+v71FU7Thq0/c9Q7pWynpvG9y07/Fm5HqiI1DWUkrnvVz15nuVXOX0qvc33wo7g6N0C651t/klZV1SokKsjV3K3pkCcVNAkMaInoPpZ3NJ/fLbZfzhP80oXia2yZj/SMzfbGoG8U7A0f987tl/Okvzaj753bLyucvza/UBvAGkGcTW2rnI1LlLly4T8Gvf5DcNhuVPeLRT3OkcroKhiPYvqUD7gAAAAAAAAAAAAAAAAAAAAAA4auZkELpZF5WNTKr6AIL8Xekblct4J6ps9IxksbeVJJUaqJ1NFVlTf6asdZ33KoXK8iMZMqtXshtPfa7y7gb7y0FvV74mzpToufNq4Xt37mDawtP2L3Oba88yRVDWOyvXumQM74c9M11p3jsqy1VIszXK5zUlTKJhe5vPjjv8AS0e39JaX4WoqKhF5MZ96nc0DerJc9F7wUVwpaSeRiyQzI6NFXp0z29pzcUutHa11/TwU7nuhgiRkbPQqoBqChlc2ug5VxmRuflQ9T9vXOfom0PeuVWkZn5DzFv1hnsN7o6Srb+Fd4blRUx3VFPQC3bqaV0tDY9NXqpWnqpqKN0bse9XKAYbxV7Z6q15c6GWwOjjip43eI97sZ6+j5SMN82vvOnrituvd5o6ebGVy/CHoldrtQUVhmu09TC2kjj8RXquUVMHm9u/ql+qtb3a5rK6WGWVfCRV7NRemAO/r9ktYt0u/UNHUwVVE2NZOaKbu1PM1npyzXXUN8jtNHNyTvdhFkl5Wp1x3+MmNt7rbTN54ba6101RFDXUtvWJ8bnIjs48iG8Fvuly1Kyis6SvrJX8sbY1wq9QNnQ7B64ViL9k7Z/zqHfbf7C60o9ZW+4zV1uljp52ve2OpRzsZ69MmMx7N7vPgYqW+v8/hTL9Ztfhk2519p/caGv1JTVEVHHG5FV8uUz5d1AmRQNVtKxF7o1E+RMHPg4Kf3rEZ3wc6LkCgAAAADjqYIqmnkp5mI+ORqtc1UyiovkYr9zTQy99N0C+2NDL0KgYm3bjQ7ERG6Ztyf8JCq7eaK/Jq3fMoZWUUDE/ueaK/Jq3fMoaf4tNHaXtO0lXXW6y0lLUMkbh8TOVcKqEjMGk+Mz8Std+cZ+sgEACeHDhoPSV02is1ZcbDR1M8jFVz3syq9SBb8p6z0c4XGp9xWx9P9Wv0gZCm2Gg8fuYt6f8ACQfcw0D+TFv+bQzEAYf9zDQP5MW/5tCrNs9CMe18embe1zVznwkMvAFlPFFTwthhYjI2JhrU7IhyZKACuTHNwtT0OltL1l2q5kjSKJysyuMux0QyF68rVUg/xebopf8AUCaZtlRzUlFIrZkavRy9PlwBo3W1+rdTaorr1WuV0lTIrkRV+CnkhsThT0V9tm4kFVO3moqFfEk6ZyqKmENUyJ+EVfT1J78I2nrZbNq6K5U0Ce6K1OaZzuucL0A3HGkFHR46MjjTqqJ2Q8++K/XCav3MmipZ0kobengx8q5aq5XK+0lLxRbh/aXomWmpp2x3GuRYY0Tu1HdF6Hn/AFKvc980j+d73q9yr5qvcDjLmEi+Fnaaj1HQ1GpNR0DZqLlcyna/o1y+k0hrimpqLV91o6WPkihqnsanoRFA6VBg3Lwk6WsWrNwKqhvdC2piZTK5Ed2Jcpsdtc1qO+1KiXP+yB5w4GD0f+4ltb+SNF8g+4ltenbSVCnxAecMHKlVDn+Mavb1nqBtQqfc5sWP5HGvb1GPpsrtmjmOZpaiarXcyLyZ6mwaCjp6GjipKSNIoImIxjE8kQD6AAABa/scfMoHMURxw5XGCmV9IH0FEccOV9JTmVAPoBwNkXJzIqKBUL2AXsBxOcqL0KK93pKO7hQOcAADr9Q0LrlaKmia/kWaNzOZO6ZQ7AAQyuO0N92n1NWa/RjLvTUjllb4irnr5mjI5bprndltyioZM1VWjnIxnVqc2T03udBR3Oiko66Bk8EiYcxyZRTH7ToDSVoqPdFrs1NSS9MvjamQNWb7QV9m26nr7PZI6uu9ytie/l5nxJjq5COfDht3c9a66jvtfSzJQQPRXvkTGV//ANJ91ttpa2F0NRGj2ORUVqplFRT47Fpy12OmfT22mjgje9XuRjUTKr7AIJ8YGm7natzm1zYFWkVkfhrGxeuET5DFLlddRbh7iWV0Vrc19OyKH3rV+C3CdfkPRS86cst4wt0t1PVqnZZGIqocVv0npq3VaVVDZKKCZOz2xJlAIv8AFrd9ZWrTdDZoqOeK0uhY2WWNOZFXHZceRr/Z7YO763sNbdLiklIzws0qoi5c7r1J13mzWy9Ua0l1ooauDOeSRqKmTlttvpbdTNpqOFsMLUw1jUwiAeb2r9tNf6Dq56Sa3VclJNlGzQNVWub61RO5idorrxpq/wAVzpoXxVcS5asjFyh6pVNDS1sfh1UEczPQ9qKh0tXoLSFZKstTYKGR/pWJMgQHdv8A7oNREZc3MT0IzP0n0aZ373LfqClZNcZJY3zNRzXRdFRVQnT9zbQy99NW9fbChdFtzoiKVssemre17VyipEnQDs9J1k1wslNVzs5HyRtdjHbKHcocUUbImIyNqNY1MI1OyHKgFAAAAAAAAAAANJ8Zv4l6/wDOM/WQ3YaT4zfxL1/5xn6yAef6pk9HOF73uy9jb/u1+k85D0b4YfxNWP8ANr9IG0CjlwhVOxZL5AWK9Qj1LV6rkIBzt6oVXtk4UcuMHy3OSo9wzJTriXkVG9fMDR/FNvCzR9F9r1pkVbnUxrzvYufCQg7WTOqaqSpkkc+SRcuc5cqqnf7o1t1m13dWXeofNUsqHNVXL269jq4rJcX2V95bTSe4WP5FlVqomQPgVcY9pPnZO/0GmeHu23e4zJHTwU6udleq4z0QgHzIq9CS+tbPqS48L1gntj3LQU0Tn1TI1649gGod69wajcPWU10lVWUkSqylYvk3PRV9Z0eh9M12rdR0looGrzySJzOT963zUx5kb5FaiJ1cuET1k2+Ebaxlk08mo7lC5lfWt5mL5tYqJhPb3A3BobTdNpnRlHZYW4SGBEVU7KvKmV+XJ517mJy6/vaf/Mk/WU9O6qPFO/z95g8w9z0/7wb5lP8Azsn6ygbZ4HXsZujVufIxjXUuMudhM5JyNqqZGo100XT0PQ8rLTc6+0zOnttVLSyuTCvjdhcHYS621auP+0VyT2TuA9RfdFEv/mIfnEHj0X8fF8T0PLb7dtW/lHc/+YcPt21b+UVz/wCYcB6lRS00jsRzMcqeSOyc5D/gXvt2umprpHdLnV1n4FORJpFcidfLJMBEAAADjecZyP7nGAAAAKABRC9q4LQBzo5vpLXuRU6HHgIgFHL1KKqeZVUKKgH0gAAAAAAAAAC3lQcqFwAt5UK8qFQAREQAAAAAAAAAAAAAAAAAADSfGZ+JmuT0yM/WQ3YaT4y/xN1v5xv6yAefre56OcMf4mbH+bX6TzjPRvhg/EpZHf7tfpA2k3q1C2ROhWNfeIXAfOvcF0vw1LQA+kACIO9ex9zvu+CutjHxWyuYk1RPyr+DXp09Hp6HfcTekLdovh/p7RbWtajZ2o56J75y+kk85iK5HqmXJ5mg+OPKbRt/rCKBBWFV58Honw9UlPXbG2ikqomzQSwK17HJlFQ864VwqL6j0a4ZMu2asn5r+8DBKDhrsVPuw++xud9h2r4zafKK3nVe3bsSIpqeClibDTxtZG1MIiJ0QRtyvQ5msx3ApVftaT+ip5f7o/jBvf8AXJP1lPUCq/a0n9FTy/3R/GDe/wCuSfrKB2Wze31RuNqN9np6tKZ7Y1dzK3JuF/CVc/yhZ81/gdLwO/jQq/6mv95OGNoEN14SLt/P7Pmw3hKuf5RRf2F+oma1ocwDRnDrsxVbZXSqrZ7oysWdiNRGoqYN7tdk4kZ1OVEwmALixzvIuVcIcLlyoBVyUAAAAAAAAAAAAAAAPoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA0nxl/ibrfzjf1kN2GkuMv8AE3W/nG/rIB5/p8JvsQ9GeF78SVk/Nr9J5yt/ZGno5wvJ/wByVk/Nr9IGzEVU7KXcynGAC9XKoAAAAC9rcmgeOZuNo2fnkN+NdhTQXHMudo2eqfAEEWdviPRzhhRPuN2b82v0nnJGvvUPRrhi6bN2X82qfpA2nHhOyHIcMbunY5HOwmQLKv8Aa0n9FTy/3R/GDe/65J+sp6fVTs00n9FTy/3Ofzbg3zp/5yT9ZQO72N3FXbfVU93SgSs8SDw+VX8uDdv33sif+2W/PEXLdQVtwnWKipZZ3omVSNuVQ+t+l9RIn/gtevsgd9RPUEl14wJ07aaT50ffg1H5NN+eIxLpnUmfe2K4L/wHfUU+1jU38wXD5lR1Dad/D7vfLufX11M61pR+5mI7KO5u5urnUh7wK2u523Ul3fX0FRTc8KI3xGKiKuSYDlwOobVV7vSWlMlR1GbgADeodQAA6h1AADqHUAAOodQAA6h1AADqHUfQADWgAAAAAAAAAAAAAAAAAAAAAAAABZN+xP8A6K/QBTx4eyzRovmiuHjwfx0X9tDzv3k1VqSk3IvdPTXqtiiiqXta1sqoiJkwldW6n/n2v+eUD1FdVU38oi/toUSrpv5RF/bQ8uvtt1P1/wBO1/zzix2rdTfz5XfHKoHqQtXTfyiL+2hpLjNqYHbM1qNmjVVlYmEdlfhIQjTV2pkx/pus+dd9Zw3DUV6uUHueuuVTPCvdj5FVAOnReV7HY7Ih6McMVTTs2VsjXTxtXw16Odhe551OQ7ii1bqGipWUtJdaqGGNOVrWSKiIB6ipU02es8af/ZC/3RTKnSdi/wD2Q8vF1tqr+fK751Qmu9WI1G/Z2u6f71QPUHx4P46P+0g8eD+Oj/tIeX32+at/nyt+KRUH2+at/n6vT2TKB6hNmic9GNka5y9kRcl6p0IV8GupL5edyZqe6XWrq4o6VXtZJIqpnqTSY7I/CidzQfHP02lan+/Q36poDjj/ABRt/rKE9J2gpH8BvsPRvhf99s3Zv6C/SecbF96iHo7wvp/3N2X80Tv+jbaMfcvk+AWx9y6T4B0U+eq/a0n9E8wdzPxg3z+uSfrKen1V+1pP6J5gbm/jAvn9ck/WUy+FbX4JYGVG6FU2REciUqrhUyhN+G2UjG48CFf+GhCjgV/GpVuX+RKn0k5UbnzOeOO0vkW3Un8RF8TEH2OpF/1ES+1iH2+EqeYxylfG3T56ekggVXRQxMVe6tbg5XdS/mLHLkfGaWlS0uI0mgAGk7AANGwADRsAA0bAANGwADRt9AAOzqAAAAAAAAAAAAAAAAAAAAAAAAFsjeaNzUXGUwXACLWuOF6r1FqmvvLb+2H3VM6TldHlevrydP8Aeh1v5UQ/NL9ZL0ARC+9Drfyoh+a/xONeEK4flLD80pMEAQ9+9BuH5Sx/FCU+9Crfyoh+a/xJhgCHbuEK4fvdUQ/Nf4lqcH92Vf3Tw/N/4kxsACHX3nt2x+6iH5r/ABLF4PLvn908PzX+JMgAQ3+86u35UQ/Nf4lF4Ort+VEPzX+JMkAR82D2BrtttUVF3qbwysSWJY0axmFTPmb5RuD6TiUXwvi00FxwxSy7StbFGr1SoRVx6Ohv066/WW2XykSlutJHVQoueR6ZTJyc5NPKVtNUpjMDk6ZPR3hiTl2dszVRf2LzQ777m+h8/uat6+2JDIrRbqK00MdFb6dkEEaYaxqYRDZPvapHYMOSRMtOKJDnOiny1SL7nk/oqeYG5jXfdBvmGqv+eSdv6SnqNIqK3lxnJh1ZttoarqZKmp0zb5Z5HK573MyrlXzF8KiRwMtk+6nV4Yqf5mvf4ycrVXyMe07o3TGnqt9XZrLSUU7m8qviZhcGQtdjyJwljI5W5x1K9yjPfNyXYKat5U9CHG7GehyP6NU4VXBm2WqAA531N8AAEAAAAAAAAAAAAAD6AAdXYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAslRETKIXlk3wTL4VxDGQXxoRMdpW8i+gpg58FnhqXIpa1F8kyXvzhMeZViYQpJ5Gi1Gu9BejG+guAFORvoHK30FQAToAAKP+Cp86n0P+Cp86k5OeaoAIT+AAAAAAAAAAAAAAAAPoAB1dgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACyb4IBl8K4jlj7AGYpnq8AFKCyTyAAvAAAAAAABR/wVPnUAnJzzVABCfwAAAAAAAAAAAAAAAB/9k=", null);

        System.out.print("*******************************************************************"+filePath);

    }
}
