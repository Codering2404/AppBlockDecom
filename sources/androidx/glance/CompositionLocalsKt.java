package androidx.glance;

import android.content.Context;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.color.ColorProviders;
import androidx.glance.color.DynamicThemeColorProviders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CompositionLocalsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f37581a = CompositionLocalKt.g(new Function0<DpSize>() { // from class: androidx.glance.CompositionLocalsKt$LocalSize$1
        public final long c() {
            throw new IllegalStateException("No default size");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return DpSize.c(c());
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f37582b = CompositionLocalKt.g(new Function0<Context>() { // from class: androidx.glance.CompositionLocalsKt$LocalContext$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Context invoke() {
            throw new IllegalStateException("No default context");
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ProvidableCompositionLocal f37583c = CompositionLocalKt.e(null, new Function0<Object>() { // from class: androidx.glance.CompositionLocalsKt$LocalState$1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return null;
        }
    }, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ProvidableCompositionLocal f37584d = CompositionLocalKt.g(new Function0<GlanceId>() { // from class: androidx.glance.CompositionLocalsKt$LocalGlanceId$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final GlanceId invoke() {
            throw new IllegalStateException("No default glance id");
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ProvidableCompositionLocal f37585e = CompositionLocalKt.g(new Function0<ColorProviders>() { // from class: androidx.glance.CompositionLocalsKt$LocalColors$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ColorProviders invoke() {
            return DynamicThemeColorProviders.B;
        }
    });

    public static final ProvidableCompositionLocal a() {
        return f37585e;
    }

    public static final ProvidableCompositionLocal b() {
        return f37582b;
    }

    public static final ProvidableCompositionLocal c() {
        return f37584d;
    }

    public static final ProvidableCompositionLocal d() {
        return f37581a;
    }

    public static final ProvidableCompositionLocal e() {
        return f37583c;
    }
}
