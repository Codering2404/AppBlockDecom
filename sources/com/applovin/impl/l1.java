package com.applovin.impl;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.applovin.impl.o2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class l1 implements o2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l1 f61090g = new b().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o2.a f61091h = new o2.a() { // from class: com.applovin.impl.ty
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return l1.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f61092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f61093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f61094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f61095d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AudioAttributes f61096f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f61097a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f61098b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f61099c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f61100d = 1;

        public b a(int i3) {
            this.f61100d = i3;
            return this;
        }

        public b b(int i3) {
            this.f61097a = i3;
            return this;
        }

        public b c(int i3) {
            this.f61098b = i3;
            return this;
        }

        public b d(int i3) {
            this.f61099c = i3;
            return this;
        }

        public l1 a() {
            return new l1(this.f61097a, this.f61098b, this.f61099c, this.f61100d);
        }
    }

    private l1(int i3, int i4, int i5, int i6) {
        this.f61092a = i3;
        this.f61093b = i4;
        this.f61094c = i5;
        this.f61095d = i6;
    }

    public AudioAttributes a() {
        if (this.f61096f == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f61092a).setFlags(this.f61093b).setUsage(this.f61094c);
            if (xp.f65027a >= 29) {
                usage.setAllowedCapturePolicy(this.f61095d);
            }
            this.f61096f = usage.build();
        }
        return this.f61096f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l1.class == obj.getClass()) {
            l1 l1Var = (l1) obj;
            if (this.f61092a == l1Var.f61092a && this.f61093b == l1Var.f61093b && this.f61094c == l1Var.f61094c && this.f61095d == l1Var.f61095d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f61092a + 527) * 31) + this.f61093b) * 31) + this.f61094c) * 31) + this.f61095d;
    }

    private static String a(int i3) {
        return Integer.toString(i3, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l1 a(Bundle bundle) {
        b bVar = new b();
        if (bundle.containsKey(a(0))) {
            bVar.b(bundle.getInt(a(0)));
        }
        if (bundle.containsKey(a(1))) {
            bVar.c(bundle.getInt(a(1)));
        }
        if (bundle.containsKey(a(2))) {
            bVar.d(bundle.getInt(a(2)));
        }
        if (bundle.containsKey(a(3))) {
            bVar.a(bundle.getInt(a(3)));
        }
        return bVar.a();
    }
}
