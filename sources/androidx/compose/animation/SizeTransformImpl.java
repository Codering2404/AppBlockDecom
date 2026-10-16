package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
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
final class SizeTransformImpl implements SizeTransform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f3736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f3737b;

    public SizeTransformImpl(boolean z2, Function2 function2) {
        this.f3736a = z2;
        this.f3737b = function2;
    }

    @Override // androidx.compose.animation.SizeTransform
    public boolean a() {
        return this.f3736a;
    }

    @Override // androidx.compose.animation.SizeTransform
    public FiniteAnimationSpec b(long j3, long j4) {
        return (FiniteAnimationSpec) this.f3737b.invoke(IntSize.b(j3), IntSize.b(j4));
    }
}
