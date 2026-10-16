package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineContext f140869c;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z2, boolean z3) {
        super(z3);
        if (z2) {
            v0((Job) coroutineContext.get(Job.v8));
        }
        this.f140869c = coroutineContext.plus(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public String D0() {
        String strG = CoroutineContextKt.g(this.f140869c);
        if (strG == null) {
            return super.D0();
        }
        return '\"' + strG + "\":" + super.D0();
    }

    @Override // kotlinx.coroutines.JobSupport
    protected final void K0(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            d1(obj);
        } else {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            c1(completedExceptionally.f140908a, completedExceptionally.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public String b0() {
        return DebugStringsKt.a(this) + " was cancelled";
    }

    protected void b1(Object obj) {
        S(obj);
    }

    public final void e1(CoroutineStart coroutineStart, Object obj, Function2 function2) {
        coroutineStart.b(function2, obj, this);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f140869c;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f140869c;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object objC0 = C0(CompletionStateKt.b(obj));
        if (objC0 == JobSupportKt.f140995b) {
            return;
        }
        b1(objC0);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void u0(Throwable th) {
        CoroutineExceptionHandlerKt.a(this.f140869c, th);
    }

    protected void d1(Object obj) {
    }

    protected void c1(Throwable th, boolean z2) {
    }
}
