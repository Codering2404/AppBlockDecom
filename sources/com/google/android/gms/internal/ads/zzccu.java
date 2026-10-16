package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzccu {
    public static final zzcci zza(Context context, String str, zzbvc zzbvcVar) {
        try {
            IBinder iBinderZze = ((zzccm) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzcct.zza)).zze(ObjectWrapper.i5(context), str, zzbvcVar, ModuleDescriptor.MODULE_VERSION);
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return iInterfaceQueryLocalInterface instanceof zzcci ? (zzcci) iInterfaceQueryLocalInterface : new zzccg(iBinderZze);
        } catch (RemoteException e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e);
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e4) {
            e = e4;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e);
            return null;
        }
    }
}
