package androidx.compose.foundation.gestures;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
@Metadata
final class DefaultDraggableAnchors<T> implements DraggableAnchors<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f5595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f5596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5597c;

    public DefaultDraggableAnchors(List list, float[] fArr) {
        this.f5595a = list;
        this.f5596b = fArr;
        list.size();
        int length = fArr.length;
        this.f5597c = fArr.length;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public Object a(float f3, boolean z2) {
        float[] fArr = this.f5596b;
        int length = fArr.length;
        int i3 = -1;
        int i4 = 0;
        float f4 = Float.POSITIVE_INFINITY;
        int i5 = 0;
        while (i4 < length) {
            float f5 = fArr[i4];
            int i6 = i5 + 1;
            float f6 = z2 ? f5 - f3 : f3 - f5;
            if (f6 < 0.0f) {
                f6 = Float.POSITIVE_INFINITY;
            }
            if (f6 <= f4) {
                i3 = i5;
                f4 = f6;
            }
            i4++;
            i5 = i6;
        }
        return this.f5595a.get(i3);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public Object b(float f3) {
        float[] fArr = this.f5596b;
        int length = fArr.length;
        int i3 = -1;
        float f4 = Float.POSITIVE_INFINITY;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i5 + 1;
            float fAbs = Math.abs(f3 - fArr[i4]);
            if (fAbs <= f4) {
                i3 = i5;
                f4 = fAbs;
            }
            i4++;
            i5 = i6;
        }
        return this.f5595a.get(i3);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float c(Object obj) {
        int iIndexOf = this.f5595a.indexOf(obj);
        float[] fArr = this.f5596b;
        return (iIndexOf < 0 || iIndexOf > ArraysKt.getLastIndex(fArr)) ? ((Number) AnchoredDraggableKt.f5385b.invoke(Integer.valueOf(iIndexOf))).floatValue() : fArr[iIndexOf];
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public boolean d(Object obj) {
        return this.f5595a.indexOf(obj) != -1;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float e() {
        Float fMinOrNull = ArraysKt.minOrNull(this.f5596b);
        if (fMinOrNull != null) {
            return fMinOrNull.floatValue();
        }
        return Float.NaN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultDraggableAnchors)) {
            return false;
        }
        DefaultDraggableAnchors defaultDraggableAnchors = (DefaultDraggableAnchors) obj;
        return Intrinsics.areEqual(this.f5595a, defaultDraggableAnchors.f5595a) && Arrays.equals(this.f5596b, defaultDraggableAnchors.f5596b) && h() == defaultDraggableAnchors.h();
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float f() {
        Float fMaxOrNull = ArraysKt.maxOrNull(this.f5596b);
        if (fMaxOrNull != null) {
            return fMaxOrNull.floatValue();
        }
        return Float.NaN;
    }

    public Object g(int i3) {
        return CollectionsKt.getOrNull(this.f5595a, i3);
    }

    public int h() {
        return this.f5597c;
    }

    public int hashCode() {
        return (((this.f5595a.hashCode() * 31) + Arrays.hashCode(this.f5596b)) * 31) + h();
    }

    public float i(int i3) {
        float[] fArr = this.f5596b;
        return (i3 < 0 || i3 > ArraysKt.getLastIndex(fArr)) ? ((Number) AnchoredDraggableKt.f5385b.invoke(Integer.valueOf(i3))).floatValue() : fArr[i3];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DraggableAnchors(anchors={");
        int iH = h();
        for (int i3 = 0; i3 < iH; i3++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(g(i3));
            sb2.append('=');
            sb2.append(i(i3));
            sb.append(sb2.toString());
            if (i3 < h() - 1) {
                sb.append(", ");
            }
        }
        sb.append("})");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
