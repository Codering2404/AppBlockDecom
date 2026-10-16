package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzceq;
import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzfqg;
import com.google.android.gms.internal.ads.zzhbt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzy implements zzhbt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListenableFuture f70790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzceq f70791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzcej f70792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzfpw f70793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzap f70794e;

    zzy(zzap zzapVar, ListenableFuture listenableFuture, zzceq zzceqVar, zzcej zzcejVar, zzfpw zzfpwVar) {
        this.f70790a = listenableFuture;
        this.f70791b = zzceqVar;
        this.f70792c = zzcejVar;
        this.f70793d = zzfpwVar;
        Objects.requireNonNull(zzapVar);
        this.f70794e = zzapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziG)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.l().zzh(th, "SignalGeneratorImpl.generateSignals");
        } else {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfqg zzfqgVarO5 = zzap.O5(this.f70790a, this.f70791b);
        if (((Boolean) zzbkj.zze.zze()).booleanValue() && zzfqgVarO5 != null) {
            zzfpw zzfpwVar = this.f70793d;
            zzfpwVar.zzj(th);
            zzfpwVar.zzd(false);
            zzfqgVarO5.zza(zzfpwVar);
            zzfqgVarO5.zzh();
        }
        zzcej zzcejVar = this.f70792c;
        if (zzcejVar == null) {
            return;
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 16);
                sb.append("Internal error. ");
                sb.append(message);
                message = sb.toString();
            }
            zzcejVar.zzb(message);
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ListenableFuture listenableFuture = this.f70790a;
        AtomicBoolean atomicBooleanP5 = this.f70794e.p5();
        zzbc zzbcVar = (zzbc) obj;
        zzfqg zzfqgVarO5 = zzap.O5(listenableFuture, this.f70791b);
        atomicBooleanP5.set(true);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziA)).booleanValue()) {
            try {
                zzcej zzcejVar = this.f70792c;
                if (zzcejVar != null) {
                    zzcejVar.zzb("QueryInfo generation has been disabled.");
                }
            } catch (RemoteException e3) {
                String strConcat = "QueryInfo generation has been disabled.".concat(e3.toString());
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.c(strConcat);
            }
            if (!((Boolean) zzbkj.zze.zze()).booleanValue() || zzfqgVarO5 == null) {
                return;
            }
            zzfpw zzfpwVar = this.f70793d;
            zzfpwVar.zzk("QueryInfo generation has been disabled.");
            zzfpwVar.zzd(false);
            zzfqgVarO5.zza(zzfpwVar);
            zzfqgVarO5.zzh();
            return;
        }
        try {
            try {
                if (zzbcVar == null) {
                    zzcej zzcejVar2 = this.f70792c;
                    if (zzcejVar2 != null) {
                        zzcejVar2.zzc(null, null, null);
                    }
                    zzfpw zzfpwVar2 = this.f70793d;
                    zzfpwVar2.zzd(true);
                    if (!((Boolean) zzbkj.zze.zze()).booleanValue() || zzfqgVarO5 == null) {
                        return;
                    }
                    zzfqgVarO5.zza(zzfpwVar2);
                    zzfqgVarO5.zzh();
                    return;
                }
                try {
                    if (TextUtils.isEmpty(new JSONObject(zzbcVar.f70707b).optString("request_id", ""))) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.f("The request ID is empty in request JSON.");
                        zzcej zzcejVar3 = this.f70792c;
                        if (zzcejVar3 != null) {
                            zzcejVar3.zzb("Internal error: request ID is empty in request JSON.");
                        }
                        zzfpw zzfpwVar3 = this.f70793d;
                        zzfpwVar3.zzk("Request ID empty");
                        zzfpwVar3.zzd(false);
                        if (!((Boolean) zzbkj.zze.zze()).booleanValue() || zzfqgVarO5 == null) {
                            return;
                        }
                        zzfqgVarO5.zza(zzfpwVar3);
                        zzfqgVarO5.zzh();
                        return;
                    }
                    Bundle bundle = zzbcVar.f70709d;
                    zzap zzapVar = this.f70794e;
                    if (zzapVar.zzF() && bundle != null && bundle.getInt(zzapVar.j5(), -1) == -1) {
                        bundle.putInt(zzapVar.j5(), zzapVar.k5().get());
                    }
                    if (zzapVar.zzE() && bundle != null && TextUtils.isEmpty(bundle.getString(zzapVar.i5()))) {
                        if (TextUtils.isEmpty(zzapVar.m5())) {
                            zzapVar.n5(com.google.android.gms.ads.internal.zzt.g().P(zzapVar.P5(), zzapVar.l5().f70149a));
                        }
                        bundle.putString(zzapVar.i5(), zzapVar.m5());
                    }
                    zzcej zzcejVar4 = this.f70792c;
                    if (zzcejVar4 != null) {
                        zzcejVar4.zzc(zzbcVar.f70706a, zzbcVar.f70707b, bundle);
                    }
                    this.f70793d.zzd(true);
                    if (!((Boolean) zzbkj.zze.zze()).booleanValue() || zzfqgVarO5 == null) {
                        return;
                    }
                    zzfqgVarO5.zza(this.f70793d);
                    zzfqgVarO5.zzh();
                } catch (JSONException e4) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Failed to create JSON object from the request string.");
                    zzcej zzcejVar5 = this.f70792c;
                    if (zzcejVar5 != null) {
                        String string = e4.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 33);
                        sb.append("Internal error for request JSON: ");
                        sb.append(string);
                        zzcejVar5.zzb(sb.toString());
                    }
                    zzfpw zzfpwVar4 = this.f70793d;
                    zzfpwVar4.zzj(e4);
                    zzfpwVar4.zzd(false);
                    com.google.android.gms.ads.internal.zzt.l().zzg(e4, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (!((Boolean) zzbkj.zze.zze()).booleanValue() || zzfqgVarO5 == null) {
                        return;
                    }
                    zzfqgVarO5.zza(zzfpwVar4);
                    zzfqgVarO5.zzh();
                }
            } catch (RemoteException e5) {
                zzfpw zzfpwVar5 = this.f70793d;
                zzfpwVar5.zzj(e5);
                zzfpwVar5.zzd(false);
                int i6 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
                com.google.android.gms.ads.internal.zzt.l().zzg(e5, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbkj.zze.zze()).booleanValue() || zzfqgVarO5 == null) {
                    return;
                }
                zzfqgVarO5.zza(this.f70793d);
                zzfqgVarO5.zzh();
            }
        } catch (Throwable th) {
            if (((Boolean) zzbkj.zze.zze()).booleanValue() && zzfqgVarO5 != null) {
                zzfqgVarO5.zza(this.f70793d);
                zzfqgVarO5.zzh();
            }
            throw th;
        }
    }
}
