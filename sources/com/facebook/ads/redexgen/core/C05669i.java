package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05669i extends C2167pc implements AnonymousClass24 {
    public final boolean A00;
    public final boolean A01;
    public final boolean A02;
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;

    @MetaExoPlayerCustomization("D25277746")
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final SparseArray<Map<C2038nW, C2023nH>> A0E;
    public final SparseBooleanArray A0F;
    public static String[] A0G = {"aGn7PxmzFVI8pseTQREUgmPTmRn3c3Qe", "IWvjCaXZ0UNcR9QsrMbq4cwMoqcNO01w", "zzFjDnJDYUSk81dZD4bwc1a4UEkJCW7c", "AfyHMFnboWczrAj6gDYBkfictlCviIiz", "ZudaxJy5LTgucmpkRl3p1l6eoKWNEQ3P", "dJwbxLQye6WGEEeA8Aa4EZe7IW3A7RwI", "l9ypC7Hglf3jtTkN6zxYkfXofkc9mvwo", "bL7rVgPoAdAWEHuIi5lDma"};
    public static final C05669i A0J = new C2026nK().A0p();

    @Deprecated
    public static final C05669i A0I = A0J;
    public static final String A0W = C5C.A0h(1000);
    public static final String A0Q = C5C.A0h(AdError.NO_FILL_ERROR_CODE);
    public static final String A0R = C5C.A0h(1002);
    public static final String A0T = C5C.A0h(1003);
    public static final String A0M = C5C.A0h(1004);
    public static final String A0N = C5C.A0h(1005);
    public static final String A0K = C5C.A0h(CloseCodes.CLOSED_ABNORMALLY);
    public static final String A0V = C5C.A0h(1007);
    public static final String A0b = C5C.A0h(1008);
    public static final String A0O = C5C.A0h(1009);
    public static final String A0Z = C5C.A0h(1010);
    public static final String A0a = C5C.A0h(CloseCodes.UNEXPECTED_CONDITION);
    public static final String A0Y = C5C.A0h(1012);
    public static final String A0X = C5C.A0h(1013);
    public static final String A0P = C5C.A0h(1014);
    public static final String A0L = C5C.A0h(1015);
    public static final String A0S = C5C.A0h(1016);
    public static final String A0U = C5C.A0h(1017);
    public static final AnonymousClass23<C05669i> A0H = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.nL
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return new C2026nK(bundle).A0p();
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A0M(SparseArray<Map<C2038nW, C2023nH>> sparseArray, SparseArray<Map<C2038nW, C2023nH>> sparseArray2) {
        int size = sparseArray.size();
        if (sparseArray2.size() != size) {
            return false;
        }
        for (int i3 = 0; i3 < size; i3++) {
            int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i3));
            if (iIndexOfKey < 0 || !A0O(sparseArray.valueAt(i3), sparseArray2.valueAt(iIndexOfKey))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A0O(Map<C2038nW, C2023nH> map, Map<C2038nW, C2023nH> map2) {
        if (map2.size() != map.size()) {
            return false;
        }
        for (Map.Entry<C2038nW, C2023nH> entry : map.entrySet()) {
            C2038nW key = entry.getKey();
            if (!map2.containsKey(key) || !C5C.A1E(entry.getValue(), map2.get(key))) {
                return false;
            }
        }
        return true;
    }

    public C05669i(C2026nK c2026nK) {
        super(c2026nK);
        this.A0C = c2026nK.A0C;
        this.A06 = c2026nK.A06;
        this.A07 = c2026nK.A07;
        this.A05 = c2026nK.A05;
        this.A09 = c2026nK.A09;
        this.A02 = c2026nK.A02;
        this.A03 = c2026nK.A03;
        this.A00 = c2026nK.A00;
        this.A01 = c2026nK.A01;
        this.A08 = c2026nK.A08;
        this.A0B = c2026nK.A0B;
        this.A0D = c2026nK.A0D;
        this.A04 = c2026nK.A04;
        this.A0E = c2026nK.A0E;
        this.A0F = c2026nK.A0F;
        this.A0A = c2026nK.A0A;
    }

    public static C05669i A02(Context context) {
        return new C2026nK(context).A0p();
    }

    public static /* synthetic */ String A0B() {
        String str = A0Z;
        String[] strArr = A0G;
        if (strArr[0].charAt(18) == strArr[1].charAt(18)) {
            throw new RuntimeException();
        }
        A0G[2] = "q21ODw35C4tKhNLL23C7ozdatpTCdbhY";
        return str;
    }

    public static /* synthetic */ String A0C() {
        String str = A0a;
        if (A0G[2].charAt(14) == 'E') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[3] = "0vyQVqHCYWPXhQOTbdu3xGlynIqeANBb";
        strArr[6] = "GRyh1cWelO50ilzlDGPvyp85W4uMwhgp";
        return str;
    }

    public static /* synthetic */ String A0H() {
        String str = A0P;
        String[] strArr = A0G;
        if (strArr[4].charAt(4) != strArr[5].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[7] = "pTwWTj5vm";
        return str;
    }

    public static /* synthetic */ String A0J() {
        String str = A0M;
        String[] strArr = A0G;
        if (strArr[3].charAt(2) != strArr[6].charAt(2)) {
            throw new RuntimeException();
        }
        A0G[7] = "PzaI";
        return str;
    }

    public static boolean A0N(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray.size();
        int firstSize = sparseBooleanArray2.size();
        if (firstSize != size) {
            return false;
        }
        for (int indexInFirst = 0; indexInFirst < size; indexInFirst++) {
            int firstSize2 = sparseBooleanArray.keyAt(indexInFirst);
            if (sparseBooleanArray2.indexOfKey(firstSize2) < 0) {
                return false;
            }
        }
        return true;
    }

    public final C2026nK A0P() {
        return new C2026nK(this);
    }

    @Deprecated
    public final C2023nH A0Q(int i3, C2038nW c2038nW) {
        Map<C2038nW, C2023nH> map = this.A0E.get(i3);
        if (map != null) {
            return map.get(c2038nW);
        }
        return null;
    }

    public final boolean A0R(int i3) {
        return this.A0F.get(i3);
    }

    @Deprecated
    public final boolean A0S(int i3, C2038nW c2038nW) {
        Map<C2038nW, C2023nH> map = this.A0E.get(i3);
        return map != null && map.containsKey(c2038nW);
    }

    @Override // com.facebook.ads.redexgen.core.C2167pc
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            String[] strArr = A0G;
            if (strArr[4].charAt(4) != strArr[5].charAt(4)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[0] = "DcJRbXEfPLE5m3v2P2UTupH85cHshXE1";
            strArr2[1] = "UExlWRKDpxUDxSKj0OTM8Ioa8cI6hcv0";
            if (cls == cls2) {
                C05669i c05669i = (C05669i) obj;
                if (super.equals(c05669i) && this.A0C == c05669i.A0C && this.A06 == c05669i.A06 && this.A07 == c05669i.A07 && this.A05 == c05669i.A05 && this.A09 == c05669i.A09 && this.A02 == c05669i.A02 && this.A03 == c05669i.A03 && this.A00 == c05669i.A00 && this.A01 == c05669i.A01 && this.A08 == c05669i.A08 && this.A0B == c05669i.A0B && this.A0D == c05669i.A0D && this.A04 == c05669i.A04 && A0N(this.A0F, c05669i.A0F) && A0M(this.A0E, c05669i.A0E)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.C2167pc
    public final int hashCode() {
        return (((((((((((((((((((((((((((1 * 31) + super.hashCode()) * 31) + (this.A0C ? 1 : 0)) * 31) + (this.A06 ? 1 : 0)) * 31) + (this.A07 ? 1 : 0)) * 31) + (this.A05 ? 1 : 0)) * 31) + (this.A09 ? 1 : 0)) * 31) + (this.A02 ? 1 : 0)) * 31) + (this.A03 ? 1 : 0)) * 31) + (this.A00 ? 1 : 0)) * 31) + (this.A01 ? 1 : 0)) * 31) + (this.A08 ? 1 : 0)) * 31) + (this.A0B ? 1 : 0)) * 31) + (this.A0D ? 1 : 0)) * 31) + (this.A04 ? 1 : 0);
    }
}
