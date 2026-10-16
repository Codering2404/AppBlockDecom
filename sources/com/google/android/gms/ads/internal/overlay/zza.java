package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzdzl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza {
    public static final boolean a(Context context, Intent intent, zzad zzadVar, zzaa zzaaVar, boolean z2, zzdzl zzdzlVar, String str, Bundle bundle) {
        if (z2) {
            return c(context, intent.getData(), zzadVar, zzaaVar, bundle);
        }
        try {
            String uri = intent.toURI();
            StringBuilder sb = new StringBuilder(String.valueOf(uri).length() + 21);
            sb.append("Launching an intent: ");
            sb.append(uri);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            if (((Boolean) zzba.c().zzd(zzbiq.zzoD)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.g();
                com.google.android.gms.ads.internal.util.zzs.D(context, intent, zzdzlVar, str);
            } else {
                com.google.android.gms.ads.internal.zzt.g();
                com.google.android.gms.ads.internal.util.zzs.y(context, intent);
            }
            if (zzadVar != null) {
                zzadVar.zzl();
            }
            if (zzaaVar != null) {
                zzaaVar.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e3) {
            String message = e3.getMessage();
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(message);
            if (zzaaVar != null) {
                zzaaVar.zza(false);
            }
            return false;
        }
    }

    public static final boolean b(Context context, zzc zzcVar, zzad zzadVar, zzaa zzaaVar, zzdzl zzdzlVar, String str) {
        int i3 = 0;
        if (zzcVar == null) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("No intent data for launcher overlay.");
            return false;
        }
        zzbiq.zza(context);
        Intent intent = zzcVar.f70081i;
        if (intent != null) {
            return a(context, intent, zzadVar, zzaaVar, zzcVar.f70083k, zzdzlVar, str, zzcVar.f70084l);
        }
        Intent intent2 = new Intent();
        String str2 = zzcVar.f70075b;
        if (TextUtils.isEmpty(str2)) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Open GMSG did not contain a URL.");
            return false;
        }
        String str3 = zzcVar.f70076c;
        if (TextUtils.isEmpty(str3)) {
            intent2.setData(Uri.parse(str2));
        } else {
            intent2.setDataAndType(Uri.parse(str2), str3);
        }
        intent2.setAction("android.intent.action.VIEW");
        String str4 = zzcVar.f70077d;
        if (!TextUtils.isEmpty(str4)) {
            intent2.setPackage(str4);
        }
        String str5 = zzcVar.f70078f;
        if (!TextUtils.isEmpty(str5)) {
            String[] strArrSplit = str5.split("/", 2);
            if (strArrSplit.length < 2) {
                int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse component name from open GMSG: ".concat(str5));
                return false;
            }
            intent2.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str6 = zzcVar.f70079g;
        if (!TextUtils.isEmpty(str6)) {
            try {
                i3 = Integer.parseInt(str6);
            } catch (NumberFormatException unused) {
                int i7 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse intent flags.");
            }
            intent2.addFlags(i3);
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzfx)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzba.c().zzd(zzbiq.zzfw)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.g();
                com.google.android.gms.ads.internal.util.zzs.b0(context, intent2);
            }
        }
        return a(context, intent2, zzadVar, zzaaVar, zzcVar.f70083k, zzdzlVar, str, zzcVar.f70084l);
    }

    private static final boolean c(Context context, Uri uri, zzad zzadVar, zzaa zzaaVar, Bundle bundle) {
        int iY;
        try {
            iY = com.google.android.gms.ads.internal.zzt.g().Y(context, uri, bundle);
            if (zzadVar != null) {
                zzadVar.zzl();
            }
        } catch (ActivityNotFoundException e3) {
            String message = e3.getMessage();
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(message);
            iY = 6;
        }
        if (zzaaVar != null) {
            zzaaVar.zzb(iY);
        }
        return iY == 5;
    }
}
