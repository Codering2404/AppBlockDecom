package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhaq;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzhar implements PrivilegedExceptionAction {
    static final /* synthetic */ zzhar zza = new zzhar();

    private /* synthetic */ zzhar() {
    }

    @Override // java.security.PrivilegedExceptionAction
    public final /* synthetic */ Object run() throws IllegalAccessException {
        int i3 = zzhaq.zzd.zzg;
        for (Field field : Unsafe.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        throw new NoSuchFieldError("the Unsafe");
    }
}
