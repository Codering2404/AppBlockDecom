package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface BringIntoViewSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f5546a = Companion.f5547a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f5547a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final AnimationSpec f5548b = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final BringIntoViewSpec f5549c = new BringIntoViewSpec() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1
        };

        private Companion() {
        }

        public final float a(float f3, float f4, float f5) {
            float f6 = f4 + f3;
            if (f3 >= 0.0f && f6 <= f5) {
                return 0.0f;
            }
            if (f3 < 0.0f && f6 > f5) {
                return 0.0f;
            }
            float f7 = f6 - f5;
            return Math.abs(f3) < Math.abs(f7) ? f3 : f7;
        }

        public final BringIntoViewSpec b() {
            return f5549c;
        }

        public final AnimationSpec c() {
            return f5548b;
        }
    }

    default float a(float f3, float f4, float f5) {
        return f5546a.a(f3, f4, f5);
    }
}
