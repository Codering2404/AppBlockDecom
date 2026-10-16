package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.LinearLayout;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbuy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class OutOfContextTestingActivity extends Activity {
    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzdt zzdtVarH = zzay.b().h(this, new zzbuy());
        if (zzdtVarH == null) {
            finish();
            return;
        }
        setContentView(R.layout.f69673a);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f69672a);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("adUnit");
        if (stringExtra == null) {
            finish();
            return;
        }
        try {
            zzdtVarH.zze(stringExtra, ObjectWrapper.i5(this), ObjectWrapper.i5(linearLayout));
        } catch (RemoteException unused) {
            finish();
        }
    }
}
