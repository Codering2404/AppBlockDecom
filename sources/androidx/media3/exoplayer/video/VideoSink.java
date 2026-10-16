package androidx.media3.exoplayer.video;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.exoplayer.Renderer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoSink {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Listener f45879a = new Listener() { // from class: androidx.media3.exoplayer.video.VideoSink.Listener.1
            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void a(VideoSink videoSink) {
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void d(VideoSink videoSink) {
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void b(VideoSink videoSink, VideoSize videoSize) {
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void c(VideoSink videoSink, VideoSinkException videoSinkException) {
            }
        };

        void a(VideoSink videoSink);

        void b(VideoSink videoSink, VideoSize videoSize);

        void c(VideoSink videoSink, VideoSinkException videoSinkException);

        void d(VideoSink videoSink);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface VideoFrameHandler {
        void a(long j3);

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class VideoSinkException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f45880a;

        public VideoSinkException(Throwable th, Format format) {
            super(th);
            this.f45880a = format;
        }
    }

    void A(boolean z2);

    void B(Listener listener, Executor executor);

    Surface a();

    boolean b();

    void c();

    void d();

    boolean e(long j3, boolean z2, VideoFrameHandler videoFrameHandler);

    void f();

    void g(VideoFrameMetadataListener videoFrameMetadataListener);

    void h(long j3, long j4);

    void i(long j3, long j4);

    boolean isInitialized();

    void j();

    void k(Renderer.WakeupListener wakeupListener);

    void l(List list);

    boolean m(boolean z2);

    boolean n(Format format);

    void o(boolean z2);

    void p();

    void q(int i3, Format format, List list);

    void r(Surface surface, Size size);

    void release();

    void s();

    void t(int i3);

    void u(float f3);

    void v();

    void x(boolean z2);

    boolean y(Bitmap bitmap, TimestampIterator timestampIterator);
}
