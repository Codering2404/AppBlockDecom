package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

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
public final class WindowInsetsPaddingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableModifierLocal f7273a = ModifierLocalKt.a(new Function0<WindowInsets>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$ModifierLocalConsumedWindowInsets$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final WindowInsets invoke() {
            return WindowInsetsKt.a(0, 0, 0, 0);
        }
    });

    public static final Modifier a(Modifier modifier, final WindowInsets windowInsets) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("consumeWindowInsets");
                inspectorInfo.b().c("insets", windowInsets);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$consumeWindowInsets$2
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(788931215);
                if (ComposerKt.M()) {
                    ComposerKt.U(788931215, i3, -1, "androidx.compose.foundation.layout.consumeWindowInsets.<anonymous> (WindowInsetsPadding.kt:100)");
                }
                boolean Z = composer.Z(windowInsets);
                WindowInsets windowInsets2 = windowInsets;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new UnionInsetsConsumingModifier(windowInsets2);
                    composer.w(objG);
                }
                UnionInsetsConsumingModifier unionInsetsConsumingModifier = (UnionInsetsConsumingModifier) objG;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return unionInsetsConsumingModifier;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    public static final ProvidableModifierLocal b() {
        return f7273a;
    }

    public static final Modifier c(Modifier modifier, final Function1 function1) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("onConsumedWindowInsetsChanged");
                inspectorInfo.b().c("block", function1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$2
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-1608161351);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1608161351, i3, -1, "androidx.compose.foundation.layout.onConsumedWindowInsetsChanged.<anonymous> (WindowInsetsPadding.kt:141)");
                }
                boolean Z = composer.Z(function1);
                Function1 function12 = function1;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new ConsumedInsetsModifier(function12);
                    composer.w(objG);
                }
                ConsumedInsetsModifier consumedInsetsModifier = (ConsumedInsetsModifier) objG;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return consumedInsetsModifier;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    public static final Modifier d(Modifier modifier, final WindowInsets windowInsets) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("windowInsetsPadding");
                inspectorInfo.b().c("insets", windowInsets);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.layout.WindowInsetsPaddingKt$windowInsetsPadding$2
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-1415685722);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1415685722, i3, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.kt:79)");
                }
                boolean Z = composer.Z(windowInsets);
                WindowInsets windowInsets2 = windowInsets;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new InsetsPaddingModifier(windowInsets2);
                    composer.w(objG);
                }
                InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) objG;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return insetsPaddingModifier;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }
}
