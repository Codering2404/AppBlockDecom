package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

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
public final class Dispatchers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Dispatchers f140935a = new Dispatchers();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CoroutineDispatcher f140936b = DefaultScheduler.f142542i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CoroutineDispatcher f140937c = Unconfined.f141023b;

    private Dispatchers() {
    }

    public static final CoroutineDispatcher a() {
        return f140936b;
    }

    public static final CoroutineDispatcher b() {
        return DefaultIoScheduler.f142540c;
    }

    public static final MainCoroutineDispatcher c() {
        return MainDispatcherLoader.f142470b;
    }
}
