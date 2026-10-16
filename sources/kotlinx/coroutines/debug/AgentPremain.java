package kotlinx.coroutines.debug;

import java.lang.instrument.ClassFileTransformer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

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
public final class AgentPremain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AgentPremain f141387a = new AgentPremain();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f141388b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DebugProbesTransformer implements ClassFileTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DebugProbesTransformer f141389a = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }
    }

    static {
        Object objB;
        try {
            Result.Companion companion = Result.f139772b;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            objB = Result.b(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        Boolean bool = (Boolean) (Result.g(objB) ? null : objB);
        f141388b = bool != null ? bool.booleanValue() : DebugProbesImpl.f141434a.d();
    }

    private AgentPremain() {
    }
}
