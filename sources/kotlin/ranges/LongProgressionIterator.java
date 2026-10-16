package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

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
public final class LongProgressionIterator extends LongIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f140225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f140227d;

    public LongProgressionIterator(long j3, long j4, long j5) {
        this.f140224a = j5;
        this.f140225b = j4;
        boolean z2 = false;
        if (j5 <= 0 ? j3 >= j4 : j3 <= j4) {
            z2 = true;
        }
        this.f140226c = z2;
        this.f140227d = z2 ? j3 : j4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f140226c;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long j3 = this.f140227d;
        if (j3 != this.f140225b) {
            this.f140227d = this.f140224a + j3;
            return j3;
        }
        if (!this.f140226c) {
            throw new NoSuchElementException();
        }
        this.f140226c = false;
        return j3;
    }
}
