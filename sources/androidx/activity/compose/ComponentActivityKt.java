package androidx.activity.compose;

import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ComponentActivityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ViewGroup.LayoutParams f449a = new ViewGroup.LayoutParams(-2, -2);

    public static final void a(ComponentActivity componentActivity, CompositionContext compositionContext, Function2 function2) {
        View childAt = ((ViewGroup) componentActivity.getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);
        ComposeView composeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
        if (composeView != null) {
            composeView.setParentCompositionContext(compositionContext);
            composeView.setContent(function2);
            return;
        }
        ComposeView composeView2 = new ComposeView(componentActivity, null, 0, 6, null);
        composeView2.setParentCompositionContext(compositionContext);
        composeView2.setContent(function2);
        c(componentActivity);
        componentActivity.setContentView(composeView2, f449a);
    }

    public static /* synthetic */ void b(ComponentActivity componentActivity, CompositionContext compositionContext, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            compositionContext = null;
        }
        a(componentActivity, compositionContext, function2);
    }

    private static final void c(ComponentActivity componentActivity) {
        View decorView = componentActivity.getWindow().getDecorView();
        if (ViewTreeLifecycleOwner.a(decorView) == null) {
            ViewTreeLifecycleOwner.b(decorView, componentActivity);
        }
        if (ViewTreeViewModelStoreOwner.a(decorView) == null) {
            ViewTreeViewModelStoreOwner.b(decorView, componentActivity);
        }
        if (ViewTreeSavedStateRegistryOwner.a(decorView) == null) {
            ViewTreeSavedStateRegistryOwner.b(decorView, componentActivity);
        }
    }
}
