package kotlin.sequences;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;

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
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", l = {178}, m = "invokeSuspend", v = 2)
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f140360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f140361d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f140362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private /* synthetic */ Object f140363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Sequence f140364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Random f140365i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$shuffled$1(Sequence sequence, Random random, Continuation continuation) {
        super(2, continuation);
        this.f140364h = sequence;
        this.f140365i = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.f140364h, this.f140365i, continuation);
        sequencesKt__SequencesKt$shuffled$1.f140363g = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List listT;
        SequenceScope sequenceScope = (SequenceScope) this.f140363g;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f140362f;
        if (i3 == 0) {
            ResultKt.b(obj);
            listT = SequencesKt___SequencesKt.T(this.f140364h);
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            listT = (List) this.f140358a;
            ResultKt.b(obj);
        }
        while (!listT.isEmpty()) {
            int iJ = this.f140365i.j(listT.size());
            Object objRemoveLast = CollectionsKt.removeLast(listT);
            Object obj2 = iJ < listT.size() ? listT.set(iJ, objRemoveLast) : objRemoveLast;
            this.f140363g = sequenceScope;
            this.f140358a = listT;
            this.f140359b = SpillingKt.a(objRemoveLast);
            this.f140360c = SpillingKt.a(obj2);
            this.f140361d = iJ;
            this.f140362f = 1;
            if (sequenceScope.a(obj2, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
