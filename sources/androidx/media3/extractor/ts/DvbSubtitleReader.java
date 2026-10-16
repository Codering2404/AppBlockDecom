package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DvbSubtitleReader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f47424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f47425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TrackOutput[] f47426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f47427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f47428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47430g = -9223372036854775807L;

    public DvbSubtitleReader(List list, String str) {
        this.f47424a = list;
        this.f47425b = str;
        this.f47426c = new TrackOutput[list.size()];
    }

    private boolean b(ParsableByteArray parsableByteArray, int i3) {
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (parsableByteArray.H() != i3) {
            this.f47427d = false;
        }
        this.f47428e--;
        return this.f47427d;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void a(ParsableByteArray parsableByteArray) {
        if (this.f47427d) {
            if (this.f47428e != 2 || b(parsableByteArray, 32)) {
                if (this.f47428e != 1 || b(parsableByteArray, 0)) {
                    int iF = parsableByteArray.f();
                    int iA = parsableByteArray.a();
                    for (TrackOutput trackOutput : this.f47426c) {
                        parsableByteArray.W(iF);
                        trackOutput.b(parsableByteArray, iA);
                    }
                    this.f47429f += iA;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void c() {
        this.f47427d = false;
        this.f47430g = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void d(boolean z2) {
        if (this.f47427d) {
            Assertions.g(this.f47430g != -9223372036854775807L);
            for (TrackOutput trackOutput : this.f47426c) {
                trackOutput.g(this.f47430g, 1, this.f47429f, 0, null);
            }
            this.f47427d = false;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i3 = 0; i3 < this.f47426c.length; i3++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = (TsPayloadReader.DvbSubtitleInfo) this.f47424a.get(i3);
            trackIdGenerator.a();
            TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 3);
            trackOutputD.c(new Format.Builder().f0(trackIdGenerator.b()).U(this.f47425b).u0("application/dvbsubs").g0(Collections.singletonList(dvbSubtitleInfo.f47737c)).j0(dvbSubtitleInfo.f47735a).N());
            this.f47426c[i3] = trackOutputD;
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void f(long j3, int i3) {
        if ((i3 & 4) == 0) {
            return;
        }
        this.f47427d = true;
        this.f47430g = j3;
        this.f47429f = 0;
        this.f47428e = 2;
    }
}
