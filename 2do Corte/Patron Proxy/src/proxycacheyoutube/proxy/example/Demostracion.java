package proxycacheyoutube.proxy.example;

import proxycacheyoutube.proxy.example.downloader.DescargadorYouTube;
import proxycacheyoutube.proxy.example.proxy.ProxyCacheYouTube;
import proxycacheyoutube.proxy.example.some_cool_media_library.ServicioYouTubeTerceros;

public class Demostracion {

    public static void main(String[] args) {
        DescargadorYouTube naiveDownloader = new DescargadorYouTube(new ServicioYouTubeTerceros());
        DescargadorYouTube smartDownloader = new DescargadorYouTube(new ProxyCacheYouTube());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(DescargadorYouTube downloader) {
        long startTime = System.currentTimeMillis();

        // Comportamiento del usuario en nuestra aplicación:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Los usuarios suelen visitar la misma página con bastante frecuencia.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
