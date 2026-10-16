package com.google.android.play.core.appupdate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzx extends AppUpdateOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f82936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f82937b;

    /* synthetic */ zzx(int i3, boolean z2, zzw zzwVar) {
        this.f82936a = i3;
        this.f82937b = z2;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final boolean a() {
        return this.f82937b;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final int b() {
        return this.f82936a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            if (this.f82936a == appUpdateOptions.b() && this.f82937b == appUpdateOptions.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f82936a ^ 1000003) * 1000003) ^ (true != this.f82937b ? 1237 : 1231);
    }

    public final String toString() {
        return "AppUpdateOptions{appUpdateType=" + this.f82936a + ", allowAssetPackDeletion=" + this.f82937b + "}";
    }
}
