package org.koin.core.definition;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.module.Module;

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
/* JADX INFO: loaded from: classes9.dex */
@KoinDslMarker
@Metadata
public final class KoinDefinition<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Module f145923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InstanceFactory f145924b;

    public KoinDefinition(Module module, InstanceFactory factory) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.f145923a = module;
        this.f145924b = factory;
    }

    public final InstanceFactory a() {
        return this.f145924b;
    }

    public final Module b() {
        return this.f145923a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KoinDefinition)) {
            return false;
        }
        KoinDefinition koinDefinition = (KoinDefinition) obj;
        return Intrinsics.areEqual(this.f145923a, koinDefinition.f145923a) && Intrinsics.areEqual(this.f145924b, koinDefinition.f145924b);
    }

    public int hashCode() {
        return (this.f145923a.hashCode() * 31) + this.f145924b.hashCode();
    }

    public String toString() {
        return "KoinDefinition(module=" + this.f145923a + ", factory=" + this.f145924b + ')';
    }
}
