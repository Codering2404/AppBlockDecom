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
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", l = {2509, 2513}, m = "invokeSuspend", v = 2)
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f140407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f140408d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f140409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Sequence f140410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function3 f140411h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduceIndexed$1(Sequence sequence, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f140410g = sequence;
        this.f140411h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.f140410g, this.f140411h, continuation);
        sequencesKt___SequencesKt$runningReduceIndexed$1.f140409f = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Iterator it;
        Object next;
        SequenceScope sequenceScope = (SequenceScope) this.f140409f;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f140408d;
        int i4 = 1;
        if (i3 == 0) {
            ResultKt.b(obj);
            it = this.f140410g.iterator();
            if (it.hasNext()) {
                next = it.next();
                this.f140409f = sequenceScope;
                this.f140405a = it;
                this.f140406b = next;
                this.f140408d = 1;
                if (sequenceScope.a(next, this) != objF) {
                }
                return objF;
            }
            return Unit.f139807a;
        }
        if (i3 == 1) {
            next = this.f140406b;
            it = (Iterator) this.f140405a;
            ResultKt.b(obj);
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i5 = this.f140407c;
            Object obj2 = this.f140406b;
            it = (Iterator) this.f140405a;
            ResultKt.b(obj);
            i4 = i5;
            next = obj2;
        }
        while (it.hasNext()) {
            Function3 function3 = this.f140411h;
            int i6 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object objInvoke = function3.invoke(Boxing.d(i4), next, it.next());
            this.f140409f = sequenceScope;
            this.f140405a = it;
            this.f140406b = objInvoke;
            this.f140407c = i6;
            this.f140408d = 2;
            if (sequenceScope.a(objInvoke, this) == objF) {
                return objF;
            }
            next = objInvoke;
            i4 = i6;
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
