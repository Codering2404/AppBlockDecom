package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VbriSeeker implements Seeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f46657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f46658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f46659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f46660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f46661e;

    private VbriSeeker(long[] jArr, long[] jArr2, long j3, long j4, int i3) {
        this.f46657a = jArr;
        this.f46658b = jArr2;
        this.f46659c = j3;
        this.f46660d = j4;
        this.f46661e = i3;
    }

    public static VbriSeeker a(long j3, long j4, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int iH;
        parsableByteArray.X(6);
        long jQ = j4 + ((long) header.f46205c) + ((long) parsableByteArray.q());
        int iQ = parsableByteArray.q();
        if (iQ <= 0) {
            return null;
        }
        long jY0 = Util.Y0((((long) iQ) * ((long) header.f46209g)) - 1, header.f46206d);
        int iP = parsableByteArray.P();
        int iP2 = parsableByteArray.P();
        int iP3 = parsableByteArray.P();
        parsableByteArray.X(2);
        long[] jArr = new long[iP];
        long[] jArr2 = new long[iP];
        int i3 = 0;
        long j5 = j4 + ((long) header.f46205c);
        while (i3 < iP) {
            long[] jArr3 = jArr;
            long[] jArr4 = jArr2;
            int i4 = i3;
            jArr3[i4] = (((long) i3) * jY0) / ((long) iP);
            jArr4[i4] = j5;
            if (iP3 == 1) {
                iH = parsableByteArray.H();
            } else if (iP3 == 2) {
                iH = parsableByteArray.P();
            } else if (iP3 == 3) {
                iH = parsableByteArray.K();
            } else {
                if (iP3 != 4) {
                    return null;
                }
                iH = parsableByteArray.L();
            }
            j5 += ((long) iH) * ((long) iP2);
            i3 = i4 + 1;
            jArr = jArr3;
            jArr2 = jArr4;
        }
        long[] jArr5 = jArr;
        long[] jArr6 = jArr2;
        if (j3 != -1 && j3 != jQ) {
            Log.i("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + jQ);
        }
        if (jQ != j5) {
            Log.i("VbriSeeker", "VBRI bytes and ToC mismatch (using max): " + jQ + ", " + j5 + "\nSeeking will be inaccurate.");
            jQ = Math.max(jQ, j5);
        }
        return new VbriSeeker(jArr5, jArr6, jY0, jQ, header.f46208f);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        int iJ = Util.j(this.f46657a, j3, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f46657a[iJ], this.f46658b[iJ]);
        if (seekPoint.f46216a >= j3 || iJ == this.f46657a.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i3 = iJ + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f46657a[i3], this.f46658b[i3]));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long d() {
        return this.f46660d;
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return true;
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long f(long j3) {
        return this.f46657a[Util.j(this.f46658b, j3, true, true)];
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public int k() {
        return this.f46661e;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46659c;
    }
}
