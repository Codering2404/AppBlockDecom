package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AsyncDifferConfig<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f51472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f51473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DiffUtil.ItemCallback f51474c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Object f51475d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Executor f51476e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Executor f51477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Executor f51478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DiffUtil.ItemCallback f51479c;

        public Builder(DiffUtil.ItemCallback itemCallback) {
            this.f51479c = itemCallback;
        }

        public AsyncDifferConfig a() {
            if (this.f51478b == null) {
                synchronized (f51475d) {
                    try {
                        if (f51476e == null) {
                            f51476e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.f51478b = f51476e;
            }
            return new AsyncDifferConfig(this.f51477a, this.f51478b, this.f51479c);
        }
    }

    AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback itemCallback) {
        this.f51472a = executor;
        this.f51473b = executor2;
        this.f51474c = itemCallback;
    }

    public Executor a() {
        return this.f51473b;
    }

    public DiffUtil.ItemCallback b() {
        return this.f51474c;
    }

    public Executor c() {
        return this.f51472a;
    }
}
