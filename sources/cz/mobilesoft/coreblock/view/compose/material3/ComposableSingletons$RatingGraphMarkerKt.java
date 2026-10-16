package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$RatingGraphMarkerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$RatingGraphMarkerKt f131146a = new ComposableSingletons$RatingGraphMarkerKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f131147b = ComposableLambdaKt.c(802494831, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.c0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphMarkerKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f131148c = ComposableLambdaKt.c(-1285574765, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.d0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphMarkerKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f131149d = ComposableLambdaKt.c(1705445934, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.e0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphMarkerKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1705445934, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphMarkerKt.lambda$1705445934.<anonymous> (RatingGraphMarker.kt:144)");
            }
            RatingGraphMarkerKt.c(StringResources_androidKt.b(R.string.De, composer, 0), BackgroundKt.d(Modifier.b8, Color.f25715b.a(), null, 2, null), ColorKt.d(4281308927L), 0L, TextStyle.e(ComposeTypographyKt.g(composer, 0).d(), 0L, TextUnitKt.i(12), FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), f131148c, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, composer, 197040, 0, 32712);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(802494831, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphMarkerKt.lambda$802494831.<anonymous> (RatingGraphMarker.kt:131)");
            }
            RatingGraphMarkerKt.c(StringResources_androidKt.b(R.string.xl, composer, 0), BackgroundKt.d(Modifier.b8, Color.f25715b.a(), null, 2, null), ColorKt.d(4294916912L), 0L, TextStyle.e(ComposeTypographyKt.g(composer, 0).d(), 0L, TextUnitKt.i(12), FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, composer, 432, 0, 32744);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1285574765, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphMarkerKt.lambda$-1285574765.<anonymous> (RatingGraphMarker.kt:150)");
            }
            IconKt.c(PainterResources_androidKt.c(R.drawable.A0, composer, 0), null, SizeKt.v(Modifier.b8, Dp.g(16)), Color.f25715b.l(), composer, 3504, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
