package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzv extends AppUpdateOptions.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f82933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f82934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f82935c;

    zzv() {
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions a() {
        if (this.f82935c == 3) {
            return new zzx(this.f82933a, this.f82934b, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f82935c & 1) == 0) {
            sb.append(" appUpdateType");
        }
        if ((this.f82935c & 2) == 0) {
            sb.append(" allowAssetPackDeletion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions.Builder b(boolean z2) {
        this.f82934b = z2;
        this.f82935c = (byte) (this.f82935c | 2);
        return this;
    }

    public final AppUpdateOptions.Builder c(int i3) {
        this.f82933a = i3;
        this.f82935c = (byte) (this.f82935c | 1);
        return this;
    }
}
