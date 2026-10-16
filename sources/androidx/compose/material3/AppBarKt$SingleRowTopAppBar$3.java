package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class AppBarKt$SingleRowTopAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WindowInsets f15753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f15754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TopAppBarScrollBehavior f15755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TopAppBarColors f15756d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f15757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ TextStyle f15758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f15759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function2 f15760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function2 f15761j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppBarKt$SingleRowTopAppBar$3(WindowInsets windowInsets, float f3, TopAppBarScrollBehavior topAppBarScrollBehavior, TopAppBarColors topAppBarColors, Function2 function2, TextStyle textStyle, boolean z2, Function2 function22, Function2 function23) {
        super(2);
        this.f15753a = windowInsets;
        this.f15754b = f3;
        this.f15755c = topAppBarScrollBehavior;
        this.f15756d = topAppBarColors;
        this.f15757f = function2;
        this.f15758g = textStyle;
        this.f15759h = z2;
        this.f15760i = function22;
        this.f15761j = function23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(TopAppBarScrollBehavior topAppBarScrollBehavior) {
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
            ComposerKt.U(-1943739546, i3, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1927)");
        }
        Modifier modifierK = SizeKt.k(ClipKt.b(WindowInsetsPaddingKt.d(Modifier.b8, this.f15753a)), 0.0f, this.f15754b, 1, null);
        boolean Z = composer.Z(this.f15755c);
        final TopAppBarScrollBehavior topAppBarScrollBehavior = this.f15755c;
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new ScrolledOffset() { // from class: androidx.compose.material3.a
                @Override // androidx.compose.material3.ScrolledOffset
                public final float a() {
                    return AppBarKt$SingleRowTopAppBar$3.d(topAppBarScrollBehavior);
                }
            };
            composer.w(objG);
        }
        ScrolledOffset scrolledOffset = (ScrolledOffset) objG;
        long jD = this.f15756d.d();
        long jE = this.f15756d.e();
        long jC = this.f15756d.c();
        Function2 function2 = this.f15757f;
        TextStyle textStyle = this.f15758g;
        Arrangement arrangement = Arrangement.f6574a;
        AppBarKt.q(modifierK, scrolledOffset, jD, jE, jC, function2, textStyle, 1.0f, arrangement.b(), this.f15759h ? arrangement.b() : arrangement.g(), 0, false, this.f15760i, this.f15761j, composer, 113246208, 3126);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
