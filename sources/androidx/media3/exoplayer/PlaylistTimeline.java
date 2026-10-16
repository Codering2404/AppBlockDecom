package androidx.media3.exoplayer;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.ShuffleOrder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class PlaylistTimeline extends AbstractConcatenatedTimeline {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f43272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f43273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f43274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f43275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Timeline[] f43276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object[] f43277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final HashMap f43278n;

    public PlaylistTimeline(Collection collection, ShuffleOrder shuffleOrder) {
        this(G(collection), H(collection), shuffleOrder);
    }

    private static Timeline[] G(Collection collection) {
        Timeline[] timelineArr = new Timeline[collection.size()];
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            timelineArr[i3] = ((MediaSourceInfoHolder) it.next()).b();
            i3++;
        }
        return timelineArr;
    }

    private static Object[] H(Collection collection) {
        Object[] objArr = new Object[collection.size()];
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            objArr[i3] = ((MediaSourceInfoHolder) it.next()).a();
            i3++;
        }
        return objArr;
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    protected int A(int i3) {
        return this.f43275k[i3];
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    protected Timeline D(int i3) {
        return this.f43276l[i3];
    }

    public PlaylistTimeline E(ShuffleOrder shuffleOrder) {
        Timeline[] timelineArr = new Timeline[this.f43276l.length];
        int i3 = 0;
        while (true) {
            Timeline[] timelineArr2 = this.f43276l;
            if (i3 >= timelineArr2.length) {
                return new PlaylistTimeline(timelineArr, this.f43277m, shuffleOrder);
            }
            timelineArr[i3] = new ForwardingTimeline(timelineArr2[i3]) { // from class: androidx.media3.exoplayer.PlaylistTimeline.1

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final Timeline.Window f43279f = new Timeline.Window();

                @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
                public Timeline.Period g(int i4, Timeline.Period period, boolean z2) {
                    Timeline.Period periodG = super.g(i4, period, z2);
                    if (super.n(periodG.f41116c, this.f43279f).f()) {
                        periodG.u(period.f41114a, period.f41115b, period.f41116c, period.f41117d, period.f41118e, AdPlaybackState.f40484g, true);
                        return periodG;
                    }
                    periodG.f41119f = true;
                    return periodG;
                }
            };
            i3++;
        }
    }

    List F() {
        return Arrays.asList(this.f43276l);
    }

    @Override // androidx.media3.common.Timeline
    public int i() {
        return this.f43273i;
    }

    @Override // androidx.media3.common.Timeline
    public int p() {
        return this.f43272h;
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    protected int s(Object obj) {
        Integer num = (Integer) this.f43278n.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    protected int t(int i3) {
        return Util.i(this.f43274j, i3 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    protected int u(int i3) {
        return Util.i(this.f43275k, i3 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    protected Object x(int i3) {
        return this.f43277m[i3];
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    protected int z(int i3) {
        return this.f43274j[i3];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private PlaylistTimeline(Timeline[] timelineArr, Object[] objArr, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i3 = 0;
        int length = timelineArr.length;
        this.f43276l = timelineArr;
        this.f43274j = new int[length];
        this.f43275k = new int[length];
        this.f43277m = objArr;
        this.f43278n = new HashMap();
        int length2 = timelineArr.length;
        int iP = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length2) {
            Timeline timeline = timelineArr[i3];
            this.f43276l[i5] = timeline;
            this.f43275k[i5] = iP;
            this.f43274j[i5] = i4;
            iP += timeline.p();
            i4 += this.f43276l[i5].i();
            this.f43278n.put(objArr[i5], Integer.valueOf(i5));
            i3++;
            i5++;
        }
        this.f43272h = iP;
        this.f43273i = i4;
    }
}
