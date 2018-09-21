package hc.lease.common.util;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
public class DownLoadZip implements Serializable {


    //文件打包下载
    public static HttpServletResponse downLoadFiles(List<File> files,
                                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            /**这个集合就是你想要打包的所有文件，
             * 这里假设已经准备好了所要打包的文件*/
            //List<File> files = new ArrayList<File>();

            /**创建一个临时压缩文件，
             * 我们会把文件流全部注入到这个文件中
             * 这里的文件你可以自定义是.rar还是.zip*/
            File file = new File("c:/certpics.rar");
            if (!file.exists()) {
                file.createNewFile();
            }
            response.reset();
            //response.getWriter()
            //创建文件输出流
            FileOutputStream fous = new FileOutputStream(file);
            /**打包的方法我们会用到ZipOutputStream这样一个输出流,
             * 所以这里我们把输出流转换一下*/
            ZipOutputStream zipOut
                    = new ZipOutputStream(fous);
            /**这个方法接受的就是一个所要打包文件的集合，
             * 还有一个ZipOutputStream*/
            zipFile(files, zipOut);
            zipOut.close();
            fous.close();
           /* return downloadZip(file,response);*/
        } catch (Exception e) {
            e.printStackTrace();
        }


        return response;
    }

    /**
     * 把接受的全部文件打成压缩包
     *
     * @param
     * @param
     */
    public static void zipFile
    (List files, ZipOutputStream outputStream) {
        int size = files.size();
        for (int i = 0; i < size; i++) {
            File file = (File) files.get(i);
            zipFile(file, outputStream);
        }
    }

    public static HttpServletResponse downloadZip(File file, HttpServletResponse response, String fileName, String contractAddress, List<File> files) {
        try {
            // 以流的形式下载文件。
          /*  InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();*/
            // 清空response
            response.reset();

            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream;charset=utf-8");
          /*  response.setContentLength();*/
            //如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
            try {

                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            InputStream inputStream = new FileInputStream(file.getPath());
            byte[] buffer = new byte[1024];
            int i = -1;
            while ((i = inputStream.read(buffer)) != -1) {
                toClient.write(buffer, 0, i);
            }
            /*toClient.write(buffer);*/
            toClient.flush();
            toClient.close();
            inputStream.close();
            toClient = null;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                for (File f : files) {
                    delAllFile(f);
                }

                File f = new File(file.getPath());
                f.delete();
                System.out.print("删除contract文件夹下的文件成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    /**
     * 根据输入的文件与输出流对文件进行打包
     *
     * @param
     * @param
     */
    public static void zipFile(File inputFile,
                               ZipOutputStream ouputStream) {
        try {
            if (inputFile.exists()) {
                /**如果是目录的话这里是不采取操作的，
                 * 至于目录的打包正在研究中*/
                if (inputFile.isFile()) {
                    FileInputStream IN = new FileInputStream(inputFile);
                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
                    //org.apache.tools.zip.ZipEntry
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    ouputStream.putNextEntry(entry);
                    // 向压缩文件中输出数据
                    int nNumber;
                    byte[] buffer = new byte[512];
                    while ((nNumber = bins.read(buffer)) != -1) {
                        ouputStream.write(buffer, 0, nNumber);
                    }
                    // 关闭创建的流对象
                    bins.close();
                    IN.close();
                } else {
                    try {
                        File[] files = inputFile.listFiles();
                        for (int i = 0; i < files.length; i++) {
                            zipFile(files[i], ouputStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 删除指定文件夹下所有文件
    // param path 文件夹完整绝对路径
    public static void delAllFile(File file) {

        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                delAllFile(f);//递归删除每一个文件
                f.delete();//删除该文件夹
            }
        }
    }


}
