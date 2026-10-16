package com.applovin.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.dc;
import com.applovin.impl.r;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.se;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.mediation.MaxDebuggerUnifiedFlowActivity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class qe extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private se f62609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DataSetObserver f62610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f62611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ListView f62612d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o f62613f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            qe.this.a();
            qe qeVar = qe.this;
            qeVar.b((Context) qeVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements dc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f62615a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a implements r.b {
            a() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerUnifiedFlowActivity maxDebuggerUnifiedFlowActivity) {
                maxDebuggerUnifiedFlowActivity.initialize(qe.this.f62609a.s());
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.qe$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0119b implements r.b {
            C0119b() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                maxDebuggerTcfInfoListActivity.initialize(qe.this.f62609a.s());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class c implements r.b {
            c() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                maxDebuggerTcfConsentStatusesListActivity.initialize(qe.this.f62609a.s());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class d implements r.b {
            d() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(qe.this.f62609a.e(), false, qe.this.f62609a.s());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class e implements r.b {
            e() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                maxDebuggerTestLiveNetworkActivity.initialize(qe.this.f62609a.j(), qe.this.f62609a.u(), qe.this.f62609a.s());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class f implements r.b {
            f() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                maxDebuggerTestModeNetworkActivity.initialize(qe.this.f62609a.t(), qe.this.f62609a.s());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class g implements r.b {
            g() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(qe.this.f62609a.n(), true, qe.this.f62609a.s());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class h implements r.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ cc f62624a;

            h(cc ccVar) {
                this.f62624a = ccVar;
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                maxDebuggerDetailActivity.initialize(((bg) this.f62624a).r());
            }
        }

        b(q qVar) {
            this.f62615a = qVar;
        }

        @Override // com.applovin.impl.dc.a
        public void a(kb kbVar, cc ccVar) {
            int iB = kbVar.b();
            if (iB == se.e.APP_INFO.ordinal()) {
                yp.a(ccVar.c(), ccVar.b(), qe.this);
                return;
            }
            if (iB == se.e.MAX.ordinal()) {
                if (qe.this.f62609a.a(ccVar)) {
                    r.a(qe.this, MaxDebuggerUnifiedFlowActivity.class, this.f62615a, new a());
                    return;
                } else {
                    yp.a(ccVar.c(), ccVar.b(), qe.this);
                    return;
                }
            }
            if (iB == se.e.PRIVACY.ordinal()) {
                if (kbVar.a() != se.d.CMP.ordinal()) {
                    if (kbVar.a() == se.d.NETWORK_CONSENT_STATUSES.ordinal()) {
                        r.a(qe.this, MaxDebuggerTcfConsentStatusesListActivity.class, this.f62615a, new c());
                        return;
                    }
                    return;
                } else if (StringUtils.isValidString(qe.this.f62609a.s().j0().k())) {
                    r.a(qe.this, MaxDebuggerTcfInfoListActivity.class, this.f62615a, new C0119b());
                    return;
                } else {
                    yp.a(ccVar.c(), ccVar.b(), qe.this);
                    return;
                }
            }
            if (iB != se.e.ADS.ordinal()) {
                if ((iB == se.e.MICRO_SDK_PARTNER_NETWORKS.ordinal() || iB == se.e.INCOMPLETE_NETWORKS.ordinal() || iB == se.e.COMPLETED_NETWORKS.ordinal()) && (ccVar instanceof bg)) {
                    r.a(qe.this, MaxDebuggerDetailActivity.class, this.f62615a, new h(ccVar));
                    return;
                }
                return;
            }
            if (kbVar.a() == se.b.AD_UNITS.ordinal()) {
                if (qe.this.f62609a.e().size() > 0) {
                    r.a(qe.this, MaxDebuggerAdUnitsListActivity.class, this.f62615a, new d());
                    return;
                } else {
                    yp.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", qe.this);
                    return;
                }
            }
            if (kbVar.a() == se.b.SELECT_LIVE_NETWORKS.ordinal()) {
                if (qe.this.f62609a.j().size() <= 0 && qe.this.f62609a.u().size() <= 0) {
                    yp.a("Complete Integrations", "Please complete integrations in order to access this.", qe.this);
                    return;
                } else if (qe.this.f62609a.s().k0().c()) {
                    yp.a("Restart Required", ccVar.b(), qe.this);
                    return;
                } else {
                    r.a(qe.this, MaxDebuggerTestLiveNetworkActivity.class, this.f62615a, new e());
                    return;
                }
            }
            if (kbVar.a() != se.b.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                if (kbVar.a() == se.b.INITIALIZATION_AD_UNITS.ordinal()) {
                    r.a(qe.this, MaxDebuggerAdUnitsListActivity.class, this.f62615a, new g());
                }
            } else if (!qe.this.f62609a.s().k0().c()) {
                qe.this.getSdk().k0().a();
                yp.a("Restart Required", ccVar.b(), qe.this);
            } else if (qe.this.f62609a.t().size() > 0) {
                r.a(qe.this, MaxDebuggerTestModeNetworkActivity.class, this.f62615a, new f());
            } else {
                yp.a("Complete Integrations", "Please complete integrations in order to access this.", qe.this);
            }
        }
    }

    private void c() {
        a();
        o oVar = new o(this, 50, R.attr.progressBarStyleLarge);
        this.f62613f = oVar;
        oVar.setColor(-3355444);
        this.f62611c.addView(this.f62613f, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f62611c.bringChildToFront(this.f62613f);
        this.f62613f.a();
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        se seVar = this.f62609a;
        if (seVar != null) {
            return seVar.s();
        }
        return null;
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(com.applovin.sdk.R.layout.mediation_debugger_list_view);
        this.f62611c = (FrameLayout) findViewById(R.id.content);
        ListView listView = (ListView) findViewById(com.applovin.sdk.R.id.listView);
        this.f62612d = listView;
        listView.setAdapter((ListAdapter) this.f62609a);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.applovin.sdk.R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        se seVar = this.f62609a;
        if (seVar != null) {
            seVar.unregisterDataSetObserver(this.f62610b);
            this.f62609a.a((dc.a) null);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.applovin.sdk.R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        b();
        return true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        se seVar = this.f62609a;
        if (seVar == null || seVar.v()) {
            return;
        }
        c();
    }

    public void setListAdapter(se seVar, q qVar) {
        DataSetObserver dataSetObserver;
        se seVar2 = this.f62609a;
        if (seVar2 != null && (dataSetObserver = this.f62610b) != null) {
            seVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f62609a = seVar;
        this.f62610b = new a();
        b((Context) this);
        this.f62609a.registerDataSetObserver(this.f62610b);
        this.f62609a.a(new b(qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        yp.a(this.f62609a.h(), this.f62609a.g(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context) {
        if (!StringUtils.isValidString(this.f62609a.g()) || this.f62609a.d()) {
            return;
        }
        this.f62609a.b(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.f10
            @Override // java.lang.Runnable
            public final void run() {
                this.f59610a.a(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        o oVar = this.f62613f;
        if (oVar != null) {
            oVar.b();
            this.f62611c.removeView(this.f62613f);
            this.f62613f = null;
        }
    }

    private void b() {
        String strO = this.f62609a.o();
        if (TextUtils.isEmpty(strO)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", strO);
        intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
        intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
        startActivity(Intent.createChooser(intent, null));
    }
}
