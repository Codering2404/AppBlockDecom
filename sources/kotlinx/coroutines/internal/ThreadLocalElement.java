package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

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
public final class ThreadLocalElement<T> implements ThreadContextElement<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f142493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadLocal f142494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineContext.Key f142495c;

    public ThreadLocalElement(Object obj, ThreadLocal threadLocal) {
        this.f142493a = obj;
        this.f142494b = threadLocal;
        this.f142495c = new ThreadLocalKey(threadLocal);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void F(CoroutineContext coroutineContext, Object obj) {
        this.f142494b.set(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.ThreadContextElement
    public Object V(CoroutineContext coroutineContext) {
        Object obj = this.f142494b.get();
        this.f142494b.set(this.f142493a);
        return obj;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return ThreadContextElement.DefaultImpls.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        if (!Intrinsics.areEqual(getKey(), key)) {
            return null;
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return this.f142495c;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return Intrinsics.areEqual(getKey(), key) ? EmptyCoroutineContext.f139889a : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return ThreadContextElement.DefaultImpls.b(this, coroutineContext);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f142493a + ", threadLocal = " + this.f142494b + ')';
    }
}
