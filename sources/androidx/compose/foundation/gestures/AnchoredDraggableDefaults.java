package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class AnchoredDraggableDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnchoredDraggableDefaults f5370a = new AnchoredDraggableDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AnimationSpec f5371b = AnimationSpecKt.n(0, 0, null, 7, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function1 f5372c = new Function1<Float, Float>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableDefaults$PositionalThreshold$1
        public final Float c(float f3) {
            return Float.valueOf(f3 / 2.0f);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).floatValue());
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DecayAnimationSpec f5373d = DecayAnimationSpecKt.c(0.0f, 0.0f, 3, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5374e = 8;

    private AnchoredDraggableDefaults() {
    }

    public final DecayAnimationSpec a() {
        return f5373d;
    }

    public final Function1 b() {
        return f5372c;
    }

    public final AnimationSpec c() {
        return f5371b;
    }
}
