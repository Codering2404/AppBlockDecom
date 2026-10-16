package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ow, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0954Ow extends AbstractC1311bF {
    public final TextView A00;
    public final TextView A01;
    public static final int A02 = (int) (XX.A02 * 36.0f);
    public static final int A05 = (int) (XX.A02 * 4.0f);
    public static final int A03 = (int) (XX.A02 * 8.0f);
    public static final int A04 = (int) (XX.A02 * 4.0f);

    public C0954Ow(C1648gi c1648gi, int i3, C0906Na c0906Na, boolean z2, String str, VA va, InterfaceC1189Yh interfaceC1189Yh, C1593fp c1593fp, Y2 y2, C0912Ng c0912Ng) {
        super(c1648gi, null, i3, c0906Na, z2, str, va, interfaceC1189Yh, c1593fp, y2, c0912Ng, false, "");
        setOrientation(0);
        setPadding(A05, A05, A05, A05);
        this.A01 = A01(-16448251, 13, true);
        this.A00 = A01(-10131605, 12, false);
        this.A06.addView(A00(i3), new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        addView(this.A06, layoutParams);
        this.A08.setPadding(A03, 0, A03, 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, A02);
        layoutParams2.gravity = 17;
        addView(this.A08, layoutParams2);
    }

    private LinearLayout A00(int i3) {
        LinearLayout linearLayout = new LinearLayout(this.A07);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04, 0, A04, 0);
        linearLayout.addView(this.A01, AbstractC1311bF.A0B);
        linearLayout.addView(this.A00, AbstractC1311bF.A0B);
        LinearLayout linearLayout2 = new LinearLayout(this.A07);
        linearLayout2.setOrientation(0);
        linearLayout2.addView(this.A09, new LinearLayout.LayoutParams(i3, i3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        linearLayout2.addView(linearLayout, layoutParams);
        return linearLayout2;
    }

    private TextView A01(int i3, int i4, boolean z2) {
        TextView textView = new TextView(this.A07);
        textView.setTextColor(i3);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        YB.A0a(textView, z2, i4);
        return textView;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1311bF
    public final void A0k() {
        super.A0k();
        setOnClickListener(this.A05);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1311bF
    public final void A0l(int i3) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1311bF
    public void setInfo(NY ny, C0908Nc c0908Nc, String str, String str2, InterfaceC1163Xh interfaceC1163Xh, InterfaceC1326bU interfaceC1326bU) {
        super.setInfo(ny, c0908Nc, str, str2, interfaceC1163Xh, interfaceC1326bU);
        this.A01.setText(ny.A0G());
        this.A00.setText(ny.A0F());
        if (TextUtils.isEmpty(c0908Nc.A04())) {
            YB.A0H(this.A08);
        }
    }
}
