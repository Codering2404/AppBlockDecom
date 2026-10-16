package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdo implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private String zzd = "-1";
    private int zze = -1;

    zzcdo(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzgVar;
        this.zza = context;
    }

    private final void zzb(String str, int i3) {
        Context context;
        boolean z2 = true;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbj)).booleanValue() ? !(str.isEmpty() || str.charAt(0) != '1') : !(i3 == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1")))) {
            z2 = false;
        }
        this.zzc.zzw(z2);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue() && z2 && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    private final void zzc() {
        this.zzc.zzw(true);
        com.google.android.gms.ads.internal.util.zzac.a(this.zza);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbl)).booleanValue()) {
                if (Objects.equals(str, "gad_has_consent_for_cookies")) {
                    int i3 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
                    com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzc;
                    if (i3 != zzgVar.zzD()) {
                        zzc();
                    }
                    zzgVar.b(i3);
                    return;
                }
                if (Objects.equals(str, "IABTCF_TCString")) {
                    String string = sharedPreferences.getString(str, "-1");
                    com.google.android.gms.ads.internal.util.zzg zzgVar2 = this.zzc;
                    if (!Objects.equals(string, zzgVar2.zzB())) {
                        zzc();
                    }
                    zzgVar2.zzA(string);
                    return;
                }
                return;
            }
            String string2 = sharedPreferences.getString("IABTCF_PurposeConsents", "-1");
            int i4 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
            String strValueOf = String.valueOf(str);
            int iHashCode = strValueOf.hashCode();
            if (iHashCode == -2004976699) {
                if (!strValueOf.equals("IABTCF_PurposeConsents") || string2.equals("-1") || this.zzd.equals(string2)) {
                    return;
                }
                this.zzd = string2;
                zzb(string2, i4);
                return;
            }
            if (iHashCode == -527267622 && strValueOf.equals("gad_has_consent_for_cookies")) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbj)).booleanValue() || i4 == -1 || this.zze == i4) {
                    return;
                }
                this.zze = i4;
                zzb(string2, i4);
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "AdMobPlusIdlessListener.onSharedPreferenceChanged");
            com.google.android.gms.ads.internal.util.zze.l("onSharedPreferenceChanged, errorMessage = ", th);
        }
    }

    final void zza() {
        SharedPreferences sharedPreferences = this.zzb;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(sharedPreferences, "gad_has_consent_for_cookies");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbl)).booleanValue()) {
            onSharedPreferenceChanged(sharedPreferences, "IABTCF_TCString");
        } else {
            onSharedPreferenceChanged(sharedPreferences, "IABTCF_PurposeConsents");
        }
    }
}
