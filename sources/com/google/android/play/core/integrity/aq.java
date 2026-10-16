package com.google.android.play.core.integrity;

import android.app.Activity;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class aq extends IntegrityTokenResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f82983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f82984b;

    aq(String str, y yVar) {
        this.f82983a = str;
        this.f82984b = yVar;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenResponse
    public final Task<Integer> showDialog(Activity activity, int i3) {
        return this.f82984b.a(activity, i3);
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenResponse
    public final String token() {
        return this.f82983a;
    }
}
