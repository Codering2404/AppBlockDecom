package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaSourceEventListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class EventDispatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f44760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f44761c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class ListenerAndHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f44762a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public MediaSourceEventListener f44763b;

            public ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.f44762a = handler;
                this.f44763b = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public void h(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.e(handler);
            Assertions.e(mediaSourceEventListener);
            this.f44761c.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void i(final Consumer consumer) {
            for (ListenerAndHandler listenerAndHandler : this.f44761c) {
                final MediaSourceEventListener mediaSourceEventListener = listenerAndHandler.f44763b;
                Util.W0(listenerAndHandler.f44762a, new Runnable() { // from class: androidx.media3.exoplayer.source.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        consumer.accept(mediaSourceEventListener);
                    }
                });
            }
        }

        public void j(int i3, Format format, int i4, Object obj, long j3) {
            k(new MediaLoadData(1, i3, format, i4, obj, Util.t1(j3), -9223372036854775807L));
        }

        public void k(final MediaLoadData mediaLoadData) {
            i(new Consumer() { // from class: androidx.media3.exoplayer.source.t
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher eventDispatcher = this.f45274a;
                    ((MediaSourceEventListener) obj).h0(eventDispatcher.f44759a, eventDispatcher.f44760b, mediaLoadData);
                }
            });
        }

        public void l(LoadEventInfo loadEventInfo, int i3, int i4, Format format, int i5, Object obj, long j3, long j4) {
            m(loadEventInfo, new MediaLoadData(i3, i4, format, i5, obj, Util.t1(j3), Util.t1(j4)));
        }

        public void m(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            i(new Consumer() { // from class: androidx.media3.exoplayer.source.x
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher eventDispatcher = this.f45288a;
                    ((MediaSourceEventListener) obj).Z(eventDispatcher.f44759a, eventDispatcher.f44760b, loadEventInfo, mediaLoadData);
                }
            });
        }

        public void n(LoadEventInfo loadEventInfo, int i3, int i4, Format format, int i5, Object obj, long j3, long j4) {
            o(loadEventInfo, new MediaLoadData(i3, i4, format, i5, obj, Util.t1(j3), Util.t1(j4)));
        }

        public void o(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            i(new Consumer() { // from class: androidx.media3.exoplayer.source.v
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher eventDispatcher = this.f45280a;
                    ((MediaSourceEventListener) obj).g0(eventDispatcher.f44759a, eventDispatcher.f44760b, loadEventInfo, mediaLoadData);
                }
            });
        }

        public void p(LoadEventInfo loadEventInfo, int i3, int i4, Format format, int i5, Object obj, long j3, long j4, IOException iOException, boolean z2) {
            r(loadEventInfo, new MediaLoadData(i3, i4, format, i5, obj, Util.t1(j3), Util.t1(j4)), iOException, z2);
        }

        public void q(LoadEventInfo loadEventInfo, int i3, IOException iOException, boolean z2) {
            p(loadEventInfo, i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z2);
        }

        public void r(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z2) {
            i(new Consumer() { // from class: androidx.media3.exoplayer.source.w
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher eventDispatcher = this.f45283a;
                    ((MediaSourceEventListener) obj).U(eventDispatcher.f44759a, eventDispatcher.f44760b, loadEventInfo, mediaLoadData, iOException, z2);
                }
            });
        }

        public void s(LoadEventInfo loadEventInfo, int i3, int i4, Format format, int i5, Object obj, long j3, long j4, int i6) {
            t(loadEventInfo, new MediaLoadData(i3, i4, format, i5, obj, Util.t1(j3), Util.t1(j4)), i6);
        }

        public void t(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final int i3) {
            i(new Consumer() { // from class: androidx.media3.exoplayer.source.u
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher eventDispatcher = this.f45276a;
                    ((MediaSourceEventListener) obj).R(eventDispatcher.f44759a, eventDispatcher.f44760b, loadEventInfo, mediaLoadData, i3);
                }
            });
        }

        public void u(MediaSourceEventListener mediaSourceEventListener) {
            for (ListenerAndHandler listenerAndHandler : this.f44761c) {
                if (listenerAndHandler.f44763b == mediaSourceEventListener) {
                    this.f44761c.remove(listenerAndHandler);
                }
            }
        }

        public void v(int i3, long j3, long j4) {
            w(new MediaLoadData(1, i3, null, 3, null, Util.t1(j3), Util.t1(j4)));
        }

        public void w(final MediaLoadData mediaLoadData) {
            final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.e(this.f44760b);
            i(new Consumer() { // from class: androidx.media3.exoplayer.source.y
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener mediaSourceEventListener = (MediaSourceEventListener) obj;
                    mediaSourceEventListener.E(this.f45291a.f44759a, mediaPeriodId, mediaLoadData);
                }
            });
        }

        public EventDispatcher x(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f44761c, i3, mediaPeriodId);
        }

        private EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f44761c = copyOnWriteArrayList;
            this.f44759a = i3;
            this.f44760b = mediaPeriodId;
        }
    }

    default void E(int i3, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    default void h0(int i3, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    default void Z(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void g0(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void R(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i4) {
    }

    default void U(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
    }
}
