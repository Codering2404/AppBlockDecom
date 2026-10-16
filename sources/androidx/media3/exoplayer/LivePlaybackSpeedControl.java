package androidx.media3.exoplayer;

import androidx.media3.common.MediaItem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface LivePlaybackSpeedControl {
    void a(MediaItem.LiveConfiguration liveConfiguration);

    float b(long j3, long j4);

    long c();

    void d();

    void e(long j3);
}
