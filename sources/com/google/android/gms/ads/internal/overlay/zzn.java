package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzdky;
import com.google.android.gms.internal.ads.zzdzl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzn {
    public static final void a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z2, zzdzl zzdzlVar) {
        if (adOverlayInfoParcel.f70051l == 4 && adOverlayInfoParcel.f70043c == null) {
            com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.f70042b;
            if (zzaVar != null) {
                zzaVar.onAdClicked();
            }
            zzdky zzdkyVar = adOverlayInfoParcel.f70061v;
            if (zzdkyVar != null) {
                zzdkyVar.zzdu();
            }
            Activity activityZzj = adOverlayInfoParcel.f70044d.zzj();
            zzc zzcVar = adOverlayInfoParcel.f70041a;
            Context context2 = (zzcVar == null || !zzcVar.f70083k || activityZzj == null) ? context : activityZzj;
            com.google.android.gms.ads.internal.zzt.e();
            zza.b(context2, zzcVar, adOverlayInfoParcel.f70049j, zzcVar != null ? zzcVar.f70082j : null, zzdzlVar, adOverlayInfoParcel.f70057r);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.f70053n.f70152d);
        intent.putExtra("shouldCallOnOverlayOpened", z2);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzoD)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.g();
            com.google.android.gms.ads.internal.util.zzs.D(context, intent, zzdzlVar, adOverlayInfoParcel.f70057r);
        } else {
            com.google.android.gms.ads.internal.zzt.g();
            com.google.android.gms.ads.internal.util.zzs.y(context, intent);
        }
    }
}
