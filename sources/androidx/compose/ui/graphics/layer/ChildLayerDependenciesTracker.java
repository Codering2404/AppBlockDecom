package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
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
public final class ChildLayerDependenciesTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GraphicsLayer f26108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GraphicsLayer f26109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableScatterSet f26110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableScatterSet f26111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f26112e;

    public final boolean i(GraphicsLayer graphicsLayer) {
        if (!this.f26112e) {
            InlineClassHelperKt.a("Only add dependencies during a tracking");
        }
        MutableScatterSet mutableScatterSet = this.f26110c;
        if (mutableScatterSet != null) {
            Intrinsics.checkNotNull(mutableScatterSet);
            mutableScatterSet.i(graphicsLayer);
        } else if (this.f26108a != null) {
            MutableScatterSet mutableScatterSetA = ScatterSetKt.a();
            GraphicsLayer graphicsLayer2 = this.f26108a;
            Intrinsics.checkNotNull(graphicsLayer2);
            mutableScatterSetA.i(graphicsLayer2);
            mutableScatterSetA.i(graphicsLayer);
            this.f26110c = mutableScatterSetA;
            this.f26108a = null;
        } else {
            this.f26108a = graphicsLayer;
        }
        MutableScatterSet mutableScatterSet2 = this.f26111d;
        if (mutableScatterSet2 != null) {
            Intrinsics.checkNotNull(mutableScatterSet2);
            return !mutableScatterSet2.z(graphicsLayer);
        }
        if (this.f26109b != graphicsLayer) {
            return true;
        }
        this.f26109b = null;
        return false;
    }
}
