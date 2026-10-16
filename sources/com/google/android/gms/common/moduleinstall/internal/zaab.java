package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaab extends zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListenerHolder f72157a;

    @Override // com.google.android.gms.common.moduleinstall.internal.zah
    public final void D4(ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.f72157a.c(new zaaa(this, moduleInstallStatusUpdate));
    }
}
