package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", l = {2979}, m = "invokeSuspend", v = 2)
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f140417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f140418d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f140419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Sequence f140420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function2 f140421h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f140420g = sequence;
        this.f140421h = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.f140420g, this.f140421h, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.f140419f = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object next;
        Iterator it;
        SequenceScope sequenceScope = (SequenceScope) this.f140419f;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f140418d;
        if (i3 == 0) {
            ResultKt.b(obj);
            Iterator it2 = this.f140420g.iterator();
            if (!it2.hasNext()) {
                return Unit.f139807a;
            }
            next = it2.next();
            it = it2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            next = this.f140417c;
            it = (Iterator) this.f140415a;
            ResultKt.b(obj);
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            Object objInvoke = this.f140421h.invoke(next, next2);
            this.f140419f = sequenceScope;
            this.f140415a = it;
            this.f140416b = SpillingKt.a(next);
            this.f140417c = next2;
            this.f140418d = 1;
            if (sequenceScope.a(objInvoke, this) == objF) {
                return objF;
            }
            next = next2;
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
