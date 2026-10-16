package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class FH extends AbstractC0996Qq<FC> {
    public final int A00;
    public final C1648gi A01;
    public final ViewOnClickListenerC0846Kr A02;
    public final List<String> A03;

    public FH(C1648gi c1648gi, List<String> screenshotUrls, int i3, ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr) {
        this.A03 = screenshotUrls;
        this.A00 = i3;
        this.A01 = c1648gi;
        this.A02 = viewOnClickListenerC0846Kr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final FC A0F(ViewGroup viewGroup, int i3) {
        FD fd = new FD(this.A01);
        if (C1098Up.A1D(this.A01)) {
            fd.setOnClickListener(new ViewOnClickListenerC1515eZ(this));
        }
        return new FC(fd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0K(FC fc, int i3) {
        String str = this.A03.get(i3);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int startSpacing = this.A00 * 4;
        if (i3 != 0) {
            startSpacing = this.A00;
        }
        marginLayoutParams.setMargins(startSpacing, 0, i3 >= A0B() + (-1) ? this.A00 * 4 : this.A00, 0);
        fc.A0p().setLayoutParams(marginLayoutParams);
        fc.A0p().A00(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0996Qq
    public final int A0B() {
        return this.A03.size();
    }
}
