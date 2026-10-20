package proxycacheyoutube.proxy.example.some_cool_media_library;

import java.util.HashMap;

public interface LibreriaYouTubeTerceros {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
