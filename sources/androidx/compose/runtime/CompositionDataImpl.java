package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionInstance;
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
public final class CompositionDataImpl implements CompositionData, CompositionInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Composition f23803a;

    public CompositionDataImpl(Composition composition) {
        this.f23803a = composition;
    }

    private final SlotTable c() {
        Composition composition = this.f23803a;
        Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        return ((CompositionImpl) composition).I();
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable b() {
        return c().b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof CompositionDataImpl) && Intrinsics.areEqual(this.f23803a, ((CompositionDataImpl) obj).f23803a);
    }

    public int hashCode() {
        return this.f23803a.hashCode() * 31;
    }
}
