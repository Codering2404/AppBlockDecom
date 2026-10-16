package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1348bq extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"5HLU", "cJmhtdIbv5Y5xdwCDl3dT8HPvklAUmwI", "4stzzs6gVfUC8wPYX", "7o6tBFGKBnQKcZsvXBJ4ayd9LnRtCNJ", "BSijPHOaulEPVGa4U1fKlqwI", "TamflSlcNH2rcKEIo3f72qWopMk8DENN", "Hhh3HDuTgivrAf4KqreTZK2", "SugScFu"};
    public static final float A06;
    public static final int A07;
    public static final int A08;
    public final TextView A00;
    public final TextView A01;
    public final TextView A02;
    public final boolean A03;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{Ascii.US, Ascii.SUB, Ascii.SUB, Ascii.ESC, 10, Ascii.US, Ascii.ETB, Ascii.DC2, Ascii.CR};
    }

    static {
        A01();
        A06 = Resources.getSystem().getDisplayMetrics().density;
        A08 = (int) (A06 * 6.0f);
        A07 = (int) (A06 * 8.0f);
    }

    public C1348bq(C1648gi c1648gi, C0906Na c0906Na, boolean z2, int i3, int i4, int i5) {
        super(c1648gi);
        setOrientation(1);
        this.A02 = new TextView(c1648gi);
        YB.A0a(this.A02, true, i3);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setLineSpacing(A08, 1.0f);
        this.A01 = new TextView(c1648gi);
        this.A00 = new TextView(c1648gi);
        YB.A0a(this.A00, false, i4);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setLineSpacing(A08, 1.0f);
        this.A03 = C1098Up.A17(c1648gi);
        int i6 = this.A03 ? -2 : -1;
        addView(this.A02, new LinearLayout.LayoutParams(i6, -2));
        addView(this.A01, new LinearLayout.LayoutParams(i6, -2));
        this.A01.setVisibility(8);
        A03(c0906Na, z2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, -2);
        layoutParams.setMargins(0, i5, 0, 0);
        addView(this.A00, layoutParams);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1348bq(C1648gi c1648gi, C0906Na c0906Na, boolean z2, boolean z3, boolean z4) {
        int i3 = z3 ? 18 : 22;
        int i4 = z3 ? 14 : 16;
        int i5 = A07;
        this(c1648gi, c0906Na, z2, i3, i4, z4 ? i5 / 2 : i5);
    }

    public final void A02() {
        this.A02.setTypeface(this.A02.getTypeface(), 1);
    }

    public final void A03(C0906Na c0906Na, boolean z2) {
        this.A02.setTextColor(c0906Na.A07(z2));
        this.A01.setTextColor(c0906Na.A05(z2));
        this.A00.setTextColor(c0906Na.A06(z2));
    }

    public final void A04(String str, String str2, String str3, boolean z2, boolean z3) {
        boolean z4 = !TextUtils.isEmpty(str);
        boolean z5 = !TextUtils.isEmpty(str2);
        TextView textView = this.A02;
        if (!z4) {
            str = str2;
        }
        textView.setText(str);
        if (str3 != null) {
            this.A01.setText(str3);
        }
        TextView textView2 = this.A00;
        if (!z4) {
            str2 = A00(0, 0, 51);
        }
        textView2.setText(str2);
        int i3 = 3;
        String[] strArr = A05;
        if (strArr[6].length() != strArr[4].length()) {
            String[] strArr2 = A05;
            strArr2[3] = "nuTyQWYrKUsKt4wC014k9cpf4UiNlrc";
            strArr2[0] = "l7Wy";
            if (!z4 || !z5) {
                TextView textView3 = this.A02;
                if (A05[1].charAt(4) != 'F') {
                    String[] strArr3 = A05;
                    strArr3[3] = "qWmgL2iM9nfMb7yMq7CVR7HS6Guvx6S";
                    strArr3[0] = "mFhP";
                    if (z2) {
                        i3 = 2;
                    } else if (z3) {
                        i3 = 4;
                    }
                    textView3.setMaxLines(i3);
                    return;
                }
            } else {
                this.A02.setMaxLines(z2 ? 1 : 2);
                this.A00.setMaxLines(z2 ? 1 : z3 ? 3 : 2);
                return;
            }
        }
        throw new RuntimeException();
    }

    public TextView getDescriptionTextView() {
        return this.A00;
    }

    public TextView getTitleTextView() {
        return this.A02;
    }

    public void setAlignment(int i3) {
        if (this.A03) {
            setGravity(i3);
        }
        this.A02.setGravity(i3);
        this.A00.setGravity(i3);
    }

    public void setCTAClickListener(ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr) {
        ViewOnClickListenerC1351bt viewOnClickListenerC1351btA03 = AbstractC1352bu.A03(viewOnClickListenerC0846Kr, A00(0, 9, 20));
        this.A02.setOnClickListener(viewOnClickListenerC1351btA03);
        this.A00.setOnClickListener(viewOnClickListenerC1351btA03);
        this.A01.setOnClickListener(viewOnClickListenerC1351btA03);
    }

    public void setDescriptionTextSize(int i3) {
        this.A00.setTextSize(i3);
    }

    public void setDescriptionVisibility(int i3) {
        this.A00.setVisibility(i3);
    }

    public void setTitleTextSize(int i3) {
        this.A02.setTextSize(i3);
    }
}
