package com.applovin.impl;

import com.applovin.impl.im;
import com.applovin.impl.km;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class y0 implements km.b, im.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f65095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f65096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w0 f65097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f65098d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(w0 w0Var, String str);

        void a(b bVar, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        APP_DETAILS_NOT_FOUND,
        INVALID_DEVELOPER_URI,
        APPADSTXT_NOT_FOUND,
        MISSING_APPLOVIN_ENTRIES,
        MISSING_NON_APPLOVIN_ENTRIES
    }

    public y0(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f65095a = jVar;
        this.f65096b = aVar;
    }

    @Override // com.applovin.impl.im.b
    public void a(b bVar, String str) {
        this.f65096b.a(bVar, str);
    }

    @Override // com.applovin.impl.im.b
    public void a(String str, String str2) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split("\n");
        int length = strArrSplit.length;
        int i3 = 1;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i3 + 1;
            x0 x0Var = new x0(strArrSplit[i4], i3);
            if (x0Var.h()) {
                String strB = x0Var.b();
                List arrayList2 = map.containsKey(strB) ? (List) map.get(strB) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(x0Var);
                    map.put(strB, arrayList2);
                }
            } else {
                arrayList.add(x0Var);
            }
            i4++;
            i3 = i5;
        }
        this.f65097c = new w0(map, arrayList);
        this.f65098d = str2;
        this.f65095a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f65095a.I().a("AppAdsTxtService", "app-ads.txt fetched: " + this.f65097c);
        }
        this.f65096b.a(this.f65097c, str2);
    }

    @Override // com.applovin.impl.km.b
    public void a(b bVar) {
        this.f65096b.a(bVar, (String) null);
    }

    @Override // com.applovin.impl.km.b
    public void a(String str) {
        this.f65095a.i0().a(new im(this.f65095a, str, this));
    }

    public void a() {
        w0 w0Var = this.f65097c;
        if (w0Var != null) {
            this.f65096b.a(w0Var, this.f65098d);
        } else {
            this.f65095a.i0().a(new km(this.f65095a, this));
        }
    }
}
