package androidx.media3.exoplayer.source.preload;

import androidx.media3.common.MediaItem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PreloadException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaItem f45217a;

    public PreloadException(MediaItem mediaItem, String str, Throwable th) {
        super(str, th);
        this.f45217a = mediaItem;
    }
}
