package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.cc;
import com.applovin.impl.dc;
import com.applovin.impl.rn;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n3 extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f61963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private dc f61964b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f61965f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f61966g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f61967h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f61968i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ List f61969j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list, List list2, List list3, List list4, List list5) {
            super(context);
            this.f61965f = list;
            this.f61966g = list2;
            this.f61967h = list3;
            this.f61968i = list4;
            this.f61969j = list5;
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return c.values().length;
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            List list;
            boolean z2 = true;
            if (i3 == c.MISSING_TC_NETWORKS.ordinal()) {
                list = this.f61965f;
            } else if (i3 == c.MISSING_AC_NETWORKS.ordinal()) {
                list = this.f61966g;
            } else {
                z2 = false;
                list = i3 == c.LISTED_TC_NETWORKS.ordinal() ? this.f61967h : i3 == c.LISTED_AC_NETWORKS.ordinal() ? this.f61968i : this.f61969j;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(n3.this.a((rn) it.next(), z2));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return i3 == c.MISSING_TC_NETWORKS.ordinal() ? this.f61965f.size() : i3 == c.MISSING_AC_NETWORKS.ordinal() ? this.f61966g.size() : i3 == c.LISTED_TC_NETWORKS.ordinal() ? this.f61967h.size() : i3 == c.LISTED_AC_NETWORKS.ordinal() ? this.f61968i.size() : this.f61969j.size();
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return i3 == c.MISSING_TC_NETWORKS.ordinal() ? new fj("MISSING TCF VENDORS (TC STRING)") : i3 == c.MISSING_AC_NETWORKS.ordinal() ? new fj("MISSING ATP NETWORKS (AC STRING)") : i3 == c.LISTED_TC_NETWORKS.ordinal() ? new fj("LISTED TCF VENDORS (TC STRING)") : i3 == c.LISTED_AC_NETWORKS.ordinal() ? new fj("LISTED ATP NETWORKS (AC STRING)") : new fj("NON-CONFIGURABLE NETWORKS");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements dc.a {
        b() {
        }

        @Override // com.applovin.impl.dc.a
        public void a(kb kbVar, cc ccVar) {
            yp.a(ccVar.c(), ccVar.b(), n3.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum c {
        MISSING_TC_NETWORKS,
        MISSING_AC_NETWORKS,
        LISTED_TC_NETWORKS,
        LISTED_AC_NETWORKS,
        OTHER_NETWORKS
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f61963a;
    }

    public void initialize(List<rn> list, List<rn> list2, List<rn> list3, List<rn> list4, List<rn> list5, com.applovin.impl.sdk.j jVar) {
        this.f61963a = jVar;
        a aVar = new a(this, list, list2, list3, list4, list5);
        this.f61964b = aVar;
        aVar.a(new b());
        this.f61964b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Configured CMP Networks");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f61964b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cc a(rn rnVar, boolean z2) {
        cc.b bVarA = cc.a();
        boolean zB = this.f61963a.j0().b();
        rn.a aVarF = rnVar.f();
        rn.a aVar = rn.a.TCF_VENDOR;
        if (aVarF == aVar || (rnVar.f() == rn.a.ATP_NETWORK && zB)) {
            String strC = rnVar.c();
            String str = rnVar.f() == aVar ? "IAB Vendor ID: " : "Google ATP ID: ";
            bVarA.d(strC).d(z2 ? -65536 : -16777216).b(strC).a(str + rnVar.d()).a(true);
        } else {
            bVarA.d(rnVar.b());
        }
        return bVarA.a();
    }
}
