package com.applovin.impl;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ae {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends xd {
        public a(xd xdVar) {
            super(xdVar);
        }

        public a b(Object obj) {
            return new a(super.a(obj));
        }

        public a(Object obj) {
            super(obj);
        }

        public a(Object obj, int i3, int i4, long j3) {
            super(obj, i3, i4, j3);
        }

        public a(Object obj, long j3, int i3) {
            super(obj, j3, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(ae aeVar, fo foVar);
    }

    sd a();

    vd a(a aVar, n0 n0Var, long j3);

    void a(Handler handler, be beVar);

    void a(Handler handler, z6 z6Var);

    void a(b bVar);

    void a(b bVar, xo xoVar);

    void a(be beVar);

    void a(vd vdVar);

    void a(z6 z6Var);

    void b();

    void b(b bVar);

    void c(b bVar);

    default boolean c() {
        return true;
    }

    default fo d() {
        return null;
    }
}
