package androidx.glance.appwidget;

import androidx.glance.GlanceModifier;
import androidx.glance.unit.Dimension;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CornerRadiusModifier implements GlanceModifier.Element {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Dimension f37877b;

    public CornerRadiusModifier(Dimension dimension) {
        this.f37877b = dimension;
    }

    public final Dimension b() {
        return this.f37877b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CornerRadiusModifier) && Intrinsics.areEqual(this.f37877b, ((CornerRadiusModifier) obj).f37877b);
    }

    public int hashCode() {
        return this.f37877b.hashCode();
    }

    public String toString() {
        return "CornerRadiusModifier(radius=" + this.f37877b + ')';
    }
}
