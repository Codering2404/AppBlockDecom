package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncListDiffer<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Executor f51480h = new MainThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListUpdateCallback f51481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AsyncDifferConfig f51482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Executor f51483c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f51485e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f51487g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f51484d = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f51486f = Collections.EMPTY_LIST;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ListListener<T> {
        void a(List list, List list2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MainThreadExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Handler f51496a = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f51496a.post(runnable);
        }
    }

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig asyncDifferConfig) {
        this.f51481a = listUpdateCallback;
        this.f51482b = asyncDifferConfig;
        if (asyncDifferConfig.c() != null) {
            this.f51483c = asyncDifferConfig.c();
        } else {
            this.f51483c = f51480h;
        }
    }

    private void d(List list, Runnable runnable) {
        Iterator it = this.f51484d.iterator();
        while (it.hasNext()) {
            ((ListListener) it.next()).a(list, this.f51486f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(ListListener listListener) {
        this.f51484d.add(listListener);
    }

    public List b() {
        return this.f51486f;
    }

    void c(List list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        List list2 = this.f51486f;
        this.f51485e = list;
        this.f51486f = Collections.unmodifiableList(list);
        diffResult.c(this.f51481a);
        d(list2, runnable);
    }

    public void e(List list) {
        f(list, null);
    }

    public void f(final List list, final Runnable runnable) {
        final int i3 = this.f51487g + 1;
        this.f51487g = i3;
        final List list2 = this.f51485e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List list3 = this.f51486f;
        if (list == null) {
            int size = list2.size();
            this.f51485e = null;
            this.f51486f = Collections.EMPTY_LIST;
            this.f51481a.b(0, size);
            d(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.f51482b.a().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult diffResultB = DiffUtil.b(new DiffUtil.Callback() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean a(int i4, int i5) {
                            Object obj = list2.get(i4);
                            Object obj2 = list.get(i5);
                            if (obj != null && obj2 != null) {
                                return AsyncListDiffer.this.f51482b.b().a(obj, obj2);
                            }
                            if (obj == null && obj2 == null) {
                                return true;
                            }
                            throw new AssertionError();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean b(int i4, int i5) {
                            Object obj = list2.get(i4);
                            Object obj2 = list.get(i5);
                            return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.f51482b.b().b(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public Object c(int i4, int i5) {
                            Object obj = list2.get(i4);
                            Object obj2 = list.get(i5);
                            if (obj == null || obj2 == null) {
                                throw new AssertionError();
                            }
                            return AsyncListDiffer.this.f51482b.b().c(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int d() {
                            return list.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int e() {
                            return list2.size();
                        }
                    });
                    AsyncListDiffer.this.f51483c.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                            if (asyncListDiffer.f51487g == i3) {
                                asyncListDiffer.c(list, diffResultB, runnable);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.f51485e = list;
        this.f51486f = Collections.unmodifiableList(list);
        this.f51481a.a(0, list.size());
        d(list3, runnable);
    }
}
