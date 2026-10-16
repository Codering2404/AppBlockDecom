package nl.dionsegijn.konfetti.modules;

import java.util.Random;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class LocationModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f143775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Float f143776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f143777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Float f143778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Random f143779e;

    public LocationModule(Random random) {
        Intrinsics.checkNotNullParameter(random, "random");
        this.f143779e = random;
    }

    public final void a(float f3, Float f4) {
        this.f143775a = f3;
        this.f143776b = f4;
    }

    public final void b(float f3, Float f4) {
        this.f143777c = f3;
        this.f143778d = f4;
    }

    public final float c() {
        if (this.f143776b == null) {
            return this.f143775a;
        }
        float fNextFloat = this.f143779e.nextFloat();
        Float f3 = this.f143776b;
        Intrinsics.checkNotNull(f3);
        float fFloatValue = f3.floatValue();
        float f4 = this.f143775a;
        return (fNextFloat * (fFloatValue - f4)) + f4;
    }

    public final float d() {
        if (this.f143778d == null) {
            return this.f143777c;
        }
        float fNextFloat = this.f143779e.nextFloat();
        Float f3 = this.f143778d;
        Intrinsics.checkNotNull(f3);
        float fFloatValue = f3.floatValue();
        float f4 = this.f143777c;
        return (fNextFloat * (fFloatValue - f4)) + f4;
    }
}
