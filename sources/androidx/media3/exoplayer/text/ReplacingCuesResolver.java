package androidx.media3.exoplayer.text;

import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ReplacingCuesResolver implements CuesResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f45304a = new ArrayList();

    private int f(long j3) {
        for (int i3 = 0; i3 < this.f45304a.size(); i3++) {
            if (j3 < ((CuesWithTiming) this.f45304a.get(i3)).f46935b) {
                return i3;
            }
        }
        return this.f45304a.size();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public ImmutableList a(long j3) {
        int iF = f(j3);
        if (iF == 0) {
            return ImmutableList.y();
        }
        CuesWithTiming cuesWithTiming = (CuesWithTiming) this.f45304a.get(iF - 1);
        long j4 = cuesWithTiming.f46937d;
        return (j4 == -9223372036854775807L || j3 < j4) ? cuesWithTiming.f46934a : ImmutableList.y();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // androidx.media3.exoplayer.text.CuesResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(androidx.media3.extractor.text.CuesWithTiming r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f46935b
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r4 = 1
            if (r0 == 0) goto Lf
            r0 = r4
            goto L10
        Lf:
            r0 = r1
        L10:
            androidx.media3.common.util.Assertions.a(r0)
            long r5 = r10.f46935b
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 > 0) goto L25
            long r5 = r10.f46937d
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 == 0) goto L23
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 >= 0) goto L25
        L23:
            r0 = r4
            goto L26
        L25:
            r0 = r1
        L26:
            java.util.ArrayList r2 = r9.f45304a
            int r2 = r2.size()
            int r2 = r2 - r4
        L2d:
            if (r2 < 0) goto L58
            long r5 = r10.f46935b
            java.util.ArrayList r3 = r9.f45304a
            java.lang.Object r3 = r3.get(r2)
            androidx.media3.extractor.text.CuesWithTiming r3 = (androidx.media3.extractor.text.CuesWithTiming) r3
            long r7 = r3.f46935b
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L46
            java.util.ArrayList r11 = r9.f45304a
            int r2 = r2 + r4
            r11.add(r2, r10)
            return r0
        L46:
            java.util.ArrayList r3 = r9.f45304a
            java.lang.Object r3 = r3.get(r2)
            androidx.media3.extractor.text.CuesWithTiming r3 = (androidx.media3.extractor.text.CuesWithTiming) r3
            long r5 = r3.f46935b
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 > 0) goto L55
            r0 = r1
        L55:
            int r2 = r2 + (-1)
            goto L2d
        L58:
            java.util.ArrayList r11 = r9.f45304a
            r11.add(r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.text.ReplacingCuesResolver.b(androidx.media3.extractor.text.CuesWithTiming, long):boolean");
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long c(long j3) {
        if (this.f45304a.isEmpty() || j3 < ((CuesWithTiming) this.f45304a.get(0)).f46935b) {
            return -9223372036854775807L;
        }
        for (int i3 = 1; i3 < this.f45304a.size(); i3++) {
            long j4 = ((CuesWithTiming) this.f45304a.get(i3)).f46935b;
            if (j3 == j4) {
                return j4;
            }
            if (j3 < j4) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) this.f45304a.get(i3 - 1);
                long j5 = cuesWithTiming.f46937d;
                return (j5 == -9223372036854775807L || j5 > j3) ? cuesWithTiming.f46935b : j5;
            }
        }
        CuesWithTiming cuesWithTiming2 = (CuesWithTiming) Iterables.j(this.f45304a);
        long j6 = cuesWithTiming2.f46937d;
        return (j6 == -9223372036854775807L || j3 < j6) ? cuesWithTiming2.f46935b : j6;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void clear() {
        this.f45304a.clear();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long d(long j3) {
        if (this.f45304a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j3 < ((CuesWithTiming) this.f45304a.get(0)).f46935b) {
            return ((CuesWithTiming) this.f45304a.get(0)).f46935b;
        }
        for (int i3 = 1; i3 < this.f45304a.size(); i3++) {
            CuesWithTiming cuesWithTiming = (CuesWithTiming) this.f45304a.get(i3);
            if (j3 < cuesWithTiming.f46935b) {
                long j4 = ((CuesWithTiming) this.f45304a.get(i3 - 1)).f46937d;
                return (j4 == -9223372036854775807L || j4 <= j3 || j4 >= cuesWithTiming.f46935b) ? cuesWithTiming.f46935b : j4;
            }
        }
        long j5 = ((CuesWithTiming) Iterables.j(this.f45304a)).f46937d;
        if (j5 == -9223372036854775807L || j3 >= j5) {
            return Long.MIN_VALUE;
        }
        return j5;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void e(long j3) {
        int iF = f(j3);
        if (iF == 0) {
            return;
        }
        long j4 = ((CuesWithTiming) this.f45304a.get(iF - 1)).f46937d;
        if (j4 == -9223372036854775807L || j4 >= j3) {
            iF--;
        }
        this.f45304a.subList(0, iF).clear();
    }
}
