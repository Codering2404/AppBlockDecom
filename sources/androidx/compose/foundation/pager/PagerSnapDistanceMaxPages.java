package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class PagerSnapDistanceMaxPages implements PagerSnapDistance {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8840b;

    public PagerSnapDistanceMaxPages(int i3) {
        this.f8840b = i3;
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public int a(int i3, int i4, float f3, int i5, int i6) {
        long j3 = i3;
        return RangesKt.p(i4, (int) RangesKt.g(j3 - ((long) this.f8840b), 0L), (int) RangesKt.l(j3 + ((long) this.f8840b), 2147483647L));
    }

    public boolean equals(Object obj) {
        return (obj instanceof PagerSnapDistanceMaxPages) && this.f8840b == ((PagerSnapDistanceMaxPages) obj).f8840b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f8840b);
    }
}
