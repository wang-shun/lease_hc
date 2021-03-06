package hc.lease.common.generate;

import com.google.common.collect.Maps;
import freemarker.template.Configuration;
import freemarker.template.Template;
import hc.lease.common.util.DateUtils;
import hc.lease.common.util.DefinedFileUtils;
import hc.lease.common.util.FreeMarkers;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.*;
import java.util.Map;

/**
 * 代码生成器
 */
public class adapterGenerate {

    private static Logger logger = LoggerFactory.getLogger(adapterGenerate.class);

    public static void main(String[] args) throws Exception {

        // ========== ↓↓↓↓↓↓ 执行前请修改参数，谨慎执行。↓↓↓↓↓↓ ====================

        // 主要提供基本功能模块代码生成。
        // 目录生成结构：{packageName}/{moduleName}/{dao,entity,service,web}/{subModuleName}/{className}

        String serviceImpl_projectPath = "E:/luomingtong/work/project/hc_lease/hc_lease/hc-lease-user-adapter";
        String serviceApi_projectPath = "E:/luomingtong/work/project/hc_lease/hc_lease/hc-lease-user-adapter-api";
        //String controller_projectPath = "";
        String controller_projectPath = "E:/luomingtong/work/project/hc_lease/hc_lease/hc-lease-web-consumer";

        // packageName 包名，这里如果更改包名，请在applicationContext.xml和srping-mvc.xml中配置base-package、packagesToScan属性，来指定多个（共4处需要修改）。
        String packageName = "com.hc.lease";
        String moduleName = "user";            // 模块名，例：sys
        String subModuleName = "";                // 子模块名（可选）
        String className = "LeaseAuthoUserRole";            // 类名，例：user
        String classAuthor = "tong";        // 类作者，例：ThinkGem
        String functionName = "用户对应的角色";            // 功能名，例：用户

        dualFile(packageName, moduleName, subModuleName, className, classAuthor, functionName, serviceImpl_projectPath, serviceApi_projectPath, controller_projectPath);

        /*
        ArrayList<Map> list = new ArrayList<Map>();
        HashMap<String,String> map = new HashMap<String, String>();

        map.put("packageName","com.hc.lease");
        map.put("moduleName","");
        map.put("subModuleName","account");
        map.put("className","LeaseCardModel");
        map.put("classAuthor","Tong");
        map.put("functionName","车型");
        list.add(map);
        */


    }

