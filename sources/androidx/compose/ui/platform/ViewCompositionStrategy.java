package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.poolingcontainer.PoolingContainerListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

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
public interface ViewCompositionStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f28220a = Companion.f28221a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f28221a = new Companion();

        private Companion() {
        }

        public final ViewCompositionStrategy a() {
            return DisposeOnDetachedFromWindowOrReleasedFromPool.f28226b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DisposeOnDetachedFromWindow implements ViewCompositionStrategy {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DisposeOnDetachedFromWindow f28222b = new DisposeOnDetachedFromWindow();

        private DisposeOnDetachedFromWindow() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$OnAttachStateChangeListener, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1] */
        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        public Function0 a(final AbstractComposeView abstractComposeView) {
            final ?? r02 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    abstractComposeView.disposeComposition();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }
            };
            abstractComposeView.addOnAttachStateChangeListener(r02);
            return new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m253invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m253invoke() {
                    abstractComposeView.removeOnAttachStateChangeListener(r02);
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DisposeOnDetachedFromWindowOrReleasedFromPool implements ViewCompositionStrategy {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DisposeOnDetachedFromWindowOrReleasedFromPool f28226b = new DisposeOnDetachedFromWindowOrReleasedFromPool();

        private DisposeOnDetachedFromWindowOrReleasedFromPool() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AbstractComposeView abstractComposeView) {
            abstractComposeView.disposeComposition();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$OnAttachStateChangeListener, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1] */
        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        public Function0 a(final AbstractComposeView abstractComposeView) {
            final ?? r02 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (PoolingContainer.f(abstractComposeView)) {
                        return;
                    }
                    abstractComposeView.disposeComposition();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }
            };
            abstractComposeView.addOnAttachStateChangeListener(r02);
            final PoolingContainerListener poolingContainerListener = new PoolingContainerListener() { // from class: androidx.compose.ui.platform.h0
                @Override // androidx.customview.poolingcontainer.PoolingContainerListener
                public final void b() {
                    ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.c(abstractComposeView);
                }
            };
            PoolingContainer.a(abstractComposeView, poolingContainerListener);
            return new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m254invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m254invoke() {
                    abstractComposeView.removeOnAttachStateChangeListener(r02);
                    PoolingContainer.g(abstractComposeView, poolingContainerListener);
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DisposeOnLifecycleDestroyed implements ViewCompositionStrategy {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Lifecycle f28231b;

        public DisposeOnLifecycleDestroyed(Lifecycle lifecycle) {
            this.f28231b = lifecycle;
        }

        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        public Function0 a(AbstractComposeView abstractComposeView) {
            return ViewCompositionStrategy_androidKt.c(abstractComposeView, this.f28231b);
        }

        public DisposeOnLifecycleDestroyed(LifecycleOwner lifecycleOwner) {
            this(lifecycleOwner.getLifecycle());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DisposeOnViewTreeLifecycleDestroyed implements ViewCompositionStrategy {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DisposeOnViewTreeLifecycleDestroyed f28232b = new DisposeOnViewTreeLifecycleDestroyed();

        private DisposeOnViewTreeLifecycleDestroyed() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$OnAttachStateChangeListener, androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1] */
        @Override // androidx.compose.ui.platform.ViewCompositionStrategy
        public Function0 a(final AbstractComposeView abstractComposeView) {
            if (!abstractComposeView.isAttachedToWindow()) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final ?? r12 = new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        LifecycleOwner lifecycleOwnerA = ViewTreeLifecycleOwner.a(abstractComposeView);
                        AbstractComposeView abstractComposeView2 = abstractComposeView;
                        if (lifecycleOwnerA != null) {
                            objectRef.f140144a = ViewCompositionStrategy_androidKt.c(abstractComposeView2, lifecycleOwnerA.getLifecycle());
                            abstractComposeView.removeOnAttachStateChangeListener(this);
                        } else {
                            InlineClassHelperKt.d("View tree for " + abstractComposeView2 + " has no ViewTreeLifecycleOwner");
                            throw new KotlinNothingValueException();
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                    }
                };
                abstractComposeView.addOnAttachStateChangeListener(r12);
                objectRef.f140144a = new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m255invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m255invoke() {
                        abstractComposeView.removeOnAttachStateChangeListener(r12);
                    }
                };
                return new Function0<Unit>() { // from class: androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m256invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m256invoke() {
                        ((Function0) objectRef.f140144a).invoke();
                    }
                };
            }
            LifecycleOwner lifecycleOwnerA = ViewTreeLifecycleOwner.a(abstractComposeView);
            if (lifecycleOwnerA != null) {
                return ViewCompositionStrategy_androidKt.c(abstractComposeView, lifecycleOwnerA.getLifecycle());
            }
            InlineClassHelperKt.d("View tree for " + abstractComposeView + " has no ViewTreeLifecycleOwner");
            throw new KotlinNothingValueException();
        }
    }

    Function0 a(AbstractComposeView abstractComposeView);
}
