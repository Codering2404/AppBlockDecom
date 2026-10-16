package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.KeyframesSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class PropertyValuesHolderFloat extends PropertyValuesHolder1D<Float> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f4438b;

    public PropertyValuesHolderFloat(String str, List list) {
        super(str, null);
        this.f4438b = list;
    }

    public final KeyframesSpec b(final int i3) {
        return AnimationSpecKt.f(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.animation.graphics.vector.PropertyValuesHolderFloat$asKeyframeSpec$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
                keyframesSpecConfig.d(i3);
                List listC = this.c();
                int i4 = i3;
                int size = listC.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Keyframe keyframe = (Keyframe) listC.get(i5);
                    keyframesSpecConfig.e(keyframesSpecConfig.f(keyframe.c(), (int) (i4 * keyframe.a())), keyframe.b());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((KeyframesSpec.KeyframesSpecConfig) obj);
                return Unit.f139807a;
            }
        });
    }

    public List c() {
        return this.f4438b;
    }
}
