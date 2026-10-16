package androidx.paging;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ConflatedEventBus<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableStateFlow f49657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Flow f49658b;

    public ConflatedEventBus(Object obj) {
        final MutableStateFlow mutableStateFlowA = StateFlowKt.a(new Pair(Integer.MIN_VALUE, obj));
        this.f49657a = mutableStateFlowA;
        this.f49658b = new Flow<T>() { // from class: androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f49660a;

                /* JADX INFO: renamed from: androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2", f = "ConflatedEventBus.kt", l = {225}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f49661a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f49662b;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f49661a = obj;
                        this.f49662b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f49660a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2$1 r0 = (androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f49662b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f49662b = r1
                        goto L18
                    L13:
                        androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2$1 r0 = new androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f49661a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f49662b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f49660a
                        kotlin.Pair r5 = (kotlin.Pair) r5
                        java.lang.Object r5 = r5.f()
                        if (r5 == 0) goto L47
                        r0.f49662b = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.ConflatedEventBus$special$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = mutableStateFlowA.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    public final Flow a() {
        return this.f49658b;
    }

    public final void b(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        MutableStateFlow mutableStateFlow = this.f49657a;
        mutableStateFlow.setValue(new Pair(Integer.valueOf(((Number) ((Pair) mutableStateFlow.getValue()).e()).intValue() + 1), data));
    }

    public /* synthetic */ ConflatedEventBus(Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : obj);
    }
}
