package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatMode;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
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
@Metadata
public final class Timestamp<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RepeatMode f4464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PropertyValuesHolder f4465e;

    public Timestamp(int i3, int i4, int i5, RepeatMode repeatMode, PropertyValuesHolder propertyValuesHolder) {
        this.f4461a = i3;
        this.f4462b = i4;
        this.f4463c = i5;
        this.f4464d = repeatMode;
        this.f4465e = propertyValuesHolder;
    }

    public final FiniteAnimationSpec a() {
        KeyframesSpec keyframesSpecB;
        PropertyValuesHolder propertyValuesHolder = this.f4465e;
        if (propertyValuesHolder instanceof PropertyValuesHolderFloat) {
            keyframesSpecB = ((PropertyValuesHolderFloat) propertyValuesHolder).b(this.f4462b);
        } else {
            if (!(propertyValuesHolder instanceof PropertyValuesHolderColor)) {
                throw new RuntimeException("Unexpected value type: " + this.f4465e);
            }
            keyframesSpecB = ((PropertyValuesHolderColor) propertyValuesHolder).b(this.f4462b);
        }
        KeyframesSpec keyframesSpec = keyframesSpecB;
        Intrinsics.checkNotNull(keyframesSpec, "null cannot be cast to non-null type androidx.compose.animation.core.KeyframesSpec<T of androidx.compose.animation.graphics.vector.Timestamp>");
        int i3 = this.f4463c;
        if (i3 == 0) {
            return keyframesSpec;
        }
        return AnimationSpecKt.h(i3 == -1 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i3 + 1, keyframesSpec, this.f4464d, 0L, 8, null);
    }

    public final int b() {
        return this.f4462b;
    }

    public final PropertyValuesHolder c() {
        return this.f4465e;
    }

    public final int d() {
        return this.f4463c;
    }

    public final RepeatMode e() {
        return this.f4464d;
    }

    public final int f() {
        return this.f4461a;
    }
}
