package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zae extends zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f72046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fragment f72047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f72048c;

    @Override // com.google.android.gms.common.internal.zag
    public final void a() {
        Intent intent = this.f72046a;
        if (intent != null) {
            this.f72047b.startActivityForResult(intent, this.f72048c);
        }
    }
}
