package androidx.compose.animation.graphics.vector;

import androidx.collection.MutableScatterMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnimatorSet extends Animator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f4406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Ordering f4407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4408c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4409a;

        static {
            int[] iArr = new int[Ordering.values().length];
            try {
                iArr[Ordering.f4420a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Ordering.f4421b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f4409a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatorSet(List list, Ordering ordering) {
        super(null);
        Object obj = null;
        this.f4406a = list;
        this.f4407b = ordering;
        int i3 = WhenMappings.f4409a[ordering.ordinal()];
        int iD = 0;
        int i4 = 1;
        if (i3 == 1) {
            if (!list.isEmpty()) {
                Object obj2 = list.get(0);
                int iD2 = ((Animator) obj2).d();
                int lastIndex = CollectionsKt.getLastIndex(list);
                if (1 <= lastIndex) {
                    while (true) {
                        Object obj3 = list.get(i4);
                        int iD3 = ((Animator) obj3).d();
                        if (iD2 < iD3) {
                            obj2 = obj3;
                            iD2 = iD3;
                        }
                        if (i4 == lastIndex) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                obj = obj2;
            }
            Animator animator = (Animator) obj;
            if (animator != null) {
                iD = animator.d();
            }
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            int size = list.size();
            int iD4 = 0;
            while (iD < size) {
                iD4 += ((Animator) list.get(iD)).d();
                iD++;
            }
            iD = iD4;
        }
        this.f4408c = iD;
    }

    @Override // androidx.compose.animation.graphics.vector.Animator
    public void b(MutableScatterMap mutableScatterMap, int i3, int i4) {
        int i5 = WhenMappings.f4409a[this.f4407b.ordinal()];
        int i6 = 0;
        if (i5 == 1) {
            List list = this.f4406a;
            int size = list.size();
            while (i6 < size) {
                ((Animator) list.get(i6)).b(mutableScatterMap, i3, i4);
                i6++;
            }
            return;
        }
        if (i5 != 2) {
            return;
        }
        List list2 = this.f4406a;
        int size2 = list2.size();
        while (i6 < size2) {
            Animator animator = (Animator) list2.get(i6);
            animator.b(mutableScatterMap, i3, i4);
            i4 += animator.d();
            i6++;
        }
    }

    @Override // androidx.compose.animation.graphics.vector.Animator
    public int d() {
        return this.f4408c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnimatorSet)) {
            return false;
        }
        AnimatorSet animatorSet = (AnimatorSet) obj;
        return Intrinsics.areEqual(this.f4406a, animatorSet.f4406a) && this.f4407b == animatorSet.f4407b;
    }

    public int hashCode() {
        return (this.f4406a.hashCode() * 31) + this.f4407b.hashCode();
    }

    public String toString() {
        return "AnimatorSet(animators=" + this.f4406a + ", ordering=" + this.f4407b + ')';
    }
}
