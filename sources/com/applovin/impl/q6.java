package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class q6 implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q6 f62576d = new q6(0, 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o2.a f62577f = new o2.a() { // from class: com.applovin.impl.e10
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return q6.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f62579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f62580c;

    public q6(int i3, int i4, int i5) {
        this.f62578a = i3;
        this.f62579b = i4;
        this.f62580c = i5;
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q6)) {
            return false;
        }
        q6 q6Var = (q6) obj;
        return this.f62578a == q6Var.f62578a && this.f62579b == q6Var.f62579b && this.f62580c == q6Var.f62580c;
    }

    public int hashCode() {
        return ((((this.f62578a + 527) * 31) + this.f62579b) * 31) + this.f62580c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q6 a(Bundle bundle) {
        return new q6(bundle.getInt(a(0), 0), bundle.getInt(a(1), 0), bundle.getInt(a(2), 0));
    }
}
