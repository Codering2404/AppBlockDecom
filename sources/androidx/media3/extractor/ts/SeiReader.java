package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.ReorderingSeiMessageQueue;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SeiReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f47689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f47690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TrackOutput[] f47691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReorderingSeiMessageQueue f47692d = new ReorderingSeiMessageQueue(new ReorderingSeiMessageQueue.SeiConsumer() { // from class: androidx.media3.extractor.ts.e
        @Override // androidx.media3.container.ReorderingSeiMessageQueue.SeiConsumer
        public final void a(long j3, ParsableByteArray parsableByteArray) {
            CeaUtil.a(j3, parsableByteArray, this.f47751a.f47691c);
        }
    });

    public SeiReader(List list, String str) {
        this.f47689a = list;
        this.f47690b = str;
        this.f47691c = new TrackOutput[list.size()];
    }

    public void b() {
        this.f47692d.d();
    }

    public void c(long j3, ParsableByteArray parsableByteArray) {
        this.f47692d.a(j3, parsableByteArray);
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i3 = 0; i3 < this.f47691c.length; i3++) {
            trackIdGenerator.a();
            TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 3);
            Format format = (Format) this.f47689a.get(i3);
            String str = format.f40632o;
            Assertions.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: " + str);
            String strB = format.f40618a;
            if (strB == null) {
                strB = trackIdGenerator.b();
            }
            trackOutputD.c(new Format.Builder().f0(strB).U(this.f47690b).u0(str).w0(format.f40622e).j0(format.f40621d).O(format.J).g0(format.f40635r).N());
            this.f47691c[i3] = trackOutputD;
        }
    }

    public void e() {
        this.f47692d.d();
    }

    public void f(int i3) {
        this.f47692d.g(i3);
    }
}
