package androidx.media3.extractor.mp3;

import android.util.Pair;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.metadata.id3.MlltFrame;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MlltSeeker implements Seeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f46631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f46632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f46633c;

    private MlltSeeker(long[] jArr, long[] jArr2, long j3) {
        this.f46631a = jArr;
        this.f46632b = jArr2;
        this.f46633c = j3 == -9223372036854775807L ? Util.P0(jArr2[jArr2.length - 1]) : j3;
    }

    public static MlltSeeker a(long j3, MlltFrame mlltFrame, long j4) {
        int length = mlltFrame.f46483e.length;
        int i3 = length + 1;
        long[] jArr = new long[i3];
        long[] jArr2 = new long[i3];
        jArr[0] = j3;
        long j5 = 0;
        jArr2[0] = 0;
        for (int i4 = 1; i4 <= length; i4++) {
            int i5 = i4 - 1;
            j3 += (long) (mlltFrame.f46481c + mlltFrame.f46483e[i5]);
            j5 += (long) (mlltFrame.f46482d + mlltFrame.f46484f[i5]);
            jArr[i4] = j3;
            jArr2[i4] = j5;
        }
        return new MlltSeeker(jArr, jArr2, j4);
    }

    private static Pair c(long j3, long[] jArr, long[] jArr2) {
        int iJ = Util.j(jArr, j3, true, true);
        long j4 = jArr[iJ];
        long j5 = jArr2[iJ];
        int i3 = iJ + 1;
        if (i3 == jArr.length) {
            return Pair.create(Long.valueOf(j4), Long.valueOf(j5));
        }
        return Pair.create(Long.valueOf(j3), Long.valueOf(((long) ((jArr[i3] == j4 ? 0.0d : (j3 - j4) / (r6 - j4)) * (jArr2[i3] - j5))) + j5));
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        Pair pairC = c(Util.t1(Util.s(j3, 0L, this.f46633c)), this.f46632b, this.f46631a);
        return new SeekMap.SeekPoints(new SeekPoint(Util.P0(((Long) pairC.first).longValue()), ((Long) pairC.second).longValue()));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long d() {
        return -1L;
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return true;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long f(long j3) {
        return Util.P0(((Long) c(j3, this.f46631a, this.f46632b).second).longValue());
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public int k() {
        return -2147483647;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46633c;
    }
}
