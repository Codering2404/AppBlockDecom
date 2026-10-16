package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ts.TsPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac4Extractor implements Extractor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExtractorsFactory f47349d = new ExtractorsFactory() { // from class: androidx.media3.extractor.ts.b
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return Ac4Extractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ac4Reader f47350a = new Ac4Reader("audio/ac4");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47351b = new ParsableByteArray(16384);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f47352c;

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new Ac4Extractor()};
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f47352c = false;
        this.f47350a.c();
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
            extractorInput.m(parsableByteArray.e(), 0, 7);
            parsableByteArray.W(0);
            int iP = parsableByteArray.P();
            if (iP == 44096 || iP == 44097) {
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                int iG2 = Ac4Util.g(parsableByteArray.e(), iP);
                if (iG2 == -1) {
                    return false;
                }
                extractorInput.i(iG2 - 7);
            } else {
                extractorInput.f();
                i5++;
                if (i5 - i3 >= 8192) {
                    return false;
                }
                extractorInput.i(i5);
                i4 = 0;
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f47350a.e(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.q();
        extractorOutput.n(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i3 = extractorInput.read(this.f47351b.e(), 0, 16384);
        if (i3 == -1) {
            return -1;
        }
        this.f47351b.W(0);
        this.f47351b.V(i3);
        if (!this.f47352c) {
            this.f47350a.f(0L, 4);
            this.f47352c = true;
        }
        this.f47350a.a(this.f47351b);
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
