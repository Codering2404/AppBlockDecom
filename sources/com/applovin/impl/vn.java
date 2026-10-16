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
public abstract class vn extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f64444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f64445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private dc f64446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f64447d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListView f64448f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f64449f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.f64449f = list;
        }

        @Override // com.applovin.impl.dc
        protected cc a() {
            return new cc.b(cc.c.SECTION_CENTERED).d("Select a network to load test ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            return vn.this.f64447d;
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return this.f64449f.size();
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return new fj("TEST MODE NETWORKS");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements dc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f64451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f64452b;

        b(List list, com.applovin.impl.sdk.j jVar) {
            this.f64451a = list;
            this.f64452b = jVar;
        }

        @Override // com.applovin.impl.dc.a
        public void a(kb kbVar, cc ccVar) {
            List listU = ((je) this.f64451a.get(kbVar.a())).u();
            if (listU.equals(this.f64452b.k0().b())) {
                this.f64452b.k0().a((List) null);
            } else {
                this.f64452b.k0().a(listU);
            }
            vn.this.f64446c.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c extends bg {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ je f64454p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(je jeVar, Context context, je jeVar2) {
            super(jeVar, context);
            this.f64454p = jeVar2;
        }

        @Override // com.applovin.impl.bg, com.applovin.impl.cc
        public int d() {
            if (this.f64454p.u().equals(vn.this.f64444a.k0().b())) {
                return R.drawable.applovin_ic_check_mark_borderless;
            }
            return 0;
        }

        @Override // com.applovin.impl.bg, com.applovin.impl.cc
        public int e() {
            if (this.f64454p.u().equals(vn.this.f64444a.k0().b())) {
                return -16776961;
            }
            return super.e();
        }

        @Override // com.applovin.impl.cc
        public SpannedString k() {
            return StringUtils.createSpannedString(this.f64454p.g(), o() ? -16777216 : -7829368, 18, 1);
        }
    }

    public vn() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f64444a;
    }

    public void initialize(List<je> list, com.applovin.impl.sdk.j jVar) {
        this.f64444a = jVar;
        this.f64445b = list;
        this.f64447d = a(list);
        a aVar = new a(this, list);
        this.f64446c = aVar;
        aVar.a(new b(list, jVar));
        this.f64446c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Test Mode Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f64448f = listView;
        listView.setAdapter((ListAdapter) this.f64446c);
    }

    @Override // com.applovin.impl.re, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f64447d = a(this.f64445b);
        this.f64446c.notifyDataSetChanged();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            je jeVar = (je) it.next();
            arrayList.add(new c(jeVar, this, jeVar));
        }
        return arrayList;
    }
}
