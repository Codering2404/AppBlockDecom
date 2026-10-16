package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ki implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2.a f61036a = new o2.a() { // from class: com.applovin.impl.ry
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return ki.a(bundle);
        }
    };

    ki() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ki a(Bundle bundle) {
        int i3 = bundle.getInt(a(0), -1);
        if (i3 == 0) {
            return (ki) ma.f61392d.a(bundle);
        }
        if (i3 == 1) {
            return (ki) fh.f59700c.a(bundle);
        }
        if (i3 == 2) {
            return (ki) cl.f58973d.a(bundle);
        }
        if (i3 == 3) {
            return (ki) co.f58983d.a(bundle);
        }
        throw new IllegalArgumentException("Encountered unknown rating type: " + i3);
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }
}
