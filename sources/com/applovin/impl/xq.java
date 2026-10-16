package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class xq implements o2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final xq f65042f = new xq(0, 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o2.a f65043g = new o2.a() { // from class: com.applovin.impl.v80
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return xq.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f65046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f65047d;

    public xq(int i3, int i4) {
        this(i3, i4, 0, 1.0f);
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof xq) {
            xq xqVar = (xq) obj;
            if (this.f65044a == xqVar.f65044a && this.f65045b == xqVar.f65045b && this.f65046c == xqVar.f65046c && this.f65047d == xqVar.f65047d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f65044a + 217) * 31) + this.f65045b) * 31) + this.f65046c) * 31) + Float.floatToRawIntBits(this.f65047d);
    }

    public xq(int i3, int i4, int i5, float f3) {
        this.f65044a = i3;
        this.f65045b = i4;
        this.f65046c = i5;
        this.f65047d = f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ xq a(Bundle bundle) {
        return new xq(bundle.getInt(a(0), 0), bundle.getInt(a(1), 0), bundle.getInt(a(2), 0), bundle.getFloat(a(3), 1.0f));
    }
}
