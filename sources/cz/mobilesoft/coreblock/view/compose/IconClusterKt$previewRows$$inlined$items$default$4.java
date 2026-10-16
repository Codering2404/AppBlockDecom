package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.sequences.SequencesKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class IconClusterKt$previewRows$$inlined$items$default$4 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f130485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Profile.BlockingMode f130486b;

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.f139807a;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
        int i5;
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composer.e(i3) ? 32 : 16;
        }
        if (!composer.r((i5 & 147) != 146, i5 & 1)) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
        }
        Pair pair = (Pair) this.f130485a.get(i3);
        composer.a0(-923993648);
        Modifier.Companion companion = Modifier.b8;
        MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer, 0);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, companion);
        ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
        Function0 function0A = companion2.a();
        if (composer.m() == null) {
            ComposablesKt.c();
        }
        composer.L();
        if (composer.i()) {
            composer.P(function0A);
        } else {
            composer.v();
        }
        Composer composerA = Updater.a(composer);
        Updater.e(composerA, measurePolicyB, companion2.e());
        Updater.e(composerA, compositionLocalMapU, companion2.g());
        Function2 function2B = companion2.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion2.f());
        RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
        float f3 = 0;
        androidx.compose.material.TextKt.c("Apps: " + pair.e() + "\nWebs: " + pair.f(), PaddingKt.l(companion, Dp.g(f3), Dp.g(f3), Dp.g(18), Dp.g(f3)), ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 131064);
        int iD = MathKt.d(((Number) pair.f()).floatValue() / 2.0f);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new Function0<String>() { // from class: cz.mobilesoft.coreblock.view.compose.IconClusterKt$previewRows$1$1$1$1
                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final String invoke() {
                    return "";
                }
            };
            composer.w(objG);
        }
        ImmutableList immutableListI = ExtensionsKt.i(SequencesKt.P(SequencesKt.i((Function0) objG), ((Number) pair.e()).intValue()));
        int iIntValue = ((Number) pair.f()).intValue();
        ArrayList arrayList = new ArrayList(iIntValue);
        int i6 = 0;
        while (i6 < iIntValue) {
            arrayList.add(new WebsiteDTO("Web " + i6, i6 < iD ? WebsiteProfileRelation.BlockingType.DOMAIN : WebsiteProfileRelation.BlockingType.KEYWORD, false, false, 12, null));
            i6++;
        }
        IconClusterKt.k(null, immutableListI, ExtensionsKt.h(CollectionsKt.emptyList()), arrayList, CollectionsKt.listOf((Object[]) new Category[]{Category.HEALTH, Category.NEWS}), true, false, this.f130486b, ((Number) pair.e()).intValue() == 5, false, false, false, composer, 1794048, 0, 3585);
        composer.y();
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
