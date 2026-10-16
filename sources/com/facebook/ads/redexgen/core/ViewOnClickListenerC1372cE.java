package com.facebook.ads.redexgen.core;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1372cE implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"QT04eFLa9mjEfMLd", "wn7Oy4ZvyPX", "JdVOIkh1rweljXiNlmOrPPxbj76ouIw4", "8", "HoYvJWyWnzW9xQrMEDuDE8k", "", "4NNWhWDRRxnZXe7GAIP6Nv2mv9IaX8G8", "Hy00I9bleYebYRTE8UzaGRkCp9A9i8E3"};
    public final /* synthetic */ KU A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.SUB, Ascii.RS, Ascii.DC2, Ascii.CAN, Ascii.SYN};
    }

    static {
        A01();
    }

    public ViewOnClickListenerC1372cE(KU ku) {
        this.A00 = ku;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.getCtaButton().A0E(A00(0, 5, 69));
        } catch (Throwable th) {
            WU.A00(th, this);
            String[] strArr = A02;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "gqn3ITnmd8SVLq3knr5xxRJ0pveQ6sYL";
            strArr2[7] = "MdUyII5PUBg9MBmNc1g4VKtuuD0LDq6P";
        }
    }
}
