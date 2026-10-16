package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ComposableSingletons$CreateSupportTicketViewKt {
    public static final ComposableSingletons$CreateSupportTicketViewKt INSTANCE = new ComposableSingletons$CreateSupportTicketViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<SnackbarData, Composer, Integer, Unit> f22lambda1 = ComposableLambdaKt.c(-1015639048, false, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CreateSupportTicketViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((SnackbarData) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }

        public final void invoke(SnackbarData snackbarData, Composer composer, int i3) {
            int i4;
            Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
            if ((i3 & 6) == 0) {
                i4 = i3 | (composer.Z(snackbarData) ? 4 : 2);
            } else {
                i4 = i3;
            }
            if ((i4 & 19) == 18 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1015639048, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CreateSupportTicketViewKt.lambda-1.<anonymous> (CreateSupportTicketView.kt:361)");
            }
            MaterialTheme materialTheme = MaterialTheme.f18110a;
            int i5 = MaterialTheme.f18111b;
            SnackbarKt.d(snackbarData, null, false, null, materialTheme.a(composer, i5).S(), materialTheme.a(composer, i5).Y(), 0L, 0L, 0L, composer, i4 & 14, 462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m1015getLambda1$revenuecatui_defaultsBc8Release() {
        return f22lambda1;
    }
}
