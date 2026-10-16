package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac3Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableBitArray f47335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f47337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f47338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f47339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TrackOutput f47341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f47345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Format f47346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47347m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47348n;

    public Ac3Reader(String str) {
        this(null, 0, str);
    }

    private boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        int iMin = Math.min(parsableByteArray.a(), i3 - this.f47343i);
        parsableByteArray.l(bArr, this.f47343i, iMin);
        int i4 = this.f47343i + iMin;
        this.f47343i = i4;
        return i4 == i3;
    }

    private void g() {
        this.f47335a.p(0);
        Ac3Util.SyncFrameInfo syncFrameInfoF = Ac3Util.f(this.f47335a);
        Format format = this.f47346l;
        if (format == null || syncFrameInfoF.f46036d != format.E || syncFrameInfoF.f46035c != format.F || !Objects.equals(syncFrameInfoF.f46033a, format.f40632o)) {
            Format.Builder builderP0 = new Format.Builder().f0(this.f47340f).U(this.f47339e).u0(syncFrameInfoF.f46033a).R(syncFrameInfoF.f46036d).v0(syncFrameInfoF.f46035c).j0(this.f47337c).s0(this.f47338d).p0(syncFrameInfoF.f46039g);
            if ("audio/ac3".equals(syncFrameInfoF.f46033a)) {
                builderP0.Q(syncFrameInfoF.f46039g);
            }
            Format formatN = builderP0.N();
            this.f47346l = formatN;
            this.f47341g.c(formatN);
        }
        this.f47347m = syncFrameInfoF.f46037e;
        this.f47345k = (((long) syncFrameInfoF.f46038f) * 1000000) / ((long) this.f47346l.F);
    }

    private boolean h(ParsableByteArray parsableByteArray) {
        while (true) {
            if (parsableByteArray.a() <= 0) {
                return false;
            }
            if (this.f47344j) {
                int iH = parsableByteArray.H();
                if (iH == 119) {
                    this.f47344j = false;
                    return true;
                }
                this.f47344j = iH == 11;
            } else {
                this.f47344j = parsableByteArray.H() == 11;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f47341g);
        while (parsableByteArray.a() > 0) {
            int i3 = this.f47342h;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int iMin = Math.min(parsableByteArray.a(), this.f47347m - this.f47343i);
                        this.f47341g.b(parsableByteArray, iMin);
                        int i4 = this.f47343i + iMin;
                        this.f47343i = i4;
                        if (i4 == this.f47347m) {
                            Assertions.g(this.f47348n != -9223372036854775807L);
                            this.f47341g.g(this.f47348n, 1, this.f47347m, 0, null);
                            this.f47348n += this.f47345k;
                            this.f47342h = 0;
                        }
                    }
                } else if (b(parsableByteArray, this.f47336b.e(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) {
                    g();
                    this.f47336b.W(0);
                    this.f47341g.b(this.f47336b, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f47342h = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f47342h = 1;
                this.f47336b.e()[0] = Ascii.VT;
                this.f47336b.e()[1] = 119;
                this.f47343i = 2;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47342h = 0;
        this.f47343i = 0;
        this.f47344j = false;
        this.f47348n = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47340f = trackIdGenerator.b();
        this.f47341g = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47348n = j3;
    }

    public Ac3Reader(String str, int i3, String str2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD]);
        this.f47335a = parsableBitArray;
        this.f47336b = new ParsableByteArray(parsableBitArray.f41576a);
        this.f47342h = 0;
        this.f47348n = -9223372036854775807L;
        this.f47337c = str;
        this.f47338d = i3;
        this.f47339e = str2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
    }
}
