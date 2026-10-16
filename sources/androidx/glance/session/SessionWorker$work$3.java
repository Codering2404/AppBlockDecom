package androidx.glance.session;

import androidx.compose.runtime.Recomposer;
import androidx.glance.EmittableWithChildren;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

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
@DebugMetadata(c = "androidx.glance.session.SessionWorker$work$3", f = "SessionWorker.kt", l = {126}, m = "invokeSuspend")
final class SessionWorker$work$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f39636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Recomposer f39637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Session f39638d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableStateFlow f39639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ SessionWorker f39640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ EmittableWithChildren f39641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ TimerScope f39642i;

    /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$work$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1 implements FlowCollector<Recomposer.State> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Session f39643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Recomposer f39644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f39645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MutableStateFlow f39646d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ SessionWorker f39647f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EmittableWithChildren f39648g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ TimerScope f39649h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f39650i;

        /* JADX INFO: renamed from: androidx.glance.session.SessionWorker$work$3$1$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f39651a;

            static {
                int[] iArr = new int[Recomposer.State.values().length];
                try {
                    iArr[Recomposer.State.f24068f.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Recomposer.State.f24064a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f39651a = iArr;
            }
        }

        AnonymousClass1(Session session, Recomposer recomposer, Ref.LongRef longRef, MutableStateFlow mutableStateFlow, SessionWorker sessionWorker, EmittableWithChildren emittableWithChildren, TimerScope timerScope, CoroutineScope coroutineScope) {
            this.f39643a = session;
            this.f39644b = recomposer;
            this.f39645c = longRef;
            this.f39646d = mutableStateFlow;
            this.f39647f = sessionWorker;
            this.f39648g = emittableWithChildren;
            this.f39649h = timerScope;
            this.f39650i = coroutineScope;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00be, code lost:
        
            if (r9.emit(r2, r0) == r1) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(androidx.compose.runtime.Recomposer.State r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 221
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.SessionWorker$work$3.AnonymousClass1.emit(androidx.compose.runtime.Recomposer$State, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SessionWorker$work$3(Recomposer recomposer, Session session, MutableStateFlow mutableStateFlow, SessionWorker sessionWorker, EmittableWithChildren emittableWithChildren, TimerScope timerScope, Continuation continuation) {
        super(2, continuation);
        this.f39637c = recomposer;
        this.f39638d = session;
        this.f39639f = mutableStateFlow;
        this.f39640g = sessionWorker;
        this.f39641h = emittableWithChildren;
        this.f39642i = timerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SessionWorker$work$3 sessionWorker$work$3 = new SessionWorker$work$3(this.f39637c, this.f39638d, this.f39639f, this.f39640g, this.f39641h, this.f39642i, continuation);
        sessionWorker$work$3.f39636b = obj;
        return sessionWorker$work$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39635a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f39636b;
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.f140143a = this.f39637c.o0();
            StateFlow stateFlowP0 = this.f39637c.p0();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f39638d, this.f39637c, longRef, this.f39639f, this.f39640g, this.f39641h, this.f39642i, coroutineScope);
            this.f39635a = 1;
            if (stateFlowP0.collect(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SessionWorker$work$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
