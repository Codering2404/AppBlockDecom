package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FontMatcher {
    public final List a(List list, FontWeight fontWeight, int i3) {
        ArrayList arrayList = new ArrayList(list.size());
        List list2 = list;
        int size = list2.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            Font font = (Font) obj;
            if (Intrinsics.areEqual(font.b(), fontWeight) && FontStyle.f(font.d(), i3)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Object obj2 = list.get(i6);
            if (FontStyle.f(((Font) obj2).d(), i3)) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            list = arrayList2;
        }
        List list3 = list;
        FontWeight.Companion companion = FontWeight.f29233b;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.j()) < 0) {
            List list4 = list3;
            int size3 = list4.size();
            FontWeight fontWeight3 = null;
            int i7 = 0;
            while (true) {
                if (i7 >= size3) {
                    break;
                }
                FontWeight fontWeightB = ((Font) list3.get(i7)).b();
                if (fontWeightB.compareTo(fontWeight) >= 0) {
                    if (fontWeightB.compareTo(fontWeight) <= 0) {
                        fontWeight2 = fontWeightB;
                        fontWeight3 = fontWeight2;
                        break;
                    }
                    if (fontWeight3 == null || fontWeightB.compareTo(fontWeight3) < 0) {
                        fontWeight3 = fontWeightB;
                    }
                } else if (fontWeight2 == null || fontWeightB.compareTo(fontWeight2) > 0) {
                    fontWeight2 = fontWeightB;
                }
                i7++;
            }
            if (fontWeight2 == null) {
                fontWeight2 = fontWeight3;
            }
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size4 = list4.size();
            while (i4 < size4) {
                Object obj3 = list3.get(i4);
                if (Intrinsics.areEqual(((Font) obj3).b(), fontWeight2)) {
                    arrayList3.add(obj3);
                }
                i4++;
            }
            return arrayList3;
        }
        if (fontWeight.compareTo(companion.k()) > 0) {
            List list5 = list3;
            int size5 = list5.size();
            FontWeight fontWeight4 = null;
            int i8 = 0;
            while (true) {
                if (i8 >= size5) {
                    break;
                }
                FontWeight fontWeightB2 = ((Font) list3.get(i8)).b();
                if (fontWeightB2.compareTo(fontWeight) >= 0) {
                    if (fontWeightB2.compareTo(fontWeight) <= 0) {
                        fontWeight2 = fontWeightB2;
                        fontWeight4 = fontWeight2;
                        break;
                    }
                    if (fontWeight4 == null || fontWeightB2.compareTo(fontWeight4) < 0) {
                        fontWeight4 = fontWeightB2;
                    }
                } else if (fontWeight2 == null || fontWeightB2.compareTo(fontWeight2) > 0) {
                    fontWeight2 = fontWeightB2;
                }
                i8++;
            }
            if (fontWeight4 != null) {
                fontWeight2 = fontWeight4;
            }
            ArrayList arrayList4 = new ArrayList(list3.size());
            int size6 = list5.size();
            while (i4 < size6) {
                Object obj4 = list3.get(i4);
                if (Intrinsics.areEqual(((Font) obj4).b(), fontWeight2)) {
                    arrayList4.add(obj4);
                }
                i4++;
            }
            return arrayList4;
        }
        FontWeight fontWeightK = companion.k();
        List list6 = list3;
        int size7 = list6.size();
        FontWeight fontWeight5 = null;
        FontWeight fontWeight6 = null;
        int i9 = 0;
        while (true) {
            if (i9 >= size7) {
                break;
            }
            FontWeight fontWeightB3 = ((Font) list3.get(i9)).b();
            if (fontWeightK == null || fontWeightB3.compareTo(fontWeightK) <= 0) {
                if (fontWeightB3.compareTo(fontWeight) >= 0) {
                    if (fontWeightB3.compareTo(fontWeight) <= 0) {
                        fontWeight5 = fontWeightB3;
                        fontWeight6 = fontWeight5;
                        break;
                    }
                    if (fontWeight6 == null || fontWeightB3.compareTo(fontWeight6) < 0) {
                        fontWeight6 = fontWeightB3;
                    }
                } else if (fontWeight5 == null || fontWeightB3.compareTo(fontWeight5) > 0) {
                    fontWeight5 = fontWeightB3;
                }
            }
            i9++;
        }
        if (fontWeight6 != null) {
            fontWeight5 = fontWeight6;
        }
        ArrayList arrayList5 = new ArrayList(list3.size());
        int size8 = list6.size();
        for (int i10 = 0; i10 < size8; i10++) {
            Object obj5 = list3.get(i10);
            if (Intrinsics.areEqual(((Font) obj5).b(), fontWeight5)) {
                arrayList5.add(obj5);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        FontWeight fontWeightK2 = FontWeight.f29233b.k();
        int size9 = list6.size();
        FontWeight fontWeight7 = null;
        int i11 = 0;
        while (true) {
            if (i11 >= size9) {
                break;
            }
            FontWeight fontWeightB4 = ((Font) list3.get(i11)).b();
            if (fontWeightK2 == null || fontWeightB4.compareTo(fontWeightK2) >= 0) {
                if (fontWeightB4.compareTo(fontWeight) >= 0) {
                    if (fontWeightB4.compareTo(fontWeight) <= 0) {
                        fontWeight2 = fontWeightB4;
                        fontWeight7 = fontWeight2;
                        break;
                    }
                    if (fontWeight7 == null || fontWeightB4.compareTo(fontWeight7) < 0) {
                        fontWeight7 = fontWeightB4;
                    }
                } else if (fontWeight2 == null || fontWeightB4.compareTo(fontWeight2) > 0) {
                    fontWeight2 = fontWeightB4;
                }
            }
            i11++;
        }
        if (fontWeight7 != null) {
            fontWeight2 = fontWeight7;
        }
        ArrayList arrayList6 = new ArrayList(list3.size());
        int size10 = list6.size();
        while (i4 < size10) {
            Object obj6 = list3.get(i4);
            if (Intrinsics.areEqual(((Font) obj6).b(), fontWeight2)) {
                arrayList6.add(obj6);
            }
            i4++;
        }
        return arrayList6;
    }
}
