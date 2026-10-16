package androidx.work;

import android.app.Notification;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ForegroundInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f54526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Notification f54528c;

    public ForegroundInfo(int i3, Notification notification, int i4) {
        this.f54526a = i3;
        this.f54528c = notification;
        this.f54527b = i4;
    }

    public int a() {
        return this.f54527b;
    }

    public Notification b() {
        return this.f54528c;
    }

    public int c() {
        return this.f54526a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.f54526a == foregroundInfo.f54526a && this.f54527b == foregroundInfo.f54527b) {
            return this.f54528c.equals(foregroundInfo.f54528c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f54526a * 31) + this.f54527b) * 31) + this.f54528c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f54526a + ", mForegroundServiceType=" + this.f54527b + ", mNotification=" + this.f54528c + '}';
    }
}
