package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.rn;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class nn extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f62090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private dc f62091b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f62092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f62093g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f62094h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, ArrayList arrayList, ArrayList arrayList2, boolean z2) {
            super(context);
            this.f62092f = arrayList;
            this.f62093g = arrayList2;
            this.f62094h = z2;
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return b.values().length;
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            return i3 == b.TC_NETWORKS.ordinal() ? this.f62092f : this.f62093g;
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return i3 == b.TC_NETWORKS.ordinal() ? this.f62092f.size() : this.f62093g.size();
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            if (i3 == b.TC_NETWORKS.ordinal()) {
                return new fj("TCF VENDORS (TC STRING)");
            }
            return new fj(this.f62094h ? "ATP NETWORKS (AC STRING)" : "APPLOVIN PRIVACY SETTING");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum b {
        TC_NETWORKS,
        AC_NETWORKS
    }

    private cc a(String str, String str2) {
        return cc.a().d(str).c(str2).a();
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f62090a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f62090a = jVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strA = a4.b().a(this);
        boolean zB = jVar.j0().b();
        if (!zB) {
            arrayList2.add(a("Has User Consent", strA));
        }
        for (rn rnVar : jVar.j0().i()) {
            Boolean boolA = rnVar.a();
            if (boolA != null) {
                if (rnVar.f() == rn.a.TCF_VENDOR) {
                    arrayList.add(a(rnVar.b(), String.valueOf(boolA)));
                } else if (rnVar.f() == rn.a.ATP_NETWORK) {
                    arrayList2.add(a(rnVar.b(), String.valueOf(boolA)));
                }
            } else if (zB && rnVar.f() == rn.a.ATP_NETWORK) {
                arrayList2.add(a(rnVar.b(), strA));
            }
        }
        a aVar = new a(this, arrayList, arrayList2, zB);
        this.f62091b = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Network Consent Statuses");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f62091b);
    }
}
