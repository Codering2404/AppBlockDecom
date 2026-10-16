package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfc extends RemoteCreator {
    public zzfc() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final zzcy a(Context context) {
        try {
            IBinder iBinderX3 = ((zzcz) getRemoteCreatorInstance(context)).x3(ObjectWrapper.i5(context), ModuleDescriptor.MODULE_VERSION);
            if (iBinderX3 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderX3.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return iInterfaceQueryLocalInterface instanceof zzcy ? (zzcy) iInterfaceQueryLocalInterface : new zzcw(iBinderX3);
        } catch (RemoteException e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e4) {
            e = e4;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzcz ? (zzcz) iInterfaceQueryLocalInterface : new zzcz(iBinder);
    }
}
