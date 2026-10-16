package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfyo implements zzfxj {
    private final Object zza;
    private final zzfyp zzb;
    private final zzfza zzc;
    private final zzfxg zzd;
    private final boolean zze;

    zzfyo(Object obj, zzfyp zzfypVar, zzfza zzfzaVar, zzfxg zzfxgVar, boolean z2) {
        this.zza = obj;
        this.zzb = zzfypVar;
        this.zzc = zzfzaVar;
        this.zzd = zzfxgVar;
        this.zze = z2;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzaze zzazeVarZza = zzazf.zza();
        zzazeVarZza.zzd(5);
        zzazeVarZza.zza(zzida.zzt(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzazf) zzazeVarZza.zzbu()).zzaN(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            obj = this.zza;
        } catch (Exception e3) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e3);
            return null;
        }
        return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(obj, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfxj
    public final synchronized String zza(Context context, String str) {
        byte[] bArrZzj;
        try {
            Map mapZzb = this.zzc.zzb();
            mapZzb.put("f", "q");
            mapZzb.put("ctx", context);
            mapZzb.put("aid", null);
            bArrZzj = zzj(null, mapZzb);
            if (this.zze) {
                mapZzb.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzi(bArrZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxj
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        byte[] bArrZzj;
        try {
            Map mapZzc = this.zzc.zzc();
            mapZzc.put("f", "v");
            mapZzc.put("ctx", context);
            mapZzc.put("aid", null);
            mapZzc.put(ViewHierarchyConstants.VIEW_KEY, view);
            mapZzc.put("act", activity);
            bArrZzj = zzj(null, mapZzc);
            if (this.zze) {
                mapZzc.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzi(bArrZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxj
    public final synchronized String zzc(Context context, String str, String str2, View view, Activity activity) {
        byte[] bArrZzj;
        try {
            Map mapZzd = this.zzc.zzd();
            mapZzd.put("f", "c");
            mapZzd.put("ctx", context);
            mapZzd.put("cs", str2);
            mapZzd.put("aid", null);
            mapZzd.put(ViewHierarchyConstants.VIEW_KEY, view);
            mapZzd.put("act", activity);
            bArrZzj = zzj(null, mapZzd);
            if (this.zze) {
                mapZzd.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzi(bArrZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzfxj
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfyy {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Map mapZze = this.zzc.zze();
            mapZze.put("aid", null);
            mapZze.put("evt", motionEvent);
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("he", Map.class).invoke(obj, mapZze);
            this.zzd.zzb(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e3) {
            throw new zzfyy(2005, e3);
        }
    }

    final zzfyp zze() {
        return this.zzb;
    }

    final synchronized boolean zzf() throws zzfyy {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e3) {
            throw new zzfyy(AdError.INTERNAL_ERROR_CODE, e3);
        }
        return ((Boolean) obj.getClass().getDeclaredMethod("init", null).invoke(obj, null)).booleanValue();
    }

    public final synchronized void zzg() throws zzfyy {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("close", null).invoke(obj, null);
            this.zzd.zzb(AdError.MEDIATION_ERROR_CODE, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e3) {
            throw new zzfyy(AdError.INTERNAL_ERROR_2003, e3);
        }
    }

    public final synchronized int zzh() throws zzfyy {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e3) {
            throw new zzfyy(AdError.INTERNAL_ERROR_2006, e3);
        }
        return ((Integer) obj.getClass().getDeclaredMethod("lcs", null).invoke(obj, null)).intValue();
    }
}
