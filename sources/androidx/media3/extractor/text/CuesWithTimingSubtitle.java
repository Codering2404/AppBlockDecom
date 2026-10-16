package androidx.media3.extractor.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CuesWithTimingSubtitle implements Subtitle {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Ordering f46938c = Ordering.f().j(new Function() { // from class: androidx.media3.extractor.text.c
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return Long.valueOf(CuesWithTimingSubtitle.g(((CuesWithTiming) obj).f46935b));
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f46939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f46940b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CuesWithTimingSubtitle(java.util.List r15) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.CuesWithTimingSubtitle.<init>(java.util.List):void");
    }

    private static long g(long j3) {
        if (j3 == -9223372036854775807L) {
            return 0L;
        }
        return j3;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int a(long j3) {
        int iF = Util.f(this.f46940b, j3, false, false);
        if (iF < this.f46939a.size()) {
            return iF;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long c(int i3) {
        Assertions.a(i3 < this.f46939a.size());
        return this.f46940b[i3];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int d() {
        return this.f46939a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.text.Subtitle
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ImmutableList b(long j3) {
        int iJ = Util.j(this.f46940b, j3, true, false);
        return iJ == -1 ? ImmutableList.y() : (ImmutableList) this.f46939a.get(iJ);
    }
}
