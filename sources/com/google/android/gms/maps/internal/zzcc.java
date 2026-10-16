package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f73116a = "zzcc";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f73117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static zzf f73118c;

    public static zzf a(Context context, MapsInitializer.Renderer renderer) throws GooglePlayServicesNotAvailableException {
        Preconditions.m(context);
        Log.d(f73116a, "preferredRenderer: ".concat(String.valueOf(renderer)));
        zzf zzfVar = f73118c;
        if (zzfVar != null) {
            return zzfVar;
        }
        int iH = GooglePlayServicesUtil.h(context, 13400000);
        if (iH != 0) {
            throw new GooglePlayServicesNotAvailableException(iH);
        }
        zzf zzfVarD = d(context, renderer);
        f73118c = zzfVarD;
        try {
            if (zzfVarD.zzd() == 2) {
                try {
                    f73118c.zzm(ObjectWrapper.i5(c(context, renderer)));
                } catch (RemoteException e3) {
                    throw new RuntimeRemoteException(e3);
                } catch (UnsatisfiedLinkError unused) {
                    Log.w(f73116a, "Caught UnsatisfiedLinkError attempting to load the LATEST renderer's native library. Attempting to use the LEGACY renderer instead.");
                    f73117b = null;
                    f73118c = d(context, MapsInitializer.Renderer.LEGACY);
                }
            }
            try {
                zzf zzfVar2 = f73118c;
                Context contextC = c(context, renderer);
                contextC.getClass();
                zzfVar2.y2(ObjectWrapper.i5(contextC.getResources()), 18020000);
                return f73118c;
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        } catch (RemoteException e5) {
            throw new RuntimeRemoteException(e5);
        }
    }

    private static Context b(Exception exc, Context context) {
        Log.e(f73116a, "Failed to load maps module, use pre-Chimera", exc);
        return GooglePlayServicesUtil.e(context);
    }

    private static Context c(Context context, MapsInitializer.Renderer renderer) {
        Context contextB;
        Context context2 = f73117b;
        if (context2 != null) {
            return context2;
        }
        String str = renderer == MapsInitializer.Renderer.LEGACY ? "com.google.android.gms.maps_legacy_dynamite" : "com.google.android.gms.maps_core_dynamite";
        try {
            contextB = DynamiteModule.e(context, DynamiteModule.f72395b, str).b();
        } catch (Exception e3) {
            if (str.equals("com.google.android.gms.maps_dynamite")) {
                contextB = b(e3, context);
            } else {
                try {
                    Log.d(f73116a, "Attempting to load maps_dynamite again.");
                    contextB = DynamiteModule.e(context, DynamiteModule.f72395b, "com.google.android.gms.maps_dynamite").b();
                } catch (Exception e4) {
                    contextB = b(e4, context);
                }
            }
        }
        f73117b = contextB;
        return contextB;
    }

    private static zzf d(Context context, MapsInitializer.Renderer renderer) {
        Log.i(f73116a, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) e(((ClassLoader) Preconditions.m(c(context, renderer).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return iInterfaceQueryLocalInterface instanceof zzf ? (zzf) iInterfaceQueryLocalInterface : new zze(iBinder);
        } catch (ClassNotFoundException e3) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl", e3);
        }
    }

    private static Object e(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unable to call the default constructor of ".concat(cls.getName()), e3);
        } catch (InstantiationException e4) {
            throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(cls.getName()), e4);
        }
    }
}
