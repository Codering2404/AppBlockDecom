package androidx.media3.exoplayer.drm;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface DrmSessionEventListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class EventDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f44057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f44058c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class ListenerAndHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f44059a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public DrmSessionEventListener f44060b;

            public ListenerAndHandler(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.f44059a = handler;
                this.f44060b = drmSessionEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public void g(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.e(handler);
            Assertions.e(drmSessionEventListener);
            this.f44058c.add(new ListenerAndHandler(handler, drmSessionEventListener));
        }

        public void h() {
            for (ListenerAndHandler listenerAndHandler : this.f44058c) {
                final DrmSessionEventListener drmSessionEventListener = listenerAndHandler.f44060b;
                Util.W0(listenerAndHandler.f44059a, new Runnable() { // from class: androidx.media3.exoplayer.drm.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f44109a;
                        drmSessionEventListener.N(eventDispatcher.f44056a, eventDispatcher.f44057b);
                    }
                });
            }
        }

        public void i() {
            for (ListenerAndHandler listenerAndHandler : this.f44058c) {
                final DrmSessionEventListener drmSessionEventListener = listenerAndHandler.f44060b;
                Util.W0(listenerAndHandler.f44059a, new Runnable() { // from class: androidx.media3.exoplayer.drm.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f44105a;
                        drmSessionEventListener.X(eventDispatcher.f44056a, eventDispatcher.f44057b);
                    }
                });
            }
        }

        public void j() {
            for (ListenerAndHandler listenerAndHandler : this.f44058c) {
                final DrmSessionEventListener drmSessionEventListener = listenerAndHandler.f44060b;
                Util.W0(listenerAndHandler.f44059a, new Runnable() { // from class: androidx.media3.exoplayer.drm.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f44107a;
                        drmSessionEventListener.i0(eventDispatcher.f44056a, eventDispatcher.f44057b);
                    }
                });
            }
        }

        public void k(final int i3) {
            for (ListenerAndHandler listenerAndHandler : this.f44058c) {
                final DrmSessionEventListener drmSessionEventListener = listenerAndHandler.f44060b;
                Util.W0(listenerAndHandler.f44059a, new Runnable() { // from class: androidx.media3.exoplayer.drm.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f44100a;
                        drmSessionEventListener.S(eventDispatcher.f44056a, eventDispatcher.f44057b, i3);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (ListenerAndHandler listenerAndHandler : this.f44058c) {
                final DrmSessionEventListener drmSessionEventListener = listenerAndHandler.f44060b;
                Util.W0(listenerAndHandler.f44059a, new Runnable() { // from class: androidx.media3.exoplayer.drm.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f44097a;
                        drmSessionEventListener.Y(eventDispatcher.f44056a, eventDispatcher.f44057b, exc);
                    }
                });
            }
        }

        public void m() {
            for (ListenerAndHandler listenerAndHandler : this.f44058c) {
                final DrmSessionEventListener drmSessionEventListener = listenerAndHandler.f44060b;
                Util.W0(listenerAndHandler.f44059a, new Runnable() { // from class: androidx.media3.exoplayer.drm.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.EventDispatcher eventDispatcher = this.f44103a;
                        drmSessionEventListener.t0(eventDispatcher.f44056a, eventDispatcher.f44057b);
                    }
                });
            }
        }

        public void n(DrmSessionEventListener drmSessionEventListener) {
            for (ListenerAndHandler listenerAndHandler : this.f44058c) {
                if (listenerAndHandler.f44060b == drmSessionEventListener) {
                    this.f44058c.remove(listenerAndHandler);
                }
            }
        }

        public EventDispatcher o(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f44058c, i3, mediaPeriodId);
        }

        private EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f44058c = copyOnWriteArrayList;
            this.f44056a = i3;
            this.f44057b = mediaPeriodId;
        }
    }

    default void N(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void X(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void i0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void t0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    default void S(int i3, MediaSource.MediaPeriodId mediaPeriodId, int i4) {
    }

    default void Y(int i3, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
    }
}
