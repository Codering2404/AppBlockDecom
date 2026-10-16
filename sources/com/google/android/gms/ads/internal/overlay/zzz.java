package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcku;
import com.google.android.gms.internal.ads.zzgqx;
import com.google.android.gms.internal.ads.zzgqy;
import com.google.android.gms.internal.ads.zzgqz;
import com.google.android.gms.internal.ads.zzgra;
import com.google.android.gms.internal.ads.zzgrt;
import com.google.android.gms.internal.ads.zzgrv;
import com.google.android.gms.internal.ads.zzgrw;
import com.google.android.gms.internal.ads.zzgrx;
import com.google.android.gms.internal.ads.zzgry;
import com.google.android.gms.internal.ads.zzgsl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzz {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzgrw f70148f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzcku f70145c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f70147e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f70143a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzgqz f70146d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f70144b = null;

    private final void l() {
        if (this.f70148f == null) {
            this.f70148f = new zzx(this);
        }
    }

    private final zzgry m() {
        zzgrx zzgrxVarZzc = zzgry.zzc();
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmW)).booleanValue() || TextUtils.isEmpty(this.f70144b)) {
            String str = this.f70143a;
            if (str != null) {
                zzgrxVarZzc.zza(str);
            } else {
                g("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgrxVarZzc.zzb(this.f70144b);
        }
        return zzgrxVarZzc.zzc();
    }

    public final synchronized void a(zzcku zzckuVar, Context context) {
        this.f70145c = zzckuVar;
        if (!b(context)) {
            g("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap map = new HashMap();
        map.put("action", "fetch_completed");
        i("on_play_store_bind", map);
    }

    public final synchronized boolean b(Context context) {
        if (!zzgsl.zza(context)) {
            return false;
        }
        try {
            this.f70146d = zzgra.zza(context);
        } catch (NullPointerException e3) {
            com.google.android.gms.ads.internal.util.zze.k("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.f70146d == null) {
            this.f70147e = false;
            return false;
        }
        l();
        this.f70147e = true;
        return true;
    }

    public final void c(zzcku zzckuVar, zzgrt zzgrtVar) {
        if (zzckuVar == null) {
            g("adWebview missing", "onLMDShow");
            return;
        }
        this.f70145c = zzckuVar;
        if (!this.f70147e && !b(zzckuVar.getContext())) {
            g("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzmW)).booleanValue()) {
            this.f70144b = zzgrtVar.zzb();
        }
        l();
        zzgqz zzgqzVar = this.f70146d;
        if (zzgqzVar != null) {
            zzgqzVar.zza(zzgrtVar, this.f70148f);
        }
    }

    public final void d() {
        zzgqz zzgqzVar;
        if (!this.f70147e || (zzgqzVar = this.f70146d) == null) {
            com.google.android.gms.ads.internal.util.zze.k("LastMileDelivery not connected");
        } else {
            zzgqzVar.zzd(m(), this.f70148f);
            h("onLMDOverlayExpand");
        }
    }

    public final void e() {
        zzgqz zzgqzVar;
        if (!this.f70147e || (zzgqzVar = this.f70146d) == null) {
            com.google.android.gms.ads.internal.util.zze.k("LastMileDelivery not connected");
        } else {
            zzgqzVar.zzc(m(), this.f70148f);
            h("onLMDOverlayCollapse");
        }
    }

    public final void f() {
        zzgqz zzgqzVar;
        if (!this.f70147e || (zzgqzVar = this.f70146d) == null) {
            com.google.android.gms.ads.internal.util.zze.k("LastMileDelivery not connected");
            return;
        }
        zzgqx zzgqxVarZzc = zzgqy.zzc();
        if (!((Boolean) zzba.c().zzd(zzbiq.zzmW)).booleanValue() || TextUtils.isEmpty(this.f70144b)) {
            String str = this.f70143a;
            if (str != null) {
                zzgqxVarZzc.zza(str);
            } else {
                g("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgqxVarZzc.zzb(this.f70144b);
        }
        zzgqzVar.zzb(zzgqxVarZzc.zzc(), this.f70148f);
    }

    final void g(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.k(str);
        if (this.f70145c != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            i("onError", map);
        }
    }

    final void h(String str) {
        i(str, new HashMap());
    }

    final void i(final String str, final Map map) {
        zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70140a.k(str, map);
            }
        });
    }

    final void j(zzgrv zzgrvVar) {
        if (!TextUtils.isEmpty(zzgrvVar.zzb())) {
            if (!((Boolean) zzba.c().zzd(zzbiq.zzmW)).booleanValue()) {
                this.f70143a = zzgrvVar.zzb();
            }
        }
        switch (zzgrvVar.zza()) {
            case 8152:
                h("onLMDOverlayOpened");
                break;
            case 8153:
                h("onLMDOverlayClicked");
                break;
            case 8155:
                h("onLMDOverlayClose");
                break;
            case 8157:
                this.f70143a = null;
                this.f70144b = null;
                this.f70147e = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzgrvVar.zza()));
                i("onLMDOverlayFailedToOpen", map);
                break;
        }
    }

    final /* synthetic */ void k(String str, Map map) {
        zzcku zzckuVar = this.f70145c;
        if (zzckuVar != null) {
            zzckuVar.zze(str, map);
        }
    }
}
