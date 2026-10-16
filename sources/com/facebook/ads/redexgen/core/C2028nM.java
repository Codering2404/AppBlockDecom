package com.facebook.ads.redexgen.core;

import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2028nM extends AbstractC0682Eh<C2028nM> implements Comparable<C2028nM> {
    public static String[] A0I = {"kuPF6Ds61I7lkNvdz9bcVPsTInik8V3M", "Qk0zKRkYsaxRz9XBLHG1rmY7ne3qL", "U5xl3sY91uvZaW", "4oEkNGaUX02G9U6MTdWApFSB5pjWlUNx", "CFtCC3eFdvC", "EnNVjubCw6rdwWEp5vRTdV2Ipxq1ST06", "834ujo2VifTXBI2K", "5tr2zEJniV6LNy5ijK5ku"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final C05669i A0A;
    public final String A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean A0E;
    public final boolean A0F;
    public final boolean A0G;
    public final boolean A0H;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C2028nM(int i3, C2171pg c2171pg, int i4, C05669i c05669i, int i5, boolean z2, InterfaceC1879kj<C2208qI> interfaceC1879kj) {
        super(i3, c2171pg, i4);
        this.A0A = c05669i;
        this.A0B = C05659h.A0K(super.A02.A0V);
        this.A0F = C05659h.A0S(i5, false);
        int i6 = 0;
        int i7 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i8 = 0;
        while (true) {
            if (i8 >= c05669i.A0I.size()) {
                break;
            }
            int iA02 = C05659h.A02(super.A02, c05669i.A0I.get(i8), false);
            if (iA02 > 0) {
                i7 = i8;
                i6 = iA02;
                break;
            }
            i8++;
        }
        this.A04 = i7;
        this.A05 = i6;
        this.A07 = C05659h.A00(super.A02.A0E, ((C2167pc) c05669i).A0B);
        this.A0C = super.A02.A0E == 0 || (super.A02.A0E & 1) != 0;
        this.A0D = (super.A02.A0H & 1) != 0;
        this.A01 = super.A02.A06;
        this.A08 = super.A02.A0G;
        this.A00 = super.A02.A05;
        this.A0E = (super.A02.A05 == -1 || super.A02.A05 <= ((C2167pc) c05669i).A01) && (super.A02.A06 == -1 || super.A02.A06 <= ((C2167pc) c05669i).A02) && interfaceC1879kj.A4C(super.A02);
        String[] strArrA1L = C5C.A1L();
        int i9 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= strArrA1L.length) {
                break;
            }
            int iA022 = C05659h.A02(super.A02, strArrA1L[i11], false);
            if (iA022 > 0) {
                i9 = i11;
                i10 = iA022;
                break;
            }
            i11++;
        }
        this.A02 = i9;
        this.A03 = i10;
        int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i13 = 0;
        while (true) {
            if (i13 < c05669i.A0J.size()) {
                if (super.A02.A0W != null && super.A02.A0W.equals(c05669i.A0J.get(i13))) {
                    i12 = i13;
                    break;
                }
                i13++;
            } else {
                break;
            }
        }
        this.A06 = i12;
        this.A0H = AbstractC05207i.A02(i5) == 128;
        this.A0G = AbstractC05207i.A04(i5) == 64;
        this.A09 = A00(i5, z2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A02(List<C2028nM> list, List<C2028nM> list2) {
        return ((C2028nM) Collections.max(list)).compareTo((C2028nM) Collections.max(list2));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static BP<C2028nM> A03(int i3, C2171pg c2171pg, C05669i c05669i, int[] iArr, boolean z2, InterfaceC1879kj<C2208qI> interfaceC1879kj) {
        C2K c2kA01 = BP.A01();
        for (int i4 = 0; i4 < c2171pg.A01; i4++) {
            c2kA01.A04(new C2028nM(i3, c2171pg, i4, c05669i, iArr[i4], z2, interfaceC1879kj));
        }
        return c2kA01.A05();
    }

    private int A00(int i3, boolean z2) {
        if (!C05659h.A0S(i3, this.A0A.A0B)) {
            return 0;
        }
        if (!this.A0E && !this.A0A.A09) {
            return 0;
        }
        if (C05659h.A0S(i3, false) && this.A0E && super.A02.A05 != -1 && !this.A0A.A0N && !this.A0A.A0O && (this.A0A.A04 || !z2)) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<java.lang.Integer> */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C2028nM c2028nM) {
        AbstractC2210qK abstractC2210qKA06;
        AbstractC2210qK abstractC2210qKA062 = (this.A0E && this.A0F) ? C05659h.A09 : C05659h.A09.A06();
        AbstractC2060ns abstractC2060nsA08 = AbstractC2060ns.A01().A09(this.A0F, c2028nM.A0F).A08(Integer.valueOf(this.A04), Integer.valueOf(c2028nM.A04), AbstractC2210qK.A03().A06()).A06(this.A05, c2028nM.A05).A06(this.A07, c2028nM.A07).A09(this.A0D, c2028nM.A0D).A09(this.A0C, c2028nM.A0C).A08(Integer.valueOf(this.A02), Integer.valueOf(c2028nM.A02), AbstractC2210qK.A03().A06()).A06(this.A03, c2028nM.A03).A09(this.A0E, c2028nM.A0E).A08(Integer.valueOf(this.A06), Integer.valueOf(c2028nM.A06), AbstractC2210qK.A03().A06());
        Integer numValueOf = Integer.valueOf(this.A00);
        Integer numValueOf2 = Integer.valueOf(c2028nM.A00);
        if (this.A0A.A0O) {
            abstractC2210qKA06 = C05659h.A09.A06();
        } else {
            abstractC2210qKA06 = C05659h.A0A;
        }
        AbstractC2060ns abstractC2060nsA082 = abstractC2060nsA08.A08(numValueOf, numValueOf2, abstractC2210qKA06).A09(this.A0H, c2028nM.A0H).A09(this.A0G, c2028nM.A0G).A08(Integer.valueOf(this.A01), Integer.valueOf(c2028nM.A01), abstractC2210qKA062).A08(Integer.valueOf(this.A08), Integer.valueOf(c2028nM.A08), abstractC2210qKA062);
        Integer numValueOf3 = Integer.valueOf(this.A00);
        Integer numValueOf4 = Integer.valueOf(c2028nM.A00);
        if (!C5C.A1E(this.A0B, c2028nM.A0B)) {
            abstractC2210qKA062 = C05659h.A0A;
        }
        return abstractC2060nsA082.A08(numValueOf3, numValueOf4, abstractC2210qKA062).A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    @Override // com.facebook.ads.redexgen.core.AbstractC0682Eh
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09(com.facebook.ads.redexgen.core.C2028nM r6) {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A00
            r3 = -1
            if (r0 != 0) goto L36
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r0 = r0.A06
            if (r0 == r3) goto L7a
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r4 = r0.A06
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2028nM.A0I
            r0 = 5
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 5
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7c
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2028nM.A0I
            java.lang.String r1 = "4j0Ebeo7wJOJZxGoc5hIgJQJaA3nIP6d"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "7JU6hRyIHJ6Xx4Pnq3EsCWmSiYve8JpD"
            r0 = 0
            r2[r0] = r1
            com.facebook.ads.redexgen.X.qI r0 = r6.A02
            int r0 = r0.A06
            if (r4 != r0) goto L7a
        L36:
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A02
            if (r0 != 0) goto L50
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            java.lang.String r0 = r0.A0W
            if (r0 == 0) goto L7a
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            java.lang.String r1 = r0.A0W
            com.facebook.ads.redexgen.X.qI r0 = r6.A02
            java.lang.String r0 = r0.A0W
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L7a
        L50:
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A03
            if (r0 != 0) goto L66
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r0 = r0.A0G
            if (r0 == r3) goto L7a
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r1 = r0.A0G
            com.facebook.ads.redexgen.X.qI r0 = r6.A02
            int r0 = r0.A0G
            if (r1 != r0) goto L7a
        L66:
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A01
            if (r0 != 0) goto L78
            boolean r1 = r5.A0H
            boolean r0 = r6.A0H
            if (r1 != r0) goto L7a
            boolean r1 = r5.A0G
            boolean r0 = r6.A0G
            if (r1 != r0) goto L7a
        L78:
            r0 = 1
        L79:
            return r0
        L7a:
            r0 = 0
            goto L79
        L7c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2028nM.A09(com.facebook.ads.redexgen.X.nM):boolean");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0682Eh
    public final int A08() {
        return this.A09;
    }
}
