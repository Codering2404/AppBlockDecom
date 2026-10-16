package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", l = {102, 104}, m = "invokeSuspend", v = 2)
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f140351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f140352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Sequence f140353d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f140354f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$ifEmpty$1(Sequence sequence, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f140353d = sequence;
        this.f140354f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.f140353d, this.f140354f, continuation);
        sequencesKt__SequencesKt$ifEmpty$1.f140352c = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if (r0.b(r6, r5) == r1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        if (r0.c(r2, r5) == r1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f140352c
            kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r5.f140351b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L23
            if (r2 == r4) goto L1b
            if (r2 != r3) goto L13
            goto L1b
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1b:
            java.lang.Object r0 = r5.f140350a
            java.util.Iterator r0 = (java.util.Iterator) r0
            kotlin.ResultKt.b(r6)
            goto L64
        L23:
            kotlin.ResultKt.b(r6)
            kotlin.sequences.Sequence r6 = r5.f140353d
            java.util.Iterator r6 = r6.iterator()
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L47
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r5.f140352c = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f140350a = r2
            r5.f140351b = r4
            java.lang.Object r6 = r0.b(r6, r5)
            if (r6 != r1) goto L64
            goto L63
        L47:
            kotlin.jvm.functions.Function0 r2 = r5.f140354f
            java.lang.Object r2 = r2.invoke()
            kotlin.sequences.Sequence r2 = (kotlin.sequences.Sequence) r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r5.f140352c = r4
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f140350a = r6
            r5.f140351b = r3
            java.lang.Object r6 = r0.c(r2, r5)
            if (r6 != r1) goto L64
        L63:
            return r1
        L64:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
