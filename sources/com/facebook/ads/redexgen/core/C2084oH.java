package com.facebook.ads.redexgen.core;

import android.os.Looper;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2084oH implements A6 {
    @Override // com.facebook.ads.redexgen.core.A6
    public final /* synthetic */ A5 AH3(A1 a12, C2208qI c2208qI) {
        return A3.A00(this, a12, c2208qI);
    }

    @Override // com.facebook.ads.redexgen.core.A6
    public final /* synthetic */ void AH4() {
    }

    @Override // com.facebook.ads.redexgen.core.A6
    public final InterfaceC05749s A3C(A1 a12, C2208qI c2208qI) {
        if (c2208qI.A0O == null) {
            return null;
        }
        return new C2082oF(new C05729q(new C0577Ab(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
    }

    @Override // com.facebook.ads.redexgen.core.A6
    public final int A7W(C2208qI c2208qI) {
        return c2208qI.A0O != null ? 1 : 0;
    }

    @Override // com.facebook.ads.redexgen.core.A6
    public final void AJe(Looper looper, C8O c8o) {
    }
}
