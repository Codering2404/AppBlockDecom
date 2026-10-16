package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final MediaItem f44602x = new MediaItem.Builder().k(Uri.EMPTY).a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f44603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f44604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Handler f44605n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f44606o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final IdentityHashMap f44607p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Map f44608q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Set f44609r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f44610s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f44611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f44612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Set f44613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ShuffleOrder f44614w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f44615h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f44616i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int[] f44617j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int[] f44618k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Timeline[] f44619l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Object[] f44620m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final HashMap f44621n;

        public ConcatenatedTimeline(Collection collection, ShuffleOrder shuffleOrder, boolean z2) {
            super(z2, shuffleOrder);
            int size = collection.size();
            this.f44617j = new int[size];
            this.f44618k = new int[size];
            this.f44619l = new Timeline[size];
            this.f44620m = new Object[size];
            this.f44621n = new HashMap();
            Iterator it = collection.iterator();
            int iP = 0;
            int i3 = 0;
            int i4 = 0;
            while (it.hasNext()) {
                MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
                this.f44619l[i4] = mediaSourceHolder.f44624a.L0();
                this.f44618k[i4] = iP;
                this.f44617j[i4] = i3;
                iP += this.f44619l[i4].p();
                i3 += this.f44619l[i4].i();
                Object[] objArr = this.f44620m;
                Object obj = mediaSourceHolder.f44625b;
                objArr[i4] = obj;
                this.f44621n.put(obj, Integer.valueOf(i4));
                i4++;
            }
            this.f44615h = iP;
            this.f44616i = i3;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int A(int i3) {
            return this.f44618k[i3];
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected Timeline D(int i3) {
            return this.f44619l[i3];
        }

        @Override // androidx.media3.common.Timeline
        public int i() {
            return this.f44616i;
        }

        @Override // androidx.media3.common.Timeline
        public int p() {
            return this.f44615h;
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int s(Object obj) {
            Integer num = (Integer) this.f44621n.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int t(int i3) {
            return Util.i(this.f44617j, i3 + 1, false, false);
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int u(int i3) {
            return Util.i(this.f44618k, i3 + 1, false, false);
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected Object x(int i3) {
            return this.f44620m[i3];
        }

        @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
        protected int z(int i3) {
            return this.f44617j[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HandlerAndRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f44622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f44623b;

        public void a() {
            this.f44622a.post(this.f44623b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MediaSourceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MaskingMediaSource f44624a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f44627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f44628e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f44629f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f44626c = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f44625b = new Object();

        public MediaSourceHolder(MediaSource mediaSource, boolean z2) {
            this.f44624a = new MaskingMediaSource(mediaSource, z2);
        }

        public void a(int i3, int i4) {
            this.f44627d = i3;
            this.f44628e = i4;
            this.f44629f = false;
            this.f44626c.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MessageData<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f44631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HandlerAndRunnable f44632c;
    }

    private void A0(int i3, MediaSourceHolder mediaSourceHolder) {
        if (i3 > 0) {
            MediaSourceHolder mediaSourceHolder2 = (MediaSourceHolder) this.f44606o.get(i3 - 1);
            mediaSourceHolder.a(i3, mediaSourceHolder2.f44628e + mediaSourceHolder2.f44624a.L0().p());
        } else {
            mediaSourceHolder.a(i3, 0);
        }
        C0(i3, 1, mediaSourceHolder.f44624a.L0().p());
        this.f44606o.add(i3, mediaSourceHolder);
        this.f44608q.put(mediaSourceHolder.f44625b, mediaSourceHolder);
        w0(mediaSourceHolder, mediaSourceHolder.f44624a);
        if (c0() && this.f44607p.isEmpty()) {
            this.f44609r.add(mediaSourceHolder);
        } else {
            o0(mediaSourceHolder);
        }
    }

    private void B0(int i3, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            A0(i3, (MediaSourceHolder) it.next());
            i3++;
        }
    }

    private void C0(int i3, int i4, int i5) {
        while (i3 < this.f44606o.size()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f44606o.get(i3);
            mediaSourceHolder.f44627d += i4;
            mediaSourceHolder.f44628e += i5;
            i3++;
        }
    }

    private void D0() {
        Iterator it = this.f44609r.iterator();
        while (it.hasNext()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) it.next();
            if (mediaSourceHolder.f44626c.isEmpty()) {
                o0(mediaSourceHolder);
                it.remove();
            }
        }
    }

    private synchronized void E0(Set set) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ((HandlerAndRunnable) it.next()).a();
            }
            this.f44604m.removeAll(set);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void F0(MediaSourceHolder mediaSourceHolder) {
        this.f44609r.add(mediaSourceHolder);
        p0(mediaSourceHolder);
    }

    private static Object G0(Object obj) {
        return AbstractConcatenatedTimeline.v(obj);
    }

    private static Object I0(Object obj) {
        return AbstractConcatenatedTimeline.w(obj);
    }

    private static Object J0(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.y(mediaSourceHolder.f44625b, obj);
    }

    private Handler K0() {
        return (Handler) Assertions.e(this.f44605n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M0(Message message) {
        switch (message.what) {
            case 1:
                MessageData messageData = (MessageData) Util.k(message.obj);
                this.f44614w = this.f44614w.g(messageData.f44630a, ((Collection) messageData.f44631b).size());
                B0(messageData.f44630a, (Collection) messageData.f44631b);
                S0(messageData.f44632c);
                return true;
            case 2:
                MessageData messageData2 = (MessageData) Util.k(message.obj);
                int i3 = messageData2.f44630a;
                int iIntValue = ((Integer) messageData2.f44631b).intValue();
                if (i3 == 0 && iIntValue == this.f44614w.getLength()) {
                    this.f44614w = this.f44614w.e();
                } else {
                    this.f44614w = this.f44614w.a(i3, iIntValue);
                }
                for (int i4 = iIntValue - 1; i4 >= i3; i4--) {
                    Q0(i4);
                }
                S0(messageData2.f44632c);
                return true;
            case 3:
                MessageData messageData3 = (MessageData) Util.k(message.obj);
                ShuffleOrder shuffleOrder = this.f44614w;
                int i5 = messageData3.f44630a;
                ShuffleOrder shuffleOrderA = shuffleOrder.a(i5, i5 + 1);
                this.f44614w = shuffleOrderA;
                this.f44614w = shuffleOrderA.g(((Integer) messageData3.f44631b).intValue(), 1);
                O0(messageData3.f44630a, ((Integer) messageData3.f44631b).intValue());
                S0(messageData3.f44632c);
                return true;
            case 4:
                MessageData messageData4 = (MessageData) Util.k(message.obj);
                this.f44614w = (ShuffleOrder) messageData4.f44631b;
                S0(messageData4.f44632c);
                return true;
            case 5:
                U0();
                return true;
            case 6:
                E0((Set) Util.k(message.obj));
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void N0(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f44629f && mediaSourceHolder.f44626c.isEmpty()) {
            this.f44609r.remove(mediaSourceHolder);
            x0(mediaSourceHolder);
        }
    }

    private void O0(int i3, int i4) {
        int iMin = Math.min(i3, i4);
        int iMax = Math.max(i3, i4);
        int iP = ((MediaSourceHolder) this.f44606o.get(iMin)).f44628e;
        List list = this.f44606o;
        list.add(i4, (MediaSourceHolder) list.remove(i3));
        while (iMin <= iMax) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f44606o.get(iMin);
            mediaSourceHolder.f44627d = iMin;
            mediaSourceHolder.f44628e = iP;
            iP += mediaSourceHolder.f44624a.L0().p();
            iMin++;
        }
    }

    private void Q0(int i3) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f44606o.remove(i3);
        this.f44608q.remove(mediaSourceHolder.f44625b);
        C0(i3, -1, -mediaSourceHolder.f44624a.L0().p());
        mediaSourceHolder.f44629f = true;
        N0(mediaSourceHolder);
    }

    private void R0() {
        S0(null);
    }

    private void S0(HandlerAndRunnable handlerAndRunnable) {
        if (!this.f44612u) {
            K0().obtainMessage(5).sendToTarget();
            this.f44612u = true;
        }
        if (handlerAndRunnable != null) {
            this.f44613v.add(handlerAndRunnable);
        }
    }

    private void T0(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        if (mediaSourceHolder.f44627d + 1 < this.f44606o.size()) {
            int iP = timeline.p() - (((MediaSourceHolder) this.f44606o.get(mediaSourceHolder.f44627d + 1)).f44628e - mediaSourceHolder.f44628e);
            if (iP != 0) {
                C0(mediaSourceHolder.f44627d + 1, 0, iP);
            }
        }
        R0();
    }

    private void U0() {
        this.f44612u = false;
        Set set = this.f44613v;
        this.f44613v = new HashSet();
        j0(new ConcatenatedTimeline(this.f44606o, this.f44614w, this.f44610s));
        K0().obtainMessage(6, set).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.e((MediaSourceHolder) this.f44607p.remove(mediaPeriod));
        mediaSourceHolder.f44624a.B(mediaPeriod);
        mediaSourceHolder.f44626c.remove(((MaskingMediaPeriod) mediaPeriod).f44719a);
        if (!this.f44607p.isEmpty()) {
            D0();
        }
        N0(mediaSourceHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId q0(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i3 = 0; i3 < mediaSourceHolder.f44626c.size(); i3++) {
            if (((MediaSource.MediaPeriodId) mediaSourceHolder.f44626c.get(i3)).f44757d == mediaPeriodId.f44757d) {
                return mediaPeriodId.a(J0(mediaSourceHolder, mediaPeriodId.f44754a));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public int s0(MediaSourceHolder mediaSourceHolder, int i3) {
        return i3 + mediaSourceHolder.f44628e;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public boolean M() {
        return false;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized Timeline O() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return new ConcatenatedTimeline(this.f44603l, this.f44614w.getLength() != this.f44603l.size() ? this.f44614w.e().g(0, this.f44603l.size()) : this.f44614w, this.f44610s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public void v0(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline) {
        T0(mediaSourceHolder, timeline);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void W() {
        super.W();
        this.f44609r.clear();
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected synchronized void f0(TransferListener transferListener) {
        try {
            super.f0(transferListener);
            this.f44605n = new Handler(new Handler.Callback() { // from class: androidx.media3.exoplayer.source.c
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f45065a.M0(message);
                }
            });
            if (this.f44603l.isEmpty()) {
                U0();
            } else {
                this.f44614w = this.f44614w.g(0, this.f44603l.size());
                B0(0, this.f44603l);
                R0();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        Object objI0 = I0(mediaPeriodId.f44754a);
        MediaSource.MediaPeriodId mediaPeriodIdA = mediaPeriodId.a(G0(mediaPeriodId.f44754a));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.f44608q.get(objI0);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new MediaSourceHolder(new FakeMediaSource(), this.f44611t);
            mediaSourceHolder.f44629f = true;
            w0(mediaSourceHolder, mediaSourceHolder.f44624a);
        }
        F0(mediaSourceHolder);
        mediaSourceHolder.f44626c.add(mediaPeriodIdA);
        MaskingMediaPeriod maskingMediaPeriodJ = mediaSourceHolder.f44624a.j(mediaPeriodIdA, allocator, j3);
        this.f44607p.put(maskingMediaPeriodJ, mediaSourceHolder);
        D0();
        return maskingMediaPeriodJ;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected synchronized void l0() {
        try {
            super.l0();
            this.f44606o.clear();
            this.f44609r.clear();
            this.f44608q.clear();
            this.f44614w = this.f44614w.e();
            Handler handler = this.f44605n;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f44605n = null;
            }
            this.f44612u = false;
            this.f44613v.clear();
            E0(this.f44604m);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem m() {
        return f44602x;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FakeMediaSource extends BaseMediaSource {
        private FakeMediaSource() {
        }

        @Override // androidx.media3.exoplayer.source.MediaSource
        public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.exoplayer.source.MediaSource
        public MediaItem m() {
            return ConcatenatingMediaSource.f44602x;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource
        public void L() {
        }

        @Override // androidx.media3.exoplayer.source.BaseMediaSource
        protected void l0() {
        }

        @Override // androidx.media3.exoplayer.source.MediaSource
        public void B(MediaPeriod mediaPeriod) {
        }

        @Override // androidx.media3.exoplayer.source.BaseMediaSource
        protected void f0(TransferListener transferListener) {
        }
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void a0() {
    }
}
