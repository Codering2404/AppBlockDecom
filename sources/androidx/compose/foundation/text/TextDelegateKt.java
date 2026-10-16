package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextDelegateKt {
    public static final int a(float f3) {
        return Math.round((float) Math.ceil(f3));
    }

    public static final TextDelegate b(TextDelegate textDelegate, AnnotatedString annotatedString, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z2, int i3, int i4, int i5, List list) {
        FontFamily.Resolver resolver2;
        boolean z3;
        int i6;
        int i7;
        int i8;
        List list2;
        if (Intrinsics.areEqual(textDelegate.k(), annotatedString) && Intrinsics.areEqual(textDelegate.j(), textStyle)) {
            z3 = z2;
            if (textDelegate.i() == z3) {
                i6 = i3;
                if (!TextOverflow.h(textDelegate.g(), i6)) {
                    resolver2 = resolver;
                    i7 = i4;
                    i8 = i5;
                    list2 = list;
                    return new TextDelegate(annotatedString, textStyle, i7, i8, z3, i6, density, resolver2, list2, null);
                }
                i7 = i4;
                if (textDelegate.d() != i7) {
                    resolver2 = resolver;
                    i8 = i5;
                    list2 = list;
                    return new TextDelegate(annotatedString, textStyle, i7, i8, z3, i6, density, resolver2, list2, null);
                }
                i8 = i5;
                if (textDelegate.e() != i8 || !Intrinsics.areEqual(textDelegate.a(), density)) {
                    resolver2 = resolver;
                    list2 = list;
                    return new TextDelegate(annotatedString, textStyle, i7, i8, z3, i6, density, resolver2, list2, null);
                }
                list2 = list;
                if (Intrinsics.areEqual(textDelegate.h(), list2)) {
                    resolver2 = resolver;
                    if (textDelegate.b() == resolver2) {
                        return textDelegate;
                    }
                } else {
                    resolver2 = resolver;
                }
                return new TextDelegate(annotatedString, textStyle, i7, i8, z3, i6, density, resolver2, list2, null);
            }
            resolver2 = resolver;
        } else {
            resolver2 = resolver;
            z3 = z2;
        }
        i6 = i3;
        i7 = i4;
        i8 = i5;
        list2 = list;
        return new TextDelegate(annotatedString, textStyle, i7, i8, z3, i6, density, resolver2, list2, null);
    }

    public static /* synthetic */ TextDelegate c(TextDelegate textDelegate, AnnotatedString annotatedString, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z2, int i3, int i4, int i5, List list, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            z2 = true;
        }
        if ((i6 & 64) != 0) {
            i3 = TextOverflow.f29661b.a();
        }
        if ((i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if ((i6 & Function.MAX_NARGS) != 0) {
            i5 = 1;
        }
        return b(textDelegate, annotatedString, textStyle, density, resolver, z2, i3, i4, i5, list);
    }
}
