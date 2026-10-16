package androidx.compose.animation.graphics.res;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.vector.VectorConfig;
import androidx.compose.ui.graphics.vector.VectorGroup;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ComposableSingletons$AnimatedVectorPainterResources_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$AnimatedVectorPainterResources_androidKt f4386a = new ComposableSingletons$AnimatedVectorPainterResources_androidKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function4 f4387b = ComposableLambdaKt.c(-869223072, false, new Function4<VectorGroup, Map<String, ? extends VectorConfig>, Composer, Integer, Unit>() { // from class: androidx.compose.animation.graphics.res.ComposableSingletons$AnimatedVectorPainterResources_androidKt$lambda-1$1
        public final void c(VectorGroup vectorGroup, Map map, Composer composer, int i3) {
            if (ComposerKt.M()) {
                ComposerKt.U(-869223072, i3, -1, "androidx.compose.animation.graphics.res.ComposableSingletons$AnimatedVectorPainterResources_androidKt.lambda-1.<anonymous> (AnimatedVectorPainterResources.android.kt:46)");
            }
            VectorPainterKt.a(vectorGroup, map, composer, i3 & 126, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            c((VectorGroup) obj, (Map) obj2, (Composer) obj3, ((Number) obj4).intValue());
            return Unit.f139807a;
        }
    });

    public final Function4 a() {
        return f4387b;
    }
}
