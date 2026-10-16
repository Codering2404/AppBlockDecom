package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzo implements DynamiteModule.VersionPolicy.IVersions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72420a;

    public zzo(int i3, int i4) {
        this.f72420a = i3;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int a(Context context, String str, boolean z2) {
        return 0;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int b(Context context, String str) {
        return this.f72420a;
    }
}
