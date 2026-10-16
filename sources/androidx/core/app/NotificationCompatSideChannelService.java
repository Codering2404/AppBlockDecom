package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.INotificationSideChannel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class NotificationSideChannelStub extends INotificationSideChannel.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NotificationCompatSideChannelService f33754a;

        @Override // android.support.v4.app.INotificationSideChannel
        public void V2(String str) {
            this.f33754a.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                this.f33754a.b(str);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void X4(String str, int i3, String str2, Notification notification) {
            this.f33754a.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                this.f33754a.d(str, i3, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void k1(String str, int i3, String str2) {
            this.f33754a.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                this.f33754a.a(str, i3, str2);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    public abstract void a(String str, int i3, String str2);

    public abstract void b(String str);

    void c(int i3, String str) {
        for (String str2 : getPackageManager().getPackagesForUid(i3)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i3 + " is not authorized for package " + str);
    }

    public abstract void d(String str, int i3, String str2, Notification notification);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
        return null;
    }
}
