package com.google.maps.android.compose;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.Marker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class ComposeInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MapView f90670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f90671b;

    public ComposeInfoWindowAdapter(MapView mapView, Function1 markerNodeFinder) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        Intrinsics.checkNotNullParameter(markerNodeFinder, "markerNodeFinder");
        this.f90670a = mapView;
        this.f90671b = markerNodeFinder;
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View a(final Marker marker) {
        final Function3 function3E;
        Intrinsics.checkNotNullParameter(marker, "marker");
        MarkerNode markerNode = (MarkerNode) this.f90671b.invoke(marker);
        if (markerNode == null || (function3E = markerNode.e()) == null) {
            return null;
        }
        Context context = this.f90670a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mapView.context");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.c(1508359207, true, new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.ComposeInfoWindowAdapter$getInfoContents$view$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i3) {
                if ((i3 & 11) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(1508359207, i3, -1, "com.google.maps.android.compose.ComposeInfoWindowAdapter.getInfoContents.<anonymous>.<anonymous> (ComposeInfoWindowAdapter.kt:49)");
                }
                function3E.invoke(marker, composer, 8);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        MapComposeViewRenderKt.c(this.f90670a, composeView, null, markerNode.d(), 2, null);
        return composeView;
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View b(final Marker marker) {
        final Function3 function3F;
        Intrinsics.checkNotNullParameter(marker, "marker");
        MarkerNode markerNode = (MarkerNode) this.f90671b.invoke(marker);
        if (markerNode == null || (function3F = markerNode.f()) == null) {
            return null;
        }
        Context context = this.f90670a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mapView.context");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.c(-742372995, true, new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.ComposeInfoWindowAdapter$getInfoWindow$view$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i3) {
                if ((i3 & 11) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-742372995, i3, -1, "com.google.maps.android.compose.ComposeInfoWindowAdapter.getInfoWindow.<anonymous>.<anonymous> (ComposeInfoWindowAdapter.kt:62)");
                }
                function3F.invoke(marker, composer, 8);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        MapComposeViewRenderKt.c(this.f90670a, composeView, null, markerNode.d(), 2, null);
        return composeView;
    }
}
