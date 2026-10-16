package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

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
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparable f140208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparable f140209b;

    @Override // kotlin.ranges.ClosedRange
    public Comparable a() {
        return this.f140208a;
    }

    @Override // kotlin.ranges.ClosedRange
    public Comparable e() {
        return this.f140209b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ComparableRange)) {
            return false;
        }
        if (isEmpty() && ((ComparableRange) obj).isEmpty()) {
            return true;
        }
        ComparableRange comparableRange = (ComparableRange) obj;
        return Intrinsics.areEqual(a(), comparableRange.a()) && Intrinsics.areEqual(e(), comparableRange.e());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a().hashCode() * 31) + e().hashCode();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ boolean isEmpty() {
        return ClosedRange.DefaultImpls.a(this);
    }

    public String toString() {
        return a() + FacebookContentProvider.INVALID_FILE_NAME + e();
    }
}
