package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyy extends RemoteCreator {
    public zzbyy() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzbze ? (zzbze) iInterfaceQueryLocalInterface : new zzbzc(iBinder);
    }

    public final zzbzb zza(Activity activity) {
        try {
            IBinder iBinderZze = ((zzbze) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.i5(activity));
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return iInterfaceQueryLocalInterface instanceof zzbzb ? (zzbzb) iInterfaceQueryLocalInterface : new zzbyz(iBinderZze);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote AdOverlay.", e3);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not create remote AdOverlay.", e4);
            return null;
        }
    }
}
