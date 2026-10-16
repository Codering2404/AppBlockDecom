package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AdsLoader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EventListener {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Provider {
        AdsLoader a(MediaItem.AdsConfiguration adsConfiguration);
    }

    void a(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    void b(AdsMediaSource adsMediaSource, EventListener eventListener);

    void c(AdsMediaSource adsMediaSource, int i3, int i4);

    void e(int... iArr);

    void f(AdsMediaSource adsMediaSource, int i3, int i4, IOException iOException);

    default void d(AdsMediaSource adsMediaSource, Timeline timeline) {
    }
}
