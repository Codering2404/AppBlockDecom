package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzhbt;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzz implements zzhbt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbzq f70795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f70796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzap f70797c;

    zzz(zzap zzapVar, zzbzq zzbzqVar, boolean z2) {
        this.f70795a = zzbzqVar;
        this.f70796b = z2;
        Objects.requireNonNull(zzapVar);
        this.f70797c = zzapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        try {
            zzbzq zzbzqVar = this.f70795a;
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 16);
            sb.append("Internal error: ");
            sb.append(message);
            zzbzqVar.zzf(sb.toString());
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.f70795a.zze(arrayList);
            zzap zzapVar = this.f70797c;
            if (!zzapVar.zzC() && !this.f70796b) {
                return;
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                Uri uri = (Uri) obj2;
                if (zzapVar.D5(uri)) {
                    zzapVar.h5().zzb(zzap.B5(uri, zzapVar.o5(), AppEventsConstants.EVENT_PARAM_VALUE_YES).toString(), null, null, null);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziw)).booleanValue()) {
                        zzapVar.h5().zzb(uri.toString(), null, null, null);
                    }
                }
            }
        } catch (RemoteException e3) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }
}
