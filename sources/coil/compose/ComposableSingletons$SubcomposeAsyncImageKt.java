package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ComposableSingletons$SubcomposeAsyncImageKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$SubcomposeAsyncImageKt f55548a = new ComposableSingletons$SubcomposeAsyncImageKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function3 f55549b = ComposableLambdaKt.c(-1692951203, false, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.ComposableSingletons$SubcomposeAsyncImageKt$lambda-1$1
        public final void c(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i3) {
            int i4;
            if ((i3 & 14) == 0) {
                i4 = (composer.Z(subcomposeAsyncImageScope) ? 4 : 2) | i3;
            } else {
                i4 = i3;
            }
            if ((i4 & 91) == 18 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1692951203, i4, -1, "coil.compose.ComposableSingletons$SubcomposeAsyncImageKt.lambda-1.<anonymous> (SubcomposeAsyncImage.kt:238)");
            }
            SubcomposeAsyncImageKt.c(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, composer, i4 & 14, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            c((SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }
    });

    public final Function3 a() {
        return f55549b;
    }
}
