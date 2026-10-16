package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class fh extends ki {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o2.a f59700c = new o2.a() { // from class: com.applovin.impl.uw
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return fh.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f59701b;

    public fh() {
        this.f59701b = -1.0f;
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fh b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 1);
        float f3 = bundle.getFloat(a(1), -1.0f);
        return f3 == -1.0f ? new fh() : new fh(f3);
    }

    public boolean equals(Object obj) {
        return (obj instanceof fh) && this.f59701b == ((fh) obj).f59701b;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.f59701b));
    }

    public fh(float f3) {
        b1.a(f3 >= 0.0f && f3 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f59701b = f3;
    }
}
