package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzvn f78690a = b(zzvn.f78691a);

    private static zzvn b(String[] strArr) {
        zzvt zzvtVar;
        try {
            zzvtVar = zzvu.f78702a;
        } catch (NoClassDefFoundError unused) {
            zzvtVar = null;
        }
        if (zzvtVar != null) {
            return zzvtVar;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzvn) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
