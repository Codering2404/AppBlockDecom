package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbvc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl extends RemoteCreator {
    public zzl() {
        super("com.google.android.gms.ads.AdPreloaderRemoteCreatorImpl");
    }

    public final zzch a(Context context, zzbvc zzbvcVar) {
        try {
            IBinder iBinderX3 = ((zzci) getRemoteCreatorInstance(context)).x3(ObjectWrapper.i5(context), zzbvcVar, ModuleDescriptor.MODULE_VERSION);
            if (iBinderX3 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderX3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
            return iInterfaceQueryLocalInterface instanceof zzch ? (zzch) iInterfaceQueryLocalInterface : new zzcf(iBinderX3);
        } catch (RemoteException e3) {
            e = e3;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote AdPreloaderCreator.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e4) {
            e = e4;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote AdPreloaderCreator.", e);
            return null;
        } catch (NullPointerException e5) {
            e = e5;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not get remote AdPreloaderCreator.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloaderCreator");
        return iInterfaceQueryLocalInterface instanceof zzci ? (zzci) iInterfaceQueryLocalInterface : new zzci(iBinder);
    }
}
