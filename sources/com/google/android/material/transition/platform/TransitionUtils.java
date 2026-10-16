package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.PathParser;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TransitionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RectF f82830a = new RectF();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface CornerSizeBinaryOperator {
        CornerSize a(CornerSize cornerSize, CornerSize cornerSize2);
    }

    static float b(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    static ShapeAppearanceModel c(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.y(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.platform.a
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize a(CornerSize cornerSize) {
                return RelativeCornerSize.b(rectF, cornerSize);
            }
        });
    }

    static Shader d(int i3) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i3, i3, Shader.TileMode.CLAMP);
    }

    static Object e(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    static View f(View view, int i3) {
        String resourceName = view.getResources().getResourceName(i3);
        while (view != null) {
            if (view.getId() != i3) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static View g(View view, int i3) {
        View viewFindViewById = view.findViewById(i3);
        return viewFindViewById != null ? viewFindViewById : f(view, i3);
    }

    static RectF h(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    static RectF i(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static Rect j(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean k(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return (shapeAppearanceModel.r().a(rectF) == 0.0f && shapeAppearanceModel.t().a(rectF) == 0.0f && shapeAppearanceModel.l().a(rectF) == 0.0f && shapeAppearanceModel.j().a(rectF) == 0.0f) ? false : true;
    }

    static float l(float f3, float f4, float f5) {
        return f3 + (f5 * (f4 - f3));
    }

    static float m(float f3, float f4, float f5, float f6, float f7) {
        return n(f3, f4, f5, f6, f7, false);
    }

    static float n(float f3, float f4, float f5, float f6, float f7, boolean z2) {
        return (!z2 || (f7 >= 0.0f && f7 <= 1.0f)) ? f7 < f5 ? f3 : f7 > f6 ? f4 : l(f3, f4, (f7 - f5) / (f6 - f5)) : l(f3, f4, f7);
    }

    static int o(int i3, int i4, float f3, float f4, float f5) {
        return f5 < f3 ? i3 : f5 > f4 ? i4 : (int) l(i3, i4, (f5 - f3) / (f4 - f3));
    }

    static ShapeAppearanceModel p(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, final RectF rectF, final RectF rectF2, final float f3, final float f4, final float f5) {
        return f5 < f3 ? shapeAppearanceModel : f5 > f4 ? shapeAppearanceModel2 : w(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.1
            @Override // com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator
            public CornerSize a(CornerSize cornerSize, CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.m(cornerSize.a(rectF), cornerSize2.a(rectF2), f3, f4, f5));
            }
        });
    }

    static boolean q(Transition transition, Context context, int i3) {
        int iF;
        if (i3 == 0 || transition.getDuration() != -1 || (iF = MotionUtils.f(context, i3, -1)) == -1) {
            return false;
        }
        transition.setDuration(iF);
        return true;
    }

    static boolean r(Transition transition, Context context, int i3, TimeInterpolator timeInterpolator) {
        if (i3 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.g(context, i3, timeInterpolator));
        return true;
    }

    static boolean s(Transition transition, Context context, int i3) {
        PathMotion pathMotionT;
        if (i3 == 0 || (pathMotionT = t(context, i3)) == null) {
            return false;
        }
        transition.setPathMotion(pathMotionT);
        return true;
    }

    private static int u(Canvas canvas, Rect rect, int i3) {
        RectF rectF = f82830a;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i3);
    }

    static void v(Canvas canvas, Rect rect, float f3, float f4, float f5, int i3, CanvasCompat.CanvasOperation canvasOperation) {
        if (i3 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f3, f4);
        canvas.scale(f5, f5);
        if (i3 < 255) {
            u(canvas, rect, i3);
        }
        canvasOperation.a(canvas);
        canvas.restoreToCount(iSave);
    }

    static ShapeAppearanceModel w(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (k(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).v().E(cornerSizeBinaryOperator.a(shapeAppearanceModel.r(), shapeAppearanceModel2.r())).I(cornerSizeBinaryOperator.a(shapeAppearanceModel.t(), shapeAppearanceModel2.t())).w(cornerSizeBinaryOperator.a(shapeAppearanceModel.j(), shapeAppearanceModel2.j())).A(cornerSizeBinaryOperator.a(shapeAppearanceModel.l(), shapeAppearanceModel2.l())).m();
    }

    static PathMotion t(Context context, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i3, typedValue, true)) {
            return null;
        }
        int i4 = typedValue.type;
        if (i4 != 16) {
            if (i4 == 3) {
                return new PatternPathMotion(PathParser.e(String.valueOf(typedValue.string)));
            }
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
        int i5 = typedValue.data;
        if (i5 == 0) {
            return null;
        }
        if (i5 == 1) {
            return new MaterialArcMotion();
        }
        throw new IllegalArgumentException(sKeKFMqmvNzY.KZKH + i5);
    }
}
