package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestManagerRetriever implements Handler.Callback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final RequestManagerFactory f67037g = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile RequestManager f67038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestManagerFactory f67039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayMap f67040c = new ArrayMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FrameWaiter f67041d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LifecycleRequestManagerRetriever f67042f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RequestManagerFactory {
        RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        requestManagerFactory = requestManagerFactory == null ? f67037g : requestManagerFactory;
        this.f67039b = requestManagerFactory;
        this.f67042f = new LifecycleRequestManagerRetriever(requestManagerFactory);
        this.f67041d = b();
    }

    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static FrameWaiter b() {
        return (HardwareConfigState.f66877f && HardwareConfigState.f66876e) ? new FirstFrameWaiter() : new DoNothingFirstFrameWaiter();
    }

    private static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private RequestManager f(Context context) {
        if (this.f67038a == null) {
            synchronized (this) {
                try {
                    if (this.f67038a == null) {
                        this.f67038a = this.f67039b.a(Glide.c(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f67038a;
    }

    private static boolean g(Context context) {
        Activity activityC = c(context);
        return activityC == null || !activityC.isFinishing();
    }

    public RequestManager d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (Util.t() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return e((FragmentActivity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return d(contextWrapper.getBaseContext());
                }
            }
        }
        return f(context);
    }

    public RequestManager e(FragmentActivity fragmentActivity) {
        if (Util.s()) {
            return d(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.f67041d.a(fragmentActivity);
        boolean zG = g(fragmentActivity);
        return this.f67042f.b(fragmentActivity, Glide.c(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), zG);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }
}
