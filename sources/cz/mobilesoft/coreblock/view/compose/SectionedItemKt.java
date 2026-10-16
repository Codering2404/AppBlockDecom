package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CheckboxColors;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class SectionedItemKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0c35  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0c5e  */
    /* JADX WARN: Removed duplicated region for block: B:421:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0115  */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void G(androidx.compose.ui.Modifier r83, java.lang.String r84, androidx.compose.ui.text.AnnotatedString r85, java.lang.String r86, androidx.compose.ui.text.AnnotatedString r87, java.lang.String r88, androidx.compose.ui.graphics.vector.ImageVector r89, androidx.compose.ui.graphics.Color r90, androidx.compose.ui.graphics.painter.Painter r91, boolean r92, long r93, long r95, androidx.compose.ui.graphics.Shape r97, boolean r98, kotlin.jvm.functions.Function0 r99, boolean r100, java.lang.String r101, long r102, androidx.compose.runtime.Composer r104, final int r105, final int r106, final int r107) {
        /*
            Method dump skipped, instruction units count: 3188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SectionedItemKt.G(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.text.AnnotatedString, java.lang.String, androidx.compose.ui.text.AnnotatedString, java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.painter.Painter, boolean, long, long, androidx.compose.ui.graphics.Shape, boolean, kotlin.jvm.functions.Function0, boolean, java.lang.String, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:379:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0114  */
    /* JADX WARN: Type inference failed for: r52v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r55v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void H(androidx.compose.ui.Modifier r52, java.lang.String r53, androidx.compose.ui.text.AnnotatedString r54, java.lang.String r55, androidx.compose.ui.text.AnnotatedString r56, androidx.compose.ui.graphics.painter.Painter r57, long r58, long r60, androidx.compose.ui.graphics.Color r62, long r63, androidx.compose.ui.graphics.Shape r65, kotlin.jvm.functions.Function0 r66, java.lang.Boolean r67, boolean r68, boolean r69, boolean r70, androidx.compose.runtime.Composer r71, final int r72, final int r73, final int r74) {
        /*
            Method dump skipped, instruction units count: 2364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SectionedItemKt.H(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.text.AnnotatedString, java.lang.String, androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.graphics.painter.Painter, long, long, androidx.compose.ui.graphics.Color, long, androidx.compose.ui.graphics.Shape, kotlin.jvm.functions.Function0, java.lang.Boolean, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.r0(semantics, Role.f28457b.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Modifier modifier, String str, AnnotatedString annotatedString, String str2, AnnotatedString annotatedString2, Painter painter, long j3, long j4, Color color, long j5, Shape shape, Function0 function0, Boolean bool, boolean z2, boolean z3, boolean z4, int i3, int i4, int i5, Composer composer, int i6) {
        H(modifier, str, annotatedString, str2, annotatedString2, painter, j3, j4, color, j5, shape, function0, bool, z2, z3, z4, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0a06  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0a2f  */
    /* JADX WARN: Removed duplicated region for block: B:389:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void L(androidx.compose.ui.Modifier r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, androidx.compose.ui.graphics.vector.ImageVector r61, long r62, boolean r64, boolean r65, long r66, androidx.compose.ui.graphics.Color r68, long r69, long r71, androidx.compose.ui.text.TextStyle r73, androidx.compose.ui.text.TextStyle r74, androidx.compose.ui.graphics.Shape r75, boolean r76, kotlin.jvm.functions.Function0 r77, androidx.compose.runtime.Composer r78, final int r79, final int r80, final int r81) {
        /*
            Method dump skipped, instruction units count: 2629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SectionedItemKt.L(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, long, boolean, boolean, long, androidx.compose.ui.graphics.Color, long, long, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.graphics.Shape, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(boolean z2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (z2) {
            graphicsLayer.j(180.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Modifier modifier, String str, String str2, String str3, ImageVector imageVector, long j3, boolean z2, boolean z3, long j4, Color color, long j5, long j6, TextStyle textStyle, TextStyle textStyle2, Shape shape, boolean z4, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) {
        L(modifier, str, str2, str3, imageVector, j3, z2, z3, j4, color, j5, j6, textStyle, textStyle2, shape, z4, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0ad9  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0afb  */
    /* JADX WARN: Removed duplicated region for block: B:367:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v53 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void P(androidx.compose.ui.Modifier r56, java.lang.String r57, androidx.compose.ui.text.AnnotatedString r58, java.lang.String r59, androidx.compose.ui.text.AnnotatedString r60, androidx.compose.ui.graphics.vector.ImageVector r61, long r62, long r64, long r66, androidx.compose.ui.graphics.Shape r68, java.util.List r69, kotlin.jvm.functions.Function0 r70, java.lang.Boolean r71, boolean r72, androidx.compose.runtime.Composer r73, final int r74, final int r75, final int r76) {
        /*
            Method dump skipped, instruction units count: 2833
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SectionedItemKt.P(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.text.AnnotatedString, java.lang.String, androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.graphics.vector.ImageVector, long, long, long, androidx.compose.ui.graphics.Shape, java.util.List, kotlin.jvm.functions.Function0, java.lang.Boolean, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier R(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.k(applyIf, 0.0f, Dp.g(16), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function0 function0, boolean z2) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(List list, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(2113847431, i3, -1, "cz.mobilesoft.coreblock.view.compose.SectionedItemSwitch.<anonymous>.<anonymous> (SectionedItem.kt:606)");
        }
        Modifier.Companion companion = Modifier.b8;
        float f3 = 16;
        Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
        int i4 = 0;
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
        int iA = ComposablesKt.a(composer2, 0);
        CompositionLocalMap compositionLocalMapU = composer2.u();
        Modifier modifierF = ComposedModifierKt.f(composer2, modifierM);
        ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
        Function0 function0A = companion2.a();
        if (composer2.m() == null) {
            ComposablesKt.c();
        }
        composer2.L();
        if (composer2.i()) {
            composer2.P(function0A);
        } else {
            composer2.v();
        }
        Composer composerA = Updater.a(composer2);
        Updater.e(composerA, measurePolicyA, companion2.e());
        Updater.e(composerA, compositionLocalMapU, companion2.g());
        Function2 function2B = companion2.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion2.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        float f4 = 0.0f;
        Object obj = null;
        androidx.compose.material3.DividerKt.b(PaddingKt.k(companion, Dp.g(12), 0.0f, 2, null), 0.0f, ComposeColorsKt.j(composer2, 0).v(), composer2, 6, 2);
        composer2.a0(219384110);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ExpandableCheckboxItem expandableCheckboxItem = (ExpandableCheckboxItem) it.next();
            Modifier modifierM2 = PaddingKt.m(SizeKt.h(Modifier.b8, f4, 1, obj), Dp.g(40), Dp.g(8), Dp.g(f3), 0.0f, 8, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.e(), Alignment.f25072a.i(), composer2, 54);
            int iA2 = ComposablesKt.a(composer2, i4);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierM2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A2 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f5 = f4;
            Object obj2 = obj;
            float f6 = f3;
            androidx.compose.material3.TextKt.c(StringResources_androidKt.b(expandableCheckboxItem.b(), composer2, i4), null, ComposeColorsKt.j(composer2, i4).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, i4).b(), composer, 0, 0, 65530);
            boolean zC = expandableCheckboxItem.c();
            CheckboxColors checkboxColorsH = ComposeColorsKt.h(composer, 0);
            boolean Z = composer.Z(expandableCheckboxItem);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.z9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SectionedItemKt.U(expandableCheckboxItem, ((Boolean) obj3).booleanValue());
                    }
                };
                composer.w(objG);
            }
            CheckboxKt.a(zC, (Function1) objG, null, false, checkboxColorsH, null, composer, 0, 44);
            composer.y();
            composer2 = composer;
            i4 = 0;
            f3 = f6;
            obj = obj2;
            f4 = f5;
        }
        composer.U();
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(ExpandableCheckboxItem expandableCheckboxItem, boolean z2) {
        expandableCheckboxItem.a().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Modifier modifier, String str, AnnotatedString annotatedString, String str2, AnnotatedString annotatedString2, ImageVector imageVector, long j3, long j4, long j5, Shape shape, List list, Function0 function0, Boolean bool, boolean z2, int i3, int i4, int i5, Composer composer, int i6) {
        P(modifier, str, annotatedString, str2, annotatedString2, imageVector, j3, j4, j5, shape, list, function0, bool, z2, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void W(androidx.compose.ui.Modifier r38, java.lang.String r39, androidx.compose.ui.graphics.vector.ImageVector r40, boolean r41, long r42, long r44, androidx.compose.ui.graphics.Shape r46, boolean r47, final java.lang.String r48, long r49, kotlin.jvm.functions.Function0 r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SectionedItemKt.W(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, boolean, long, long, androidx.compose.ui.graphics.Shape, boolean, java.lang.String, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(String str, long j3, String str2, long j4, FlowRowScope FlowRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1380616036, i3, -1, "cz.mobilesoft.coreblock.view.compose.SectionedItemWithChip.<anonymous>.<anonymous>.<anonymous> (SectionedItem.kt:850)");
            }
            androidx.compose.material3.TextKt.c(str == null ? "" : str, null, j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            LabelsKt.e(str2, ComposeColorsKt.j(composer, 0).q0(), j4, Dp.g(8), Dp.g(4), RoundedCornerShapeKt.a(50), Integer.valueOf(R.drawable.V3), composer, 27648, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(boolean z2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (z2) {
            graphicsLayer.j(180.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Modifier modifier, String str, ImageVector imageVector, boolean z2, long j3, long j4, Shape shape, boolean z3, String str2, long j5, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) throws XmlPullParserException, IOException {
        W(modifier, str, imageVector, z2, j3, j4, shape, z3, str2, j5, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(boolean z2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (z2) {
            graphicsLayer.j(180.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(Modifier modifier, String str, AnnotatedString annotatedString, String str2, AnnotatedString annotatedString2, String str3, ImageVector imageVector, Color color, Painter painter, boolean z2, long j3, long j4, Shape shape, boolean z3, Function0 function0, boolean z4, String str4, long j5, int i3, int i4, int i5, Composer composer, int i6) {
        G(modifier, str, annotatedString, str2, annotatedString2, str3, imageVector, color, painter, z2, j3, j4, shape, z3, function0, z4, str4, j5, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    public static final Shape e0(int i3, int i4, Composer composer, int i5) {
        if (ComposerKt.M()) {
            ComposerKt.U(1980106832, i5, -1, "cz.mobilesoft.coreblock.view.compose.sectionItemCorners (SectionedItem.kt:103)");
        }
        float fA = PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0);
        float fG = Dp.g(2);
        RoundedCornerShape roundedCornerShapeD = i4 == 1 ? RoundedCornerShapeKt.d(fA) : i3 == 0 ? RoundedCornerShapeKt.e(fA, fA, fG, fG) : i3 == i4 - 1 ? RoundedCornerShapeKt.e(fG, fG, fA, fA) : RoundedCornerShapeKt.d(fG);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return roundedCornerShapeD;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0af5  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0b27  */
    /* JADX WARN: Removed duplicated region for block: B:556:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f0(final java.util.List r56, final kotlin.jvm.functions.Function3 r57, kotlin.jvm.functions.Function3 r58, kotlin.jvm.functions.Function3 r59, kotlin.jvm.functions.Function3 r60, kotlin.jvm.functions.Function3 r61, kotlin.jvm.functions.Function3 r62, kotlin.jvm.functions.Function3 r63, kotlin.jvm.functions.Function3 r64, kotlin.jvm.functions.Function3 r65, kotlin.jvm.functions.Function3 r66, kotlin.jvm.functions.Function3 r67, kotlin.jvm.functions.Function3 r68, boolean r69, boolean r70, boolean r71, long r72, androidx.compose.ui.graphics.Color r74, kotlin.jvm.functions.Function3 r75, long r76, androidx.compose.ui.text.TextStyle r78, androidx.compose.ui.text.TextStyle r79, long r80, kotlin.jvm.functions.Function3 r82, kotlin.jvm.functions.Function3 r83, final kotlin.jvm.functions.Function2 r84, androidx.compose.runtime.Composer r85, final int r86, final int r87, final int r88, final int r89) {
        /*
            Method dump skipped, instruction units count: 2883
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SectionedItemKt.f0(java.util.List, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, boolean, boolean, boolean, long, androidx.compose.ui.graphics.Color, kotlin.jvm.functions.Function3, long, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g0(Object obj, Composer composer, int i3) {
        composer.a0(1443070453);
        if (ComposerKt.M()) {
            ComposerKt.U(1443070453, i3, -1, "cz.mobilesoft.coreblock.view.compose.toSectionedItems.<anonymous> (SectionedItem.kt:124)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h0(Object obj, Composer composer, int i3) {
        composer.a0(-378612512);
        if (ComposerKt.M()) {
            ComposerKt.U(-378612512, i3, -1, "cz.mobilesoft.coreblock.view.compose.toSectionedItems.<anonymous> (SectionedItem.kt:125)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i0(Object obj, Composer composer, int i3) {
        composer.a0(1340752596);
        if (ComposerKt.M()) {
            ComposerKt.U(1340752596, i3, -1, "cz.mobilesoft.coreblock.view.compose.toSectionedItems.<anonymous> (SectionedItem.kt:126)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j0(Object obj, Composer composer, int i3) {
        composer.a0(130574854);
        if (ComposerKt.M()) {
            ComposerKt.U(130574854, i3, -1, "cz.mobilesoft.coreblock.view.compose.toSectionedItems.<anonymous> (SectionedItem.kt:127)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k0(Object obj, Composer composer, int i3) {
        composer.a0(-303505398);
        if (ComposerKt.M()) {
            ComposerKt.U(-303505398, i3, -1, "cz.mobilesoft.coreblock.view.compose.toSectionedItems.<anonymous> (SectionedItem.kt:128)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(Function2 function2, Object obj, int i3) {
        function2.invoke(obj, Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function2 function2, Object obj, int i3) {
        function2.invoke(obj, Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(Function2 function2, Object obj, int i3) {
        function2.invoke(obj, Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function2 function2, Object obj, int i3) {
        function2.invoke(obj, Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function2 function2, Object obj, int i3) {
        function2.invoke(obj, Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(List list, Function3 function3, Function3 function32, Function3 function33, Function3 function34, Function3 function35, Function3 function36, Function3 function37, Function3 function38, Function3 function39, Function3 function310, Function3 function311, Function3 function312, boolean z2, boolean z3, boolean z4, long j3, Color color, Function3 function313, long j4, TextStyle textStyle, TextStyle textStyle2, long j5, Function3 function314, Function3 function315, Function2 function2, int i3, int i4, int i5, int i6, Composer composer, int i7) {
        f0(list, function3, function32, function33, function34, function35, function36, function37, function38, function39, function310, function311, function312, z2, z3, z4, j3, color, function313, j4, textStyle, textStyle2, j5, function314, function315, function2, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c5 A[LOOP:0: B:146:0x01bf->B:148:0x01c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r0(final java.util.List r40, final kotlin.jvm.functions.Function3 r41, kotlin.jvm.functions.Function3 r42, kotlin.jvm.functions.Function3 r43, boolean r44, boolean r45, kotlin.jvm.functions.Function3 r46, kotlin.jvm.functions.Function3 r47, kotlin.jvm.functions.Function3 r48, final kotlin.jvm.functions.Function2 r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 801
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.SectionedItemKt.r0(java.util.List, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, boolean, boolean, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0(Object obj, Composer composer, int i3) {
        composer.a0(-648558530);
        if (ComposerKt.M()) {
            ComposerKt.U(-648558530, i3, -1, "cz.mobilesoft.coreblock.view.compose.toSections.<anonymous> (SectionedItem.kt:66)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(List list, Function3 function3, Function3 function32, Function3 function33, boolean z2, boolean z3, Function3 function34, Function3 function35, Function3 function36, Function2 function2, int i3, int i4, Composer composer, int i5) {
        r0(list, function3, function32, function33, z2, z3, function34, function35, function36, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
