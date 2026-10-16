package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.cc;
import com.applovin.impl.dc;
import com.applovin.impl.r;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxDebuggerWaterfallSegmentsActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b0 extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f58527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f58528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private dc f58529c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dc {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ z f58530f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, z zVar) {
            super(context);
            this.f58530f = zVar;
        }

        @Override // com.applovin.impl.dc
        protected int b() {
            return this.f58530f.g().size();
        }

        @Override // com.applovin.impl.dc
        protected List c(int i3) {
            ArrayList arrayList = new ArrayList();
            a0 a0Var = (a0) this.f58530f.g().get(i3);
            arrayList.add(b0.this.c(a0Var.c()));
            if (a0Var.b() != null) {
                arrayList.add(b0.this.a("AB Test Experiment Name", a0Var.b()));
            }
            kr krVarD = a0Var.d();
            b0 b0Var = b0.this;
            arrayList.add(b0Var.a("Device ID Targeting", b0Var.a(krVarD.a())));
            b0 b0Var2 = b0.this;
            arrayList.add(b0Var2.a("Device Type Targeting", b0Var2.b(krVarD.b())));
            if (krVarD.c() != null) {
                arrayList.add(b0.this.a(krVarD.c()));
            }
            return arrayList;
        }

        @Override // com.applovin.impl.dc
        protected int d(int i3) {
            a0 a0Var = (a0) this.f58530f.g().get(i3);
            return (a0Var.b() != null ? 1 : 0) + 3 + (a0Var.d().c() != null ? 1 : 0);
        }

        @Override // com.applovin.impl.dc
        protected cc e(int i3) {
            return i3 == b.TARGETED_WATERFALL.ordinal() ? new fj("TARGETED WATERFALL FOR CURRENT DEVICE") : i3 == b.OTHER_WATERFALLS.ordinal() ? new fj("OTHER WATERFALLS") : new fj("");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        TARGETED_WATERFALL,
        OTHER_WATERFALLS
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f58528b;
    }

    public void initialize(final z zVar, final com.applovin.impl.sdk.j jVar) {
        this.f58527a = zVar;
        this.f58528b = jVar;
        a aVar = new a(this, zVar);
        this.f58529c = aVar;
        aVar.a(new dc.a() { // from class: com.applovin.impl.rs
            @Override // com.applovin.impl.dc.a
            public final void a(kb kbVar, cc ccVar) {
                this.f62922a.a(jVar, zVar, kbVar, ccVar);
            }
        });
        this.f58529c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle(this.f58527a.d());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter((ListAdapter) this.f58529c);
        listView.setDividerHeight(0);
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dc dcVar = this.f58529c;
        if (dcVar != null) {
            dcVar.a((dc.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        if (str.equals("phone")) {
            return "Phones";
        }
        if (str.equals("tablet")) {
            return "Tablets";
        }
        return "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cc c(String str) {
        return cc.a(cc.c.RIGHT_DETAIL).b(StringUtils.createSpannedString(str, -16777216, 18, 1)).a(this).a(true).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (str.equals("idfa")) {
            return "IDFA Only";
        }
        if (str.equals("dnt")) {
            return "No IDFA Only";
        }
        return "All";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(z zVar, kb kbVar, com.applovin.impl.sdk.j jVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(zVar, (a0) zVar.g().get(kbVar.b()), null, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(z zVar, kb kbVar, com.applovin.impl.sdk.j jVar, MaxDebuggerWaterfallSegmentsActivity maxDebuggerWaterfallSegmentsActivity) {
        a0 a0Var = (a0) zVar.g().get(kbVar.b());
        maxDebuggerWaterfallSegmentsActivity.initialize(a0Var.c(), a0Var.d().c(), jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.j jVar, final z zVar, final kb kbVar, cc ccVar) {
        if (kbVar.a() == 0) {
            r.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.ss
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    b0.a(zVar, kbVar, jVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        } else {
            r.a(this, MaxDebuggerWaterfallSegmentsActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.ts
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    b0.a(zVar, kbVar, jVar, (MaxDebuggerWaterfallSegmentsActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cc a(String str, String str2) {
        return cc.a(cc.c.RIGHT_DETAIL).d(str).c(str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cc a(List list) {
        return cc.a(cc.c.DETAIL).d("Segment Targeting").a(StringUtils.createSpannedString(list.size() + " segment group(s)", -7829368, 14)).a(this).a(true).a();
    }
}
