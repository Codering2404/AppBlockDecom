package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2026nK extends C04153h {
    public static String[] A0G = {"svIlLfjydeGBu6G0UjrHSopJ4Ky0wypW", "Eix0ooWKKyHx1hOwK", "jEg8xHvrvI0NXBTEehRxqQQjEYaTbIQI", "2fo", "JdZ", "dfBQZRQYRFpeihXeeCDcyjRnxunK4YCt", "ZC", "go43CHW4mwtjJCZZxmpd9eXXAUtGDH29"};
    public boolean A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;

    @MetaExoPlayerCustomization("D25277746 - If all qualities are filtered out, do not use a fixed selection but differ to adaptive track selection in hero.")
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public final SparseArray<Map<C2038nW, C2023nH>> A0E;
    public final SparseBooleanArray A0F;

    @Deprecated
    public C2026nK() {
        this.A0E = new SparseArray<>();
        this.A0F = new SparseBooleanArray();
        A0W();
    }

    public C2026nK(Context context) {
        super(context);
        this.A0E = new SparseArray<>();
        this.A0F = new SparseBooleanArray();
        A0W();
    }

    @MetaExoPlayerCustomization("Modified to support setExceedRendererCapabilitiesIfAllFilteredOut")
    public C2026nK(Bundle bundle) {
        super(bundle);
        A0W();
        C05669i c05669i = C05669i.A0J;
        A17(bundle.getBoolean(C05669i.A0W, c05669i.A0C));
        A11(bundle.getBoolean(C05669i.A0Q, c05669i.A06));
        A12(bundle.getBoolean(C05669i.A0R, c05669i.A07));
        A10(bundle.getBoolean(C05669i.A0H(), c05669i.A05));
        A14(bundle.getBoolean(C05669i.A0T, c05669i.A09));
        A0x(bundle.getBoolean(C05669i.A0J(), c05669i.A02));
        A0y(bundle.getBoolean(C05669i.A0N, c05669i.A03));
        A0v(bundle.getBoolean(C05669i.A0K, c05669i.A00));
        A0w(bundle.getBoolean(C05669i.A0L, c05669i.A01));
        A13(bundle.getBoolean(C05669i.A0S, c05669i.A08));
        A16(bundle.getBoolean(C05669i.A0V, c05669i.A0B));
        A18(bundle.getBoolean(C05669i.A0b, c05669i.A0D));
        A0z(bundle.getBoolean(C05669i.A0O, c05669i.A04));
        A15(bundle.getBoolean(C05669i.A0U, c05669i.A0A));
        this.A0E = new SparseArray<>();
        A0X(bundle);
        this.A0F = A0R(bundle.getIntArray(C05669i.A0X));
    }

    @MetaExoPlayerCustomization("To support exceedRendererCapabilitiesIfAllFilteredOut")
    public C2026nK(C05669i c05669i) {
        super(c05669i);
        this.A0C = c05669i.A0C;
        this.A06 = c05669i.A06;
        this.A07 = c05669i.A07;
        this.A05 = c05669i.A05;
        this.A09 = c05669i.A09;
        this.A02 = c05669i.A02;
        this.A03 = c05669i.A03;
        this.A00 = c05669i.A00;
        this.A01 = c05669i.A01;
        this.A08 = c05669i.A08;
        this.A0B = c05669i.A0B;
        this.A0D = c05669i.A0D;
        this.A04 = c05669i.A04;
        this.A0A = c05669i.A0A;
        this.A0E = A0G((SparseArray<Map<C2038nW, C2023nH>>) c05669i.A0E);
        this.A0F = c05669i.A0F.clone();
    }

    public static SparseArray<Map<C2038nW, C2023nH>> A0G(SparseArray<Map<C2038nW, C2023nH>> sparseArray) {
        SparseArray<Map<C2038nW, C2023nH>> sparseArray2 = new SparseArray<>();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            sparseArray2.put(sparseArray.keyAt(i3), new HashMap(sparseArray.valueAt(i3)));
        }
        return sparseArray2;
    }

    private SparseBooleanArray A0R(int[] iArr) {
        if (iArr == null) {
            return new SparseBooleanArray();
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
        for (int i3 : iArr) {
            sparseBooleanArray.append(i3, true);
        }
        return sparseBooleanArray;
    }

    @MetaExoPlayerCustomization("To support setting exceedRendererCapabilitiesIfAllFilteredOut")
    private void A0W() {
        this.A0C = true;
        this.A06 = false;
        this.A07 = true;
        this.A05 = false;
        this.A09 = true;
        this.A02 = false;
        this.A03 = false;
        this.A00 = false;
        this.A01 = false;
        this.A08 = true;
        this.A0B = true;
        this.A0D = false;
        this.A04 = true;
        this.A0A = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A0X(Bundle bundle) {
        BP bpA01;
        SparseArray sparseArrayA00;
        int[] intArray = bundle.getIntArray(C05669i.A0B());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(C05669i.A0C());
        if (parcelableArrayList == null) {
            bpA01 = BP.A03();
        } else {
            AnonymousClass23<C2038nW> anonymousClass23 = C2038nW.A05;
            String[] strArr = A0G;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[2] = "KlsLVpZXOsku5rL5eePguYtdE3UqynPn";
            strArr2[5] = "qpearOu2I9fJNwBbehSRgczBWJlsPwpY";
            bpA01 = AnonymousClass44.A01(anonymousClass23, parcelableArrayList);
        }
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(C05669i.A0Y);
        if (sparseParcelableArray == null) {
            sparseArrayA00 = new SparseArray();
        } else {
            sparseArrayA00 = AnonymousClass44.A00(C2023nH.A05, sparseParcelableArray);
        }
        if (intArray == null || intArray.length != bpA01.size()) {
            return;
        }
        for (int i3 = 0; i3 < intArray.length; i3++) {
            A0r(intArray[i3], (C2038nW) bpA01.get(i3), (C2023nH) sparseArrayA00.get(i3));
        }
    }

    @Override // com.facebook.ads.redexgen.core.C04153h
    /* JADX INFO: renamed from: A0q, reason: merged with bridge method [inline-methods] */
    public final C2026nK A0m(int i3, int i4, boolean z2) {
        super.A0m(i3, i4, z2);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
    
        if (com.facebook.ads.redexgen.core.C5C.A1E(r4, r8) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
    
        if (com.facebook.ads.redexgen.core.C5C.A1E(r4, r8) != false) goto L15;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.C2026nK A0r(int r6, com.facebook.ads.redexgen.core.C2038nW r7, com.facebook.ads.redexgen.core.C2023nH r8) {
        /*
            r5 = this;
            android.util.SparseArray<java.util.Map<com.facebook.ads.redexgen.X.nW, com.facebook.ads.redexgen.X.nH>> r0 = r5.A0E
            java.lang.Object r3 = r0.get(r6)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 != 0) goto L14
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            android.util.SparseArray<java.util.Map<com.facebook.ads.redexgen.X.nW, com.facebook.ads.redexgen.X.nH>> r0 = r5.A0E
            r0.put(r6, r3)
        L14:
            boolean r4 = r3.containsKey(r7)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2026nK.A0G
            r0 = 4
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L30
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L30:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2026nK.A0G
            java.lang.String r1 = "Tjk1w46Zsfr3yClteaW3dwU9W0N7TL6X"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "KoERYkShSHV4ud9Re9JlKSMcCXAYN5Cn"
            r0 = 5
            r2[r0] = r1
            if (r4 == 0) goto L7c
            java.lang.Object r4 = r3.get(r7)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2026nK.A0G
            r0 = 0
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 28
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L69
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2026nK.A0G
            java.lang.String r1 = "d9Fp2lxah88hbF8VY"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "He"
            r0 = 6
            r2[r0] = r1
            boolean r0 = com.facebook.ads.redexgen.core.C5C.A1E(r4, r8)
            if (r0 == 0) goto L7c
        L68:
            return r5
        L69:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2026nK.A0G
            java.lang.String r1 = "6G3DmRjovsWEEopHgL7H9VeUKDmRIoIA"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "heYp32NvS9S7pouisOnfj6NnH9zTXJMv"
            r0 = 7
            r2[r0] = r1
            boolean r0 = com.facebook.ads.redexgen.core.C5C.A1E(r4, r8)
            if (r0 == 0) goto L7c
            goto L68
        L7c:
            r3.put(r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2026nK.A0r(int, com.facebook.ads.redexgen.X.nW, com.facebook.ads.redexgen.X.nH):com.facebook.ads.redexgen.X.nK");
    }

    @Override // com.facebook.ads.redexgen.core.C04153h
    /* JADX INFO: renamed from: A0s, reason: merged with bridge method [inline-methods] */
    public final C2026nK A0n(Context context) {
        super.A0n(context);
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.C04153h
    /* JADX INFO: renamed from: A0t, reason: merged with bridge method [inline-methods] */
    public final C2026nK A0o(Context context, boolean z2) {
        super.A0o(context, z2);
        return this;
    }

    public final C2026nK A0u(C2167pc c2167pc) {
        super.A0W(c2167pc);
        return this;
    }

    public final C2026nK A0v(boolean z2) {
        this.A00 = z2;
        return this;
    }

    public final C2026nK A0w(boolean z2) {
        this.A01 = z2;
        return this;
    }

    public final C2026nK A0x(boolean z2) {
        this.A02 = z2;
        return this;
    }

    public final C2026nK A0y(boolean z2) {
        this.A03 = z2;
        return this;
    }

    public final C2026nK A0z(boolean z2) {
        this.A04 = z2;
        return this;
    }

    public final C2026nK A10(boolean z2) {
        this.A05 = z2;
        return this;
    }

    public final C2026nK A11(boolean z2) {
        this.A06 = z2;
        return this;
    }

    public final C2026nK A12(boolean z2) {
        this.A07 = z2;
        return this;
    }

    public final C2026nK A13(boolean z2) {
        this.A08 = z2;
        return this;
    }

    public final C2026nK A14(boolean z2) {
        this.A09 = z2;
        return this;
    }

    @MetaExoPlayerCustomization("D25277746")
    public final C2026nK A15(boolean z2) {
        this.A0A = z2;
        return this;
    }

    public final C2026nK A16(boolean z2) {
        this.A0B = z2;
        return this;
    }

    public final C2026nK A17(boolean z2) {
        this.A0C = z2;
        return this;
    }

    public final C2026nK A18(boolean z2) {
        this.A0D = z2;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.C04153h
    /* JADX INFO: renamed from: A19, reason: merged with bridge method [inline-methods] */
    public final C05669i A0p() {
        return new C05669i(this);
    }
}
