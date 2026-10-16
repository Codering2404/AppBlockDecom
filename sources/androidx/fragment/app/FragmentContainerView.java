package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f37198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f37199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f37200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37201d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api20Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api20Impl f37202a = new Api20Impl();

        private Api20Impl() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v2, WindowInsets insets) {
            Intrinsics.checkNotNullParameter(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            Intrinsics.checkNotNullParameter(v2, "v");
            Intrinsics.checkNotNullParameter(insets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v2, insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(View view) {
        if (this.f37199b.contains(view)) {
            this.f37198a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i3, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (FragmentManager.L0(child) != null) {
            super.addView(child, i3, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        WindowInsetsCompat windowInsetsCompatY;
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompatZ = WindowInsetsCompat.z(insets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatZ, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f37200c;
        if (onApplyWindowInsetsListener != null) {
            Api20Impl api20Impl = Api20Impl.f37202a;
            Intrinsics.checkNotNull(onApplyWindowInsetsListener);
            windowInsetsCompatY = WindowInsetsCompat.z(api20Impl.a(onApplyWindowInsetsListener, this, insets));
        } else {
            windowInsetsCompatY = ViewCompat.Y(this, windowInsetsCompatZ);
        }
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatY, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!windowInsetsCompatY.r()) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                ViewCompat.g(getChildAt(i3), windowInsetsCompatY);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.f37201d) {
            Iterator it = this.f37198a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long j3) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.f37201d && !this.f37198a.isEmpty() && this.f37198a.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, j3);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f37199b.remove(view);
        if (this.f37198a.remove(view)) {
            this.f37201d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.p0(this).m0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View view = getChildAt(childCount);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                a(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        View view = getChildAt(i3);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        a(view);
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i3, int i4) {
        int i5 = i3 + i4;
        for (int i6 = i3; i6 < i5; i6++) {
            View view = getChildAt(i6);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            a(view);
        }
        super.removeViews(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i3, int i4) {
        int i5 = i3 + i4;
        for (int i6 = i3; i6 < i5; i6++) {
            View view = getChildAt(i6);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i3, i4);
    }

    public final void setDrawDisappearingViewsLast(boolean z2) {
        this.f37201d = z2;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f37200c = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getParent() == this) {
            this.f37199b.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f37198a = new ArrayList();
        this.f37199b = new ArrayList();
        this.f37201d = true;
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i3) {
        String str;
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f37198a = new ArrayList();
        this.f37199b = new ArrayList();
        this.f37201d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] FragmentContainerView = R.styleable.f37102e;
            Intrinsics.checkNotNullExpressionValue(FragmentContainerView, "FragmentContainerView");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(R.styleable.f37103f);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attrs, FragmentManager fm) {
        String str;
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.f37198a = new ArrayList();
        this.f37199b = new ArrayList();
        this.f37201d = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = R.styleable.f37102e;
        Intrinsics.checkNotNullExpressionValue(FragmentContainerView, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(R.styleable.f37103f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.f37104g);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentM0 = fm.m0(id);
        if (classAttribute != null && fragmentM0 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentA = fm.B0().a(context.getClassLoader(), classAttribute);
            Intrinsics.checkNotNullExpressionValue(fragmentA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentA.mFragmentId = id;
            fragmentA.mContainerId = id;
            fragmentA.mTag = string;
            fragmentA.mFragmentManager = fm;
            fragmentA.mHost = fm.E0();
            fragmentA.onInflate(context, attrs, (Bundle) null);
            fm.q().x(true).d(this, fragmentA, string).m();
        }
        fm.e1(this);
    }
}
