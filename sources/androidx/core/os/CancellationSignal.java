package androidx.core.os;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class CancellationSignal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f34146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OnCancelListener f34147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f34148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34149d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCancelListener {
        void onCancel();
    }

    private void d() {
        while (this.f34149d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f34146a) {
                    return;
                }
                this.f34146a = true;
                this.f34149d = true;
                OnCancelListener onCancelListener = this.f34147b;
                Object obj = this.f34148c;
                if (onCancelListener != null) {
                    try {
                        onCancelListener.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f34149d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((android.os.CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f34149d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public Object b() {
        Object obj;
        synchronized (this) {
            try {
                if (this.f34148c == null) {
                    android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                    this.f34148c = cancellationSignal;
                    if (this.f34146a) {
                        cancellationSignal.cancel();
                    }
                }
                obj = this.f34148c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public void c(OnCancelListener onCancelListener) {
        synchronized (this) {
            try {
                d();
                if (this.f34147b == onCancelListener) {
                    return;
                }
                this.f34147b = onCancelListener;
                if (this.f34146a && onCancelListener != null) {
                    onCancelListener.onCancel();
                }
            } finally {
            }
        }
    }
}
