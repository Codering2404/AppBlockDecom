package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

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
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {

    /* JADX INFO: renamed from: $$v$c$kotlin-ULongArray$-$this$asList$0, reason: not valid java name */
    final /* synthetic */ long[] f44$$v$c$kotlinULongArray$$this$asList$0;

    UArraysKt___UArraysJvmKt$asList$2(long[] jArr) {
        this.f44$$v$c$kotlinULongArray$$this$asList$0 = jArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m1532containsVKZWuLQ(((ULong) obj).g());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m1532containsVKZWuLQ(long j3) {
        return ULongArray.f(this.f44$$v$c$kotlinULongArray$$this$asList$0, j3);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i3) {
        return ULong.a(m1533getsVKNKU(i3));
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public long m1533getsVKNKU(int i3) {
        return ULongArray.l(this.f44$$v$c$kotlinULongArray$$this$asList$0, i3);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return ULongArray.o(this.f44$$v$c$kotlinULongArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ULong) {
            return m1534indexOfVKZWuLQ(((ULong) obj).g());
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOf-VKZWuLQ, reason: not valid java name */
    public int m1534indexOfVKZWuLQ(long j3) {
        return ArraysKt.indexOf(this.f44$$v$c$kotlinULongArray$$this$asList$0, j3);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ULongArray.q(this.f44$$v$c$kotlinULongArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ULong) {
            return m1535lastIndexOfVKZWuLQ(((ULong) obj).g());
        }
        return -1;
    }

    /* JADX INFO: renamed from: lastIndexOf-VKZWuLQ, reason: not valid java name */
    public int m1535lastIndexOfVKZWuLQ(long j3) {
        return ArraysKt.lastIndexOf(this.f44$$v$c$kotlinULongArray$$this$asList$0, j3);
    }
}
