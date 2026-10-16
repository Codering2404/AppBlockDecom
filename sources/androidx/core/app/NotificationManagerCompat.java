package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class NotificationManagerCompat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f33756d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static SideChannelManager f33759g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f33760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NotificationManager f33761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f33755c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Set f33757e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f33758f = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api30Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api34Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CancelTask implements Task {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f33762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f33763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f33764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f33765d;

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void a(INotificationSideChannel iNotificationSideChannel) {
            if (this.f33765d) {
                iNotificationSideChannel.V2(this.f33762a);
            } else {
                iNotificationSideChannel.k1(this.f33762a, this.f33763b, this.f33764c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f33762a + ", id:" + this.f33763b + ", tag:" + this.f33764c + ", all:" + this.f33765d + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterruptionFilter {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NotificationWithIdAndTag {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NotifyTask implements Task {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f33766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f33767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f33768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Notification f33769d;

        NotifyTask(String str, int i3, String str2, Notification notification) {
            this.f33766a = str;
            this.f33767b = i3;
            this.f33768c = str2;
            this.f33769d = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.X4(this.f33766a, this.f33767b, this.f33768c, this.f33769d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f33766a + ", id:" + this.f33767b + ", tag:" + this.f33768c + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ServiceConnectedEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ComponentName f33770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f33771b;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f33770a = componentName;
            this.f33771b = iBinder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SideChannelManager implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f33772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HandlerThread f33773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f33774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map f33775d = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Set f33776f = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class ListenerRecord {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ComponentName f33777a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            INotificationSideChannel f33779c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f33778b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            ArrayDeque f33780d = new ArrayDeque();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f33781e = 0;

            ListenerRecord(ComponentName componentName) {
                this.f33777a = componentName;
            }
        }

        SideChannelManager(Context context) {
            this.f33772a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f33773b = handlerThread;
            handlerThread.start();
            this.f33774c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(ListenerRecord listenerRecord) {
            if (listenerRecord.f33778b) {
                return true;
            }
            boolean zBindService = this.f33772a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.f33777a), this, 33);
            listenerRecord.f33778b = zBindService;
            if (zBindService) {
                listenerRecord.f33781e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.f33777a);
                this.f33772a.unbindService(this);
            }
            return listenerRecord.f33778b;
        }

        private void b(ListenerRecord listenerRecord) {
            if (listenerRecord.f33778b) {
                this.f33772a.unbindService(this);
                listenerRecord.f33778b = false;
            }
            listenerRecord.f33779c = null;
        }

        private void c(Task task) {
            j();
            for (ListenerRecord listenerRecord : this.f33775d.values()) {
                listenerRecord.f33780d.add(task);
                g(listenerRecord);
            }
        }

        private void d(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f33775d.get(componentName);
            if (listenerRecord != null) {
                g(listenerRecord);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f33775d.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.f33779c = INotificationSideChannel.Stub.x3(iBinder);
                listenerRecord.f33781e = 0;
                g(listenerRecord);
            }
        }

        private void f(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f33775d.get(componentName);
            if (listenerRecord != null) {
                b(listenerRecord);
            }
        }

        private void g(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.f33777a + ", " + listenerRecord.f33780d.size() + " queued tasks");
            }
            if (listenerRecord.f33780d.isEmpty()) {
                return;
            }
            if (!a(listenerRecord) || listenerRecord.f33779c == null) {
                i(listenerRecord);
                return;
            }
            while (true) {
                Task task = (Task) listenerRecord.f33780d.peek();
                if (task == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + task);
                    }
                    task.a(listenerRecord.f33779c);
                    listenerRecord.f33780d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.f33777a);
                    }
                } catch (RemoteException e3) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.f33777a, e3);
                }
            }
            if (listenerRecord.f33780d.isEmpty()) {
                return;
            }
            i(listenerRecord);
        }

        private void i(ListenerRecord listenerRecord) {
            if (this.f33774c.hasMessages(3, listenerRecord.f33777a)) {
                return;
            }
            int i3 = listenerRecord.f33781e;
            int i4 = i3 + 1;
            listenerRecord.f33781e = i4;
            if (i4 <= 6) {
                int i5 = (1 << i3) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i5 + " ms");
                }
                this.f33774c.sendMessageDelayed(this.f33774c.obtainMessage(3, listenerRecord.f33777a), i5);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.f33780d.size() + " tasks to " + listenerRecord.f33777a + " after " + listenerRecord.f33781e + " retries");
            listenerRecord.f33780d.clear();
        }

        private void j() {
            Set setE = NotificationManagerCompat.e(this.f33772a);
            if (setE.equals(this.f33776f)) {
                return;
            }
            this.f33776f = setE;
            List<ResolveInfo> listQueryIntentServices = this.f33772a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setE.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f33775d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f33775d.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            Iterator it = this.f33775d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    b((ListenerRecord) entry.getValue());
                    it.remove();
                }
            }
        }

        public void h(Task task) {
            this.f33774c.obtainMessage(0, task).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                c((Task) message.obj);
                return true;
            }
            if (i3 == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                e(serviceConnectedEvent.f33770a, serviceConnectedEvent.f33771b);
                return true;
            }
            if (i3 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i3 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f33774c.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f33774c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface Task {
        void a(INotificationSideChannel iNotificationSideChannel);
    }

    private NotificationManagerCompat(Context context) {
        this.f33760a = context;
        this.f33761b = (NotificationManager) context.getSystemService("notification");
    }

    public static NotificationManagerCompat d(Context context) {
        return new NotificationManagerCompat(context);
    }

    public static Set e(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f33755c) {
            if (string != null) {
                try {
                    if (!string.equals(f33756d)) {
                        String[] strArrSplit = string.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f33757e = hashSet;
                        f33756d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f33757e;
        }
        return set;
    }

    private void h(Task task) {
        synchronized (f33758f) {
            try {
                if (f33759g == null) {
                    f33759g = new SideChannelManager(this.f33760a.getApplicationContext());
                }
                f33759g.h(task);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean i(Notification notification) {
        Bundle bundleA = NotificationCompat.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return Api24Impl.a(this.f33761b);
    }

    public void b(int i3) {
        c(null, i3);
    }

    public void c(String str, int i3) {
        this.f33761b.cancel(str, i3);
    }

    public void f(int i3, Notification notification) {
        g(null, i3, notification);
    }

    public void g(String str, int i3, Notification notification) {
        if (!i(notification)) {
            this.f33761b.notify(str, i3, notification);
        } else {
            h(new NotifyTask(this.f33760a.getPackageName(), i3, str, notification));
            this.f33761b.cancel(str, i3);
        }
    }
}
