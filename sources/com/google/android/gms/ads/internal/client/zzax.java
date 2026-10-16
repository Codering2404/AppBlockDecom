package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzbkz;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzco f69828a;

    static {
        zzco zzcmVar = null;
        try {
            Object objNewInstance = zzaw.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(null).newInstance(null);
            if (objNewInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) objNewInstance;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                zzcmVar = iInterfaceQueryLocalInterface instanceof zzco ? (zzco) iInterfaceQueryLocalInterface : new zzcm(iBinder);
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.f("ClientApi class is not an instance of IBinder.");
            }
        } catch (Exception unused) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Failed to instantiate ClientApi class.");
        }
        f69828a = zzcmVar;
    }

    zzax() {
    }

    private final Object e() {
        zzco zzcoVar = f69828a;
        if (zzcoVar == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return c(zzcoVar);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke local loader using ClientApi class.", e3);
            return null;
        }
    }

    private final Object f() {
        try {
            return b();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke remote loader.", e3);
            return null;
        }
    }

    protected abstract Object a();

    protected abstract Object b();

    protected abstract Object c(zzco zzcoVar);

    public final Object d(Context context, boolean z2) {
        boolean z3;
        Object objE;
        if (!z2) {
            zzay.a();
            if (!com.google.android.gms.ads.internal.util.client.zzf.G(context, 12451000)) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Google Play Services is not available.");
                z2 = true;
            }
        }
        boolean z4 = false;
        boolean z5 = !(DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.c(context, ModuleDescriptor.MODULE_ID));
        zzbiq.zza(context);
        if (((Boolean) zzbkl.zza.zze()).booleanValue()) {
            z3 = false;
        } else {
            boolean z6 = z2 | z5;
            if (((Boolean) zzbkl.zzb.zze()).booleanValue()) {
                z3 = true;
                z4 = true;
            } else {
                z4 = z6;
                z3 = false;
            }
        }
        if (z4) {
            objE = e();
            if (objE == null && !z3) {
                objE = f();
            }
        } else {
            Object objF = f();
            if (objF == null) {
                if (zzay.h().nextInt(((Long) zzbkz.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzay.a().t(context, zzay.g().f70149a, "gmob-apps", bundle, true);
                }
            }
            objE = objF == null ? e() : objF;
        }
        return objE == null ? a() : objE;
    }
}
