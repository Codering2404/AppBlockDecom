package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
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
public final class OffsetEffect extends RenderEffect {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RenderEffect f25816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f25817c;

    @Override // androidx.compose.ui.graphics.RenderEffect
    protected android.graphics.RenderEffect b() {
        return RenderEffectVerificationHelper.f25880a.b(this.f25816b, this.f25817c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetEffect)) {
            return false;
        }
        OffsetEffect offsetEffect = (OffsetEffect) obj;
        return Intrinsics.areEqual(this.f25816b, offsetEffect.f25816b) && Offset.j(this.f25817c, offsetEffect.f25817c);
    }

    public int hashCode() {
        RenderEffect renderEffect = this.f25816b;
        return ((renderEffect != null ? renderEffect.hashCode() : 0) * 31) + Offset.o(this.f25817c);
    }

    public String toString() {
        return "OffsetEffect(renderEffect=" + this.f25816b + ", offset=" + ((Object) Offset.s(this.f25817c)) + ')';
    }
}
