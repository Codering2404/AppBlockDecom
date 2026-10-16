package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MultiParagraphKt {
    public static final int a(List list, int i3) {
        int i4;
        int iB = ((ParagraphInfo) CollectionsKt.last(list)).b();
        boolean z2 = false;
        if (!(i3 <= ((ParagraphInfo) CollectionsKt.last(list)).b())) {
            InlineClassHelperKt.a("Index " + i3 + " should be less or equal than last line's end " + iB);
        }
        int size = list.size() - 1;
        int i5 = 0;
        while (true) {
            if (i5 > size) {
                i4 = -(i5 + 1);
                break;
            }
            i4 = (i5 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i4);
            byte b3 = paragraphInfo.f() > i3 ? (byte) 1 : paragraphInfo.b() <= i3 ? (byte) -1 : (byte) 0;
            if (b3 >= 0) {
                if (b3 <= 0) {
                    break;
                }
                size = i4 - 1;
            } else {
                i5 = i4 + 1;
            }
        }
        if (i4 >= 0 && i4 < list.size()) {
            z2 = true;
        }
        if (!z2) {
            InlineClassHelperKt.a("Found paragraph index " + i4 + " should be in range [0, " + list.size() + ").\nDebug info: index=" + i3 + ", paragraphs=[" + ListUtilsKt.e(list, null, null, null, 0, null, new Function1<ParagraphInfo, CharSequence>() { // from class: androidx.compose.ui.text.MultiParagraphKt$findParagraphByIndex$2$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final CharSequence invoke(ParagraphInfo paragraphInfo2) {
                    return '[' + paragraphInfo2.f() + ", " + paragraphInfo2.b() + ')';
                }
            }, 31, null) + ']');
        }
        return i4;
    }

    public static final int b(List list, int i3) {
        int size = list.size() - 1;
        int i4 = 0;
        while (i4 <= size) {
            int i5 = (i4 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i5);
            byte b3 = paragraphInfo.g() > i3 ? (byte) 1 : paragraphInfo.c() <= i3 ? (byte) -1 : (byte) 0;
            if (b3 < 0) {
                i4 = i5 + 1;
            } else {
                if (b3 <= 0) {
                    return i5;
                }
                size = i5 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static final int c(List list, float f3) {
        if (f3 <= 0.0f) {
            return 0;
        }
        if (f3 >= ((ParagraphInfo) CollectionsKt.last(list)).a()) {
            return CollectionsKt.getLastIndex(list);
        }
        int size = list.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i4);
            byte b3 = paragraphInfo.h() > f3 ? (byte) 1 : paragraphInfo.a() <= f3 ? (byte) -1 : (byte) 0;
            if (b3 < 0) {
                i3 = i4 + 1;
            } else {
                if (b3 <= 0) {
                    return i4;
                }
                size = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static final void d(List list, long j3, Function1 function1) {
        int size = list.size();
        for (int iA = a(list, TextRange.l(j3)); iA < size; iA++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(iA);
            if (paragraphInfo.f() >= TextRange.k(j3)) {
                return;
            }
            if (paragraphInfo.f() != paragraphInfo.b()) {
                function1.invoke(paragraphInfo);
            }
        }
    }
}
