package androidx.media3.extractor.flv;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlvExtractor implements Extractor {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ExtractorsFactory f46358q = new ExtractorsFactory() { // from class: androidx.media3.extractor.flv.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return FlvExtractor.b();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ExtractorOutput f46364f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f46366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f46367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f46369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f46370l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f46371m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f46372n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AudioTagPayloadReader f46373o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private VideoTagPayloadReader f46374p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f46359a = new ParsableByteArray(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f46360b = new ParsableByteArray(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f46361c = new ParsableByteArray(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ParsableByteArray f46362d = new ParsableByteArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScriptTagPayloadReader f46363e = new ScriptTagPayloadReader();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46365g = 1;

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new FlvExtractor()};
    }

    private void d() {
        if (this.f46372n) {
            return;
        }
        this.f46364f.n(new SeekMap.Unseekable(-9223372036854775807L));
        this.f46372n = true;
    }

    private long e() {
        if (this.f46366h) {
            return this.f46367i + this.f46371m;
        }
        if (this.f46363e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.f46371m;
    }

    private ParsableByteArray f(ExtractorInput extractorInput) {
        if (this.f46370l > this.f46362d.b()) {
            ParsableByteArray parsableByteArray = this.f46362d;
            parsableByteArray.U(new byte[Math.max(parsableByteArray.b() * 2, this.f46370l)], 0);
        } else {
            this.f46362d.W(0);
        }
        this.f46362d.V(this.f46370l);
        extractorInput.readFully(this.f46362d.e(), 0, this.f46370l);
        return this.f46362d;
    }

    private boolean k(ExtractorInput extractorInput) {
        if (!extractorInput.g(this.f46360b.e(), 0, 9, true)) {
            return false;
        }
        this.f46360b.W(0);
        this.f46360b.X(4);
        int iH = this.f46360b.H();
        boolean z2 = (iH & 4) != 0;
        boolean z3 = (iH & 1) != 0;
        if (z2 && this.f46373o == null) {
            this.f46373o = new AudioTagPayloadReader(this.f46364f.d(8, 1));
        }
        if (z3 && this.f46374p == null) {
            this.f46374p = new VideoTagPayloadReader(this.f46364f.d(9, 2));
        }
        this.f46364f.q();
        this.f46368j = this.f46360b.q() - 5;
        this.f46365g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean l(androidx.media3.extractor.ExtractorInput r10) {
        /*
            r9 = this;
            long r0 = r9.e()
            int r2 = r9.f46369k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            androidx.media3.extractor.flv.AudioTagPayloadReader r3 = r9.f46373o
            if (r3 == 0) goto L23
            r9.d()
            androidx.media3.extractor.flv.AudioTagPayloadReader r2 = r9.f46373o
            androidx.media3.common.util.ParsableByteArray r10 = r9.f(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = r6
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            androidx.media3.extractor.flv.VideoTagPayloadReader r3 = r9.f46374p
            if (r3 == 0) goto L39
            r9.d()
            androidx.media3.extractor.flv.VideoTagPayloadReader r2 = r9.f46374p
            androidx.media3.common.util.ParsableByteArray r10 = r9.f(r10)
            boolean r10 = r2.a(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.f46372n
            if (r2 != 0) goto L6e
            androidx.media3.extractor.flv.ScriptTagPayloadReader r2 = r9.f46363e
            androidx.media3.common.util.ParsableByteArray r10 = r9.f(r10)
            boolean r10 = r2.a(r10, r0)
            androidx.media3.extractor.flv.ScriptTagPayloadReader r0 = r9.f46363e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            androidx.media3.extractor.ExtractorOutput r2 = r9.f46364f
            androidx.media3.extractor.IndexSeekMap r3 = new androidx.media3.extractor.IndexSeekMap
            androidx.media3.extractor.flv.ScriptTagPayloadReader r7 = r9.f46363e
            long[] r7 = r7.e()
            androidx.media3.extractor.flv.ScriptTagPayloadReader r8 = r9.f46363e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.n(r3)
            r9.f46372n = r6
            goto L21
        L6e:
            int r0 = r9.f46370l
            r10.k(r0)
            r10 = 0
            r0 = r10
        L75:
            boolean r1 = r9.f46366h
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.f46366h = r6
            androidx.media3.extractor.flv.ScriptTagPayloadReader r10 = r9.f46363e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.f46371m
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.f46367i = r1
        L8f:
            r10 = 4
            r9.f46368j = r10
            r10 = 2
            r9.f46365g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.flv.FlvExtractor.l(androidx.media3.extractor.ExtractorInput):boolean");
    }

    private boolean m(ExtractorInput extractorInput) {
        if (!extractorInput.g(this.f46361c.e(), 0, 11, true)) {
            return false;
        }
        this.f46361c.W(0);
        this.f46369k = this.f46361c.H();
        this.f46370l = this.f46361c.K();
        this.f46371m = this.f46361c.K();
        this.f46371m = (((long) (this.f46361c.H() << 24)) | this.f46371m) * 1000;
        this.f46361c.X(3);
        this.f46365g = 4;
        return true;
    }

    private void n(ExtractorInput extractorInput) {
        extractorInput.k(this.f46368j);
        this.f46368j = 0;
        this.f46365g = 3;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        if (j3 == 0) {
            this.f46365g = 1;
            this.f46366h = false;
        } else {
            this.f46365g = 3;
        }
        this.f46368j = 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        extractorInput.m(this.f46359a.e(), 0, 3);
        this.f46359a.W(0);
        if (this.f46359a.K() != 4607062) {
            return false;
        }
        extractorInput.m(this.f46359a.e(), 0, 2);
        this.f46359a.W(0);
        if ((this.f46359a.P() & 250) != 0) {
            return false;
        }
        extractorInput.m(this.f46359a.e(), 0, 4);
        this.f46359a.W(0);
        int iQ = this.f46359a.q();
        extractorInput.f();
        extractorInput.i(iQ);
        extractorInput.m(this.f46359a.e(), 0, 4);
        this.f46359a.W(0);
        return this.f46359a.q() == 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46364f = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        Assertions.i(this.f46364f);
        while (true) {
            int i3 = this.f46365g;
            if (i3 != 1) {
                if (i3 == 2) {
                    n(extractorInput);
                } else if (i3 != 3) {
                    if (i3 != 4) {
                        throw new IllegalStateException();
                    }
                    if (l(extractorInput)) {
                        return 0;
                    }
                } else if (!m(extractorInput)) {
                    return -1;
                }
            } else if (!k(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
