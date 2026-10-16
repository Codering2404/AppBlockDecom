package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class RippleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f19381a = CompositionLocalKt.g(new Function0<Boolean>() { // from class: androidx.compose.material3.RippleKt$LocalUseFallbackRippleImplementation$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f19382b = CompositionLocalKt.e(null, new Function0<RippleConfiguration>() { // from class: androidx.compose.material3.RippleKt$LocalRippleConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final RippleConfiguration invoke() {
            return new RippleConfiguration(0L, null, 3, null);
        }
    }, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RippleNodeFactory f19383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final RippleNodeFactory f19384d;

    static {
        Dp.Companion companion = Dp.f29970b;
        float fC = companion.c();
        Color.Companion companion2 = Color.f25715b;
        f19383c = new RippleNodeFactory(true, fC, companion2.k(), (DefaultConstructorMarker) null);
        f19384d = new RippleNodeFactory(false, companion.c(), companion2.k(), (DefaultConstructorMarker) null);
    }

    public static final ProvidableCompositionLocal a() {
        return f19382b;
    }

    public static final IndicationNodeFactory b(boolean z2, float f3, long j3) {
        return (Dp.i(f3, Dp.f29970b.c()) && Color.t(j3, Color.f25715b.k())) ? z2 ? f19383c : f19384d : new RippleNodeFactory(z2, f3, j3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IndicationNodeFactory c(boolean z2, float f3, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        if ((i3 & 2) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 4) != 0) {
            j3 = Color.f25715b.k();
        }
        return b(z2, f3, j3);
    }

    public static final Indication d(boolean z2, float f3, long j3, Composer composer, int i3, int i4) {
        Composer composer2;
        Indication indicationB;
        if ((i4 & 1) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i4 & 2) != 0) {
            f3 = Dp.f29970b.c();
        }
        float f4 = f3;
        if ((i4 & 4) != 0) {
            j3 = Color.f25715b.k();
        }
        long j4 = j3;
        if (ComposerKt.M()) {
            ComposerKt.U(-1315814667, i3, -1, "androidx.compose.material3.rippleOrFallbackImplementation (Ripple.kt:230)");
        }
        composer.a0(-1280632857);
        if (((Boolean) composer.q(f19381a)).booleanValue()) {
            composer2 = composer;
            indicationB = androidx.compose.material.ripple.RippleKt.f(z3, f4, j4, composer2, i3 & 1022, 0);
        } else {
            composer2 = composer;
            indicationB = b(z3, f4, j4);
        }
        composer2.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return indicationB;
    }
}
