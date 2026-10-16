package cz.mobilesoft.statistics.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StatisticsDatabaseExtKt {
    public static final Object a(int i3, long j3, Function1 function1, Function1 function12, Continuation continuation) {
        return FlowKt.F(b(FlowKt.I(new StatisticsDatabaseExtKt$retryInFlowOrNull$2(function12, null)), i3, j3, function1), continuation);
    }

    public static final Flow b(Flow flow, int i3, long j3, Function1 function1) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.h(FlowKt.a0(flow, new StatisticsDatabaseExtKt$retryWhenLocked$1(i3, j3, null)), new StatisticsDatabaseExtKt$retryWhenLocked$2(function1, null));
    }
}
