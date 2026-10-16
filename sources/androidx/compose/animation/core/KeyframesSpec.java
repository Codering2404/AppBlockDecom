package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyframesSpecConfig f4008a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class KeyframeEntity<T> extends KeyframeBaseEntity<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4009c;

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, easing, i3);
        }

        public final int d() {
            return this.f4009c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof KeyframeEntity)) {
                return false;
            }
            KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
            return Intrinsics.areEqual(keyframeEntity.b(), b()) && Intrinsics.areEqual(keyframeEntity.a(), a()) && ArcMode.d(keyframeEntity.f4009c, this.f4009c);
        }

        public int hashCode() {
            Object objB = b();
            return ((((objB != null ? objB.hashCode() : 0) * 31) + ArcMode.e(this.f4009c)) * 31) + a().hashCode();
        }

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i4 & 2) != 0 ? EasingKt.e() : easing, (i4 & 4) != 0 ? ArcMode.f3871b.a() : i3, null);
        }

        private KeyframeEntity(Object obj, Easing easing, int i3) {
            super(obj, easing, null);
            this.f4009c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class KeyframesSpecConfig<T> extends KeyframesSpecBaseConfig<T, KeyframeEntity<T>> {
        public KeyframesSpecConfig() {
            super(null);
        }

        public KeyframeEntity f(Object obj, int i3) {
            KeyframeEntity keyframeEntity = new KeyframeEntity(obj, null, 0, 6, null);
            c().r(i3, keyframeEntity);
            return keyframeEntity;
        }

        public final void g(KeyframeEntity keyframeEntity, Easing easing) {
            keyframeEntity.c(easing);
        }
    }

    public KeyframesSpec(KeyframesSpecConfig keyframesSpecConfig) {
        this.f4008a = keyframesSpecConfig;
    }

    public final KeyframesSpecConfig f() {
        return this.f4008a;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public VectorizedKeyframesSpec a(TwoWayConverter twoWayConverter) {
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i3;
        MutableIntList mutableIntList = new MutableIntList(this.f4008a.c().d() + 2);
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(this.f4008a.c().d());
        MutableIntObjectMap mutableIntObjectMapC = this.f4008a.c();
        int[] iArr3 = mutableIntObjectMapC.f2886b;
        Object[] objArr = mutableIntObjectMapC.f2887c;
        long[] jArr3 = mutableIntObjectMapC.f2885a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i4 = 0;
            while (true) {
                long j3 = jArr3[i4];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j3) < 128) {
                            int i8 = (i4 << 3) + i7;
                            int i9 = iArr3[i8];
                            KeyframeEntity keyframeEntity = (KeyframeEntity) objArr[i8];
                            mutableIntList.l(i9);
                            i3 = i5;
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            mutableIntObjectMap.r(i9, new VectorizedKeyframeSpecElementInfo((AnimationVector) twoWayConverter.a().invoke(keyframeEntity.b()), keyframeEntity.a(), keyframeEntity.d(), null));
                        } else {
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            i3 = i5;
                        }
                        j3 >>= i3;
                        i7++;
                        i5 = i3;
                        jArr3 = jArr2;
                        iArr3 = iArr2;
                    }
                    jArr = jArr3;
                    iArr = iArr3;
                    if (i6 != i5) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                    iArr = iArr3;
                }
                if (i4 == length) {
                    break;
                }
                i4++;
                jArr3 = jArr;
                iArr3 = iArr;
            }
        }
        if (!this.f4008a.c().a(0)) {
            mutableIntList.k(0, 0);
        }
        if (!this.f4008a.c().a(this.f4008a.b())) {
            mutableIntList.l(this.f4008a.b());
        }
        mutableIntList.r();
        return new VectorizedKeyframesSpec(mutableIntList, mutableIntObjectMap, this.f4008a.b(), this.f4008a.a(), EasingKt.e(), ArcMode.f3871b.a(), null);
    }
}
