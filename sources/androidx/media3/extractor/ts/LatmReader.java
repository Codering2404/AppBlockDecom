package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LatmReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f47567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f47568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f47569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ParsableByteArray f47570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ParsableBitArray f47571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TrackOutput f47572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f47573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Format f47574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f47577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f47578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f47579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f47580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f47582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f47583q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f47584r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f47585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f47586t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f47587u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f47588v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f47589w;

    public LatmReader(String str, int i3, String str2) {
        this.f47567a = str;
        this.f47568b = i3;
        this.f47569c = str2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f47570d = parsableByteArray;
        this.f47571e = new ParsableBitArray(parsableByteArray.e());
        this.f47579m = -9223372036854775807L;
    }

    private static long b(ParsableBitArray parsableBitArray) {
        return parsableBitArray.h((parsableBitArray.h(2) + 1) * 8);
    }

    private void g(ParsableBitArray parsableBitArray) throws ParserException {
        if (!parsableBitArray.g()) {
            this.f47580n = true;
            l(parsableBitArray);
        } else if (!this.f47580n) {
            return;
        }
        if (this.f47581o != 0) {
            throw ParserException.a(null, null);
        }
        if (this.f47582p != 0) {
            throw ParserException.a(null, null);
        }
        k(parsableBitArray, j(parsableBitArray));
        if (this.f47584r) {
            parsableBitArray.r((int) this.f47585s);
        }
    }

    private int h(ParsableBitArray parsableBitArray) throws ParserException {
        int iB = parsableBitArray.b();
        AacUtil.Config configD = AacUtil.d(parsableBitArray, true);
        this.f47589w = configD.f46026c;
        this.f47586t = configD.f46024a;
        this.f47588v = configD.f46025b;
        return iB - parsableBitArray.b();
    }

    private void i(ParsableBitArray parsableBitArray) {
        int iH = parsableBitArray.h(3);
        this.f47583q = iH;
        if (iH == 0) {
            parsableBitArray.r(8);
            return;
        }
        if (iH == 1) {
            parsableBitArray.r(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            parsableBitArray.r(6);
        } else {
            if (iH != 6 && iH != 7) {
                throw new IllegalStateException();
            }
            parsableBitArray.r(1);
        }
    }

    private int j(ParsableBitArray parsableBitArray) throws ParserException {
        int iH;
        if (this.f47583q != 0) {
            throw ParserException.a(null, null);
        }
        int i3 = 0;
        do {
            iH = parsableBitArray.h(8);
            i3 += iH;
        } while (iH == 255);
        return i3;
    }

    private void k(ParsableBitArray parsableBitArray, int i3) {
        int iE = parsableBitArray.e();
        if ((iE & 7) == 0) {
            this.f47570d.W(iE >> 3);
        } else {
            parsableBitArray.i(this.f47570d.e(), 0, i3 * 8);
            this.f47570d.W(0);
        }
        this.f47572f.b(this.f47570d, i3);
        Assertions.g(this.f47579m != -9223372036854775807L);
        this.f47572f.g(this.f47579m, 1, i3, 0, null);
        this.f47579m += this.f47587u;
    }

    private void l(ParsableBitArray parsableBitArray) throws ParserException {
        boolean zG;
        int iH = parsableBitArray.h(1);
        int iH2 = iH == 1 ? parsableBitArray.h(1) : 0;
        this.f47581o = iH2;
        if (iH2 != 0) {
            throw ParserException.a(null, null);
        }
        if (iH == 1) {
            b(parsableBitArray);
        }
        if (!parsableBitArray.g()) {
            throw ParserException.a(null, null);
        }
        this.f47582p = parsableBitArray.h(6);
        int iH3 = parsableBitArray.h(4);
        int iH4 = parsableBitArray.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw ParserException.a(null, null);
        }
        if (iH == 0) {
            int iE = parsableBitArray.e();
            int iH5 = h(parsableBitArray);
            parsableBitArray.p(iE);
            byte[] bArr = new byte[(iH5 + 7) / 8];
            parsableBitArray.i(bArr, 0, iH5);
            Format formatN = new Format.Builder().f0(this.f47573g).U(this.f47569c).u0("audio/mp4a-latm").S(this.f47589w).R(this.f47588v).v0(this.f47586t).g0(Collections.singletonList(bArr)).j0(this.f47567a).s0(this.f47568b).N();
            if (!formatN.equals(this.f47574h)) {
                this.f47574h = formatN;
                this.f47587u = 1024000000 / ((long) formatN.F);
                this.f47572f.c(formatN);
            }
        } else {
            parsableBitArray.r(((int) b(parsableBitArray)) - h(parsableBitArray));
        }
        i(parsableBitArray);
        boolean zG2 = parsableBitArray.g();
        this.f47584r = zG2;
        this.f47585s = 0L;
        if (zG2) {
            if (iH == 1) {
                this.f47585s = b(parsableBitArray);
            } else {
                do {
                    zG = parsableBitArray.g();
                    this.f47585s = (this.f47585s << 8) + ((long) parsableBitArray.h(8));
                } while (zG);
            }
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(8);
        }
    }

    private void m(int i3) {
        this.f47570d.S(i3);
        this.f47571e.n(this.f47570d.e());
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.i(this.f47572f);
        while (parsableByteArray.a() > 0) {
            int i3 = this.f47575i;
            if (i3 != 0) {
                if (i3 == 1) {
                    int iH = parsableByteArray.H();
                    if ((iH & 224) == 224) {
                        this.f47578l = iH;
                        this.f47575i = 2;
                    } else if (iH != 86) {
                        this.f47575i = 0;
                    }
                } else if (i3 == 2) {
                    int iH2 = ((this.f47578l & (-225)) << 8) | parsableByteArray.H();
                    this.f47577k = iH2;
                    if (iH2 > this.f47570d.e().length) {
                        m(this.f47577k);
                    }
                    this.f47576j = 0;
                    this.f47575i = 3;
                } else {
                    if (i3 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(parsableByteArray.a(), this.f47577k - this.f47576j);
                    parsableByteArray.l(this.f47571e.f41576a, this.f47576j, iMin);
                    int i4 = this.f47576j + iMin;
                    this.f47576j = i4;
                    if (i4 == this.f47577k) {
                        this.f47571e.p(0);
                        g(this.f47571e);
                        this.f47575i = 0;
                    }
                }
            } else if (parsableByteArray.H() == 86) {
                this.f47575i = 1;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47575i = 0;
        this.f47579m = -9223372036854775807L;
        this.f47580n = false;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47572f = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f47573g = trackIdGenerator.b();
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47579m = j3;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
    }
}
