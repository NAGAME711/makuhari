package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author i7403
 *
 */
@Controller
public class FileDown {

	@RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
            Model model)throws Exception {
      
       String path = "C:\\temp";
       String filename="日本語フォルダ日本語ファイル名.txt";
       File file = new File(path + File.separator + filename);
       HttpHeaders headers = new HttpHeaders();  
       //ファイルが化けない処理 
       String downloadFielName=urlEncode(filename);

       headers.setContentDispositionFormData("attachment", downloadFielName); 
       //application/octet-stream
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
               headers, HttpStatus.OK);  
    }   
    /**
     * @param fileName
     * @return 化けないファイル名
     */
    public static String urlEncode(String fileName) {
       
        URLCodec codec = new URLCodec("UTF-8");
        String encodeFileName = "";
        try {
            encodeFileName = codec.encode(fileName);
        } catch (EncoderException e) {
    
            return "bad_fine_name";
        }
        return encodeFileName.replaceAll("\\+", "%20").replaceAll("%2B", "+");
    }
 

	
}
