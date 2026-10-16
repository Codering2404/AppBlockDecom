package cz.mobilesoft.coreblock.util.paywalltrace;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.paywalltrace.ComposableSingletons$PaywallTraceAttachmentKt;
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
public final class ComposableSingletons$PaywallTraceAttachmentKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$PaywallTraceAttachmentKt f128962a = new ComposableSingletons$PaywallTraceAttachmentKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f128963b = ComposableLambdaKt.c(542757902, false, new Function2() { // from class: i2.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PaywallTraceAttachmentKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f128964c = ComposableLambdaKt.c(-660478499, false, new Function2() { // from class: i2.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PaywallTraceAttachmentKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(542757902, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.ComposableSingletons$PaywallTraceAttachmentKt.lambda$542757902.<anonymous> (PaywallTraceAttachment.kt:69)");
            }
            PaywallTraceOverlayKt.I(null, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-660478499, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.ComposableSingletons$PaywallTraceAttachmentKt.lambda$-660478499.<anonymous> (PaywallTraceAttachment.kt:68)");
            }
            ComposeThemesKt.b(null, f128963b, composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 c() {
        return f128964c;
    }
}
