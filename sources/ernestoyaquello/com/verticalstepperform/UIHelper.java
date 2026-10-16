package ernestoyaquello.com.verticalstepperform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class UIHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f134619a = new ConcurrentHashMap();

    private static void d(View view) {
        ObjectAnimator objectAnimator;
        Map map = f134619a;
        if (!map.containsKey(view) || (objectAnimator = (ObjectAnimator) map.get(view)) == null) {
            return;
        }
        objectAnimator.end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(View view, boolean z2) {
        h(view, z2 ? 0 : -2);
        view.setAlpha(z2 ? 0.0f : 1.0f);
        view.setVisibility(z2 ? 8 : 0);
    }

    private static void f(final View view, final boolean z2) {
        int height = view.getHeight();
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        if (height < 0) {
            height = z2 ? measuredHeight : 0;
            h(view, height);
        }
        float f3 = measuredHeight;
        final float f4 = height / f3;
        float f5 = z2 ? 0.0f : 1.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (f4 == f5) {
            d(view);
            e(view, z2);
            return;
        }
        long jAbs = ((int) ((f3 * Math.abs(f5 - f4)) / view.getContext().getResources().getDisplayMetrics().density)) * 2;
        if (jAbs < 150) {
            jAbs = 150;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, f4, f5);
        objectAnimatorOfFloat.setDuration(jAbs);
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ernestoyaquello.com.verticalstepperform.UIHelper.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                UIHelper.h(view, (int) (measuredHeight * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                view.requestLayout();
            }
        });
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ernestoyaquello.com.verticalstepperform.UIHelper.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                UIHelper.f134619a.remove(view);
                UIHelper.e(view, z2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(f4);
                view.setVisibility(0);
            }
        });
        d(view);
        f134619a.put(view, objectAnimatorOfFloat);
        objectAnimatorOfFloat.start();
    }

    static void g(AppCompatButton appCompatButton, int i3, int i4, int i5, int i6) {
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[0]};
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{i5, i5, i3});
        ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{i6, i6, i4});
        ViewCompat.r0(appCompatButton, colorStateList);
        appCompatButton.setTextColor(colorStateList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    static void i(View view, boolean z2) {
        if (z2) {
            f(view, false);
        } else {
            d(view);
            e(view, false);
        }
    }

    static void j(View view, boolean z2) {
        if (z2) {
            f(view, true);
        } else {
            d(view);
            e(view, true);
        }
    }
}
