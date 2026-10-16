package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.internal.gtm.zzro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzek implements Runnable {
    final /* synthetic */ zzro zza;
    final /* synthetic */ zzel zzb;

    zzek(zzel zzelVar, zzro zzroVar) {
        this.zzb = zzelVar;
        this.zza = zzroVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileOutputStream fileOutputStream;
        zzro zzroVar = this.zza;
        File fileZze = this.zzb.zze();
        try {
            try {
                fileOutputStream = new FileOutputStream(fileZze);
                try {
                    zzroVar.zzS(fileOutputStream);
                } catch (IOException unused) {
                    Log.w("GoogleTagManager", "Error writing resource to disk. Removing resource from disk.");
                    fileZze.delete();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        Log.w("GoogleTagManager", "error closing stream for writing resource to disk");
                    }
                }
            } catch (FileNotFoundException unused3) {
                Log.e("GoogleTagManager", "Error opening resource file for writing");
            }
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException unused4) {
                Log.w("GoogleTagManager", "error closing stream for writing resource to disk");
            }
        }
    }
}
