package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zaa implements SuccessContinuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zaa f72310a = new zaa();

    private /* synthetic */ zaa() {
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        int i3 = GoogleApiAvailability.f71449d;
        return Tasks.forResult(null);
    }
}
