package com.valentinilk.shimmer;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

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
public final class ShimmerThemeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ShimmerTheme f93828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f93829b;

    static {
        InfiniteRepeatableSpec infiniteRepeatableSpecE = AnimationSpecKt.e(AnimationSpecKt.m(800, 1500, EasingKt.e()), RepeatMode.f4052a, 0L, 4, null);
        int i3 = BlendMode.f25667b.i();
        Color.Companion companion = Color.f25715b;
        f93828a = new ShimmerTheme(infiniteRepeatableSpecE, i3, 15.0f, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.r(companion.k(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(Color.r(companion.k(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(Color.r(companion.k(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null))}), CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.0f), Float.valueOf(0.5f), Float.valueOf(1.0f)}), Dp.g(RCHTTPStatusCodes.BAD_REQUEST), null);
        f93829b = CompositionLocalKt.g(new Function0<ShimmerTheme>() { // from class: com.valentinilk.shimmer.ShimmerThemeKt$LocalShimmerTheme$1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ShimmerTheme invoke() {
                return ShimmerThemeKt.a();
            }
        });
    }

    public static final ShimmerTheme a() {
        return f93828a;
    }

    public static final ProvidableCompositionLocal b() {
        return f93829b;
    }
}
