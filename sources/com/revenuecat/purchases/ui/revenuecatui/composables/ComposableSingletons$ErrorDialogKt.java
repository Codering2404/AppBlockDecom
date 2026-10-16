package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import com.revenuecat.purchases.ui.revenuecatui.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$ErrorDialogKt {
    public static final ComposableSingletons$ErrorDialogKt INSTANCE = new ComposableSingletons$ErrorDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f15lambda1 = ComposableLambdaKt.c(1324687321, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i3) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i3 & 17) == 16 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1324687321, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt.lambda-1.<anonymous> (ErrorDialog.kt:25)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.OK, composer, 0), null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, composer, 0, 0, 130558);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f16lambda2 = ComposableLambdaKt.c(-1820821153, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt$lambda-2$1
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
                ComposerKt.U(-1820821153, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ComposableSingletons$ErrorDialogKt.lambda-2.<anonymous> (ErrorDialog.kt:31)");
            }
            IconKt.c(PainterResources_androidKt.c(R.drawable.error, composer, 0), null, null, 0L, composer, 48, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m873getLambda1$revenuecatui_defaultsBc8Release() {
        return f15lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m874getLambda2$revenuecatui_defaultsBc8Release() {
        return f16lambda2;
    }
}
