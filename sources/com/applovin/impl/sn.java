package com.applovin.impl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sn extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f63817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f63818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f63819c;

    private void a() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", this.f63819c);
        intent.putExtra("android.intent.extra.TITLE", this.f63818b);
        intent.putExtra("android.intent.extra.SUBJECT", this.f63818b);
        startActivity(Intent.createChooser(intent, null));
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f63817a;
    }

    public void initialize(String str, String str2, com.applovin.impl.sdk.j jVar) {
        this.f63817a = jVar;
        this.f63818b = str;
        this.f63819c = str2;
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_text_view_activity);
        setTitle(this.f63818b);
        ((TextView) findViewById(R.id.textView)).setText(this.f63819c);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        a();
        return true;
    }
}
