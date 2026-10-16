package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadLocalKt;

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
public final class ThreadLocalEventLoop {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocalEventLoop f141011a = new ThreadLocalEventLoop();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f141012b = ThreadLocalKt.a(new Symbol("ThreadLocalEventLoop"));

    private ThreadLocalEventLoop() {
    }

    public final EventLoop a() {
        return (EventLoop) f141012b.get();
    }

    public final EventLoop b() {
        ThreadLocal threadLocal = f141012b;
        EventLoop eventLoop = (EventLoop) threadLocal.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        EventLoop eventLoopA = EventLoopKt.a();
        threadLocal.set(eventLoopA);
        return eventLoopA;
    }

    public final void c() {
        f141012b.set(null);
    }

    public final void d(EventLoop eventLoop) {
        f141012b.set(eventLoop);
    }
}
