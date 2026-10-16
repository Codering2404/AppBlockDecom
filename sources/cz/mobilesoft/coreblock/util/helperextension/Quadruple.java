package cz.mobilesoft.coreblock.util.helperextension;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class Quadruple<T, U, V, Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f128645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f128646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f128647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f128648d;

    public Quadruple(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f128645a = obj;
        this.f128646b = obj2;
        this.f128647c = obj3;
        this.f128648d = obj4;
    }

    public final Object a() {
        return this.f128645a;
    }

    public final Object b() {
        return this.f128648d;
    }

    public final Object c() {
        return this.f128646b;
    }

    public final Object d() {
        return this.f128647c;
    }
}
