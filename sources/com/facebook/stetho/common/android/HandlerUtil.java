package com.facebook.stetho.common.android;

import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class HandlerUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class WaitableRunnable<V> implements Runnable {
        private Exception mException;
        private boolean mIsDone;
        private V mValue;

        protected WaitableRunnable() {
        }

        private void join() {
            synchronized (this) {
                while (!this.mIsDone) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        public V invoke(Handler handler) {
            if (!handler.post(this)) {
                throw new RuntimeException("Handler.post() returned false");
            }
            join();
            if (this.mException == null) {
                return this.mValue;
            }
            throw new RuntimeException(this.mException);
        }

        protected abstract V onRun();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    this.mValue = onRun();
                    this.mException = null;
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                    }
                } catch (Exception e3) {
                    this.mValue = null;
                    this.mException = e3;
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                    }
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.mIsDone = true;
                    notifyAll();
                    throw th;
                }
            }
        }
    }

    private HandlerUtil() {
    }

    public static boolean checkThreadAccess(Handler handler) {
        return Looper.myLooper() == handler.getLooper();
    }

    public static <V> V postAndWait(Handler handler, final UncheckedCallable<V> uncheckedCallable) {
        if (!checkThreadAccess(handler)) {
            return new WaitableRunnable<V>() { // from class: com.facebook.stetho.common.android.HandlerUtil.1
                @Override // com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable
                protected V onRun() {
                    return (V) uncheckedCallable.call();
                }
            }.invoke(handler);
        }
        try {
            return uncheckedCallable.call();
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public static void verifyThreadAccess(Handler handler) {
        Util.throwIfNot(checkThreadAccess(handler));
    }

    public static void postAndWait(Handler handler, final Runnable runnable) {
        if (checkThreadAccess(handler)) {
            try {
                runnable.run();
                return;
            } catch (RuntimeException e3) {
                throw new RuntimeException(e3);
            }
        }
        new WaitableRunnable<Void>() { // from class: com.facebook.stetho.common.android.HandlerUtil.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable
            public Void onRun() {
                runnable.run();
                return null;
            }
        }.invoke(handler);
    }
}
