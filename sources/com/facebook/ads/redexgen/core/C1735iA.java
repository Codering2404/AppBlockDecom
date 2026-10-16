package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1735iA implements InterfaceC0951Ot {
    public Drawable A00;
    public final /* synthetic */ C0950Os A01;

    public C1735iA(C0950Os c0950Os) {
        this.A01 = c0950Os;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0951Ot
    public final Drawable A7E() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0951Ot
    public final C0950Os A7F() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0951Ot
    public final boolean A8q() {
        return this.A01.getPreventCornerOverlap();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0951Ot
    public final boolean A9R() {
        return this.A01.getUseCompatPadding();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0951Ot
    public final void AJK(Drawable drawable) {
        this.A00 = drawable;
        this.A01.setBackgroundDrawable(drawable);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0951Ot
    public final void AJl(int i3, int i4, int i5, int i6) {
        this.A01.A05.set(i3, i4, i5, i6);
        super/*android.widget.FrameLayout*/.setPadding(this.A01.A04.left + i3, this.A01.A04.top + i4, this.A01.A04.right + i5, this.A01.A04.bottom + i6);
    }
}
