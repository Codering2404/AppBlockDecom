package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzjy implements zzjv {
    private static zzjy zza;
    private final Context zzb;
    private final ContentObserver zzc;
    private boolean zzd;

    private zzjy() {
        this.zzd = false;
        this.zzb = null;
        this.zzc = null;
    }

    static zzjy zza(Context context) {
        zzjy zzjyVar;
        synchronized (zzjy.class) {
            try {
                if (zza == null) {
                    zza = PermissionChecker.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzjy(context) : new zzjy();
                }
                zzjy zzjyVar2 = zza;
                if (zzjyVar2 != null && zzjyVar2.zzc != null && !zzjyVar2.zzd) {
                    try {
                        context.getContentResolver().registerContentObserver(zzjg.zza, true, zza.zzc);
                        ((zzjy) Preconditions.t(zza)).zzd = true;
                    } catch (SecurityException e3) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e3);
                    }
                }
                zzjyVar = (zzjy) Preconditions.t(zza);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzjyVar;
    }

    static synchronized void zzc() {
        Context context;
        try {
            zzjy zzjyVar = zza;
            if (zzjyVar != null && (context = zzjyVar.zzb) != null && zzjyVar.zzc != null && zzjyVar.zzd) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjv
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final String zze(final String str) {
        Context context = this.zzb;
        if (context != null && !zzjm.zzb(context)) {
            try {
                return (String) zzjv.zzh(new zzju() { // from class: com.google.android.gms.internal.measurement.zzjx
                    @Override // com.google.android.gms.internal.measurement.zzju
                    public final /* synthetic */ Object zza() {
                        return this.zza.zzd(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e3) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e3);
            }
        }
        return null;
    }

    final /* synthetic */ String zzd(String str) {
        return zzjf.zza(((Context) Preconditions.t(this.zzb)).getContentResolver(), str, null);
    }

    private zzjy(Context context) {
        this.zzd = false;
        this.zzb = context;
        this.zzc = new zzjw(this, null);
    }
}
