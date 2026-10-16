package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
final /* synthetic */ class FlowKt__DistinctKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1 f141649a = new Function1() { // from class: kotlinx.coroutines.flow.a
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return FlowKt__DistinctKt.d(obj);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function2 f141650b = new Function2() { // from class: kotlinx.coroutines.flow.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(FlowKt__DistinctKt.c(obj, obj2));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static final Flow e(Flow flow) {
        return flow instanceof StateFlow ? flow : h(flow, f141649a, f141650b);
    }

    public static final Flow f(Flow flow, Function2 function2) {
        Function1 function1 = f141649a;
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return h(flow, function1, (Function2) TypeIntrinsics.f(function2, 2));
    }

    public static final Flow g(Flow flow, Function1 function1) {
        return h(flow, function1, f141650b);
    }

    private static final Flow h(Flow flow, Function1 function1, Function2 function2) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.f141480b == function1 && distinctFlowImpl.f141481c == function2) {
                return flow;
            }
        }
        return new DistinctFlowImpl(flow, function1, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Object obj) {
        return obj;
    }
}
