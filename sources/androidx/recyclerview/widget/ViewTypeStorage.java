package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
interface ViewTypeStorage {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class IsolatedViewTypeStorage implements ViewTypeStorage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray f52076a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f52077b = 0;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class WrapperViewTypeLookup implements ViewTypeLookup {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private SparseIntArray f52078a = new SparseIntArray(1);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private SparseIntArray f52079b = new SparseIntArray(1);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final NestedAdapterWrapper f52080c;

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.f52080c = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int a(int i3) {
                int iIndexOfKey = this.f52079b.indexOfKey(i3);
                if (iIndexOfKey >= 0) {
                    return this.f52079b.valueAt(iIndexOfKey);
                }
                throw new IllegalStateException("requested global type " + i3 + " does not belong to the adapter:" + this.f52080c.f51822c);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int b(int i3) {
                int iIndexOfKey = this.f52078a.indexOfKey(i3);
                if (iIndexOfKey > -1) {
                    return this.f52078a.valueAt(iIndexOfKey);
                }
                int iC = IsolatedViewTypeStorage.this.c(this.f52080c);
                this.f52078a.put(i3, iC);
                this.f52079b.put(iC, i3);
                return iC;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                IsolatedViewTypeStorage.this.d(this.f52080c);
            }
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public NestedAdapterWrapper a(int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = (NestedAdapterWrapper) this.f52076a.get(i3);
            if (nestedAdapterWrapper != null) {
                return nestedAdapterWrapper;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i3);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public ViewTypeLookup b(NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        int c(NestedAdapterWrapper nestedAdapterWrapper) {
            int i3 = this.f52077b;
            this.f52077b = i3 + 1;
            this.f52076a.put(i3, nestedAdapterWrapper);
            return i3;
        }

        void d(NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.f52076a.size() - 1; size >= 0; size--) {
                if (((NestedAdapterWrapper) this.f52076a.valueAt(size)) == nestedAdapterWrapper) {
                    this.f52076a.removeAt(size);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ViewTypeLookup {
        int a(int i3);

        int b(int i3);

        void dispose();
    }

    NestedAdapterWrapper a(int i3);

    ViewTypeLookup b(NestedAdapterWrapper nestedAdapterWrapper);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray f52082a = new SparseArray();

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public NestedAdapterWrapper a(int i3) {
            List list = (List) this.f52082a.get(i3);
            if (list != null && !list.isEmpty()) {
                return (NestedAdapterWrapper) list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i3);
        }

        @Override // androidx.recyclerview.widget.ViewTypeStorage
        public ViewTypeLookup b(NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        void c(NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.f52082a.size() - 1; size >= 0; size--) {
                List list = (List) this.f52082a.valueAt(size);
                if (list.remove(nestedAdapterWrapper) && list.isEmpty()) {
                    this.f52082a.removeAt(size);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class WrapperViewTypeLookup implements ViewTypeLookup {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final NestedAdapterWrapper f52083a;

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.f52083a = nestedAdapterWrapper;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int b(int i3) {
                List arrayList = (List) SharedIdRangeViewTypeStorage.this.f52082a.get(i3);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    SharedIdRangeViewTypeStorage.this.f52082a.put(i3, arrayList);
                }
                if (!arrayList.contains(this.f52083a)) {
                    arrayList.add(this.f52083a);
                }
                return i3;
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                SharedIdRangeViewTypeStorage.this.c(this.f52083a);
            }

            @Override // androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup
            public int a(int i3) {
                return i3;
            }
        }
    }
}
