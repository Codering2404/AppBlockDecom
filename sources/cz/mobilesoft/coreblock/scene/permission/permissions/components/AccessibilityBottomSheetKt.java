package cz.mobilesoft.coreblock.scene.permission.permissions.components;

import android.text.Spanned;
import android.text.style.StyleSpan;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.core.text.HtmlCompat;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.AccessibilityBottomSheetKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class AccessibilityBottomSheetKt {
    public static final void f(final boolean z2, final Function0 onDismiss, final Function0 onConfirm, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer composerK = composer.k(1540519468);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDismiss) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onConfirm) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1540519468, i4, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.components.AccessibilityBottomSheet (AccessibilityBottomSheet.kt:36)");
            }
            function0 = onDismiss;
            ComposeBottomSheetsKt.f(null, null, true, ComposableLambdaKt.e(1185969643, true, new Function4() { // from class: h1.d
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return AccessibilityBottomSheetKt.g(z2, onDismiss, onConfirm, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, function0, composerK, ((i4 << 12) & 458752) | 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: h1.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityBottomSheetKt.h(z2, function0, onConfirm, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(boolean z2, Function0 function0, Function0 function02, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1185969643, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.components.AccessibilityBottomSheet.<anonymous> (AccessibilityBottomSheet.kt:40)");
            }
            i(z2, function0, function02, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(boolean z2, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        f(z2, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(final boolean r36, kotlin.jvm.functions.Function0 r37, kotlin.jvm.functions.Function0 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.components.AccessibilityBottomSheetKt.i(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(boolean z2, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        i(z2, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final AnnotatedString n(String str) {
        Spanned spannedA = HtmlCompat.a(str, 63);
        Intrinsics.checkNotNullExpressionValue(spannedA, "fromHtml(...)");
        String string = spannedA.toString();
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        builder.l(string);
        StyleSpan[] styleSpanArr = (StyleSpan[]) spannedA.getSpans(0, spannedA.length(), StyleSpan.class);
        Intrinsics.checkNotNull(styleSpanArr);
        for (StyleSpan styleSpan : styleSpanArr) {
            if (styleSpan.getStyle() == 1) {
                builder.f(new SpanStyle(0L, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null), spannedA.getSpanStart(styleSpan), spannedA.getSpanEnd(styleSpan));
            }
        }
        return builder.t();
    }
}
