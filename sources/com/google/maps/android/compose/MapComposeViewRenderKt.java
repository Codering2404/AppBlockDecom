package com.google.maps.android.compose;

import android.content.Context;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.AbstractComposeView;
import com.google.android.gms.maps.MapView;
import com.google.maps.android.compose.ComposeUiViewRenderer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class MapComposeViewRenderKt {
    private static final NoDrawContainerView a(MapView mapView) {
        int i3 = R.id.f91243a;
        NoDrawContainerView noDrawContainerView = (NoDrawContainerView) mapView.findViewById(i3);
        if (noDrawContainerView != null) {
            return noDrawContainerView;
        }
        Context context = mapView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        NoDrawContainerView noDrawContainerView2 = new NoDrawContainerView(context);
        noDrawContainerView2.setId(i3);
        mapView.addView(noDrawContainerView2);
        return noDrawContainerView2;
    }

    public static final void b(MapView mapView, AbstractComposeView view, Function1 function1, CompositionContext parentContext) {
        Intrinsics.checkNotNullParameter(mapView, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        ComposeUiViewRenderer.RenderHandle renderHandleD = d(mapView, view, parentContext);
        if (function1 != null) {
            try {
                function1.invoke(view);
                Unit unit = Unit.f139807a;
            } finally {
            }
        }
        CloseableKt.a(renderHandleD, null);
    }

    public static /* synthetic */ void c(MapView mapView, AbstractComposeView abstractComposeView, Function1 function1, CompositionContext compositionContext, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        b(mapView, abstractComposeView, function1, compositionContext);
    }

    public static final ComposeUiViewRenderer.RenderHandle d(MapView mapView, final AbstractComposeView view, CompositionContext parentContext) {
        Intrinsics.checkNotNullParameter(mapView, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        final NoDrawContainerView noDrawContainerViewA = a(mapView);
        noDrawContainerViewA.addView(view);
        view.setParentCompositionContext(parentContext);
        return new ComposeUiViewRenderer.RenderHandle() { // from class: com.google.maps.android.compose.MapComposeViewRenderKt$startRenderingComposeView$2
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ComposeUiViewRenderer.RenderHandle.DefaultImpls.a(this);
            }

            @Override // com.google.maps.android.compose.ComposeUiViewRenderer.RenderHandle
            public void dispose() {
                noDrawContainerViewA.removeView(view);
            }
        };
    }
}
