package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjk;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzcy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57549a = 0;

    static {
        int i3 = zzcz.f57550a;
    }

    public static String a(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + com.google.android.gms.internal.play_billing.zzbm.zzc(exc.getMessage());
            int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static zziw b(zzjd zzjdVar, int i3, BillingResult billingResult, String str, zzjk zzjkVar) {
        try {
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(billingResult.c());
            zzjbVarZza.zzb(billingResult.a());
            if (billingResult.b() != 0) {
                zzjbVarZza.zzd(billingResult.b());
            }
            if (zzjdVar != null) {
                zzjbVarZza.zze(zzjdVar);
            }
            if (str != null) {
                zzjbVarZza.zza(str);
            }
            zziu zziuVarZza = zziw.zza();
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(i3);
            if (!zzjkVar.equals(zzjk.BROADCAST_ACTION_UNSPECIFIED)) {
                zziuVarZza.zza(zzjkVar);
            }
            return (zziw) zziuVarZza.zzi();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzja c(int i3, zzjk zzjkVar) {
        try {
            zziy zziyVarZza = zzja.zza();
            zziyVarZza.zze(i3);
            if (!zzjkVar.equals(zzjk.BROADCAST_ACTION_UNSPECIFIED)) {
                zziyVarZza.zza(zzjkVar);
            }
            return (zzja) zziyVarZza.zzi();
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", e3);
            return null;
        }
    }
}
