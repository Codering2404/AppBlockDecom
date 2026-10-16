package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class MediaMetadataCompatApi21 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    public static void a(Object obj, Parcel parcel, int i3) {
        ((MediaMetadata) obj).writeToParcel(parcel, i3);
    }
}
