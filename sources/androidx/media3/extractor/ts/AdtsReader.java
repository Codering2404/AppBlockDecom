package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AdtsReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final byte[] f47381x = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f47382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableBitArray f47383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f47384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f47385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f47386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f47387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f47388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TrackOutput f47389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TrackOutput f47390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f47392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f47393l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f47394m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f47395n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47396o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f47397p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f47398q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f47399r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f47400s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f47401t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f47402u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TrackOutput f47403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f47404w;

    public AdtsReader(boolean z2, String str) {
        this(z2, null, 0, str);
    }

    private void b() {
        Assertions.e(this.f47389h);
        Util.k(this.f47403v);
        Util.k(this.f47390i);
    }

    private void g(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() == 0) {
            return;
        }
        this.f47383b.f41576a[0] = parsableByteArray.e()[parsableByteArray.f()];
        this.f47383b.p(2);
        int iH = this.f47383b.h(4);
        int i3 = this.f47397p;
        if (i3 != -1 && iH != i3) {
            q();
            return;
        }
        if (!this.f47395n) {
            this.f47395n = true;
            this.f47396o = this.f47398q;
            this.f47397p = iH;
        }
        t();
    }

    private boolean h(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.W(i3 + 1);
        if (!w(parsableByteArray, this.f47383b.f41576a, 1)) {
            return false;
        }
        this.f47383b.p(4);
        int iH = this.f47383b.h(1);
        int i4 = this.f47396o;
        if (i4 != -1 && iH != i4) {
            return false;
        }
        if (this.f47397p != -1) {
            if (!w(parsableByteArray, this.f47383b.f41576a, 1)) {
                return true;
            }
            this.f47383b.p(2);
            if (this.f47383b.h(4) != this.f47397p) {
                return false;
            }
            parsableByteArray.W(i3 + 2);
        }
        if (!w(parsableByteArray, this.f47383b.f41576a, 4)) {
            return true;
        }
        this.f47383b.p(14);
        int iH2 = this.f47383b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrE = parsableByteArray.e();
        int iG = parsableByteArray.g();
        int i5 = i3 + iH2;
        if (i5 >= iG) {
            return true;
        }
        byte b3 = bArrE[i5];
        if (b3 == -1) {
            int i6 = i5 + 1;
            if (i6 == iG) {
                return true;
            }
            return l((byte) -1, bArrE[i6]) && ((bArrE[i6] & 8) >> 3) == iH;
        }
        if (b3 != 73) {
            return false;
        }
        int i7 = i5 + 1;
        if (i7 == iG) {
            return true;
        }
        if (bArrE[i7] != 68) {
            return false;
        }
        int i8 = i5 + 2;
        return i8 == iG || bArrE[i8] == 51;
    }

    private boolean i(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        int iMin = Math.min(parsableByteArray.a(), i3 - this.f47392k);
        parsableByteArray.l(bArr, this.f47392k, iMin);
        int i4 = this.f47392k + iMin;
        this.f47392k = i4;
        return i4 == i3;
    }

    private void j(ParsableByteArray parsableByteArray) {
        byte[] bArrE = parsableByteArray.e();
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        while (iF < iG) {
            int i3 = iF + 1;
            byte b3 = bArrE[iF];
            int i4 = b3 & 255;
            if (this.f47393l == 512 && l((byte) -1, (byte) i4) && (this.f47395n || h(parsableByteArray, iF - 1))) {
                this.f47398q = (b3 & 8) >> 3;
                this.f47394m = (b3 & 1) == 0;
                if (this.f47395n) {
                    t();
                } else {
                    r();
                }
                parsableByteArray.W(i3);
                return;
            }
            int i5 = this.f47393l;
            int i6 = i4 | i5;
            if (i6 == 329) {
                this.f47393l = 768;
            } else if (i6 == 511) {
                this.f47393l = 512;
            } else if (i6 == 836) {
                this.f47393l = 1024;
            } else if (i6 == 1075) {
                u();
                parsableByteArray.W(i3);
                return;
            } else if (i5 != 256) {
                this.f47393l = Function.MAX_NARGS;
            }
            iF = i3;
        }
        parsableByteArray.W(iF);
    }

    private boolean l(byte b3, byte b4) {
        return m(((b3 & 255) << 8) | (b4 & 255));
    }

    public static boolean m(int i3) {
        return (i3 & 65526) == 65520;
    }

    private void n() {
        this.f47383b.p(0);
        if (this.f47399r) {
            this.f47383b.r(10);
        } else {
            int i3 = 2;
            int iH = this.f47383b.h(2) + 1;
            if (iH != 2) {
                Log.i("AdtsReader", "Detected audio object type: " + iH + ", but assuming AAC LC.");
            } else {
                i3 = iH;
            }
            this.f47383b.r(5);
            byte[] bArrA = AacUtil.a(i3, this.f47397p, this.f47383b.h(3));
            AacUtil.Config configE = AacUtil.e(bArrA);
            Format formatN = new Format.Builder().f0(this.f47388g).U(this.f47387f).u0("audio/mp4a-latm").S(configE.f46026c).R(configE.f46025b).v0(configE.f46024a).g0(Collections.singletonList(bArrA)).j0(this.f47385d).s0(this.f47386e).N();
            this.f47400s = 1024000000 / ((long) formatN.F);
            this.f47389h.c(formatN);
            this.f47399r = true;
        }
        this.f47383b.r(4);
        int iH2 = this.f47383b.h(13);
        int i4 = iH2 - 7;
        if (this.f47394m) {
            i4 = iH2 - 9;
        }
        v(this.f47389h, this.f47400s, 0, i4);
    }

    private void o() {
        this.f47390i.b(this.f47384c, 10);
        this.f47384c.W(6);
        v(this.f47390i, 0L, 10, this.f47384c.G() + 10);
    }

    private void p(ParsableByteArray parsableByteArray) {
        int iMin = Math.min(parsableByteArray.a(), this.f47401t - this.f47392k);
        this.f47403v.b(parsableByteArray, iMin);
        int i3 = this.f47392k + iMin;
        this.f47392k = i3;
        if (i3 == this.f47401t) {
            Assertions.g(this.f47402u != -9223372036854775807L);
            this.f47403v.g(this.f47402u, 1, this.f47401t, 0, null);
            this.f47402u += this.f47404w;
            s();
        }
    }

    private void q() {
        this.f47395n = false;
        s();
    }

    private void r() {
        this.f47391j = 1;
        this.f47392k = 0;
    }

    private void s() {
        this.f47391j = 0;
        this.f47392k = 0;
        this.f47393l = Function.MAX_NARGS;
    }

    private void t() {
        this.f47391j = 3;
        this.f47392k = 0;
    }

    private void u() {
        this.f47391j = 2;
        this.f47392k = f47381x.length;
        this.f47401t = 0;
        this.f47384c.W(0);
    }

    private void v(TrackOutput trackOutput, long j3, int i3, int i4) {
        this.f47391j = 4;
        this.f47392k = i3;
        this.f47403v = trackOutput;
        this.f47404w = j3;
        this.f47401t = i4;
    }

    private boolean w(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        if (parsableByteArray.a() < i3) {
            return false;
        }
        parsableByteArray.l(bArr, 0, i3);
        return true;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        b();
        while (parsableByteArray.a() > 0) {
            int i3 = this.f47391j;
            if (i3 == 0) {
                j(parsableByteArray);
            } else if (i3 == 1) {
                g(parsableByteArray);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (i(parsableByteArray, this.f47383b.f41576a, this.f47394m ? 7 : 5)) {
                        n();
                    }
                } else {
                    if (i3 != 4) {
                        throw new IllegalStateException();
                    }
                    p(parsableByteArray);
                }
            } else if (i(parsableByteArray, this.f47384c.e(), 10)) {
                o();
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47402u = -9223372036854775807L;
        q();
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47388g = trackIdGenerator.b();
        TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 1);
        this.f47389h = trackOutputD;
        this.f47403v = trackOutputD;
        if (!this.f47382a) {
            this.f47390i = new DiscardingTrackOutput();
            return;
        }
        trackIdGenerator.a();
        TrackOutput trackOutputD2 = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f47390i = trackOutputD2;
        trackOutputD2.c(new Format.Builder().f0(trackIdGenerator.b()).U(this.f47387f).u0("application/id3").N());
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47402u = j3;
    }

    public long k() {
        return this.f47400s;
    }

    public AdtsReader(boolean z2, String str, int i3, String str2) {
        this.f47383b = new ParsableBitArray(new byte[7]);
        this.f47384c = new ParsableByteArray(Arrays.copyOf(f47381x, 10));
        this.f47396o = -1;
        this.f47397p = -1;
        this.f47400s = -9223372036854775807L;
        this.f47402u = -9223372036854775807L;
        this.f47382a = z2;
        this.f47385d = str;
        this.f47386e = i3;
        this.f47387f = str2;
        s();
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
    }
}
