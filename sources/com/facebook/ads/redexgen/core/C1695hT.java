package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.ads.AdClosedListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1695hT extends C1018Rm implements AdOptionsViewApi, InterfaceC1254aK {
    public static byte[] A0B;
    public static String[] A0C = {"HVqi6jlpWuJt2YtXNdvGk3FhV0BHl3EV", "MmKJ6DDV7RS65o7dKLAsYGebg3Me5CTe", "1YJN2Qnc4ttaIZRVWQztvMy6euLicnbf", "AdY32lBMWhACAu5OzQBb3WT", "7pW2kqTunwh3p", "By284lxDKeQhXfwWoADF7ASQT9nDXNCZ", "", "3GcamP2dghLgpW6nys2YEXVC3i8y"};
    public static final int A0D;
    public static final int A0E;
    public ImageView A00;
    public ImageView A01;
    public C1266aW A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final Context A06;
    public final LinearLayout A07;
    public final AdOptionsView A08;
    public final NativeAdLayout A09;
    public final UK A0A;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        byte[] bArr = {81, 102, 115, 108, 113, 119, 35, 66, 103};
        String[] strArr = A0C;
        if (strArr[3].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[3] = "u5VvbSB0F1Ye86S0UUtiEMk";
        strArr2[7] = "xkynJM0f4daSI4M9ryujsiLCexBq";
        A0B = bArr;
    }

    static {
        A08();
        A0D = (int) (XX.A02 * 23.0f);
        A0E = (int) (XX.A02 * 4.0f);
    }

    public C1695hT(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i3, AdOptionsView adOptionsView) {
        this.A05 = false;
        this.A04 = false;
        this.A03 = false;
        this.A08 = adOptionsView;
        this.A09 = nativeAdLayout;
        this.A06 = context;
        this.A07 = new LinearLayout(context);
        this.A08.addView(this.A07);
        this.A07.setOrientation(orientation != AdOptionsView.Orientation.HORIZONTAL ? 1 : 0);
        this.A0A = UK.A0L(nativeAdBase.getInternalNativeAd());
        this.A0A.A1c(nativeAdLayout);
        this.A0A.A1e(this);
        C1830ju c1830juA12 = this.A0A.A12();
        if (c1830juA12 != null && c1830juA12.A0R() && !c1830juA12.A0P()) {
            this.A07.setVisibility(8);
            return;
        }
        EnumC1158Xc.A04(this.A08, EnumC1158Xc.A0C);
        if (A0C()) {
            A05();
            return;
        }
        if (A0B()) {
            A06();
        } else {
            A09(i3);
        }
        A04();
    }

    public C1695hT(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        this(context, nativeAdBase, nativeAdLayout, AdOptionsView.Orientation.HORIZONTAL, 23, adOptionsView);
    }

    private ImageView A00(YM ym) {
        ImageView imageView = new ImageView(this.A08.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(A0E, A0E, A0E, A0E);
        imageView.setImageBitmap(YN.A01(ym));
        return imageView;
    }

    public static YM A01(AbstractC1813jd abstractC1813jd) {
        if (AbstractC1255aL.A00(abstractC1813jd) == EnumC1259aP.A02) {
            return YM.AD_CHOICE_COLLAPSED_PILL;
        }
        return YM.CREDIT_LINE_COLLAPSED_PILL;
    }

    public static YM A02(AbstractC1813jd abstractC1813jd) {
        if (AbstractC1255aL.A00(abstractC1813jd) == EnumC1259aP.A02) {
            return YM.AD_CHOICE_EXPANDED_PILL;
        }
        return YM.CREDIT_LINE_PILL;
    }

    private void A04() {
        this.A07.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Rb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.A00.A0D(view);
            }
        });
    }

    private void A05() {
        C1257aN c1257aNA02 = AbstractC1258aO.A02(this.A0A.A15(), EnumC1256aM.A05, this.A0A.A13());
        c1257aNA02.setBackgroundColor(-2145637581);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.A07.addView(c1257aNA02, layoutParams);
    }

    private void A06() {
        if (this.A0A.A13() != null) {
            A0A(A01(this.A0A.A13()));
        }
        if (this.A00 != null && this.A09 != null && this.A0A.A13() != null) {
            this.A02 = AbstractC1258aO.A03(this.A0A.A15(), EnumC1256aM.A05, this.A0A.A13(), this.A00, A02(this.A0A.A13()), this.A09, this);
            if (this.A0A.A13().A2Q()) {
                this.A02.A0A();
            }
        }
    }

    private void A07() {
        this.A0A.A1O();
        if (C1098Up.A2Z(this.A06)) {
            this.A07.performAccessibilityAction(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
        }
    }

    private void A09(int i3) {
        this.A01 = A00(YM.DEFAULT_INFO_ICON);
        A0A(YM.AD_CHOICES_ICON);
        this.A07.addView(this.A01);
        setIconSizeDp(i3);
        setIconColor(-10459280);
    }

    private void A0A(YM ym) {
        this.A00 = A00(ym);
        this.A00.setContentDescription(A03(0, 9, 53));
        this.A07.addView(this.A00);
    }

    private boolean A0B() {
        return this.A0A.A13() != null && this.A0A.A13().A2Q();
    }

    private boolean A0C() {
        return this.A0A.A13() != null && this.A0A.A13().A2W();
    }

    public final /* synthetic */ void A0D(View view) {
        if (A0B()) {
            if (this.A02 != null) {
                this.A02.A0B();
                return;
            }
            return;
        }
        A07();
    }

    public final void A0E(YM ym) {
        if (this.A01 != null) {
            this.A01.setImageBitmap(YN.A01(ym));
        }
    }

    public final boolean A0F() {
        return this.A03;
    }

    public final boolean A0G() {
        return this.A04;
    }

    public final boolean A0H() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1254aK
    public final void ADW(View view) {
        A07();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.C1018Rm, com.facebook.ads.internal.api.AdComponentView
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (!z2 && this.A02 != null) {
            this.A02.A09();
        }
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconColor(int i3) {
        if (this.A01 != null) {
            this.A01.setColorFilter(i3);
        }
        if (this.A00 != null && !A0B()) {
            this.A00.setColorFilter(i3);
            this.A03 = true;
        }
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconSizeDp(int i3) {
        int iconSize = Math.max(A0D, (int) (XX.A02 * i3));
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(iconSize, iconSize);
        if (this.A01 != null) {
            this.A01.setLayoutParams(iconParams);
        }
        if (this.A00 != null) {
            this.A00.setLayoutParams(iconParams);
            this.A04 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.C1018Rm, com.facebook.ads.internal.api.AdComponentView
    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = -2;
        super.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setOnAdClosedListener(AdClosedListener adClosedListener) {
        this.A0A.A1Y(adClosedListener);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setSingleIcon(boolean z2) {
        if (this.A01 != null) {
            YB.A0O(this.A01, z2 ? 8 : 0);
        }
        this.A05 = true;
    }
}
