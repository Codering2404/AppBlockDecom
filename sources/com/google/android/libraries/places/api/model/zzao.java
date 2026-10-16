package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzao extends zzfx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f75083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f75084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f75085c;

    zzao() {
    }

    @Override // com.google.android.libraries.places.api.model.zzfx
    final zzfx a(int i3) {
        this.f75084b = i3;
        this.f75085c = (byte) (this.f75085c | 2);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzfx
    final LocalTime b() {
        if (this.f75085c == 3) {
            return new zzea(this.f75083a, this.f75084b);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f75085c & 1) == 0) {
            sb.append(" hours");
        }
        if ((this.f75085c & 2) == 0) {
            sb.append(" minutes");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    final zzfx c(int i3) {
        this.f75083a = i3;
        this.f75085c = (byte) (this.f75085c | 1);
        return this;
    }
}
