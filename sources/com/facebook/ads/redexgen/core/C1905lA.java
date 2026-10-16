package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.SparseArray;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1905lA implements H9 {
    public static String[] A0B = {"UBvRkgXOGDkhiRviOullp8V", "VkNaXMTzU8N2w", "EmncOItxREzVuvRcJiesLUTUZ", "GKNHQwhZeE13dvoU8lLSXwuEJRZ0Rb8T", "UfDFEQBLtd8kFCM7fNQpR1e2paOBi7mP", "RVi2VPuM0SECIbGMRSZvlBLvqxfM7S", "lPCpjqdMUX8JsRnbL9v7kcIYKByBL6xe", "JprIbG5eTccKgwX6h6kDKt0luN"};
    public static final HD A0C = new HD() { // from class: com.facebook.ads.redexgen.X.lB
        @Override // com.facebook.ads.redexgen.core.HD
        public final H9[] A5N() {
            return C1905lA.A01();
        }

        @Override // com.facebook.ads.redexgen.core.HD
        public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
            return HC.A01(this, uri, map);
        }
    };
    public long A00;
    public HA A01;
    public C1907lC A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final SparseArray<L7> A07;
    public final C04554v A08;
    public final AnonymousClass53 A09;
    public final L6 A0A;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b1  */
    @Override // com.facebook.ads.redexgen.core.H9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int AHL(com.facebook.ads.redexgen.core.InterfaceC1999ms r12, com.facebook.ads.redexgen.core.HV r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1905lA.AHL(com.facebook.ads.redexgen.X.ms, com.facebook.ads.redexgen.X.HV):int");
    }

    public C1905lA() {
        this(new AnonymousClass53(0L));
    }

    public C1905lA(AnonymousClass53 anonymousClass53) {
        this.A09 = anonymousClass53;
        this.A08 = new C04554v(4096);
        this.A07 = new SparseArray<>();
        this.A0A = new L6();
    }

    @RequiresNonNull({"output"})
    private void A00(long j3) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A0A.A0C() != -9223372036854775807L) {
                this.A02 = new C1907lC(this.A0A.A0D(), this.A0A.A0C(), j3);
                this.A01.AJ7(this.A02.A07());
            } else {
                this.A01.AJ7(new C1994mn(this.A0A.A0C()));
            }
        }
    }

    public static /* synthetic */ H9[] A01() {
        return new H9[]{new C1905lA()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A01 = ha;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j3, long j4) {
        boolean z2 = false;
        boolean resetTimestampAdjuster = this.A09.A04() == -9223372036854775807L;
        if (!resetTimestampAdjuster) {
            long jA02 = this.A09.A02();
            if (jA02 != -9223372036854775807L && jA02 != 0 && jA02 != j4) {
                z2 = true;
            }
            resetTimestampAdjuster = z2;
        }
        if (resetTimestampAdjuster) {
            this.A09.A07(j4);
        }
        if (this.A02 != null) {
            this.A02.A08(j4);
        }
        for (int i3 = 0; i3 < this.A07.size(); i3++) {
            this.A07.valueAt(i3).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1999ms interfaceC1999ms) throws IOException {
        byte[] bArr = new byte[14];
        interfaceC1999ms.AGt(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        byte b3 = bArr[13];
        if (A0B[3].charAt(12) == 'n') {
            throw new RuntimeException();
        }
        A0B[2] = "VV5ZPjEmtEUa5x1ycfEwWXr";
        int packStuffingLength = b3 & 7;
        interfaceC1999ms.A47(packStuffingLength);
        interfaceC1999ms.AGt(bArr, 0, 3);
        int packStuffingLength2 = bArr[0];
        int i3 = (packStuffingLength2 & 255) << 16;
        int packStuffingLength3 = bArr[1];
        int i4 = i3 | ((packStuffingLength3 & 255) << 8);
        int packStuffingLength4 = bArr[2];
        return 1 == ((packStuffingLength4 & 255) | i4);
    }
}
