package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AudioRendererEventListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EventDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f43700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioRendererEventListener f43701b;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.f43700a = audioRendererEventListener != null ? (Handler) Assertions.e(handler) : null;
            this.f43701b = audioRendererEventListener;
        }

        public static /* synthetic */ void d(EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
            eventDispatcher.getClass();
            decoderCounters.c();
            ((AudioRendererEventListener) Util.k(eventDispatcher.f43701b)).q(decoderCounters);
        }

        public void m(final Exception exc) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43929a.f43701b)).x(exc);
                    }
                });
            }
        }

        public void n(final Exception exc) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43931a.f43701b)).e(exc);
                    }
                });
            }
        }

        public void o(final AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43925a.f43701b)).a(audioTrackConfig);
                    }
                });
            }
        }

        public void p(final AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43927a.f43701b)).c(audioTrackConfig);
                    }
                });
            }
        }

        public void q(final String str, final long j3, final long j4) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43936a.f43701b)).i(str, j3, j4);
                    }
                });
            }
        }

        public void r(final String str) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43940a.f43701b)).h(str);
                    }
                });
            }
        }

        public void s(final DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.d(this.f43942a, decoderCounters);
                    }
                });
            }
        }

        public void t(final DecoderCounters decoderCounters) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43923a.f43701b)).k(decoderCounters);
                    }
                });
            }
        }

        public void u(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43933a.f43701b)).o(format, decoderReuseEvaluation);
                    }
                });
            }
        }

        public void v(final long j3) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43944a.f43701b)).n(j3);
                    }
                });
            }
        }

        public void w(final boolean z2) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43950a.f43701b)).d(z2);
                    }
                });
            }
        }

        public void x(final int i3, final long j3, final long j4) {
            Handler handler = this.f43700a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((AudioRendererEventListener) Util.k(this.f43946a.f43701b)).y(i3, j3, j4);
                    }
                });
            }
        }
    }

    default void a(AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void c(AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void d(boolean z2) {
    }

    default void e(Exception exc) {
    }

    default void h(String str) {
    }

    default void k(DecoderCounters decoderCounters) {
    }

    default void n(long j3) {
    }

    default void q(DecoderCounters decoderCounters) {
    }

    default void x(Exception exc) {
    }

    default void o(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void i(String str, long j3, long j4) {
    }

    default void y(int i3, long j3, long j4) {
    }
}
