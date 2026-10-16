package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class po implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final po f62471d = new po(new oo[0]);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o2.a f62472f = new o2.a() { // from class: com.applovin.impl.s00
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return po.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final oo[] f62474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f62475c;

    public po(oo... ooVarArr) {
        this.f62474b = ooVarArr;
        this.f62473a = ooVarArr.length;
    }

    public oo a(int i3) {
        return this.f62474b[i3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && po.class == obj.getClass()) {
            po poVar = (po) obj;
            if (this.f62473a == poVar.f62473a && Arrays.equals(this.f62474b, poVar.f62474b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f62475c == 0) {
            this.f62475c = Arrays.hashCode(this.f62474b);
        }
        return this.f62475c;
    }

    private static String b(int i3) {
        return Integer.toString(i3, 36);
    }

    public int a(oo ooVar) {
        for (int i3 = 0; i3 < this.f62473a; i3++) {
            if (this.f62474b[i3] == ooVar) {
                return i3;
            }
        }
        return -1;
    }

    public boolean a() {
        return this.f62473a == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ po a(Bundle bundle) {
        return new po((oo[]) p2.a(oo.f62349d, bundle.getParcelableArrayList(b(0)), db.h()).toArray(new oo[0]));
    }
}
