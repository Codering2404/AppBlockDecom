package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.cc;
import com.applovin.impl.dc;
import com.applovin.impl.r;
import com.applovin.impl.rn;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerCmpNetworksListActivity;
import com.applovin.mediation.MaxDebuggerTcfStringActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pn extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f62444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private dc f62445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f62446c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f62447d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f62448f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f62449g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f62450h = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return e.values().length;
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            return i3 == e.IAB_TCF_PARAMETERS.ordinal() ? pn.this.c() : pn.this.a();
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return i3 == e.IAB_TCF_PARAMETERS.ordinal() ? d.values().length : c.values().length;
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return i3 == e.IAB_TCF_PARAMETERS.ordinal() ? new fj("IAB TCF Parameters") : new fj("CMP CONFIGURATION");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements dc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qn f62452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f62453b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a implements r.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f62455a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f62456b;

            a(String str, String str2) {
                this.f62455a = str;
                this.f62456b = str2;
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTcfStringActivity maxDebuggerTcfStringActivity) {
                maxDebuggerTcfStringActivity.initialize(this.f62455a, this.f62456b, b.this.f62453b);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.pn$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0115b implements r.b {
            C0115b() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerCmpNetworksListActivity maxDebuggerCmpNetworksListActivity) {
                maxDebuggerCmpNetworksListActivity.initialize(pn.this.f62448f, pn.this.f62449g, pn.this.f62446c, pn.this.f62447d, pn.this.f62450h, b.this.f62453b);
            }
        }

        b(qn qnVar, com.applovin.impl.sdk.j jVar) {
            this.f62452a = qnVar;
            this.f62453b = jVar;
        }

        @Override // com.applovin.impl.dc.a
        public void a(kb kbVar, cc ccVar) {
            String strA;
            String strC;
            if (kbVar.b() != e.IAB_TCF_PARAMETERS.ordinal()) {
                if (kbVar.a() == c.CONFIGURED_NETWORKS.ordinal()) {
                    r.a(pn.this, MaxDebuggerCmpNetworksListActivity.class, this.f62453b.e(), new C0115b());
                    return;
                } else {
                    yp.a(ccVar.c(), ccVar.b(), pn.this);
                    return;
                }
            }
            if (kbVar.a() == d.TC_STRING.ordinal()) {
                strA = uj.f64243s.a();
                strC = this.f62452a.k();
            } else {
                strA = uj.f64244t.a();
                strC = this.f62452a.c();
            }
            r.a(pn.this, MaxDebuggerTcfStringActivity.class, this.f62453b.e(), new a(strA, strC));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum c {
        CMP_SDK_ID,
        CMP_SDK_VERSION,
        INSTRUCTIONS,
        CONFIGURED_NETWORKS
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum d {
        GDPR_APPLIES,
        TC_STRING,
        AC_STRING
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum e {
        IAB_TCF_PARAMETERS,
        CMP_CONFIGURATION
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f62444a;
    }

    public void initialize(com.applovin.impl.sdk.j jVar) {
        this.f62444a = jVar;
        qn qnVarJ0 = jVar.j0();
        a(qnVarJ0.i());
        a aVar = new a(this);
        this.f62445b = aVar;
        aVar.a(new b(qnVarJ0, jVar));
        this.f62445b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("CMP (Consent Management Platform)");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f62445b);
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dc dcVar = this.f62445b;
        if (dcVar != null) {
            dcVar.a((dc.a) null);
        }
    }

    private void a(rn rnVar, List list) {
        if (rnVar.d() != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (rnVar.d().equals(((rn) it.next()).d())) {
                    return;
                }
            }
        }
        list.add(rnVar);
    }

    private cc b() {
        cc.b bVarA;
        String strA = uj.f64240p.a();
        Integer numE = this.f62444a.j0().e();
        if (StringUtils.isValidString(this.f62444a.j0().d())) {
            bVarA = cc.a(cc.c.RIGHT_DETAIL);
        } else {
            cc.b bVarB = cc.a(cc.c.DETAIL).b("Unknown CMP SDK ID");
            bVarA = bVarB.a("Your integrated CMP might not be Google-certified. " + ("SharedPreferences value for key " + strA + " is " + numE + ".") + "\n\nIf you use Google AdMob or Google Ad Manager, make sure that the integrated CMP is included in the list of Google-certified CMPs at: https://support.google.com/admob/answer/13554116").a(R.drawable.applovin_ic_warning).b(t3.a(R.color.applovin_sdk_warningColor, this)).a(true);
        }
        bVarA.d(strA);
        bVarA.c(numE != null ? numE.toString() : "No value set");
        bVarA.c(numE != null ? -16777216 : -65536);
        return bVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(d.values().length);
        Integer numG = this.f62444a.j0().g();
        String strK = this.f62444a.j0().k();
        String strC = this.f62444a.j0().c();
        arrayList.add(a(uj.f64242r.a(), numG));
        arrayList.add(a(uj.f64243s.a(), strK, !tn.b(strK)));
        arrayList.add(a(uj.f64244t.a(), strC, false));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        String str;
        ArrayList arrayList = new ArrayList(c.values().length);
        int size = this.f62448f.size() + this.f62449g.size();
        arrayList.add(b());
        arrayList.add(a(uj.f64241q.a(), this.f62444a.j0().f()));
        arrayList.add(cc.a(cc.c.DETAIL).d("To check which networks are missing from your CMP, first make sure that you have granted consent to all networks through your CMP flow. Then add the following networks to your CMP network list.").a());
        cc.b bVarD = cc.a(cc.c.RIGHT_DETAIL).d("Configured CMP Networks");
        if (size > 0) {
            str = "Missing " + size + " network(s)";
        } else {
            str = "";
        }
        arrayList.add(bVarD.c(str).c(size > 0 ? -65536 : -16777216).a(this).a(true).a());
        return arrayList;
    }

    private cc a(String str, String str2, boolean z2) {
        boolean zIsValidString = StringUtils.isValidString(str2);
        if (zIsValidString && str2.length() > 35) {
            str2 = str2.substring(0, 35) + "...";
        }
        cc.b bVarD = cc.a(cc.c.DETAIL).d(str);
        if (!zIsValidString) {
            str2 = "No value set";
        }
        cc.b bVarA = bVarD.c(str2).c(z2 ? -65536 : -16777216).a(zIsValidString);
        if (zIsValidString) {
            bVarA.a(this);
        }
        return bVarA.a();
    }

    private cc a(String str, Integer num) {
        return cc.a(cc.c.RIGHT_DETAIL).d(str).c(num != null ? num.toString() : "No value set").c(num != null ? -16777216 : -65536).a();
    }

    private void a(List list) {
        boolean zB = this.f62444a.j0().b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rn rnVar = (rn) it.next();
            if (rnVar.f() == rn.a.TCF_VENDOR) {
                if (Boolean.TRUE.equals(rnVar.a())) {
                    a(rnVar, this.f62446c);
                } else {
                    a(rnVar, this.f62448f);
                }
            } else if (rnVar.f() != rn.a.ATP_NETWORK) {
                this.f62450h.add(rnVar);
            } else if (zB) {
                if (Boolean.TRUE.equals(rnVar.a())) {
                    a(rnVar, this.f62447d);
                } else {
                    a(rnVar, this.f62449g);
                }
            } else {
                this.f62450h.add(rnVar);
            }
        }
    }
}
