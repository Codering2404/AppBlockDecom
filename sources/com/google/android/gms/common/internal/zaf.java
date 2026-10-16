package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaf extends zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f72049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LifecycleFragment f72050b;

    zaf(Intent intent, LifecycleFragment lifecycleFragment, int i3) {
        this.f72049a = intent;
        this.f72050b = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void a() {
        Intent intent = this.f72049a;
        if (intent != null) {
            this.f72050b.startActivityForResult(intent, 2);
        }
    }
}
