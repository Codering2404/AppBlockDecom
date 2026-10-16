package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbaj {
    protected volatile Boolean zzb;
    private final zzbbs zzc;
    private static final ConditionVariable zzd = new ConditionVariable();
    protected static volatile zzfzc zza = null;
    private static volatile Random zze = null;

    public zzbaj(zzbbs zzbbsVar) {
        this.zzc = zzbbsVar;
        zzbbsVar.zzd().execute(new zzbai(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zze == null) {
                synchronized (zzbaj.class) {
                    try {
                        if (zze == null) {
                            zze = new Random();
                        }
                    } finally {
                    }
                }
            }
            return zze.nextInt();
        }
    }

    public final void zza(int i3, int i4, long j3, String str, Exception exc) {
        try {
            zzd.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzaws zzawsVarZza = zzaww.zza();
            zzawsVarZza.zza(this.zzc.zza.getPackageName());
            zzawsVarZza.zzb(j3);
            if (str != null) {
                zzawsVarZza.zze(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzawsVarZza.zzc(stringWriter.toString());
                zzawsVarZza.zzd(exc.getClass().getName());
            }
            zzfzb zzfzbVarZza = zza.zza(((zzaww) zzawsVarZza.zzbu()).zzaN());
            zzfzbVarZza.zzc(i3);
            if (i4 != -1) {
                zzfzbVarZza.zzb(i4);
            }
            zzfzbVarZza.zza();
        } catch (Exception unused) {
        }
    }

    final /* synthetic */ zzbbs zzb() {
        return this.zzc;
    }
}
