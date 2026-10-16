package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SearchBar_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TextFieldColors f19508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f19509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f19510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f19511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f19512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f19513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f19514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f19515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f19516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final CubicBezierEasing f19517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final CubicBezierEasing f19518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final FiniteAnimationSpec f19519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final FiniteAnimationSpec f19520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final FiniteAnimationSpec f19521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final FiniteAnimationSpec f19522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final FiniteAnimationSpec f19523p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final EnterTransition f19524q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ExitTransition f19525r;

    static {
        Color.Companion companion = Color.f25715b;
        f19508a = new TextFieldColors(companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), new TextSelectionColors(companion.k(), companion.k(), null), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), companion.k(), null);
        f19509b = Dp.g(SearchBarDefaults.f19467a.e() / 2);
        f19510c = Dp.g(240);
        f19511d = Dp.g(360);
        f19512e = Dp.g(720);
        float f3 = 8;
        f19513f = Dp.g(f3);
        f19514g = Dp.g(4);
        f19515h = Dp.g(f3);
        f19516i = Dp.g(24);
        CubicBezierEasing cubicBezierEasingB = MotionTokens.f22946a.b();
        f19517j = cubicBezierEasingB;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        f19518k = cubicBezierEasing;
        TweenSpec tweenSpecM = AnimationSpecKt.m(600, 100, cubicBezierEasingB);
        f19519l = tweenSpecM;
        TweenSpec tweenSpecM2 = AnimationSpecKt.m(350, 100, cubicBezierEasing);
        f19520m = tweenSpecM2;
        f19521n = AnimationSpecKt.n(350, 0, cubicBezierEasing, 2, null);
        TweenSpec tweenSpecM3 = AnimationSpecKt.m(600, 100, cubicBezierEasingB);
        f19522o = tweenSpecM3;
        TweenSpec tweenSpecM4 = AnimationSpecKt.m(350, 100, cubicBezierEasing);
        f19523p = tweenSpecM4;
        f19524q = EnterExitTransitionKt.o(tweenSpecM, 0.0f, 2, null).c(EnterExitTransitionKt.m(tweenSpecM3, null, false, null, 14, null));
        f19525r = EnterExitTransitionKt.q(tweenSpecM2, 0.0f, 2, null).c(EnterExitTransitionKt.A(tweenSpecM4, null, false, null, 14, null));
    }

    public static final float A() {
        return f19511d;
    }

    public static final float B() {
        return f19513f;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final kotlin.jvm.functions.Function2 r26, final boolean r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.material3.SearchBarColors r31, float r32, float r33, final kotlin.jvm.functions.Function3 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.a(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final java.lang.String r34, final kotlin.jvm.functions.Function1 r35, final kotlin.jvm.functions.Function1 r36, final boolean r37, final kotlin.jvm.functions.Function1 r38, androidx.compose.ui.Modifier r39, boolean r40, kotlin.jvm.functions.Function2 r41, kotlin.jvm.functions.Function2 r42, kotlin.jvm.functions.Function2 r43, androidx.compose.ui.graphics.Shape r44, androidx.compose.material3.SearchBarColors r45, float r46, float r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, final kotlin.jvm.functions.Function3 r49, androidx.compose.runtime.Composer r50, final int r51, final int r52, final int r53) {
        /*
            Method dump skipped, instruction units count: 917
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.b(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final java.lang.String r35, final kotlin.jvm.functions.Function1 r36, final kotlin.jvm.functions.Function1 r37, final boolean r38, final kotlin.jvm.functions.Function1 r39, androidx.compose.ui.Modifier r40, boolean r41, kotlin.jvm.functions.Function2 r42, kotlin.jvm.functions.Function2 r43, kotlin.jvm.functions.Function2 r44, androidx.compose.ui.graphics.Shape r45, androidx.compose.material3.SearchBarColors r46, float r47, float r48, androidx.compose.foundation.layout.WindowInsets r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, final kotlin.jvm.functions.Function3 r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instruction units count: 971
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.c(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0104  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final kotlin.jvm.functions.Function2 r29, final boolean r30, final kotlin.jvm.functions.Function1 r31, androidx.compose.ui.Modifier r32, androidx.compose.ui.graphics.Shape r33, androidx.compose.material3.SearchBarColors r34, float r35, float r36, androidx.compose.foundation.layout.WindowInsets r37, final kotlin.jvm.functions.Function3 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.d(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final androidx.compose.animation.core.Animatable r27, final androidx.compose.runtime.MutableFloatState r28, final androidx.compose.runtime.MutableState r29, final androidx.compose.runtime.MutableState r30, androidx.compose.ui.Modifier r31, final kotlin.jvm.functions.Function2 r32, androidx.compose.ui.graphics.Shape r33, androidx.compose.material3.SearchBarColors r34, float r35, float r36, androidx.compose.foundation.layout.WindowInsets r37, final kotlin.jvm.functions.Function3 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 925
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.e(androidx.compose.animation.core.Animatable, androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final boolean f(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean g(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final Animatable animatable, final MutableFloatState mutableFloatState, final MutableState mutableState, final MutableState mutableState2, final Modifier modifier, final WindowInsets windowInsets, final Function2 function2, final Function2 function22, final Function2 function23, Composer composer, final int i3) {
        int i4;
        final MutableFloatState mutableFloatState2;
        MutableState mutableState3;
        MutableState mutableState4;
        int i5;
        Composer composerK = composer.k(70029564);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(animatable) : composerK.I(animatable) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            mutableFloatState2 = mutableFloatState;
            i4 |= composerK.Z(mutableFloatState2) ? 32 : 16;
        } else {
            mutableFloatState2 = mutableFloatState;
        }
        if ((i3 & 384) == 0) {
            mutableState3 = mutableState;
            i4 |= composerK.Z(mutableState3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            mutableState3 = mutableState;
        }
        if ((i3 & 3072) == 0) {
            mutableState4 = mutableState2;
            i4 |= composerK.Z(mutableState4) ? 2048 : 1024;
        } else {
            mutableState4 = mutableState2;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(modifier) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(windowInsets) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(function22) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.I(function23) ? 67108864 : 33554432;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(70029564, i4, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:941)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new MutableWindowInsets(null, 1, null);
                composerK.w(objG);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) objG;
            Modifier modifierA = ZIndexModifierKt.a(modifier, 1.0f);
            boolean z2 = (i4 & 458752) == 131072;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(WindowInsets windowInsets2) {
                        mutableWindowInsets.f(WindowInsetsKt.h(windowInsets, windowInsets2));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((WindowInsets) obj);
                        return Unit.f139807a;
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierA2 = WindowInsetsPaddingKt.a(WindowInsetsPaddingKt.c(modifierA, (Function1) objG2), windowInsets);
            boolean z3 = ((i4 & 7168) == 2048) | ((i4 & 14) == 4 || ((i4 & 8) != 0 && composerK.I(animatable))) | ((i4 & 112) == 32) | ((i4 & 896) == 256);
            Object objG3 = composerK.G();
            if (z3 || objG3 == companion.a()) {
                final MutableState mutableState5 = mutableState3;
                final MutableState mutableState6 = mutableState4;
                i5 = i4;
                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(final MeasureScope measureScope, List list, final long j3) {
                        Object obj;
                        final Placeable placeableN0;
                        int i6;
                        int iK;
                        MeasureScope measureScope2 = measureScope;
                        long j4 = j3;
                        final float fFloatValue = ((Number) animatable.n()).floatValue();
                        int size = list.size();
                        int i7 = 0;
                        while (i7 < size) {
                            Measurable measurable = (Measurable) list.get(i7);
                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "InputField")) {
                                int size2 = list.size();
                                int i8 = 0;
                                while (i8 < size2) {
                                    Measurable measurable2 = (Measurable) list.get(i8);
                                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable2), "Surface")) {
                                        int size3 = list.size();
                                        int i9 = 0;
                                        while (true) {
                                            if (i9 >= size3) {
                                                obj = null;
                                                break;
                                            }
                                            obj = list.get(i9);
                                            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj), "Content")) {
                                                break;
                                            }
                                            i9++;
                                        }
                                        Measurable measurable3 = (Measurable) obj;
                                        final int iA = mutableWindowInsets.a(measureScope2) + measureScope2.z0(SearchBar_androidKt.B());
                                        int iZ0 = measureScope2.z0(SearchBar_androidKt.B());
                                        int iG = ConstraintsKt.g(j4, measurable.l0(Constraints.k(j4)));
                                        int iF = ConstraintsKt.f(j4, measurable.d0(Constraints.l(j4)));
                                        int iD = MathKt.d(Constraints.l(j4) * 0.9f);
                                        int iD2 = MathKt.d(Constraints.k(j4) * 0.9f);
                                        final float fW = SearchBar_androidKt.w((BackEventCompat) mutableState6.getValue(), fFloatValue, mutableFloatState2.c());
                                        int iC = MathHelpersKt.c(iG, iD, fW);
                                        int i10 = iA + iF;
                                        int iC2 = MathHelpersKt.c(i10, iD2, fW);
                                        int iL = Constraints.l(j4);
                                        int iK2 = Constraints.k(j4);
                                        int iC3 = MathHelpersKt.c(iC, iL, fFloatValue);
                                        final int iC4 = MathHelpersKt.c(iC2, iK2, fFloatValue);
                                        final int iC5 = MathHelpersKt.c(iA, 0, fFloatValue);
                                        final int iC6 = MathHelpersKt.c(0, iZ0, fFloatValue);
                                        final Placeable placeableN02 = measurable.n0(ConstraintsKt.a(iC3, iL, iF, iF));
                                        int iX0 = placeableN02.X0();
                                        final Placeable placeableN03 = measurable2.n0(Constraints.f29963b.c(iX0, iC4 - iC5));
                                        if (measurable3 != null) {
                                            if (Constraints.g(j3)) {
                                                i6 = 0;
                                                iK = RangesKt.f(Constraints.k(j3) - (i10 + iZ0), 0);
                                            } else {
                                                i6 = 0;
                                                iK = Constraints.k(j3);
                                            }
                                            placeableN0 = measurable3.n0(ConstraintsKt.a(iX0, iX0, i6, iK));
                                        } else {
                                            placeableN0 = null;
                                        }
                                        final MutableState mutableState7 = mutableState6;
                                        final MutableState mutableState8 = mutableState5;
                                        return MeasureScope.B0(measureScope, iX0, iC4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                invoke((Placeable.PlacementScope) obj2);
                                                return Unit.f139807a;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                int iZ02 = measureScope.z0(SearchBar_androidKt.f19515h);
                                                int iX = SearchBar_androidKt.x(j3, iZ02, (BackEventCompat) mutableState7.getValue(), measureScope.getLayoutDirection(), fFloatValue, fW);
                                                int iY = SearchBar_androidKt.y(j3, iZ02, (BackEventCompat) mutableState7.getValue(), (BackEventCompat) mutableState8.getValue(), iC4, measureScope.z0(SearchBar_androidKt.f19516i), fW);
                                                Placeable.PlacementScope.m(placementScope, placeableN03, iX, iY + iC5, 0.0f, 4, null);
                                                Placeable.PlacementScope.m(placementScope, placeableN02, iX, iY + iA, 0.0f, 4, null);
                                                Placeable placeable = placeableN0;
                                                if (placeable != null) {
                                                    Placeable.PlacementScope.m(placementScope, placeable, iX, iY + iA + placeableN02.O0() + iC6, 0.0f, 4, null);
                                                }
                                            }
                                        }, 4, null);
                                    }
                                    i8++;
                                    measureScope2 = measureScope;
                                    j4 = j3;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i7++;
                            measureScope2 = measureScope;
                            j4 = j3;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerK.w(measurePolicy);
                objG3 = measurePolicy;
            } else {
                i5 = i4;
            }
            MeasurePolicy measurePolicy2 = (MeasurePolicy) objG3;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicy2, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierB = LayoutIdKt.b(companion3, "Surface");
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion4.o(), true);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierB);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyG, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function22.invoke(composerK, Integer.valueOf((i5 >> 21) & 14));
            composerK.y();
            Modifier modifierB2 = LayoutIdKt.b(companion3, "InputField");
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion4.o(), true);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB2);
            Function0 function0A3 = companion2.a();
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
            Updater.e(composerA3, measurePolicyG2, companion2.e());
            Updater.e(composerA3, compositionLocalMapU3, companion2.g());
            Function2 function2B3 = companion2.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion2.f());
            function2.invoke(composerK, Integer.valueOf((i5 >> 18) & 14));
            composerK.y();
            composerK.a0(-1107184481);
            if (function23 != null) {
                Modifier modifierB3 = LayoutIdKt.b(companion3, "Content");
                MeasurePolicy measurePolicyG3 = BoxKt.g(companion4.o(), true);
                int iA4 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU4 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierB3);
                Function0 function0A4 = companion2.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A4);
                } else {
                    composerK.v();
                }
                Composer composerA4 = Updater.a(composerK);
                Updater.e(composerA4, measurePolicyG3, companion2.e());
                Updater.e(composerA4, compositionLocalMapU4, companion2.g());
                Function2 function2B4 = companion2.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion2.f());
                function23.invoke(composerK, 0);
                composerK.y();
                Unit unit = Unit.f139807a;
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    SearchBar_androidKt.h(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float w(BackEventCompat backEventCompat, float f3, float f4) {
        if (backEventCompat == null) {
            return 0.0f;
        }
        if (Float.isNaN(f4)) {
            return 1.0f;
        }
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        return f3 / f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(long j3, int i3, BackEventCompat backEventCompat, LayoutDirection layoutDirection, float f3, float f4) {
        if (backEventCompat == null || f4 == 0.0f) {
            return 0;
        }
        return MathKt.d(((Constraints.l(j3) * 0.05f) - i3) * (1 - f3) * f4 * (backEventCompat.b() == 0 ? 1 : -1) * (layoutDirection == LayoutDirection.f30001a ? 1 : -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int y(long j3, int i3, BackEventCompat backEventCompat, BackEventCompat backEventCompat2, int i4, int i5, float f3) {
        if (backEventCompat2 == null || backEventCompat == null || f3 == 0.0f) {
            return 0;
        }
        int iMin = Math.min(Math.max(0, ((Constraints.k(j3) - i4) / 2) - i3), i5);
        float fC = backEventCompat.c() - backEventCompat2.c();
        float fAbs = Math.abs(fC) / Constraints.k(j3);
        return MathKt.d(MathHelpersKt.c(0, iMin, fAbs) * f3 * Math.signum(fC));
    }

    public static final float z() {
        return f19510c;
    }
}
