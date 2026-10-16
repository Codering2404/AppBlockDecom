package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

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
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Key f140909a = new Key(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineDispatcher d(CoroutineContext.Element element) {
            if (element instanceof CoroutineDispatcher) {
                return (CoroutineDispatcher) element;
            }
            return null;
        }

        private Key() {
            super(ContinuationInterceptor.t8, new Function1() { // from class: kotlinx.coroutines.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CoroutineDispatcher.Key.d((CoroutineContext.Element) obj);
                }
            });
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.t8);
    }

    public static /* synthetic */ CoroutineDispatcher q0(CoroutineDispatcher coroutineDispatcher, int i3, String str, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i4 & 2) != 0) {
            str = null;
        }
        return coroutineDispatcher.j0(i3, str);
    }

    public abstract void M(CoroutineContext coroutineContext, Runnable runnable);

    public void O(CoroutineContext coroutineContext, Runnable runnable) {
        M(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void c(Continuation continuation) {
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation) continuation).q();
    }

    public boolean e0(CoroutineContext coroutineContext) {
        return true;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final Continuation f(Continuation continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public /* synthetic */ CoroutineDispatcher g0(int i3) {
        return j0(i3, null);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return ContinuationInterceptor.DefaultImpls.a(this, key);
    }

    public CoroutineDispatcher j0(int i3, String str) {
        LimitedDispatcherKt.a(i3);
        return new LimitedDispatcher(this, i3, str);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return ContinuationInterceptor.DefaultImpls.b(this, key);
    }

    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
