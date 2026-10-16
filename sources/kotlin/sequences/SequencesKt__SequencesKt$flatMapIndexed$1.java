package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", l = {383}, m = "invokeSuspend", v = 2)
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f140343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f140344d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f140345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private /* synthetic */ Object f140346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Sequence f140347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function2 f140348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function1 f140349j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$flatMapIndexed$1(Sequence sequence, Function2 function2, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f140347h = sequence;
        this.f140348i = function2;
        this.f140349j = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.f140347h, this.f140348i, this.f140349j, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.f140346g = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i3;
        Iterator it;
        SequenceScope sequenceScope = (SequenceScope) this.f140346g;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f140345f;
        if (i4 == 0) {
            ResultKt.b(obj);
            i3 = 0;
            it = this.f140347h.iterator();
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = this.f140344d;
            it = (Iterator) this.f140341a;
            ResultKt.b(obj);
        }
        while (it.hasNext()) {
            Object next = it.next();
            Function2 function2 = this.f140348i;
            int i5 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object objInvoke = function2.invoke(Boxing.d(i3), next);
            Iterator it2 = (Iterator) this.f140349j.invoke(objInvoke);
            this.f140346g = sequenceScope;
            this.f140341a = it;
            this.f140342b = SpillingKt.a(next);
            this.f140343c = SpillingKt.a(objInvoke);
            this.f140344d = i5;
            this.f140345f = 1;
            if (sequenceScope.b(it2, this) == objF) {
                return objF;
            }
            i3 = i5;
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
