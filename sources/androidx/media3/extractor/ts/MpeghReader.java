package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.MpeghUtil;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MpeghReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f47604a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TrackOutput f47610g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47613j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f47615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47616m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47618o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f47619p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f47623t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f47625v;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f47608e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47605b = new ParsableByteArray(new byte[15], 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableBitArray f47606c = new ParsableBitArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ParsableByteArray f47607d = new ParsableByteArray();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MpeghUtil.MhasPacketHeader f47620q = new MpeghUtil.MhasPacketHeader();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f47621r = -2147483647;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f47622s = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f47624u = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47614k = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f47617n = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f47611h = -9.223372036854776E18d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f47612i = -9.223372036854776E18d;

    public MpeghReader(String str) {
        this.f47604a = str;
    }

    private void b(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z2) {
        int iF = parsableByteArray.f();
        int iMin = Math.min(parsableByteArray.a(), parsableByteArray2.a());
        parsableByteArray.l(parsableByteArray2.e(), parsableByteArray2.f(), iMin);
        parsableByteArray2.X(iMin);
        if (z2) {
            parsableByteArray.W(iF);
        }
    }

    private void g() {
        int i3;
        if (this.f47625v) {
            this.f47614k = false;
            i3 = 1;
        } else {
            i3 = 0;
        }
        double d3 = (((double) (this.f47622s - this.f47623t)) * 1000000.0d) / ((double) this.f47621r);
        long jRound = Math.round(this.f47611h);
        if (this.f47613j) {
            this.f47613j = false;
            this.f47611h = this.f47612i;
        } else {
            this.f47611h += d3;
        }
        this.f47610g.g(jRound, i3, this.f47619p, 0, null);
        this.f47625v = false;
        this.f47623t = 0;
        this.f47619p = 0;
    }

    private void h(ParsableBitArray parsableBitArray) throws ParserException {
        MpeghUtil.Mpegh3daConfig mpegh3daConfigH = MpeghUtil.h(parsableBitArray);
        this.f47621r = mpegh3daConfigH.f47630b;
        this.f47622s = mpegh3daConfigH.f47631c;
        long j3 = this.f47624u;
        long j4 = this.f47620q.f47627b;
        if (j3 != j4) {
            this.f47624u = j4;
            String str = "mhm1";
            if (mpegh3daConfigH.f47629a != -1) {
                str = "mhm1" + String.format(".%02X", Integer.valueOf(mpegh3daConfigH.f47629a));
            }
            byte[] bArr = mpegh3daConfigH.f47632d;
            this.f47610g.c(new Format.Builder().f0(this.f47609f).U(this.f47604a).u0("audio/mhm1").v0(this.f47621r).S(str).g0((bArr == null || bArr.length <= 0) ? null : ImmutableList.A(Util.f41614f, bArr)).N());
        }
        this.f47625v = true;
    }

    private boolean i() throws ParserException {
        int iG = this.f47605b.g();
        this.f47606c.o(this.f47605b.e(), iG);
        boolean zG = MpeghUtil.g(this.f47606c, this.f47620q);
        if (zG) {
            this.f47618o = 0;
            this.f47619p += this.f47620q.f47628c + iG;
        }
        return zG;
    }

    private boolean j(int i3) {
        return i3 == 1 || i3 == 17;
    }

    private boolean k(ParsableByteArray parsableByteArray) {
        int i3 = this.f47615l;
        if ((i3 & 2) == 0) {
            parsableByteArray.W(parsableByteArray.g());
            return false;
        }
        if ((i3 & 4) != 0) {
            return true;
        }
        while (parsableByteArray.a() > 0) {
            int i4 = this.f47616m << 8;
            this.f47616m = i4;
            int iH = i4 | parsableByteArray.H();
            this.f47616m = iH;
            if (MpeghUtil.e(iH)) {
                parsableByteArray.W(parsableByteArray.f() - 3);
                this.f47616m = 0;
                return true;
            }
        }
        return false;
    }

    private void l(ParsableByteArray parsableByteArray) {
        int iMin = Math.min(parsableByteArray.a(), this.f47620q.f47628c - this.f47618o);
        this.f47610g.b(parsableByteArray, iMin);
        this.f47618o += iMin;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.i(this.f47610g);
        while (parsableByteArray.a() > 0) {
            int i3 = this.f47608e;
            if (i3 != 0) {
                if (i3 == 1) {
                    b(parsableByteArray, this.f47605b, false);
                    if (this.f47605b.a() != 0) {
                        this.f47617n = false;
                    } else if (i()) {
                        this.f47605b.W(0);
                        TrackOutput trackOutput = this.f47610g;
                        ParsableByteArray parsableByteArray2 = this.f47605b;
                        trackOutput.b(parsableByteArray2, parsableByteArray2.g());
                        this.f47605b.S(2);
                        this.f47607d.S(this.f47620q.f47628c);
                        this.f47617n = true;
                        this.f47608e = 2;
                    } else if (this.f47605b.g() < 15) {
                        ParsableByteArray parsableByteArray3 = this.f47605b;
                        parsableByteArray3.V(parsableByteArray3.g() + 1);
                        this.f47617n = false;
                    }
                } else {
                    if (i3 != 2) {
                        throw new IllegalStateException();
                    }
                    if (j(this.f47620q.f47626a)) {
                        b(parsableByteArray, this.f47607d, true);
                    }
                    l(parsableByteArray);
                    int i4 = this.f47618o;
                    MpeghUtil.MhasPacketHeader mhasPacketHeader = this.f47620q;
                    if (i4 == mhasPacketHeader.f47628c) {
                        int i5 = mhasPacketHeader.f47626a;
                        if (i5 == 1) {
                            h(new ParsableBitArray(this.f47607d.e()));
                        } else if (i5 == 17) {
                            this.f47623t = MpeghUtil.f(new ParsableBitArray(this.f47607d.e()));
                        } else if (i5 == 2) {
                            g();
                        }
                        this.f47608e = 1;
                    }
                }
            } else if (k(parsableByteArray)) {
                this.f47608e = 1;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47608e = 0;
        this.f47616m = 0;
        this.f47605b.S(2);
        this.f47618o = 0;
        this.f47619p = 0;
        this.f47621r = -2147483647;
        this.f47622s = -1;
        this.f47623t = 0;
        this.f47624u = -1L;
        this.f47625v = false;
        this.f47613j = false;
        this.f47617n = true;
        this.f47614k = true;
        this.f47611h = -9.223372036854776E18d;
        this.f47612i = -9.223372036854776E18d;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47609f = trackIdGenerator.b();
        this.f47610g = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47615l = i3;
        if (!this.f47614k && (this.f47619p != 0 || !this.f47617n)) {
            this.f47613j = true;
        }
        if (j3 != -9223372036854775807L) {
            if (this.f47613j) {
                this.f47612i = j3;
            } else {
                this.f47611h = j3;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
    }
}
