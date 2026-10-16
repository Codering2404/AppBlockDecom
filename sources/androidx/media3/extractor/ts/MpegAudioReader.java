package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MpegAudioReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MpegAudioUtil.Header f47591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f47592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f47593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f47594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TrackOutput f47595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f47596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f47597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f47601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47603n;

    public MpegAudioReader(String str) {
        this(null, 0, str);
    }

    private void b(ParsableByteArray parsableByteArray) {
        byte[] bArrE = parsableByteArray.e();
        int iG = parsableByteArray.g();
        for (int iF = parsableByteArray.f(); iF < iG; iF++) {
            byte b3 = bArrE[iF];
            boolean z2 = (b3 & 255) == 255;
            boolean z3 = this.f47600k && (b3 & 224) == 224;
            this.f47600k = z2;
            if (z3) {
                parsableByteArray.W(iF + 1);
                this.f47600k = false;
                this.f47590a.e()[1] = bArrE[iF];
                this.f47598i = 2;
                this.f47597h = 1;
                return;
            }
        }
        parsableByteArray.W(iG);
    }

    private void g(ParsableByteArray parsableByteArray) {
        int iMin = Math.min(parsableByteArray.a(), this.f47602m - this.f47598i);
        this.f47595f.b(parsableByteArray, iMin);
        int i3 = this.f47598i + iMin;
        this.f47598i = i3;
        if (i3 < this.f47602m) {
            return;
        }
        Assertions.g(this.f47603n != -9223372036854775807L);
        this.f47595f.g(this.f47603n, 1, this.f47602m, 0, null);
        this.f47603n += this.f47601l;
        this.f47598i = 0;
        this.f47597h = 0;
    }

    private void h(ParsableByteArray parsableByteArray) {
        int iMin = Math.min(parsableByteArray.a(), 4 - this.f47598i);
        parsableByteArray.l(this.f47590a.e(), this.f47598i, iMin);
        int i3 = this.f47598i + iMin;
        this.f47598i = i3;
        if (i3 < 4) {
            return;
        }
        this.f47590a.W(0);
        if (!this.f47591b.a(this.f47590a.q())) {
            this.f47598i = 0;
            this.f47597h = 1;
            return;
        }
        MpegAudioUtil.Header header = this.f47591b;
        this.f47602m = header.f46205c;
        if (!this.f47599j) {
            this.f47601l = (((long) header.f46209g) * 1000000) / ((long) header.f46206d);
            this.f47595f.c(new Format.Builder().f0(this.f47596g).U(this.f47594e).u0(this.f47591b.f46204b).k0(4096).R(this.f47591b.f46207e).v0(this.f47591b.f46206d).j0(this.f47592c).s0(this.f47593d).N());
            this.f47599j = true;
        }
        this.f47590a.W(0);
        this.f47595f.b(this.f47590a, 4);
        this.f47597h = 2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f47595f);
        while (parsableByteArray.a() > 0) {
            int i3 = this.f47597h;
            if (i3 == 0) {
                b(parsableByteArray);
            } else if (i3 == 1) {
                h(parsableByteArray);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException();
                }
                g(parsableByteArray);
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47597h = 0;
        this.f47598i = 0;
        this.f47600k = false;
        this.f47603n = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f47596g = trackIdGenerator.b();
        this.f47595f = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        this.f47603n = j3;
    }

    public MpegAudioReader(String str, int i3, String str2) {
        this.f47597h = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f47590a = parsableByteArray;
        parsableByteArray.e()[0] = -1;
        this.f47591b = new MpegAudioUtil.Header();
        this.f47603n = -9223372036854775807L;
        this.f47592c = str;
        this.f47593d = i3;
        this.f47594e = str2;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
    }
}
