package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zac implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f72312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f72313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ActivityResultLauncher f72314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ GoogleApiAvailability f72315d;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        PendingIntent pendingIntentE = this.f72315d.e(this.f72312a, this.f72313b, 0);
        if (pendingIntentE == null) {
            return;
        }
        this.f72314c.b(new IntentSenderRequest.Builder(pendingIntentE.getIntentSender()).a());
    }
}
