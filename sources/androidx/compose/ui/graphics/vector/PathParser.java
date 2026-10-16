package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
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
public final class PathParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f26441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f26442b = new float[64];

    public static /* synthetic */ ArrayList c(PathParser pathParser, String str, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            arrayList = new ArrayList();
        }
        return pathParser.b(str, arrayList);
    }

    public final PathParser a(String str) {
        ArrayList arrayList = this.f26441a;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f26441a = arrayList;
        } else {
            arrayList.clear();
        }
        b(str, arrayList);
        return this;
    }

    public final ArrayList b(String str, ArrayList arrayList) {
        int i3;
        char cCharAt;
        int i4;
        int length = str.length();
        int i5 = 0;
        while (i5 < length && Intrinsics.compare((int) str.charAt(i5), 32) <= 0) {
            i5++;
        }
        while (length > i5 && Intrinsics.compare((int) str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i6 = 0;
        while (i5 < length) {
            while (true) {
                i3 = i5 + 1;
                cCharAt = str.charAt(i5);
                int i7 = cCharAt | ' ';
                if ((i7 - 97) * (i7 - 122) <= 0 && i7 != 101) {
                    break;
                }
                if (i3 >= length) {
                    cCharAt = 0;
                    break;
                }
                i5 = i3;
            }
            if (cCharAt != 0) {
                if ((cCharAt | ' ') != 122) {
                    i6 = 0;
                    while (true) {
                        if (i3 >= length || Intrinsics.compare((int) str.charAt(i3), 32) > 0) {
                            long jA = FastFloatParserKt.a(str, i3, length);
                            i4 = (int) (jA >>> 32);
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (jA & 4294967295L));
                            if (!Float.isNaN(fIntBitsToFloat)) {
                                float[] fArr = this.f26442b;
                                int i8 = i6 + 1;
                                fArr[i6] = fIntBitsToFloat;
                                if (i8 >= fArr.length) {
                                    float[] fArr2 = new float[i8 * 2];
                                    this.f26442b = fArr2;
                                    ArraysKt.copyInto(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i6 = i8;
                            }
                            while (i4 < length && str.charAt(i4) == ',') {
                                i4++;
                            }
                            if (i4 >= length || Float.isNaN(fIntBitsToFloat)) {
                                break;
                            }
                            i3 = i4;
                        } else {
                            i3++;
                        }
                    }
                    i3 = i4;
                }
                PathNodeKt.a(cCharAt, arrayList, this.f26442b, i6);
            }
            i5 = i3;
        }
        return arrayList;
    }

    public final List d() {
        ArrayList arrayList = this.f26441a;
        return arrayList != null ? arrayList : CollectionsKt.emptyList();
    }
}
