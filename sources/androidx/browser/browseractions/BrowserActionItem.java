package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BrowserActionItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PendingIntent f2549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f2551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f2552e;

    public PendingIntent a() {
        PendingIntent pendingIntent = this.f2549b;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
    }

    public int b() {
        return this.f2550c;
    }

    public Uri c() {
        return this.f2551d;
    }

    Runnable d() {
        return this.f2552e;
    }

    public String e() {
        return this.f2548a;
    }
}
