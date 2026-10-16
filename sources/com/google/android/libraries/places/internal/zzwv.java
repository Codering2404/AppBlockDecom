package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzwv extends zzwz {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzwz f78784b = new zzwv();

    private zzwv() {
    }

    @Override // com.google.android.libraries.places.internal.zzwz
    public final int c(zzww zzwwVar, int i3, String str, int i4, int i5, int i6) {
        zzwr zzwrVarE;
        char cCharAt = str.charAt(i6);
        zzuk zzukVarB = zzuk.b(str, i5, i6, (cCharAt & ' ') == 0);
        zzuj zzujVarA = zzuj.a(cCharAt);
        int i7 = i6 + 1;
        if (zzujVarA != null) {
            if (!zzukVarB.i(zzujVarA)) {
                throw zzwy.a("invalid format specifier", str, i4, i7);
            }
            zzwrVarE = zzwt.e(i3, zzujVarA, zzukVarB);
        } else if (cCharAt == 't' || cCharAt == 'T') {
            if (!zzukVarB.h(160, false)) {
                throw zzwy.a("invalid format specification", str, i4, i7);
            }
            int i8 = i6 + 2;
            if (i8 > str.length()) {
                throw zzwy.b("truncated format specifier", str, i4);
            }
            zzwp zzwpVarA = zzwp.a(str.charAt(i7));
            if (zzwpVarA == null) {
                throw zzwy.b("illegal date/time conversion", str, i7);
            }
            zzwrVarE = zzwq.e(zzwpVarA, zzukVarB, i3);
            i7 = i8;
        } else {
            if (cCharAt != 'h' && cCharAt != 'H') {
                throw zzwy.a("invalid format specification", str, i4, i7);
            }
            if (!zzukVarB.h(160, false)) {
                throw zzwy.a("invalid format specification", str, i4, i7);
            }
            zzwrVarE = new zzwu(zzukVarB, i3, zzukVarB);
        }
        zzwwVar.h(i4, i7, zzwrVarE);
        return i7;
    }
}
