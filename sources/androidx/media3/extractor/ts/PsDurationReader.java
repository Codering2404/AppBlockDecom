package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class PsDurationReader {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f47657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f47658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f47659e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimestampAdjuster f47655a = new TimestampAdjuster(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f47660f = -9223372036854775807L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47661g = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f47662h = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47656b = new ParsableByteArray();

    PsDurationReader() {
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(ExtractorInput extractorInput) {
        this.f47656b.T(Util.f41614f);
        this.f47657c = true;
        extractorInput.f();
        return 0;
    }

    private int f(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    private int h(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int iMin = (int) Math.min(20000L, extractorInput.getLength());
        long j3 = 0;
        if (extractorInput.getPosition() != j3) {
            positionHolder.f46210a = j3;
            return 1;
        }
        this.f47656b.S(iMin);
        extractorInput.f();
        extractorInput.m(this.f47656b.e(), 0, iMin);
        this.f47660f = i(this.f47656b);
        this.f47658d = true;
        return 0;
    }

    private long i(ParsableByteArray parsableByteArray) {
        int iG = parsableByteArray.g();
        for (int iF = parsableByteArray.f(); iF < iG - 3; iF++) {
            if (f(parsableByteArray.e(), iF) == 442) {
                parsableByteArray.W(iF + 4);
                long jL = l(parsableByteArray);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long length = extractorInput.getLength();
        int iMin = (int) Math.min(20000L, length);
        long j3 = length - ((long) iMin);
        if (extractorInput.getPosition() != j3) {
            positionHolder.f46210a = j3;
            return 1;
        }
        this.f47656b.S(iMin);
        extractorInput.f();
        extractorInput.m(this.f47656b.e(), 0, iMin);
        this.f47661g = k(this.f47656b);
        this.f47659e = true;
        return 0;
    }

    private long k(ParsableByteArray parsableByteArray) {
        int iF = parsableByteArray.f();
        for (int iG = parsableByteArray.g() - 4; iG >= iF; iG--) {
            if (f(parsableByteArray.e(), iG) == 442) {
                parsableByteArray.W(iG + 4);
                long jL = l(parsableByteArray);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long l(ParsableByteArray parsableByteArray) {
        int iF = parsableByteArray.f();
        if (parsableByteArray.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.l(bArr, 0, 9);
        parsableByteArray.W(iF);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    private static long m(byte[] bArr) {
        byte b3 = bArr[0];
        long j3 = (((((long) b3) & 56) >> 3) << 30) | ((((long) b3) & 3) << 28) | ((((long) bArr[1]) & 255) << 20);
        byte b4 = bArr[2];
        return j3 | (((((long) b4) & 248) >> 3) << 15) | ((((long) b4) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public long c() {
        return this.f47662h;
    }

    public TimestampAdjuster d() {
        return this.f47655a;
    }

    public boolean e() {
        return this.f47657c;
    }

    public int g(ExtractorInput extractorInput, PositionHolder positionHolder) {
        if (!this.f47659e) {
            return j(extractorInput, positionHolder);
        }
        if (this.f47661g == -9223372036854775807L) {
            return b(extractorInput);
        }
        if (!this.f47658d) {
            return h(extractorInput, positionHolder);
        }
        long j3 = this.f47660f;
        if (j3 == -9223372036854775807L) {
            return b(extractorInput);
        }
        this.f47662h = this.f47655a.c(this.f47661g) - this.f47655a.b(j3);
        return b(extractorInput);
    }
}
