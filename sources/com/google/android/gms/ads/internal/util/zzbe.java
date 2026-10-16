package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f70270a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f70271b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f70272c = new ArrayList();

    public final zzbe a(String str, double d3, double d4) {
        List list;
        int i3 = 0;
        while (true) {
            list = this.f70270a;
            if (i3 >= list.size()) {
                break;
            }
            double dDoubleValue = ((Double) this.f70272c.get(i3)).doubleValue();
            double dDoubleValue2 = ((Double) this.f70271b.get(i3)).doubleValue();
            if (d3 < dDoubleValue || (dDoubleValue == d3 && d4 < dDoubleValue2)) {
                break;
            }
            i3++;
        }
        list.add(i3, str);
        this.f70272c.add(i3, Double.valueOf(d3));
        this.f70271b.add(i3, Double.valueOf(d4));
        return this;
    }

    public final zzbf b() {
        return new zzbf(this, null);
    }

    final /* synthetic */ List c() {
        return this.f70270a;
    }

    final /* synthetic */ List d() {
        return this.f70271b;
    }

    final /* synthetic */ List e() {
        return this.f70272c;
    }
}
