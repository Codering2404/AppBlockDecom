package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfvs {
    private static final zzfvs zza = new zzfvs();
    private WeakReference zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public static zzfvs zza() {
        return zza;
    }

    public final void zzb(Context context) {
        if (context == null) {
            return;
        }
        this.zzb = new WeakReference(context);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(new zzfvr(this), intentFilter);
    }

    public final void zzc() {
        KeyguardManager keyguardManager;
        Context context = (Context) this.zzb.get();
        if (context == null || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null) {
            return;
        }
        boolean zIsDeviceLocked = keyguardManager.isDeviceLocked();
        zzd(this.zzc, zIsDeviceLocked);
        this.zzd = zIsDeviceLocked;
    }

    public final void zzd(boolean z2, boolean z3) {
        if ((z3 || z2) == (this.zzd || this.zzc)) {
            return;
        }
        Iterator it = zzfvi.zza().zze().iterator();
        while (it.hasNext()) {
            ((zzfuo) it.next()).zzg().zzg(z3 || z2);
        }
    }

    final /* synthetic */ void zze(boolean z2) {
        this.zzc = z2;
    }

    final /* synthetic */ boolean zzf() {
        return this.zzd;
    }
}
