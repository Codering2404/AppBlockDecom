package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ComposableSingletons$BottomSheetScaffoldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BottomSheetScaffoldKt f16710a = new ComposableSingletons$BottomSheetScaffoldKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function2 f16711b = ComposableLambdaKt.c(-927355320, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-927355320, i3, -1, "androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.lambda-1.<anonymous> (BottomSheetScaffold.kt:120)");
            }
            BottomSheetDefaults.f15945a.a(null, 0.0f, 0.0f, null, 0L, composer, 196608, 31);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function3 f16712c = ComposableLambdaKt.c(923568898, false, new Function3<SnackbarHostState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt$lambda-2$1
        public final void c(SnackbarHostState snackbarHostState, Composer composer, int i3) {
            if ((i3 & 6) == 0) {
                i3 |= composer.Z(snackbarHostState) ? 4 : 2;
            }
            if ((i3 & 19) == 18 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(923568898, i3, -1, "androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.lambda-2.<anonymous> (BottomSheetScaffold.kt:123)");
            }
            SnackbarHostKt.b(snackbarHostState, null, null, composer, i3 & 14, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            c((SnackbarHostState) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function2 f16713d = ComposableLambdaKt.c(1800698411, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1800698411, i3, -1, "androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.lambda-3.<anonymous> (BottomSheetScaffold.kt:358)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    public final Function2 a() {
        return f16711b;
    }

    public final Function3 b() {
        return f16712c;
    }

    public final Function2 c() {
        return f16713d;
    }
}
