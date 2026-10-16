package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
public final class MainDispatcherLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MainDispatcherLoader f142469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MainCoroutineDispatcher f142470b;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        f142469a = mainDispatcherLoader;
        SystemPropsKt.f("kotlinx.coroutines.fast.service.loader", true);
        f142470b = mainDispatcherLoader.a();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher a() {
        Object next;
        MainCoroutineDispatcher mainCoroutineDispatcherE;
        try {
            List listS = SequencesKt.S(SequencesKt.e(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            Iterator it = listS.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((MainDispatcherFactory) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((MainDispatcherFactory) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            if (mainDispatcherFactory != null && (mainCoroutineDispatcherE = MainDispatchersKt.e(mainDispatcherFactory, listS)) != null) {
                return mainCoroutineDispatcherE;
            }
            return MainDispatchersKt.b(null, null, 3, null);
        } catch (Throwable th) {
            return MainDispatchersKt.b(th, null, 2, null);
        }
    }
}
