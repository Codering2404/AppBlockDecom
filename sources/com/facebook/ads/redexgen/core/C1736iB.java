package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1736iB implements InterfaceC0944Om {
    public final SharedPreferences A00;

    public C1736iB(SharedPreferences sharedPreferences) {
        this.A00 = sharedPreferences;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0944Om
    public final C1737iC A6I() {
        return new C1737iC(this.A00.edit());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0944Om
    public final long A8Q(String str, long j3) {
        return this.A00.getLong(str, j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0944Om
    public final String A9E(String str, String str2) {
        return this.A00.getString(str, str2);
    }
}
