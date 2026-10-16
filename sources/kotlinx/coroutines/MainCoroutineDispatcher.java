package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

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
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher j0(int i3, String str) {
        LimitedDispatcherKt.a(i3);
        return LimitedDispatcherKt.b(this, str);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strZ0 = z0();
        if (strZ0 != null) {
            return strZ0;
        }
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }

    public abstract MainCoroutineDispatcher w0();

    protected final String z0() {
        MainCoroutineDispatcher mainCoroutineDispatcherW0;
        MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
        if (this == mainCoroutineDispatcherC) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcherW0 = mainCoroutineDispatcherC.w0();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcherW0 = null;
        }
        if (this == mainCoroutineDispatcherW0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
