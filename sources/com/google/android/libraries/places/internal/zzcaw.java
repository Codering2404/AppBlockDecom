package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzcaw implements zzccy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzccy f77364a;

    public zzcaw(zzccy zzccyVar) {
        this.f77364a = (zzccy) Preconditions.u(zzccyVar, "delegate");
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void D0(boolean z2, boolean z3, int i3, int i4, List list) {
        this.f77364a.D0(false, false, i3, 0, list);
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void E1(int i3, long j3) {
        this.f77364a.E1(i3, j3);
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public void G(int i3, zzccv zzccvVar) {
        this.f77364a.G(i3, zzccvVar);
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public void L0(boolean z2, int i3, int i4) {
        this.f77364a.L0(z2, i3, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void T0(zzcdk zzcdkVar) {
        this.f77364a.T0(zzcdkVar);
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void Y0(boolean z2, int i3, zzcff zzcffVar, int i4) {
        this.f77364a.Y0(z2, i3, zzcffVar, i4);
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void Z(int i3, zzccv zzccvVar, byte[] bArr) {
        this.f77364a.Z(0, zzccvVar, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f77364a.close();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public void v2(zzcdk zzcdkVar) {
        this.f77364a.v2(zzcdkVar);
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void zzd() {
        this.f77364a.zzd();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void zze() {
        this.f77364a.zze();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final int zzg() {
        return this.f77364a.zzg();
    }
}
