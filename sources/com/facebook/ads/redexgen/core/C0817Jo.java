package com.facebook.ads.redexgen.core;

import android.text.Layout;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0817Jo {
    public static final Comparator<C0817Jo> A02 = new Comparator() { // from class: com.facebook.ads.redexgen.X.Jn
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((C0817Jo) obj2).A00, ((C0817Jo) obj).A00);
        }
    };
    public final int A00;
    public final C2158pT A01;

    public C0817Jo(CharSequence charSequence, Layout.Alignment alignment, float f3, int i3, int i4, float f4, int i5, float f5, boolean z2, int i6, int i7) {
        C04223o cueBuilder = new C04223o().A0G(charSequence).A0F(alignment).A07(f3, i3).A09(i4).A04(f4).A0A(i5).A06(f5);
        if (z2) {
            cueBuilder.A0C(i6);
        }
        this.A01 = cueBuilder.A0H();
        this.A00 = i7;
    }
}
