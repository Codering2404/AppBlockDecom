package cz.mobilesoft.coreblock.view.compose.profileitem;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class ProfileItemKt$Preview$lambda$0$0$$inlined$items$default$4 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f131681a;

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.f139807a;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
        int i5;
        if ((i4 & 6) == 0) {
            i5 = (composer.Z(lazyItemScope) ? 4 : 2) | i4;
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
        ProfileViewDTO profileViewDTO = (ProfileViewDTO) this.f131681a.get(i3);
        composer.a0(-498322990);
        ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
        AppIconCache appIconCache = new AppIconCache();
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new Function1<ProfileItemEvent, Unit>() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt$Preview$1$1$1$1$1
                public final void c(ProfileItemEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((ProfileItemEvent) obj);
                    return Unit.f139807a;
                }
            };
            composer.w(objG);
        }
        ProfileItemKt.I0(scaffoldStateG, profileViewDTO, appIconCache, null, false, null, (Function1) objG, composer, 1572864, 56);
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
