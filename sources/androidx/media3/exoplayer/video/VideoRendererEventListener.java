package androidx.media3.exoplayer.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoRendererEventListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EventDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f45877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final VideoRendererEventListener f45878b;

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            this.f45877a = videoRendererEventListener != null ? (Handler) Assertions.e(handler) : null;
            this.f45878b = videoRendererEventListener;
        }

        public static /* synthetic */ void d(EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
            eventDispatcher.getClass();
            decoderCounters.c();
            ((VideoRendererEventListener) Util.k(eventDispatcher.f45878b)).w(decoderCounters);
        }

        public void k(final String str, final long j3, final long j4) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f45897a.f45878b)).g(str, j3, j4);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f46008a.f45878b)).f(str);
                    }
                });
            }
        }

        public void m(final DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener.EventDispatcher.d(this.f46006a, decoderCounters);
                    }
                });
            }
        }

        public void n(final int i3, final long j3) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f45903a.f45878b)).r(i3, j3);
                    }
                });
            }
        }

        public void o(final DecoderCounters decoderCounters) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f46001a.f45878b)).l(decoderCounters);
                    }
                });
            }
        }

        public void p(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f46003a.f45878b)).v(format, decoderReuseEvaluation);
                    }
                });
            }
        }

        public void q(final Object obj) {
            if (this.f45877a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f45877a.post(new Runnable() { // from class: androidx.media3.exoplayer.video.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f45906a.f45878b)).s(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void r(final long j3, final int i3) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f45909a.f45878b)).A(j3, i3);
                    }
                });
            }
        }

        public void s(final Exception exc) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f45999a.f45878b)).p(exc);
                    }
                });
            }
        }

        public void t(final VideoSize videoSize) {
            Handler handler = this.f45877a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((VideoRendererEventListener) Util.k(this.f45901a.f45878b)).b(videoSize);
                    }
                });
            }
        }
    }

    default void b(VideoSize videoSize) {
    }

    default void f(String str) {
    }

    default void l(DecoderCounters decoderCounters) {
    }

    default void p(Exception exc) {
    }

    default void w(DecoderCounters decoderCounters) {
    }

    default void A(long j3, int i3) {
    }

    default void r(int i3, long j3) {
    }

    default void s(Object obj, long j3) {
    }

    default void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void g(String str, long j3, long j4) {
    }
}
