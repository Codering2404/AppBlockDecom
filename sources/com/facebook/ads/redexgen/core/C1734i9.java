package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.i9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1734i9 implements InterfaceC0952Ou {
    private C0953Ov A00(InterfaceC0951Ot interfaceC0951Ot) {
        return (C0953Ov) interfaceC0951Ot.A7E();
    }

    public final void A01(InterfaceC0951Ot interfaceC0951Ot) {
        if (!interfaceC0951Ot.A9R()) {
            interfaceC0951Ot.AJl(0, 0, 0, 0);
            return;
        }
        float fA8S = A8S(interfaceC0951Ot);
        float fA8r = A8r(interfaceC0951Ot);
        float elevation = AbstractC0955Ox.A00(fA8S, fA8r, interfaceC0951Ot.A8q());
        int vPadding = (int) Math.ceil(elevation);
        float elevation2 = AbstractC0955Ox.A01(fA8S, fA8r, interfaceC0951Ot.A8q());
        int iCeil = (int) Math.ceil(elevation2);
        interfaceC0951Ot.AJl(vPadding, iCeil, vPadding, iCeil);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final ColorStateList A71(InterfaceC0951Ot interfaceC0951Ot) {
        return A00(interfaceC0951Ot).A05();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final float A7v(InterfaceC0951Ot interfaceC0951Ot) {
        return interfaceC0951Ot.A7F().getElevation();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final float A8S(InterfaceC0951Ot interfaceC0951Ot) {
        return A00(interfaceC0951Ot).A03();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final float A8X(InterfaceC0951Ot interfaceC0951Ot) {
        return A8r(interfaceC0951Ot) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final float A8Y(InterfaceC0951Ot interfaceC0951Ot) {
        return A8r(interfaceC0951Ot) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final float A8r(InterfaceC0951Ot interfaceC0951Ot) {
        return A00(interfaceC0951Ot).A04();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void AAE() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void AAG(InterfaceC0951Ot interfaceC0951Ot, Context context, ColorStateList colorStateList, float f3, float f4, float f5) {
        C0953Ov background = new C0953Ov(colorStateList, f3);
        interfaceC0951Ot.AJK(background);
        View view = interfaceC0951Ot.A7F();
        view.setClipToOutline(true);
        view.setElevation(f4);
        AJX(interfaceC0951Ot, f5);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void ADP(InterfaceC0951Ot interfaceC0951Ot) {
        AJX(interfaceC0951Ot, A8S(interfaceC0951Ot));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void AFT(InterfaceC0951Ot interfaceC0951Ot) {
        AJX(interfaceC0951Ot, A8S(interfaceC0951Ot));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void AJJ(InterfaceC0951Ot interfaceC0951Ot, ColorStateList colorStateList) {
        A00(interfaceC0951Ot).A08(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void AJP(InterfaceC0951Ot interfaceC0951Ot, float f3) {
        interfaceC0951Ot.A7F().setElevation(f3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void AJX(InterfaceC0951Ot interfaceC0951Ot, float f3) {
        A00(interfaceC0951Ot).A07(f3, interfaceC0951Ot.A9R(), interfaceC0951Ot.A8q());
        A01(interfaceC0951Ot);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0952Ou
    public final void AJj(InterfaceC0951Ot interfaceC0951Ot, float f3) {
        A00(interfaceC0951Ot).A06(f3);
    }
}
