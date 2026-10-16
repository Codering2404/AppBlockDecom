package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ts.TsPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac3Extractor implements Extractor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExtractorsFactory f47331d = new ExtractorsFactory() { // from class: androidx.media3.extractor.ts.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return Ac3Extractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ac3Reader f47332a = new Ac3Reader("audio/ac3");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47333b = new ParsableByteArray(2786);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f47334c;

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new Ac3Extractor()};
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f47334c = false;
        this.f47332a.c();
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i3 = 0;
        while (true) {
            extractorInput.m(parsableByteArray.e(), 0, 10);
            parsableByteArray.W(0);
            if (parsableByteArray.K() != 4801587) {
                break;
            }
            parsableByteArray.X(3);
            int iG = parsableByteArray.G();
            i3 += iG + 10;
            extractorInput.i(iG);
        }
        extractorInput.f();
        extractorInput.i(i3);
        int i4 = 0;
        int i5 = i3;
        while (true) {
            extractorInput.m(parsableByteArray.e(), 0, 6);
            parsableByteArray.W(0);
            if (parsableByteArray.P() != 2935) {
                extractorInput.f();
                i5++;
                if (i5 - i3 >= 8192) {
                    return false;
                }
                extractorInput.i(i5);
                i4 = 0;
            } else {
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                int iG2 = Ac3Util.g(parsableByteArray.e());
                if (iG2 == -1) {
                    return false;
                }
                extractorInput.i(iG2 - 6);
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f47332a.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.q();
        extractorOutput.n(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i3 = extractorInput.read(this.f47333b.e(), 0, 2786);
        if (i3 == -1) {
            return -1;
        }
        this.f47333b.W(0);
        this.f47333b.V(i3);
        if (!this.f47334c) {
            this.f47332a.f(0L, 4);
            this.f47334c = true;
        }
        this.f47332a.a(this.f47333b);
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
