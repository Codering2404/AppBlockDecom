package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class LazyLayoutScrollDeltaBetweenPasses {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimationState f8175a;

    public LazyLayoutScrollDeltaBetweenPasses() {
        TwoWayConverter twoWayConverterI = VectorConvertersKt.i(FloatCompanionObject.f140130a);
        Float fValueOf = Float.valueOf(0.0f);
        this.f8175a = AnimationStateKt.d(twoWayConverterI, fValueOf, fValueOf, 0L, 0L, false, 56, null);
    }

    public final float b() {
        return ((Number) this.f8175a.getValue()).floatValue();
    }

    public final void c(float f3, Density density, CoroutineScope coroutineScope) {
        if (f3 <= density.M1(LazyLayoutScrollDeltaBetweenPassesKt.f8180a)) {
            return;
        }
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            float fFloatValue = ((Number) this.f8175a.getValue()).floatValue();
            if (this.f8175a.r()) {
                this.f8175a = AnimationStateKt.g(this.f8175a, fFloatValue - f3, 0.0f, 0L, 0L, false, 30, null);
                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new LazyLayoutScrollDeltaBetweenPasses$updateScrollDeltaForApproach$2$1(this, null), 3, null);
            } else {
                this.f8175a = new AnimationState(VectorConvertersKt.i(FloatCompanionObject.f140130a), Float.valueOf(-f3), null, 0L, 0L, false, 60, null);
                BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new LazyLayoutScrollDeltaBetweenPasses$updateScrollDeltaForApproach$2$2(this, null), 3, null);
            }
            companion.m(snapshotD, snapshotE, function1G);
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }
}
