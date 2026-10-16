package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$CompositionKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$CompositionKt f23733a = new ComposableSingletons$CompositionKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f23734b = ComposableLambdaKt.c(954879418, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.ComposableSingletons$CompositionKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(954879418, i3, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda-1.<anonymous> (Composition.kt:600)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f23735c = ComposableLambdaKt.c(1918065384, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.ComposableSingletons$CompositionKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1918065384, i3, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda-2.<anonymous> (Composition.kt:815)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    public final Function2 a() {
        return f23734b;
    }

    public final Function2 b() {
        return f23735c;
    }
}
