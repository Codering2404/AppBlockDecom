package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdqs {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzfky zzc;
    private final zzdpy zzd;
    private final zzdpt zze;
    private final zzdrg zzf;
    private final zzdro zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzblt zzj;
    private final zzdpq zzk;

    public zzdqs(com.google.android.gms.ads.internal.util.zzg zzgVar, zzfky zzfkyVar, zzdpy zzdpyVar, zzdpt zzdptVar, zzdrg zzdrgVar, zzdro zzdroVar, Executor executor, Executor executor2, zzdpq zzdpqVar) {
        this.zzb = zzgVar;
        this.zzc = zzfkyVar;
        this.zzj = zzfkyVar.zzj;
        this.zzd = zzdpyVar;
        this.zze = zzdptVar;
        this.zzf = zzdrgVar;
        this.zzg = zzdroVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdpqVar;
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i3) {
        if (i3 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i3 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i3 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z2) {
        View viewZzJ = z2 ? this.zze.zzJ() : this.zze.zzK();
        if (viewZzJ == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzJ.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzJ.getParent()).removeView(viewZzJ);
        }
        viewGroup.addView(viewZzJ, ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeK)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    public final void zza(final zzdrq zzdrqVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf(zzdrqVar);
            }
        });
    }

    public final void zzb(zzdrq zzdrqVar) {
        zzdrg zzdrgVar;
        if (zzdrqVar == null || (zzdrgVar = this.zzf) == null || zzdrqVar.zzdA() == null || !this.zzd.zzb()) {
            return;
        }
        try {
            zzdrqVar.zzdA().addView(zzdrgVar.zza());
        } catch (zzclj e3) {
            com.google.android.gms.ads.internal.util.zze.l("web view can not be obtained", e3);
        }
    }

    public final void zzc(zzdrq zzdrqVar) {
        if (zzdrqVar == null) {
            return;
        }
        Context context = zzdrqVar.zzdF().getContext();
        if (com.google.android.gms.ads.internal.util.zzbs.i(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Activity context is needed for policy validator.");
                return;
            }
            zzdro zzdroVar = this.zzg;
            if (zzdroVar == null || zzdrqVar.zzdA() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(zzdroVar.zza(zzdrqVar.zzdA(), windowManager), com.google.android.gms.ads.internal.util.zzbs.k());
            } catch (zzclj e3) {
                com.google.android.gms.ads.internal.util.zze.l("web view can not be obtained", e3);
            }
        }
    }

    public final boolean zzd(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    public final boolean zze(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zzf(com.google.android.gms.internal.ads.zzdrq r11) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqs.zzf(com.google.android.gms.internal.ads.zzdrq):void");
    }

    final /* synthetic */ void zzg(ViewGroup viewGroup) {
        zzdpt zzdptVar = this.zze;
        if (zzdptVar.zzJ() != null) {
            boolean z2 = viewGroup != null;
            if (zzdptVar.zzx() == 2 || zzdptVar.zzx() == 1) {
                this.zzb.k(this.zzc.zzg, String.valueOf(zzdptVar.zzx()), z2);
            } else if (zzdptVar.zzx() == 6) {
                com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzb;
                String str = this.zzc.zzg;
                zzgVar.k(str, "2", z2);
                zzgVar.k(str, AppEventsConstants.EVENT_PARAM_VALUE_YES, z2);
            }
        }
    }
}
