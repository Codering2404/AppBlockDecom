package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class f1 extends d1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f59603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f59604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f59605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f59606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final u2 f59607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f59608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a f59609l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(Uri uri);
    }

    public f1(String str, com.applovin.impl.sdk.ad.b bVar, u2 u2Var, com.applovin.impl.sdk.j jVar, a aVar) {
        this(str, bVar, bVar.Y(), true, u2Var, jVar, aVar);
    }

    private void a(Uri uri) {
        a aVar;
        if (this.f59056e.get() || (aVar = this.f59609l) == null) {
            return;
        }
        aVar.a(uri);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean call() {
        if (this.f59056e.get()) {
            return Boolean.FALSE;
        }
        String strA = this.f59608k.A().a(a(), this.f59603f, this.f59604g.getCachePrefix(), this.f59605h, this.f59606i, this.f59607j, this.f59608k.A().a(this.f59603f, this.f59604g));
        if (TextUtils.isEmpty(strA)) {
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.f59056e.get()) {
            return Boolean.FALSE;
        }
        File fileA = this.f59608k.A().a(strA, a());
        if (fileA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f59054c.b(this.f59053b, "Unable to retrieve File for cached filename = " + strA);
            }
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.f59056e.get()) {
            return Boolean.FALSE;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f59054c.b(this.f59053b, "Unable to extract Uri from file");
            }
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.f59056e.get()) {
            return Boolean.FALSE;
        }
        a(uriFromFile);
        return Boolean.TRUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f59603f.equals(((f1) obj).f59603f);
    }

    public int hashCode() {
        String str = this.f59603f;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public f1(String str, com.applovin.impl.sdk.ad.b bVar, List list, boolean z2, u2 u2Var, com.applovin.impl.sdk.j jVar, a aVar) {
        super("AsyncTaskCacheResource", jVar);
        this.f59603f = str;
        this.f59604g = bVar;
        this.f59605h = list;
        this.f59606i = z2;
        this.f59607j = u2Var;
        this.f59608k = jVar;
        this.f59609l = aVar;
    }
}
