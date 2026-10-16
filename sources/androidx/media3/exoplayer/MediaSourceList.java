package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MediaSourceList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlayerId f43188a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MediaSourceListInfoRefreshListener f43192e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AnalyticsCollector f43195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HandlerWrapper f43196i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f43198k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TransferListener f43199l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ShuffleOrder f43197j = new ShuffleOrder.DefaultShuffleOrder(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IdentityHashMap f43190c = new IdentityHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f43191d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f43189b = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f43193f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f43194g = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaSourceHolder f43200a;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.f43200a = mediaSourceHolder;
        }

        private Pair J(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId mediaPeriodIdN = MediaSourceList.n(this.f43200a, mediaPeriodId);
                if (mediaPeriodIdN == null) {
                    return null;
                }
                mediaPeriodId2 = mediaPeriodIdN;
            }
            return Pair.create(Integer.valueOf(MediaSourceList.s(this.f43200a, i3)), mediaPeriodId2);
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void E(int i3, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.c2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f43965a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.E(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) Assertions.e((MediaSource.MediaPeriodId) pair.second), mediaLoadData);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void N(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.e2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44116a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.N(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void R(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final int i4) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.l2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44186a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.R(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, i4);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void S(int i3, MediaSource.MediaPeriodId mediaPeriodId, final int i4) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.k2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44182a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.S(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i4);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void U(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z2) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.m2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44196a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.U(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z2);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void X(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.n2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44354a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.X(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void Y(int i3, MediaSource.MediaPeriodId mediaPeriodId, final Exception exc) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.g2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44128a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.Y(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, exc);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void Z(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.f2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44121a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.Z(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void g0(int i3, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.j2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44176a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.g0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
        public void h0(int i3, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.h2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44137a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.h0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, mediaLoadData);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void i0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.d2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f43972a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.i0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void t0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            final Pair pairJ = J(i3, mediaPeriodId);
            if (pairJ != null) {
                MediaSourceList.this.f43196i.j(new Runnable() { // from class: androidx.media3.exoplayer.i2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f44143a;
                        Pair pair = pairJ;
                        MediaSourceList.this.f43195h.t0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaSourceAndListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaSource f43202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f43203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ForwardingEventListener f43204c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.f43202a = mediaSource;
            this.f43203b = mediaSourceCaller;
            this.f43204c = forwardingEventListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MediaSourceHolder implements MediaSourceInfoHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MaskingMediaSource f43205a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f43208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f43209e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f43207c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f43206b = new Object();

        public MediaSourceHolder(MediaSource mediaSource, boolean z2) {
            this.f43205a = new MaskingMediaSource(mediaSource, z2);
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public Object a() {
            return this.f43206b;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public Timeline b() {
            return this.f43205a.L0();
        }

        public void c(int i3) {
            this.f43208d = i3;
            this.f43209e = false;
            this.f43207c.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MediaSourceListInfoRefreshListener {
        void c();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, PlayerId playerId) {
        this.f43188a = playerId;
        this.f43192e = mediaSourceListInfoRefreshListener;
        this.f43195h = analyticsCollector;
        this.f43196i = handlerWrapper;
    }

    private void B(int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f43189b.remove(i5);
            this.f43191d.remove(mediaSourceHolder.f43206b);
            g(i5, -mediaSourceHolder.f43205a.L0().p());
            mediaSourceHolder.f43209e = true;
            if (this.f43198k) {
                u(mediaSourceHolder);
            }
        }
    }

    private void g(int i3, int i4) {
        while (i3 < this.f43189b.size()) {
            ((MediaSourceHolder) this.f43189b.get(i3)).f43208d += i4;
            i3++;
        }
    }

    private void j(MediaSourceHolder mediaSourceHolder) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.f43193f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f43202a.K(mediaSourceAndListener.f43203b);
        }
    }

    private void k() {
        Iterator it = this.f43194g.iterator();
        while (it.hasNext()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
            if (mediaSourceHolder.f43207c.isEmpty()) {
                j(mediaSourceHolder);
                it.remove();
            }
        }
    }

    private void l(MediaSourceHolder mediaSourceHolder) {
        this.f43194g.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) this.f43193f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f43202a.G(mediaSourceAndListener.f43203b);
        }
    }

    private static Object m(Object obj) {
        return AbstractConcatenatedTimeline.v(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSource.MediaPeriodId n(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i3 = 0; i3 < mediaSourceHolder.f43207c.size(); i3++) {
            if (((MediaSource.MediaPeriodId) mediaSourceHolder.f43207c.get(i3)).f44757d == mediaPeriodId.f44757d) {
                return mediaPeriodId.a(p(mediaSourceHolder, mediaPeriodId.f44754a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return AbstractConcatenatedTimeline.w(obj);
    }

    private static Object p(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.y(mediaSourceHolder.f43206b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int s(MediaSourceHolder mediaSourceHolder, int i3) {
        return i3 + mediaSourceHolder.f43208d;
    }

    private void u(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f43209e && mediaSourceHolder.f43207c.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.e((MediaSourceAndListener) this.f43193f.remove(mediaSourceHolder));
            mediaSourceAndListener.f43202a.J(mediaSourceAndListener.f43203b);
            mediaSourceAndListener.f43202a.d(mediaSourceAndListener.f43204c);
            mediaSourceAndListener.f43202a.u(mediaSourceAndListener.f43204c);
            this.f43194g.remove(mediaSourceHolder);
        }
    }

    private void x(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.f43205a;
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: androidx.media3.exoplayer.b2
            @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
            public final void z(MediaSource mediaSource, Timeline timeline) {
                this.f43960a.f43192e.c();
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.f43193f.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, mediaSourceCaller, forwardingEventListener));
        maskingMediaSource.b(Util.E(), forwardingEventListener);
        maskingMediaSource.t(Util.E(), forwardingEventListener);
        maskingMediaSource.C(mediaSourceCaller, this.f43199l, this.f43188a);
    }

    public Timeline A(int i3, int i4, ShuffleOrder shuffleOrder) {
        Assertions.a(i3 >= 0 && i3 <= i4 && i4 <= r());
        this.f43197j = shuffleOrder;
        B(i3, i4);
        return i();
    }

    public Timeline C(List list, ShuffleOrder shuffleOrder) {
        B(0, this.f43189b.size());
        return f(this.f43189b.size(), list, shuffleOrder);
    }

    public Timeline D(ShuffleOrder shuffleOrder) {
        int iR = r();
        if (shuffleOrder.getLength() != iR) {
            shuffleOrder = shuffleOrder.e().g(0, iR);
        }
        this.f43197j = shuffleOrder;
        return i();
    }

    public Timeline E(int i3, int i4, List list) {
        Assertions.a(i3 >= 0 && i3 <= i4 && i4 <= r());
        Assertions.a(list.size() == i4 - i3);
        for (int i5 = i3; i5 < i4; i5++) {
            ((MediaSourceHolder) this.f43189b.get(i5)).f43205a.H((MediaItem) list.get(i5 - i3));
        }
        return i();
    }

    public Timeline f(int i3, List list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.f43197j = shuffleOrder;
            for (int i4 = i3; i4 < list.size() + i3; i4++) {
                MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) list.get(i4 - i3);
                if (i4 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = (MediaSourceHolder) this.f43189b.get(i4 - 1);
                    mediaSourceHolder.c(mediaSourceHolder2.f43208d + mediaSourceHolder2.f43205a.L0().p());
                } else {
                    mediaSourceHolder.c(0);
                }
                g(i4, mediaSourceHolder.f43205a.L0().p());
                this.f43189b.add(i4, mediaSourceHolder);
                this.f43191d.put(mediaSourceHolder.f43206b, mediaSourceHolder);
                if (this.f43198k) {
                    x(mediaSourceHolder);
                    if (this.f43190c.isEmpty()) {
                        this.f43194g.add(mediaSourceHolder);
                    } else {
                        j(mediaSourceHolder);
                    }
                }
            }
        }
        return i();
    }

    public MediaPeriod h(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        Object objO = o(mediaPeriodId.f44754a);
        MediaSource.MediaPeriodId mediaPeriodIdA = mediaPeriodId.a(m(mediaPeriodId.f44754a));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.e((MediaSourceHolder) this.f43191d.get(objO));
        l(mediaSourceHolder);
        mediaSourceHolder.f43207c.add(mediaPeriodIdA);
        MaskingMediaPeriod maskingMediaPeriodJ = mediaSourceHolder.f43205a.j(mediaPeriodIdA, allocator, j3);
        this.f43190c.put(maskingMediaPeriodJ, mediaSourceHolder);
        k();
        return maskingMediaPeriodJ;
    }

    public Timeline i() {
        if (this.f43189b.isEmpty()) {
            return Timeline.f41105a;
        }
        int iP = 0;
        for (int i3 = 0; i3 < this.f43189b.size(); i3++) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f43189b.get(i3);
            mediaSourceHolder.f43208d = iP;
            iP += mediaSourceHolder.f43205a.L0().p();
        }
        return new PlaylistTimeline(this.f43189b, this.f43197j);
    }

    public ShuffleOrder q() {
        return this.f43197j;
    }

    public int r() {
        return this.f43189b.size();
    }

    public boolean t() {
        return this.f43198k;
    }

    public Timeline v(int i3, int i4, int i5, ShuffleOrder shuffleOrder) {
        Assertions.a(i3 >= 0 && i3 <= i4 && i4 <= r() && i5 >= 0);
        this.f43197j = shuffleOrder;
        if (i3 == i4 || i3 == i5) {
            return i();
        }
        int iMin = Math.min(i3, i5);
        int iMax = Math.max(((i4 - i3) + i5) - 1, i4 - 1);
        int iP = ((MediaSourceHolder) this.f43189b.get(iMin)).f43208d;
        Util.O0(this.f43189b, i3, i4, i5);
        while (iMin <= iMax) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f43189b.get(iMin);
            mediaSourceHolder.f43208d = iP;
            iP += mediaSourceHolder.f43205a.L0().p();
            iMin++;
        }
        return i();
    }

    public void w(TransferListener transferListener) {
        Assertions.g(!this.f43198k);
        this.f43199l = transferListener;
        for (int i3 = 0; i3 < this.f43189b.size(); i3++) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f43189b.get(i3);
            x(mediaSourceHolder);
            this.f43194g.add(mediaSourceHolder);
        }
        this.f43198k = true;
    }

    public void y() {
        for (MediaSourceAndListener mediaSourceAndListener : this.f43193f.values()) {
            try {
                mediaSourceAndListener.f43202a.J(mediaSourceAndListener.f43203b);
            } catch (RuntimeException e3) {
                Log.e("MediaSourceList", "Failed to release child source.", e3);
            }
            mediaSourceAndListener.f43202a.d(mediaSourceAndListener.f43204c);
            mediaSourceAndListener.f43202a.u(mediaSourceAndListener.f43204c);
        }
        this.f43193f.clear();
        this.f43194g.clear();
        this.f43198k = false;
    }

    public void z(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.e((MediaSourceHolder) this.f43190c.remove(mediaPeriod));
        mediaSourceHolder.f43205a.B(mediaPeriod);
        mediaSourceHolder.f43207c.remove(((MaskingMediaPeriod) mediaPeriod).f44719a);
        if (!this.f43190c.isEmpty()) {
            k();
        }
        u(mediaSourceHolder);
    }
}
