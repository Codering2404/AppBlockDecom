package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.Pair;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class KeyframesWithSplineSpec<T> implements DurationBasedAnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyframesWithSplineSpecConfig f4013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4014b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class KeyframesWithSplineSpecConfig<T> extends KeyframesSpecBaseConfig<T, KeyframesSpec.KeyframeEntity<T>> {
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public VectorizedDurationBasedAnimationSpec a(TwoWayConverter twoWayConverter) {
        int[] iArr;
        Object[] objArr;
        int[] iArr2;
        Object[] objArr2;
        int i3;
        MutableIntObjectMap mutableIntObjectMapC = this.f4013a.c();
        MutableIntList mutableIntList = new MutableIntList(mutableIntObjectMapC.d() + 2);
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(mutableIntObjectMapC.d());
        int[] iArr3 = mutableIntObjectMapC.f2886b;
        Object[] objArr3 = mutableIntObjectMapC.f2887c;
        long[] jArr = mutableIntObjectMapC.f2885a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i4 = 0;
            while (true) {
                long j3 = jArr[i4];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j3) < 128) {
                            int i8 = (i4 << 3) + i7;
                            int i9 = iArr3[i8];
                            KeyframesSpec.KeyframeEntity keyframeEntity = (KeyframesSpec.KeyframeEntity) objArr3[i8];
                            mutableIntList.l(i9);
                            i3 = i5;
                            iArr2 = iArr3;
                            objArr2 = objArr3;
                            mutableIntObjectMap.r(i9, new Pair(twoWayConverter.a().invoke(keyframeEntity.b()), keyframeEntity.a()));
                        } else {
                            iArr2 = iArr3;
                            objArr2 = objArr3;
                            i3 = i5;
                        }
                        j3 >>= i3;
                        i7++;
                        i5 = i3;
                        iArr3 = iArr2;
                        objArr3 = objArr2;
                    }
                    iArr = iArr3;
                    objArr = objArr3;
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    objArr = objArr3;
                }
                if (i4 == length) {
                    break;
                }
                i4++;
                iArr3 = iArr;
                objArr3 = objArr;
            }
        }
        if (!mutableIntObjectMapC.a(0)) {
            mutableIntList.k(0, 0);
        }
        if (!mutableIntObjectMapC.a(this.f4013a.b())) {
            mutableIntList.l(this.f4013a.b());
        }
        mutableIntList.r();
        return new VectorizedMonoSplineKeyframesSpec(mutableIntList, mutableIntObjectMap, this.f4013a.b(), this.f4013a.a(), this.f4014b);
    }
}
