package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class OggExtractor implements Extractor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExtractorsFactory f46885d = new ExtractorsFactory() { // from class: androidx.media3.extractor.ogg.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return OggExtractor.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExtractorOutput f46886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StreamReader f46887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f46888c;

    public static /* synthetic */ Extractor[] b() {
        return new Extractor[]{new OggExtractor()};
    }

    private static ParsableByteArray d(ParsableByteArray parsableByteArray) {
        parsableByteArray.W(0);
        return parsableByteArray;
    }

    private boolean e(ExtractorInput extractorInput) {
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.a(extractorInput, true) && (oggPageHeader.f46895b & 2) == 2) {
            int iMin = Math.min(oggPageHeader.f46902i, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(iMin);
            extractorInput.m(parsableByteArray.e(), 0, iMin);
            if (FlacReader.p(d(parsableByteArray))) {
                this.f46887b = new FlacReader();
            } else if (VorbisReader.r(d(parsableByteArray))) {
                this.f46887b = new VorbisReader();
            } else if (OpusReader.o(d(parsableByteArray))) {
                this.f46887b = new OpusReader();
            }
            return true;
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        StreamReader streamReader = this.f46887b;
        if (streamReader != null) {
            streamReader.m(j3, j4);
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        try {
            return e(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46886a = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        Assertions.i(this.f46886a);
        if (this.f46887b == null) {
            if (!e(extractorInput)) {
                throw ParserException.a("Failed to determine bitstream type", null);
            }
            extractorInput.f();
        }
        if (!this.f46888c) {
            TrackOutput trackOutputD = this.f46886a.d(0, 1);
            this.f46886a.q();
            this.f46887b.d(this.f46886a, trackOutputD);
            this.f46888c = true;
        }
        return this.f46887b.g(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
