package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

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
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f142018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Flow f142019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function3 f142020c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", l = {110, 111}, m = "collect")
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f142021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f142022b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f142024d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f142025f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f142026g;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f142021a = obj;
            this.f142022b |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.f142018a = obj;
        this.f142019b = flow;
        this.f142020c = function3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        if (r8.collect(r5, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f142022b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f142022b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f142021a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f142022b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L7b
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.f142026g
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r2 = r0.f142025f
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.f142024d
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 r4 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) r4
            kotlin.ResultKt.b(r8)
            goto L62
        L44:
            kotlin.ResultKt.b(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.lang.Object r2 = r6.f142018a
            r8.f140144a = r2
            r0.f142024d = r6
            r0.f142025f = r7
            r0.f142026g = r8
            r0.f142022b = r4
            java.lang.Object r2 = r7.emit(r2, r0)
            if (r2 != r1) goto L5f
            goto L7a
        L5f:
            r4 = r6
            r2 = r7
            r7 = r8
        L62:
            kotlinx.coroutines.flow.Flow r8 = r4.f142019b
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1 r5 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1
            kotlin.jvm.functions.Function3 r4 = r4.f142020c
            r5.<init>(r7, r4, r2)
            r7 = 0
            r0.f142024d = r7
            r0.f142025f = r7
            r0.f142026g = r7
            r0.f142022b = r3
            java.lang.Object r7 = r8.collect(r5, r0)
            if (r7 != r1) goto L7b
        L7a:
            return r1
        L7b:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
