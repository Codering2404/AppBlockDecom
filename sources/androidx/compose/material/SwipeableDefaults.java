package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
@Deprecated
@Metadata
public final class SwipeableDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SwipeableDefaults f14296a = new SwipeableDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SpringSpec f14297b = new SpringSpec(0.0f, 0.0f, null, 7, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f14298c = Dp.g(125);

    private SwipeableDefaults() {
    }

    public static /* synthetic */ ResistanceConfig d(SwipeableDefaults swipeableDefaults, Set set, float f3, float f4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f3 = 10.0f;
        }
        if ((i3 & 4) != 0) {
            f4 = 10.0f;
        }
        return swipeableDefaults.c(set, f3, f4);
    }

    public final SpringSpec a() {
        return f14297b;
    }

    public final float b() {
        return f14298c;
    }

    public final ResistanceConfig c(Set set, float f3, float f4) {
        if (set.size() <= 1) {
            return null;
        }
        Set set2 = set;
        Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) set2);
        Intrinsics.checkNotNull(fMaxOrNull);
        float fFloatValue = fMaxOrNull.floatValue();
        Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) set2);
        Intrinsics.checkNotNull(fMinOrNull);
        return new ResistanceConfig(fFloatValue - fMinOrNull.floatValue(), f3, f4);
    }
}
