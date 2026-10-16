package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.cc;
import com.applovin.impl.dc;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class un extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f64277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f64278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f64279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private dc f64280d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f64281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f64282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ListView f64283h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.dc
        protected cc a() {
            return new cc.b(cc.c.SECTION_CENTERED).d("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return c.COUNT.ordinal();
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            return i3 == c.BIDDERS.ordinal() ? un.this.f64281f : un.this.f64282g;
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return i3 == c.BIDDERS.ordinal() ? un.this.f64281f.size() : un.this.f64282g.size();
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return i3 == c.BIDDERS.ordinal() ? new fj("BIDDERS") : new fj("WATERFALL");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b extends bg {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ ic f64285p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(je jeVar, Context context, ic icVar) {
            super(jeVar, context);
            this.f64285p = icVar;
        }

        @Override // com.applovin.impl.bg, com.applovin.impl.cc
        public int d() {
            if (un.this.f64277a.k0().b() == null || !un.this.f64277a.k0().b().equals(this.f64285p.b())) {
                return 0;
            }
            return R.drawable.applovin_ic_check_mark_borderless;
        }

        @Override // com.applovin.impl.bg, com.applovin.impl.cc
        public int e() {
            if (un.this.f64277a.k0().b() == null || !un.this.f64277a.k0().b().equals(this.f64285p.b())) {
                return super.e();
            }
            return -16776961;
        }

        @Override // com.applovin.impl.cc
        public SpannedString k() {
            return StringUtils.createSpannedString(this.f64285p.a(), o() ? -16777216 : -7829368, 18, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum c {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public un() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f64277a;
    }

    public void initialize(List<ic> list, List<ic> list2, final com.applovin.impl.sdk.j jVar) {
        this.f64277a = jVar;
        this.f64278b = list;
        this.f64279c = list2;
        this.f64281f = a(list);
        this.f64282g = a(list2);
        a aVar = new a(this);
        this.f64280d = aVar;
        aVar.a(new dc.a() { // from class: com.applovin.impl.t60
            @Override // com.applovin.impl.dc.a
            public final void a(kb kbVar, cc ccVar) {
                this.f63883a.a(jVar, kbVar, ccVar);
            }
        });
        this.f64280d.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f64283h = listView;
        listView.setAdapter((ListAdapter) this.f64280d);
    }

    @Override // com.applovin.impl.re, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f64281f = a(this.f64278b);
        this.f64282g = a(this.f64279c);
        this.f64280d.c();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ic icVar = (ic) it.next();
            arrayList.add(new b(icVar.d(), this, icVar));
        }
        return arrayList;
    }

    private ic a(kb kbVar) {
        if (kbVar.b() == c.BIDDERS.ordinal()) {
            return (ic) this.f64278b.get(kbVar.a());
        }
        return (ic) this.f64279c.get(kbVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.j jVar, kb kbVar, cc ccVar) {
        List listB = a(kbVar).b();
        if (listB.equals(jVar.k0().b())) {
            jVar.k0().a((List) null);
        } else {
            jVar.k0().a(listB);
        }
        this.f64280d.notifyDataSetChanged();
    }
}
