package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class SegmentedButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SegmentedButtonDefaults f19722a = new SegmentedButtonDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f19723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f19724c;

    static {
        OutlinedSegmentedButtonTokens outlinedSegmentedButtonTokens = OutlinedSegmentedButtonTokens.f23131a;
        f19723b = outlinedSegmentedButtonTokens.h();
        f19724c = outlinedSegmentedButtonTokens.e();
    }

    private SegmentedButtonDefaults() {
    }

    public static /* synthetic */ BorderStroke d(SegmentedButtonDefaults segmentedButtonDefaults, long j3, float f3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f3 = f19723b;
        }
        return segmentedButtonDefaults.c(j3, f3);
    }

    public final void a(Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1273041460);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(this) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1273041460, i4, -1, "androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon (SegmentedButton.kt:545)");
            }
            IconKt.d(CheckKt.a(Icons.Filled.f15154a), null, SizeKt.v(Modifier.b8, f19724c), 0L, composerK, 48, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonDefaults$ActiveIcon$1
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
                    this.f19725a.a(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(final boolean r17, kotlin.jvm.functions.Function2 r18, kotlin.jvm.functions.Function2 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonDefaults.b(boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public final BorderStroke c(long j3, float f3) {
        return BorderStrokeKt.a(f3, j3);
    }

    public final SegmentedButtonColors e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(679457321, i3, -1, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:431)");
        }
        SegmentedButtonColors segmentedButtonColorsG = g(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return segmentedButtonColorsG;
    }

    public final float f() {
        return f19723b;
    }

    public final SegmentedButtonColors g(ColorScheme colorScheme) {
        SegmentedButtonColors segmentedButtonColorsJ = colorScheme.J();
        if (segmentedButtonColorsJ != null) {
            return segmentedButtonColorsJ;
        }
        OutlinedSegmentedButtonTokens outlinedSegmentedButtonTokens = OutlinedSegmentedButtonTokens.f23131a;
        SegmentedButtonColors segmentedButtonColors = new SegmentedButtonColors(ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.i()), ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.j()), ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.g()), colorScheme.o0(), ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.k()), ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.g()), ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.i()), Color.r(ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.b()), outlinedSegmentedButtonTokens.c(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.g()), outlinedSegmentedButtonTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0(), ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.b()), ColorSchemeKt.g(colorScheme, outlinedSegmentedButtonTokens.g()), null);
        colorScheme.h1(segmentedButtonColors);
        return segmentedButtonColors;
    }

    public final float h() {
        return f19724c;
    }
}
