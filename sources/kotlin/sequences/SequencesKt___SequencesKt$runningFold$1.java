package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", l = {2423, 2427}, m = "invokeSuspend", v = 2)
final class SequencesKt___SequencesKt$runningFold$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f140384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f140385d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f140386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Object f140387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Sequence f140388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function2 f140389i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFold$1(Object obj, Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f140387g = obj;
        this.f140388h = sequence;
        this.f140389i = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.f140387g, this.f140388h, this.f140389i, continuation);
        sequencesKt___SequencesKt$runningFold$1.f140386f = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r0.a(r7, r6) == r1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f140386f
            kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f140385d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L29
            if (r2 == r4) goto L25
            if (r2 != r3) goto L1d
            java.lang.Object r2 = r6.f140383b
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r6.f140382a
            kotlin.ResultKt.b(r7)
            r7 = r4
            goto L41
        L1d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L25:
            kotlin.ResultKt.b(r7)
            goto L39
        L29:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f140387g
            r6.f140386f = r0
            r6.f140385d = r4
            java.lang.Object r7 = r0.a(r7, r6)
            if (r7 != r1) goto L39
            goto L65
        L39:
            java.lang.Object r7 = r6.f140387g
            kotlin.sequences.Sequence r2 = r6.f140388h
            java.util.Iterator r2 = r2.iterator()
        L41:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L66
            java.lang.Object r4 = r2.next()
            kotlin.jvm.functions.Function2 r5 = r6.f140389i
            java.lang.Object r7 = r5.invoke(r7, r4)
            r6.f140386f = r0
            r6.f140382a = r7
            r6.f140383b = r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r6.f140384c = r4
            r6.f140385d = r3
            java.lang.Object r4 = r0.a(r7, r6)
            if (r4 != r1) goto L41
        L65:
            return r1
        L66:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFold$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
