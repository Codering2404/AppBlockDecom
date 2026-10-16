package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", l = {2480, 2483}, m = "invokeSuspend", v = 2)
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f140401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f140402d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Sequence f140403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function2 f140404g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduce$1(Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f140403f = sequence;
        this.f140404g = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.f140403f, this.f140404g, continuation);
        sequencesKt___SequencesKt$runningReduce$1.f140402d = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object next;
        Iterator it;
        SequenceScope sequenceScope = (SequenceScope) this.f140402d;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f140401c;
        if (i3 == 0) {
            ResultKt.b(obj);
            Iterator it2 = this.f140403f.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.f140402d = sequenceScope;
                this.f140399a = it2;
                this.f140400b = next;
                this.f140401c = 1;
                if (sequenceScope.a(next, this) != objF) {
                    it = it2;
                }
                return objF;
            }
            return Unit.f139807a;
        }
        if (i3 != 1 && i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        next = this.f140400b;
        it = (Iterator) this.f140399a;
        ResultKt.b(obj);
        while (it.hasNext()) {
            next = this.f140404g.invoke(next, it.next());
            this.f140402d = sequenceScope;
            this.f140399a = it;
            this.f140400b = next;
            this.f140401c = 2;
            if (sequenceScope.a(next, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
