package androidx.compose.foundation.contextmenu;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ContextMenuUi_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PopupProperties f5287a = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ContextMenuColors f5288b;

    static {
        Color.Companion companion = Color.f25715b;
        f5288b = new ContextMenuColors(companion.l(), companion.a(), companion.a(), Color.r(companion.a(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(companion.a(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.foundation.contextmenu.ContextMenuColors r28, androidx.compose.ui.Modifier r29, final kotlin.jvm.functions.Function3 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.a(androidx.compose.foundation.contextmenu.ContextMenuColors, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final java.lang.String r23, final boolean r24, final androidx.compose.foundation.contextmenu.ContextMenuColors r25, androidx.compose.ui.Modifier r26, kotlin.jvm.functions.Function3 r27, final kotlin.jvm.functions.Function0 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.b(java.lang.String, boolean, androidx.compose.foundation.contextmenu.ContextMenuColors, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final androidx.compose.ui.window.PopupPositionProvider r14, final kotlin.jvm.functions.Function0 r15, androidx.compose.ui.Modifier r16, final androidx.compose.foundation.contextmenu.ContextMenuColors r17, final kotlin.jvm.functions.Function1 r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.c(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.contextmenu.ContextMenuColors, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void d(PopupPositionProvider popupPositionProvider, Function0 function0, Modifier modifier, Function1 function1, Composer composer, final int i3, final int i4) {
        int i5;
        Function0 function02;
        final Function1 function12;
        final PopupPositionProvider popupPositionProvider2;
        final Modifier modifier2;
        Composer composerK = composer.k(712057293);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(popupPositionProvider) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.M()) {
                ComposerKt.U(712057293, i5, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:106)");
            }
            function02 = function0;
            c(popupPositionProvider, function02, modifier3, e(0, 0, composerK, 0, 3), function1, composerK, (i5 & 1022) | ((i5 << 3) & 57344), 0);
            popupPositionProvider2 = popupPositionProvider;
            function12 = function1;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier3;
        } else {
            function02 = function0;
            function12 = function1;
            popupPositionProvider2 = popupPositionProvider;
            composerK.Q();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function0 function03 = function02;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    ContextMenuUi_androidKt.d(popupPositionProvider2, function03, modifier2, function12, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public static final ContextMenuColors e(int i3, int i4, Composer composer, int i5, int i6) {
        int i7 = (i6 & 1) != 0 ? R.style.Widget.PopupMenu : i3;
        int i8 = (i6 & 2) != 0 ? R.style.TextAppearance.Widget.PopupMenu.Large : i4;
        if (ComposerKt.M()) {
            ComposerKt.U(1689505294, i5, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:363)");
        }
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        boolean Z = composer.Z((Configuration) composer.q(AndroidCompositionLocals_androidKt.f())) | composer.Z(context);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            ContextMenuColors contextMenuColors = f5288b;
            long jH = h(context, i7, R.attr.colorBackground, contextMenuColors.a());
            ColorStateList colorStateListI = i(context, i8, R.attr.textColorPrimary);
            long jG = g(colorStateListI, contextMenuColors.e());
            long jF = f(colorStateListI, contextMenuColors.c());
            Object contextMenuColors2 = new ContextMenuColors(jH, jG, jG, jF, jF, null);
            composer.w(contextMenuColors2);
            objG = contextMenuColors2;
        }
        ContextMenuColors contextMenuColors3 = (ContextMenuColors) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return contextMenuColors3;
    }

    private static final long f(ColorStateList colorStateList, long j3) {
        int iK = ColorKt.k(j3);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{-16842910}, iK)) : null;
        return (numValueOf == null || numValueOf.intValue() == iK) ? j3 : ColorKt.b(numValueOf.intValue());
    }

    private static final long g(ColorStateList colorStateList, long j3) {
        int iK = ColorKt.k(j3);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.state_enabled}, iK)) : null;
        return (numValueOf == null || numValueOf.intValue() == iK) ? j3 : ColorKt.b(numValueOf.intValue());
    }

    private static final long h(Context context, int i3, int i4, long j3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, new int[]{i4});
        int iK = ColorKt.k(j3);
        int color = typedArrayObtainStyledAttributes.getColor(0, iK);
        typedArrayObtainStyledAttributes.recycle();
        return color == iK ? j3 : ColorKt.b(color);
    }

    private static final ColorStateList i(Context context, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, new int[]{i4});
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        return colorStateList;
    }
}
