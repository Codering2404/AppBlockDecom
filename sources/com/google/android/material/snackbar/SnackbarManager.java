package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class SnackbarManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static SnackbarManager f82111e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f82112a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f82113b = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.d((SnackbarRecord) message.obj);
            return true;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SnackbarRecord f82114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SnackbarRecord f82115d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        void a(int i3);

        void show();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SnackbarRecord {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference f82117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f82118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f82119c;

        SnackbarRecord(int i3, Callback callback) {
            this.f82117a = new WeakReference(callback);
            this.f82118b = i3;
        }

        boolean a(Callback callback) {
            return callback != null && this.f82117a.get() == callback;
        }
    }

    private SnackbarManager() {
    }

    private boolean a(SnackbarRecord snackbarRecord, int i3) {
        Callback callback = (Callback) snackbarRecord.f82117a.get();
        if (callback == null) {
            return false;
        }
        this.f82113b.removeCallbacksAndMessages(snackbarRecord);
        callback.a(i3);
        return true;
    }

    static SnackbarManager c() {
        if (f82111e == null) {
            f82111e = new SnackbarManager();
        }
        return f82111e;
    }

    private boolean f(Callback callback) {
        SnackbarRecord snackbarRecord = this.f82114c;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    private boolean g(Callback callback) {
        SnackbarRecord snackbarRecord = this.f82115d;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    private void l(SnackbarRecord snackbarRecord) {
        int i3 = snackbarRecord.f82118b;
        if (i3 == -2) {
            return;
        }
        if (i3 <= 0) {
            i3 = i3 == -1 ? 1500 : 2750;
        }
        this.f82113b.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.f82113b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i3);
    }

    private void n() {
        SnackbarRecord snackbarRecord = this.f82115d;
        if (snackbarRecord != null) {
            this.f82114c = snackbarRecord;
            this.f82115d = null;
            Callback callback = (Callback) snackbarRecord.f82117a.get();
            if (callback != null) {
                callback.show();
            } else {
                this.f82114c = null;
            }
        }
    }

    public void b(Callback callback, int i3) {
        synchronized (this.f82112a) {
            try {
                if (f(callback)) {
                    a(this.f82114c, i3);
                } else if (g(callback)) {
                    a(this.f82115d, i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void d(SnackbarRecord snackbarRecord) {
        synchronized (this.f82112a) {
            try {
                if (this.f82114c == snackbarRecord || this.f82115d == snackbarRecord) {
                    a(snackbarRecord, 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(Callback callback) {
        boolean z2;
        synchronized (this.f82112a) {
            try {
                z2 = f(callback) || g(callback);
            } finally {
            }
        }
        return z2;
    }

    public void h(Callback callback) {
        synchronized (this.f82112a) {
            try {
                if (f(callback)) {
                    this.f82114c = null;
                    if (this.f82115d != null) {
                        n();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(Callback callback) {
        synchronized (this.f82112a) {
            try {
                if (f(callback)) {
                    l(this.f82114c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(Callback callback) {
        synchronized (this.f82112a) {
            try {
                if (f(callback)) {
                    SnackbarRecord snackbarRecord = this.f82114c;
                    if (!snackbarRecord.f82119c) {
                        snackbarRecord.f82119c = true;
                        this.f82113b.removeCallbacksAndMessages(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(Callback callback) {
        synchronized (this.f82112a) {
            try {
                if (f(callback)) {
                    SnackbarRecord snackbarRecord = this.f82114c;
                    if (snackbarRecord.f82119c) {
                        snackbarRecord.f82119c = false;
                        l(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m(int i3, Callback callback) {
        synchronized (this.f82112a) {
            try {
                if (f(callback)) {
                    SnackbarRecord snackbarRecord = this.f82114c;
                    snackbarRecord.f82118b = i3;
                    this.f82113b.removeCallbacksAndMessages(snackbarRecord);
                    l(this.f82114c);
                    return;
                }
                if (g(callback)) {
                    this.f82115d.f82118b = i3;
                } else {
                    this.f82115d = new SnackbarRecord(i3, callback);
                }
                SnackbarRecord snackbarRecord2 = this.f82114c;
                if (snackbarRecord2 == null || !a(snackbarRecord2, 4)) {
                    this.f82114c = null;
                    n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
