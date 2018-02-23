import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Calendar;

/**
 * @Author 黄昌焕
 * @Date 2018-01-18  16:44
 */
public class ParseTaoBaoVoucher {
    private static final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
    static{
        webClient.getOptions().setCssEnabled(false);// 禁用css支持

        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setRedirectEnabled(true);

        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true); // 启用JS解释器，默认为true
        webClient.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
        webClient.getOptions().setTimeout(25000);
        webClient.getOptions().setUseInsecureSSL(true);
    }
    public static void main(String[] args) {


        Runnable r = () -> System.out.println("hello world");


        String url = "https://uland.taobao.com/coupon/edetail?e=pcZlpvD1bRMGQASttHIRqZ2KcAURoJ3cTmsRLnpaQQhpQaXy6DC%2BsCd7ahx5NnUj9rQ7tKm8Bbe9oQz4KvtM0b9fwBwwUiqlcCoFqbpg3AQmuWBlXFVRhG7PVn13QcLNgPRfTgnhrZM%3D&traceId=0ab2909b15162702564635585e&activityId=3a759631eaeb44f5ab357c27eb9b5a87&itemId=558938841631";

        //System.out.println(page.asXml());
        //webClient.closeAllWindows();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1516273053303l);
        System.out.println(calendar.getTime());
        try{
            HtmlPage page=webClient.getPage(url);
            webClient.waitForBackgroundJavaScript(20000);
            Document doc = Jsoup.parse(page.asXml());
            System.out.println(doc);
            //Document doc = Jsoup.connect(url).validateTLSCertificates(false).get();
        } catch (Exception e) {

        }
    }
}

