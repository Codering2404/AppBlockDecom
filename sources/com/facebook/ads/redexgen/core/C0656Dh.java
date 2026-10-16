package com.facebook.ads.redexgen.core;

import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0656Dh implements InterfaceC1536eu {
    public View A00;
    public C0685Ek A01;
    public EnumC1551f9 A02;
    public boolean A03;
    public final Handler A04;
    public final EA A05;
    public final E4 A06;
    public final E2 A07;
    public final AbstractC0668Dt A08;
    public final boolean A09;
    public final boolean A0A;

    public C0656Dh(View view, EnumC1551f9 enumC1551f9, boolean z2) {
        this(view, enumC1551f9, z2, false);
    }

    public C0656Dh(View view, EnumC1551f9 enumC1551f9, boolean z2, boolean z3) {
        this.A06 = new E4() { // from class: com.facebook.ads.redexgen.X.3p
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4B c4b) {
                this.A00.A06(1, 0);
            }
        };
        this.A07 = new E2() { // from class: com.facebook.ads.redexgen.X.3n
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(E3 e3) {
                if (!this.A00.A03) {
                    return;
                }
                if (this.A00.A02 == EnumC1551f9.A02 || this.A00.A09) {
                    this.A00.A02 = null;
                    this.A00.A05();
                } else {
                    this.A00.A06(0, 8);
                }
            }
        };
        this.A05 = new EA() { // from class: com.facebook.ads.redexgen.X.3e
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4K c4k) {
                if (this.A00.A02 == EnumC1551f9.A03) {
                    return;
                }
                this.A00.A00.setAlpha(1.0f);
                this.A00.A00.setVisibility(0);
            }
        };
        this.A08 = new C04123c(this);
        this.A03 = true;
        this.A04 = new Handler();
        this.A09 = z2;
        this.A0A = z3;
        A08(view, enumC1551f9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        this.A00.animate().alpha(0.0f).setDuration(500L).setListener(new C1550f8(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(int i3, int i4) {
        this.A04.removeCallbacksAndMessages(null);
        this.A00.clearAnimation();
        this.A00.setAlpha(i3);
        this.A00.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(AnimatorListenerAdapter animatorListenerAdapter) {
        this.A00.setVisibility(0);
        this.A00.animate().alpha(1.0f).setDuration(500L).setListener(animatorListenerAdapter);
    }

    private final void A08(View view, EnumC1551f9 enumC1551f9) {
        this.A02 = enumC1551f9;
        this.A00 = view;
        this.A00.clearAnimation();
        if (enumC1551f9 == EnumC1551f9.A03) {
            this.A00.setAlpha(0.0f);
            this.A00.setVisibility(8);
        } else {
            this.A00.setAlpha(1.0f);
            this.A00.setVisibility(0);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AAv(C0685Ek c0685Ek) {
        this.A01 = c0685Ek;
        c0685Ek.getEventBus().A03(this.A06, this.A07, this.A08, this.A05);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AKV(C0685Ek c0685Ek) {
        A06(1, 0);
        c0685Ek.getEventBus().A04(this.A05, this.A08, this.A07, this.A06);
        this.A01 = null;
    }
}
