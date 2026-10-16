package kotlinx.coroutines.stream;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class StreamFlow<T> implements Flow<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142625b = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Stream f142626a;
    private volatile /* synthetic */ int consumed$volatile;

    /* JADX INFO: renamed from: kotlinx.coroutines.stream.StreamFlow$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", l = {22}, m = "collect")
    static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f142627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f142628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f142629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f142630d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f142632g;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f142630d = obj;
            this.f142632g |= Integer.MIN_VALUE;
            return StreamFlow.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.stream.StreamFlow.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = (kotlinx.coroutines.stream.StreamFlow.AnonymousClass1) r0
            int r1 = r0.f142632g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f142632g = r1
            goto L18
        L13:
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = new kotlinx.coroutines.stream.StreamFlow$collect$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f142630d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f142632g
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.f142629c
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.f142628b
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.f142627a
            kotlinx.coroutines.stream.StreamFlow r4 = (kotlinx.coroutines.stream.StreamFlow) r4
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L36
            r7 = r2
            goto L58
        L36:
            r6 = move-exception
            goto L7b
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = f()
            r2 = 0
            boolean r7 = r7.compareAndSet(r5, r2, r3)
            if (r7 == 0) goto L81
            java.util.stream.Stream r7 = r5.f142626a     // Catch: java.lang.Throwable -> L79
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L79
            r4 = r7
            r7 = r6
            r6 = r4
            r4 = r5
        L58:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L71
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L36
            r0.f142627a = r4     // Catch: java.lang.Throwable -> L36
            r0.f142628b = r7     // Catch: java.lang.Throwable -> L36
            r0.f142629c = r6     // Catch: java.lang.Throwable -> L36
            r0.f142632g = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r2 = r7.emit(r2, r0)     // Catch: java.lang.Throwable -> L36
            if (r2 != r1) goto L58
            return r1
        L71:
            java.util.stream.Stream r6 = r4.f142626a
            r6.close()
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L79:
            r6 = move-exception
            r4 = r5
        L7b:
            java.util.stream.Stream r7 = r4.f142626a
            r7.close()
            throw r6
        L81:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Stream.consumeAsFlow can be collected only once"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.stream.StreamFlow.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
