package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.google.android.gms.internal.play_billing.zzjd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ActivityResultLauncher f57328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActivityResultLauncher f57329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ActivityResultLauncher f57330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActivityResultLauncher f57331d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ResultReceiver f57332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ResultReceiver f57333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ResultReceiver f57334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ResultReceiver f57335i;

    final void I(ActivityResult activityResult) {
        Intent intentC = activityResult.c();
        int iC = com.google.android.gms.internal.play_billing.zzc.zzi(intentC, "ProxyBillingActivityV2").c();
        ResultReceiver resultReceiver = this.f57332f;
        if (resultReceiver != null) {
            resultReceiver.send(iC, intentC == null ? null : intentC.getExtras());
        }
        if (activityResult.d() != -1 || iC != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + activityResult.d() + " and billing's responseCode: " + iC);
        }
        finish();
    }

    final void J(ActivityResult activityResult) {
        Intent intentC = activityResult.c();
        int iC = com.google.android.gms.internal.play_billing.zzc.zzi(intentC, "ProxyBillingActivityV2").c();
        ResultReceiver resultReceiver = this.f57333g;
        if (resultReceiver != null) {
            resultReceiver.send(iC, intentC == null ? null : intentC.getExtras());
        }
        if (activityResult.d() != -1 || iC != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(activityResult.d()), Integer.valueOf(iC)));
        }
        finish();
    }

    final void L(ActivityResult activityResult) {
        Intent intentC = activityResult.c();
        Bundle extras = intentC == null ? null : intentC.getExtras();
        if (activityResult.d() != -1) {
            if (extras == null) {
                extras = new Bundle();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", String.format("External offer flow finished with resultCode: %s", Integer.valueOf(activityResult.d())));
            extras.putInt("INTERNAL_LOG_ERROR_REASON", zzjd.ERROR_IN_ACTIVITY_RESULT.zza());
            extras.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("External offer flow finished with error resultCode: %s", Integer.valueOf(activityResult.d())));
        }
        int iC = com.google.android.gms.internal.play_billing.zzc.zzi(intentC, "ProxyBillingActivityV2").c();
        ResultReceiver resultReceiver = this.f57334h;
        if (resultReceiver != null) {
            resultReceiver.send(iC, extras);
        } else {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", "External offer flow result receiver is null");
        }
        if (iC != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", String.format("External offer flow finished with billing responseCode: %s", Integer.valueOf(iC)));
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f57328a = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.zzdu
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f57587a.I((ActivityResult) obj);
            }
        });
        this.f57329b = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.zzdv
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f57588a.J((ActivityResult) obj);
            }
        });
        this.f57330c = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.zzdw
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f57589a.L((ActivityResult) obj);
            }
        });
        this.f57331d = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.zzdx
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f57590a.N((ActivityResult) obj);
            }
        });
        if (bundle != null) {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.f57332f = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
            }
            if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                this.f57333g = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
            }
            if (bundle.containsKey("external_offer_flow_result_receiver")) {
                this.f57334h = (ResultReceiver) bundle.getParcelable("external_offer_flow_result_receiver");
            }
            if (bundle.containsKey("launch_external_link_result_receiver")) {
                this.f57335i = (ResultReceiver) bundle.getParcelable("launch_external_link_result_receiver");
                return;
            }
            return;
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("ProxyBillingActivityV2", "Launching Play Store billing dialog");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.f57332f = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.f57328a.b(new IntentSenderRequest.Builder(pendingIntent).a());
            return;
        }
        if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
            this.f57333g = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
            this.f57329b.b(new IntentSenderRequest.Builder(pendingIntent2).a());
        } else if (getIntent().hasExtra("external_offer_flow_pending_intent")) {
            PendingIntent pendingIntent3 = (PendingIntent) getIntent().getParcelableExtra("external_offer_flow_pending_intent");
            this.f57334h = (ResultReceiver) getIntent().getParcelableExtra("external_offer_flow_result_receiver");
            this.f57330c.b(new IntentSenderRequest.Builder(pendingIntent3).a());
        } else if (getIntent().hasExtra("launch_external_link_flow_pending_intent")) {
            PendingIntent pendingIntent4 = (PendingIntent) getIntent().getParcelableExtra("launch_external_link_flow_pending_intent");
            this.f57335i = (ResultReceiver) getIntent().getParcelableExtra("launch_external_link_result_receiver");
            this.f57331d.b(new IntentSenderRequest.Builder(pendingIntent4).a());
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f57332f;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f57333g;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.f57334h;
        if (resultReceiver3 != null) {
            bundle.putParcelable("external_offer_flow_result_receiver", resultReceiver3);
        }
        ResultReceiver resultReceiver4 = this.f57335i;
        if (resultReceiver4 != null) {
            bundle.putParcelable("launch_external_link_result_receiver", resultReceiver4);
        }
    }

    final void N(ActivityResult activityResult) {
        Bundle extras;
        Intent intentC = activityResult.c();
        if (intentC == null) {
            extras = null;
        } else {
            extras = intentC.getExtras();
        }
        if (activityResult.d() != -1) {
            if (extras == null) {
                extras = new Bundle();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", String.format("Launch external link flow finished with resultCode: %s", Integer.valueOf(activityResult.d())));
            extras.putInt("INTERNAL_LOG_ERROR_REASON", zzjd.ERROR_IN_ACTIVITY_RESULT.zza());
            extras.putString(SbbqvQlxi.jJT, String.format("Launch external link flow finished with error resultCode: %s", Integer.valueOf(activityResult.d())));
        }
        int iC = com.google.android.gms.internal.play_billing.zzc.zzi(intentC, "ProxyBillingActivityV2").c();
        ResultReceiver resultReceiver = this.f57335i;
        if (resultReceiver != null) {
            resultReceiver.send(iC, extras);
        } else {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", "Launch external link flow result receiver is null");
        }
        if (iC != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingActivityV2", String.format("Launch external link flow finished with billing responseCode: %s", Integer.valueOf(iC)));
        }
        finish();
    }
}
