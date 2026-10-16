package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac4Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableBitArray f47353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f47355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f47356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f47357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TrackOutput f47359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47363k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f47364l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Format f47365m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f47366n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f47367o;

    public Ac4Reader(String str) {
        this(null, 0, str);
    }

    private boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        int iMin = Math.min(parsableByteArray.a(), i3 - this.f47361i);
        parsableByteArray.l(bArr, this.f47361i, iMin);
        int i4 = this.f47361i + iMin;
        this.f47361i = i4;
        return i4 == i3;
    }

    private void g() {
        this.f47353a.p(0);
        Ac4Util.SyncFrameInfo syncFrameInfoF = Ac4Util.f(this.f47353a);
        Format format = this.f47365m;
        if (format == null || syncFrameInfoF.f46049c != format.E || syncFrameInfoF.f46048b != format.F || !"audio/ac4".equals(format.f40632o)) {
            Format formatN = new Format.Builder().f0(this.f47358f).U(this.f47357e).u0("audio/ac4").R(syncFrameInfoF.f46049c).v0(syncFrameInfoF.f46048b).j0(this.f47355c).s0(this.f47356d).N();
            this.f47365m = formatN;
            this.f47359g.c(formatN);
        }
        this.f47366n = syncFrameInfoF.f46050d;
        this.f47364l = (((long) syncFrameInfoF.f46051e) * 1000000) / ((long) this.f47365m.F);
    }

    private boolean h(ParsableByteArray parsableByteArray) {
        int iH;
        while (true) {
            if (parsableByteArray.a() <= 0) {
                return false;
            }
            if (this.f47362j) {
                iH = parsableByteArray.H();
                this.f47362j = iH == 172;
                if (iH == 64 || iH == 65) {
                    break;
                }
            } else {
                this.f47362j = parsableByteArray.H() == 172;
            }
        }
        this.f47363k = iH == 65;
        return true;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f47359g);
        while (parsableByteArray.a() > 0) {
            int i3 = this.f47360h;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int iMin = Math.min(parsableByteArray.a(), this.f47366n - this.f47361i);
                        this.f47359g.b(parsableByteArray, iMin);
                        int i4 = this.f47361i + iMin;
                        this.f47361i = i4;
                        if (i4 == this.f47366n) {
                            Assertions.g(this.f47367o != -9223372036854775807L);
                            this.f47359g.g(this.f47367o, 1, this.f47366n, 0, null);
                            this.f47367o += this.f47364l;
                            this.f47360h = 0;
                        }
                    }
                } else if (b(parsableByteArray, this.f47354b.e(), 16)) {
                    g();
                    this.f47354b.W(0);
                    this.f47359g.b(this.f47354b, 16);
                    this.f47360h = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f47360h = 1;
                this.f47354b.e()[0] = -84;
                this.f47354b.e()[1] = (byte) (this.f47363k ? 65 : 64);
                this.f47361i = 2;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47360h = 0;
        this.f47361i = 0;
        this.f47362j = false;
        this.f47363k = false;
        this.f47367o = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47358f = trackIdGenerator.b();
        this.f47359g = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47367o = j3;
    }

    public Ac4Reader(String str, int i3, String str2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[16]);
        this.f47353a = parsableBitArray;
        this.f47354b = new ParsableByteArray(parsableBitArray.f41576a);
        this.f47360h = 0;
        this.f47361i = 0;
        this.f47362j = false;
        this.f47363k = false;
        this.f47367o = -9223372036854775807L;
        this.f47355c = str;
        this.f47356d = i3;
        this.f47357e = str2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
    }
}
