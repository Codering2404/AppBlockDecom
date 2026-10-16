package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzr {
    public static final FileOutputStream zza(File file, zzgww zzgwwVar, zzgzi zzgziVar) throws IOException {
        return new FileOutputStream(file, zzgwwVar.contains(zzgzq.APPEND));
    }
}
