package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f78789a = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzxe f78790b;

    static {
        zzxe zzxfVar;
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                zzxfVar = new zzxf();
                break;
            }
            zzxfVar = null;
            try {
                zzxfVar = (zzxe) Class.forName(f78789a[i3]).asSubclass(zzxe.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzxfVar != null) {
                break;
            } else {
                i3++;
            }
        }
        f78790b = zzxfVar;
    }
}
