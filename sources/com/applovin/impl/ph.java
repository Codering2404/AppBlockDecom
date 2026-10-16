package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ph implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ph f62438d = new ph(1.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o2.a f62439f = new o2.a() { // from class: com.applovin.impl.r00
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return ph.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f62440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f62441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f62442c;

    public ph(float f3) {
        this(f3, 1.0f);
    }

    public long a(long j3) {
        return j3 * ((long) this.f62442c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ph.class == obj.getClass()) {
            ph phVar = (ph) obj;
            if (this.f62440a == phVar.f62440a && this.f62441b == phVar.f62441b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.f62440a) + 527) * 31) + Float.floatToRawIntBits(this.f62441b);
    }

    public String toString() {
        return xp.a("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f62440a), Float.valueOf(this.f62441b));
    }

    public ph(float f3, float f4) {
        b1.a(f3 > 0.0f);
        b1.a(f4 > 0.0f);
        this.f62440a = f3;
        this.f62441b = f4;
        this.f62442c = Math.round(f3 * 1000.0f);
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ph a(Bundle bundle) {
        return new ph(bundle.getFloat(a(0), 1.0f), bundle.getFloat(a(1), 1.0f));
    }

    public ph a(float f3) {
        return new ph(f3, this.f62441b);
    }
}
