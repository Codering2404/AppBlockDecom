package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", l = {2451, 2456}, m = "invokeSuspend", v = 2)
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f140392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f140393d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f140394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private /* synthetic */ Object f140395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Object f140396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Sequence f140397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function3 f140398j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFoldIndexed$1(Object obj, Sequence sequence, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f140396h = obj;
        this.f140397i = sequence;
        this.f140398j = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.f140396h, this.f140397i, this.f140398j, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.f140395g = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        if (r0.a(r10, r9) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f140395g
            kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r9.f140394f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2b
            if (r2 == r4) goto L27
            if (r2 != r3) goto L1f
            int r2 = r9.f140393d
            java.lang.Object r4 = r9.f140391b
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r9.f140390a
            kotlin.ResultKt.b(r10)
            r10 = r5
            goto L47
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            kotlin.ResultKt.b(r10)
            goto L3b
        L2b:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.f140396h
            r9.f140395g = r0
            r9.f140394f = r4
            java.lang.Object r10 = r0.a(r10, r9)
            if (r10 != r1) goto L3b
            goto L78
        L3b:
            java.lang.Object r10 = r9.f140396h
            kotlin.sequences.Sequence r2 = r9.f140397i
            java.util.Iterator r2 = r2.iterator()
            r4 = 0
            r8 = r4
            r4 = r2
            r2 = r8
        L47:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L7b
            java.lang.Object r5 = r4.next()
            kotlin.jvm.functions.Function3 r6 = r9.f140398j
            int r7 = r2 + 1
            if (r2 >= 0) goto L5a
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L5a:
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.d(r2)
            java.lang.Object r10 = r6.invoke(r2, r10, r5)
            r9.f140395g = r0
            r9.f140390a = r10
            r9.f140391b = r4
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r9.f140392c = r2
            r9.f140393d = r7
            r9.f140394f = r3
            java.lang.Object r2 = r0.a(r10, r9)
            if (r2 != r1) goto L79
        L78:
            return r1
        L79:
            r2 = r7
            goto L47
        L7b:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
