package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzam extends zzfw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f75076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f75077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f75078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte f75079d;

    zzam() {
    }

    @Override // com.google.android.libraries.places.api.model.zzfw
    final zzfw a(int i3) {
        this.f75077b = i3;
        this.f75079d = (byte) (this.f75079d | 2);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzfw
    final zzfw b(int i3) {
        this.f75078c = i3;
        this.f75079d = (byte) (this.f75079d | 4);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzfw
    final LocalDate c() {
        if (this.f75079d == 7) {
            return new zzdy(this.f75076a, this.f75077b, this.f75078c);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f75079d & 1) == 0) {
            sb.append(" year");
        }
        if ((this.f75079d & 2) == 0) {
            sb.append(" month");
        }
        if ((this.f75079d & 4) == 0) {
            sb.append(" day");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    final zzfw d(int i3) {
        this.f75076a = i3;
        this.f75079d = (byte) (this.f75079d | 1);
        return this;
    }
}
