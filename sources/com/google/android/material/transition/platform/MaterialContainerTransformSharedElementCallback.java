package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static WeakReference f82792f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f82793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f82794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f82795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Rect f82796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ShapeProvider f82797e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ShapeProvider {
        ShapeAppearanceModel a(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ShapeableViewShapeProvider implements ShapeProvider {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        public ShapeAppearanceModel a(View view) {
            if (view instanceof Shapeable) {
                return ((Shapeable) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    private static Drawable e(Window window) {
        return window.getDecorView().getBackground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Window window) {
        Drawable drawableE = e(window);
        if (drawableE == null) {
            return;
        }
        drawableE.mutate().setColorFilter(BlendModeColorFilterCompat.a(0, BlendModeCompat.CLEAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Window window) {
        Drawable drawableE = e(window);
        if (drawableE == null) {
            return;
        }
        drawableE.mutate().clearColorFilter();
    }

    private void h(final Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
            if (!this.f82795c) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.f82794b) {
                j(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.1
                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.g(window);
                    }

                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.f(window);
                    }
                });
            }
        }
    }

    private void i(final Activity activity, final Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementReturnTransition;
            materialContainerTransform.p(true);
            materialContainerTransform.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.2
                @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    View view;
                    if (MaterialContainerTransformSharedElementCallback.f82792f != null && (view = (View) MaterialContainerTransformSharedElementCallback.f82792f.get()) != null) {
                        view.setAlpha(1.0f);
                        WeakReference unused = MaterialContainerTransformSharedElementCallback.f82792f = null;
                    }
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
            });
            if (this.f82794b) {
                j(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.3
                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.f(window);
                    }
                });
            }
        }
    }

    private static void j(Window window, MaterialContainerTransform materialContainerTransform) {
        if (materialContainerTransform.getDuration() >= 0) {
            window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
        }
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        f82792f = new WeakReference(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        WeakReference weakReference;
        View view;
        ShapeAppearanceModel shapeAppearanceModelA;
        View viewOnCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (viewOnCreateSnapshotView != null && (weakReference = f82792f) != null && this.f82797e != null && (view = (View) weakReference.get()) != null && (shapeAppearanceModelA = this.f82797e.a(view)) != null) {
            viewOnCreateSnapshotView.setTag(R.id.T, shapeAppearanceModelA);
        }
        return viewOnCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List list, Map map) {
        View view;
        Activity activityA;
        if (list.isEmpty() || map.isEmpty() || (view = (View) map.get(list.get(0))) == null || (activityA = ContextUtils.a(view.getContext())) == null) {
            return;
        }
        Window window = activityA.getWindow();
        if (this.f82793a) {
            h(window);
        } else {
            i(activityA, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List list, List list2, List list3) {
        if (!list2.isEmpty()) {
            View view = (View) list2.get(0);
            int i3 = R.id.T;
            if (view.getTag(i3) instanceof View) {
                ((View) list2.get(0)).setTag(i3, null);
            }
        }
        if (!this.f82793a && !list2.isEmpty()) {
            this.f82796d = TransitionUtils.j((View) list2.get(0));
        }
        this.f82793a = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List list, List list2, List list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            ((View) list2.get(0)).setTag(R.id.T, list3.get(0));
        }
        if (this.f82793a || list2.isEmpty() || this.f82796d == null) {
            return;
        }
        View view = (View) list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f82796d.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f82796d.height(), 1073741824));
        Rect rect = this.f82796d;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
