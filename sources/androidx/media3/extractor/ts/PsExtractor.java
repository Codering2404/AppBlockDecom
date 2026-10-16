package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PsExtractor implements Extractor {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ExtractorsFactory f47663l = new ExtractorsFactory() { // from class: androidx.media3.extractor.ts.d
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return PsExtractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimestampAdjuster f47664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f47665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f47666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PsDurationReader f47667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f47668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f47669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f47670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f47671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PsBinarySearchSeeker f47672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ExtractorOutput f47673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47674k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PesReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ElementaryStreamReader f47675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TimestampAdjuster f47676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParsableBitArray f47677c = new ParsableBitArray(new byte[64]);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f47678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f47679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f47680f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47681g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f47682h;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f47675a = elementaryStreamReader;
            this.f47676b = timestampAdjuster;
        }

        private void b() {
            this.f47677c.r(8);
            this.f47678d = this.f47677c.g();
            this.f47679e = this.f47677c.g();
            this.f47677c.r(6);
            this.f47681g = this.f47677c.h(8);
        }

        private void c() {
            this.f47682h = 0L;
            if (this.f47678d) {
                this.f47677c.r(4);
                long jH = ((long) this.f47677c.h(3)) << 30;
                this.f47677c.r(1);
                long jH2 = jH | ((long) (this.f47677c.h(15) << 15));
                this.f47677c.r(1);
                long jH3 = jH2 | ((long) this.f47677c.h(15));
                this.f47677c.r(1);
                if (!this.f47680f && this.f47679e) {
                    this.f47677c.r(4);
                    long jH4 = ((long) this.f47677c.h(3)) << 30;
                    this.f47677c.r(1);
                    long jH5 = jH4 | ((long) (this.f47677c.h(15) << 15));
                    this.f47677c.r(1);
                    long jH6 = jH5 | ((long) this.f47677c.h(15));
                    this.f47677c.r(1);
                    this.f47676b.b(jH6);
                    this.f47680f = true;
                }
                this.f47682h = this.f47676b.b(jH3);
            }
        }

        public void a(ParsableByteArray parsableByteArray) {
            parsableByteArray.l(this.f47677c.f41576a, 0, 3);
            this.f47677c.p(0);
            b();
            parsableByteArray.l(this.f47677c.f41576a, 0, this.f47681g);
            this.f47677c.p(0);
            c();
            this.f47675a.f(this.f47682h, 4);
            this.f47675a.a(parsableByteArray);
            this.f47675a.d(false);
        }

        public void d() {
            this.f47680f = false;
            this.f47675a.c();
        }
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0L));
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new PsExtractor()};
    }

    private void d(long j3) {
        if (this.f47674k) {
            return;
        }
        this.f47674k = true;
        if (this.f47667d.c() == -9223372036854775807L) {
            this.f47673j.n(new SeekMap.Unseekable(this.f47667d.c()));
            return;
        }
        PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(this.f47667d.d(), this.f47667d.c(), j3);
        this.f47672i = psBinarySearchSeeker;
        this.f47673j.n(psBinarySearchSeeker.b());
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        boolean z2 = this.f47664a.f() == -9223372036854775807L;
        if (!z2) {
            long jD = this.f47664a.d();
            z2 = (jD == -9223372036854775807L || jD == 0 || jD == j4) ? false : true;
        }
        if (z2) {
            this.f47664a.i(j4);
        }
        PsBinarySearchSeeker psBinarySearchSeeker = this.f47672i;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.h(j4);
        }
        for (int i3 = 0; i3 < this.f47665b.size(); i3++) {
            ((PesReader) this.f47665b.valueAt(i3)).d();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        byte[] bArr = new byte[14];
        extractorInput.m(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.i(bArr[13] & 7);
        extractorInput.m(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f47673j = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        ElementaryStreamReader h262Reader;
        Assertions.i(this.f47673j);
        long length = extractorInput.getLength();
        if (length != -1 && !this.f47667d.e()) {
            return this.f47667d.g(extractorInput, positionHolder);
        }
        d(length);
        PsBinarySearchSeeker psBinarySearchSeeker = this.f47672i;
        if (psBinarySearchSeeker != null && psBinarySearchSeeker.d()) {
            return this.f47672i.c(extractorInput, positionHolder);
        }
        extractorInput.f();
        long jH = length != -1 ? length - extractorInput.h() : -1L;
        if ((jH != -1 && jH < 4) || !extractorInput.d(this.f47666c.e(), 0, 4, true)) {
            return -1;
        }
        this.f47666c.W(0);
        int iQ = this.f47666c.q();
        if (iQ == 441) {
            return -1;
        }
        if (iQ == 442) {
            extractorInput.m(this.f47666c.e(), 0, 10);
            this.f47666c.W(9);
            extractorInput.k((this.f47666c.H() & 7) + 14);
            return 0;
        }
        if (iQ == 443) {
            extractorInput.m(this.f47666c.e(), 0, 2);
            this.f47666c.W(0);
            extractorInput.k(this.f47666c.P() + 6);
            return 0;
        }
        if (((iQ & (-256)) >> 8) != 1) {
            extractorInput.k(1);
            return 0;
        }
        int i3 = iQ & 255;
        PesReader pesReader = (PesReader) this.f47665b.get(i3);
        if (!this.f47668e) {
            if (pesReader == null) {
                if (i3 == 189) {
                    h262Reader = new Ac3Reader("video/mp2p");
                    this.f47669f = true;
                    this.f47671h = extractorInput.getPosition();
                } else if ((iQ & 224) == 192) {
                    h262Reader = new MpegAudioReader("video/mp2p");
                    this.f47669f = true;
                    this.f47671h = extractorInput.getPosition();
                } else if ((iQ & 240) == 224) {
                    h262Reader = new H262Reader("video/mp2p");
                    this.f47670g = true;
                    this.f47671h = extractorInput.getPosition();
                } else {
                    h262Reader = null;
                }
                if (h262Reader != null) {
                    h262Reader.e(this.f47673j, new TsPayloadReader.TrackIdGenerator(i3, Function.MAX_NARGS));
                    pesReader = new PesReader(h262Reader, this.f47664a);
                    this.f47665b.put(i3, pesReader);
                }
            }
            if (extractorInput.getPosition() > ((this.f47669f && this.f47670g) ? this.f47671h + 8192 : 1048576L)) {
                this.f47668e = true;
                this.f47673j.q();
            }
        }
        extractorInput.m(this.f47666c.e(), 0, 2);
        this.f47666c.W(0);
        int iP = this.f47666c.P() + 6;
        if (pesReader == null) {
            extractorInput.k(iP);
        } else {
            this.f47666c.S(iP);
            extractorInput.readFully(this.f47666c.e(), 0, iP);
            this.f47666c.W(6);
            pesReader.a(this.f47666c);
            ParsableByteArray parsableByteArray = this.f47666c;
            parsableByteArray.V(parsableByteArray.b());
        }
        return 0;
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.f47664a = timestampAdjuster;
        this.f47666c = new ParsableByteArray(4096);
        this.f47665b = new SparseArray();
        this.f47667d = new PsDurationReader();
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
