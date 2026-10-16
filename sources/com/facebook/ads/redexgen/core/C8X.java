package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.MlltFrame;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8X implements InterfaceC1972mF {
    public final long A00;
    public final long[] A01;
    public final long[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Pair<Long, Long> A00(long j3, long[] jArr, long[] jArr2) {
        int iA0L = C5C.A0L(jArr, j3, true, true);
        long j4 = jArr[iA0L];
        long j5 = jArr2[iA0L];
        int i3 = iA0L + 1;
        if (i3 == jArr.length) {
            return Pair.create(Long.valueOf(j4), Long.valueOf(j5));
        }
        return Pair.create(Long.valueOf(j3), Long.valueOf(((long) ((jArr2[i3] - j5) * (jArr[i3] == j4 ? 0.0d : (j3 - j4) / (r4 - j4)))) + j5));
    }

    public C8X(long[] jArr, long[] jArr2, long j3) {
        this.A01 = jArr;
        this.A02 = jArr2;
        this.A00 = j3 == -9223372036854775807L ? C5C.A0O(jArr2[jArr2.length - 1]) : j3;
    }

    public static C8X A01(long j3, MlltFrame mlltFrame, long j4) {
        int length = mlltFrame.A03.length;
        int referenceCount = length + 1;
        long[] jArr = new long[referenceCount];
        int referenceCount2 = length + 1;
        long[] jArr2 = new long[referenceCount2];
        jArr[0] = j3;
        jArr2[0] = 0;
        long j5 = 0;
        for (int i3 = 1; i3 <= length; i3++) {
            int referenceCount3 = i3 - 1;
            j3 += (long) (mlltFrame.A00 + mlltFrame.A03[referenceCount3]);
            int referenceCount4 = i3 - 1;
            j5 += (long) (mlltFrame.A01 + mlltFrame.A04[referenceCount4]);
            jArr[i3] = j3;
            jArr2[i3] = j5;
        }
        return new C8X(jArr, jArr2, j4);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A7j() {
        return -1L;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        Pair<Long, Long> pairA00 = A00(C5C.A0P(C5C.A0T(j3, 0L, this.A00)), this.A02, this.A01);
        return new HX(new HZ(C5C.A0O(((Long) pairA00.first).longValue()), ((Long) pairA00.second).longValue()));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A9H(long j3) {
        Pair<Long, Long> positionAndTimeMs = A00(j3, this.A01, this.A02);
        return C5C.A0O(((Long) positionAndTimeMs.second).longValue());
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}
