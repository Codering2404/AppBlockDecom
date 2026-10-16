package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ma extends ki {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f61392d = new o2.a() { // from class: com.applovin.impl.oz
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return ma.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f61393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f61394c;

    public ma() {
        this.f61393b = false;
        this.f61394c = false;
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ma b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 0);
        return bundle.getBoolean(a(1), false) ? new ma(bundle.getBoolean(a(2), false)) : new ma();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ma)) {
            return false;
        }
        ma maVar = (ma) obj;
        return this.f61394c == maVar.f61394c && this.f61393b == maVar.f61393b;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f61393b), Boolean.valueOf(this.f61394c));
    }

    public ma(boolean z2) {
        this.f61393b = true;
        this.f61394c = z2;
    }
}
