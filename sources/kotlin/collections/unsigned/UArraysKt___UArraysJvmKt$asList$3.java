package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
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
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<UByte> implements RandomAccess {

    /* JADX INFO: renamed from: $$v$c$kotlin-UByteArray$-$this$asList$0, reason: not valid java name */
    final /* synthetic */ byte[] f45$$v$c$kotlinUByteArray$$this$asList$0;

    UArraysKt___UArraysJvmKt$asList$3(byte[] bArr) {
        this.f45$$v$c$kotlinUByteArray$$this$asList$0 = bArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m1536contains7apg3OU(((UByte) obj).f());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m1536contains7apg3OU(byte b3) {
        return UByteArray.f(this.f45$$v$c$kotlinUByteArray$$this$asList$0, b3);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i3) {
        return UByte.a(m1537getw2LRezQ(i3));
    }

    /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
    public byte m1537getw2LRezQ(int i3) {
        return UByteArray.l(this.f45$$v$c$kotlinUByteArray$$this$asList$0, i3);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UByteArray.o(this.f45$$v$c$kotlinUByteArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof UByte) {
            return m1538indexOf7apg3OU(((UByte) obj).f());
        }
        return -1;
    }

    /* JADX INFO: renamed from: indexOf-7apg3OU, reason: not valid java name */
    public int m1538indexOf7apg3OU(byte b3) {
        return ArraysKt.indexOf(this.f45$$v$c$kotlinUByteArray$$this$asList$0, b3);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UByteArray.q(this.f45$$v$c$kotlinUByteArray$$this$asList$0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof UByte) {
            return m1539lastIndexOf7apg3OU(((UByte) obj).f());
        }
        return -1;
    }

    /* JADX INFO: renamed from: lastIndexOf-7apg3OU, reason: not valid java name */
    public int m1539lastIndexOf7apg3OU(byte b3) {
        return ArraysKt.lastIndexOf(this.f45$$v$c$kotlinUByteArray$$this$asList$0, b3);
    }
}
