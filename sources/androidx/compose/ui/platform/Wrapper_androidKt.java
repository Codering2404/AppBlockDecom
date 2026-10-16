package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.ui.R;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class Wrapper_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ViewGroup.LayoutParams f28337a = new ViewGroup.LayoutParams(-2, -2);

    public static final AbstractApplier a(LayoutNode layoutNode) {
        return new UiApplier(layoutNode);
    }

    private static final Composition b(AndroidComposeView androidComposeView, CompositionContext compositionContext, Function2 function2) {
        if (InspectableValueKt.b()) {
            int i3 = R.id.K;
            if (androidComposeView.getTag(i3) == null) {
                androidComposeView.setTag(i3, Collections.newSetFromMap(new WeakHashMap()));
            }
        }
        View view = androidComposeView.getView();
        int i4 = R.id.L;
        Object tag = view.getTag(i4);
        WrappedComposition wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, CompositionKt.a(new UiApplier(androidComposeView.getRoot()), compositionContext));
            androidComposeView.getView().setTag(i4, wrappedComposition);
        }
        wrappedComposition.f(function2);
        if (!Intrinsics.areEqual(androidComposeView.getCoroutineContext(), compositionContext.i())) {
            androidComposeView.setCoroutineContext(compositionContext.i());
        }
        return wrappedComposition;
    }

    public static final Composition c(AbstractComposeView abstractComposeView, CompositionContext compositionContext, Function2 function2) {
        GlobalSnapshotManager.f28064a.b();
        AndroidComposeView androidComposeView = null;
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                androidComposeView = (AndroidComposeView) childAt;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        if (androidComposeView == null) {
            androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), compositionContext.i());
            abstractComposeView.addView(androidComposeView.getView(), f28337a);
        }
        return b(androidComposeView, compositionContext, function2);
    }
}
