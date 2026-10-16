package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f53826a;

    CompositeOnPageChangeCallback(int i3) {
        this.f53826a = new ArrayList(i3);
    }

    private void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void a(int i3) {
        try {
            Iterator it = this.f53826a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.OnPageChangeCallback) it.next()).a(i3);
            }
        } catch (ConcurrentModificationException e3) {
            f(e3);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void b(int i3, float f3, int i4) {
        try {
            Iterator it = this.f53826a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.OnPageChangeCallback) it.next()).b(i3, f3, i4);
            }
        } catch (ConcurrentModificationException e3) {
            f(e3);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void c(int i3) {
        try {
            Iterator it = this.f53826a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.OnPageChangeCallback) it.next()).c(i3);
            }
        } catch (ConcurrentModificationException e3) {
            f(e3);
        }
    }

    void d(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f53826a.add(onPageChangeCallback);
    }

    void e(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f53826a.remove(onPageChangeCallback);
    }
}
