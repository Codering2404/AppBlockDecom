package com.google.maps.android.compose;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.Arrays;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class MapEffectKt {
    public static final void a(final Object obj, final Object obj2, final Object obj3, final Function3 block, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer composerK = composer.k(-88380218);
        if (ComposerKt.M()) {
            ComposerKt.U(-88380218, i3, -1, "com.google.maps.android.compose.MapEffect (MapEffect.kt:62)");
        }
        Applier applierM = composerK.m();
        Intrinsics.checkNotNull(applierM, "null cannot be cast to non-null type com.google.maps.android.compose.MapApplier");
        EffectsKt.e(obj, obj2, obj3, new MapEffectKt$MapEffect$5(block, ((MapApplier) applierM).I(), null), composerK, 4680);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.MapEffectKt$MapEffect$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                invoke((Composer) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i4) {
                MapEffectKt.a(obj, obj2, obj3, block, composer2, i3 | 1);
            }
        });
    }

    public static final void b(final Object obj, final Object obj2, final Function3 block, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer composerK = composer.k(-834763738);
        if (ComposerKt.M()) {
            ComposerKt.U(-834763738, i3, -1, "com.google.maps.android.compose.MapEffect (MapEffect.kt:42)");
        }
        Applier applierM = composerK.m();
        Intrinsics.checkNotNull(applierM, "null cannot be cast to non-null type com.google.maps.android.compose.MapApplier");
        EffectsKt.f(obj, obj2, new MapEffectKt$MapEffect$3(block, ((MapApplier) applierM).I(), null), composerK, 584);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.MapEffectKt$MapEffect$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                invoke((Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i4) {
                MapEffectKt.b(obj, obj2, block, composer2, i3 | 1);
            }
        });
    }

    public static final void c(final Object obj, final Function3 block, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(block, "block");
        Composer composerK = composer.k(-357282938);
        if (ComposerKt.M()) {
            ComposerKt.U(-357282938, i3, -1, "com.google.maps.android.compose.MapEffect (MapEffect.kt:22)");
        }
        Applier applierM = composerK.m();
        Intrinsics.checkNotNull(applierM, "null cannot be cast to non-null type com.google.maps.android.compose.MapApplier");
        EffectsKt.g(obj, new MapEffectKt$MapEffect$1(block, ((MapApplier) applierM).I(), null), composerK, 72);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.MapEffectKt$MapEffect$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i4) {
                MapEffectKt.c(obj, block, composer2, i3 | 1);
            }
        });
    }

    public static final void d(final Object[] keys, final Function3 block, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(block, "block");
        Composer composerK = composer.k(-276920653);
        if (ComposerKt.M()) {
            ComposerKt.U(-276920653, i3, -1, "com.google.maps.android.compose.MapEffect (MapEffect.kt:87)");
        }
        Applier applierM = composerK.m();
        Intrinsics.checkNotNull(applierM, "null cannot be cast to non-null type com.google.maps.android.compose.MapApplier");
        EffectsKt.i(Arrays.copyOf(keys, keys.length), new MapEffectKt$MapEffect$7(block, ((MapApplier) applierM).I(), null), composerK, 72);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.MapEffectKt$MapEffect$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i4) {
                Object[] objArr = keys;
                MapEffectKt.d(Arrays.copyOf(objArr, objArr.length), block, composer2, i3 | 1);
            }
        });
    }
}
