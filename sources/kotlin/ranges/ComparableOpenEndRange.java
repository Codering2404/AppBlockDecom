package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.OpenEndRange;

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
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparable f140206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparable f140207b;

    @Override // kotlin.ranges.OpenEndRange
    public Comparable a() {
        return this.f140206a;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ boolean b(Comparable comparable) {
        return OpenEndRange.DefaultImpls.a(this, comparable);
    }

    public /* bridge */ boolean c() {
        return OpenEndRange.DefaultImpls.b(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ComparableOpenEndRange)) {
            return false;
        }
        if (c() && ((ComparableOpenEndRange) obj).c()) {
            return true;
        }
        ComparableOpenEndRange comparableOpenEndRange = (ComparableOpenEndRange) obj;
        return Intrinsics.areEqual(a(), comparableOpenEndRange.a()) && Intrinsics.areEqual(f(), comparableOpenEndRange.f());
    }

    @Override // kotlin.ranges.OpenEndRange
    public Comparable f() {
        return this.f140207b;
    }

    public int hashCode() {
        if (c()) {
            return -1;
        }
        return (a().hashCode() * 31) + f().hashCode();
    }

    public String toString() {
        return a() + "..<" + f();
    }
}
