package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class bj extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bk f83024a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bj(bk bkVar, String str, long j3) {
        super(str, j3);
        this.f83024a = bkVar;
    }

    @Override // com.google.android.play.core.integrity.y
    final Task b(Activity activity, Bundle bundle) {
        bundle.putLong("cloud.prj", this.f83024a.f83027e);
        return this.f83024a.f83025c.c(activity, bundle);
    }
}
