package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class co extends ki {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f58983d = new o2.a() { // from class: com.applovin.impl.lu
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return co.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f58984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f58985c;

    public co() {
        this.f58984b = false;
        this.f58985c = false;
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static co b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 3);
        return bundle.getBoolean(a(1), false) ? new co(bundle.getBoolean(a(2), false)) : new co();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof co)) {
            return false;
        }
        co coVar = (co) obj;
        return this.f58985c == coVar.f58985c && this.f58984b == coVar.f58984b;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f58984b), Boolean.valueOf(this.f58985c));
    }

    public co(boolean z2) {
        this.f58984b = true;
        this.f58985c = z2;
    }
}
