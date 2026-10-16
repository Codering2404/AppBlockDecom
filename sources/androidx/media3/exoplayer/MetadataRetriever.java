package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataRetriever {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MetadataRetrieverInternal {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final SharedWorkerThread f43210e = new SharedWorkerThread();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaSource.Factory f43211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaItem f43212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HandlerWrapper f43213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SettableFuture f43214d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private final class MediaSourceHandlerCallback implements Handler.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final MediaSourceCaller f43215a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private MediaSource f43216b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private MediaPeriod f43217c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ MetadataRetrieverInternal f43218d;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private final class MediaSourceCaller implements MediaSource.MediaSourceCaller {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final MediaPeriodCallback f43219a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final Allocator f43220b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private boolean f43221c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ MediaSourceHandlerCallback f43222d;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                private final class MediaPeriodCallback implements MediaPeriod.Callback {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ MediaSourceCaller f43223a;

                    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void h(MediaPeriod mediaPeriod) {
                        this.f43223a.f43222d.f43218d.f43213c.b(3).a();
                    }

                    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
                    public void g(MediaPeriod mediaPeriod) {
                        this.f43223a.f43222d.f43218d.f43214d.B(mediaPeriod.s());
                        this.f43223a.f43222d.f43218d.f43213c.b(4).a();
                    }
                }

                @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
                public void z(MediaSource mediaSource, Timeline timeline) {
                    if (this.f43221c) {
                        return;
                    }
                    this.f43221c = true;
                    this.f43222d.f43217c = mediaSource.j(new MediaSource.MediaPeriodId(timeline.m(0)), this.f43220b, 0L);
                    this.f43222d.f43217c.r(this.f43219a, 0L);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i3 = message.what;
                if (i3 == 1) {
                    MediaSource mediaSourceC = this.f43218d.f43211a.c((MediaItem) message.obj);
                    this.f43216b = mediaSourceC;
                    mediaSourceC.C(this.f43215a, null, PlayerId.f43489d);
                    this.f43218d.f43213c.k(2);
                    return true;
                }
                if (i3 == 2) {
                    try {
                        MediaPeriod mediaPeriod = this.f43217c;
                        if (mediaPeriod == null) {
                            ((MediaSource) Assertions.e(this.f43216b)).L();
                        } else {
                            mediaPeriod.o();
                        }
                        this.f43218d.f43213c.a(2, 100);
                    } catch (Exception e3) {
                        this.f43218d.f43214d.C(e3);
                        this.f43218d.f43213c.b(4).a();
                    }
                    return true;
                }
                if (i3 == 3) {
                    ((MediaPeriod) Assertions.e(this.f43217c)).b(new LoadingInfo.Builder().f(0L).d());
                    return true;
                }
                if (i3 != 4) {
                    return false;
                }
                if (this.f43217c != null) {
                    ((MediaSource) Assertions.e(this.f43216b)).B(this.f43217c);
                }
                ((MediaSource) Assertions.e(this.f43216b)).J(this.f43215a);
                this.f43218d.f43213c.f(null);
                MetadataRetrieverInternal.f43210e.b();
                return true;
            }
        }

        public void e() {
            this.f43213c.e(1, this.f43212b).a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SharedWorkerThread {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f43224d = new AtomicInteger(5);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Deque f43225a = new ArrayDeque();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private HandlerThread f43226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f43227c;

        private void a() {
            if (!this.f43225a.isEmpty() && this.f43227c - this.f43225a.size() < f43224d.get()) {
                ((MetadataRetrieverInternal) this.f43225a.removeFirst()).e();
            }
        }

        public synchronized void b() {
            try {
                int i3 = this.f43227c - 1;
                this.f43227c = i3;
                if (i3 == 0) {
                    ((HandlerThread) Assertions.e(this.f43226b)).quit();
                    this.f43226b = null;
                } else {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
