package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class NonEmptyListKt {
    public static final /* synthetic */ Result flatten(NonEmptyList nonEmptyList) {
        Intrinsics.checkNotNullParameter(nonEmptyList, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<A> it = nonEmptyList.iterator();
        while (it.hasNext()) {
            Result result = (Result) it.next();
            if (result instanceof Result.Success) {
                if (arrayList2.isEmpty()) {
                    arrayList.add(((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList2.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = toNonEmptyListOrNull(arrayList2);
        Result error = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList);
        if (error instanceof Result.Success) {
            NonEmptyList nonEmptyListOrNull2 = toNonEmptyListOrNull((List) ((Result.Success) error).getValue());
            Intrinsics.checkNotNull(nonEmptyListOrNull2);
            return new Result.Success(nonEmptyListOrNull2);
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ NonEmptyList nonEmptyListOf(Object obj, Object... t2) {
        Intrinsics.checkNotNullParameter(t2, "t");
        return new NonEmptyList(obj, ArraysKt.toList(t2));
    }

    public static final /* synthetic */ NonEmptyList toNonEmptyListOrNull(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return new NonEmptyList(it.next(), CollectionsKt.toList(new NonEmptyListKt$toNonEmptyListOrNull$$inlined$Iterable$1(it)));
        }
        return null;
    }
}
