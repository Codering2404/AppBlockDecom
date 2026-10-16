package com.google.android.gms.maps.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zza {
    public static byte a(Boolean bool) {
        if (bool != null) {
            return !bool.booleanValue() ? (byte) 0 : (byte) 1;
        }
        return (byte) -1;
    }

    public static Boolean b(byte b3) {
        if (b3 == 0) {
            return Boolean.FALSE;
        }
        if (b3 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }
}
