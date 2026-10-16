package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MergingMediaSource extends CompositeMediaSource<Integer> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final MediaItem f44777x = new MediaItem.Builder().f("MergingMediaSource").a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f44778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f44779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MediaSource[] f44780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f44781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Timeline[] f44782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ArrayList f44783q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f44784r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Map f44785s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Multimap f44786t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f44787u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long[][] f44788v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private IllegalMergeException f44789w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ClippedTimeline extends ForwardingTimeline {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long[] f44790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long[] f44791g;

        public ClippedTimeline(Timeline timeline, Map map) {
            super(timeline);
            int iP = timeline.p();
            this.f44791g = new long[timeline.p()];
            Timeline.Window window = new Timeline.Window();
            for (int i3 = 0; i3 < iP; i3++) {
                this.f44791g[i3] = timeline.n(i3, window).f41147m;
            }
            int i4 = timeline.i();
            this.f44790f = new long[i4];
            Timeline.Period period = new Timeline.Period();
            for (int i5 = 0; i5 < i4; i5++) {
                timeline.g(i5, period, true);
                long jLongValue = ((Long) Assertions.e((Long) map.get(period.f41115b))).longValue();
                long[] jArr = this.f44790f;
                jLongValue = jLongValue == Long.MIN_VALUE ? period.f41117d : jLongValue;
                jArr[i5] = jLongValue;
                long j3 = period.f41117d;
                if (j3 != -9223372036854775807L) {
                    long[] jArr2 = this.f44791g;
                    int i6 = period.f41116c;
                    jArr2[i6] = jArr2[i6] - (j3 - jLongValue);
                }
            }
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
            super.g(i3, period, z2);
            period.f41117d = this.f44790f[i3];
            return period;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.media3.common.Timeline.Window o(int r5, androidx.media3.common.Timeline.Window r6, long r7) {
            /*
                r4 = this;
                super.o(r5, r6, r7)
                long[] r7 = r4.f44791g
                r7 = r7[r5]
                r6.f41147m = r7
                r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 == 0) goto L1e
                long r2 = r6.f41146l
                int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r5 != 0) goto L19
                goto L1e
            L19:
                long r7 = java.lang.Math.min(r2, r7)
                goto L20
            L1e:
                long r7 = r6.f41146l
            L20:
                r6.f41146l = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.MergingMediaSource.ClippedTimeline.o(int, androidx.media3.common.Timeline$Window, long):androidx.media3.common.Timeline$Window");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class IllegalMergeException extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44792a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i3) {
            this.f44792a = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaPeriodAndId {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaSource.MediaPeriodId f44793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaPeriod f44794b;

        private MediaPeriodAndId(MediaSource.MediaPeriodId mediaPeriodId, MediaPeriod mediaPeriod) {
            this.f44793a = mediaPeriodId;
            this.f44794b = mediaPeriod;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void B0() {
        Timeline[] timelineArr;
        Timeline.Period period = new Timeline.Period();
        for (int i3 = 0; i3 < this.f44787u; i3++) {
            int i4 = 0;
            long j3 = Long.MIN_VALUE;
            while (true) {
                timelineArr = this.f44782p;
                if (i4 >= timelineArr.length) {
                    break;
                }
                long jK = timelineArr[i4].f(i3, period).k();
                if (jK != -9223372036854775807L) {
                    long j4 = jK + this.f44788v[i3][i4];
                    if (j3 == Long.MIN_VALUE || j4 < j3) {
                        j3 = j4;
                    }
                }
                i4++;
            }
            Object objM = timelineArr[0].m(i3);
            this.f44785s.put(objM, Long.valueOf(j3));
            Iterator it = this.f44786t.get(objM).iterator();
            while (it.hasNext()) {
                ((ClippingMediaPeriod) it.next()).v(0L, j3);
            }
        }
    }

    private void y0() {
        Timeline.Period period = new Timeline.Period();
        for (int i3 = 0; i3 < this.f44787u; i3++) {
            long j3 = -this.f44782p[0].f(i3, period).o();
            int i4 = 1;
            while (true) {
                Timeline[] timelineArr = this.f44782p;
                if (i4 < timelineArr.length) {
                    this.f44788v[i3][i4] = j3 - (-timelineArr[i4].f(i3, period).o());
                    i4++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void v0(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.f44789w != null) {
            return;
        }
        if (this.f44787u == -1) {
            this.f44787u = timeline.i();
        } else if (timeline.i() != this.f44787u) {
            this.f44789w = new IllegalMergeException(0);
            return;
        }
        if (this.f44788v.length == 0) {
            this.f44788v = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f44787u, this.f44782p.length);
        }
        this.f44783q.remove(mediaSource);
        this.f44782p[num.intValue()] = timeline;
        if (this.f44783q.isEmpty()) {
            if (this.f44778l) {
                y0();
            }
            Timeline clippedTimeline = this.f44782p[0];
            if (this.f44779m) {
                B0();
                clippedTimeline = new ClippedTimeline(clippedTimeline, this.f44785s);
            }
            j0(clippedTimeline);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        if (this.f44779m) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            Iterator it = this.f44786t.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((ClippingMediaPeriod) entry.getValue()).equals(clippingMediaPeriod)) {
                    this.f44786t.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.f44553a;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        for (int i3 = 0; i3 < this.f44780n.length; i3++) {
            List list = (List) this.f44781o.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                if (((MediaPeriodAndId) list.get(i4)).f44794b.equals(mediaPeriod)) {
                    list.remove(i4);
                    break;
                }
                i4++;
            }
            this.f44780n[i3].B(mergingMediaPeriod.m(i3));
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void H(MediaItem mediaItem) {
        this.f44780n[0].H(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public void L() throws IllegalMergeException {
        IllegalMergeException illegalMergeException = this.f44789w;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.L();
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        super.f0(transferListener);
        for (int i3 = 0; i3 < this.f44780n.length; i3++) {
            w0(Integer.valueOf(i3), this.f44780n[i3]);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        int length = this.f44780n.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int iB = this.f44782p[0].b(mediaPeriodId.f44754a);
        for (int i3 = 0; i3 < length; i3++) {
            MediaSource.MediaPeriodId mediaPeriodIdA = mediaPeriodId.a(this.f44782p[i3].m(iB));
            mediaPeriodArr[i3] = this.f44780n[i3].j(mediaPeriodIdA, allocator, j3 - this.f44788v[iB][i3]);
            ((List) this.f44781o.get(i3)).add(new MediaPeriodAndId(mediaPeriodIdA, mediaPeriodArr[i3]));
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.f44784r, this.f44788v[iB], mediaPeriodArr);
        if (!this.f44779m) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, false, 0L, ((Long) Assertions.e((Long) this.f44785s.get(mediaPeriodId.f44754a))).longValue());
        this.f44786t.put(mediaPeriodId.f44754a, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        super.l0();
        Arrays.fill(this.f44782p, (Object) null);
        this.f44787u = -1;
        this.f44789w = null;
        this.f44783q.clear();
        Collections.addAll(this.f44783q, this.f44780n);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem m() {
        MediaSource[] mediaSourceArr = this.f44780n;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].m() : f44777x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId q0(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        List list = (List) this.f44781o.get(num.intValue());
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (((MediaPeriodAndId) list.get(i3)).f44793a.equals(mediaPeriodId)) {
                return ((MediaPeriodAndId) ((List) this.f44781o.get(0)).get(i3)).f44793a;
            }
        }
        return null;
    }

    public MergingMediaSource(boolean z2, MediaSource... mediaSourceArr) {
        this(z2, false, mediaSourceArr);
    }

    public MergingMediaSource(boolean z2, boolean z3, MediaSource... mediaSourceArr) {
        this(z2, z3, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z2, boolean z3, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.f44778l = z2;
        this.f44779m = z3;
        this.f44780n = mediaSourceArr;
        this.f44784r = compositeSequenceableLoaderFactory;
        this.f44783q = new ArrayList(Arrays.asList(mediaSourceArr));
        this.f44787u = -1;
        this.f44781o = new ArrayList(mediaSourceArr.length);
        for (int i3 = 0; i3 < mediaSourceArr.length; i3++) {
            this.f44781o.add(new ArrayList());
        }
        this.f44782p = new Timeline[mediaSourceArr.length];
        this.f44788v = new long[0][];
        this.f44785s = new HashMap();
        this.f44786t = MultimapBuilder.a().a().e();
    }
}
