package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class OggPageHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f46896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f46897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f46898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f46899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f46901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f46902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f46903j = new int[255];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ParsableByteArray f46904k = new ParsableByteArray(255);

    OggPageHeader() {
    }

    public boolean a(ExtractorInput extractorInput, boolean z2) throws ParserException {
        b();
        this.f46904k.S(27);
        if (!ExtractorUtil.b(extractorInput, this.f46904k.e(), 0, 27, z2) || this.f46904k.J() != 1332176723) {
            return false;
        }
        int iH = this.f46904k.H();
        this.f46894a = iH;
        if (iH != 0) {
            if (z2) {
                return false;
            }
            throw ParserException.c("unsupported bit stream revision");
        }
        this.f46895b = this.f46904k.H();
        this.f46896c = this.f46904k.v();
        this.f46897d = this.f46904k.x();
        this.f46898e = this.f46904k.x();
        this.f46899f = this.f46904k.x();
        int iH2 = this.f46904k.H();
        this.f46900g = iH2;
        this.f46901h = iH2 + 27;
        this.f46904k.S(iH2);
        if (!ExtractorUtil.b(extractorInput, this.f46904k.e(), 0, this.f46900g, z2)) {
            return false;
        }
        for (int i3 = 0; i3 < this.f46900g; i3++) {
            this.f46903j[i3] = this.f46904k.H();
            this.f46902i += this.f46903j[i3];
        }
        return true;
    }

    public void b() {
        this.f46894a = 0;
        this.f46895b = 0;
        this.f46896c = 0L;
        this.f46897d = 0L;
        this.f46898e = 0L;
        this.f46899f = 0L;
        this.f46900g = 0;
        this.f46901h = 0;
        this.f46902i = 0;
    }

    public boolean c(ExtractorInput extractorInput) {
        return d(extractorInput, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.a(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(androidx.media3.extractor.ExtractorInput r9, long r10) {
        /*
            r8 = this;
            long r0 = r9.getPosition()
            long r2 = r9.h()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            androidx.media3.common.util.Assertions.a(r0)
            androidx.media3.common.util.ParsableByteArray r0 = r8.f46904k
            r3 = 4
            r0.S(r3)
        L1a:
            r4 = -1
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L2b
            long r4 = r9.getPosition()
            r6 = 4
            long r4 = r4 + r6
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 >= 0) goto L51
        L2b:
            androidx.media3.common.util.ParsableByteArray r4 = r8.f46904k
            byte[] r4 = r4.e()
            boolean r4 = androidx.media3.extractor.ExtractorUtil.b(r9, r4, r1, r3, r2)
            if (r4 == 0) goto L51
            androidx.media3.common.util.ParsableByteArray r0 = r8.f46904k
            r0.W(r1)
            androidx.media3.common.util.ParsableByteArray r0 = r8.f46904k
            long r4 = r0.J()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L4d
            r9.f()
            return r2
        L4d:
            r9.k(r2)
            goto L1a
        L51:
            if (r0 == 0) goto L5b
            long r3 = r9.getPosition()
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 >= 0) goto L63
        L5b:
            int r3 = r9.a(r2)
            r4 = -1
            if (r3 == r4) goto L63
            goto L51
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ogg.OggPageHeader.d(androidx.media3.extractor.ExtractorInput, long):boolean");
    }
}
