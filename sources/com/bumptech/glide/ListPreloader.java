package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f66071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PreloadTargetQueue f66072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RequestManager f66073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PreloadModelProvider f66074d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PreloadSizeProvider f66075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f66076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f66077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f66078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f66079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f66080k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PreloadModelProvider<U> {
        List a(int i3);

        RequestBuilder b(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PreloadSizeProvider<T> {
        int[] a(Object obj, int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PreloadTargetQueue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue f66084a;

        public PreloadTarget a(int i3, int i4) {
            PreloadTarget preloadTarget = (PreloadTarget) this.f66084a.poll();
            this.f66084a.offer(preloadTarget);
            preloadTarget.f66082b = i3;
            preloadTarget.f66081a = i4;
            return preloadTarget;
        }
    }

    private void a() {
        for (int i3 = 0; i3 < this.f66072b.f66084a.size(); i3++) {
            this.f66073c.l(this.f66072b.a(0, 0));
        }
    }

    private void b(int i3, int i4) {
        int iMin;
        int iMax;
        if (i3 < i4) {
            iMax = Math.max(this.f66076g, i3);
            iMin = i4;
        } else {
            iMin = Math.min(this.f66077h, i3);
            iMax = i4;
        }
        int iMin2 = Math.min(this.f66079j, iMin);
        int iMin3 = Math.min(this.f66079j, Math.max(0, iMax));
        if (i3 < i4) {
            for (int i5 = iMin3; i5 < iMin2; i5++) {
                d(this.f66074d.a(i5), i5, true);
            }
        } else {
            for (int i6 = iMin2 - 1; i6 >= iMin3; i6--) {
                d(this.f66074d.a(i6), i6, false);
            }
        }
        this.f66077h = iMin3;
        this.f66076g = iMin2;
    }

    private void c(int i3, boolean z2) {
        if (this.f66080k != z2) {
            this.f66080k = z2;
            a();
        }
        b(i3, (z2 ? this.f66071a : -this.f66071a) + i3);
    }

    private void d(List list, int i3, boolean z2) {
        int size = list.size();
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                e(list.get(i4), i3, i4);
            }
            return;
        }
        for (int i5 = size - 1; i5 >= 0; i5--) {
            e(list.get(i5), i3, i5);
        }
    }

    private void e(Object obj, int i3, int i4) {
        int[] iArrA;
        RequestBuilder requestBuilderB;
        if (obj == null || (iArrA = this.f66075f.a(obj, i3, i4)) == null || (requestBuilderB = this.f66074d.b(obj)) == null) {
            return;
        }
        requestBuilderB.C0(this.f66072b.a(iArrA[0], iArrA[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        if (this.f66079j == 0 && i5 == 0) {
            return;
        }
        this.f66079j = i5;
        int i6 = this.f66078i;
        if (i3 > i6) {
            c(i4 + i3, true);
        } else if (i3 < i6) {
            c(i3, false);
        }
        this.f66078i = i3;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PreloadTarget implements Target<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f66081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f66082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Request f66083c;

        @Override // com.bumptech.glide.request.target.Target
        public Request b() {
            return this.f66083c;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void i(Request request) {
            this.f66083c = request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void k(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.d(this.f66082b, this.f66081a);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void c(SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void f(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void g(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void j(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void h(Object obj, Transition transition) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
    }
}
