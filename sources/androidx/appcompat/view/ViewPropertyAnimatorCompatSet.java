package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f1322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ViewPropertyAnimatorListener f1323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1324e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1321b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewPropertyAnimatorListenerAdapter f1325f = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1326a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1327b = 0;

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            int i3 = this.f1327b + 1;
            this.f1327b = i3;
            if (i3 == ViewPropertyAnimatorCompatSet.this.f1320a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f1323d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void c(View view) {
            if (this.f1326a) {
                return;
            }
            this.f1326a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f1323d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.c(null);
            }
        }

        void d() {
            this.f1327b = 0;
            this.f1326a = false;
            ViewPropertyAnimatorCompatSet.this.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList f1320a = new ArrayList();

    public void a() {
        if (this.f1324e) {
            ArrayList arrayList = this.f1320a;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((ViewPropertyAnimatorCompat) obj).c();
            }
            this.f1324e = false;
        }
    }

    void b() {
        this.f1324e = false;
    }

    public ViewPropertyAnimatorCompatSet c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f1324e) {
            this.f1320a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f1320a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.i(viewPropertyAnimatorCompat.d());
        this.f1320a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet e(long j3) {
        if (!this.f1324e) {
            this.f1321b = j3;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet f(Interpolator interpolator) {
        if (!this.f1324e) {
            this.f1322c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f1324e) {
            this.f1323d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (this.f1324e) {
            return;
        }
        ArrayList arrayList = this.f1320a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) obj;
            long j3 = this.f1321b;
            if (j3 >= 0) {
                viewPropertyAnimatorCompat.e(j3);
            }
            Interpolator interpolator = this.f1322c;
            if (interpolator != null) {
                viewPropertyAnimatorCompat.f(interpolator);
            }
            if (this.f1323d != null) {
                viewPropertyAnimatorCompat.g(this.f1325f);
            }
            viewPropertyAnimatorCompat.k();
        }
        this.f1324e = true;
    }
}
