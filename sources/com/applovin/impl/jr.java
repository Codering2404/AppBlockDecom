package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.cc;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class jr extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f60811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f60812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private dc f60813c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f60814f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.f60814f = list;
        }

        @Override // com.applovin.impl.dc
        protected cc a() {
            return new cc.b(cc.c.SECTION_CENTERED).d("A plus in front of each segment indicates inclusion and a minus indicates exclusion. The comma in comma-separated values functions as an ∨ (or) operator, and a new row functions as an ∧ (and) operator.").a();
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            return this.f60814f;
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return this.f60814f.size();
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return new fj("SEGMENT TARGETING");
        }
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(cc.a(cc.c.DETAIL).d((String) it.next()).a());
        }
        return arrayList;
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f60812b;
    }

    public void initialize(String str, List<String> list, com.applovin.impl.sdk.j jVar) {
        this.f60811a = str;
        this.f60812b = jVar;
        a aVar = new a(this, a(list));
        this.f60813c = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f60811a);
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.f60813c);
    }
}
