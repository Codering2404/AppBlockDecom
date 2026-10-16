package com.facebook.ads.redexgen.core;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1594fq {
    public float A00;
    public EnumC0872Lr A01;
    public Map<String, String> A02;

    public C1594fq(EnumC0872Lr enumC0872Lr) {
        this(enumC0872Lr, 0.0f);
    }

    public C1594fq(EnumC0872Lr enumC0872Lr, float f3) {
        this(enumC0872Lr, f3, null);
    }

    public C1594fq(@Nullable EnumC0872Lr enumC0872Lr, float f3, Map<String, String> windowParams) {
        this.A01 = enumC0872Lr;
        this.A00 = f3;
        if (windowParams != null) {
            this.A02 = windowParams;
        } else {
            this.A02 = new HashMap();
        }
    }

    public final float A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01.A03();
    }

    public final EnumC0872Lr A02() {
        return this.A01;
    }

    public final Map<String, String> A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A01 == EnumC0872Lr.A0I;
    }
}
