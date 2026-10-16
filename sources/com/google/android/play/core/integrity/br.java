package com.google.android.play.core.integrity;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class br extends StandardIntegrityManager.StandardIntegrityToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f83042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f83043b;

    br(String str, y yVar) {
        this.f83042a = str;
        this.f83043b = yVar;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityToken
    public final Task<Integer> showDialog(Activity activity, int i3) {
        return this.f83043b.a(activity, i3);
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityToken
    public final String token() {
        return this.f83042a;
    }
}
