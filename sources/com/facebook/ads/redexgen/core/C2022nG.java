package com.facebook.ads.redexgen.core;

import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2022nG extends AbstractC0682Eh<C2022nG> implements Comparable<C2022nG> {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A01(List<C2022nG> list, List<C2022nG> list2) {
        return list.get(0).compareTo(list2.get(0));
    }

    public C2022nG(int i3, C2171pg c2171pg, int i4, C05669i c05669i, int i5, String str) {
        List<String> listA03;
        super(i3, c2171pg, i4);
        int i6 = 0;
        this.A08 = C05659h.A0S(i5, false);
        int i7 = super.A02.A0H & (~((C2167pc) c05669i).A00);
        this.A06 = (i7 & 1) != 0;
        this.A07 = (i7 & 2) != 0;
        int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int bestLanguageScore = 0;
        if (c05669i.A0K.isEmpty()) {
            listA03 = MetaExoPlayerCustomizedCollections.A03("");
        } else {
            listA03 = c05669i.A0K;
        }
        int bestLanguageIndex = 0;
        while (true) {
            if (bestLanguageIndex >= listA03.size()) {
                break;
            }
            int iA02 = C05659h.A02(super.A02, listA03.get(bestLanguageIndex), c05669i.A0P);
            if (iA02 > 0) {
                i8 = bestLanguageIndex;
                bestLanguageScore = iA02;
                break;
            }
            bestLanguageIndex++;
        }
        this.A00 = i8;
        this.A01 = bestLanguageScore;
        this.A02 = C05659h.A00(super.A02.A0E, ((C2167pc) c05669i).A0C);
        this.A05 = (super.A02.A0E & 1088) != 0;
        this.A03 = C05659h.A02(super.A02, str, C05659h.A0K(str) == null);
        boolean z2 = this.A01 > 0 || (c05669i.A0K.isEmpty() && this.A02 > 0) || this.A06 || (this.A07 && this.A03 > 0);
        if (C05659h.A0S(i5, c05669i.A0B) && z2) {
            i6 = 1;
        }
        this.A04 = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C2022nG c2022nG) {
        AbstractC2060ns abstractC2060nsA06 = AbstractC2060ns.A01().A09(this.A08, c2022nG.A08).A08(Integer.valueOf(this.A00), Integer.valueOf(c2022nG.A00), AbstractC2210qK.A03().A06()).A06(this.A01, c2022nG.A01).A06(this.A02, c2022nG.A02).A09(this.A06, c2022nG.A06).A08(Boolean.valueOf(this.A07), Boolean.valueOf(c2022nG.A07), this.A01 == 0 ? AbstractC2210qK.A03() : AbstractC2210qK.A03().A06()).A06(this.A03, c2022nG.A03);
        if (this.A02 == 0) {
            abstractC2060nsA06 = abstractC2060nsA06.A0A(this.A05, c2022nG.A05);
        }
        return abstractC2060nsA06.A05();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<com.facebook.ads.androidx.media3.exoplayer.trackselection.DefaultTrackSelector$TextTrackInfo> */
    public static BP<C2022nG> A02(int i3, C2171pg c2171pg, C05669i c05669i, int[] iArr, String str) {
        C2K c2kA01 = BP.A01();
        for (int i4 = 0; i4 < c2171pg.A01; i4++) {
            c2kA01.A04(new C2022nG(i3, c2171pg, i4, c05669i, iArr[i4], str));
        }
        return c2kA01.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0682Eh
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final boolean A09(C2022nG c2022nG) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0682Eh
    public final int A08() {
        return this.A04;
    }
}
