package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1iSDK;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AFb1jSDK implements Application.ActivityLifecycleCallbacks {
    private final AFf1rSDK AFInAppEventParameterName;
    boolean AFInAppEventType;
    private final AFb1sSDK AFKeystoreWrapper;
    private boolean afDebugLog;
    final AFb1iSDK.AFa1vSDK valueOf;
    private final Executor values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AFa1ySDK extends TimerTask {
        private /* synthetic */ Context values;

        AFa1ySDK(Context context) {
            this.values = context;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (AFb1jSDK.this.AFInAppEventType && AFb1jSDK.this.afDebugLog) {
                AFb1jSDK aFb1jSDK = AFb1jSDK.this;
                aFb1jSDK.AFInAppEventType = false;
                try {
                    AFb1iSDK.AFa1vSDK aFa1vSDK = aFb1jSDK.valueOf;
                    Context context = this.values;
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    aFa1vSDK.AFInAppEventType(context);
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Listener threw exception! ", e3);
                }
            }
        }
    }

    public AFb1jSDK(Executor executor, AFb1sSDK aFb1sSDK, AFf1rSDK aFf1rSDK, AFb1iSDK.AFa1vSDK aFa1vSDK) {
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(aFb1sSDK, "");
        Intrinsics.checkNotNullParameter(aFf1rSDK, "");
        Intrinsics.checkNotNullParameter(aFa1vSDK, "");
        this.values = executor;
        this.AFKeystoreWrapper = aFb1sSDK;
        this.AFInAppEventParameterName = aFf1rSDK;
        this.valueOf = aFa1vSDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFInAppEventType(AFb1jSDK aFb1jSDK, Activity activity) {
        Intrinsics.checkNotNullParameter(aFb1jSDK, "");
        Intrinsics.checkNotNullParameter(activity, "");
        AFb1sSDK aFb1sSDK = aFb1jSDK.AFKeystoreWrapper;
        Intent intent = activity.getIntent();
        if (((intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) ? null : intent.getData()) != null && intent != AFb1sSDK.values) {
            AFb1sSDK.values = intent;
        }
        aFb1jSDK.AFInAppEventParameterName.values(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(final Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.values.execute(new Runnable() { // from class: com.appsflyer.internal.h
            @Override // java.lang.Runnable
            public final void run() {
                AFb1jSDK.AFInAppEventType(this.f65642a, activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.values.execute(new Runnable() { // from class: com.appsflyer.internal.j
            @Override // java.lang.Runnable
            public final void run() {
                AFb1jSDK.AFKeystoreWrapper(this.f65646a, activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.values.execute(new Runnable() { // from class: com.appsflyer.internal.i
            @Override // java.lang.Runnable
            public final void run() {
                AFb1jSDK.values(this.f65644a, activity);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bundle, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFb1jSDK aFb1jSDK, Activity activity) {
        Intrinsics.checkNotNullParameter(aFb1jSDK, "");
        Intrinsics.checkNotNullParameter(activity, "");
        aFb1jSDK.afDebugLog = true;
        Context applicationContext = activity.getApplicationContext();
        try {
            Timer timer = new Timer();
            AFa1ySDK aFa1ySDK = aFb1jSDK.new AFa1ySDK(applicationContext);
            AFb1iSDK.AFa1xSDK aFa1xSDK = AFb1iSDK.AFa1xSDK;
            timer.schedule(aFa1ySDK, AFb1iSDK.AFa1xSDK.AFKeystoreWrapper());
        } catch (Throwable th) {
            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void values(AFb1jSDK aFb1jSDK, Activity activity) {
        Intrinsics.checkNotNullParameter(aFb1jSDK, "");
        Intrinsics.checkNotNullParameter(activity, "");
        if (!aFb1jSDK.AFInAppEventType) {
            try {
                aFb1jSDK.valueOf.AFInAppEventType(activity);
            } catch (Exception e3) {
                AFLogger.afErrorLog("Listener thrown an exception: ", e3, true);
            }
        }
        aFb1jSDK.afDebugLog = false;
        aFb1jSDK.AFInAppEventType = true;
    }
}
