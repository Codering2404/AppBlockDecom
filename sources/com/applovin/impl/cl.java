package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class cl extends ki {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f58973d = new o2.a() { // from class: com.applovin.impl.ku
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return cl.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f58974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f58975c;

    public cl(int i3) {
        b1.a(i3 > 0, "maxStars must be a positive integer");
        this.f58974b = i3;
        this.f58975c = -1.0f;
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cl b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 2);
        int i3 = bundle.getInt(a(1), 5);
        float f3 = bundle.getFloat(a(2), -1.0f);
        return f3 == -1.0f ? new cl(i3) : new cl(i3, f3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cl)) {
            return false;
        }
        cl clVar = (cl) obj;
        return this.f58974b == clVar.f58974b && this.f58975c == clVar.f58975c;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f58974b), Float.valueOf(this.f58975c));
    }

    public cl(int i3, float f3) {
        boolean z2 = false;
        b1.a(i3 > 0, "maxStars must be a positive integer");
        if (f3 >= 0.0f && f3 <= i3) {
            z2 = true;
        }
        b1.a(z2, "starRating is out of range [0, maxStars]");
        this.f58974b = i3;
        this.f58975c = f3;
    }
}
