package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcak;
import com.google.android.gms.internal.ads.zzcdn;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public final class zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f70390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcdn f70391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcak f70392d = new zzcak(false, Collections.EMPTY_LIST);

    public zzb(Context context, zzcdn zzcdnVar, zzcak zzcakVar) {
        this.f70389a = context;
        this.f70391c = zzcdnVar;
    }

    private final boolean d() {
        zzcdn zzcdnVar = this.f70391c;
        return (zzcdnVar != null && zzcdnVar.zza().zzf) || this.f70392d.zza;
    }

    public final void a() {
        this.f70390b = true;
    }

    public final boolean b() {
        return !d() || this.f70390b;
    }

    public final void c(String str) {
        List<String> list;
        if (d()) {
            if (str == null) {
                str = "";
            }
            zzcdn zzcdnVar = this.f70391c;
            if (zzcdnVar != null) {
                zzcdnVar.zze(str, null, 3);
                return;
            }
            zzcak zzcakVar = this.f70392d;
            if (!zzcakVar.zza || (list = zzcakVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.f70389a;
                    zzt.g();
                    com.google.android.gms.ads.internal.util.zzs.o(context, "", strReplace);
                }
            }
        }
    }
}
