package androidx.collection;

import androidx.collection.MutableOrderedSetWrapper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [E] */
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.collection.MutableOrderedSetWrapper$iterator$1$iterator$1", f = "OrderedScatterSet.kt", l = {1489}, m = "invokeSuspend")
final class MutableOrderedSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f3030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f3031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f3032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f3033d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private /* synthetic */ Object f3035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableOrderedSetWrapper f3036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableOrderedSetWrapper.AnonymousClass1 f3037i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MutableOrderedSetWrapper$iterator$1$iterator$1(MutableOrderedSetWrapper mutableOrderedSetWrapper, MutableOrderedSetWrapper.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(2, continuation);
        this.f3036h = mutableOrderedSetWrapper;
        this.f3037i = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MutableOrderedSetWrapper$iterator$1$iterator$1 mutableOrderedSetWrapper$iterator$1$iterator$1 = new MutableOrderedSetWrapper$iterator$1$iterator$1(this.f3036h, this.f3037i, continuation);
        mutableOrderedSetWrapper$iterator$1$iterator$1.f3035g = obj;
        return mutableOrderedSetWrapper$iterator$1$iterator$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MutableOrderedSetWrapper mutableOrderedSetWrapper;
        int i3;
        MutableOrderedSetWrapper.AnonymousClass1 anonymousClass1;
        long[] jArr;
        SequenceScope sequenceScope;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f3034f;
        if (i4 == 0) {
            ResultKt.b(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.f3035g;
            MutableOrderedScatterSet mutableOrderedScatterSet = this.f3036h.f3026b;
            MutableOrderedSetWrapper.AnonymousClass1 anonymousClass12 = this.f3037i;
            mutableOrderedSetWrapper = this.f3036h;
            long[] jArr2 = mutableOrderedScatterSet.f3094c;
            i3 = mutableOrderedScatterSet.f3096e;
            anonymousClass1 = anonymousClass12;
            jArr = jArr2;
            sequenceScope = sequenceScope2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = this.f3033d;
            jArr = (long[]) this.f3032c;
            mutableOrderedSetWrapper = (MutableOrderedSetWrapper) this.f3031b;
            anonymousClass1 = (MutableOrderedSetWrapper.AnonymousClass1) this.f3030a;
            sequenceScope = (SequenceScope) this.f3035g;
            ResultKt.b(obj);
        }
        while (i3 != Integer.MAX_VALUE) {
            int i5 = (int) ((jArr[i3] >> 31) & 2147483647L);
            anonymousClass1.a(i3);
            Object obj2 = mutableOrderedSetWrapper.f3026b.f3093b[i3];
            this.f3035g = sequenceScope;
            this.f3030a = anonymousClass1;
            this.f3031b = mutableOrderedSetWrapper;
            this.f3032c = jArr;
            this.f3033d = i5;
            this.f3034f = 1;
            if (sequenceScope.a(obj2, this) == objF) {
                return objF;
            }
            i3 = i5;
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((MutableOrderedSetWrapper$iterator$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
