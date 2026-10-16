package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class CompositionLocalKt {
    public static final void a(final CompositionLocalContext compositionLocalContext, final Function2 function2, Composer composer, final int i3) {
        Composer composerK = composer.k(1853897736);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(compositionLocalContext) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1853897736, i4, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:399)");
            }
            PersistentCompositionLocalMap persistentCompositionLocalMapA = compositionLocalContext.a();
            ArrayList arrayList = new ArrayList(persistentCompositionLocalMapA.size());
            for (Map.Entry<CompositionLocal<Object>, ValueHolder<Object>> entry : persistentCompositionLocalMapA.entrySet()) {
                arrayList.add(entry.getValue().a(entry.getKey()));
            }
            ProvidedValue[] providedValueArr = (ProvidedValue[]) arrayList.toArray(new ProvidedValue[0]);
            c((ProvidedValue[]) Arrays.copyOf(providedValueArr, providedValueArr.length), function2, composerK, i4 & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CompositionLocalKt.a(compositionLocalContext, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void b(final ProvidedValue providedValue, final Function2 function2, Composer composer, final int i3) {
        Composer composerK = composer.k(-1350970552);
        if (ComposerKt.M()) {
            ComposerKt.U(-1350970552, i3, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:381)");
        }
        composerK.N(providedValue);
        function2.invoke(composerK, Integer.valueOf((i3 >> 3) & 14));
        composerK.x();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$2
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
                    CompositionLocalKt.b(providedValue, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void c(final ProvidedValue[] providedValueArr, final Function2 function2, Composer composer, final int i3) {
        Composer composerK = composer.k(-1390796515);
        if (ComposerKt.M()) {
            ComposerKt.U(-1390796515, i3, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:361)");
        }
        composerK.b0(providedValueArr);
        function2.invoke(composerK, Integer.valueOf((i3 >> 3) & 14));
        composerK.R();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.CompositionLocalKt$CompositionLocalProvider$1
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
                    ProvidedValue[] providedValueArr2 = providedValueArr;
                    CompositionLocalKt.c((ProvidedValue[]) Arrays.copyOf(providedValueArr2, providedValueArr2.length), function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal d(SnapshotMutationPolicy snapshotMutationPolicy, Function0 function0) {
        return new DynamicProvidableCompositionLocal(snapshotMutationPolicy, function0);
    }

    public static /* synthetic */ ProvidableCompositionLocal e(SnapshotMutationPolicy snapshotMutationPolicy, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.r();
        }
        return d(snapshotMutationPolicy, function0);
    }

    public static final ProvidableCompositionLocal f(Function1 function1) {
        return new ComputedProvidableCompositionLocal(function1);
    }

    public static final ProvidableCompositionLocal g(Function0 function0) {
        return new StaticProvidableCompositionLocal(function0);
    }
}
