package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
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
public final class UArraysKt___UArraysJvmKt$asList$1 extends AbstractList<UInt> implements RandomAccess {

    /* JADX INFO: renamed from: $$v$c$kotlin-UIntArray$-$this$asList$0, reason: not valid java name */
    final /* synthetic */ int[] f43$$v$c$kotlinUIntArray$$this$asList$0;

    UArraysKt___UArraysJvmKt$asList$1(int[] iArr) {
        this.f43$$v$c$kotlinUIntArray$$this$asList$0 = iArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m1528containsWZ4Q5Ns(((UInt) obj).f());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m1528containsWZ4Q5Ns(int i3) {
        return UIntArray.f(this.f43$$v$c$kotlinUIntArray$$this$asList$0, i3);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i3) {
        return UInt.a(m1529getpVg5ArA(i3));
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public int m1529getpVg5ArA(int i3) {
        return UIntArray.l(this.f43$$v$c$kotlinUIntArray$$this$asList$0, i3);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UIntArray.o(this.f43$$v$c$kotlinUIntArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof UInt) {
            return m1530indexOfWZ4Q5Ns(((UInt) obj).f());
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOf-WZ4Q5Ns, reason: not valid java name */
    public int m1530indexOfWZ4Q5Ns(int i3) {
        return ArraysKt.indexOf(this.f43$$v$c$kotlinUIntArray$$this$asList$0, i3);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UIntArray.q(this.f43$$v$c$kotlinUIntArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof UInt) {
            return m1531lastIndexOfWZ4Q5Ns(((UInt) obj).f());
        }
        return -1;
    }

    /* JADX INFO: renamed from: lastIndexOf-WZ4Q5Ns, reason: not valid java name */
    public int m1531lastIndexOfWZ4Q5Ns(int i3) {
        return ArraysKt.lastIndexOf(this.f43$$v$c$kotlinUIntArray$$this$asList$0, i3);
    }
}
