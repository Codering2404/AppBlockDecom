package androidx.glance.session;

import android.content.Context;
import androidx.work.ListenableWorker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.session.SessionWorker$doWork$2", f = "SessionWorker.kt", l = {88}, m = "invokeSuspend")
final class SessionWorker$doWork$2 extends SuspendLambda implements Function2<TimerScope, Continuation<? super ListenableWorker.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f39615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionWorker f39616c;

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.session.SessionWorker$doWork$2$1", f = "SessionWorker.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TimerScope f39618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SessionWorker f39619c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TimerScope timerScope, SessionWorker sessionWorker, Continuation continuation) {
            super(1, continuation);
            this.f39618b = timerScope;
            this.f39619c = sessionWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f39618b, this.f39619c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f39617a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f39618b.r(this.f39619c.f39608g.b());
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$doWork$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.session.SessionWorker$doWork$2$2", f = "SessionWorker.kt", l = {95}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super ListenableWorker.Result>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SessionWorker f39621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimerScope f39622c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SessionWorker sessionWorker, TimerScope timerScope, Continuation continuation) {
            super(1, continuation);
            this.f39621b = sessionWorker;
            this.f39622c = timerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(this.f39621b, this.f39622c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f39620a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            SessionWorker sessionWorker = this.f39621b;
            TimerScope timerScope = this.f39622c;
            this.f39620a = 1;
            Object objK = sessionWorker.k(timerScope, this);
            return objK == objF ? objF : objK;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SessionWorker$doWork$2(SessionWorker sessionWorker, Continuation continuation) {
        super(2, continuation);
        this.f39616c = sessionWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SessionWorker$doWork$2 sessionWorker$doWork$2 = new SessionWorker$doWork$2(this.f39616c, continuation);
        sessionWorker$doWork$2.f39615b = obj;
        return sessionWorker$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TimerScope timerScope, Continuation continuation) {
        return ((SessionWorker$doWork$2) create(timerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39614a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        TimerScope timerScope = (TimerScope) this.f39615b;
        Context applicationContext = this.f39616c.getApplicationContext();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(timerScope, this.f39616c, null);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f39616c, timerScope, null);
        this.f39614a = 1;
        Object objA = IdleEventBroadcastReceiverKt.a(applicationContext, anonymousClass1, anonymousClass2, this);
        return objA == objF ? objF : objA;
    }
}
