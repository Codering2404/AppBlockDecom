package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class c extends StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f83049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte f83050b;

    c() {
    }

    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder a(int i3) {
        this.f83050b = (byte) (this.f83050b | 2);
        return this;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest build() {
        if (this.f83050b == 3) {
            return new e(this.f83049a, 0, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f83050b & 1) == 0) {
            sb.append(" cloudProjectNumber");
        }
        if ((this.f83050b & 2) == 0) {
            sb.append(" webViewRequestMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder
    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder setCloudProjectNumber(long j3) {
        this.f83049a = j3;
        this.f83050b = (byte) (this.f83050b | 1);
        return this;
    }
}
