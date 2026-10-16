package cz.mobilesoft.coreblock.util.compose;

import androidx.compose.material.Shapes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeThemesKt {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final androidx.compose.material.Shapes r8, kotlin.jvm.functions.Function2 r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1234460539(0x49945f7b, float:1215471.4)
            androidx.compose.runtime.Composer r5 = r10.k(r0)
            r10 = r11 & 6
            if (r10 != 0) goto L1f
            r10 = r12 & 1
            if (r10 != 0) goto L1c
            boolean r10 = r5.Z(r8)
            if (r10 == 0) goto L1c
            r10 = 4
            goto L1d
        L1c:
            r10 = 2
        L1d:
            r10 = r10 | r11
            goto L20
        L1f:
            r10 = r11
        L20:
            r1 = r11 & 48
            if (r1 != 0) goto L30
            boolean r1 = r5.I(r9)
            if (r1 == 0) goto L2d
            r1 = 32
            goto L2f
        L2d:
            r1 = 16
        L2f:
            r10 = r10 | r1
        L30:
            r1 = r10 & 19
            r2 = 18
            r3 = 0
            if (r1 == r2) goto L39
            r1 = 1
            goto L3a
        L39:
            r1 = r3
        L3a:
            r2 = r10 & 1
            boolean r1 = r5.r(r1, r2)
            if (r1 == 0) goto L97
            r5.J()
            r1 = r11 & 1
            if (r1 == 0) goto L5a
            boolean r1 = r5.S()
            if (r1 == 0) goto L50
            goto L5a
        L50:
            r5.Q()
            r1 = r12 & 1
            if (r1 == 0) goto L67
        L57:
            r10 = r10 & (-15)
            goto L67
        L5a:
            r1 = r12 & 1
            if (r1 == 0) goto L67
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.f13091a
            int r1 = androidx.compose.material.MaterialTheme.f13092b
            androidx.compose.material.Shapes r8 = r8.b(r5, r1)
            goto L57
        L67:
            r5.z()
            boolean r1 = androidx.compose.runtime.ComposerKt.M()
            if (r1 == 0) goto L76
            r1 = -1
            java.lang.String r2 = "cz.mobilesoft.coreblock.util.compose.AppBlockTheme (ComposeThemes.kt:14)"
            androidx.compose.runtime.ComposerKt.U(r0, r10, r1, r2)
        L76:
            cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette r0 = cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt.j(r5, r3)
            androidx.compose.material.Colors r1 = r0.s0()
            androidx.compose.material.Typography r2 = cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt.g(r5, r3)
            int r10 = r10 << 6
            r6 = r10 & 8064(0x1f80, float:1.13E-41)
            r7 = 0
            r3 = r8
            r4 = r9
            androidx.compose.material.MaterialThemeKt.a(r1, r2, r3, r4, r5, r6, r7)
            boolean r8 = androidx.compose.runtime.ComposerKt.M()
            if (r8 == 0) goto L95
            androidx.compose.runtime.ComposerKt.T()
        L95:
            r8 = r3
            goto L9b
        L97:
            r4 = r9
            r5.Q()
        L9b:
            androidx.compose.runtime.ScopeUpdateScope r9 = r5.n()
            if (r9 == 0) goto La9
            cz.mobilesoft.coreblock.util.compose.h r10 = new cz.mobilesoft.coreblock.util.compose.h
            r10.<init>()
            r9.a(r10)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.compose.ComposeThemesKt.b(androidx.compose.material.Shapes, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Shapes shapes, Function2 function2, int i3, int i4, Composer composer, int i5) {
        b(shapes, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
