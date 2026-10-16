package androidx.media3.extractor.ts;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AdtsExtractor implements Extractor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ExtractorsFactory f47368m = new ExtractorsFactory() { // from class: androidx.media3.extractor.ts.c
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return AdtsExtractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f47369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdtsReader f47370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f47371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ParsableByteArray f47372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ParsableBitArray f47373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ExtractorOutput f47374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f47376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f47380l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AdtsExtractor() {
        this(0);
    }

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new AdtsExtractor()};
    }

    private void d(ExtractorInput extractorInput) throws ParserException {
        int iH;
        if (this.f47378j) {
            return;
        }
        this.f47377i = -1;
        extractorInput.f();
        long j3 = 0;
        if (extractorInput.getPosition() == 0) {
            l(extractorInput);
        }
        int i3 = 0;
        int i4 = 0;
        do {
            try {
                if (!extractorInput.d(this.f47372d.e(), 0, 2, true)) {
                    break;
                }
                this.f47372d.W(0);
                if (!AdtsReader.m(this.f47372d.P())) {
                    break;
                }
                if (!extractorInput.d(this.f47372d.e(), 0, 4, true)) {
                    break;
                }
                this.f47373e.p(14);
                iH = this.f47373e.h(13);
                if (iH <= 6) {
                    this.f47378j = true;
                    throw ParserException.a("Malformed ADTS stream", null);
                }
                j3 += (long) iH;
                i4++;
                if (i4 == 1000) {
                    break;
                }
            } catch (EOFException unused) {
            }
        } while (extractorInput.l(iH - 6, true));
        i3 = i4;
        extractorInput.f();
        if (i3 > 0) {
            this.f47377i = (int) (j3 / ((long) i3));
        } else {
            this.f47377i = -1;
        }
        this.f47378j = true;
    }

    private static int e(int i3, long j3) {
        return (int) ((((long) i3) * 8000000) / j3);
    }

    private SeekMap f(long j3, boolean z2) {
        return new ConstantBitrateSeekMap(j3, this.f47376h, e(this.f47377i, this.f47370b.k()), this.f47377i, z2);
    }

    private void k(long j3, boolean z2) {
        if (this.f47380l) {
            return;
        }
        boolean z3 = (this.f47369a & 1) != 0 && this.f47377i > 0;
        if (z3 && this.f47370b.k() == -9223372036854775807L && !z2) {
            return;
        }
        if (!z3 || this.f47370b.k() == -9223372036854775807L) {
            this.f47374f.n(new SeekMap.Unseekable(-9223372036854775807L));
        } else {
            this.f47374f.n(f(j3, (this.f47369a & 2) != 0));
        }
        this.f47380l = true;
    }

    private int l(ExtractorInput extractorInput) {
        int i3 = 0;
        while (true) {
            extractorInput.m(this.f47372d.e(), 0, 10);
            this.f47372d.W(0);
            if (this.f47372d.K() != 4801587) {
                break;
            }
            this.f47372d.X(3);
            int iG = this.f47372d.G();
            i3 += iG + 10;
            extractorInput.i(iG);
        }
        extractorInput.f();
        extractorInput.i(i3);
        if (this.f47376h == -1) {
            this.f47376h = i3;
        }
        return i3;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f47379k = false;
        this.f47370b.c();
        this.f47375g = j4;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        int iL = l(extractorInput);
        int i3 = iL;
        int i4 = 0;
        int i5 = 0;
        do {
            extractorInput.m(this.f47372d.e(), 0, 2);
            this.f47372d.W(0);
            if (AdtsReader.m(this.f47372d.P())) {
                i4++;
                if (i4 >= 4 && i5 > 188) {
                    return true;
                }
                extractorInput.m(this.f47372d.e(), 0, 4);
                this.f47373e.p(14);
                int iH = this.f47373e.h(13);
                if (iH <= 6) {
                    i3++;
                    extractorInput.f();
                    extractorInput.i(i3);
                } else {
                    extractorInput.i(iH - 6);
                    i5 += iH;
                }
            } else {
                i3++;
                extractorInput.f();
                extractorInput.i(i3);
            }
            i4 = 0;
            i5 = 0;
        } while (i3 - iL < 8192);
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f47374f = extractorOutput;
        this.f47370b.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.q();
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        Assertions.i(this.f47374f);
        long length = extractorInput.getLength();
        int i3 = this.f47369a;
        if ((i3 & 2) != 0 || ((i3 & 1) != 0 && length != -1)) {
            d(extractorInput);
        }
        int i4 = extractorInput.read(this.f47371c.e(), 0, 2048);
        boolean z2 = i4 == -1;
        k(length, z2);
        if (z2) {
            return -1;
        }
        this.f47371c.W(0);
        this.f47371c.V(i4);
        if (!this.f47379k) {
            this.f47370b.f(this.f47375g, 4);
            this.f47379k = true;
        }
        this.f47370b.a(this.f47371c);
        return 0;
    }

    public AdtsExtractor(int i3) {
        this.f47369a = (i3 & 2) != 0 ? i3 | 1 : i3;
        this.f47370b = new AdtsReader(true, "audio/mp4a-latm");
        this.f47371c = new ParsableByteArray(2048);
        this.f47377i = -1;
        this.f47376h = -1L;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.f47372d = parsableByteArray;
        this.f47373e = new ParsableBitArray(parsableByteArray.e());
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
