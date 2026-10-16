package com.facebook.ads.redexgen.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0652Dd extends ImageView implements InterfaceC1536eu {
    public static byte[] A05;
    public static String[] A06 = {"4xWU9o1Qdv49zg4k19WdZrOQJ68qlBKJ", "QfpLWsUkij8dLfBb7Aagb5qXzjDoxZj6", "QolGMRpELvSET2", "SiemLW4oVdpf", "uXL2k0aAaj67psTeNQKHhn5IgBi2NdXT", "OArHsnP", "A54GrsZIV89x3qzJRphed5abiMfcDTpl", "7SQmPw6zIXtGY8y4ylHwiNNuEQdMSmlG"};
    public static final int A07;
    public static final int A08;
    public C0685Ek A00;
    public final Paint A01;
    public final C1648gi A02;
    public final VI A03;
    public final AbstractC0666Dr A04;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-100, -60, -61, -76, 111, -112, -77};
    }

    static {
        A06();
        A08 = (int) (XX.A02 * 40.0f);
        A07 = (int) (XX.A02 * 10.0f);
    }

    public C0652Dd(C1648gi c1648gi, VI vi) {
        super(c1648gi);
        this.A04 = new AbstractC0666Dr() { // from class: com.facebook.ads.redexgen.X.3V
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C0667Ds c0667Ds) {
                this.A00.A09();
            }
        };
        this.A03 = vi;
        this.A02 = c1648gi;
        this.A01 = new Paint();
        this.A01.setColor(Integer.MIN_VALUE);
        setColorFilter(-1);
        setPadding(A07, A07, A07, A07);
        setContentDescription(A03(0, 7, 17));
        A05();
        setOnClickListener(new ViewOnClickListenerC1554fC(this));
    }

    private void A04() {
        setImageBitmap(YN.A01(YM.ICON_MUTE));
    }

    private void A05() {
        setImageBitmap(YN.A01(YM.ICON_UN_MUTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A07() {
        return this.A00 != null && this.A00.getVolume() == 0.0f;
    }

    public final void A09() {
        if (this.A00 == null) {
            return;
        }
        boolean zA07 = A07();
        if (A06[3].length() != 12) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[7] = "aX931uSfPaE8IiOHtPCxhipRkXbTn1t9";
        strArr[4] = "ET7wr0zhj8rUQx1GjBOUHwAZuNFVr5BQ";
        if (zA07) {
            A04();
        } else {
            A05();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AAv(C0685Ek c0685Ek) {
        this.A00 = c0685Ek;
        if (this.A00 != null) {
            this.A00.getEventBus().A05(this.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AKV(C0685Ek c0685Ek) {
        if (this.A00 != null) {
            UM<UN, UL> eventBus = this.A00.getEventBus();
            AbstractC0666Dr abstractC0666Dr = this.A04;
            String[] strArr = A06;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[6] = "f5V50lgekxKfxPRjN4EQZ5T7YD8zyqkA";
            strArr2[1] = "6bYokHrcutoPgrqwaKTDD5vNcVht1LGT";
            eventBus.A06(abstractC0666Dr);
        }
        this.A00 = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        int y2 = getWidth() / 2;
        int x2 = getHeight() / 2;
        canvas.drawCircle(y2, x2, Math.min(y2, x2), this.A01);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int height = A08;
        int width = A08;
        setMeasuredDimension(height, width);
    }
}
