package kotlin.random;

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
public abstract class AbstractPlatformRandom extends Random {
    @Override // kotlin.random.Random
    public int b(int i3) {
        return RandomKt.i(n().nextInt(), i3);
    }

    @Override // kotlin.random.Random
    public boolean c() {
        return n().nextBoolean();
    }

    @Override // kotlin.random.Random
    public byte[] d(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        n().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public double f() {
        return n().nextDouble();
    }

    @Override // kotlin.random.Random
    public float h() {
        return n().nextFloat();
    }

    @Override // kotlin.random.Random
    public int i() {
        return n().nextInt();
    }

    @Override // kotlin.random.Random
    public int j(int i3) {
        return n().nextInt(i3);
    }

    @Override // kotlin.random.Random
    public long l() {
        return n().nextLong();
    }

    public abstract java.util.Random n();
}
