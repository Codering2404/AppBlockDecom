package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzq extends zzo {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f82924d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzr f82925f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzq(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnRequestInstallCallback"), taskCompletionSource);
        this.f82925f = zzrVar;
        this.f82924d = str;
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void K3(Bundle bundle) {
        super.K3(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f82922b.trySetException(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f82922b.trySetResult(zzr.e(this.f82925f, bundle, this.f82924d));
        }
    }
}
