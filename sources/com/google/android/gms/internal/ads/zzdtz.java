package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdtz extends zzbsd implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzblo {
    private View zza;
    private com.google.android.gms.ads.internal.client.zzea zzb;
    private zzdpo zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdtz(zzdpo zzdpoVar, zzdpt zzdptVar) {
        this.zza = zzdptVar.zzJ();
        this.zzb = zzdptVar.zzy();
        this.zzc = zzdpoVar;
        if (zzdptVar.zzT() != null) {
            zzdptVar.zzT().zzax(this);
        }
    }

    private final void zzg() {
        View view = this.zza;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zza);
        }
    }

    private final void zzh() {
        View view;
        zzdpo zzdpoVar = this.zzc;
        if (zzdpoVar == null || (view = this.zza) == null) {
            return;
        }
        Map map = Collections.EMPTY_MAP;
        zzdpoVar.zzu(view, map, map, zzdpo.zzI(view));
    }

    private static final void zzi(zzbsh zzbshVar, int i3) {
        try {
            zzbshVar.zzf(i3);
        } catch (RemoteException e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzh();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzblo
    public final void zza() {
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdty
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    this.zza.zzc();
                } catch (RemoteException e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final com.google.android.gms.ads.internal.client.zzea zzb() throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.c("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void zzc() throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzg();
        zzdpo zzdpoVar = this.zzc;
        if (zzdpoVar != null) {
            zzdpoVar.zzd();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void zzd(IObjectWrapper iObjectWrapper, zzbsh zzbshVar) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Instream ad can not be shown after destroy().");
            zzi(zzbshVar, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            String str = view == null ? "can not get video view." : "can not get video controller.";
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Instream internal error: ".concat(str));
            zzi(zzbshVar, 0);
            return;
        }
        if (this.zze) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Instream ad should not be used again.");
            zzi(zzbshVar, 1);
            return;
        }
        this.zze = true;
        zzg();
        ((ViewGroup) ObjectWrapper.h5(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
        com.google.android.gms.ads.internal.zzt.c();
        zzcge.zza(this.zza, this);
        com.google.android.gms.ads.internal.zzt.c();
        zzcge.zzb(this.zza, this);
        zzh();
        try {
            zzbshVar.zze();
        } catch (RemoteException e3) {
            int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzd(iObjectWrapper, new zzdtx(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final zzbmb zzf() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdpo zzdpoVar = this.zzc;
        if (zzdpoVar == null || zzdpoVar.zzP() == null) {
            return null;
        }
        return zzdpoVar.zzP().zza();
    }
}
