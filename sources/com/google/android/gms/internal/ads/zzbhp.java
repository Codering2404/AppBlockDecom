package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzbhv;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhp {
    private final zzbhu zza;
    private final zzbhv.zzt.zza zzb;
    private final boolean zzc;

    private zzbhp() {
        this.zzb = zzbhv.zzt.zzx();
        this.zzc = false;
        this.zza = new zzbhu();
    }

    public static zzbhp zza() {
        return new zzbhp();
    }

    private final synchronized void zzd(int i3) {
        zzbhv.zzt.zza zzaVar = this.zzb;
        zzaVar.zzE();
        zzaVar.zzD(com.google.android.gms.ads.internal.util.zzs.U());
        zzbht zzbhtVar = new zzbht(this.zza, zzaVar.zzbu().zzaN(), null);
        int i4 = i3 - 1;
        zzbhtVar.zzb(i4);
        zzbhtVar.zza();
        com.google.android.gms.ads.internal.util.zze.k("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i4, 10))));
    }

    private final synchronized void zze(int i3) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(zzfzk.zza().zza(externalStorageDirectory, "clearcut_events.txt")), true);
            try {
                try {
                    fileOutputStream.write(zzf(i3).getBytes());
                } catch (IOException unused) {
                    com.google.android.gms.ads.internal.util.zze.k("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        com.google.android.gms.ads.internal.util.zze.k("Could not close Clearcut output stream.");
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    com.google.android.gms.ads.internal.util.zze.k("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused4) {
            com.google.android.gms.ads.internal.util.zze.k("Could not find file for Clearcut");
        }
    }

    private final synchronized String zzf(int i3) {
        zzbhv.zzt.zza zzaVar;
        zzaVar = this.zzb;
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", zzaVar.zzf(), Long.valueOf(com.google.android.gms.ads.internal.zzt.o().a()), Integer.valueOf(i3 - 1), Base64.encodeToString(zzaVar.zzbu().zzaN(), 3));
    }

    public final synchronized void zzb(zzbho zzbhoVar) {
        if (this.zzc) {
            try {
                zzbhoVar.zza(this.zzb);
            } catch (NullPointerException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i3) {
        if (this.zzc) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgf)).booleanValue()) {
                zze(i3);
            } else {
                zzd(i3);
            }
        }
    }

    public zzbhp(zzbhu zzbhuVar) {
        this.zzb = zzbhv.zzt.zzx();
        this.zza = zzbhuVar;
        this.zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzge)).booleanValue();
    }
}
