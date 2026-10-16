package com.applovin.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class am extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f58464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Activity f58465i;

    public am(List list, Activity activity, com.applovin.impl.sdk.j jVar) {
        super("TaskAutoInitAdapters", jVar, true);
        this.f58464h = list;
        this.f58465i = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(oe oeVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Auto-initing adapter: " + oeVar);
        }
        this.f65231a.K().b(oeVar, this.f58465i);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f58464h.size() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f65233c;
                String str = this.f65232b;
                StringBuilder sb = new StringBuilder();
                sb.append("Auto-initing ");
                sb.append(this.f58464h.size());
                sb.append(" adapters");
                sb.append(this.f65231a.k0().c() ? " in test mode" : "");
                sb.append("...");
                nVar.a(str, sb.toString());
            }
            if (TextUtils.isEmpty(this.f65231a.N())) {
                this.f65231a.f(AppLovinMediationProvider.MAX);
            } else if (!this.f65231a.y0()) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f65231a.N());
            }
            if (this.f58465i == null) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
            }
            for (final oe oeVar : this.f58464h) {
                if (oeVar.s()) {
                    this.f65231a.i0().a(new Runnable() { // from class: com.applovin.impl.os
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f62383a.a(oeVar);
                        }
                    }, tm.b.MEDIATION);
                } else {
                    this.f65231a.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f65231a.I().a(this.f65232b, "Skipping eager auto-init for adapter " + oeVar);
                    }
                }
            }
        }
    }
}
