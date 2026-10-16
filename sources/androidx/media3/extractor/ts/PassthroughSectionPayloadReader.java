package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PassthroughSectionPayloadReader implements SectionPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Format f47638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TimestampAdjuster f47639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TrackOutput f47640c;

    public PassthroughSectionPayloadReader(String str, String str2) {
        this.f47638a = new Format.Builder().U(str2).u0(str).N();
    }

    private void c() {
        Assertions.i(this.f47639b);
        Util.k(this.f47640c);
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void a(ParsableByteArray parsableByteArray) {
        c();
        long jE = this.f47639b.e();
        long jF = this.f47639b.f();
        if (jE == -9223372036854775807L || jF == -9223372036854775807L) {
            return;
        }
        Format format = this.f47638a;
        if (jF != format.f40637t) {
            Format formatN = format.b().y0(jF).N();
            this.f47638a = formatN;
            this.f47640c.c(formatN);
        }
        int iA = parsableByteArray.a();
        this.f47640c.b(parsableByteArray, iA);
        this.f47640c.g(jE, 1, iA, 0, null);
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f47639b = timestampAdjuster;
        trackIdGenerator.a();
        TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 5);
        this.f47640c = trackOutputD;
        trackOutputD.c(this.f47638a);
    }
}
