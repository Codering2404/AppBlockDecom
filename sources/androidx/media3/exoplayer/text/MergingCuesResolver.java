package androidx.media3.exoplayer.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MergingCuesResolver implements CuesResolver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Ordering f45302b = Ordering.f().j(new Function() { // from class: androidx.media3.exoplayer.text.a
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return Long.valueOf(((CuesWithTiming) obj).f46935b);
        }
    }).a(Ordering.f().k().j(new Function() { // from class: androidx.media3.exoplayer.text.b
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return Long.valueOf(((CuesWithTiming) obj).f46936c);
        }
    }));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f45303a = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.text.CuesResolver
    public ImmutableList a(long j3) {
        if (!this.f45303a.isEmpty()) {
            if (j3 >= ((CuesWithTiming) this.f45303a.get(0)).f46935b) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < this.f45303a.size(); i3++) {
                    CuesWithTiming cuesWithTiming = (CuesWithTiming) this.f45303a.get(i3);
                    if (j3 >= cuesWithTiming.f46935b && j3 < cuesWithTiming.f46937d) {
                        arrayList.add(cuesWithTiming);
                    }
                    if (j3 < cuesWithTiming.f46935b) {
                        break;
                    }
                }
                ImmutableList immutableListK = ImmutableList.K(f45302b, arrayList);
                ImmutableList.Builder builderO = ImmutableList.o();
                for (int i4 = 0; i4 < immutableListK.size(); i4++) {
                    builderO.k(((CuesWithTiming) immutableListK.get(i4)).f46934a);
                }
                return builderO.m();
            }
        }
        return ImmutableList.y();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public boolean b(CuesWithTiming cuesWithTiming, long j3) {
        Assertions.a(cuesWithTiming.f46935b != -9223372036854775807L);
        Assertions.a(cuesWithTiming.f46936c != -9223372036854775807L);
        boolean z2 = cuesWithTiming.f46935b <= j3 && j3 < cuesWithTiming.f46937d;
        for (int size = this.f45303a.size() - 1; size >= 0; size--) {
            if (cuesWithTiming.f46935b >= ((CuesWithTiming) this.f45303a.get(size)).f46935b) {
                this.f45303a.add(size + 1, cuesWithTiming);
                return z2;
            }
        }
        this.f45303a.add(0, cuesWithTiming);
        return z2;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long c(long j3) {
        if (this.f45303a.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j3 < ((CuesWithTiming) this.f45303a.get(0)).f46935b) {
            return -9223372036854775807L;
        }
        long jMax = ((CuesWithTiming) this.f45303a.get(0)).f46935b;
        for (int i3 = 0; i3 < this.f45303a.size(); i3++) {
            long j4 = ((CuesWithTiming) this.f45303a.get(i3)).f46935b;
            long j5 = ((CuesWithTiming) this.f45303a.get(i3)).f46937d;
            if (j5 > j3) {
                if (j4 > j3) {
                    break;
                }
                jMax = Math.max(jMax, j4);
            } else {
                jMax = Math.max(jMax, j5);
            }
        }
        return jMax;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void clear() {
        this.f45303a.clear();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long d(long j3) {
        int i3 = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            if (i3 >= this.f45303a.size()) {
                break;
            }
            long j4 = ((CuesWithTiming) this.f45303a.get(i3)).f46935b;
            long j5 = ((CuesWithTiming) this.f45303a.get(i3)).f46937d;
            if (j3 < j4) {
                jMin = jMin == -9223372036854775807L ? j4 : Math.min(jMin, j4);
            } else {
                if (j3 < j5) {
                    jMin = jMin == -9223372036854775807L ? j5 : Math.min(jMin, j5);
                }
                i3++;
            }
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void e(long j3) {
        int i3 = 0;
        while (i3 < this.f45303a.size()) {
            long j4 = ((CuesWithTiming) this.f45303a.get(i3)).f46935b;
            if (j3 > j4 && j3 > ((CuesWithTiming) this.f45303a.get(i3)).f46937d) {
                this.f45303a.remove(i3);
                i3--;
            } else if (j3 < j4) {
                return;
            }
            i3++;
        }
    }
}
