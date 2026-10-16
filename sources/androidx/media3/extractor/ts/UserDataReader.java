package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class UserDataReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f47748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f47749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TrackOutput[] f47750c;

    public UserDataReader(List list, String str) {
        this.f47748a = list;
        this.f47749b = str;
        this.f47750c = new TrackOutput[list.size()];
    }

    public void a(long j3, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 9) {
            return;
        }
        int iQ = parsableByteArray.q();
        int iQ2 = parsableByteArray.q();
        int iH = parsableByteArray.H();
        if (iQ == 434 && iQ2 == 1195456820 && iH == 3) {
            CeaUtil.b(j3, parsableByteArray, this.f47750c);
        }
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i3 = 0; i3 < this.f47750c.length; i3++) {
            trackIdGenerator.a();
            TrackOutput trackOutputD = extractorOutput.d(trackIdGenerator.c(), 3);
            Format format = (Format) this.f47748a.get(i3);
            String str = format.f40632o;
            Assertions.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption MIME type provided: " + str);
            trackOutputD.c(new Format.Builder().f0(trackIdGenerator.b()).U(this.f47749b).u0(str).w0(format.f40622e).j0(format.f40621d).O(format.J).g0(format.f40635r).N());
            this.f47750c[i3] = trackOutputD;
        }
    }
}
