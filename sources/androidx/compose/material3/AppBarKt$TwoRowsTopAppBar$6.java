package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

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
final class AppBarKt$TwoRowsTopAppBar$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WindowInsets f15833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f15834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TopAppBarColors f15835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f15836d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TextStyle f15837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f15838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f15839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function2 f15840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function2 f15841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ float f15842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ TopAppBarScrollBehavior f15843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Function2 f15844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ TextStyle f15845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ float f15846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f15847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ boolean f15848q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$6(WindowInsets windowInsets, float f3, TopAppBarColors topAppBarColors, Function2 function2, TextStyle textStyle, float f4, boolean z2, Function2 function22, Function2 function23, float f5, TopAppBarScrollBehavior topAppBarScrollBehavior, Function2 function24, TextStyle textStyle2, float f6, Ref.IntRef intRef, boolean z3) {
        super(2);
        this.f15833a = windowInsets;
        this.f15834b = f3;
        this.f15835c = topAppBarColors;
        this.f15836d = function2;
        this.f15837f = textStyle;
        this.f15838g = f4;
        this.f15839h = z2;
        this.f15840i = function22;
        this.f15841j = function23;
        this.f15842k = f5;
        this.f15843l = topAppBarScrollBehavior;
        this.f15844m = function24;
        this.f15845n = textStyle2;
        this.f15846o = f6;
        this.f15847p = intRef;
        this.f15848q = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float e() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(TopAppBarScrollBehavior topAppBarScrollBehavior) {
        TopAppBarState state;
        if (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.d();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }

    public final void invoke(Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1350062619, i3, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:2043)");
        }
        WindowInsets windowInsets = this.f15833a;
        float f3 = this.f15834b;
        TopAppBarColors topAppBarColors = this.f15835c;
        Function2 function2 = this.f15836d;
        TextStyle textStyle = this.f15837f;
        float f4 = this.f15838g;
        boolean z2 = this.f15839h;
        Function2 function22 = this.f15840i;
        Function2 function23 = this.f15841j;
        float f5 = this.f15842k;
        final TopAppBarScrollBehavior topAppBarScrollBehavior = this.f15843l;
        Function2 function24 = this.f15844m;
        TextStyle textStyle2 = this.f15845n;
        float f6 = this.f15846o;
        Ref.IntRef intRef = this.f15847p;
        boolean z3 = this.f15848q;
        Modifier.Companion companion = Modifier.b8;
        Arrangement arrangement = Arrangement.f6574a;
        MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), Alignment.f25072a.k(), composer, 0);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, companion);
        ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
        Function0 function0A = companion2.a();
        if (composer.m() == null) {
            ComposablesKt.c();
        }
        composer.L();
        if (composer.i()) {
            composer.P(function0A);
        } else {
            composer.v();
        }
        Composer composerA = Updater.a(composer);
        Updater.e(composerA, measurePolicyA, companion2.e());
        Updater.e(composerA, compositionLocalMapU, companion2.g());
        Function2 function2B = companion2.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion2.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        AppBarKt.q(SizeKt.k(ClipKt.b(WindowInsetsPaddingKt.d(companion, windowInsets)), 0.0f, f3, 1, null), new ScrolledOffset() { // from class: androidx.compose.material3.b
            @Override // androidx.compose.material3.ScrolledOffset
            public final float a() {
                return AppBarKt$TwoRowsTopAppBar$6.e();
            }
        }, topAppBarColors.d(), topAppBarColors.e(), topAppBarColors.c(), function2, textStyle, f4, arrangement.b(), arrangement.g(), 0, z2, function22, function23, composer, 905969712, 3078);
        Modifier modifierK = SizeKt.k(ClipKt.b(WindowInsetsPaddingKt.d(companion, WindowInsetsKt.i(windowInsets, WindowInsetsSides.f7284b.g()))), 0.0f, Dp.g(f5 - f3), 1, null);
        boolean Z = composer.Z(topAppBarScrollBehavior);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new ScrolledOffset() { // from class: androidx.compose.material3.c
                @Override // androidx.compose.material3.ScrolledOffset
                public final float a() {
                    return AppBarKt$TwoRowsTopAppBar$6.h(topAppBarScrollBehavior);
                }
            };
            composer.w(objG);
        }
        long jD = topAppBarColors.d();
        long jE = topAppBarColors.e();
        long jC = topAppBarColors.c();
        Arrangement.Vertical verticalA = arrangement.a();
        Arrangement.Horizontal horizontalG = arrangement.g();
        int i4 = intRef.f140142a;
        ComposableSingletons$AppBarKt composableSingletons$AppBarKt = ComposableSingletons$AppBarKt.f16673a;
        AppBarKt.q(modifierK, (ScrolledOffset) objG, jD, jE, jC, function24, textStyle2, f6, verticalA, horizontalG, i4, z3, composableSingletons$AppBarKt.i(), composableSingletons$AppBarKt.j(), composer, 905969664, 3456);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
