package kotlinx.coroutines.sync;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

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
public interface Mutex {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ boolean b(Mutex mutex, Object obj, int i3, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i3 & 1) != 0) {
                obj = null;
            }
            return mutex.b(obj);
        }

        public static /* synthetic */ void c(Mutex mutex, Object obj, int i3, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i3 & 1) != 0) {
                obj = null;
            }
            mutex.i(obj);
        }

        public static /* synthetic */ Object a(Mutex mutex, Object obj, Continuation continuation, int i3, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException(KLAQHFCRAUejH.TKshyNyJFUZH);
            }
            if ((i3 & 1) != 0) {
                obj = null;
            }
            return mutex.f(obj, continuation);
        }
    }

    boolean b(Object obj);

    boolean c();

    Object f(Object obj, Continuation continuation);

    void i(Object obj);
}
