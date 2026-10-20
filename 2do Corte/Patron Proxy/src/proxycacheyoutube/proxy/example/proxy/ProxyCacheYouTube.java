package proxycacheyoutube.proxy.example.proxy;

import proxycacheyoutube.proxy.example.some_cool_media_library.LibreriaYouTubeTerceros;
import proxycacheyoutube.proxy.example.some_cool_media_library.ServicioYouTubeTerceros;
import proxycacheyoutube.proxy.example.some_cool_media_library.Video;

import java.util.HashMap;

public class ProxyCacheYouTube implements LibreriaYouTubeTerceros {
    private LibreriaYouTubeTerceros youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    public ProxyCacheYouTube() {
        this.youtubeService = new ServicioYouTubeTerceros();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
