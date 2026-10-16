package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;

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
public final class IntrinsicMeasureBlocks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntrinsicMeasureBlocks f6985a = new IntrinsicMeasureBlocks();

    private IntrinsicMeasureBlocks() {
    }

    public final int a(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i4, i3);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f3 = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            if (fE == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER), i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i3 - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.I(iMin2));
            } else if (fE > 0.0f) {
                f3 += fE;
            }
        }
        int iRound = f3 == 0.0f ? 0 : i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i3 - iMin, 0) / f3);
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float fE2 = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable2));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.I(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int b(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i5 = 0;
        float f3 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i6);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            int iL0 = intrinsicMeasurable.l0(i3);
            if (fE == 0.0f) {
                i5 += iL0;
            } else if (fE > 0.0f) {
                f3 += fE;
                iMax = Math.max(iMax, Math.round(iL0 / fE));
            }
        }
        return Math.round(iMax * f3) + i5 + ((list.size() - 1) * i4);
    }

    public final int c(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i4, i3);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f3 = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            if (fE == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER), i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i3 - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.d0(iMin2));
            } else if (fE > 0.0f) {
                f3 += fE;
            }
        }
        int iRound = f3 == 0.0f ? 0 : i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i3 - iMin, 0) / f3);
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float fE2 = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable2));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.d0(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int d(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i5 = 0;
        float f3 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i6);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            int iK0 = intrinsicMeasurable.k0(i3);
            if (fE == 0.0f) {
                i5 += iK0;
            } else if (fE > 0.0f) {
                f3 += fE;
                iMax = Math.max(iMax, Math.round(iK0 / fE));
            }
        }
        return Math.round(iMax * f3) + i5 + ((list.size() - 1) * i4);
    }

    public final int e(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i5 = 0;
        float f3 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i6);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            int I = intrinsicMeasurable.I(i3);
            if (fE == 0.0f) {
                i5 += I;
            } else if (fE > 0.0f) {
                f3 += fE;
                iMax = Math.max(iMax, Math.round(I / fE));
            }
        }
        return Math.round(iMax * f3) + i5 + ((list.size() - 1) * i4);
    }

    public final int f(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i4, i3);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f3 = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            if (fE == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.I(Api.BaseClientBuilder.API_PRIORITY_OTHER), i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i3 - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.l0(iMin2));
            } else if (fE > 0.0f) {
                f3 += fE;
            }
        }
        int iRound = f3 == 0.0f ? 0 : i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i3 - iMin, 0) / f3);
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float fE2 = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable2));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.l0(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }

    public final int g(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int iMax = 0;
        int i5 = 0;
        float f3 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i6);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            int iD0 = intrinsicMeasurable.d0(i3);
            if (fE == 0.0f) {
                i5 += iD0;
            } else if (fE > 0.0f) {
                f3 += fE;
                iMax = Math.max(iMax, Math.round(iD0 / fE));
            }
        }
        return Math.round(iMax * f3) + i5 + ((list.size() - 1) * i4);
    }

    public final int h(List list, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMin = Math.min((list.size() - 1) * i4, i3);
        List list2 = list;
        int size = list2.size();
        int iMax = 0;
        float f3 = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i5);
            float fE = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable));
            if (fE == 0.0f) {
                int iMin2 = Math.min(intrinsicMeasurable.I(Api.BaseClientBuilder.API_PRIORITY_OTHER), i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i3 - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, intrinsicMeasurable.k0(iMin2));
            } else if (fE > 0.0f) {
                f3 += fE;
            }
        }
        int iRound = f3 == 0.0f ? 0 : i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(i3 - iMin, 0) / f3);
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i6);
            float fE2 = RowColumnImplKt.e(RowColumnImplKt.c(intrinsicMeasurable2));
            if (fE2 > 0.0f) {
                iMax = Math.max(iMax, intrinsicMeasurable2.k0(iRound != Integer.MAX_VALUE ? Math.round(iRound * fE2) : Integer.MAX_VALUE));
            }
        }
        return iMax;
    }
}
