package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

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
@Metadata
final class KTypeWrapper implements KType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KType f142826a;

    public KTypeWrapper(KType origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f142826a = origin;
    }

    @Override // kotlin.reflect.KType
    public boolean c() {
        return this.f142826a.c();
    }

    @Override // kotlin.reflect.KType
    public KClassifier d() {
        return this.f142826a.d();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        KType kType = this.f142826a;
        KTypeWrapper kTypeWrapper = obj instanceof KTypeWrapper ? (KTypeWrapper) obj : null;
        if (!Intrinsics.areEqual(kType, kTypeWrapper != null ? kTypeWrapper.f142826a : null)) {
            return false;
        }
        KClassifier kClassifierD = d();
        if (kClassifierD instanceof KClass) {
            KType kType2 = obj instanceof KType ? (KType) obj : null;
            KClassifier kClassifierD2 = kType2 != null ? kType2.d() : null;
            if (kClassifierD2 != null && (kClassifierD2 instanceof KClass)) {
                return Intrinsics.areEqual(JvmClassMappingKt.a((KClass) kClassifierD), JvmClassMappingKt.a((KClass) kClassifierD2));
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f142826a.hashCode();
    }

    @Override // kotlin.reflect.KType
    public List p() {
        return this.f142826a.p();
    }

    public String toString() {
        return "KTypeWrapper: " + this.f142826a;
    }
}
