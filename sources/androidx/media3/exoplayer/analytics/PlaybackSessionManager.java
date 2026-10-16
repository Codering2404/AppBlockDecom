package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface PlaybackSessionManager {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void B0(AnalyticsListener.EventTime eventTime, String str);

        void c(AnalyticsListener.EventTime eventTime, String str, String str2);

        void m0(AnalyticsListener.EventTime eventTime, String str, boolean z2);

        void y0(AnalyticsListener.EventTime eventTime, String str);
    }

    void a(AnalyticsListener.EventTime eventTime);

    String b();

    String c(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId);

    boolean d(AnalyticsListener.EventTime eventTime, String str);

    void e(AnalyticsListener.EventTime eventTime);

    void f(AnalyticsListener.EventTime eventTime);

    void g(Listener listener);

    void h(AnalyticsListener.EventTime eventTime, int i3);
}
