package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Id3Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f47560a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TrackOutput f47562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f47563d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f47566g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47561b = new ParsableByteArray(10);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f47564e = -9223372036854775807L;

    public Id3Reader(String str) {
        this.f47560a = str;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        Assertions.i(this.f47562c);
        if (this.f47563d) {
            int iA = parsableByteArray.a();
            int i3 = this.f47566g;
            if (i3 < 10) {
                int iMin = Math.min(iA, 10 - i3);
                System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), this.f47561b.e(), this.f47566g, iMin);
                if (this.f47566g + iMin == 10) {
                    this.f47561b.W(0);
                    if (73 != this.f47561b.H() || 68 != this.f47561b.H() || 51 != this.f47561b.H()) {
                        Log.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.f47563d = false;
                        return;
                    } else {
                        this.f47561b.X(3);
                        this.f47565f = this.f47561b.G() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f47565f - this.f47566g);
            this.f47562c.b(parsableByteArray, iMin2);
            this.f47566g += iMin2;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47563d = false;
        this.f47564e = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
        int i3;
        Assertions.i(this.f47562c);
        if (this.f47563d && (i3 = this.f47565f) != 0 && this.f47566g == i3) {
            Assertions.g(this.f47564e != -9223372036854775807L);
            this.f47562c.g(this.f47564e, 1, this.f47565f, 0, null);
            this.f47563d = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f47562c = trackOutputD;
        trackOutputD.c(new Format.Builder().f0(trackIdGenerator.b()).U(this.f47560a).u0("application/id3").N());
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        if ((i3 & 4) == 0) {
            return;
        }
        this.f47563d = true;
        this.f47564e = j3;
        this.f47565f = 0;
        this.f47566g = 0;
    }
}
