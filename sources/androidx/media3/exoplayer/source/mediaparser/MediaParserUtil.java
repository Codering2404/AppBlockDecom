package androidx.media3.exoplayer.source.mediaparser;

import android.media.MediaParser;
import android.media.metrics.LogSessionId;
import androidx.media3.exoplayer.analytics.PlayerId;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaParserUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api31 {
        public static void a(MediaParser mediaParser, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            mediaParser.setLogSessionId(logSessionIdA);
        }
    }

    public static void a(MediaParser mediaParser, PlayerId playerId) {
        Api31.a(mediaParser, playerId);
    }
}
