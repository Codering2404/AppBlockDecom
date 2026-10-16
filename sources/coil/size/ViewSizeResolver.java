package coil.size;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import coil.size.Dimension;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface ViewSizeResolver<T extends View> extends SizeResolver {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    private default Dimension d(int i3, int i4, int i5) {
        if (i3 == -2) {
            return Dimension.Undefined.f56164a;
        }
        int i6 = i3 - i5;
        if (i6 > 0) {
            return Dimensions.a(i6);
        }
        int i7 = i4 - i5;
        if (i7 > 0) {
            return Dimensions.a(i7);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    default void e(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        } else {
            a().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewTreeObserver$OnPreDrawListener, coil.size.ViewSizeResolver$size$3$preDrawListener$1] */
    static /* synthetic */ Object g(final ViewSizeResolver viewSizeResolver, Continuation continuation) {
        Size size = viewSizeResolver.getSize();
        if (size != null) {
            return size;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        final ViewTreeObserver viewTreeObserver = viewSizeResolver.a().getViewTreeObserver();
        final ?? r2 = new ViewTreeObserver.OnPreDrawListener() { // from class: coil.size.ViewSizeResolver$size$3$preDrawListener$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f56183a;

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                Size size2 = this.f56184b.getSize();
                if (size2 != null) {
                    this.f56184b.e(viewTreeObserver, this);
                    if (!this.f56183a) {
                        this.f56183a = true;
                        cancellableContinuationImpl.resumeWith(Result.b(size2));
                    }
                }
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(r2);
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: coil.size.ViewSizeResolver$size$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                this.f56180a.e(viewTreeObserver, r2);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    private default Dimension getHeight() {
        ViewGroup.LayoutParams layoutParams = a().getLayoutParams();
        return d(layoutParams != null ? layoutParams.height : -1, a().getHeight(), f() ? a().getPaddingTop() + a().getPaddingBottom() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    default Size getSize() {
        Dimension height;
        Dimension width = getWidth();
        if (width == null || (height = getHeight()) == null) {
            return null;
        }
        return new Size(width, height);
    }

    private default Dimension getWidth() {
        ViewGroup.LayoutParams layoutParams = a().getLayoutParams();
        return d(layoutParams != null ? layoutParams.width : -1, a().getWidth(), f() ? a().getPaddingLeft() + a().getPaddingRight() : 0);
    }

    View a();

    @Override // coil.size.SizeResolver
    default Object b(Continuation continuation) {
        return g(this, continuation);
    }

    default boolean f() {
        return true;
    }
}
