package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
public final class CoroutineContextKt {
    private static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z2) {
        boolean zH = h(coroutineContext);
        boolean zH2 = h(coroutineContext2);
        if (!zH && !zH2) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f139889a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new Function2() { // from class: kotlinx.coroutines.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CoroutineContextKt.e(objectRef, z2, (CoroutineContext) obj, (CoroutineContext.Element) obj2);
            }
        });
        if (zH2) {
            objectRef.f140144a = ((CoroutineContext) objectRef.f140144a).fold(emptyCoroutineContext, new Function2() { // from class: kotlinx.coroutines.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoroutineContextKt.f((CoroutineContext) obj, (CoroutineContext.Element) obj2);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.f140144a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext e(Ref.ObjectRef objectRef, boolean z2, CoroutineContext coroutineContext, CoroutineContext.Element element) {
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.plus(element);
        }
        CoroutineContext.Element element2 = ((CoroutineContext) objectRef.f140144a).get(element.getKey());
        if (element2 == null) {
            return coroutineContext.plus(z2 ? ((CopyableThreadContextElement) element).C() : (CopyableThreadContextElement) element);
        }
        objectRef.f140144a = ((CoroutineContext) objectRef.f140144a).minusKey(element.getKey());
        return coroutineContext.plus(((CopyableThreadContextElement) element).j(element2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext f(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        return element instanceof CopyableThreadContextElement ? coroutineContext.plus(((CopyableThreadContextElement) element).C()) : coroutineContext.plus(element);
    }

    public static final String g(CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean h(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, new Function2() { // from class: kotlinx.coroutines.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(CoroutineContextKt.i(((Boolean) obj).booleanValue(), (CoroutineContext.Element) obj2));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(boolean z2, CoroutineContext.Element element) {
        return z2 || (element instanceof CopyableThreadContextElement);
    }

    public static final CoroutineContext j(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        return !h(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : d(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext k(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextD = d(coroutineScope.getCoroutineContext(), coroutineContext, true);
        return (coroutineContextD == Dispatchers.a() || coroutineContextD.get(ContinuationInterceptor.t8) != null) ? coroutineContextD : coroutineContextD.plus(Dispatchers.a());
    }

    public static final UndispatchedCoroutine l(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final UndispatchedCoroutine m(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        if (!(continuation instanceof CoroutineStackFrame) || coroutineContext.get(UndispatchedMarker.f141025a) == null) {
            return null;
        }
        UndispatchedCoroutine undispatchedCoroutineL = l((CoroutineStackFrame) continuation);
        if (undispatchedCoroutineL != null) {
            undispatchedCoroutineL.g1(coroutineContext, obj);
        }
        return undispatchedCoroutineL;
    }
}
