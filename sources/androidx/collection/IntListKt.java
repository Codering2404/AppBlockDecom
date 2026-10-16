package androidx.collection;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class IntListKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IntList f2878a = new MutableIntList(0);

    public static final IntList a() {
        return f2878a;
    }

    public static final IntList b(int i3) {
        return e(i3);
    }

    public static final IntList c(int i3, int i4) {
        return f(i3, i4);
    }

    public static final IntList d(int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        mutableIntList.m(mutableIntList.f2877b, elements);
        return mutableIntList;
    }

    public static final MutableIntList e(int i3) {
        MutableIntList mutableIntList = new MutableIntList(1);
        mutableIntList.l(i3);
        return mutableIntList;
    }

    public static final MutableIntList f(int i3, int i4) {
        MutableIntList mutableIntList = new MutableIntList(2);
        mutableIntList.l(i3);
        mutableIntList.l(i4);
        return mutableIntList;
    }
}
