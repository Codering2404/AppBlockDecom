package androidx.media3.exoplayer.source;

import androidx.media3.common.Timeline;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingTimeline extends Timeline {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final Timeline f44698e;

    public ForwardingTimeline(Timeline timeline) {
        this.f44698e = timeline;
    }

    @Override // androidx.media3.common.Timeline
    public int a(boolean z2) {
        return this.f44698e.a(z2);
    }

    @Override // androidx.media3.common.Timeline
    public int b(Object obj) {
        return this.f44698e.b(obj);
    }

    @Override // androidx.media3.common.Timeline
    public int c(boolean z2) {
        return this.f44698e.c(z2);
    }

    @Override // androidx.media3.common.Timeline
    public int e(int i3, int i4, boolean z2) {
        return this.f44698e.e(i3, i4, z2);
    }

    @Override // androidx.media3.common.Timeline
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
        return this.f44698e.g(i3, period, z2);
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period h(Object obj, Timeline.Period period) {
        return super.h(obj, period);
    }

    @Override // androidx.media3.common.Timeline
    public final int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.media3.common.Timeline
    public int i() {
        return this.f44698e.i();
    }

    @Override // androidx.media3.common.Timeline
    public int l(int i3, int i4, boolean z2) {
        return this.f44698e.l(i3, i4, z2);
    }

    @Override // androidx.media3.common.Timeline
    public Object m(int i3) {
        return this.f44698e.m(i3);
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Window o(int i3, Timeline.Window window, long j3) {
        return this.f44698e.o(i3, window, j3);
    }

    @Override // androidx.media3.common.Timeline
    public int p() {
        return this.f44698e.p();
    }
}
