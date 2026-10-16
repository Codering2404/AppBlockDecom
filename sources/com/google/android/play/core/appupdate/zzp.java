package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzp extends zzo {
    zzp(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        super(zzrVar, new com.google.android.play.core.appupdate.internal.zzm("OnCompleteUpdateCallback"), taskCompletionSource);
    }

    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void zzb(Bundle bundle) {
        super.zzb(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f82922b.trySetException(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f82922b.trySetResult(null);
        }
    }
}
