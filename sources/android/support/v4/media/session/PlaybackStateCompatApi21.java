package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class PlaybackStateCompatApi21 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CustomAction {
        public static String a(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        public static Bundle b(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }

        public static int c(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static CharSequence d(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }
    }

    public static long a(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static long b(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static long c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static List d(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static CharSequence e(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long f(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static float g(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long h(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static int i(Object obj) {
        return ((PlaybackState) obj).getState();
    }
}
