package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzf implements IntentSenderForResultStarter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f82910a;

    zzf(zzg zzgVar, Activity activity) {
        this.f82910a = activity;
    }

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final void a(IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) throws IntentSender.SendIntentException {
        this.f82910a.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }
}
