package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.cc;
import com.applovin.impl.dc;
import com.applovin.impl.r;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerAdUnitWaterfallsListActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c0 extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f58793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private dc f58794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f58795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f58796d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListView f58797f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f58798f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.f58798f = list;
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            return c0.this.f58795c;
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            return this.f58798f.size();
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return new fj("");
        }
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f58793a;
    }

    public void initialize(final List<z> list, boolean z2, final com.applovin.impl.sdk.j jVar) {
        this.f58796d = z2;
        this.f58793a = jVar;
        this.f58795c = a(list);
        a aVar = new a(this, list);
        this.f58794b = aVar;
        aVar.a(new dc.a() { // from class: com.applovin.impl.du
            @Override // com.applovin.impl.dc.a
            public final void a(kb kbVar, cc ccVar) {
                this.f59305a.a(list, jVar, kbVar, ccVar);
            }
        });
        this.f58794b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f58796d ? "Selective Init " : "");
        sb.append("Ad Units");
        setTitle(sb.toString());
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f58797f = listView;
        listView.setAdapter((ListAdapter) this.f58794b);
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(zVar.c(), -16777216));
            spannableStringBuilder.append((CharSequence) new SpannedString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(zVar.b(), -16777216));
            arrayList.add(cc.a(cc.c.DETAIL).b(StringUtils.createSpannedString(zVar.d(), -16777216, 18, 1)).a(new SpannedString(spannableStringBuilder)).a(this).a(true).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, final com.applovin.impl.sdk.j jVar, kb kbVar, cc ccVar) {
        final z zVar = (z) list.get(kbVar.a());
        if (zVar.g().size() == 1) {
            r.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.eu
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    ((MaxDebuggerAdUnitDetailActivity) activity).initialize(zVar, null, null, jVar);
                }
            });
        } else {
            r.a(this, MaxDebuggerAdUnitWaterfallsListActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.fu
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    ((MaxDebuggerAdUnitWaterfallsListActivity) activity).initialize(zVar, jVar);
                }
            });
        }
    }
}
