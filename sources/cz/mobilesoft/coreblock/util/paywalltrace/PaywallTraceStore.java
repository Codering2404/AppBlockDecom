package cz.mobilesoft.coreblock.util.paywalltrace;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class PaywallTraceStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PaywallTraceStore f128981a = new PaywallTraceStore();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableStateFlow f128982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f128983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final StateFlow f128984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f128985e;

    static {
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(CollectionsKt.emptyList());
        f128982b = mutableStateFlowA;
        f128984d = mutableStateFlowA;
        f128985e = 8;
    }

    private PaywallTraceStore() {
    }

    private final void e(PaywallTrace paywallTrace) {
        Object value;
        MutableStateFlow mutableStateFlow = f128982b;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.take(CollectionsKt.plus((Collection) CollectionsKt.listOf(paywallTrace), (Iterable) value), 50)));
    }

    public final void a() {
        f128983c++;
    }

    public final StateFlow b() {
        return f128984d;
    }

    public final void c(PaywallTrace trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        e(PaywallTrace.b(trace, 0L, null, null, null, null, null, null, null, null, null, f128983c, 1023, null));
    }

    public final void d(PaywallTrace trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        e(PaywallTrace.b(trace, 0L, null, null, null, null, null, null, null, null, null, 0, 1023, null));
    }
}