    public static void dualFile(String packageName, String moduleName, String subModuleName, String className, String classAuthor, String functionName, String serviceImpl_projectPath_c, String serviceApi_projectPath_c, String controller_projectPath) throws Exception {

        // 是否启用生成工具
        //Boolean isEnable = false;
        Boolean isEnable = true;

        // ========== ↑↑↑↑↑↑ 执行前请修改参数，谨慎执行。↑↑↑↑↑↑ ====================

        if (!isEnable) {
            logger.info("请启用代码生成工具，设置参数：isEnable = true");
            return;
        }

        if (StringUtils.isBlank(moduleName) || StringUtils.isBlank(moduleName)
                || StringUtils.isBlank(className) || StringUtils.isBlank(functionName)) {
            logger.info("参数设置错误：包名、模块名、类名、功能名不能为空。");
            return;
        }

        // 获取文件分隔符
        String separator = File.separator;

        // 获取工程路径
        File projectPath = new DefaultResourceLoader().getResource("").getFile();
        while (!new File(projectPath.getPath() + separator + "src" + separator + "main").exists()) {
            projectPath = projectPath.getParentFile();
        }
        logger.info("Project Path: {}", projectPath);

        File tplPath_projectPath = new File("E:/luomingtong/work/project/hc_lease/hc_lease/hc-lease-common-util");// 模板文件所在项目路径
        File serviceImpl_projectPath = new File(serviceImpl_projectPath_c);// serviceImpl文件所在项目路径
        File serviceApi_projectPath = new File(serviceApi_projectPath_c);// serviceApi文件所在项目路径

        // 模板文件路径
        String tplPath = StringUtils.replace(tplPath_projectPath + "/src/main/java/hc/lease/common/generate", "/", separator);
        logger.info("Template Path: {}", tplPath);

        // Java文件路径
        String javaPath = StringUtils.replaceEach(projectPath + "/src/main/java/" + StringUtils.lowerCase(packageName),
                new String[]{"/", "."}, new String[]{separator, separator});
        logger.info("Java Path: {}", javaPath);


        // Java文件路径
        String serviceImpl_javaPath = StringUtils.replaceEach(serviceImpl_projectPath + "/src/main/java/" + StringUtils.lowerCase(packageName),
                new String[]{"/", "."}, new String[]{separator, separator});
        logger.info("serviceApi_javaPath Path: {}", serviceImpl_javaPath);

        // Java文件路径
        String serviceApi_javaPath = StringUtils.replaceEach(serviceApi_projectPath + "/src/main/java/" + StringUtils.lowerCase(packageName),
                new String[]{"/", "."}, new String[]{separator, separator});
        logger.info("serviceApi_javaPath Path: {}", serviceApi_javaPath);

        // Java文件路径
        String controller_javaPath = StringUtils.replaceEach(controller_projectPath + "/src/main/java/" + StringUtils.lowerCase(packageName),
                new String[]{"/", "."}, new String[]{separator, separator});
        logger.info("serviceApi_javaPath Path: {}", serviceApi_javaPath);


        // 视图文件路径
        String viewPath = StringUtils.replace(projectPath + "/src/main/webapp/WEB-INF/views", "/", separator);
        logger.info("View Path: {}", viewPath);

        // 代码模板配置
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(new File(tplPath));

        // 定义模板变量
        Map<String, String> model = Maps.newHashMap();
        model.put("packageName", StringUtils.lowerCase(packageName));
        model.put("moduleName", moduleName);
        model.put("subModuleName", StringUtils.isNotBlank(subModuleName) ? "." + StringUtils.lowerCase(subModuleName) : "");
        model.put("className", StringUtils.uncapitalize(className));
        model.put("ClassName", StringUtils.capitalize(className));
        model.put("classAuthor", StringUtils.isNotBlank(classAuthor) ? classAuthor : "Generate Tools");
        model.put("classVersion", DateUtils.getDate());
        model.put("functionName", functionName);
        model.put("tableName", model.get("moduleName") + (StringUtils.isNotBlank(subModuleName)
                ? "_" + StringUtils.lowerCase(subModuleName) : "") + "_" + model.get("className"));
        model.put("urlPrefix", model.get("moduleName") + (StringUtils.isNotBlank(subModuleName)
                ? "/" + StringUtils.lowerCase(subModuleName) : "") + "/" + model.get("className"));
        model.put("adminPath", "admin");
        model.put("viewPrefix", //StringUtils.substringAfterLast(model.get("packageName"),".")+"/"+
                model.get("urlPrefix"));
        model.put("permissionPrefix", model.get("moduleName") + (StringUtils.isNotBlank(subModuleName)
                ? ":" + StringUtils.lowerCase(subModuleName) : "") + ":" + model.get("className"));

        Template template = cfg.getTemplate("entity.ftl");
        String content = "";
        String filePath = "";

        /*
        // 生成 Entity
        String content = FreeMarkers.renderTemplate(template, model);
        String filePath = javaPath + separator + model.get("moduleName") + separator + "entity"
                + separator + StringUtils.lowerCase(subModuleName) + separator + model.get("ClassName") + ".java";
        writeFile(content, filePath);
        logger.info("Entity: {}", filePath);

        // 生成 Dao
        template = cfg.getTemplate("dao.ftl");
        content = FreeMarkers.renderTemplate(template, model);
        filePath = javaPath + separator + model.get("moduleName") + separator + "dao" + separator
                + StringUtils.lowerCase(subModuleName) + separator + model.get("ClassName") + "Dao.java";
        writeFile(content, filePath);
        logger.info("Dao: {}", filePath);
        */

        // 生成 AdapterImpl
        template = cfg.getTemplate("adapterImpl.ftl");
        content = FreeMarkers.renderTemplate(template, model);
        filePath = serviceImpl_javaPath + separator + model.get("moduleName") + separator + "adapter" + separator + "impl" + separator
                + StringUtils.lowerCase(subModuleName) + separator + model.get("ClassName") + "AdapterImpl.java";
        writeFile(content, filePath);
        logger.info("Service: {}", filePath);

        // 生成 AdapterApi
        template = cfg.getTemplate("adapterApi.ftl");
        content = FreeMarkers.renderTemplate(template, model);
        filePath = serviceApi_javaPath + separator + model.get("moduleName") + separator + "adapter" + separator + "api" + separator
                + StringUtils.lowerCase(subModuleName) + separator + model.get("ClassName") + "Adapter.java";
        writeFile(content, filePath);
        logger.info("Service: {}", filePath);

        // 生成 Controller
        template = cfg.getTemplate("controller.ftl");
        content = FreeMarkers.renderTemplate(template, model);
        filePath = controller_javaPath + separator + model.get("moduleName") + separator + "controller" + separator
                + StringUtils.lowerCase(subModuleName) + separator + model.get("ClassName") + "Controller.java";
        writeFile(content, filePath);
        logger.info("Controller: {}", filePath);


/*
        // 生成 ViewForm
        template = cfg.getTemplate("viewForm.ftl");
        content = FreeMarkers.renderTemplate(template, model);
        filePath = viewPath + separator + StringUtils.substringAfterLast(model.get("packageName"), ".")
                + separator + model.get("moduleName") + separator + StringUtils.lowerCase(subModuleName)
                + separator + model.get("className") + "Form.jsp";
        writeFile(content, filePath);
        logger.info("ViewForm: {}", filePath);

        // 生成 ViewList
        template = cfg.getTemplate("viewList.ftl");
        content = FreeMarkers.renderTemplate(template, model);
        filePath = viewPath + separator + StringUtils.substringAfterLast(model.get("packageName"), ".")
                + separator + model.get("moduleName") + separator + StringUtils.lowerCase(subModuleName)
                + separator + model.get("className") + "List.jsp";
        writeFile(content, filePath);
        logger.info("ViewList: {}", filePath);

        logger.info("Generate Success.");
        */

    }

    /**
     * 将内容写入文件
     *
     * @param content
     * @param filePath
     */
    public static void writeFile(String content, String filePath) {
        try {
            if (DefinedFileUtils.createFile(filePath)) {
                FileOutputStream fos = new FileOutputStream(filePath);
                Writer writer = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(content);
                bufferedWriter.close();
                writer.close();
            } else {
                logger.info("生成失败，文件已存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
