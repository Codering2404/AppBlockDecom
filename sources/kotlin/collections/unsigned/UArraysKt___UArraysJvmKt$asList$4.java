package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UShortArray;
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
public final class UArraysKt___UArraysJvmKt$asList$4 extends AbstractList<UShort> implements RandomAccess {

    /* JADX INFO: renamed from: $$v$c$kotlin-UShortArray$-$this$asList$0, reason: not valid java name */
    final /* synthetic */ short[] f46$$v$c$kotlinUShortArray$$this$asList$0;

    UArraysKt___UArraysJvmKt$asList$4(short[] sArr) {
        this.f46$$v$c$kotlinUShortArray$$this$asList$0 = sArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m1540containsxj2QHRw(((UShort) obj).f());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public boolean m1540containsxj2QHRw(short s2) {
        return UShortArray.f(this.f46$$v$c$kotlinUShortArray$$this$asList$0, s2);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i3) {
        return UShort.a(m1541getMh2AYeg(i3));
    }

    /* JADX INFO: renamed from: get-Mh2AYeg, reason: not valid java name */
    public short m1541getMh2AYeg(int i3) {
        return UShortArray.l(this.f46$$v$c$kotlinUShortArray$$this$asList$0, i3);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UShortArray.o(this.f46$$v$c$kotlinUShortArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof UShort) {
            return m1542indexOfxj2QHRw(((UShort) obj).f());
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOf-xj2QHRw, reason: not valid java name */
    public int m1542indexOfxj2QHRw(short s2) {
        return ArraysKt.indexOf(this.f46$$v$c$kotlinUShortArray$$this$asList$0, s2);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UShortArray.q(this.f46$$v$c$kotlinUShortArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof UShort) {
            return m1543lastIndexOfxj2QHRw(((UShort) obj).f());
        }
        return -1;
    }

    /* JADX INFO: renamed from: lastIndexOf-xj2QHRw, reason: not valid java name */
    public int m1543lastIndexOfxj2QHRw(short s2) {
        return ArraysKt.lastIndexOf(this.f46$$v$c$kotlinUShortArray$$this$asList$0, s2);
    }
}
