package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzdzg;
import com.google.android.gms.internal.ads.zzdzq;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdzq f70778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map f70779i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f70776f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque f70777g = new ArrayDeque();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f70771a = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhR)).intValue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f70772b = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhS)).longValue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f70773c = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhW)).booleanValue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f70774d = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhV)).booleanValue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f70775e = Collections.synchronizedMap(new zzn(this));

    public zzq(zzdzq zzdzqVar) {
        this.f70778h = zzdzqVar;
    }

    private final synchronized void i() {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
        try {
            Iterator it = this.f70775e.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (jCurrentTimeMillis - ((zzo) entry.getValue()).f70764a.longValue() <= this.f70772b) {
                    break;
                }
                this.f70777g.add(new Pair((String) entry.getKey(), ((zzo) entry.getValue()).f70765b));
                it.remove();
            }
        } catch (ConcurrentModificationException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private final synchronized void j(final zzdzg zzdzgVar) {
        if (this.f70773c) {
            ArrayDeque arrayDeque = this.f70777g;
            final ArrayDeque arrayDequeClone = arrayDeque.clone();
            arrayDeque.clear();
            ArrayDeque arrayDeque2 = this.f70776f;
            final ArrayDeque arrayDequeClone2 = arrayDeque2.clone();
            arrayDeque2.clear();
            zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f70767a.f(zzdzgVar, arrayDequeClone, arrayDequeClone2);
                }
            });
        }
    }

    private final void k(zzdzg zzdzgVar, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdzgVar.zzc());
            this.f70779i = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.f70779i.put("e_r", str);
            this.f70779i.put("e_id", (String) pair2.first);
            if (this.f70774d) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzv.b(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                l(this.f70779i, "e_type", (String) pair.first);
                l(this.f70779i, "e_agent", (String) pair.second);
            }
            this.f70778h.zzb(this.f70779i);
        }
    }

    private static final void l(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    public final synchronized void a(String str, String str2, zzdzg zzdzgVar) {
        this.f70775e.put(str, new zzo(Long.valueOf(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis()), str2, new HashSet()));
        i();
        j(zzdzgVar);
    }

    public final synchronized String b(String str, zzdzg zzdzgVar) {
        zzo zzoVar = (zzo) this.f70775e.get(str);
        zzdzgVar.zzc().put("request_id", str);
        if (zzoVar == null) {
            zzdzgVar.zzc().put("mhit", "false");
            return null;
        }
        zzdzgVar.zzc().put("mhit", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return zzoVar.f70765b;
    }

    public final synchronized void c(String str) {
        this.f70775e.remove(str);
    }

    public final synchronized boolean d(String str, String str2) {
        zzo zzoVar = (zzo) this.f70775e.get(str);
        if (zzoVar != null) {
            if (zzoVar.f70766c.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean e(String str, String str2, int i3) {
        zzo zzoVar = (zzo) this.f70775e.get(str);
        if (zzoVar == null) {
            return false;
        }
        Set set = zzoVar.f70766c;
        set.add(str2);
        return set.size() < i3;
    }

    final /* synthetic */ void f(zzdzg zzdzgVar, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        k(zzdzgVar, arrayDeque, "to");
        k(zzdzgVar, arrayDeque2, "of");
    }

    final /* synthetic */ int g() {
        return this.f70771a;
    }

    final /* synthetic */ ArrayDeque h() {
        return this.f70776f;
    }
}
