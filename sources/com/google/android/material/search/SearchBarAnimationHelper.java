package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.search.SearchBar;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class SearchBarAnimationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f81645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Animator f81646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Animator f81647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f81648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f81649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f81650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Animator f81651g;

    /* JADX INFO: renamed from: com.google.android.material.search.SearchBarAnimationHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBarAnimationHelper f81652a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f81652a.e(new OnLoadAnimationInvocation() { // from class: com.google.android.material.search.b
                @Override // com.google.android.material.search.SearchBarAnimationHelper.OnLoadAnimationInvocation
                public final void a(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
                    onLoadAnimationCallback.a();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.search.SearchBarAnimationHelper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f81653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Animator f81654b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f81653a.setVisibility(8);
            this.f81654b.start();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.search.SearchBarAnimationHelper$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBarAnimationHelper f81655a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f81655a.f81651g = null;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.search.SearchBarAnimationHelper$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBar f81656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchBarAnimationHelper f81657b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f81657b.f81648d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f81656a.setVisibility(4);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.search.SearchBarAnimationHelper$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBarAnimationHelper f81658a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f81658a.f81651g = null;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.search.SearchBarAnimationHelper$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass6 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SearchBar f81659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SearchBarAnimationHelper f81660b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f81659a.setVisibility(0);
            this.f81660b.f81649e = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f81659a.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnLoadAnimationInvocation {
        void a(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(OnLoadAnimationInvocation onLoadAnimationInvocation) {
        Iterator it = this.f81645a.iterator();
        while (it.hasNext()) {
            onLoadAnimationInvocation.a((SearchBar.OnLoadAnimationCallback) it.next());
        }
    }

    void f(boolean z2) {
        this.f81650f = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void g(SearchBar searchBar) {
        Animator animator = this.f81646b;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f81647c;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView instanceof AnimatableView) {
            ((AnimatableView) centerView).j();
        }
        if (centerView != 0) {
            centerView.setAlpha(0.0f);
        }
    }
}
