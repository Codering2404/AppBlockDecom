package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.internal.ads.zzbiq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f70303a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f70304b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f70305c;

    zzbz(Context context) {
        this.f70305c = context;
    }

    public final void a() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlP)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.g();
            final Map mapI0 = zzs.i0((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlU));
            Iterator it = mapI0.keySet().iterator();
            while (it.hasNext()) {
                c((String) it.next());
            }
            b(new zzbx() { // from class: com.google.android.gms.ads.internal.util.zzby
                @Override // com.google.android.gms.ads.internal.util.zzbx
                public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str, String str2) {
                    Map map = mapI0;
                    if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
                        com.google.android.gms.ads.internal.zzt.l().zzo().zzy(false);
                    }
                }
            });
        }
    }

    final synchronized void b(zzbx zzbxVar) {
        this.f70304b.add(zzbxVar);
    }

    final synchronized void c(String str) {
        try {
            Map map = this.f70303a;
            if (map.containsKey(str)) {
                return;
            }
            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.f70305c) : this.f70305c.getSharedPreferences(str, 0);
            zzbw zzbwVar = new zzbw(this, str);
            map.put(str, zzbwVar);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzbwVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    final /* synthetic */ List d() {
        return this.f70304b;
    }
}
