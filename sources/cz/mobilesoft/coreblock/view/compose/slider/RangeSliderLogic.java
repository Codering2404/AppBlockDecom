package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class RangeSliderLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableInteractionSource f132029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableInteractionSource f132030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final State f132031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final State f132032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final State f132033e;

    public RangeSliderLogic(MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State rawOffsetStart, State rawOffsetEnd, State onDrag) {
        Intrinsics.checkNotNullParameter(startInteractionSource, "startInteractionSource");
        Intrinsics.checkNotNullParameter(endInteractionSource, "endInteractionSource");
        Intrinsics.checkNotNullParameter(rawOffsetStart, "rawOffsetStart");
        Intrinsics.checkNotNullParameter(rawOffsetEnd, "rawOffsetEnd");
        Intrinsics.checkNotNullParameter(onDrag, "onDrag");
        this.f132029a = startInteractionSource;
        this.f132030b = endInteractionSource;
        this.f132031c = rawOffsetStart;
        this.f132032d = rawOffsetEnd;
        this.f132033e = onDrag;
    }

    public final MutableInteractionSource a(boolean z2) {
        return z2 ? this.f132029a : this.f132030b;
    }

    public final void b(boolean z2, float f3, Interaction interaction, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        ((Function2) this.f132033e.getValue()).invoke(Boolean.valueOf(z2), Float.valueOf(f3 - ((Number) (z2 ? this.f132031c : this.f132032d).getValue()).floatValue()));
        BuildersKt__Builders_commonKt.d(scope, null, null, new RangeSliderLogic$captureThumb$1(this, z2, interaction, null), 3, null);
    }

    public final int c(float f3) {
        return Float.compare(Math.abs(((Number) this.f132031c.getValue()).floatValue() - f3), Math.abs(((Number) this.f132032d.getValue()).floatValue() - f3));
    }
}
