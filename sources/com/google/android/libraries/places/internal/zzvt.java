package com.google.android.libraries.places.internal;

import android.os.Build;
import dalvik.system.VMStack;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzvt extends zzvn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f78699b = zza.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f78700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzvm f78701d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class zza {
        zza() {
        }

        static boolean a() {
            return zzvt.h();
        }
    }

    static {
        String str = Build.FINGERPRINT;
        boolean z2 = true;
        if (str != null && !"robolectric".equals(str)) {
            z2 = false;
        }
        f78700c = z2;
        f78701d = new zzvm() { // from class: com.google.android.libraries.places.internal.zzvt.1
        };
    }

    static boolean h() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", null);
            return zza.class.getName().equals(i());
        } catch (Throwable unused) {
            return false;
        }
    }

    static String i() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzvn
    protected zzup c(String str) {
        return zzvy.d(str);
    }

    @Override // com.google.android.libraries.places.internal.zzvn
    protected zzwd e() {
        return zzvz.c();
    }
}
