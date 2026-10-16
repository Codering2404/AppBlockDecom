package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {
    private final View E;
    private final NestedScrollDispatcher F;
    private final SaveableStateRegistry G;
    private final int H;
    private final String I;
    private SaveableStateRegistry.Entry J;
    private Function1 K;
    private Function1 L;
    private Function1 M;

    /* synthetic */ ViewFactoryHolder(Context context, CompositionContext compositionContext, View view, NestedScrollDispatcher nestedScrollDispatcher, SaveableStateRegistry saveableStateRegistry, int i3, Owner owner, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : compositionContext, view, (i4 & 8) != 0 ? new NestedScrollDispatcher() : nestedScrollDispatcher, saveableStateRegistry, i3, owner);
    }

    private final void I() {
        SaveableStateRegistry saveableStateRegistry = this.G;
        if (saveableStateRegistry != null) {
            setSavableRegistryEntry(saveableStateRegistry.b(this.I, new Function0<Object>() { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$registerSaveStateProvider$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SparseArray<Parcelable> sparseArray = new SparseArray<>();
                    this.f30148a.E.saveHierarchyState(sparseArray);
                    return sparseArray;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        setSavableRegistryEntry(null);
    }

    private final void setSavableRegistryEntry(SaveableStateRegistry.Entry entry) {
        SaveableStateRegistry.Entry entry2 = this.J;
        if (entry2 != null) {
            entry2.a();
        }
        this.J = entry;
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.F;
    }

    public final Function1<T, Unit> getReleaseBlock() {
        return this.M;
    }

    public final Function1<T, Unit> getResetBlock() {
        return this.L;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public /* bridge */ /* synthetic */ AbstractComposeView getSubCompositionView() {
        return super.getSubCompositionView();
    }

    public final Function1<T, Unit> getUpdateBlock() {
        return this.K;
    }

    public final void setReleaseBlock(Function1<? super T, Unit> function1) {
        this.M = function1;
        setRelease(new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$releaseBlock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m275invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m275invoke() {
                this.f30149a.getReleaseBlock().invoke(this.f30149a.E);
                this.f30149a.J();
            }
        });
    }

    public final void setResetBlock(Function1<? super T, Unit> function1) {
        this.L = function1;
        setReset(new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$resetBlock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m276invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m276invoke() {
                this.f30150a.getResetBlock().invoke(this.f30150a.E);
            }
        });
    }

    public final void setUpdateBlock(Function1<? super T, Unit> function1) {
        this.K = function1;
        setUpdate(new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$updateBlock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m277invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m277invoke() {
                this.f30151a.getUpdateBlock().invoke(this.f30151a.E);
            }
        });
    }

    private ViewFactoryHolder(Context context, CompositionContext compositionContext, View view, NestedScrollDispatcher nestedScrollDispatcher, SaveableStateRegistry saveableStateRegistry, int i3, Owner owner) {
        super(context, compositionContext, i3, nestedScrollDispatcher, view, owner);
        this.E = view;
        this.F = nestedScrollDispatcher;
        this.G = saveableStateRegistry;
        this.H = i3;
        setClipChildren(false);
        String strValueOf = String.valueOf(i3);
        this.I = strValueOf;
        Object objF = saveableStateRegistry != null ? saveableStateRegistry.f(strValueOf) : null;
        SparseArray<Parcelable> sparseArray = objF instanceof SparseArray ? (SparseArray) objF : null;
        if (sparseArray != null) {
            view.restoreHierarchyState(sparseArray);
        }
        I();
        this.K = AndroidView_androidKt.e();
        this.L = AndroidView_androidKt.e();
        this.M = AndroidView_androidKt.e();
    }

    public ViewFactoryHolder(Context context, Function1 function1, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i3, Owner owner) {
        this(context, compositionContext, (View) function1.invoke(context), null, saveableStateRegistry, i3, owner, 8, null);
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public View getViewRoot() {
        return this;
    }
}
