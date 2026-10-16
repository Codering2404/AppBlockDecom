package cz.mobilesoft.coreblock.scene.dev_events;

import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.VectorResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$DevEventsActivityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$DevEventsActivityKt f101641a = new ComposableSingletons$DevEventsActivityKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f101642b = ComposableLambdaKt.c(177257537, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dev_events.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DevEventsActivityKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f101643c = ComposableLambdaKt.c(-1082545800, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dev_events.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DevEventsActivityKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f101644d = ComposableLambdaKt.c(1493895562, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dev_events.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DevEventsActivityKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1493895562, i3, -1, "cz.mobilesoft.coreblock.scene.dev_events.ComposableSingletons$DevEventsActivityKt.lambda$1493895562.<anonymous> (DevEventsActivity.kt:153)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G1, composer, 6), null, null, 0L, composer, 48, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(177257537, i3, -1, "cz.mobilesoft.coreblock.scene.dev_events.ComposableSingletons$DevEventsActivityKt.lambda$177257537.<anonymous> (DevEventsActivity.kt:83)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G1, composer, 6), null, null, 0L, composer, 48, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1082545800, i3, -1, "cz.mobilesoft.coreblock.scene.dev_events.ComposableSingletons$DevEventsActivityKt.lambda$-1082545800.<anonymous> (DevEventsActivity.kt:92)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.y6, composer, 6), null, null, ComposeColorsKt.j(composer, 0).p0(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 d() {
        return f101643c;
    }

    public final Function2 e() {
        return f101644d;
    }

    public final Function2 f() {
        return f101642b;
    }
}
