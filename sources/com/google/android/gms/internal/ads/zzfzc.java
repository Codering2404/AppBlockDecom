package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfzc {
    final zzfzf zza;
    final boolean zzb;

    private zzfzc(zzfzf zzfzfVar) {
        this.zza = zzfzfVar;
        this.zzb = zzfzfVar != null;
    }

    public static zzfzc zzb(Context context, String str, String str2) {
        zzfzf zzfzdVar;
        try {
            try {
                try {
                    IBinder iBinderD = DynamiteModule.e(context, DynamiteModule.f72395b, ModuleDescriptor.MODULE_ID).d("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderD == null) {
                        zzfzdVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderD.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfzdVar = iInterfaceQueryLocalInterface instanceof zzfzf ? (zzfzf) iInterfaceQueryLocalInterface : new zzfzd(iBinderD);
                    }
                    zzfzdVar.zzj(ObjectWrapper.i5(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfzc(zzfzdVar);
                } catch (Exception e3) {
                    throw new zzfyf(e3);
                }
            } catch (RemoteException | zzfyf | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfzc(new zzfzg());
            }
        } catch (Exception e4) {
            throw new zzfyf(e4);
        }
    }

    public static zzfzc zzc() {
        zzfzg zzfzgVar = new zzfzg();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfzc(zzfzgVar);
    }

    public final zzfzb zza(byte[] bArr) {
        return new zzfzb(this, bArr, null);
    }
}
