package songs.services;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface ArtistJudge {
    List<String> topX(String path, int x);
}
