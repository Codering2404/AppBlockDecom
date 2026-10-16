package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class KotlinRandom extends java.util.Random {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Companion f140177c = new Companion(null);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Random f140178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f140179b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // java.util.Random
    protected int next(int i3) {
        return this.f140178a.b(i3);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.f140178a.c();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f140178a.d(bytes);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.f140178a.f();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.f140178a.h();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.f140178a.i();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.f140178a.l();
    }

    @Override // java.util.Random
    public void setSeed(long j3) {
        if (this.f140179b) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.f140179b = true;
    }

    @Override // java.util.Random
    public int nextInt(int i3) {
        return this.f140178a.j(i3);
    }
}
