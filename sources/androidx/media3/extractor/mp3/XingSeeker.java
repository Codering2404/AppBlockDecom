package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class XingSeeker implements Seeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f46668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f46670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f46671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f46672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f46673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long[] f46674g;

    private XingSeeker(long j3, int i3, long j4, int i4) {
        this(j3, i3, j4, i4, -1L, null);
    }

    public static XingSeeker a(XingFrame xingFrame, long j3) {
        long[] jArr;
        long jA = xingFrame.a();
        if (jA == -9223372036854775807L) {
            return null;
        }
        long j4 = xingFrame.f46664c;
        if (j4 == -1 || (jArr = xingFrame.f46667f) == null) {
            MpegAudioUtil.Header header = xingFrame.f46662a;
            return new XingSeeker(j3, header.f46205c, jA, header.f46208f);
        }
        MpegAudioUtil.Header header2 = xingFrame.f46662a;
        return new XingSeeker(j3, header2.f46205c, jA, header2.f46208f, j4, jArr);
    }

    private long c(int i3) {
        return (this.f46670c * ((long) i3)) / 100;
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        if (!e()) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.f46668a + ((long) this.f46669b)));
        }
        long jS = Util.s(j3, 0L, this.f46670c);
        double d3 = (jS * 100.0d) / this.f46670c;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i3 = (int) d3;
                double d5 = ((long[]) Assertions.i(this.f46674g))[i3];
                d4 = d5 + ((d3 - ((double) i3)) * ((i3 == 99 ? 256.0d : r3[i3 + 1]) - d5));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(jS, this.f46668a + Util.s(Math.round((d4 / 256.0d) * this.f46672e), this.f46669b, this.f46672e - 1)));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long d() {
        return this.f46673f;
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return this.f46674g != null;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long f(long j3) {
        long j4 = j3 - this.f46668a;
        if (!e() || j4 <= this.f46669b) {
            return 0L;
        }
        long[] jArr = (long[]) Assertions.i(this.f46674g);
        double d3 = (j4 * 256.0d) / this.f46672e;
        int iJ = Util.j(jArr, (long) d3, true, true);
        long jC = c(iJ);
        long j5 = jArr[iJ];
        int i3 = iJ + 1;
        long jC2 = c(i3);
        return jC + Math.round((j5 == (iJ == 99 ? 256L : jArr[i3]) ? 0.0d : (d3 - j5) / (r0 - j5)) * (jC2 - jC));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public int k() {
        return this.f46671d;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46670c;
    }

    private XingSeeker(long j3, int i3, long j4, int i4, long j5, long[] jArr) {
        this.f46668a = j3;
        this.f46669b = i3;
        this.f46670c = j4;
        this.f46671d = i4;
        this.f46672e = j5;
        this.f46674g = jArr;
        this.f46673f = j5 != -1 ? j3 + j5 : -1L;
    }
}
