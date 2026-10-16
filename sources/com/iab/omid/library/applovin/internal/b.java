package com.iab.omid.library.applovin.internal;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class b extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f92139d = new b();

    private b() {
    }

    public static b g() {
        return f92139d;
    }

    @Override // com.iab.omid.library.applovin.internal.d
    public void b(boolean z2) {
        Iterator<com.iab.omid.library.applovin.adsession.a> it = c.c().b().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(z2);
        }
    }

    @Override // com.iab.omid.library.applovin.internal.d
    public boolean d() {
        Iterator<com.iab.omid.library.applovin.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            View viewC = it.next().c();
            if (viewC != null && viewC.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
