package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

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
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ThreadLocal f141024f;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public UndispatchedCoroutine(CoroutineContext coroutineContext, Continuation continuation) {
        UndispatchedMarker undispatchedMarker = UndispatchedMarker.f141025a;
        super(coroutineContext.get(undispatchedMarker) == null ? coroutineContext.plus(undispatchedMarker) : coroutineContext, continuation);
        this.f141024f = new ThreadLocal();
        if (continuation.getContext().get(ContinuationInterceptor.t8) instanceof CoroutineDispatcher) {
            return;
        }
        Object objI = ThreadContextKt.i(coroutineContext, null);
        ThreadContextKt.f(coroutineContext, objI);
        g1(coroutineContext, objI);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void b1(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.f141024f.get();
            if (pair != null) {
                ThreadContextKt.f((CoroutineContext) pair.a(), pair.b());
            }
            this.f141024f.remove();
        }
        Object objA = CompletionStateKt.a(obj, this.f142480d);
        Continuation continuation = this.f142480d;
        CoroutineContext context = continuation.getContext();
        Object objI = ThreadContextKt.i(context, null);
        UndispatchedCoroutine undispatchedCoroutineM = objI != ThreadContextKt.f142489a ? CoroutineContextKt.m(continuation, context, objI) : null;
        try {
            this.f142480d.resumeWith(objA);
            Unit unit = Unit.f139807a;
            if (undispatchedCoroutineM == null || undispatchedCoroutineM.f1()) {
                ThreadContextKt.f(context, objI);
            }
        } catch (Throwable th) {
            if (undispatchedCoroutineM == null || undispatchedCoroutineM.f1()) {
                ThreadContextKt.f(context, objI);
            }
            throw th;
        }
    }

    public final boolean f1() {
        boolean z2 = this.threadLocalIsSet && this.f141024f.get() == null;
        this.f141024f.remove();
        return !z2;
    }

    public final void g1(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f141024f.set(TuplesKt.a(coroutineContext, obj));
    }
}
