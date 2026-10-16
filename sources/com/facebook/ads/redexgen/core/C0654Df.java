package com.facebook.ads.redexgen.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Df, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0654Df extends ImageView implements InterfaceC1536eu {
    public static byte[] A06;
    public static String[] A07 = {"aghB38UhEEJpk0kXnwVgQHJdsNEW", "Z42NiOwJIVHIw0Yvb2zaIIHOyWtQtdjq", "3gFse8uXyFGORzgMyq8kaPi65dxCnZzv", "Jw8apcEAXkOZ3AQdkmgk3jwFJH7gSyWz", "3SkqDykKznuf11rk6OObVQ9S0DbCfrGf", "LUP6WVZdZh28wzzt0Y5b2oxyslCE6YSF", "OrWA41O07SU0jmvClar47c0fhMdTsOQM", "iv"};
    public static final int A08;
    public static final int A09;
    public C0685Ek A00;
    public final Paint A01;
    public final RectF A02;
    public final C1648gi A03;
    public final VI A04;
    public final AbstractC0666Dr A05;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A07[2].charAt(1) == 'n') {
                throw new RuntimeException();
            }
            A07[4] = "46k42TMmXNLOzm12QaWH4fref2fTAqwO";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 73);
            i6++;
        }
    }

    public static void A06() {
        A06 = new byte[]{44, Ascii.DC4, Ascii.NAK, 4, 65, 32, 5};
    }

    static {
        A06();
        A09 = (int) (XX.A02 * 4.0f);
        A08 = (int) (XX.A02 * 6.0f);
    }

    public C0654Df(C1648gi c1648gi, VI vi) {
        this(c1648gi, vi, false);
    }

    public C0654Df(C1648gi c1648gi, VI vi, boolean z2) {
        super(c1648gi);
        this.A05 = new AbstractC0666Dr() { // from class: com.facebook.ads.redexgen.X.3W
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C0667Ds c0667Ds) {
                this.A00.A09();
            }
        };
        this.A04 = vi;
        this.A03 = c1648gi;
        if (z2) {
            this.A02 = new RectF();
        } else {
            this.A02 = null;
        }
        this.A01 = new Paint();
        this.A01.setColor(-1728053248);
        setColorFilter(-1);
        setPadding(A09, A09, A09, A09);
        setContentDescription(A03(0, 7, 40));
        A05();
        setOnClickListener(new ViewOnClickListenerC1553fB(this));
    }

    private void A04() {
        setImageBitmap(YN.A01(YM.SOUND_OFF));
    }

    private void A05() {
        setImageBitmap(YN.A01(YM.SOUND_ON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A07() {
        return this.A00 != null && this.A00.getVolume() == 0.0f;
    }

    public final void A09() {
        if (this.A00 == null) {
            return;
        }
        if (A07()) {
            A04();
        } else {
            A05();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AAv(C0685Ek c0685Ek) {
        this.A00 = c0685Ek;
        if (this.A00 != null) {
            this.A00.getEventBus().A05(this.A05);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AKV(C0685Ek c0685Ek) {
        if (this.A00 != null) {
            this.A00.getEventBus().A06(this.A05);
        }
        this.A00 = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int x2 = getHeight();
        int y2 = x2 / 2;
        if (this.A02 != null) {
            RectF rectF = this.A02;
            int x3 = getWidth();
            float f3 = x3;
            int x4 = getHeight();
            rectF.set(0.0f, 0.0f, f3, x4);
            RectF rectF2 = this.A02;
            int x5 = A08;
            float f4 = x5;
            if (A07[3].charAt(1) == 84) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[5] = "zT7YbptMnSmKw0M5I4XTvaxbvvVXxWiN";
            strArr[1] = "NI8lQWe2kpQIwBdYvxwMMOMmXOv2vWWW";
            int x6 = A08;
            canvas.drawRoundRect(rectF2, f4, x6, this.A01);
        } else {
            int x7 = Math.min(width, y2);
            canvas.drawCircle(width, y2, x7, this.A01);
        }
        super.onDraw(canvas);
    }

    public void setBackgroundPaintColor(int i3) {
        this.A01.setColor(i3);
    }
}
