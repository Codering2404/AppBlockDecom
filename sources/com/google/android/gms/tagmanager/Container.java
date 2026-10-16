package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzrv;
import com.google.android.gms.internal.gtm.zzsc;
import com.google.android.gms.internal.gtm.zzsd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class Container {
    private final Context zza;
    private final String zzb;
    private final DataLayer zzc;
    private zzet zzd;
    private volatile long zzg;
    private Map zze = new HashMap();
    private Map zzf = new HashMap();
    private volatile String zzh = "";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    Container(Context context, DataLayer dataLayer, String str, long j3, com.google.android.gms.internal.gtm.zzak zzakVar) {
        this.zza = context;
        this.zzc = dataLayer;
        this.zzb = str;
        this.zzg = j3;
        com.google.android.gms.internal.gtm.zzac zzacVarZzc = zzakVar.zzc();
        zzacVarZzc.getClass();
        try {
            zzg(zzsd.zzb(zzacVarZzc));
        } catch (zzsc e3) {
            Log.e("GoogleTagManager", "Not loading resource: " + zzacVarZzc.toString() + " because it is invalid: " + e3.toString());
        }
        if (zzakVar.zza() != 0) {
            com.google.android.gms.internal.gtm.zzai[] zzaiVarArr = (com.google.android.gms.internal.gtm.zzai[]) zzakVar.zzi().toArray(new com.google.android.gms.internal.gtm.zzai[0]);
            zzet zzetVarZzf = zzf();
            if (zzetVarZzf == null) {
                Log.e("GoogleTagManager", "evaluateTags called for closed container.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.gtm.zzai zzaiVar : zzaiVarArr) {
                arrayList.add(zzaiVar);
            }
            zzetVarZzf.zze(arrayList);
        }
    }

    private final synchronized zzet zzf() {
        return this.zzd;
    }

    private final void zzg(zzrv zzrvVar) {
        this.zzh = zzrvVar.zzb();
        zzh(new zzet((Context) Preconditions.m(this.zza), zzrvVar, (DataLayer) Preconditions.m(this.zzc), new zzu(this, null), new zzw(this, null), new zzdk()));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzc.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", Preconditions.m(this.zzb)));
        }
    }

    private final synchronized void zzh(zzet zzetVar) {
        this.zzd = zzetVar;
    }

    public String getContainerId() {
        return this.zzb;
    }

    public long getLastRefreshTime() {
        return this.zzg;
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    final FunctionCallMacroCallback zza(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zze) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zze.get(str);
        }
        return functionCallMacroCallback;
    }

    public final FunctionCallTagCallback zzb(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzf) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzf.get(str);
        }
        return functionCallTagCallback;
    }

    public final String zzc() {
        return this.zzh;
    }

    final void zze() {
        this.zzd = null;
    }

    public boolean getBoolean(String str) {
        zzet zzetVarZzf = zzf();
        String str2 = jlWo.dAZoTIq;
        if (zzetVarZzf == null) {
            Log.e(str2, "getBoolean called for closed container.");
            zzfu.zze().getClass();
            return false;
        }
        try {
            return zzfu.zzf(zzfu.zzk((com.google.android.gms.internal.gtm.zzam) zzetVarZzf.zza(str).zza())).booleanValue();
        } catch (Exception e3) {
            Log.e(str2, "Calling getBoolean() threw an exception: " + e3.getMessage() + " Returning default value.");
            zzfu.zze().getClass();
            return false;
        }
    }

    public final void zzd(String str) {
        zzet zzetVarZzf = zzf();
        if (zzetVarZzf == null) {
            Log.e(CbYNFSEGaQj.pncctktXhDuOBts, "evaluateTags called for closed container.");
        } else {
            zzetVarZzf.zzc(str);
        }
    }
}
