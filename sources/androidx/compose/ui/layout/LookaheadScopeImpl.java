package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LookaheadScopeImpl implements LookaheadScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0 f27148a;

    public LookaheadScopeImpl(Function0 function0) {
        this.f27148a = function0;
    }

    public final void a(Function0 function0) {
        this.f27148a = function0;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates x(LayoutCoordinates layoutCoordinates) {
        LookaheadLayoutCoordinates lookaheadLayoutCoordinatesT2;
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = layoutCoordinates instanceof LookaheadLayoutCoordinates ? (LookaheadLayoutCoordinates) layoutCoordinates : null;
        if (lookaheadLayoutCoordinates != null) {
            return lookaheadLayoutCoordinates;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        NodeCoordinator nodeCoordinator = (NodeCoordinator) layoutCoordinates;
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinator.S2();
        return (lookaheadDelegateS2 == null || (lookaheadLayoutCoordinatesT2 = lookaheadDelegateS2.t2()) == null) ? nodeCoordinator : lookaheadLayoutCoordinatesT2;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates z(Placeable.PlacementScope placementScope) {
        Function0 function0 = this.f27148a;
        Intrinsics.checkNotNull(function0);
        return (LayoutCoordinates) function0.invoke();
    }

    public /* synthetic */ LookaheadScopeImpl(Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function0);
    }
}
