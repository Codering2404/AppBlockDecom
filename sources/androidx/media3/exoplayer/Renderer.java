package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Renderer extends PlayerMessage.Target {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface WakeupListener {
        void a();

        void b();
    }

    boolean B();

    default long E(long j3, long j4) {
        return 10000L;
    }

    void F(Timeline timeline);

    RendererCapabilities H();

    long O();

    void P(long j3);

    MediaClock Q();

    boolean b();

    void c();

    int g();

    String getName();

    int getState();

    void h(long j3, long j4);

    SampleStream i();

    boolean isReady();

    boolean k();

    void m(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j3, boolean z2, boolean z3, long j4, long j5, MediaSource.MediaPeriodId mediaPeriodId);

    void o(int i3, PlayerId playerId, Clock clock);

    void p();

    void reset();

    void start();

    void stop();

    void x(Format[] formatArr, SampleStream sampleStream, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId);

    void y();

    default void f() {
    }

    default void release() {
    }

    default void L(float f3, float f4) {
    }
}
