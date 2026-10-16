package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class PlayCoreDialogWrapperActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultReceiver f82938a;

    private final void a() {
        ResultReceiver resultReceiver = this.f82938a;
        if (resultReceiver != null) {
            resultReceiver.send(3, new Bundle());
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i3, int i4, Intent intent) {
        ResultReceiver resultReceiver;
        super.onActivityResult(i3, i4, intent);
        if (i3 == 0 && (resultReceiver = this.f82938a) != null) {
            if (i4 == -1) {
                resultReceiver.send(1, new Bundle());
            } else if (i4 == 0) {
                resultReceiver.send(2, new Bundle());
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        Intent intent;
        int intExtra = getIntent().getIntExtra("window_flags", 0);
        if (intExtra != 0) {
            getWindow().getDecorView().setSystemUiVisibility(intExtra);
            Intent intent2 = new Intent();
            intent2.putExtra("window_flags", intExtra);
            intent = intent2;
        } else {
            intent = null;
        }
        super.onCreate(bundle);
        if (bundle != null) {
            this.f82938a = (ResultReceiver) bundle.getParcelable(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER);
            return;
        }
        this.f82938a = (ResultReceiver) getIntent().getParcelableExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER);
        Bundle extras = getIntent().getExtras();
        PendingIntent pendingIntent = extras != null ? (PendingIntent) extras.get("confirmation_intent") : null;
        if (extras == null || pendingIntent == null) {
            a();
            finish();
        } else {
            try {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 0, intent, 0, 0, 0);
                } catch (IntentSender.SendIntentException unused) {
                    a();
                    finish();
                }
            } catch (IntentSender.SendIntentException unused2) {
            }
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, this.f82938a);
    }
}
