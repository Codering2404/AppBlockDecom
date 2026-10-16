package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Handler f67219f = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bumptech.glide.request.target.PreloadTarget.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((PreloadTarget) message.obj).a();
            return true;
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RequestManager f67220d;

    void a() {
        this.f67220d.l(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void h(Object obj, Transition transition) {
        Request requestB = b();
        if (requestB == null || !requestB.g()) {
            return;
        }
        f67219f.obtainMessage(1, this).sendToTarget();
    }

    @Override // com.bumptech.glide.request.target.Target
    public void g(Drawable drawable) {
    }
}
