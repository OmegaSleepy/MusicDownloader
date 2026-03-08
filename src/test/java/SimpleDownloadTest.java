import org.omega.service.DownloadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.omega.util.Method;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimpleDownloadTest {

    @Test
    public void testDownload() {
        DownloadService.downloadSingle("https://www.youtube.com/watch?v=3N6YbsRxTf8", Method.AUDIO);
    }

    @Test
    public void testDownload2() {
        DownloadService.downloadSingle("https://www.youtube.com/watch?v=3N6YbsRxTf8", Method.VIDEO);
    }

    @Test
    public void testDownload3() {
        DownloadService.downloadMultiple("https://youtube.com/playlist?list=OLAK5uy_kdpxq-hy6u56F2eqtN3O-q0b2eSOXs9xQ&si=eP_4I8PizJDFJMK5", Method.AUDIO);
    }
}
