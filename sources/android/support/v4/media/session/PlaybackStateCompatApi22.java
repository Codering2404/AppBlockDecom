package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class PlaybackStateCompatApi22 {
    public static Bundle a(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }
}
