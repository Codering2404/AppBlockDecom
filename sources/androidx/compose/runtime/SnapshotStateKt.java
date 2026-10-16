package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SnapshotStateKt {
    public static final State a(Flow flow, Object obj, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        return SnapshotStateKt__SnapshotFlowKt.b(flow, obj, coroutineContext, composer, i3, i4);
    }

    public static final State b(StateFlow stateFlow, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        return SnapshotStateKt__SnapshotFlowKt.c(stateFlow, coroutineContext, composer, i3, i4);
    }

    public static final MutableVector c() {
        return SnapshotStateKt__DerivedStateKt.b();
    }

    public static final State d(SnapshotMutationPolicy snapshotMutationPolicy, Function0 function0) {
        return SnapshotStateKt__DerivedStateKt.c(snapshotMutationPolicy, function0);
    }

    public static final State e(Function0 function0) {
        return SnapshotStateKt__DerivedStateKt.d(function0);
    }

    public static final SnapshotStateList f() {
        return SnapshotStateKt__SnapshotStateKt.a();
    }

    public static final SnapshotStateList g(Object... objArr) {
        return SnapshotStateKt__SnapshotStateKt.b(objArr);
    }

    public static final SnapshotStateMap h() {
        return SnapshotStateKt__SnapshotStateKt.c();
    }

    public static final MutableState i(Object obj, SnapshotMutationPolicy snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.d(obj, snapshotMutationPolicy);
    }

    public static final SnapshotMutationPolicy k() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.a();
    }

    public static final State l(Object obj, Object obj2, Object obj3, Function2 function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.a(obj, obj2, obj3, function2, composer, i3);
    }

    public static final State m(Object obj, Function2 function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.b(obj, function2, composer, i3);
    }

    public static final State n(Object obj, Object[] objArr, Function2 function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.c(obj, objArr, function2, composer, i3);
    }

    public static final SnapshotMutationPolicy o() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.b();
    }

    public static final State p(Object obj, Composer composer, int i3) {
        return SnapshotStateKt__SnapshotStateKt.f(obj, composer, i3);
    }

    public static final Flow q(Function0 function0) {
        return SnapshotStateKt__SnapshotFlowKt.e(function0);
    }

    public static final SnapshotMutationPolicy r() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.c();
    }
}
