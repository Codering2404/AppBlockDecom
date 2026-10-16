package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.CommonNotificationBuilder;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DisplayNotification {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f89374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f89375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NotificationParams f89376c;

    public DisplayNotification(Context context, NotificationParams notificationParams, ExecutorService executorService) {
        this.f89374a = executorService;
        this.f89375b = context;
        this.f89376c = notificationParams;
    }

    private void c(CommonNotificationBuilder.DisplayNotificationInfo displayNotificationInfo) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f89375b.getSystemService("notification")).notify(displayNotificationInfo.f89371b, displayNotificationInfo.f89372c, displayNotificationInfo.f89370a.c());
    }

    private ImageDownload d() {
        ImageDownload imageDownloadF = ImageDownload.f(this.f89376c.p("gcm.n.image"));
        if (imageDownloadF != null) {
            imageDownloadF.j(this.f89374a);
        }
        return imageDownloadF;
    }

    private void e(NotificationCompat.Builder builder, ImageDownload imageDownload) {
        if (imageDownload == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(imageDownload.i(), 5L, TimeUnit.SECONDS);
            builder.r(bitmap);
            builder.D(new NotificationCompat.BigPictureStyle().i(bitmap).h(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            imageDownload.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e3) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e3.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            imageDownload.close();
        }
    }

    boolean a() {
        if (this.f89376c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        ImageDownload imageDownloadD = d();
        CommonNotificationBuilder.DisplayNotificationInfo displayNotificationInfoE = CommonNotificationBuilder.e(this.f89375b, this.f89376c);
        e(displayNotificationInfoE.f89370a, imageDownloadD);
        c(displayNotificationInfoE);
        return true;
    }

    private boolean b() {
        if (((KeyguardManager) this.f89375b.getSystemService(MrGIhy.QRSxaMaUGLN)).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.c()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f89375b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == iMyPid) {
                    if (next.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
