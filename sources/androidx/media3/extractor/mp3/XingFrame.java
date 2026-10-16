package androidx.media3.extractor.mp3;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class XingFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MpegAudioUtil.Header f46662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f46667f;

    private XingFrame(MpegAudioUtil.Header header, long j3, long j4, long[] jArr, int i3, int i4) {
        this.f46662a = new MpegAudioUtil.Header(header);
        this.f46663b = j3;
        this.f46664c = j4;
        this.f46667f = jArr;
        this.f46665d = i3;
        this.f46666e = i4;
    }

    public static XingFrame b(MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        long[] jArr;
        int i3;
        int i4;
        int iQ = parsableByteArray.q();
        int iL = (iQ & 1) != 0 ? parsableByteArray.L() : -1;
        long J = (iQ & 2) != 0 ? parsableByteArray.J() : -1L;
        if ((iQ & 4) == 4) {
            jArr = new long[100];
            for (int i5 = 0; i5 < 100; i5++) {
                jArr[i5] = parsableByteArray.H();
            }
        } else {
            jArr = null;
        }
        long[] jArr2 = jArr;
        if ((iQ & 8) != 0) {
            parsableByteArray.X(4);
        }
        if (parsableByteArray.a() >= 24) {
            parsableByteArray.X(21);
            int iK = parsableByteArray.K();
            i4 = iK & 4095;
            i3 = (16773120 & iK) >> 12;
        } else {
            i3 = -1;
            i4 = -1;
        }
        return new XingFrame(header, iL, J, jArr2, i3, i4);
    }

    public long a() {
        long j3 = this.f46663b;
        if (j3 == -1 || j3 == 0) {
            return -9223372036854775807L;
        }
        MpegAudioUtil.Header header = this.f46662a;
        return Util.Y0((j3 * ((long) header.f46209g)) - 1, header.f46206d);
    }
}
