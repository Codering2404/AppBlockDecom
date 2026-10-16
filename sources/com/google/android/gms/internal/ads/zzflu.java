package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzflu {
    private static zzflu zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcv zzc;
    private final AtomicReference zzd = new AtomicReference();

    zzflu(Context context, com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
        this.zzb = context;
        this.zzc = zzcvVar;
    }

    public static zzflu zza(Context context) {
        synchronized (zzflu.class) {
            try {
                zzflu zzfluVar = zza;
                if (zzfluVar != null) {
                    return zzfluVar;
                }
                Context applicationContext = context.getApplicationContext();
                long jLongValue = ((Long) zzbkr.zzb.zze()).longValue();
                com.google.android.gms.ads.internal.client.zzcv zzcvVarZzf = null;
                if (jLongValue > 0 && jLongValue <= 261210000) {
                    zzcvVarZzf = zzf(applicationContext);
                }
                zzflu zzfluVar2 = new zzflu(applicationContext, zzcvVarZzf);
                zza = zzfluVar2;
                return zzfluVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static com.google.android.gms.ads.internal.client.zzcv zzf(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzcu.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to retrieve lite SDK info.", e3);
            return null;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzez zzg() {
        com.google.android.gms.ads.internal.client.zzcv zzcvVar = this.zzc;
        if (zzcvVar != null) {
            try {
                return zzcvVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final VersionInfoParcel zzb(int i3, boolean z2, int i4) {
        com.google.android.gms.ads.internal.client.zzez zzezVarZzg;
        com.google.android.gms.ads.internal.zzt.g();
        boolean zH = com.google.android.gms.ads.internal.util.zzs.h(this.zzb);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i4, true, zH);
        return (((Boolean) zzbkr.zzc.zze()).booleanValue() && (zzezVarZzg = zzg()) != null) ? new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, zzezVarZzg.zza(), true, zH) : versionInfoParcel;
    }

    public final void zzc(zzbvc zzbvcVar) {
        zzbvc adapterCreator;
        if (!((Boolean) zzbkr.zza.zze()).booleanValue()) {
            androidx.compose.animation.core.h.a(this.zzd, null, zzbvcVar);
            return;
        }
        com.google.android.gms.ads.internal.client.zzcv zzcvVar = this.zzc;
        if (zzcvVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzcvVar.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference = this.zzd;
        if (adapterCreator != null) {
            zzbvcVar = adapterCreator;
        }
        androidx.compose.animation.core.h.a(atomicReference, null, zzbvcVar);
    }

    public final zzbvc zzd() {
        return (zzbvc) this.zzd.get();
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzez zzezVarZzg = zzg();
        if (zzezVarZzg != null) {
            return zzezVarZzg.zzb();
        }
        return null;
    }
}
