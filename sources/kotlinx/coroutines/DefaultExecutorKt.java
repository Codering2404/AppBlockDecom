package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

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
public final class DefaultExecutorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f140928a = SystemPropsKt.f("kotlinx.coroutines.main.delay", false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Delay f140929b = b();

    public static final Delay a() {
        return f140929b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Delay b() {
        if (!f140928a) {
            return DefaultExecutor.f140926i;
        }
        MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
        return (MainDispatchersKt.c(mainCoroutineDispatcherC) || !(mainCoroutineDispatcherC instanceof Delay)) ? DefaultExecutor.f140926i : (Delay) mainCoroutineDispatcherC;
    }
}
