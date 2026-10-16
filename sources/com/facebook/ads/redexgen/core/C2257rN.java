package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.rN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2257rN<ModelType, StateType> {
    public static byte[] A0A;
    public static final C2257rN A0B;
    public EnumC2258rO A00;
    public EnumC2249rE A01;
    public String A02;
    public boolean A03;
    public final boolean A04;
    public final C2257rN A05;
    public final ModelType A06;
    public final StateType A07;
    public final String A08;
    public final List<ViewpointAction<ModelType, StateType>> A09;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{78, 113, 125, 111, 104, 119, 113, 118, 108, 92, 121, 108, 121, 56, 107, 112, 119, 109, 116, 124, 56, 118, 119, 108, 56, 123, 119, 118, 108, 121, 113, 118, 56, 121, 56, 110, 113, 125, 111, 56, 121, 107, 56, 117, 119, 124, 125, 116, 83, 91, 70, 66, 79};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A03(InterfaceC2248rD interfaceC2248rD) {
        Iterator<ViewpointAction<ModelType, StateType>> it = this.A09.iterator();
        while (it.hasNext()) {
            it.next().A6R(this, interfaceC2248rD);
        }
        EnumC2249rE enumC2249rEA9U = interfaceC2248rD.A9U(this);
        this.A01 = enumC2249rEA9U;
        if (enumC2249rEA9U == EnumC2249rE.A02) {
            this.A03 = true;
        }
    }

    static {
        A02();
        A0B = new C2257rN(null, null, A01(48, 5, 44), A01(48, 5, 44), Collections.emptyList(), A0B, false);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rP != com.instagram.common.viewpoint.core.ViewpointData$Builder<ModelType, StateType> */
    /* JADX WARN: Illegal instructions before constructor call */
    public C2257rN(C2259rP<ModelType, StateType> c2259rP) {
        List listEmptyList;
        Object obj = c2259rP.A03;
        Object obj2 = c2259rP.A04;
        String str = c2259rP.A06;
        String str2 = c2259rP.A06;
        if (c2259rP.A01 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = c2259rP.A01;
        }
        this(obj, obj2, str, str2, listEmptyList, c2259rP.A00, c2259rP.A02);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    public C2257rN(ModelType modeltype, StateType statetype, String str, String str2, List<ViewpointAction<ModelType, StateType>> list, C2257rN c2257rN, boolean z2) {
        this.A00 = EnumC2258rO.A02;
        if (!(modeltype instanceof View)) {
            this.A06 = modeltype;
            this.A07 = statetype;
            this.A08 = str;
            this.A02 = str2;
            this.A05 = c2257rN;
            this.A03 = false;
            this.A09 = list;
            this.A04 = z2;
            return;
        }
        throw new IllegalArgumentException(A01(0, 48, 2));
    }

    public static <ModelType, StateType> C2259rP<ModelType, StateType> A00(ModelType model, StateType state, String str) {
        return new C2259rP<>(model, state, str);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    public final boolean A04() {
        return this.A03;
    }
}
