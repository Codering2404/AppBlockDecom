package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zq {
    public static void a(View view, long j3) {
        a(view, j3, (Runnable) null);
    }

    public static boolean b(int i3) {
        return i3 == 0;
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static void a(View view, long j3, Runnable runnable) {
        view.setVisibility(4);
        view.bringToFront();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j3);
        alphaAnimation.setAnimationListener(new a(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static void b(View view, long j3, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j3);
        alphaAnimation.setAnimationListener(new b(view, runnable));
        view.startAnimation(alphaAnimation);
    }

    public static View b(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById != null ? viewFindViewById : rootView;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] a(int r2, int r3, int r4) {
        /*
            if (r2 != 0) goto L7
            int[] r2 = new int[]{r3, r4}
            return r2
        L7:
            r0 = r2 & 119(0x77, float:1.67E-43)
            r1 = 119(0x77, float:1.67E-43)
            if (r0 != r1) goto L14
            r2 = 13
            int[] r2 = new int[]{r2}
            return r2
        L14:
            r0 = r2 & 112(0x70, float:1.57E-43)
            r1 = 112(0x70, float:1.57E-43)
            if (r0 != r1) goto L1b
            goto L33
        L1b:
            r0 = r2 & 48
            r1 = 48
            if (r0 != r1) goto L24
            r3 = 10
            goto L35
        L24:
            r0 = r2 & 80
            r1 = 80
            if (r0 != r1) goto L2d
            r3 = 12
            goto L35
        L2d:
            r0 = r2 & 16
            r1 = 16
            if (r0 != r1) goto L35
        L33:
            r3 = 15
        L35:
            r0 = r2 & 7
            r1 = 7
            if (r0 != r1) goto L3b
            goto L6f
        L3b:
            boolean r0 = com.applovin.impl.z3.d()
            if (r0 == 0) goto L4b
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r1 = r2 & r0
            if (r1 != r0) goto L4b
            r4 = 20
            goto L71
        L4b:
            r0 = r2 & 3
            r1 = 3
            if (r0 != r1) goto L53
            r4 = 9
            goto L71
        L53:
            boolean r0 = com.applovin.impl.z3.d()
            if (r0 == 0) goto L63
            r0 = 8388613(0x800005, float:1.175495E-38)
            r1 = r2 & r0
            if (r1 != r0) goto L63
            r4 = 21
            goto L71
        L63:
            r0 = r2 & 5
            r1 = 5
            if (r0 != r1) goto L6b
            r4 = 11
            goto L71
        L6b:
            r0 = 1
            r2 = r2 & r0
            if (r2 != r0) goto L71
        L6f:
            r4 = 14
        L71:
            int[] r2 = new int[]{r4, r3}
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.zq.a(int, int, int):int[]");
    }

    public static String a(int i3) {
        if (i3 == 0) {
            return "VISIBLE";
        }
        if (i3 == 4) {
            return "INVISIBLE";
        }
        if (i3 == 8) {
            return "GONE";
        }
        return String.valueOf(i3);
    }

    public static boolean a(int i3, int i4) {
        return b(i3) != b(i4);
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                if (a(view, viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(View view, Activity activity) {
        if (activity != null && view != null) {
            Window window = activity.getWindow();
            if (window != null) {
                return a(view, window.getDecorView());
            }
            View viewFindViewById = activity.findViewById(R.id.content);
            if (viewFindViewById != null) {
                return a(view, viewFindViewById.getRootView());
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f65484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f65485b;

        a(View view, Runnable runnable) {
            this.f65484a = view;
            this.f65485b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.f65485b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f65484a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f65486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f65487b;

        b(View view, Runnable runnable) {
            this.f65486a = view;
            this.f65487b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f65486a.setVisibility(4);
            Runnable runnable = this.f65487b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f65486a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public static Activity a(View view, com.applovin.impl.sdk.j jVar) {
        if (view == null) {
            return null;
        }
        for (int i3 = 0; i3 < 1000; i3++) {
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("ViewUtils", "Encountered error while retrieving activity from view", th);
                }
            }
        }
        return null;
    }

    public static String a(View view) {
        return view.getClass().getName() + '@' + Integer.toHexString(view.hashCode());
    }
}
