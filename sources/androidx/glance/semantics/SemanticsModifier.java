package androidx.glance.semantics;

import androidx.glance.GlanceModifier;
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
public final class SemanticsModifier implements GlanceModifier.Element {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SemanticsConfiguration f39516b;

    public SemanticsModifier(SemanticsConfiguration semanticsConfiguration) {
        this.f39516b = semanticsConfiguration;
    }

    public final SemanticsConfiguration b() {
        return this.f39516b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SemanticsModifier) && Intrinsics.areEqual(this.f39516b, ((SemanticsModifier) obj).f39516b);
    }

    public int hashCode() {
        return this.f39516b.hashCode();
    }

    public String toString() {
        return "SemanticsModifier(configuration=" + this.f39516b + ')';
    }
}
