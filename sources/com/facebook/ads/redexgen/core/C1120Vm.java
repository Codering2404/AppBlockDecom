package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1120Vm {
    public final AdErrorType A00;
    public final String A01;

    public C1120Vm(int i3, String str) {
        this(AdErrorType.adErrorTypeFromCode(i3), str);
    }

    public C1120Vm(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static C1120Vm A00(AdErrorType adErrorType) {
        return new C1120Vm(adErrorType, (String) null);
    }

    public static C1120Vm A01(AdErrorType adErrorType, String str) {
        return new C1120Vm(adErrorType, str);
    }

    public static C1120Vm A02(C1121Vn c1121Vn) {
        return new C1120Vm(c1121Vn.A00(), c1121Vn.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
