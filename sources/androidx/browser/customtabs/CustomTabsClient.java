package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class CustomTabsClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ICustomTabsService f2597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f2598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f2599c;

    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.f2597a = iCustomTabsService;
        this.f2598b = componentName;
        this.f2599c = context;
    }

    public static boolean a(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static boolean b(Context context, String str) {
        if (str == null) {
            return false;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            return a(applicationContext, str, new CustomTabsServiceConnection() { // from class: androidx.browser.customtabs.CustomTabsClient.1
                @Override // androidx.browser.customtabs.CustomTabsServiceConnection
                public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                    customTabsClient.h(0L);
                    applicationContext.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            });
        } catch (SecurityException unused) {
            return false;
        }
    }

    private ICustomTabsCallback.Stub c(final CustomTabsCallback customTabsCallback) {
        return new ICustomTabsCallback.Stub() { // from class: androidx.browser.customtabs.CustomTabsClient.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Handler f2601a = new Handler(Looper.getMainLooper());

            @Override // android.support.customtabs.ICustomTabsCallback
            public void D3(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.10
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onUnminimized(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void E1(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.7
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onWarmupCompleted(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void P3(final int i3, final int i4, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onActivityResized(i3, i4, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void P4(final String str, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onPostMessage(str, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void W4(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onMessageChannelReady(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void Z4(final int i3, final Uri uri, final boolean z2, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onRelationshipValidationResult(i3, uri, z2, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void d0(final int i3, final int i4, final int i5, final int i6, final int i7, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.8
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onActivityLayout(i3, i4, i5, i6, i7, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void s3(final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.9
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onMinimized(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void t4(final int i3, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onNavigationEvent(i3, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void u1(final String str, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2601a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.extraCallback(str, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public Bundle w0(String str, Bundle bundle) {
                CustomTabsCallback customTabsCallback2 = customTabsCallback;
                if (customTabsCallback2 == null) {
                    return null;
                }
                return customTabsCallback2.extraCallbackWithResult(str, bundle);
            }
        };
    }

    public static String d(Context context, List list) {
        return e(context, list, false);
    }

    public static String e(Context context, List list, boolean z2) {
        ResolveInfo resolveInfoResolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z2 && (resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    private CustomTabsSession g(CustomTabsCallback customTabsCallback, PendingIntent pendingIntent) {
        boolean zD4;
        ICustomTabsCallback.Stub stubC = c(customTabsCallback);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                zD4 = this.f2597a.r1(stubC, bundle);
            } else {
                zD4 = this.f2597a.d4(stubC);
            }
            if (zD4) {
                return new CustomTabsSession(this.f2597a, stubC, this.f2598b, pendingIntent);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public CustomTabsSession f(CustomTabsCallback customTabsCallback) {
        return g(customTabsCallback, null);
    }

    public boolean h(long j3) {
        try {
            return this.f2597a.n3(j3);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
