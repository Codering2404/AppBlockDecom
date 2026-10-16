package androidx.recyclerview.widget;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SortedList<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BatchedCallback<T2> extends Callback<T2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Callback f52007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BatchingListUpdateCallback f52008b;

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void a(int i3, int i4) {
            this.f52008b.a(i3, i4);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void b(int i3, int i4) {
            this.f52008b.b(i3, i4);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void c(int i3, int i4, Object obj) {
            this.f52008b.c(i3, i4, obj);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return this.f52007a.compare(obj, obj2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void d(int i3, int i4) {
            this.f52008b.d(i3, i4);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void e(int i3, int i4) {
            this.f52008b.c(i3, i4, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public void c(int i3, int i4, Object obj) {
            e(i3, i4);
        }

        @Override // java.util.Comparator
        public abstract int compare(Object obj, Object obj2);

        public abstract void e(int i3, int i4);
    }
}
