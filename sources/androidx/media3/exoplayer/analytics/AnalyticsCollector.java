package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AnalyticsCollector extends Player.Listener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    void A(long j3, int i3);

    void D(List list, MediaSource.MediaPeriodId mediaPeriodId);

    void I();

    void a(AudioSink.AudioTrackConfig audioTrackConfig);

    void c(AudioSink.AudioTrackConfig audioTrackConfig);

    void d0(AnalyticsListener analyticsListener);

    void e(Exception exc);

    void f(String str);

    void g(String str, long j3, long j4);

    void h(String str);

    void i(String str, long j3, long j4);

    void k(DecoderCounters decoderCounters);

    void k0(int i3, int i4, boolean z2);

    void l(DecoderCounters decoderCounters);

    void n(long j3);

    void o(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void p(Exception exc);

    void q(DecoderCounters decoderCounters);

    void r(int i3, long j3);

    void release();

    void s(Object obj, long j3);

    void u0(Player player, Looper looper);

    void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void w(DecoderCounters decoderCounters);

    void x(Exception exc);

    void y(int i3, long j3, long j4);
}
