package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
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
final class ThreadState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f142499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f142500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadContextElement[] f142501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f142502d;

    public ThreadState(CoroutineContext coroutineContext, int i3) {
        this.f142499a = coroutineContext;
        this.f142500b = new Object[i3];
        this.f142501c = new ThreadContextElement[i3];
    }

    public final void a(ThreadContextElement threadContextElement, Object obj) {
        Object[] objArr = this.f142500b;
        int i3 = this.f142502d;
        objArr[i3] = obj;
        ThreadContextElement[] threadContextElementArr = this.f142501c;
        this.f142502d = i3 + 1;
        Intrinsics.checkNotNull(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        threadContextElementArr[i3] = threadContextElement;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f142501c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i3 = length - 1;
            ThreadContextElement threadContextElement = this.f142501c[length];
            Intrinsics.checkNotNull(threadContextElement);
            threadContextElement.F(coroutineContext, this.f142500b[length]);
            if (i3 < 0) {
                return;
            } else {
                length = i3;
            }
        }
    }
}
