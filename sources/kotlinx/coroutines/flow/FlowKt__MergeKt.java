package kotlinx.coroutines.flow;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;

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
final /* synthetic */ class FlowKt__MergeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f141798a = SystemPropsKt.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Api.BaseClientBuilder.API_PRIORITY_OTHER);

    public static final int a() {
        return f141798a;
    }

    public static final Flow b(Flow flow, Function2 function2) {
        return FlowKt.m0(flow, new FlowKt__MergeKt$mapLatest$1(function2, null));
    }

    public static final Flow c(Iterable iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    public static final Flow d(Flow... flowArr) {
        return FlowKt.S(ArraysKt.asIterable(flowArr));
    }

    public static final Flow e(Flow flow, Function3 function3) {
        return new ChannelFlowTransformLatest(function3, flow, null, 0, null, 28, null);
    }
}
