package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzk extends zzfr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f75368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f75369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f75370c;

    zzk() {
    }

    @Override // com.google.android.libraries.places.api.model.zzfr
    public final zzfr a(int i3) {
        this.f75368a = i3;
        this.f75370c = (byte) (this.f75370c | 1);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzfr
    public final zzfr b(int i3) {
        this.f75369b = i3;
        this.f75370c = (byte) (this.f75370c | 2);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzfr
    public final zzfs c() {
        if (this.f75370c == 3) {
            return new zzcs(this.f75368a, this.f75369b);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f75370c & 1) == 0) {
            sb.append(" offset");
        }
        if ((this.f75370c & 2) == 0) {
            sb.append(" length");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
