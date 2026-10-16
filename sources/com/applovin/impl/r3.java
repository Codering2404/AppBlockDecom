package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class r3 implements o2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o2.a f62721g = new o2.a() { // from class: com.applovin.impl.v30
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return r3.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f62723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f62724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f62725d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62726f;

    public r3(int i3, int i4, int i5, byte[] bArr) {
        this.f62722a = i3;
        this.f62723b = i4;
        this.f62724c = i5;
        this.f62725d = bArr;
    }

    public static int a(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 9) {
            return (i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7) ? 2 : -1;
        }
        return 6;
    }

    private static String c(int i3) {
        return Integer.toString(i3, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && r3.class == obj.getClass()) {
            r3 r3Var = (r3) obj;
            if (this.f62722a == r3Var.f62722a && this.f62723b == r3Var.f62723b && this.f62724c == r3Var.f62724c && Arrays.equals(this.f62725d, r3Var.f62725d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f62726f == 0) {
            this.f62726f = ((((((this.f62722a + 527) * 31) + this.f62723b) * 31) + this.f62724c) * 31) + Arrays.hashCode(this.f62725d);
        }
        return this.f62726f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f62722a);
        sb.append(", ");
        sb.append(this.f62723b);
        sb.append(", ");
        sb.append(this.f62724c);
        sb.append(", ");
        sb.append(this.f62725d != null);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r3 a(Bundle bundle) {
        return new r3(bundle.getInt(c(0), -1), bundle.getInt(c(1), -1), bundle.getInt(c(2), -1), bundle.getByteArray(c(3)));
    }

    public static int b(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 16) {
            return 6;
        }
        if (i3 != 18) {
            return (i3 == 6 || i3 == 7) ? 3 : -1;
        }
        return 7;
    }
}
