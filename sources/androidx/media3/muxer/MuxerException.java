package androidx.media3.muxer;

import androidx.media3.common.MediaLibraryInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MuxerException extends Exception {
    static {
        MediaLibraryInfo.a("media3.muxer");
    }

    public MuxerException(String str, Throwable th) {
        super(str, th);
    }
}
