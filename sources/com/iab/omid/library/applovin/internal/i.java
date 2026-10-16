package com.iab.omid.library.applovin.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.applovin.internal.d;
import com.iab.omid.library.applovin.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class i implements d.a, com.iab.omid.library.applovin.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f92158f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f92159a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.applovin.devicevolume.e f92160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.applovin.devicevolume.b f92161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.applovin.devicevolume.d f92162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f92163e;

    public i(com.iab.omid.library.applovin.devicevolume.e eVar, com.iab.omid.library.applovin.devicevolume.b bVar) {
        this.f92160b = eVar;
        this.f92161c = bVar;
    }

    private c a() {
        if (this.f92163e == null) {
            this.f92163e = c.c();
        }
        return this.f92163e;
    }

    public static i c() {
        if (f92158f == null) {
            f92158f = new i(new com.iab.omid.library.applovin.devicevolume.e(), new com.iab.omid.library.applovin.devicevolume.b());
        }
        return f92158f;
    }

    public float b() {
        return this.f92159a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f92162d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f92162d.d();
    }

    @Override // com.iab.omid.library.applovin.devicevolume.c
    public void a(float f3) {
        this.f92159a = f3;
        Iterator<com.iab.omid.library.applovin.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f3);
        }
    }

    public void a(Context context) {
        this.f92162d = this.f92160b.a(new Handler(), context, this.f92161c.a(), this);
    }

    @Override // com.iab.omid.library.applovin.internal.d.a
    public void a(boolean z2) {
        if (z2) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
