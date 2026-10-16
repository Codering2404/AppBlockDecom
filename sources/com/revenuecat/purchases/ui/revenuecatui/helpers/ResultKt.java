package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
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
public final /* synthetic */ class ResultKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, F> List<F> collectErrors(List<? extends Result<? extends T, ? extends NonEmptyList<? extends F>>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Result result = (Result) it.next();
            Result.Error error = result instanceof Result.Error ? (Result.Error) result : null;
            NonEmptyList nonEmptyList = error != null ? (NonEmptyList) error.getValue() : null;
            if (nonEmptyList != null) {
                arrayList.add(nonEmptyList);
            }
        }
        return CollectionsKt.flatten(arrayList);
    }

    public static final /* synthetic */ Result errorIfNull(Object obj, Object obj2) {
        return obj != null ? new Result.Success(obj) : new Result.Error(obj2);
    }

    public static final /* synthetic */ Object errorOrNull(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return null;
        }
        if (result instanceof Result.Error) {
            return ((Result.Error) result).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<R, B> flatMap(Result<? extends A, ? extends B> result, Function1<? super A, ? extends Result<? extends R, ? extends B>> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return (Result) transform.invoke(((Result.Success) result).getValue());
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<A, R> flatMapError(Result<? extends A, ? extends B> result, Function1<? super B, ? extends Result<? extends A, ? extends R>> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            return (Result) transform.invoke(((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ <A extends R, B, R> R getOrElse(Result<? extends A, ? extends B> result, Function1<? super B, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        if (result instanceof Result.Success) {
            return (R) ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return (R) onFailure.invoke(((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Object getOrNull(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return ((Result.Success) result).getValue();
        }
        if (result instanceof Result.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Object getOrThrow(Result result) throws Throwable {
        Intrinsics.checkNotNullParameter(result, "<this>");
        if (result instanceof Result.Success) {
            return ((Result.Success) result).getValue();
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Error error = (Result.Error) result;
        if (error.getValue() instanceof Throwable) {
            throw ((Throwable) error.getValue());
        }
        throw new IllegalStateException(("Result was unsuccessful: " + error.getValue()).toString());
    }

    public static final /* synthetic */ boolean isError(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        return result instanceof Result.Error;
    }

    public static final /* synthetic */ boolean isSuccess(Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        return result instanceof Result.Success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<R, B> map(Result<? extends A, ? extends B> result, Function1<? super A, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return new Result.Success(transform.invoke(((Result.Success) result).getValue()));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, R> Result<A, R> mapError(Result<? extends A, ? extends B> result, Function1<? super B, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            return new Result.Error(transform.invoke(((Result.Error) result).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B, E> Result<List<B>, NonEmptyList<E>> mapOrAccumulate(Iterable<? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> iterable, Function1<? super A, ? extends B> transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Result<? extends A, ? extends NonEmptyList<? extends E>> result : iterable) {
            if (result instanceof Result.Success) {
                if (arrayList2.isEmpty()) {
                    arrayList.add(transform.invoke(((Result.Success) result).getValue()));
                }
            } else if (result instanceof Result.Error) {
                arrayList2.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList2);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList);
    }

    public static final /* synthetic */ <K, A, B, E> Result<Map<K, B>, NonEmptyList<E>> mapValuesOrAccumulate(Map<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> map, Function1<? super A, ? extends B> transform) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> entry : map.entrySet()) {
            K key = entry.getKey();
            Result<? extends A, ? extends NonEmptyList<? extends E>> value = entry.getValue();
            if (value instanceof Result.Success) {
                if (arrayList.isEmpty()) {
                    linkedHashMap.put(key, transform.invoke(((Result.Success) value).getValue()));
                }
            } else if (value instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) value).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        return nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <A, B> Result<A, B> onError(Result<? extends A, ? extends B> result, Function1<? super B, Unit> block) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!(result instanceof Result.Success) && (result instanceof Result.Error)) {
            block.invoke(((Result.Error) result).getValue());
        }
        return result;
    }

    public static final /* synthetic */ Result orSuccessfullyNull(Result result) {
        return result == null ? new Result.Success(null) : result;
    }

    public static final /* synthetic */ <A, B, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Function2<? super A, ? super B, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        Result.Success success3 = new Result.Success(unit);
        Result.Success success4 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Object value = ((Result.Success) first).getValue();
        Object value2 = ((Result.Success) second).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        return new Result.Success(transform.invoke(value, value2));
    }

    public static final /* synthetic */ <K, A, B, E> Result<NonEmptyMap<K, B>, NonEmptyList<E>> mapValuesOrAccumulate(NonEmptyMap<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> nonEmptyMap, Function1<? super A, ? extends B> transform) {
        Intrinsics.checkNotNullParameter(nonEmptyMap, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Result success = (Result) nonEmptyMap.getEntry().getValue();
        if (success instanceof Result.Success) {
            success = new Result.Success(transform.invoke(((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(TuplesKt.a(nonEmptyMap.getEntry().getKey(), ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success) && (success instanceof Result.Error)) {
            arrayList.addAll((NonEmptyList) ((Result.Error) success).getValue());
        }
        for (Map.Entry<K, ? extends Result<? extends A, ? extends NonEmptyList<? extends E>>> entry : nonEmptyMap.entrySet()) {
            K key = entry.getKey();
            Result<? extends A, ? extends NonEmptyList<? extends E>> value = entry.getValue();
            if (value instanceof Result.Success) {
                if (arrayList.isEmpty() && !Intrinsics.areEqual(key, nonEmptyMap.getEntry().getKey())) {
                    linkedHashMap.put(key, transform.invoke(((Result.Success) value).getValue()));
                }
            } else if (value instanceof Result.Error) {
                arrayList.addAll((Collection) ((Result.Error) value).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList);
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        return new Result.Success(NonEmptyMapKt.nonEmptyMapOf((Pair) getOrThrow(success), linkedHashMap));
    }

    public static final /* synthetic */ <A, B, C, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Function3<? super A, ? super B, ? super C, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        Result.Success success3 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, success, success2, success3})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Object value = ((Result.Success) first).getValue();
        Object value2 = ((Result.Success) second).getValue();
        Object value3 = ((Result.Success) third).getValue();
        Object value4 = success.getValue();
        Object value5 = success2.getValue();
        return new Result.Success(transform.invoke(value, value2, value3));
    }

    public static final /* synthetic */ <A, B, C, D, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Result<? extends D, ? extends NonEmptyList<? extends H>> fourth, Function4<? super A, ? super B, ? super C, ? super D, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, fourth, success, success2})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Object value = ((Result.Success) first).getValue();
        Object value2 = ((Result.Success) second).getValue();
        Object value3 = ((Result.Success) third).getValue();
        Object value4 = ((Result.Success) fourth).getValue();
        Object value5 = success.getValue();
        return new Result.Success(transform.invoke(value, value2, value3, value4));
    }

    public static final /* synthetic */ <A, B, C, D, E, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> first, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Result<? extends D, ? extends NonEmptyList<? extends H>> fourth, Result<? extends E, ? extends NonEmptyList<? extends H>> fifth, Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(fifth, "fifth");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Result.Success success = new Result.Success(Unit.f139807a);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, fourth, fifth, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Object value = ((Result.Success) first).getValue();
        Object value2 = ((Result.Success) second).getValue();
        Object value3 = ((Result.Success) third).getValue();
        Object value4 = ((Result.Success) fourth).getValue();
        Object value5 = ((Result.Success) fifth).getValue();
        return new Result.Success(transform.invoke(value, value2, value3, value4, value5));
    }

    public static final /* synthetic */ <A, B, C, D, E, F, G, H> Result<G, NonEmptyList<H>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends H>> result, Result<? extends B, ? extends NonEmptyList<? extends H>> second, Result<? extends C, ? extends NonEmptyList<? extends H>> third, Result<? extends D, ? extends NonEmptyList<? extends H>> fourth, Result<? extends E, ? extends NonEmptyList<? extends H>> fifth, Result<? extends F, ? extends NonEmptyList<? extends H>> sixth, Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? extends G> transform) {
        Intrinsics.checkNotNullParameter(result, MrGIhy.eniXBVUzZAC);
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(fifth, "fifth");
        Intrinsics.checkNotNullParameter(sixth, "sixth");
        Intrinsics.checkNotNullParameter(transform, "transform");
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{result, second, third, fourth, fifth, sixth})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        return new Result.Success(transform.k(((Result.Success) result).getValue(), ((Result.Success) second).getValue(), ((Result.Success) third).getValue(), ((Result.Success) fourth).getValue(), ((Result.Success) fifth).getValue(), ((Result.Success) sixth).getValue()));
    }

    public static final /* synthetic */ <A, B, C, D, E, F, G, H, I> Result<H, NonEmptyList<I>> zipOrAccumulate(Result<? extends A, ? extends NonEmptyList<? extends I>> first, Result<? extends B, ? extends NonEmptyList<? extends I>> second, Result<? extends C, ? extends NonEmptyList<? extends I>> third, Result<? extends D, ? extends NonEmptyList<? extends I>> fourth, Result<? extends E, ? extends NonEmptyList<? extends I>> fifth, Result<? extends F, ? extends NonEmptyList<? extends I>> sixth, Result<? extends G, ? extends NonEmptyList<? extends I>> seventh, Function7<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? extends H> transform) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        Intrinsics.checkNotNullParameter(fourth, "fourth");
        Intrinsics.checkNotNullParameter(fifth, "fifth");
        Intrinsics.checkNotNullParameter(sixth, "sixth");
        Intrinsics.checkNotNullParameter(seventh, "seventh");
        Intrinsics.checkNotNullParameter(transform, "transform");
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(collectErrors(CollectionsKt.listOf((Object[]) new Result[]{first, second, third, fourth, fifth, sixth})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        return new Result.Success(transform.o(((Result.Success) first).getValue(), ((Result.Success) second).getValue(), ((Result.Success) third).getValue(), ((Result.Success) fourth).getValue(), ((Result.Success) fifth).getValue(), ((Result.Success) sixth).getValue(), ((Result.Success) seventh).getValue()));
    }
}
