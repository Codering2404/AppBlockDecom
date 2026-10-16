package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.primitives.Ints;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DtsReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47407a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f47409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f47410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f47411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TrackOutput f47413g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f47417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Format f47418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f47420n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47414h = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f47423q = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f47408b = new AtomicInteger();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47421o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f47422p = -1;

    public DtsReader(String str, int i3, int i4, String str2) {
        this.f47407a = new ParsableByteArray(new byte[i4]);
        this.f47409c = str;
        this.f47410d = i3;
        this.f47411e = str2;
    }

    private boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        int iMin = Math.min(parsableByteArray.a(), i3 - this.f47415i);
        parsableByteArray.l(bArr, this.f47415i, iMin);
        int i4 = this.f47415i + iMin;
        this.f47415i = i4;
        return i4 == i3;
    }

    private void g() {
        byte[] bArrE = this.f47407a.e();
        if (this.f47418l == null) {
            Format formatH = DtsUtil.h(bArrE, this.f47412f, this.f47409c, this.f47410d, this.f47411e, null);
            this.f47418l = formatH;
            this.f47413g.c(formatH);
        }
        this.f47419m = DtsUtil.b(bArrE);
        this.f47417k = Ints.d(Util.Y0(DtsUtil.g(bArrE), this.f47418l.F));
    }

    private void h() throws ParserException {
        DtsUtil.DtsHeader dtsHeaderI = DtsUtil.i(this.f47407a.e());
        k(dtsHeaderI);
        this.f47419m = dtsHeaderI.f46146d;
        long j3 = dtsHeaderI.f46147e;
        if (j3 == -9223372036854775807L) {
            j3 = 0;
        }
        this.f47417k = j3;
    }

    private void i() throws ParserException {
        DtsUtil.DtsHeader dtsHeaderK = DtsUtil.k(this.f47407a.e(), this.f47408b);
        if (this.f47420n == 3) {
            k(dtsHeaderK);
        }
        this.f47419m = dtsHeaderK.f46146d;
        long j3 = dtsHeaderK.f46147e;
        if (j3 == -9223372036854775807L) {
            j3 = 0;
        }
        this.f47417k = j3;
    }

    private boolean j(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.a() > 0) {
            int i3 = this.f47416j << 8;
            this.f47416j = i3;
            int iH = i3 | parsableByteArray.H();
            this.f47416j = iH;
            int iC = DtsUtil.c(iH);
            this.f47420n = iC;
            if (iC != 0) {
                byte[] bArrE = this.f47407a.e();
                int i4 = this.f47416j;
                bArrE[0] = (byte) ((i4 >> 24) & 255);
                bArrE[1] = (byte) ((i4 >> 16) & 255);
                bArrE[2] = (byte) ((i4 >> 8) & 255);
                bArrE[3] = (byte) (i4 & 255);
                this.f47415i = 4;
                this.f47416j = 0;
                return true;
            }
        }
        return false;
    }

    private void k(DtsUtil.DtsHeader dtsHeader) {
        int i3;
        int i4 = dtsHeader.f46144b;
        if (i4 == -2147483647 || (i3 = dtsHeader.f46145c) == -1) {
            return;
        }
        Format format = this.f47418l;
        if (format != null && i3 == format.E && i4 == format.F && Objects.equals(dtsHeader.f46143a, format.f40632o)) {
            return;
        }
        Format format2 = this.f47418l;
        Format formatN = (format2 == null ? new Format.Builder() : format2.b()).f0(this.f47412f).U(this.f47411e).u0(dtsHeader.f46143a).R(dtsHeader.f46145c).v0(dtsHeader.f46144b).j0(this.f47409c).s0(this.f47410d).N();
        this.f47418l = formatN;
        this.f47413g.c(formatN);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.i(this.f47413g);
        while (parsableByteArray.a() > 0) {
            switch (this.f47414h) {
                case 0:
                    if (j(parsableByteArray)) {
                        int i3 = this.f47420n;
                        if (i3 == 3 || i3 == 4) {
                            this.f47414h = 4;
                        } else if (i3 != 1) {
                            this.f47414h = 2;
                        } else {
                            this.f47414h = 1;
                        }
                    }
                    break;
                case 1:
                    if (b(parsableByteArray, this.f47407a.e(), 18)) {
                        g();
                        this.f47407a.W(0);
                        this.f47413g.b(this.f47407a, 18);
                        this.f47414h = 6;
                    }
                    break;
                case 2:
                    if (b(parsableByteArray, this.f47407a.e(), 7)) {
                        this.f47421o = DtsUtil.j(this.f47407a.e());
                        this.f47414h = 3;
                    }
                    break;
                case 3:
                    if (b(parsableByteArray, this.f47407a.e(), this.f47421o)) {
                        h();
                        this.f47407a.W(0);
                        this.f47413g.b(this.f47407a, this.f47421o);
                        this.f47414h = 6;
                    }
                    break;
                case 4:
                    if (b(parsableByteArray, this.f47407a.e(), 6)) {
                        int iL = DtsUtil.l(this.f47407a.e());
                        this.f47422p = iL;
                        int i4 = this.f47415i;
                        if (i4 > iL) {
                            int i5 = i4 - iL;
                            this.f47415i = i4 - i5;
                            parsableByteArray.W(parsableByteArray.f() - i5);
                        }
                        this.f47414h = 5;
                    }
                    break;
                case 5:
                    if (b(parsableByteArray, this.f47407a.e(), this.f47422p)) {
                        i();
                        this.f47407a.W(0);
                        this.f47413g.b(this.f47407a, this.f47422p);
                        this.f47414h = 6;
                    }
                    break;
                case 6:
                    int iMin = Math.min(parsableByteArray.a(), this.f47419m - this.f47415i);
                    this.f47413g.b(parsableByteArray, iMin);
                    int i6 = this.f47415i + iMin;
                    this.f47415i = i6;
                    if (i6 == this.f47419m) {
                        Assertions.g(this.f47423q != -9223372036854775807L);
                        this.f47413g.g(this.f47423q, this.f47420n == 4 ? 0 : 1, this.f47419m, 0, null);
                        this.f47423q += this.f47417k;
                        this.f47414h = 0;
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47414h = 0;
        this.f47415i = 0;
        this.f47416j = 0;
        this.f47423q = -9223372036854775807L;
        this.f47408b.set(0);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47412f = trackIdGenerator.b();
        this.f47413g = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47423q = j3;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
    }
}
