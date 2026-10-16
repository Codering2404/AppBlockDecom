package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class LockScreenKt$LockScreen$4$4$3$2$5 implements Function3<RowScope, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LockViewState f105411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f105412b;

    LockScreenKt$LockScreen$4$4$3$2$5(LockViewState lockViewState, boolean z2) {
        this.f105411a = lockViewState;
        this.f105412b = z2;
    }

    public final void c(RowScope Button, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(Button) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (!composer.r((i4 & 19) != 18, i4 & 1)) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1881152681, i4, -1, "cz.mobilesoft.coreblock.scene.lockscreen.LockScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LockScreen.kt:726)");
        }
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityQ = this.f105411a.q();
        String strE = customBlockingScreenConfigEntityQ != null ? customBlockingScreenConfigEntityQ.e() : null;
        if (strE == null) {
            composer.a0(686397425);
        } else {
            composer.a0(686397426);
            strB = strE.length() > 0 ? strE : null;
            if (strB == null) {
                composer.a0(2063372253);
                String strB = StringResources_androidKt.b(R.string.N7, composer, 0);
                composer.U();
                strB = strB;
            } else {
                composer.a0(2063371230);
                composer.U();
            }
        }
        composer.U();
        if (strB == null) {
            composer.a0(686470803);
            strB = StringResources_androidKt.b(R.string.N7, composer, 0);
        } else {
            composer.a0(-393501962);
        }
        composer.U();
        TextKt.c(strB, null, Color.r(ComposeColorsKt.j(composer, 0).q0(), (this.f105411a.l() || this.f105412b) ? 1.0f : 0.35f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).i(), composer, 0, 0, 65530);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        c((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.f139807a;
    }
}
