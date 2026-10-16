package androidx.media3.extractor;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SingleSampleExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f46218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f46220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ExtractorOutput f46223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TrackOutput f46224g;

    public SingleSampleExtractor(int i3, int i4, String str) {
        this.f46218a = i3;
        this.f46219b = i4;
        this.f46220c = str;
    }

    private void b(String str) {
        TrackOutput trackOutputD = this.f46223f.d(1024, 4);
        this.f46224g = trackOutputD;
        trackOutputD.c(new Format.Builder().U(str).u0(str).N());
        this.f46223f.q();
        this.f46223f.n(new SingleSampleSeekMap(-9223372036854775807L));
        this.f46222e = 1;
    }

    private void d(ExtractorInput extractorInput) {
        int iD = ((TrackOutput) Assertions.e(this.f46224g)).d(extractorInput, 1024, true);
        if (iD != -1) {
            this.f46221d += iD;
            return;
        }
        this.f46222e = 2;
        this.f46224g.g(0L, 1, this.f46221d, 0, null);
        this.f46221d = 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        if (j3 == 0 || this.f46222e == 1) {
            this.f46222e = 1;
            this.f46221d = 0;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        Assertions.g((this.f46218a == -1 || this.f46219b == -1) ? false : true);
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f46219b);
        extractorInput.m(parsableByteArray.e(), 0, this.f46219b);
        return parsableByteArray.P() == this.f46218a;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46223f = extractorOutput;
        b(this.f46220c);
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i3 = this.f46222e;
        if (i3 == 1) {
            d(extractorInput);
            return 0;
        }
        if (i3 == 2) {
            return -1;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
