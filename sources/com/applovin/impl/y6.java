package com.applovin.impl;

import com.applovin.impl.z6;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface y6 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65158a;

        public a(Throwable th, int i3) {
            super(th);
            this.f65158a = i3;
        }
    }

    static void a(y6 y6Var, y6 y6Var2) {
        if (y6Var == y6Var2) {
            return;
        }
        if (y6Var2 != null) {
            y6Var2.b(null);
        }
        if (y6Var != null) {
            y6Var.a((z6.a) null);
        }
    }

    void a(z6.a aVar);

    boolean a(String str);

    int b();

    void b(z6.a aVar);

    boolean c();

    Map d();

    UUID e();

    y4 f();

    a getError();
}
