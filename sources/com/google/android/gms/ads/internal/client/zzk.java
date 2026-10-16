package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbvc;
import com.google.android.gms.internal.ads.zzbzy;
import com.google.android.gms.internal.ads.zzcaa;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzk extends RemoteCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzcaa f69963a;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzbu a(Context context, zzr zzrVar, String str, zzbvc zzbvcVar, int i3) {
        zzbiq.zza(context);
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmd)).booleanValue()) {
            try {
                IBinder iBinderX3 = ((zzbv) getRemoteCreatorInstance(context)).x3(ObjectWrapper.i5(context), zzrVar, str, zzbvcVar, ModuleDescriptor.MODULE_VERSION, i3);
                if (iBinderX3 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinderX3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(iBinderX3);
            } catch (RemoteException e3) {
                e = e3;
                com.google.android.gms.ads.internal.util.client.zzo.b("Could not create remote AdManager.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e4) {
                e = e4;
                com.google.android.gms.ads.internal.util.client.zzo.b("Could not create remote AdManager.", e);
                return null;
            }
        }
        try {
            IBinder iBinderX32 = ((zzbv) com.google.android.gms.ads.internal.util.client.zzs.a(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", zzj.f69962a)).x3(ObjectWrapper.i5(context), zzrVar, str, zzbvcVar, ModuleDescriptor.MODULE_VERSION, i3);
            if (iBinderX32 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface2 = iBinderX32.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return iInterfaceQueryLocalInterface2 instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface2 : new zzbs(iBinderX32);
        } catch (RemoteException e5) {
            e = e5;
            Throwable th = e;
            zzcaa zzcaaVarZza = zzbzy.zza(context);
            this.f69963a = zzcaaVarZza;
            zzcaaVarZza.zzh(th, "AdManagerCreator.newAdManagerByDynamiteLoader");
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", th);
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e6) {
            e = e6;
            Throwable th2 = e;
            zzcaa zzcaaVarZza2 = zzbzy.zza(context);
            this.f69963a = zzcaaVarZza2;
            zzcaaVarZza2.zzh(th2, "AdManagerCreator.newAdManagerByDynamiteLoader");
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", th2);
            return null;
        } catch (NullPointerException e7) {
            e = e7;
            Throwable th22 = e;
            zzcaa zzcaaVarZza22 = zzbzy.zza(context);
            this.f69963a = zzcaaVarZza22;
            zzcaaVarZza22.zzh(th22, "AdManagerCreator.newAdManagerByDynamiteLoader");
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", th22);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzbv ? (zzbv) iInterfaceQueryLocalInterface : new zzbv(iBinder);
    }
}
