package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t6 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private v6 f63879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f63880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f63881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f63882d;

    private void b() {
        pc pcVar = new pc();
        pcVar.a(this.f63880b.v().a(this.f63879a));
        String strB = this.f63880b.v().b(this.f63879a.a());
        if (strB != null) {
            pcVar.a("\nBid Response Preview:\n");
            pcVar.a(strB);
        }
        TextView textView = (TextView) findViewById(R.id.email_report_tv);
        this.f63881c = textView;
        textView.setText(pcVar.toString());
        this.f63881c.setTextColor(-16777216);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a()) {
            finish();
            return;
        }
        setTitle(this.f63879a.c() + " - " + this.f63879a.d());
        setContentView(R.layout.creative_debugger_displayed_ad_detail_activity);
        b();
        Button button = (Button) findViewById(R.id.report_ad_button);
        this.f63882d = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.g50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f59870a.a(view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.creative_debugger_displayed_ad_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!a()) {
            finish();
            return false;
        }
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f63880b.v().a(this.f63879a, (Context) this, false);
        return true;
    }

    public void a(v6 v6Var, com.applovin.impl.sdk.j jVar) {
        this.f63879a = v6Var;
        this.f63880b = jVar;
    }

    private boolean a() {
        return (this.f63879a == null || this.f63880b == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f63880b.v().a(this.f63879a, (Context) this, true);
    }
}
