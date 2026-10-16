package cz.mobilesoft.coreblock.scene.selection.base.selectionscreens;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.scene.selection.components.AllowlistWebsitesHintKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$BaseWebsiteSelectionScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BaseWebsiteSelectionScreenKt f118782a = new ComposableSingletons$BaseWebsiteSelectionScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f118783b = ComposableLambdaKt.c(1633787756, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.p
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BaseWebsiteSelectionScreenKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f118784c = ComposableLambdaKt.c(-851117773, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.q
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BaseWebsiteSelectionScreenKt.g((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1633787756, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.ComposableSingletons$BaseWebsiteSelectionScreenKt.lambda$1633787756.<anonymous> (BaseWebsiteSelectionScreen.kt:58)");
            }
            WebsiteProfileRelation.BlockingType blockingType = WebsiteProfileRelation.BlockingType.DOMAIN;
            BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState = new BaseSelectionViewState.WebsiteKeywordsViewState(null, MapsKt.mutableMapOf(TuplesKt.a("Website1", new WebsiteStateDTO(new WebsiteDTO("Website Name", blockingType, false, false, 12, null), false, false, false, 12, null)), TuplesKt.a("Website2", new WebsiteStateDTO(new WebsiteDTO("Website Name", blockingType, false, false, 12, null), false, false, false, 12, null)), TuplesKt.a("Website3", new WebsiteStateDTO(new WebsiteDTO("Website Name", blockingType, false, false, 12, null), false, false, false, 12, null))), null, null, null, 29, null);
            LazyListState lazyListStateB = LazyListStateKt.b(0, 0, composer, 0, 3);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BaseWebsiteSelectionScreenKt.f((BaseSelectionViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            BaseWebsiteSelectionScreenKt.p(websiteKeywordsViewState, blockingType, null, lazyListStateB, scaffoldStateG, (Function1) objG, composer, 196656, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(BaseSelectionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-851117773, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.ComposableSingletons$BaseWebsiteSelectionScreenKt.lambda$-851117773.<anonymous> (BaseWebsiteSelectionScreen.kt:150)");
            }
            AllowlistWebsitesHintKt.b(PaddingKt.j(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(16), Dp.g(8)), composer, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 d() {
        return f118784c;
    }
}
