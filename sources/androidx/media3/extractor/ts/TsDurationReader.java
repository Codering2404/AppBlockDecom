package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TsDurationReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f47697a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f47700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f47701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f47702f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimestampAdjuster f47698b = new TimestampAdjuster(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47703g = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f47704h = -9223372036854775807L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f47705i = -9223372036854775807L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f47699c = new ParsableByteArray();

    TsDurationReader(int i3) {
        this.f47697a = i3;
    }

    private int a(ExtractorInput extractorInput) {
        this.f47699c.T(Util.f41614f);
        this.f47700d = true;
        extractorInput.f();
        return 0;
    }

    private int f(ExtractorInput extractorInput, PositionHolder positionHolder, int i3) {
        int iMin = (int) Math.min(this.f47697a, extractorInput.getLength());
        long j3 = 0;
        if (extractorInput.getPosition() != j3) {
            positionHolder.f46210a = j3;
            return 1;
        }
        this.f47699c.S(iMin);
        extractorInput.f();
        extractorInput.m(this.f47699c.e(), 0, iMin);
        this.f47703g = g(this.f47699c, i3);
        this.f47701e = true;
        return 0;
    }

    private long g(ParsableByteArray parsableByteArray, int i3) {
        int iG = parsableByteArray.g();
        for (int iF = parsableByteArray.f(); iF < iG; iF++) {
            if (parsableByteArray.e()[iF] == 71) {
                long jC = TsUtil.c(parsableByteArray, iF, i3);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(ExtractorInput extractorInput, PositionHolder positionHolder, int i3) {
        long length = extractorInput.getLength();
        int iMin = (int) Math.min(this.f47697a, length);
        long j3 = length - ((long) iMin);
        if (extractorInput.getPosition() != j3) {
            positionHolder.f46210a = j3;
            return 1;
        }
        this.f47699c.S(iMin);
        extractorInput.f();
        extractorInput.m(this.f47699c.e(), 0, iMin);
        this.f47704h = i(this.f47699c, i3);
        this.f47702f = true;
        return 0;
    }

    private long i(ParsableByteArray parsableByteArray, int i3) {
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        for (int i4 = iG - 188; i4 >= iF; i4--) {
            if (TsUtil.b(parsableByteArray.e(), iF, iG, i4)) {
                long jC = TsUtil.c(parsableByteArray, i4, i3);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    public long b() {
        return this.f47705i;
    }

    public TimestampAdjuster c() {
        return this.f47698b;
    }

    public boolean d() {
        return this.f47700d;
    }

    public int e(ExtractorInput extractorInput, PositionHolder positionHolder, int i3) {
        if (i3 <= 0) {
            return a(extractorInput);
        }
        if (!this.f47702f) {
            return h(extractorInput, positionHolder, i3);
        }
        if (this.f47704h == -9223372036854775807L) {
            return a(extractorInput);
        }
        if (!this.f47701e) {
            return f(extractorInput, positionHolder, i3);
        }
        long j3 = this.f47703g;
        if (j3 == -9223372036854775807L) {
            return a(extractorInput);
        }
        this.f47705i = this.f47698b.c(this.f47704h) - this.f47698b.b(j3);
        return a(extractorInput);
    }
}
