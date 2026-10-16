package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2063nv implements InterfaceC0646Cx {
    public static String[] A07 = {"KBisateWM8YQ4arKDgRYpdTDxezzMkCv", "VJ2uSooodcJBZOLyoDYKaqw5tYDrMz4W", "bemaZsDF2tY6J54Bg3tOUH55klLpC", "LnVxhCvG0lD6F7ZPu", "7ofy39p1yDzqV7NnIWFVVnn8VzEJdml2", "3pklWVRHTZe0TjeZrFE3TnxhkITdP", "TfKHOeXRiNIOMg3PDS", "WMeybOD3P6lu5fyh7Idh"};
    public Looper A00;
    public Timeline A01;
    public C8O A02;
    public final ArrayList<InterfaceC0645Cw> A05 = new ArrayList<>(1);
    public final HashSet<InterfaceC0645Cw> A06 = new HashSet<>(1);
    public final D8 A04 = new D8();
    public final A1 A03 = new A1();

    public abstract void A09();

    public abstract void A0A(InterfaceC04795t interfaceC04795t);

    public final C8O A00() {
        return (C8O) AbstractC04323y.A02(this.A02);
    }

    public final A1 A01(C2056no c2056no) {
        return this.A03.A00(0, c2056no);
    }

    public final D8 A02(C2056no c2056no) {
        return this.A04.A02(0, c2056no, 0L);
    }

    public void A03() {
    }

    public void A04() {
    }

    public final void A05(Timeline timeline) {
        this.A01 = timeline;
        Iterator<InterfaceC0645Cw> it = this.A05.iterator();
        while (it.hasNext()) {
            it.next().AG1(this, timeline);
        }
    }

    public final void A06(InterfaceC0645Cw interfaceC0645Cw) {
        boolean z2 = !this.A06.isEmpty();
        this.A06.remove(interfaceC0645Cw);
        if (z2) {
            boolean wasEnabled = this.A06.isEmpty();
            if (wasEnabled) {
                A03();
            }
        }
    }

    public final void A07(InterfaceC0645Cw interfaceC0645Cw) {
        AbstractC04323y.A01(this.A00);
        boolean zIsEmpty = this.A06.isEmpty();
        this.A06.add(interfaceC0645Cw);
        if (zIsEmpty) {
            A04();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A08(com.facebook.ads.redexgen.core.InterfaceC0645Cw r4, com.facebook.ads.redexgen.core.InterfaceC04795t r5, com.facebook.ads.redexgen.core.C8O r6) {
        /*
            r3 = this;
            android.os.Looper r2 = android.os.Looper.myLooper()
            android.os.Looper r0 = r3.A00
            if (r0 == 0) goto Lc
            android.os.Looper r0 = r3.A00
            if (r0 != r2) goto L31
        Lc:
            r0 = 1
        Ld:
            com.facebook.ads.redexgen.core.AbstractC04323y.A07(r0)
            r3.A02 = r6
            com.facebook.ads.androidx.media3.common.Timeline r1 = r3.A01
            java.util.ArrayList<com.facebook.ads.redexgen.X.Cw> r0 = r3.A05
            r0.add(r4)
            android.os.Looper r0 = r3.A00
            if (r0 != 0) goto L28
            r3.A00 = r2
            java.util.HashSet<com.facebook.ads.redexgen.X.Cw> r0 = r3.A06
            r0.add(r4)
            r3.A0A(r5)
        L27:
            return
        L28:
            if (r1 == 0) goto L27
            r3.A07(r4)
            r4.AG1(r3, r1)
            goto L27
        L31:
            r0 = 0
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2063nv.A08(com.facebook.ads.redexgen.X.Cw, com.facebook.ads.redexgen.X.5t, com.facebook.ads.redexgen.X.8O):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0646Cx
    public final void A3z(Handler handler, D9 d9) {
        AbstractC04323y.A01(handler);
        AbstractC04323y.A01(d9);
        this.A04.A04(handler, d9);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0646Cx
    public final void AH7(InterfaceC0645Cw interfaceC0645Cw, InterfaceC04795t interfaceC04795t) {
        A08(interfaceC0645Cw, interfaceC04795t, C8O.A03);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0646Cx
    public final void AHl(InterfaceC0645Cw interfaceC0645Cw) {
        this.A05.remove(interfaceC0645Cw);
        if (this.A05.isEmpty()) {
            this.A00 = null;
            this.A01 = null;
            this.A02 = null;
            this.A06.clear();
            String[] strArr = A07;
            if (strArr[2].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[3] = "pnZ7WVnnf2PAl7J7h";
            strArr2[6] = "ddcJoNElLz9Uvwup8w";
            A09();
            return;
        }
        A06(interfaceC0645Cw);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0646Cx
    public final void AIS(D9 d9) {
        this.A04.A0D(d9);
    }
}
