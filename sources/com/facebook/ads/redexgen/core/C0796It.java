package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.It, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0796It extends AbstractC1294ay {
    public static byte[] A01;
    public static String[] A02 = {"Hi1Kp4OvuN0Mi1seIlZSQ9fXUMjjvE9p", "a9aQz404TSolCr57kPPHO7UwC5OuSOzH", "iZ3", "0R4wIBceXoURlcuySRfEAV2VVdZMdToQ", "Pns5aPZ6VZAIHBBYLIEekDbTjPHG0hEC", "QEtpGmawVai8H8emaUXHDe6205ss7rIx", "CSF", "KC7cPyOdjWwnXiGHMOi8VSLb8GeuOYES"};
    public final /* synthetic */ C1432dC A00;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-44, -23, -34, -47, -35, -39, -45, -49, -29, -44, -37, -49, -36, -47, -23, -43, -30, -49, -45, -33, -34, -28, -43, -34, -28, -49, -40, -43, -39, -41, -40, -28, -53, -32, -43, -56, -44, -48, -54, -58, -38, -53, -46, -58, -45, -56, -32, -52, -39, -58, -54, -42, -43, -37, -52, -43, -37, -58, -34, -48, -53, -37, -49};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        int dynamicWebViewWidth = getDynamicWebViewWidth();
        int dynamicWebViewHeight = getDynamicWebViewHeight();
        if (dynamicWebViewWidth <= 0 || dynamicWebViewHeight <= 0) {
            super.onMeasure(i3, i4);
            return;
        }
        float f3 = dynamicWebViewWidth / dynamicWebViewHeight;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        boolean z2 = mode != 1073741824;
        boolean z3 = mode2 != 1073741824;
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int width2 = viewGroup.getWidth();
            height = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            width = width2 != 0 ? viewGroup.getWidth() : Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (viewGroup.getHeight() != 0) {
                height = viewGroup.getHeight();
            }
        }
        int iA00 = A00(dynamicWebViewWidth, width, i3);
        int iA002 = A00(dynamicWebViewHeight, height, i4);
        if ((z3 || z2) && Math.abs((iA00 / iA002) - f3) > 1.0E-7d) {
            boolean z4 = false;
            if (z3) {
                iA002 = (int) (iA00 / f3);
                z4 = true;
            }
            if (!z4 && z2) {
                float f4 = iA002 * f3;
                if (A02[4].charAt(14) == 'W') {
                    throw new RuntimeException();
                }
                A02[4] = "z0LYwU9eQuMrdS04YY6f4w1GT5TpPfvp";
                iA00 = (int) f4;
            }
        }
        setMeasuredDimension(iA00, iA002);
    }

    static {
        A02();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0796It(C1432dC c1432dC, C1648gi c1648gi) {
        super(c1648gi);
        this.A00 = c1432dC;
        getSettings().setAllowFileAccess(true);
        setBackgroundColor(0);
    }

    private int A00(int i3, int i4, int i5) {
        int specMode = View.MeasureSpec.getMode(i5);
        int result = View.MeasureSpec.getSize(i5);
        switch (specMode) {
            case Integer.MIN_VALUE:
                int iMin = Math.min(i3, result);
                String[] strArr = A02;
                String str = strArr[0];
                String str2 = strArr[7];
                int specMode2 = str.charAt(6);
                if (specMode2 != str2.charAt(6)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "m6i";
                strArr2[2] = "Lyc";
                return Math.min(iMin, i4);
            case 0:
                return Math.min(i3, i4);
            case 1073741824:
                return result;
            default:
                return i3;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1294ay
    public final WebChromeClient A0G() {
        return new C1427d7(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1294ay
    public final WebViewClient A0H() {
        return new C1428d8(this.A00);
    }

    private int getDynamicWebViewHeight() {
        return this.A00.A09.A1H().optInt(A01(0, 32, 84));
    }

    private int getDynamicWebViewWidth() {
        return this.A00.A09.A1H().optInt(A01(32, 31, 75));
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.A00.A02 != null) {
            this.A00.A02.AGC(this, motionEvent);
        }
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (A02[1].charAt(18) != 'P') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "8G0frzOI4hnuLOXw8ofdNPqhqb4ZK9tq";
        strArr[7] = "WF4GKlO7gB8U235davoNaDl6h9NjfHA4";
        return zOnTouchEvent;
    }
}
