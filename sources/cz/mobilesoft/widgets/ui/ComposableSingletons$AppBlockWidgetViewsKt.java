package cz.mobilesoft.widgets.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
public final class ComposableSingletons$AppBlockWidgetViewsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$AppBlockWidgetViewsKt f134215a = new ComposableSingletons$AppBlockWidgetViewsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f134216b = ComposableLambdaKt.c(690944620, false, new Function2() { // from class: cz.mobilesoft.widgets.ui.x0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AppBlockWidgetViewsKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f134217c = ComposableLambdaKt.c(1472940444, false, new Function2() { // from class: cz.mobilesoft.widgets.ui.y0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AppBlockWidgetViewsKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1472940444, i3, -1, "cz.mobilesoft.widgets.ui.ComposableSingletons$AppBlockWidgetViewsKt.lambda$1472940444.<anonymous> (AppBlockWidgetViews.kt:610)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(690944620, i3, -1, "cz.mobilesoft.widgets.ui.ComposableSingletons$AppBlockWidgetViewsKt.lambda$690944620.<anonymous> (AppBlockWidgetViews.kt:67)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    public final Function2 c() {
        return f134217c;
    }

    public final Function2 d() {
        return f134216b;
    }
}
