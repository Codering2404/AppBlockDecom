package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class IndexSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LongArray f46193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LongArray f46194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f46195c;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j3) {
        Assertions.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            this.f46193a = new LongArray(length);
            this.f46194b = new LongArray(length);
        } else {
            int i3 = length + 1;
            LongArray longArray = new LongArray(i3);
            this.f46193a = longArray;
            LongArray longArray2 = new LongArray(i3);
            this.f46194b = longArray2;
            longArray.a(0L);
            longArray2.a(0L);
        }
        this.f46193a.b(jArr);
        this.f46194b.b(jArr2);
        this.f46195c = j3;
    }

    public void a(long j3, long j4) {
        if (this.f46194b.d() == 0 && j3 > 0) {
            this.f46193a.a(0L);
            this.f46194b.a(0L);
        }
        this.f46193a.a(j4);
        this.f46194b.a(j3);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        if (this.f46194b.d() == 0) {
            return new SeekMap.SeekPoints(SeekPoint.f46215c);
        }
        int iG = Util.g(this.f46194b, j3, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f46194b.c(iG), this.f46193a.c(iG));
        if (seekPoint.f46216a == j3 || iG == this.f46194b.d() - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i3 = iG + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f46194b.c(i3), this.f46193a.c(i3)));
    }

    public boolean c(long j3, long j4) {
        if (this.f46194b.d() == 0) {
            return false;
        }
        LongArray longArray = this.f46194b;
        return j3 - longArray.c(longArray.d() - 1) < j4;
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return this.f46194b.d() > 0;
    }

    public long f(long j3) {
        if (this.f46194b.d() == 0) {
            return -9223372036854775807L;
        }
        return this.f46194b.c(Util.g(this.f46193a, j3, true, true));
    }

    public void g(long j3) {
        this.f46195c = j3;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46195c;
    }
}
