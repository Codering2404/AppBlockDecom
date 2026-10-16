package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HashMap f44588i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Handler f44589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TransferListener f44590k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f44591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MediaSourceEventListener.EventDispatcher f44592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private DrmSessionEventListener.EventDispatcher f44593c;

        public ForwardingEventListener(Object obj) {
            this.f44592b = CompositeMediaSource.this.V(null);
            this.f44593c = CompositeMediaSource.this.Q(null);
            this.f44591a = obj;
        }

        private boolean b(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodIdQ0;
            if (mediaPeriodId != null) {
                mediaPeriodIdQ0 = CompositeMediaSource.this.q0(this.f44591a, mediaPeriodId);
                if (mediaPeriodIdQ0 == null) {
                    return false;
                }
            } else {
                mediaPeriodIdQ0 = null;
            }
            int iS0 = CompositeMediaSource.this.s0(this.f44591a, i3);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.f44592b;
            if (eventDispatcher.f44759a != iS0 || !Objects.equals(eventDispatcher.f44760b, mediaPeriodIdQ0)) {
                this.f44592b = CompositeMediaSource.this.T(iS0, mediaPeriodIdQ0);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.f44593c;
            if (eventDispatcher2.f44056a == iS0 && Objects.equals(eventDispatcher2.f44057b, mediaPeriodIdQ0)) {
                return true;
            }
            this.f44593c = CompositeMediaSource.this.P(iS0, mediaPeriodIdQ0);
            return true;
        }

        private MediaLoadData d(MediaLoadData mediaLoadData, MediaSource.MediaPeriodId mediaPeriodId) {
            long jR0 = CompositeMediaSource.this.r0(this.f44591a, mediaLoadData.f44745f, mediaPeriodId);
            long jR02 = CompositeMediaSource.this.r0(this.f44591a, mediaLoadData.f44746g, mediaPeriodId);
            return (jR0 == mediaLoadData.f44745f && jR02 == mediaLoadData.f44746g) ? mediaLoadData : new MediaLoadData(mediaLoadData.f44740a, mediaLoadData.f44741b, mediaLoadData.f44742c, mediaLoadData.f44743d, mediaLoadData.f44744e, jR0, jR02);
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void E(int i3, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (b(i3, mediaPeriodId)) {
                this.f44592b.w(d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void N(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i3, mediaPeriodId)) {
                this.f44593c.h();
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void R(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i4) {
            if (b(i3, mediaPeriodId)) {
                this.f44592b.t(loadEventInfo, d(mediaLoadData, mediaPeriodId), i4);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void S(int i3, MediaSource.MediaPeriodId mediaPeriodId, int i4) {
            if (b(i3, mediaPeriodId)) {
                this.f44593c.k(i4);
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void U(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            if (b(i3, mediaPeriodId)) {
                this.f44592b.r(loadEventInfo, d(mediaLoadData, mediaPeriodId), iOException, z2);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void X(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i3, mediaPeriodId)) {
                this.f44593c.i();
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void Y(int i3, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (b(i3, mediaPeriodId)) {
                this.f44593c.l(exc);
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void Z(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i3, mediaPeriodId)) {
                this.f44592b.m(loadEventInfo, d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void g0(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i3, mediaPeriodId)) {
                this.f44592b.o(loadEventInfo, d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void h0(int i3, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (b(i3, mediaPeriodId)) {
                this.f44592b.k(d(mediaLoadData, mediaPeriodId));
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void i0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i3, mediaPeriodId)) {
                this.f44593c.j();
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void t0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i3, mediaPeriodId)) {
                this.f44593c.m();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaSourceAndListener<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaSource f44595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f44596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ForwardingEventListener f44597c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.f44595a = mediaSource;
            this.f44596b = mediaSourceCaller;
            this.f44597c = forwardingEventListener;
        }
    }

    protected CompositeMediaSource() {
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void L() {
        Iterator it = this.f44588i.values().iterator();
        while (it.hasNext()) {
            ((MediaSourceAndListener) it.next()).f44595a.L();
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void W() {
        for (MediaSourceAndListener mediaSourceAndListener : this.f44588i.values()) {
            mediaSourceAndListener.f44595a.K(mediaSourceAndListener.f44596b);
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void a0() {
        for (MediaSourceAndListener mediaSourceAndListener : this.f44588i.values()) {
            mediaSourceAndListener.f44595a.G(mediaSourceAndListener.f44596b);
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        this.f44590k = transferListener;
        this.f44589j = Util.C();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        for (MediaSourceAndListener mediaSourceAndListener : this.f44588i.values()) {
            mediaSourceAndListener.f44595a.J(mediaSourceAndListener.f44596b);
            mediaSourceAndListener.f44595a.d(mediaSourceAndListener.f44597c);
            mediaSourceAndListener.f44595a.u(mediaSourceAndListener.f44597c);
        }
        this.f44588i.clear();
    }

    protected final void o0(Object obj) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.e((MediaSourceAndListener) this.f44588i.get(obj));
        mediaSourceAndListener.f44595a.K(mediaSourceAndListener.f44596b);
    }

    protected final void p0(Object obj) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.e((MediaSourceAndListener) this.f44588i.get(obj));
        mediaSourceAndListener.f44595a.G(mediaSourceAndListener.f44596b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void v0(Object obj, MediaSource mediaSource, Timeline timeline);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w0(final Object obj, MediaSource mediaSource) {
        Assertions.a(!this.f44588i.containsKey(obj));
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: androidx.media3.exoplayer.source.b
            @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
            public final void z(MediaSource mediaSource2, Timeline timeline) {
                this.f45062a.v0(obj, mediaSource2, timeline);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(obj);
        this.f44588i.put(obj, new MediaSourceAndListener(mediaSource, mediaSourceCaller, forwardingEventListener));
        mediaSource.b((Handler) Assertions.e(this.f44589j), forwardingEventListener);
        mediaSource.t((Handler) Assertions.e(this.f44589j), forwardingEventListener);
        mediaSource.C(mediaSourceCaller, this.f44590k, b0());
        if (c0()) {
            return;
        }
        mediaSource.K(mediaSourceCaller);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x0(Object obj) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.e((MediaSourceAndListener) this.f44588i.remove(obj));
        mediaSourceAndListener.f44595a.J(mediaSourceAndListener.f44596b);
        mediaSourceAndListener.f44595a.d(mediaSourceAndListener.f44597c);
        mediaSourceAndListener.f44595a.u(mediaSourceAndListener.f44597c);
    }

    protected MediaSource.MediaPeriodId q0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    protected int s0(Object obj, int i3) {
        return i3;
    }

    protected long r0(Object obj, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        return j3;
    }
}
