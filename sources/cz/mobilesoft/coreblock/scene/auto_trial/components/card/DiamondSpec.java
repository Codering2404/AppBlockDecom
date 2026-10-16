package cz.mobilesoft.coreblock.scene.auto_trial.components.card;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class DiamondSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f98946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f98947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f98948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f98949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f98950e;

    public DiamondSpec(float f3, float f4, float f5, float f6, float f7) {
        this.f98946a = f3;
        this.f98947b = f4;
        this.f98948c = f5;
        this.f98949d = f6;
        this.f98950e = f7;
    }

    public final float a() {
        return this.f98946a;
    }

    public final float b() {
        return this.f98947b;
    }

    public final float c() {
        return this.f98950e;
    }

    public final float d() {
        return this.f98948c;
    }

    public final float e() {
        return this.f98949d;
    }
}
