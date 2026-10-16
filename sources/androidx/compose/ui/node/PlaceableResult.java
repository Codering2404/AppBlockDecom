package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasureResult;
import kotlin.Metadata;
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
final class PlaceableResult implements OwnerScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MeasureResult f27631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LookaheadCapablePlaceable f27632b;

    public PlaceableResult(MeasureResult measureResult, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.f27631a = measureResult;
        this.f27632b = lookaheadCapablePlaceable;
    }

    public final LookaheadCapablePlaceable a() {
        return this.f27632b;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean a1() {
        return this.f27632b.u1().m();
    }

    public final MeasureResult b() {
        return this.f27631a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceableResult)) {
            return false;
        }
        PlaceableResult placeableResult = (PlaceableResult) obj;
        return Intrinsics.areEqual(this.f27631a, placeableResult.f27631a) && Intrinsics.areEqual(this.f27632b, placeableResult.f27632b);
    }

    public int hashCode() {
        return (this.f27631a.hashCode() * 31) + this.f27632b.hashCode();
    }

    public String toString() {
        return "PlaceableResult(result=" + this.f27631a + ", placeable=" + this.f27632b + ')';
    }
}
