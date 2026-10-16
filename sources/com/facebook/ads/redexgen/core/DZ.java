package com.facebook.ads.redexgen.core;

import android.R;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DZ extends RelativeLayout implements InterfaceC1536eu {
    public static byte[] A0B;
    public static String[] A0C = {"QrML4Ecz92sfYCeCtaSnFCosFmipGlTz", "VhmrcYjsqpOA7Iy", "ZK9HRS350jRidth", "ZjYoflRzQYTDfI0m0JAvuVl9vp7GlkSu", "MmC", "ZvQ3uBw3DQ7M1xesozkO3pU9", "XD5i8EmzP8U96tjWoOsk6YaJBmNCgDM7", "cjtQcAKtxYCLU"};
    public static final int A0D;
    public static final int A0E;
    public int A00;
    public int A01;
    public ObjectAnimator A02;
    public C0685Ek A03;
    public boolean A04;
    public boolean A05;
    public final ProgressBar A06;
    public final UN A07;
    public final UN A08;
    public final UN A09;
    public final UN A0A;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        String[] strArr = A0C;
        if (strArr[0].charAt(7) != strArr[6].charAt(7)) {
            throw new RuntimeException();
        }
        A0C[4] = "F3xM2b87YXaGRbor1WnSFNsn05JfW";
        A0B = new byte[]{-5, -3, -6, -14, -3, -16, -2, -2};
    }

    static {
        A03();
        A0D = (int) (XX.A02 * 8.0f);
        A0E = (int) (XX.A02 * 6.0f);
    }

    public DZ(C1648gi c1648gi, int i3) {
        this(c1648gi, A0E, -12549889, 0, i3);
    }

    public DZ(C1648gi c1648gi, int i3, int i4) {
        this(c1648gi, i4, -12549889, 0, i3);
    }

    public DZ(C1648gi c1648gi, int i3, int i4, int i5, int i6) {
        super(c1648gi);
        this.A04 = false;
        this.A01 = -1;
        this.A05 = true;
        this.A0A = new AbstractC0674Dz() { // from class: com.facebook.ads.redexgen.X.33
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4A c4a) {
                if (this.A00.A03 != null) {
                    this.A00.A09(true);
                }
            }
        };
        this.A08 = new E4() { // from class: com.facebook.ads.redexgen.X.31
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4B c4b) {
                this.A00.A02();
            }
        };
        this.A09 = new E2() { // from class: com.facebook.ads.redexgen.X.2z
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(E3 e3) {
                if (this.A00.A03 != null) {
                    this.A00.A09(true);
                }
            }
        };
        this.A07 = new EA() { // from class: com.facebook.ads.redexgen.X.2w
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4K c4k) {
                if (this.A00.A03 != null && this.A00.A05) {
                    this.A00.A06();
                }
            }
        };
        this.A00 = i6;
        this.A06 = new ProgressBar(c1648gi, null, R.attr.progressBarStyleHorizontal);
        A08(i4, i5, false);
        this.A06.setMax(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        addView(this.A06, new RelativeLayout.LayoutParams(-1, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        if (this.A02 != null) {
            this.A02.cancel();
            this.A02.setTarget(null);
            this.A02 = null;
            this.A06.clearAnimation();
        }
    }

    public final void A06() {
        A02();
        this.A02 = ObjectAnimator.ofInt(this.A06, A01(0, 8, 56), 0, 0);
        this.A02.setDuration(0L);
        this.A02.setInterpolator(new LinearInterpolator());
        this.A02.start();
        this.A01 = -1;
    }

    public final void A07(int i3) {
        if (this.A04) {
            return;
        }
        A02();
        int i4 = this.A00;
        int i5 = i4 > 0 ? (i3 * ColorExtractionConstants.MAX_PIXEL_SAMPLES) / i4 : 0;
        int i6 = this.A01;
        int progress = A0C[3].charAt(25);
        if (progress != 112) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[0] = "EPor81PzILPcuU6FixKr7Fru1uzRlGJl";
        strArr[6] = "FnG13n1zUgJ6jZbSKNpX0gvuGbObv9dX";
        if (i6 >= i5 || i4 <= i3) {
            int progress2 = this.A00;
            if (progress2 != -1) {
                int duration = this.A06.getProgress();
                if (duration < 10000) {
                    this.A06.setProgress(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                    return;
                }
                return;
            }
            return;
        }
        ProgressBar progressBar = this.A06;
        int duration2 = this.A01;
        this.A02 = ObjectAnimator.ofInt(progressBar, A01(0, 8, 56), duration2, i5);
        ObjectAnimator objectAnimator = this.A02;
        int duration3 = Math.min(250, i4 - i3);
        objectAnimator.setDuration(duration3);
        this.A02.setInterpolator(new LinearInterpolator());
        this.A02.start();
        this.A01 = i5;
    }

    public final void A08(int i3, int i4, boolean z2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i4);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i3);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        if (z2) {
            gradientDrawable.setCornerRadius(40.0f);
            gradientDrawable2.setCornerRadius(40.0f);
            gradientDrawable3.setCornerRadius(40.0f);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable3, new ScaleDrawable(gradientDrawable2, 8388611, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        this.A06.setProgressDrawable(layerDrawable);
    }

    public final void A09(boolean z2) {
        if (this.A03 == null) {
            return;
        }
        A02();
        int currentPositionInMillis = this.A03.getCurrentPositionInMillis();
        int position = this.A00;
        int duration = position == -1 ? this.A03.getDuration() : this.A00;
        int i3 = duration > 0 ? (currentPositionInMillis * ColorExtractionConstants.MAX_PIXEL_SAMPLES) / duration : 0;
        int position2 = this.A01;
        if (position2 >= i3 || duration <= currentPositionInMillis) {
            int position3 = this.A00;
            if (position3 != -1) {
                ProgressBar progressBar = this.A06;
                String[] strArr = A0C;
                String str = strArr[1];
                String str2 = strArr[2];
                int duration2 = str.length();
                int position4 = str2.length();
                if (duration2 != position4) {
                    throw new RuntimeException();
                }
                A0C[4] = "qF0L9nDi3kEsuJUK3R2iV2qYkdzV6";
                int duration3 = progressBar.getProgress();
                if (duration3 < 10000) {
                    this.A06.setProgress(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                    return;
                }
                return;
            }
            return;
        }
        if (z2) {
            ProgressBar progressBar2 = this.A06;
            int position5 = this.A01;
            this.A02 = ObjectAnimator.ofInt(progressBar2, A01(0, 8, 56), position5, i3);
            ObjectAnimator objectAnimator = this.A02;
            int position6 = Math.min(250, duration - currentPositionInMillis);
            objectAnimator.setDuration(position6);
            this.A02.setInterpolator(new LinearInterpolator());
            this.A02.start();
        } else {
            ProgressBar progressBar3 = this.A06;
            int duration4 = A0C[7].length();
            if (duration4 != 13) {
                progressBar3.setProgress(i3);
            } else {
                A0C[5] = "fU59jt";
                progressBar3.setProgress(i3);
            }
        }
        this.A01 = i3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AAv(C0685Ek c0685Ek) {
        this.A03 = c0685Ek;
        c0685Ek.getEventBus().A03(this.A08, this.A09, this.A0A, this.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AKV(C0685Ek c0685Ek) {
        c0685Ek.getEventBus().A04(this.A0A, this.A09, this.A08, this.A07);
        this.A03 = null;
    }

    public int getCustomDuration() {
        return this.A00;
    }

    public void setCustomDuration(int i3) {
        this.A00 = i3;
    }

    public void setShouldClearAnimationWhenVideoCompleted(boolean z2) {
        this.A05 = z2;
    }
}
