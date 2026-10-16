package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class K3 implements InterfaceC1304b8 {
    public final /* synthetic */ C0811Ji A00;

    public K3(C0811Ji c0811Ji) {
        this.A00 = c0811Ji;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1304b8
    public final void AE7(C1303b7 c1303b7) {
        if (this.A00.A02 != null && c1303b7.A00() != null) {
            this.A00.A02.setImageBitmap(c1303b7.A00());
            this.A00.A02.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A00.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
