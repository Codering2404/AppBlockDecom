package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class r {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f62688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f62689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f62690c;

        a(Class cls, b bVar, q qVar) {
            this.f62688a = cls;
            this.f62689b = bVar;
            this.f62690c = qVar;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.f62688a.isInstance(activity)) {
                this.f62689b.a(activity);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!this.f62688a.isInstance(activity) || activity.isChangingConfigurations()) {
                return;
            }
            this.f62690c.b(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(Activity activity);
    }

    public static Activity a(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static void a(boolean z2, Activity activity) {
        if (z2 && z3.b()) {
            WindowInsetsController insetsController = activity.getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsBehavior(2);
                insetsController.hide(WindowInsets.Type.systemBars());
                return;
            } else {
                activity.getWindow().getDecorView().setSystemUiVisibility(5894);
                return;
            }
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public static boolean a(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isChangingConfigurations()) {
            return true;
        }
        return z3.d() && activity.isDestroyed();
    }

    public static void a(Context context, Class cls) {
        Intent intent = new Intent(context, (Class<?>) cls);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, Class cls, q qVar, b bVar) {
        qVar.a(new a(cls, bVar, qVar));
        a(context, cls);
    }
}
