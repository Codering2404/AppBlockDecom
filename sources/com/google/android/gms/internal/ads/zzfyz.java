package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.AdError;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfyz {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfza zzc;
    private final zzfxg zzd;
    private final zzfxb zze;
    private final boolean zzf;
    private zzfyo zzg;
    private final Object zzh = new Object();

    public zzfyz(Context context, zzfza zzfzaVar, zzfxg zzfxgVar, zzfxb zzfxbVar, boolean z2) {
        this.zzb = context;
        this.zzc = zzfzaVar;
        this.zzd = zzfxgVar;
        this.zze = zzfxbVar;
        this.zzf = z2;
    }

    private final synchronized Class zzd(zzfyp zzfypVar) throws zzfyy {
        try {
            if (zzfypVar.zza() == null) {
                throw new zzfyy(4010, "mc");
            }
            String strZza = zzfypVar.zza().zza();
            HashMap map = zza;
            Class cls = (Class) map.get(strZza);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.zze.zza(zzfypVar.zzb())) {
                    throw new zzfyy(2026, "VM did not pass signature verification");
                }
                try {
                    File fileZzc = zzfypVar.zzc();
                    if (!fileZzc.exists()) {
                        fileZzc.mkdirs();
                    }
                    Class<?> clsLoadClass = new DexClassLoader(zzfypVar.zzb().getAbsolutePath(), fileZzc.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    map.put(strZza, clsLoadClass);
                    return clsLoadClass;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    throw new zzfyy(AdError.REMOTE_ADS_SERVICE_ERROR, e);
                } catch (IllegalArgumentException e4) {
                    e = e4;
                    throw new zzfyy(AdError.REMOTE_ADS_SERVICE_ERROR, e);
                } catch (SecurityException e5) {
                    e = e5;
                    throw new zzfyy(AdError.REMOTE_ADS_SERVICE_ERROR, e);
                }
            } catch (GeneralSecurityException e6) {
                throw new zzfyy(2026, e6);
            }
        } finally {
        }
    }

    public final boolean zza(zzfyp zzfypVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfyo zzfyoVar = new zzfyo(zzd(zzfypVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfypVar.zzd(), null, new Bundle(), 2), zzfypVar, this.zzc, this.zzd, this.zzf);
                if (!zzfyoVar.zzf()) {
                    throw new zzfyy(4000, "init failed");
                }
                int iZzh = zzfyoVar.zzh();
                if (iZzh != 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzh).length() + 4);
                    sb.append("ci: ");
                    sb.append(iZzh);
                    throw new zzfyy(4001, sb.toString());
                }
                synchronized (this.zzh) {
                    zzfyo zzfyoVar2 = this.zzg;
                    if (zzfyoVar2 != null) {
                        try {
                            zzfyoVar2.zzg();
                        } catch (zzfyy e3) {
                            this.zzd.zzc(e3.zza(), -1L, e3);
                        }
                        this.zzg = zzfyoVar;
                    } else {
                        this.zzg = zzfyoVar;
                    }
                }
                this.zzd.zzb(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e4) {
                throw new zzfyy(AdError.INTERNAL_ERROR_2004, e4);
            }
        } catch (zzfyy e5) {
            this.zzd.zzc(e5.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e5);
            return false;
        } catch (Exception e6) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e6);
            return false;
        }
    }

    public final zzfxj zzb() {
        zzfyo zzfyoVar;
        synchronized (this.zzh) {
            zzfyoVar = this.zzg;
        }
        return zzfyoVar;
    }

    public final zzfyp zzc() {
        synchronized (this.zzh) {
            try {
                zzfyo zzfyoVar = this.zzg;
                if (zzfyoVar == null) {
                    return null;
                }
                return zzfyoVar.zze();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
