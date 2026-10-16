package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzboj implements zzbpq {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z]([a-zA-Z0-9]|:|-|_)*$");
    private static final Pattern zzb = Pattern.compile("^[0-9]*(,[0-9]*)*$");

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("No label given for CSI tick.");
                return;
            }
            zzbih zzbihVar = zzbiq.zzcL;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue() && !zza.matcher(str2).matches()) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Invalid label given for CSI tick. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
                return;
            }
            if (TextUtils.isEmpty(str4)) {
                int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("No timestamp given for CSI tick.");
                return;
            }
            try {
                long jA = com.google.android.gms.ads.internal.zzt.o().a() + (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
                if (true == TextUtils.isEmpty(str3)) {
                    str3 = "native:view_load";
                }
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).booleanValue() || zza.matcher(str3).matches()) {
                    zzckuVar.zzq().zzb(str2, str3, jA);
                    return;
                } else {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("Invalid start label given for CSI tick. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
                    return;
                }
            } catch (NumberFormatException e3) {
                int i7 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Malformed timestamp for CSI tick.", e3);
                return;
            }
        }
        if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                int i8 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("No value given for CSI experiment.");
                return;
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcL)).booleanValue() || zzb.matcher(str5).matches()) {
                zzckuVar.zzq().zzc().zzd("e", str5);
                return;
            } else {
                int i9 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Invalid value given for CSI experiment. Should be a comma separated list of numbers.");
                return;
            }
        }
        if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                int i10 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("No value given for CSI extra.");
                return;
            }
            if (TextUtils.isEmpty(str6)) {
                int i11 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("No name given for CSI extra.");
                return;
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcL)).booleanValue() || zza.matcher(str6).matches()) {
                zzckuVar.zzq().zzc().zzd(str6, str7);
            } else {
                int i12 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Invalid name given for CSI extra. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
            }
        }
    }
}
