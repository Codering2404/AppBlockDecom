package androidx.media3.extractor.flac;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacExtractor implements Extractor {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ExtractorsFactory f46338o = new ExtractorsFactory() { // from class: androidx.media3.extractor.flac.b
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return FlacExtractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f46340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f46341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FlacFrameReader.SampleNumberHolder f46342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExtractorOutput f46343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TrackOutput f46344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Metadata f46346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FlacStreamMetadata f46347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f46349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private FlacBinarySearchSeeker f46350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f46351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f46352n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new FlacExtractor()};
    }

    private long d(ParsableByteArray parsableByteArray, boolean z2) {
        boolean zD;
        Assertions.e(this.f46347i);
        int iF = parsableByteArray.f();
        while (iF <= parsableByteArray.g() - 16) {
            parsableByteArray.W(iF);
            if (FlacFrameReader.d(parsableByteArray, this.f46347i, this.f46349k, this.f46342d)) {
                parsableByteArray.W(iF);
                return this.f46342d.f46151a;
            }
            iF++;
        }
        if (!z2) {
            parsableByteArray.W(iF);
            return -1L;
        }
        while (iF <= parsableByteArray.g() - this.f46348j) {
            parsableByteArray.W(iF);
            try {
                zD = FlacFrameReader.d(parsableByteArray, this.f46347i, this.f46349k, this.f46342d);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (parsableByteArray.f() <= parsableByteArray.g() ? zD : false) {
                parsableByteArray.W(iF);
                return this.f46342d.f46151a;
            }
            iF++;
        }
        parsableByteArray.W(parsableByteArray.g());
        return -1L;
    }

    private void e(ExtractorInput extractorInput) {
        this.f46349k = FlacMetadataReader.b(extractorInput);
        ((ExtractorOutput) Util.k(this.f46343e)).n(f(extractorInput.getPosition(), extractorInput.getLength()));
        this.f46345g = 5;
    }

    private SeekMap f(long j3, long j4) {
        Assertions.e(this.f46347i);
        FlacStreamMetadata flacStreamMetadata = this.f46347i;
        if (flacStreamMetadata.f46165k != null) {
            return new FlacSeekTableSeekMap(flacStreamMetadata, j3);
        }
        if (j4 == -1 || flacStreamMetadata.f46164j <= 0) {
            return new SeekMap.Unseekable(flacStreamMetadata.f());
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata, this.f46349k, j3, j4);
        this.f46350l = flacBinarySearchSeeker;
        return flacBinarySearchSeeker.b();
    }

    private void k(ExtractorInput extractorInput) {
        byte[] bArr = this.f46339a;
        extractorInput.m(bArr, 0, bArr.length);
        extractorInput.f();
        this.f46345g = 2;
    }

    private void l() {
        ((TrackOutput) Util.k(this.f46344f)).g((this.f46352n * 1000000) / ((long) ((FlacStreamMetadata) Util.k(this.f46347i)).f46159e), 1, this.f46351m, 0, null);
    }

    private int m(ExtractorInput extractorInput, PositionHolder positionHolder) {
        boolean z2;
        Assertions.e(this.f46344f);
        Assertions.e(this.f46347i);
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.f46350l;
        if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.d()) {
            return this.f46350l.c(extractorInput, positionHolder);
        }
        if (this.f46352n == -1) {
            this.f46352n = FlacFrameReader.i(extractorInput, this.f46347i);
            return 0;
        }
        int iG = this.f46340b.g();
        if (iG < 32768) {
            int i3 = extractorInput.read(this.f46340b.e(), iG, 32768 - iG);
            z2 = i3 == -1;
            if (!z2) {
                this.f46340b.V(iG + i3);
            } else if (this.f46340b.a() == 0) {
                l();
                return -1;
            }
        } else {
            z2 = false;
        }
        int iF = this.f46340b.f();
        int i4 = this.f46351m;
        int i5 = this.f46348j;
        if (i4 < i5) {
            ParsableByteArray parsableByteArray = this.f46340b;
            parsableByteArray.X(Math.min(i5 - i4, parsableByteArray.a()));
        }
        long jD = d(this.f46340b, z2);
        int iF2 = this.f46340b.f() - iF;
        this.f46340b.W(iF);
        this.f46344f.b(this.f46340b, iF2);
        this.f46351m += iF2;
        if (jD != -1) {
            l();
            this.f46351m = 0;
            this.f46352n = jD;
        }
        int length = this.f46340b.e().length - this.f46340b.g();
        if (this.f46340b.a() < 16 && length < 16) {
            int iA = this.f46340b.a();
            System.arraycopy(this.f46340b.e(), this.f46340b.f(), this.f46340b.e(), 0, iA);
            this.f46340b.W(0);
            this.f46340b.V(iA);
        }
        return 0;
    }

    private void n(ExtractorInput extractorInput) {
        this.f46346h = FlacMetadataReader.d(extractorInput, !this.f46341c);
        this.f46345g = 1;
    }

    private void o(ExtractorInput extractorInput) {
        FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.f46347i);
        boolean zE = false;
        while (!zE) {
            zE = FlacMetadataReader.e(extractorInput, flacStreamMetadataHolder);
            this.f46347i = (FlacStreamMetadata) Util.k(flacStreamMetadataHolder.f46152a);
        }
        Assertions.e(this.f46347i);
        this.f46348j = Math.max(this.f46347i.f46157c, 6);
        ((TrackOutput) Util.k(this.f46344f)).c(this.f46347i.g(this.f46339a, this.f46346h).b().U("audio/flac").N());
        ((TrackOutput) Util.k(this.f46344f)).e(this.f46347i.f());
        this.f46345g = 4;
    }

    private void p(ExtractorInput extractorInput) throws ParserException {
        FlacMetadataReader.i(extractorInput);
        this.f46345g = 3;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        if (j3 == 0) {
            this.f46345g = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.f46350l;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.h(j4);
            }
        }
        this.f46352n = j4 != 0 ? -1L : 0L;
        this.f46351m = 0;
        this.f46340b.S(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) throws Throwable {
        FlacMetadataReader.c(extractorInput, false);
        return FlacMetadataReader.a(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46343e = extractorOutput;
        this.f46344f = extractorOutput.d(0, 1);
        extractorOutput.q();
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        int i3 = this.f46345g;
        if (i3 == 0) {
            n(extractorInput);
            return 0;
        }
        if (i3 == 1) {
            k(extractorInput);
            return 0;
        }
        if (i3 == 2) {
            p(extractorInput);
            return 0;
        }
        if (i3 == 3) {
            o(extractorInput);
            return 0;
        }
        if (i3 == 4) {
            e(extractorInput);
            return 0;
        }
        if (i3 == 5) {
            return m(extractorInput, positionHolder);
        }
        throw new IllegalStateException();
    }

    public FlacExtractor(int i3) {
        this.f46339a = new byte[42];
        this.f46340b = new ParsableByteArray(new byte[32768], 0);
        this.f46341c = (i3 & 1) != 0;
        this.f46342d = new FlacFrameReader.SampleNumberHolder();
        this.f46345g = 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
