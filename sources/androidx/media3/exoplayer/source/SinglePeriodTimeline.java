package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SinglePeriodTimeline extends Timeline {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Object f44924r = new Object();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final MediaItem f44925s = new MediaItem.Builder().f("SinglePeriodTimeline").k(Uri.EMPTY).a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f44926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f44927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f44928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f44929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f44930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f44931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f44932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f44933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f44934m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f44935n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f44936o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MediaItem f44937p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MediaItem.LiveConfiguration f44938q;

    public SinglePeriodTimeline(long j3, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem) {
        this(j3, j3, 0L, 0L, z2, z3, z4, obj, mediaItem);
    }

    @Override // androidx.media3.common.Timeline
    public int b(Object obj) {
        return f44924r.equals(obj) ? 0 : -1;
    }

    @Override // androidx.media3.common.Timeline
    public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
        Assertions.c(i3, 0, 1);
        return period.t(null, z2 ? f44924r : null, 0, this.f44929h, -this.f44931j);
    }

    @Override // androidx.media3.common.Timeline
    public int i() {
        return 1;
    }

    @Override // androidx.media3.common.Timeline
    public Object m(int i3) {
        Assertions.c(i3, 0, 1);
        return f44924r;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[PHI: r1
      0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.media3.common.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.media3.common.Timeline.Window o(int r25, androidx.media3.common.Timeline.Window r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            androidx.media3.common.util.Assertions.c(r3, r1, r2)
            long r1 = r0.f44932k
            boolean r14 = r0.f44934m
            if (r14 == 0) goto L2e
            boolean r3 = r0.f44935n
            if (r3 != 0) goto L2e
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2e
            long r3 = r0.f44930i
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r5
            goto L30
        L27:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = androidx.media3.common.Timeline.Window.f41125q
            androidx.media3.common.MediaItem r5 = r0.f44937p
            java.lang.Object r6 = r0.f44936o
            long r7 = r0.f44926e
            long r9 = r0.f44927f
            long r11 = r0.f44928g
            boolean r13 = r0.f44933l
            androidx.media3.common.MediaItem$LiveConfiguration r15 = r0.f44938q
            long r1 = r0.f44930i
            r21 = 0
            r18 = r1
            long r1 = r0.f44931j
            r20 = 0
            r3 = r26
            r22 = r1
            androidx.media3.common.Timeline$Window r1 = r3.g(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SinglePeriodTimeline.o(int, androidx.media3.common.Timeline$Window, long):androidx.media3.common.Timeline$Window");
    }

    @Override // androidx.media3.common.Timeline
    public int p() {
        return 1;
    }

    public SinglePeriodTimeline(long j3, long j4, long j5, long j6, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j3, j4, j5, j6, z2, z3, false, obj, mediaItem, z4 ? mediaItem.f40716d : null);
    }

    public SinglePeriodTimeline(long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z2, boolean z3, boolean z4, Object obj, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
        this.f44926e = j3;
        this.f44927f = j4;
        this.f44928g = j5;
        this.f44929h = j6;
        this.f44930i = j7;
        this.f44931j = j8;
        this.f44932k = j9;
        this.f44933l = z2;
        this.f44934m = z3;
        this.f44935n = z4;
        this.f44936o = obj;
        this.f44937p = (MediaItem) Assertions.e(mediaItem);
        this.f44938q = liveConfiguration;
    }
}
