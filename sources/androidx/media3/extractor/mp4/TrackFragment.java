package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TrackFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DefaultSampleValues f46836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f46837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f46838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f46839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f46840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f46841f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f46847l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TrackEncryptionBox f46849n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f46851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f46852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f46853r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f46842g = new long[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f46843h = new int[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f46844i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f46845j = new long[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f46846k = new boolean[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean[] f46848m = new boolean[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ParsableByteArray f46850o = new ParsableByteArray();

    public void a(ParsableByteArray parsableByteArray) {
        parsableByteArray.l(this.f46850o.e(), 0, this.f46850o.g());
        this.f46850o.W(0);
        this.f46851p = false;
    }

    public void b(ExtractorInput extractorInput) {
        extractorInput.readFully(this.f46850o.e(), 0, this.f46850o.g());
        this.f46850o.W(0);
        this.f46851p = false;
    }

    public long c(int i3) {
        return this.f46845j[i3];
    }

    public void d(int i3) {
        this.f46850o.S(i3);
        this.f46847l = true;
        this.f46851p = true;
    }

    public void e(int i3, int i4) {
        this.f46840e = i3;
        this.f46841f = i4;
        if (this.f46843h.length < i3) {
            this.f46842g = new long[i3];
            this.f46843h = new int[i3];
        }
        if (this.f46844i.length < i4) {
            int i5 = (i4 * 125) / 100;
            this.f46844i = new int[i5];
            this.f46845j = new long[i5];
            this.f46846k = new boolean[i5];
            this.f46848m = new boolean[i5];
        }
    }

    public void f() {
        this.f46840e = 0;
        this.f46852q = 0L;
        this.f46853r = false;
        this.f46847l = false;
        this.f46851p = false;
        this.f46849n = null;
    }

    public boolean g(int i3) {
        return this.f46847l && this.f46848m[i3];
    }
}
