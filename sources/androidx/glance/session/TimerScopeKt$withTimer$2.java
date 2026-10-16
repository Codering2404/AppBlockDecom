package androidx.glance.session;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.session.TimerScopeKt$withTimer$2", f = "TimerScope.kt", l = {86}, m = "invokeSuspend")
final class TimerScopeKt$withTimer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f39676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f39677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TimeSource f39678d;

    /* JADX INFO: renamed from: androidx.glance.session.TimerScopeKt$withTimer$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.session.TimerScopeKt$withTimer$2$1", f = "TimerScope.kt", l = {127}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f39680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f39681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TimeSource f39682d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f39683f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AtomicReference f39684g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function2 function2, TimeSource timeSource, CoroutineScope coroutineScope, AtomicReference atomicReference, Continuation continuation) {
            super(2, continuation);
            this.f39681c = function2;
            this.f39682d = timeSource;
            this.f39683f = coroutineScope;
            this.f39684g = atomicReference;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f39681c, this.f39682d, this.f39683f, this.f39684g, continuation);
            anonymousClass1.f39680b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f39679a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            TimerScopeKt$withTimer$2$1$blockScope$1 timerScopeKt$withTimer$2$1$blockScope$1 = new TimerScopeKt$withTimer$2$1$blockScope$1((CoroutineScope) this.f39680b, this.f39682d, this.f39683f, this.f39681c, this.f39684g);
            Function2 function2 = this.f39681c;
            this.f39679a = 1;
            Object objInvoke = function2.invoke(timerScopeKt$withTimer$2$1$blockScope$1, this);
            return objInvoke == objF ? objF : objInvoke;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimerScopeKt$withTimer$2(Function2 function2, TimeSource timeSource, Continuation continuation) {
        super(2, continuation);
        this.f39677c = function2;
        this.f39678d = timeSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TimerScopeKt$withTimer$2 timerScopeKt$withTimer$2 = new TimerScopeKt$withTimer$2(this.f39677c, this.f39678d, continuation);
        timerScopeKt$withTimer$2.f39676b = obj;
        return timerScopeKt$withTimer$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AtomicReference atomicReference;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39675a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f39676b;
            AtomicReference atomicReference2 = new AtomicReference(null);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f39677c, this.f39678d, coroutineScope, atomicReference2, null);
            this.f39676b = atomicReference2;
            this.f39675a = 1;
            obj = CoroutineScopeKt.f(anonymousClass1, this);
            if (obj == objF) {
                return objF;
            }
            atomicReference = atomicReference2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            atomicReference = (AtomicReference) this.f39676b;
            ResultKt.b(obj);
        }
        Job job = (Job) atomicReference.get();
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TimerScopeKt$withTimer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
