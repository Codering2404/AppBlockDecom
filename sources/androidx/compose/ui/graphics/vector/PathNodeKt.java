package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
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
public final class PathNodeKt {
    public static final void a(char c3, ArrayList arrayList, float[] fArr, int i3) {
        int i4 = 0;
        switch (c3) {
            case 'A':
                int i5 = i3 - 7;
                for (int i6 = 0; i6 <= i5; i6 += 7) {
                    arrayList.add(new PathNode.ArcTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], Float.compare(fArr[i6 + 3], 0.0f) != 0, Float.compare(fArr[i6 + 4], 0.0f) != 0, fArr[i6 + 5], fArr[i6 + 6]));
                }
                return;
            case 'C':
                int i7 = i3 - 6;
                while (i4 <= i7) {
                    arrayList.add(new PathNode.CurveTo(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3], fArr[i4 + 4], fArr[i4 + 5]));
                    i4 += 6;
                }
                return;
            case 'H':
                int i8 = i3 - 1;
                while (i4 <= i8) {
                    arrayList.add(new PathNode.HorizontalTo(fArr[i4]));
                    i4++;
                }
                return;
            case 'L':
                int i9 = i3 - 2;
                while (i4 <= i9) {
                    arrayList.add(new PathNode.LineTo(fArr[i4], fArr[i4 + 1]));
                    i4 += 2;
                }
                return;
            case 'M':
                b(arrayList, fArr, i3);
                return;
            case 'Q':
                int i10 = i3 - 4;
                while (i4 <= i10) {
                    arrayList.add(new PathNode.QuadTo(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3]));
                    i4 += 4;
                }
                return;
            case 'S':
                int i11 = i3 - 4;
                while (i4 <= i11) {
                    arrayList.add(new PathNode.ReflectiveCurveTo(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3]));
                    i4 += 4;
                }
                return;
            case 'T':
                int i12 = i3 - 2;
                while (i4 <= i12) {
                    arrayList.add(new PathNode.ReflectiveQuadTo(fArr[i4], fArr[i4 + 1]));
                    i4 += 2;
                }
                return;
            case 'V':
                int i13 = i3 - 1;
                while (i4 <= i13) {
                    arrayList.add(new PathNode.VerticalTo(fArr[i4]));
                    i4++;
                }
                return;
            case 'Z':
            case 'z':
                arrayList.add(PathNode.Close.f26389c);
                return;
            case 'a':
                int i14 = i3 - 7;
                for (int i15 = 0; i15 <= i14; i15 += 7) {
                    arrayList.add(new PathNode.RelativeArcTo(fArr[i15], fArr[i15 + 1], fArr[i15 + 2], Float.compare(fArr[i15 + 3], 0.0f) != 0, Float.compare(fArr[i15 + 4], 0.0f) != 0, fArr[i15 + 5], fArr[i15 + 6]));
                }
                return;
            case 'c':
                int i16 = i3 - 6;
                while (i4 <= i16) {
                    arrayList.add(new PathNode.RelativeCurveTo(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3], fArr[i4 + 4], fArr[i4 + 5]));
                    i4 += 6;
                }
                return;
            case 'h':
                int i17 = i3 - 1;
                while (i4 <= i17) {
                    arrayList.add(new PathNode.RelativeHorizontalTo(fArr[i4]));
                    i4++;
                }
                return;
            case 'l':
                int i18 = i3 - 2;
                while (i4 <= i18) {
                    arrayList.add(new PathNode.RelativeLineTo(fArr[i4], fArr[i4 + 1]));
                    i4 += 2;
                }
                return;
            case 'm':
                c(arrayList, fArr, i3);
                return;
            case 'q':
                int i19 = i3 - 4;
                while (i4 <= i19) {
                    arrayList.add(new PathNode.RelativeQuadTo(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3]));
                    i4 += 4;
                }
                return;
            case 's':
                int i20 = i3 - 4;
                while (i4 <= i20) {
                    arrayList.add(new PathNode.RelativeReflectiveCurveTo(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3]));
                    i4 += 4;
                }
                return;
            case 't':
                int i21 = i3 - 2;
                while (i4 <= i21) {
                    arrayList.add(new PathNode.RelativeReflectiveQuadTo(fArr[i4], fArr[i4 + 1]));
                    i4 += 2;
                }
                return;
            case 'v':
                int i22 = i3 - 1;
                while (i4 <= i22) {
                    arrayList.add(new PathNode.RelativeVerticalTo(fArr[i4]));
                    i4++;
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown command for: " + c3);
        }
    }

    private static final void b(List list, float[] fArr, int i3) {
        int i4 = i3 - 2;
        if (i4 >= 0) {
            list.add(new PathNode.MoveTo(fArr[0], fArr[1]));
            for (int i5 = 2; i5 <= i4; i5 += 2) {
                list.add(new PathNode.LineTo(fArr[i5], fArr[i5 + 1]));
            }
        }
    }

    private static final void c(List list, float[] fArr, int i3) {
        int i4 = i3 - 2;
        if (i4 >= 0) {
            list.add(new PathNode.RelativeMoveTo(fArr[0], fArr[1]));
            for (int i5 = 2; i5 <= i4; i5 += 2) {
                list.add(new PathNode.RelativeLineTo(fArr[i5], fArr[i5 + 1]));
            }
        }
    }
}
