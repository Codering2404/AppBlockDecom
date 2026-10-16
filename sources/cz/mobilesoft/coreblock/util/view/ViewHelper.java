package cz.mobilesoft.coreblock.util.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.tabs.TabLayout;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.badge.BadgeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class ViewHelper {
    public static /* synthetic */ Unit a(String str, Drawable drawable, ImageView imageView, RequestManager requestManager) {
        RequestBuilder requestBuilderQ = requestManager.q("https://f1.allesedv.com/32/" + str);
        if (drawable != null) {
            requestBuilderQ = (RequestBuilder) ((RequestBuilder) requestBuilderQ.c0(drawable)).m(drawable);
        }
        requestBuilderQ.a(RequestOptions.t0()).F0(imageView);
        return Unit.f139807a;
    }

    public static int b(float f3, Context context) {
        return (int) (f3 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    public static int c(Context context) {
        return context.getResources().getConfiguration().uiMode & 48;
    }

    public static void d(TabLayout tabLayout, Context context) {
        ViewGroup viewGroup = (ViewGroup) tabLayout.getChildAt(0);
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (i3 != 0) {
                layoutParams.setMarginStart(b(8.0f, context));
            }
            if (i3 != viewGroup.getChildCount() - 1) {
                layoutParams.setMarginEnd(b(8.0f, context));
            }
            layoutParams.gravity = 1;
            layoutParams.width = -2;
            childAt.setLayoutParams(layoutParams);
            tabLayout.requestLayout();
        }
    }

    public static boolean e(Context context) {
        return c(context) == 32;
    }

    public static void f(final ImageView imageView, final String str) {
        Context context = imageView.getContext();
        final Drawable drawableB = AppCompatResources.b(context, R.drawable.T6);
        ViewHelperExtKt.f(context, new Function1() { // from class: cz.mobilesoft.coreblock.util.view.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ViewHelper.a(str, drawableB, imageView, (RequestManager) obj);
            }
        });
    }

    public static void g(final BadgeView badgeView, String str) {
        Drawable drawableB = AppCompatResources.b(badgeView.getContext(), R.drawable.T6);
        RequestBuilder requestBuilderQ = Glide.t(badgeView.getContext()).q("https://f1.allesedv.com/32/" + str);
        if (drawableB != null) {
            requestBuilderQ = (RequestBuilder) ((RequestBuilder) requestBuilderQ.c0(drawableB)).m(drawableB);
        }
        requestBuilderQ.a(RequestOptions.t0()).C0(new CustomTarget<Drawable>() { // from class: cz.mobilesoft.coreblock.util.view.ViewHelper.1
            @Override // com.bumptech.glide.request.target.Target
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void h(Drawable drawable, Transition transition) {
                badgeView.setImageDrawable(drawable);
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void f(Drawable drawable) {
                badgeView.setImageDrawable(drawable);
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void j(Drawable drawable) {
                badgeView.setImageDrawable(drawable);
            }

            @Override // com.bumptech.glide.request.target.Target
            public void g(Drawable drawable) {
            }
        });
    }

    public static void h(Context context, View view) {
        i(view, ResourcesCompat.i(context, R.font.f95584a));
    }

    public static void i(View view, Typeface typeface) {
        try {
            if (!(view instanceof ViewGroup)) {
                if (view instanceof TextView) {
                    ((TextView) view).setTypeface(typeface);
                }
            } else {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    i(viewGroup.getChildAt(i3), typeface);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static float j(int i3, Context context) {
        return i3 / (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static void k(View view, float f3) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "rotation", f3);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.start();
    }
}
