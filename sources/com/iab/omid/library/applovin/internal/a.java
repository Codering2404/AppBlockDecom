package com.iab.omid.library.applovin.internal;

import android.content.Context;
import com.iab.omid.library.applovin.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f92133f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.applovin.utils.f f92134a = new com.iab.omid.library.applovin.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f92135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f92136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f92137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f92138e;

    private a(d dVar) {
        this.f92137d = dVar;
    }

    public static a a() {
        return f92133f;
    }

    private void c() {
        if (!this.f92136c || this.f92135b == null) {
            return;
        }
        Iterator<com.iab.omid.library.applovin.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f92135b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f92134a.a();
        Date date = this.f92135b;
        if (date == null || dateA.after(date)) {
            this.f92135b = dateA;
            c();
        }
    }

    public void a(Context context) {
        if (this.f92136c) {
            return;
        }
        this.f92137d.a(context);
        this.f92137d.a(this);
        this.f92137d.e();
        this.f92138e = this.f92137d.c();
        this.f92136c = true;
    }

    @Override // com.iab.omid.library.applovin.internal.d.a
    public void a(boolean z2) {
        if (!this.f92138e && z2) {
            d();
        }
        this.f92138e = z2;
    }
}
