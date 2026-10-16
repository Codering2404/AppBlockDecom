package com.applovin.impl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.dc;
import com.applovin.impl.r;
import com.applovin.impl.w4;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class v4 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w4 f64376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f64377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListView f64378c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements dc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f64379a;

        /* JADX INFO: renamed from: com.applovin.impl.v4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0127a implements r.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kb f64381a;

            C0127a(kb kbVar) {
                this.f64381a = kbVar;
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
                maxCreativeDebuggerDisplayedAdActivity.a((v6) v4.this.f64376a.d().get(this.f64381a.a()), v4.this.f64376a.e());
            }
        }

        a(q qVar) {
            this.f64379a = qVar;
        }

        @Override // com.applovin.impl.dc.a
        public void a(kb kbVar, cc ccVar) {
            if (kbVar.b() != w4.a.RECENT_ADS.ordinal()) {
                return;
            }
            r.a(v4.this, MaxCreativeDebuggerDisplayedAdActivity.class, this.f64379a, new C0127a(kbVar));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        w4 w4Var = this.f64376a;
        if (w4Var != null) {
            w4Var.a((dc.a) null);
            this.f64376a.g();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        w4 w4Var = this.f64376a;
        if (w4Var == null) {
            finish();
            return;
        }
        this.f64378c.setAdapter((ListAdapter) w4Var);
        w4 w4Var2 = this.f64376a;
        if (w4Var2 != null && !w4Var2.e().v().g()) {
            a(R.string.applovin_creative_debugger_disabled_text);
            return;
        }
        w4 w4Var3 = this.f64376a;
        if (w4Var3 == null || !w4Var3.f()) {
            return;
        }
        a(R.string.applovin_creative_debugger_no_ads_text);
    }

    public void a(w4 w4Var, q qVar) {
        this.f64376a = w4Var;
        w4Var.a(new a(qVar));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(QaXmqxvjHhxVy.rVLyLm);
        setContentView(R.layout.mediation_debugger_list_view);
        this.f64377b = (FrameLayout) findViewById(android.R.id.content);
        this.f64378c = (ListView) findViewById(R.id.listView);
    }

    private void a(int i3) {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setText(i3);
        this.f64377b.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f64377b.bringChildToFront(textView);
    }
}
