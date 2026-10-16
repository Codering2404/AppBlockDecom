package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ah extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ai f82964a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ah(ai aiVar, String str, long j3) {
        super(str, j3);
        this.f82964a = aiVar;
    }

    @Override // com.google.android.play.core.integrity.y
    final Task b(Activity activity, Bundle bundle) {
        return this.f82964a.f82965a.b(activity, bundle);
    }
}
