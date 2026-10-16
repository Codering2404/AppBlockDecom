package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.Owner;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0<Unit> disposeViewCompositionStrategy;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }

    private final CompositionContext b(CompositionContext compositionContext) {
        CompositionContext compositionContext2 = e(compositionContext) ? compositionContext : null;
        if (compositionContext2 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference<>(compositionContext2);
        }
        return compositionContext;
    }

    private final void c() {
        if (this.creatingComposition) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    private final void d() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = Wrapper_androidKt.c(this, f(), ComposableLambdaKt.c(-656146368, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer, int i3) {
                        if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                            composer.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-656146368, i3, -1, "androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous> (ComposeView.android.kt:249)");
                        }
                        this.f27647a.Content(composer, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }));
            } finally {
                this.creatingComposition = false;
            }
        }
    }

    private final boolean e(CompositionContext compositionContext) {
        return !(compositionContext instanceof Recomposer) || ((Recomposer.State) ((Recomposer) compositionContext).p0().getValue()).compareTo(Recomposer.State.f24065b) > 0;
    }

    private final CompositionContext f() {
        CompositionContext compositionContext;
        CompositionContext compositionContextB = this.parentContext;
        if (compositionContextB == null) {
            CompositionContext compositionContextD = WindowRecomposer_androidKt.d(this);
            CompositionContext compositionContext2 = null;
            compositionContextB = compositionContextD != null ? b(compositionContextD) : null;
            if (compositionContextB == null) {
                WeakReference<CompositionContext> weakReference = this.cachedViewTreeCompositionContext;
                if (weakReference != null && (compositionContext = weakReference.get()) != null && e(compositionContext)) {
                    compositionContext2 = compositionContext;
                }
                return compositionContext2 == null ? b(WindowRecomposer_androidKt.h(this)) : compositionContext2;
            }
        }
        return compositionContextB;
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition composition = this.composition;
            if (composition != null) {
                composition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    d();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    public abstract void Content(Composer composer, int i3);

    @Override // android.view.ViewGroup
    public void addView(View view) {
        c();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        c();
        return super.addViewInLayout(view, i3, layoutParams);
    }

    public final void createComposition() {
        if (this.parentContext == null && !isAttachedToWindow()) {
            throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.");
        }
        d();
    }

    public final void disposeComposition() {
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void internalOnLayout$ui_release(boolean z2, int i3, int i4, int i5, int i6) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i5 - i3) - getPaddingRight(), (i6 - i4) - getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui_release(int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i3, i4);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i3)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i4) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i4)));
        setMeasuredDimension(childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        internalOnLayout$ui_release(z2, i3, i4, i5, i6);
    }

    @Override // android.view.View
    protected final void onMeasure(int i3, int i4) {
        d();
        internalOnMeasure$ui_release(i3, i4);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        childAt.setLayoutDirection(i3);
    }

    public final void setParentCompositionContext(CompositionContext compositionContext) {
        setParentContext(compositionContext);
    }

    public final void setShowLayoutBounds(boolean z2) {
        this.showLayoutBounds = z2;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((Owner) childAt).setShowLayoutBounds(z2);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z2) {
        super.setTransitionGroup(z2);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy viewCompositionStrategy) {
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = viewCompositionStrategy.a(this);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public AbstractComposeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.f28220a.a().a(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        c();
        super.addView(view, i3);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z2) {
        c();
        return super.addViewInLayout(view, i3, layoutParams, z2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i4) {
        c();
        super.addView(view, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        c();
        super.addView(view, i3, layoutParams);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }
}
