package com.applovin.impl;

import android.os.Looper;
import com.applovin.impl.a7;
import com.applovin.impl.y6;
import com.applovin.impl.z6;
import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a7 f58214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a7 f58215b;

    static {
        a aVar = new a();
        f58214a = aVar;
        f58215b = aVar;
    }

    int a(e9 e9Var);

    y6 a(Looper looper, z6.a aVar, e9 e9Var);

    default void a() {
    }

    default void b() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements a7 {
        a() {
        }

        @Override // com.applovin.impl.a7
        public y6 a(Looper looper, z6.a aVar, e9 e9Var) {
            if (e9Var.f59397p == null) {
                return null;
            }
            return new t7(new y6.a(new sp(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
        }

        @Override // com.applovin.impl.a7
        public int a(e9 e9Var) {
            return e9Var.f59397p != null ? 1 : 0;
        }
    }

    default b b(Looper looper, z6.a aVar, e9 e9Var) {
        return b.f58216a;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f58216a = new b() { // from class: com.applovin.impl.ks
            @Override // com.applovin.impl.a7.b
            public final void a() {
                a7.b.b();
            }
        };

        void a();

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void b() {
        }
    }
}
