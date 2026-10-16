package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.R;
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
public final class ComposableSingletons$DefaultPaywallViewKt {
    public static final ComposableSingletons$DefaultPaywallViewKt INSTANCE = new ComposableSingletons$DefaultPaywallViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f32lambda1 = ComposableLambdaKt.c(619696328, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i3) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i3 & 17) == 16 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(619696328, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-1.<anonymous> (DefaultPaywallView.kt:228)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f33lambda2 = ComposableLambdaKt.c(-1207225124, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }

        public final void invoke(RowScope Button, Composer composer, int i3) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i3 & 17) == 16 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1207225124, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-2.<anonymous> (DefaultPaywallView.kt:272)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.revenuecatui_purchase, composer, 0), null, 0L, 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 196608, 0, 131038);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f34lambda3 = ComposableLambdaKt.c(-1536372177, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-3$1
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
                ComposerKt.U(-1536372177, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-3.<anonymous> (DefaultPaywallView.kt:286)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.revenuecatui_restore_purchases, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131070);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1101getLambda1$revenuecatui_defaultsBc8Release() {
        return f32lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1102getLambda2$revenuecatui_defaultsBc8Release() {
        return f33lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1103getLambda3$revenuecatui_defaultsBc8Release() {
        return f34lambda3;
    }
}
