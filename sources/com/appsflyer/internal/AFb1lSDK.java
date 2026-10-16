package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.appsflyer.internal.AFb1iSDK;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1lSDK implements AFb1iSDK {
    private final Executor AFInAppEventType;
    private final AFf1rSDK AFKeystoreWrapper;
    private final AFb1sSDK valueOf;
    private AFb1jSDK values;

    public AFb1lSDK(Executor executor, AFb1sSDK aFb1sSDK, AFf1rSDK aFf1rSDK) {
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(aFb1sSDK, "");
        Intrinsics.checkNotNullParameter(aFf1rSDK, "");
        this.AFInAppEventType = executor;
        this.valueOf = aFb1sSDK;
        this.AFKeystoreWrapper = aFf1rSDK;
    }

    @Override // com.appsflyer.internal.AFb1iSDK
    public final boolean AFKeystoreWrapper() {
        return this.values != null;
    }

    @Override // com.appsflyer.internal.AFb1iSDK
    public final void valueOf(Context context, AFb1iSDK.AFa1vSDK aFa1vSDK) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFa1vSDK, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (this.values != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
            }
            ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.values);
        }
        this.values = null;
        AFb1jSDK aFb1jSDK = new AFb1jSDK(this.AFInAppEventType, this.valueOf, this.AFKeystoreWrapper, aFa1vSDK);
        this.values = aFb1jSDK;
        if (context instanceof Activity) {
            aFb1jSDK.onActivityResumed((Activity) context);
        }
        Context applicationContext2 = context.getApplicationContext();
        if (applicationContext2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(this.values);
    }

    @Override // com.appsflyer.internal.AFb1iSDK
    public final void AFKeystoreWrapper(Context context) {
        AFb1iSDK.AFa1vSDK aFa1vSDK;
        Intrinsics.checkNotNullParameter(context, "");
        AFb1jSDK aFb1jSDK = this.values;
        if (aFb1jSDK == null || (aFa1vSDK = aFb1jSDK.valueOf) == null) {
            return;
        }
        aFa1vSDK.AFInAppEventType(context);
    }
}
