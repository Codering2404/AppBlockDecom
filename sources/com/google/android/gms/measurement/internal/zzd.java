package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzd extends zzf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f73533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f73534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f73535d;

    public zzd(zzic zzicVar) {
        super(zzicVar);
        this.f73534c = new ArrayMap();
        this.f73533b = new ArrayMap();
    }

    private final void o(long j3, zzlu zzluVar) {
        if (zzluVar == null) {
            this.f73997a.a().w().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j3 < 1000) {
            this.f73997a.a().w().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j3));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j3);
        zzpp.k0(zzluVar, bundle, true);
        this.f73997a.B().t("am", "_xa", bundle);
    }

    private final void p(String str, long j3, zzlu zzluVar) {
        if (zzluVar == null) {
            this.f73997a.a().w().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j3 < 1000) {
            this.f73997a.a().w().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j3));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j3);
        zzpp.k0(zzluVar, bundle, true);
        this.f73997a.B().t("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void n(long j3) {
        Map map = this.f73533b;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), Long.valueOf(j3));
        }
        if (map.isEmpty()) {
            return;
        }
        this.f73535d = j3;
    }

    public final void i(String str, long j3) {
        if (str == null || str.length() == 0) {
            this.f73997a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f73997a.b().t(new zza(this, str, j3));
        }
    }

    public final void j(String str, long j3) {
        if (str == null || str.length() == 0) {
            this.f73997a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f73997a.b().t(new zzb(this, str, j3));
        }
    }

    public final void k(long j3) {
        zzlu zzluVarQ = this.f73997a.I().q(false);
        Map map = this.f73533b;
        for (String str : map.keySet()) {
            p(str, j3 - ((Long) map.get(str)).longValue(), zzluVarQ);
        }
        if (!map.isEmpty()) {
            o(j3 - this.f73535d, zzluVarQ);
        }
        n(j3);
    }

    final /* synthetic */ void l(String str, long j3) {
        h();
        Preconditions.g(str);
        Map map = this.f73534c;
        if (map.isEmpty()) {
            this.f73535d = j3;
        }
        Integer num = (Integer) map.get(str);
        if (num != null) {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (map.size() >= 100) {
            this.f73997a.a().r().a("Too many ads visible");
        } else {
            map.put(str, 1);
            this.f73533b.put(str, Long.valueOf(j3));
        }
    }

    final /* synthetic */ void m(String str, long j3) {
        h();
        Preconditions.g(str);
        Map map = this.f73534c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            this.f73997a.a().o().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzlu zzluVarQ = this.f73997a.I().q(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            map.put(str, Integer.valueOf(iIntValue));
            return;
        }
        map.remove(str);
        Map map2 = this.f73533b;
        Long l3 = (Long) map2.get(str);
        if (l3 == null) {
            this.f73997a.a().o().a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j3 - l3.longValue();
            map2.remove(str);
            p(str, jLongValue, zzluVarQ);
        }
        if (map.isEmpty()) {
            long j4 = this.f73535d;
            if (j4 == 0) {
                this.f73997a.a().o().a("First ad exposure time was never set");
            } else {
                o(j3 - j4, zzluVarQ);
                this.f73535d = 0L;
            }
        }
    }
}
