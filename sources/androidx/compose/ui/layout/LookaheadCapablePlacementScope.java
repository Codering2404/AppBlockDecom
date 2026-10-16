package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
final class LookaheadCapablePlacementScope extends Placeable.PlacementScope {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LookaheadCapablePlaceable f27146b;

    public LookaheadCapablePlacementScope(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.f27146b = lookaheadCapablePlaceable;
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public LayoutCoordinates d() {
        LayoutCoordinates layoutCoordinatesU1 = this.f27146b.W1() ? null : this.f27146b.u1();
        if (layoutCoordinatesU1 == null) {
            this.f27146b.X1().f0().I();
        }
        return layoutCoordinatesU1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public LayoutDirection e() {
        return this.f27146b.getLayoutDirection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public int f() {
        return this.f27146b.S0();
    }
}
