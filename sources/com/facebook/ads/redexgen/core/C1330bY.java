package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1330bY extends RelativeLayout {
    public static String[] A06 = {"5SHdRwFrRc5I045mD2ED8hkR", "u607MEARHNz8UhlPP1yTj4t381pEaF91", "vukf6ONNN7udfcALTJGLQQCjk2MRvNqz", "", "LcpvFkzcfh74Tt7JU5VGWxCVkX9ufVQR", "0vcUNZ0oTZNrvLONhpGozykOOsxw8rlk", "", "YDZhxKGTPmLilHONF7GF9MvjPIJLKPZP"};
    public final int A00;
    public final LinearLayout A01;
    public final C1807jT A02;
    public final C1648gi A03;
    public final VA A04;
    public final InterfaceC1189Yh A05;

    public C1330bY(C1648gi c1648gi, C1807jT c1807jT, VA va, InterfaceC1189Yh interfaceC1189Yh, int i3, int i4) {
        super(c1648gi);
        this.A03 = c1648gi;
        this.A02 = c1807jT;
        this.A04 = va;
        this.A05 = interfaceC1189Yh;
        this.A00 = i3;
        this.A01 = new LinearLayout(c1648gi);
        A00();
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        setLayoutOrientation(i4);
    }

    private void A00() {
        int i3 = 0;
        while (true) {
            int iA23 = this.A02.A23();
            String[] strArr = A06;
            String str = strArr[2];
            String str2 = strArr[4];
            int iCharAt = str.charAt(18);
            int i4 = str2.charAt(18);
            if (iCharAt == i4) {
                throw new RuntimeException();
            }
            A06[7] = "iNncIzrUEB4NW29LDzlz6YUCQOx5Utak";
            if (i3 < iA23) {
                LF lf = new LF(this.A03, this.A02.A27(i3), this.A04, this.A05);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.weight = 1.0f;
                int i5 = LF.A0C;
                int i6 = LF.A0C;
                int i7 = LF.A0C;
                int i8 = LF.A0C;
                layoutParams.setMargins(i5, i6, i7, i8);
                lf.setLayoutParams(layoutParams);
                this.A01.addView(lf);
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayoutOrientation(configuration.orientation);
    }

    private void setLayoutOrientation(int i3) {
        if (i3 != 1) {
            this.A01.setOrientation(0);
            this.A01.setPadding(0, this.A00, 0, (int) (((double) this.A00) * 0.25d));
        } else {
            this.A01.setOrientation(1);
            this.A01.setPadding(0, (int) (((double) this.A00) * 1.5d), 0, this.A00);
        }
    }
}
