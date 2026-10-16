package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AppBarKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f15632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f15633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f15634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f15635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CubicBezierEasing f15636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f15637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f15638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f15639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f15640i;

    static {
        float f3 = 16;
        float f4 = 12;
        float fG = Dp.g(Dp.g(f3) - Dp.g(f4));
        f15632a = fG;
        float fG2 = Dp.g(Dp.g(f3) - Dp.g(f4));
        f15633b = fG2;
        f15634c = Dp.g(Dp.g(f3) - fG);
        f15635d = Dp.g(Dp.g(f4) - fG2);
        f15636e = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        f15637f = Dp.g(24);
        f15638g = Dp.g(28);
        float fG3 = Dp.g(4);
        f15639h = fG3;
        f15640i = Dp.g(Dp.g(f3) - fG3);
    }

    public static final float B() {
        return f15633b;
    }

    public static final TopAppBarState C(final float f3, final float f4, final float f5, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = -3.4028235E38f;
        }
        if ((i4 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 4) != 0) {
            f5 = 0.0f;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1801969826, i3, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1291)");
        }
        Object[] objArr = new Object[0];
        Saver saverA = TopAppBarState.f21553d.a();
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.c(f3)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.c(f4)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.c(f5)) || (i3 & 384) == 256);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<TopAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final TopAppBarState invoke() {
                    return new TopAppBarState(f3, f4, f5);
                }
            };
            composer.w(objG);
        }
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return topAppBarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object D(androidx.compose.material3.TopAppBarState r21, float r22, androidx.compose.animation.core.DecayAnimationSpec r23, androidx.compose.animation.core.AnimationSpec r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.D(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object E(androidx.compose.material3.BottomAppBarState r21, float r22, androidx.compose.animation.core.DecayAnimationSpec r23, androidx.compose.animation.core.AnimationSpec r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.E(androidx.compose.material3.BottomAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r24, long r25, long r27, float r29, androidx.compose.foundation.layout.PaddingValues r30, androidx.compose.foundation.layout.WindowInsets r31, final kotlin.jvm.functions.Function3 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.a(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final kotlin.jvm.functions.Function3 r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2 r29, long r30, long r32, float r34, androidx.compose.foundation.layout.PaddingValues r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.b(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(androidx.compose.ui.Modifier r35, long r36, long r38, float r40, androidx.compose.foundation.layout.PaddingValues r41, androidx.compose.foundation.layout.WindowInsets r42, androidx.compose.material3.BottomAppBarScrollBehavior r43, final kotlin.jvm.functions.Function3 r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.c(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final kotlin.jvm.functions.Function3 r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2 r29, long r30, long r32, float r34, androidx.compose.foundation.layout.PaddingValues r35, androidx.compose.foundation.layout.WindowInsets r36, androidx.compose.material3.BottomAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.d(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.BottomAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final BottomAppBarState e(float f3, float f4, float f5) {
        return new BottomAppBarStateImpl(f3, f4, f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void f(final kotlin.jvm.functions.Function2 r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2 r22, kotlin.jvm.functions.Function3 r23, androidx.compose.foundation.layout.WindowInsets r24, androidx.compose.material3.TopAppBarColors r25, androidx.compose.material3.TopAppBarScrollBehavior r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.f(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final kotlin.jvm.functions.Function2 r24, androidx.compose.ui.Modifier r25, kotlin.jvm.functions.Function2 r26, kotlin.jvm.functions.Function3 r27, float r28, androidx.compose.foundation.layout.WindowInsets r29, androidx.compose.material3.TopAppBarColors r30, androidx.compose.material3.TopAppBarScrollBehavior r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.g(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void h(final kotlin.jvm.functions.Function2 r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2 r23, kotlin.jvm.functions.Function3 r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.h(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(final kotlin.jvm.functions.Function2 r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function2 r31, kotlin.jvm.functions.Function3 r32, float r33, float r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 647
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.i(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void j(final kotlin.jvm.functions.Function2 r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2 r23, kotlin.jvm.functions.Function3 r24, androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.material3.TopAppBarColors r26, androidx.compose.material3.TopAppBarScrollBehavior r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.j(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final kotlin.jvm.functions.Function2 r29, androidx.compose.ui.Modifier r30, kotlin.jvm.functions.Function2 r31, kotlin.jvm.functions.Function3 r32, float r33, float r34, androidx.compose.foundation.layout.WindowInsets r35, androidx.compose.material3.TopAppBarColors r36, androidx.compose.material3.TopAppBarScrollBehavior r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 647
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.k(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(androidx.compose.ui.Modifier r31, final kotlin.jvm.functions.Function2 r32, final androidx.compose.ui.text.TextStyle r33, final boolean r34, final kotlin.jvm.functions.Function2 r35, final kotlin.jvm.functions.Function3 r36, final float r37, final androidx.compose.foundation.layout.WindowInsets r38, final androidx.compose.material3.TopAppBarColors r39, final androidx.compose.material3.TopAppBarScrollBehavior r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 713
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.l(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final long m(State state) {
        return ((Color) state.getValue()).B();
    }

    private static final float n(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void o(final kotlin.jvm.functions.Function2 r20, androidx.compose.ui.Modifier r21, kotlin.jvm.functions.Function2 r22, kotlin.jvm.functions.Function3 r23, androidx.compose.foundation.layout.WindowInsets r24, androidx.compose.material3.TopAppBarColors r25, androidx.compose.material3.TopAppBarScrollBehavior r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.o(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final Modifier modifier, final ScrolledOffset scrolledOffset, long j3, final long j4, final long j5, final Function2 function2, final TextStyle textStyle, final float f3, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final int i3, final boolean z2, final Function2 function22, final Function2 function23, Composer composer, final int i4, final int i5) {
        int i6;
        long j6;
        int i7;
        Composer composer2;
        Composer composerK = composer.k(-742442296);
        if ((i4 & 6) == 0) {
            i6 = (composerK.Z(modifier) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= (i4 & 64) == 0 ? composerK.Z(scrolledOffset) : composerK.I(scrolledOffset) ? 32 : 16;
        }
        int i8 = i4 & 384;
        int i9 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i8 == 0) {
            j6 = j3;
            i6 |= composerK.f(j6) ? 256 : 128;
        } else {
            j6 = j3;
        }
        int i10 = i6;
        if ((i4 & 3072) == 0) {
            i10 |= composerK.f(j4) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i10 |= composerK.f(j5) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i10 |= composerK.I(function2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i4 & 1572864) == 0) {
            i10 |= composerK.Z(textStyle) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i10 |= composerK.c(f3) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i10 |= composerK.Z(vertical) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i10 |= composerK.Z(horizontal) ? 536870912 : 268435456;
        }
        int i11 = i10;
        if ((i5 & 6) == 0) {
            i7 = i5 | (composerK.e(i3) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            if (composerK.I(function22)) {
                i9 = 256;
            }
            i7 |= i9;
        }
        if ((i5 & 3072) == 0) {
            i7 |= composerK.I(function23) ? 2048 : 1024;
        }
        int i12 = i7;
        if ((i11 & 306783379) == 306783378 && (i12 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-742442296, i11, i12, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2134)");
            }
            boolean z3 = ((i11 & 112) == 32 || ((i11 & 64) != 0 && composerK.I(scrolledOffset))) | ((1879048192 & i11) == 536870912) | ((234881024 & i11) == 67108864) | ((i12 & 14) == 4);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(final MeasureScope measureScope, List list, final long j7) {
                        int size = list.size();
                        for (int i13 = 0; i13 < size; i13++) {
                            Measurable measurable = (Measurable) list.get(i13);
                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "navigationIcon")) {
                                final Placeable placeableN0 = measurable.n0(Constraints.d(j7, 0, 0, 0, 0, 14, null));
                                int size2 = list.size();
                                for (int i14 = 0; i14 < size2; i14++) {
                                    Measurable measurable2 = (Measurable) list.get(i14);
                                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable2), "actionIcons")) {
                                        final Placeable placeableN02 = measurable2.n0(Constraints.d(j7, 0, 0, 0, 0, 14, null));
                                        int iL = Constraints.l(j7) == Integer.MAX_VALUE ? Constraints.l(j7) : RangesKt.f((Constraints.l(j7) - placeableN0.X0()) - placeableN02.X0(), 0);
                                        int size3 = list.size();
                                        for (int i15 = 0; i15 < size3; i15++) {
                                            Measurable measurable3 = (Measurable) list.get(i15);
                                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable3), "title")) {
                                                final Placeable placeableN03 = measurable3.n0(Constraints.d(j7, 0, iL, 0, 0, 12, null));
                                                final int iP0 = placeableN03.p0(AlignmentLineKt.b()) != Integer.MIN_VALUE ? placeableN03.p0(AlignmentLineKt.b()) : 0;
                                                float fA = scrolledOffset.a();
                                                final int iK = Constraints.k(j7) == Integer.MAX_VALUE ? Constraints.k(j7) : Constraints.k(j7) + (Float.isNaN(fA) ? 0 : MathKt.d(fA));
                                                int iL2 = Constraints.l(j7);
                                                final Arrangement.Horizontal horizontal2 = horizontal;
                                                final Arrangement.Vertical vertical2 = vertical;
                                                final int i16 = i3;
                                                return MeasureScope.B0(measureScope, iL2, iK, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((Placeable.PlacementScope) obj);
                                                        return Unit.f139807a;
                                                    }

                                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                                        int iL3;
                                                        int i17;
                                                        int iO0;
                                                        int iL4;
                                                        Placeable placeable = placeableN0;
                                                        Placeable.PlacementScope.m(placementScope, placeable, 0, (iK - placeable.O0()) / 2, 0.0f, 4, null);
                                                        Placeable placeable2 = placeableN03;
                                                        Arrangement.Horizontal horizontal3 = horizontal2;
                                                        Arrangement arrangement = Arrangement.f6574a;
                                                        if (Intrinsics.areEqual(horizontal3, arrangement.b())) {
                                                            iL3 = (Constraints.l(j7) - placeableN03.X0()) / 2;
                                                            if (iL3 < placeableN0.X0()) {
                                                                iL4 = placeableN0.X0() - iL3;
                                                            } else if (placeableN03.X0() + iL3 > Constraints.l(j7) - placeableN02.X0()) {
                                                                iL4 = (Constraints.l(j7) - placeableN02.X0()) - (placeableN03.X0() + iL3);
                                                            }
                                                            iL3 += iL4;
                                                        } else {
                                                            iL3 = Intrinsics.areEqual(horizontal3, arrangement.c()) ? (Constraints.l(j7) - placeableN03.X0()) - placeableN02.X0() : Math.max(measureScope.z0(AppBarKt.f15640i), placeableN0.X0());
                                                        }
                                                        int i18 = iL3;
                                                        Arrangement.Vertical vertical3 = vertical2;
                                                        if (Intrinsics.areEqual(vertical3, arrangement.b())) {
                                                            iO0 = (iK - placeableN03.O0()) / 2;
                                                        } else {
                                                            if (!Intrinsics.areEqual(vertical3, arrangement.a())) {
                                                                i17 = 0;
                                                                Placeable.PlacementScope.m(placementScope, placeable2, i18, i17, 0.0f, 4, null);
                                                                Placeable.PlacementScope.m(placementScope, placeableN02, Constraints.l(j7) - placeableN02.X0(), (iK - placeableN02.O0()) / 2, 0.0f, 4, null);
                                                            }
                                                            int i19 = i16;
                                                            if (i19 == 0) {
                                                                iO0 = iK - placeableN03.O0();
                                                            } else {
                                                                int iO02 = i19 - (placeableN03.O0() - iP0);
                                                                int iO03 = placeableN03.O0() + iO02;
                                                                if (iO03 > Constraints.k(j7)) {
                                                                    iO02 -= iO03 - Constraints.k(j7);
                                                                }
                                                                iO0 = (iK - placeableN03.O0()) - Math.max(0, iO02);
                                                            }
                                                        }
                                                        i17 = iO0;
                                                        Placeable.PlacementScope.m(placementScope, placeable2, i18, i17, 0.0f, 4, null);
                                                        Placeable.PlacementScope.m(placementScope, placeableN02, Constraints.l(j7) - placeableN02.X0(), (iK - placeableN02.O0()) / 2, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierB = LayoutIdKt.b(companion2, "navigationIcon");
            float f4 = f15639h;
            Modifier modifierM = PaddingKt.m(modifierB, f4, 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A2 = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG, companion.e());
            Updater.e(composerA2, compositionLocalMapU2, companion.g());
            Function2 function2B2 = companion.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ProvidedValue providedValueD = ContentColorKt.a().d(Color.n(j6));
            int i13 = ProvidedValue.f24012i;
            CompositionLocalKt.b(providedValueD, function22, composerK, ((i12 >> 3) & 112) | i13);
            composerK.y();
            Modifier modifierC = GraphicsLayerModifierKt.c(PaddingKt.k(LayoutIdKt.b(companion2, "title"), f4, 0.0f, 2, null).then(z2 ? SemanticsModifierKt.c(companion2, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.f139807a;
                }
            }) : companion2), 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC);
            Function0 function0A3 = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion.e());
            Updater.e(composerA3, compositionLocalMapU3, companion.g());
            Function2 function2B3 = companion.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion.f());
            int i14 = i11 >> 9;
            ProvideContentColorTextStyleKt.a(j4, textStyle, function2, composerK, (i14 & 14) | ((i11 >> 15) & 112) | (i14 & 896));
            composer2 = composerK;
            composer2.y();
            Modifier modifierM2 = PaddingKt.m(LayoutIdKt.b(companion2, "actionIcons"), 0.0f, 0.0f, f4, 0.0f, 11, null);
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion3.o(), false);
            int iA4 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU4 = composer2.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierM2);
            Function0 function0A4 = companion.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A4);
            } else {
                composer2.v();
            }
            Composer composerA4 = Updater.a(composer2);
            Updater.e(composerA4, measurePolicyG3, companion.e());
            Updater.e(composerA4, compositionLocalMapU4, companion.g());
            Function2 function2B4 = companion.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion.f());
            CompositionLocalKt.b(ContentColorKt.a().d(Color.n(j5)), function23, composer2, ((i12 >> 6) & 112) | i13);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final long j7 = j6;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i15) {
                    AppBarKt.q(modifier, scrolledOffset, j7, j4, j5, function2, textStyle, f3, vertical, horizontal, i3, z2, function22, function23, composer3, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(androidx.compose.ui.Modifier r40, final kotlin.jvm.functions.Function2 r41, final androidx.compose.ui.text.TextStyle r42, final float r43, final kotlin.jvm.functions.Function2 r44, final androidx.compose.ui.text.TextStyle r45, final kotlin.jvm.functions.Function2 r46, final kotlin.jvm.functions.Function3 r47, final float r48, final float r49, final androidx.compose.foundation.layout.WindowInsets r50, final androidx.compose.material3.TopAppBarColors r51, final androidx.compose.material3.TopAppBarScrollBehavior r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 875
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.r(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void p(final kotlin.jvm.functions.Function2 r24, androidx.compose.ui.Modifier r25, kotlin.jvm.functions.Function2 r26, kotlin.jvm.functions.Function3 r27, float r28, androidx.compose.foundation.layout.WindowInsets r29, androidx.compose.material3.TopAppBarColors r30, androidx.compose.material3.TopAppBarScrollBehavior r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.p(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }
}
