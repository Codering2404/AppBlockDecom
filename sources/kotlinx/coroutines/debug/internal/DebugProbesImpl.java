package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class DebugProbesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DebugProbesImpl f141434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final StackTraceElement f141435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f141436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentWeakMap f141437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f141438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f141439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f141440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Function1 f141441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ConcurrentWeakMap f141442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private f141443j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Continuation f141444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DebugCoroutineInfoImpl f141445b;

        private final StackTraceFrame a() {
            return this.f141445b.d();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame stackTraceFrameA = a();
            if (stackTraceFrameA != null) {
                return stackTraceFrameA.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f141444a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            StackTraceFrame stackTraceFrameA = a();
            if (stackTraceFrameA != null) {
                return stackTraceFrameA.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            DebugProbesImpl.f141434a.f(this);
            this.f141444a.resumeWith(obj);
        }

        public String toString() {
            return this.f141444a.toString();
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f141434a = debugProbesImpl;
        f141435b = new ArtificialStackFrames().b();
        f141436c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f141437d = new ConcurrentWeakMap(false, 1, null);
        f141438e = true;
        f141440g = true;
        f141441h = debugProbesImpl.c();
        f141442i = new ConcurrentWeakMap(true);
        f141443j = new DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private(null);
    }

    private DebugProbesImpl() {
    }

    private final Function1 c() {
        Object objB;
        try {
            Result.Companion companion = Result.f139772b;
            Object objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            objB = Result.b((Function1) TypeIntrinsics.f(objNewInstance, 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        return (Function1) (Result.g(objB) ? null : objB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(CoroutineOwner coroutineOwner) {
        Job job;
        CoroutineContext coroutineContextC = coroutineOwner.f141445b.c();
        if (coroutineContextC == null || (job = (Job) coroutineContextC.get(Job.v8)) == null || !job.isCompleted()) {
            return false;
        }
        f141437d.remove(coroutineOwner);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(CoroutineOwner coroutineOwner) {
        CoroutineStackFrame coroutineStackFrameG;
        f141437d.remove(coroutineOwner);
        CoroutineStackFrame coroutineStackFrameF = coroutineOwner.f141445b.f();
        if (coroutineStackFrameF == null || (coroutineStackFrameG = g(coroutineStackFrameF)) == null) {
            return;
        }
        f141442i.remove(coroutineStackFrameG);
    }

    private final CoroutineStackFrame g(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    public final boolean d() {
        return f141439f;
    }
}
