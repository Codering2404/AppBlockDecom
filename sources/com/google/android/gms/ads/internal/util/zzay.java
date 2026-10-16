package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzata;
import com.google.android.gms.internal.ads.zzate;
import com.google.android.gms.internal.ads.zzath;
import com.google.android.gms.internal.ads.zzatn;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzaua;
import com.google.android.gms.internal.ads.zzauf;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbro;
import com.google.android.gms.internal.ads.zzfzk;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzay extends zzatt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70261a;

    private zzay(Context context, zzats zzatsVar) {
        super(zzatsVar);
        this.f70261a = context;
    }

    public static zzath a(Context context) {
        zzath zzathVar = new zzath(new zzaua(new File(zzfzk.zza().zza(context.getCacheDir(), "admob_volley")), 20971520), new zzay(context, new zzauf(null, null)), 4);
        zzathVar.zza();
        return zzathVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatt, com.google.android.gms.internal.ads.zzasx
    public final zzata zza(zzate zzateVar) throws zzatn {
        if (zzateVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfr), zzateVar.zzh())) {
                Context context = this.f70261a;
                com.google.android.gms.ads.internal.client.zzay.a();
                if (com.google.android.gms.ads.internal.util.client.zzf.G(context, 13400000)) {
                    zzata zzataVarZza = new zzbro(context).zza(zzateVar);
                    if (zzataVarZza != null) {
                        zze.k("Got gmscore asset response: ".concat(String.valueOf(zzateVar.zzh())));
                        return zzataVarZza;
                    }
                    zze.k("Failed to get gmscore asset response: ".concat(String.valueOf(zzateVar.zzh())));
                }
            }
        }
        return super.zza(zzateVar);
    }
}
