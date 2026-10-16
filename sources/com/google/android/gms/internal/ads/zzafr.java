package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzafr implements zzafs {
    static final /* synthetic */ zzafr zza = new zzafr();

    private /* synthetic */ zzafr() {
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final /* synthetic */ Constructor zza() throws IllegalAccessException, InvocationTargetException {
        int i3 = zzafu.zza;
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzafy.class).getConstructor(Integer.TYPE);
        }
        return null;
    }
}
