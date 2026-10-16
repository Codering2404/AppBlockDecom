package androidx.compose.ui;

import androidx.compose.animation.core.h;
import androidx.compose.ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

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
@DebugMetadata(c = "androidx.compose.ui.SessionMutex$withSessionCancellingPrevious$2", f = "SessionMutex.kt", l = {61, 63}, m = "invokeSuspend")
final class SessionMutex$withSessionCancellingPrevious$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f25181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f25182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f25183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AtomicReference f25184d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f25185f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SessionMutex$withSessionCancellingPrevious$2(Function1 function1, AtomicReference atomicReference, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f25183c = function1;
        this.f25184d = atomicReference;
        this.f25185f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SessionMutex$withSessionCancellingPrevious$2 sessionMutex$withSessionCancellingPrevious$2 = new SessionMutex$withSessionCancellingPrevious$2(this.f25183c, this.f25184d, this.f25185f, continuation);
        sessionMutex$withSessionCancellingPrevious$2.f25182b = obj;
        return sessionMutex$withSessionCancellingPrevious$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SessionMutex.Session session;
        Job jobA;
        SessionMutex.Session session2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f25181a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f25182b;
                session = new SessionMutex.Session(JobKt.m(coroutineScope.getCoroutineContext()), this.f25183c.invoke(coroutineScope));
                SessionMutex.Session session3 = (SessionMutex.Session) this.f25184d.getAndSet(session);
                if (session3 != null && (jobA = session3.a()) != null) {
                    this.f25182b = session;
                    this.f25181a = 1;
                    if (JobKt.g(jobA, this) != objF) {
                    }
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    session2 = (SessionMutex.Session) this.f25182b;
                    try {
                        ResultKt.b(obj);
                        h.a(this.f25184d, session2, null);
                        return obj;
                    } catch (Throwable th) {
                        th = th;
                        h.a(this.f25184d, session2, null);
                        throw th;
                    }
                }
                session = (SessionMutex.Session) this.f25182b;
                ResultKt.b(obj);
            }
            Function2 function2 = this.f25185f;
            Object objB = session.b();
            this.f25182b = session;
            this.f25181a = 2;
            obj = function2.invoke(objB, this);
            if (obj != objF) {
                session2 = session;
                h.a(this.f25184d, session2, null);
                return obj;
            }
            return objF;
        } catch (Throwable th2) {
            th = th2;
            session2 = session;
            h.a(this.f25184d, session2, null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SessionMutex$withSessionCancellingPrevious$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
