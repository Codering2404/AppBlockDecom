package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1694hS implements InterfaceC1189Yh {
    public static String[] A01 = {"8tOzOPKLz5DDIwqC88XBXxH90bmVDotF", "YCktuRbEMhZaz9U821mncTHWO05lwCqY", "Eq7g3criU65KDBPK", "XEHycrxPk7FQv1FkL381pmPNBNbKujpl", "niYnM4G6gzmxtC7fq", "sRQOtQAi", "8G5qrnHnaOtx52JqPPi", "6arHmIfqlBfM2iqNpfy3RxuQJelIt1eI"};
    public final WeakReference<C1010Re> A00;

    public C1694hS(C1010Re c1010Re) {
        this.A00 = new WeakReference<>(c1010Re);
    }

    private void A00(C1010Re c1010Re) {
        C1496eF c1496eFA07 = c1010Re.A07();
        if (c1496eFA07 != null && c1010Re.A04() != null) {
            c1010Re.A04().bringChildToFront(c1496eFA07);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1189Yh
    public void A44(View view, int i3, RelativeLayout.LayoutParams layoutParams) {
        C1010Re c1010Re = this.A00.get();
        if (c1010Re != null && c1010Re.A04() != null) {
            c1010Re.A04().addView(view, i3, layoutParams);
            A00(c1010Re);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1189Yh
    public void A45(View view, RelativeLayout.LayoutParams layoutParams) {
        C1010Re c1010Re = this.A00.get();
        if (c1010Re != null && c1010Re.A04() != null) {
            c1010Re.A04().addView(view, layoutParams);
            A00(c1010Re);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1189Yh
    public void A4j(String str) {
        if (this.A00.get() != null) {
            this.A00.get().A0C(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1189Yh
    public void A4k(String str, UL ul) {
        if (this.A00.get() != null) {
            this.A00.get().A0E(str, ul);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1189Yh
    public void AAo(String str, C0918Nm c0918Nm) {
        if (this.A00.get() != null) {
            WeakReference<C1010Re> weakReference = this.A00;
            if (A01[4].length() == 0) {
                throw new RuntimeException();
            }
            A01[2] = "IO1gKUYJJG6YtU6JnI8y";
            weakReference.get().A0D(str, c0918Nm);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1189Yh
    public void ADJ(int i3) {
        C1010Re activityApi = this.A00.get();
        if (activityApi != null) {
            activityApi.finish(i3);
        }
    }
}
