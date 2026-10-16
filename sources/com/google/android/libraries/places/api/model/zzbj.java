package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbj extends zzge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Money f75261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Money f75262b;

    zzbj() {
    }

    @Override // com.google.android.libraries.places.api.model.zzge
    public final zzge a(Money money) {
        this.f75261a = money;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzge
    public final zzge b(Money money) {
        this.f75262b = money;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzge
    public final zzgf c() {
        return new zzew(this.f75261a, this.f75262b);
    }
}
