package androidx.compose.ui.window;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

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
final class DialogLayout extends AbstractComposeView implements DialogWindowProvider, OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Window f30231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f30232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f30233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30234d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f30235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f30236g;

    public DialogLayout(Context context, Window window) {
        super(context, null, 0, 6, null);
        this.f30231a = window;
        this.f30232b = SnapshotStateKt__SnapshotStateKt.e(ComposableSingletons$AndroidDialog_androidKt.f30225a.a(), null, 2, null);
        ViewCompat.C0(this, this);
        ViewCompat.K0(this, new WindowInsetsAnimationCompat.Callback() { // from class: androidx.compose.ui.window.DialogLayout.1
            {
                super(1);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat, List list) {
                DialogLayout dialogLayout = DialogLayout.this;
                if (!dialogLayout.f30234d) {
                    View childAt = dialogLayout.getChildAt(0);
                    int iMax = Math.max(0, childAt.getLeft());
                    int iMax2 = Math.max(0, childAt.getTop());
                    int iMax3 = Math.max(0, dialogLayout.getWidth() - childAt.getRight());
                    int iMax4 = Math.max(0, dialogLayout.getHeight() - childAt.getBottom());
                    if (iMax != 0 || iMax2 != 0 || iMax3 != 0 || iMax4 != 0) {
                        return windowInsetsCompat.p(iMax, iMax2, iMax3, iMax4);
                    }
                }
                return windowInsetsCompat;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsAnimationCompat.BoundsCompat f(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
                DialogLayout dialogLayout = DialogLayout.this;
                if (!dialogLayout.f30234d) {
                    View childAt = dialogLayout.getChildAt(0);
                    int iMax = Math.max(0, childAt.getLeft());
                    int iMax2 = Math.max(0, childAt.getTop());
                    int iMax3 = Math.max(0, dialogLayout.getWidth() - childAt.getRight());
                    int iMax4 = Math.max(0, dialogLayout.getHeight() - childAt.getBottom());
                    if (iMax != 0 || iMax2 != 0 || iMax3 != 0 || iMax4 != 0) {
                        return boundsCompat.c(Insets.b(iMax, iMax2, iMax3, iMax4));
                    }
                }
                return boundsCompat;
            }
        });
    }

    private final Function2 getContent() {
        return (Function2) this.f30232b.getValue();
    }

    private final void setContent(Function2 function2) {
        this.f30232b.setValue(function2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, int i3) {
        composer.a0(1735448596);
        if (ComposerKt.M()) {
            ComposerKt.U(1735448596, i3, -1, "androidx.compose.ui.window.DialogLayout.Content (AndroidDialog.android.kt:410)");
        }
        getContent().invoke(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        if (!this.f30234d) {
            View childAt = getChildAt(0);
            int iMax = Math.max(0, childAt.getLeft());
            int iMax2 = Math.max(0, childAt.getTop());
            int iMax3 = Math.max(0, getWidth() - childAt.getRight());
            int iMax4 = Math.max(0, getHeight() - childAt.getBottom());
            if (iMax != 0 || iMax2 != 0 || iMax3 != 0 || iMax4 != 0) {
                return windowInsetsCompat.p(iMax, iMax2, iMax3, iMax4);
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f30236g;
    }

    @Override // androidx.compose.ui.window.DialogWindowProvider
    public Window getWindow() {
        return this.f30231a;
    }

    public final boolean h(MotionEvent motionEvent) {
        View childAt;
        int iD;
        float x2 = motionEvent.getX();
        if (!Float.isInfinite(x2) && !Float.isNaN(x2)) {
            float y2 = motionEvent.getY();
            if (Float.isInfinite(y2) || Float.isNaN(y2) || (childAt = getChildAt(0)) == null) {
                return false;
            }
            int left = getLeft() + childAt.getLeft();
            int width = childAt.getWidth() + left;
            int top = getTop() + childAt.getTop();
            int height = childAt.getHeight() + top;
            int iD2 = MathKt.d(motionEvent.getX());
            if (left <= iD2 && iD2 <= width && top <= (iD = MathKt.d(motionEvent.getY())) && iD <= height) {
                return true;
            }
        }
        return false;
    }

    public final void i(CompositionContext compositionContext, Function2 function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.f30236g = true;
        createComposition();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui_release(boolean z2, int i3, int i4, int i5, int i6) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int paddingLeft2 = getPaddingLeft() + (((i7 - measuredWidth) - paddingLeft) / 2);
        int paddingTop2 = getPaddingTop() + (((i8 - measuredHeight) - paddingTop) / 2);
        childAt.layout(paddingLeft2, paddingTop2, measuredWidth + paddingLeft2, measuredHeight + paddingTop2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.internalOnMeasure$ui_release(i3, i4);
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int i5 = (mode != Integer.MIN_VALUE || this.f30233c || this.f30234d || getWindow().getAttributes().height != -2) ? size2 : size2 + 1;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i6 = size - paddingLeft;
        if (i6 < 0) {
            i6 = 0;
        }
        int i7 = i5 - paddingTop;
        int i8 = i7 >= 0 ? i7 : 0;
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        }
        if (mode != 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
        }
        childAt.measure(i3, i4);
        if (mode2 == Integer.MIN_VALUE) {
            size = Math.min(size, childAt.getMeasuredWidth() + paddingLeft);
        } else if (mode2 != 1073741824) {
            size = childAt.getMeasuredWidth() + paddingLeft;
        }
        setMeasuredDimension(size, mode != Integer.MIN_VALUE ? mode != 1073741824 ? childAt.getMeasuredHeight() + paddingTop : size2 : Math.min(size2, childAt.getMeasuredHeight() + paddingTop));
        if (this.f30233c || this.f30234d || childAt.getMeasuredHeight() + paddingTop <= size2 || getWindow().getAttributes().height != -2) {
            return;
        }
        getWindow().setLayout(-1, -1);
    }

    public final void j(boolean z2, boolean z3) {
        boolean z4 = (this.f30235f && z2 == this.f30233c && z3 == this.f30234d) ? false : true;
        this.f30233c = z2;
        this.f30234d = z3;
        if (z4) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int i3 = z2 ? -2 : -1;
            if (i3 == attributes.width && this.f30235f) {
                return;
            }
            getWindow().setLayout(i3, -2);
            this.f30235f = true;
        }
    }
}
