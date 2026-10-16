package androidx.media3.extractor;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import java.util.Arrays;
import kotlin.comparisons.xn.YvFRmou;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class ChunkIndex implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f46088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f46089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f46090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f46091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f46092f;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f46088b = iArr;
        this.f46089c = jArr;
        this.f46090d = jArr2;
        this.f46091e = jArr3;
        int length = iArr.length;
        this.f46087a = length;
        if (length > 0) {
            this.f46092f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f46092f = 0L;
        }
    }

    public int a(long j3) {
        return Util.j(this.f46091e, j3, true, true);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        int iA = a(j3);
        SeekPoint seekPoint = new SeekPoint(this.f46091e[iA], this.f46089c[iA]);
        if (seekPoint.f46216a >= j3 || iA == this.f46087a - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i3 = iA + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f46091e[i3], this.f46089c[i3]));
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return true;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46092f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f46087a + ", sizes=" + Arrays.toString(this.f46088b) + YvFRmou.UuYOzshaKEX + Arrays.toString(this.f46089c) + ", timeUs=" + Arrays.toString(this.f46091e) + ", durationsUs=" + Arrays.toString(this.f46090d) + ")";
    }
}
