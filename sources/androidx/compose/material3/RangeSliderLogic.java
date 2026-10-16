package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
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
final class RangeSliderLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RangeSliderState f19348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableInteractionSource f19349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableInteractionSource f19350c;

    public RangeSliderLogic(RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2) {
        this.f19348a = rangeSliderState;
        this.f19349b = mutableInteractionSource;
        this.f19350c = mutableInteractionSource2;
    }

    public final MutableInteractionSource a(boolean z2) {
        return z2 ? this.f19349b : this.f19350c;
    }

    public final void b(boolean z2, float f3, Interaction interaction, CoroutineScope coroutineScope) {
        RangeSliderState rangeSliderState = this.f19348a;
        rangeSliderState.x(z2, f3 - (z2 ? rangeSliderState.o() : rangeSliderState.n()));
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new RangeSliderLogic$captureThumb$1(this, z2, interaction, null), 3, null);
    }

    public final int c(float f3) {
        return Float.compare(Math.abs(this.f19348a.o() - f3), Math.abs(this.f19348a.n() - f3));
    }
}
