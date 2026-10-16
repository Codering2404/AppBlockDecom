package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class F9 extends C1343bl {
    public final ImageView A00;
    public final C1648gi A01;

    public F9(C1648gi c1648gi) {
        super(c1648gi);
        this.A01 = c1648gi;
        setRadius(30);
        this.A00 = new ImageView(c1648gi);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final /* synthetic */ void A00(C1303b7 c1303b7) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -2;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.updateViewLayout(this, layoutParams);
        }
    }

    public void setUrl(String str) {
        LM lm = new LM(this.A00, this.A01);
        lm.A04();
        lm.A07(str);
        lm.A06(new InterfaceC1304b8() { // from class: com.facebook.ads.redexgen.X.FA
            @Override // com.facebook.ads.redexgen.core.InterfaceC1304b8
            public final void AE7(C1303b7 c1303b7) {
                this.A00.A00(c1303b7);
            }
        });
    }
}
