package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ResourceRecycler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f66523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f66524b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ResourceRecyclerCallback implements Handler.Callback {
        ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).a();
            return true;
        }
    }

    ResourceRecycler() {
    }

    synchronized void a(Resource resource, boolean z2) {
        try {
            if (this.f66523a || z2) {
                this.f66524b.obtainMessage(1, resource).sendToTarget();
            } else {
                this.f66523a = true;
                resource.a();
                this.f66523a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
