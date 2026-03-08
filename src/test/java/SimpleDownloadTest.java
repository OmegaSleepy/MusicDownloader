import org.omega.service.DownloadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimpleDownloadTest {

    @Test
    public void testDownload() {
        DownloadService.download("https://www.youtube.com/watch?v=3N6YbsRxTf8");
    }
}
