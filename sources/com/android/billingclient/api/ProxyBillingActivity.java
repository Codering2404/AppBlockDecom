package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ProxyBillingActivity extends Activity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzei f57321h = zzeg.f57593a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultReceiver f57322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f57323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f57324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f57325d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f57326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f57327g;

    private zzjd a(int i3, Intent intent) {
        return intent == null ? i3 != -1 ? i3 != 0 ? i3 != 3 ? i3 != 4 ? zzjd.NULL_DATA_WITH_OTHER_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzjd.NULL_DATA_WITH_PLAY_CANCELED_WITHOUT_COMPLETE_ACTION_RESULT_CODE : zzjd.NULL_DATA_WITH_PLAY_CANCELED_RESULT_CODE : zzjd.NULL_DATA_WITH_CANCELLED_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : zzjd.NULL_DATA_WITH_OK_RESULT_CODE_IN_PROXY_BILLING_ACTIVITY_RESULT : intent.getExtras() == null ? zzjd.NULL_BUNDLE_IN_ACTIVITY_RESULT : i3 == 5 ? zzjd.PLAY_STORE_ON_CREATE_RUNTIME_EXCEPTION : zzjd.REASON_UNSPECIFIED;
    }

    private boolean b(int i3, Intent intent) {
        return !a(i3, intent).equals(zzjd.REASON_UNSPECIFIED);
    }

    private Intent c(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent d(zzjd zzjdVar, long j3, boolean z2) {
        Intent intentE = e();
        intentE.putExtra("RESPONSE_CODE", 6);
        intentE.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
        BillingResult.Builder builderD = BillingResult.d();
        builderD.d(6);
        builderD.b("An internal error occurred.");
        BillingResult billingResultA = builderD.a();
        int i3 = zzcy.f57549a;
        intentE.putExtra("FAILURE_LOGGING_PAYLOAD", zzcy.b(zzjdVar, 2, billingResultA, null, zzjk.BROADCAST_ACTION_UNSPECIFIED).zzQ());
        intentE.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        intentE.putExtra("billingClientTransactionId", j3);
        intentE.putExtra("wasServiceAutoReconnected", this.f57327g);
        return intentE;
    }

    private Intent e() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle != null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f57323b = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f57322a = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.f57324c = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.f57325d = bundle.getInt("activity_code", 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.f57326f = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.f57327g = bundle.getBoolean("wasServiceAutoReconnected");
                return;
            }
            return;
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("ProxyBillingActivity", "Launching Play Store billing flow");
        this.f57325d = 100;
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f57324c = true;
                this.f57325d = 110;
            }
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.f57322a = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            this.f57325d = 101;
        } else {
            pendingIntent = null;
        }
        if (getIntent().hasExtra("billingClientTransactionId")) {
            this.f57326f = getIntent().getLongExtra("billingClientTransactionId", 0L);
        }
        if (getIntent().hasExtra("wasServiceAutoReconnected")) {
            this.f57327g = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
        }
        try {
            this.f57323b = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), this.f57325d, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e3);
            ResultReceiver resultReceiver = this.f57322a;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            } else {
                Intent intentD = d(zzjd.INTENT_SENDER_EXCEPTION, this.f57326f, false);
                if (this.f57324c) {
                    intentD.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentD);
            }
            this.f57323b = false;
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f57323b) {
            Intent intentE = e();
            intentE.putExtra("RESPONSE_CODE", 1);
            intentE.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            if (this.f57324c) {
                intentE.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i3 = this.f57325d;
            if (i3 == 110 || i3 == 100) {
                intentE.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                intentE.putExtra("billingClientTransactionId", this.f57326f);
            }
            sendBroadcast(intentE);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f57322a;
        if (resultReceiver != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f57323b);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f57324c);
        bundle.putInt("activity_code", this.f57325d);
        bundle.putLong("billingClientTransactionId", this.f57326f);
        bundle.putBoolean("wasServiceAutoReconnected", this.f57327g);
    }
}
