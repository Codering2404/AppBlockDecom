package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaButtonReceiver extends BroadcastReceiver {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f40480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Intent f40481d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f40482e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MediaBrowserCompat f40483f;

        MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f40480c = context;
            this.f40481d = intent;
            this.f40482e = pendingResult;
        }

        private void e() {
            this.f40483f.b();
            this.f40482e.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void a() {
            try {
                new MediaControllerCompat(this.f40480c, this.f40483f.c()).a((KeyEvent) this.f40481d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e3) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e3);
            }
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void b() {
            e();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void c() {
            e();
        }

        void f(MediaBrowserCompat mediaBrowserCompat) {
            this.f40483f = mediaBrowserCompat;
        }
    }

    private static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + listQueryIntentServices.size());
    }

    private static void b(Context context, Intent intent) {
        context.startForegroundService(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName componentNameA = a(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameA != null) {
            intent.setComponent(componentNameA);
            b(context, intent);
            return;
        }
        ComponentName componentNameA2 = a(context, "android.media.browse.MediaBrowserService");
        if (componentNameA2 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, pendingResultGoAsync);
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, componentNameA2, mediaButtonConnectionCallback, null);
        mediaButtonConnectionCallback.f(mediaBrowserCompat);
        mediaBrowserCompat.a();
    }
}
