package androidx.browser.trusted;

import android.content.pm.PackageManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TokenContents f2698a;

    public boolean a(String str, PackageManager packageManager) {
        return PackageIdentityUtils.c(str, packageManager, this.f2698a);
    }
}
