package com.revenuecat.purchases.ui.revenuecatui.utils;

import androidx.compose.ui.text.font.FontStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ParsedFont {
    public static final int $stable = 0;
    private final int resId;
    private final int style;
    private final int weight;

    public /* synthetic */ ParsedFont(int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5);
    }

    /* JADX INFO: renamed from: copy-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ ParsedFont m1231copyRetOiIg$default(ParsedFont parsedFont, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i3 = parsedFont.resId;
        }
        if ((i6 & 2) != 0) {
            i4 = parsedFont.weight;
        }
        if ((i6 & 4) != 0) {
            i5 = parsedFont.style;
        }
        return parsedFont.m1233copyRetOiIg(i3, i4, i5);
    }

    public final int component1() {
        return this.resId;
    }

    public final int component2() {
        return this.weight;
    }

    /* JADX INFO: renamed from: component3-_-LCdwA, reason: not valid java name */
    public final int m1232component3_LCdwA() {
        return this.style;
    }

    /* JADX INFO: renamed from: copy-RetOiIg, reason: not valid java name */
    public final ParsedFont m1233copyRetOiIg(int i3, int i4, int i5) {
        return new ParsedFont(i3, i4, i5, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParsedFont)) {
            return false;
        }
        ParsedFont parsedFont = (ParsedFont) obj;
        return this.resId == parsedFont.resId && this.weight == parsedFont.weight && FontStyle.f(this.style, parsedFont.style);
    }

    public final int getResId() {
        return this.resId;
    }

    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: not valid java name */
    public final int m1234getStyle_LCdwA() {
        return this.style;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.resId) * 31) + Integer.hashCode(this.weight)) * 31) + FontStyle.g(this.style);
    }

    public String toString() {
        return "ParsedFont(resId=" + this.resId + ", weight=" + this.weight + ", style=" + ((Object) FontStyle.h(this.style)) + ')';
    }

    private ParsedFont(int i3, int i4, int i5) {
        this.resId = i3;
        this.weight = i4;
        this.style = i5;
    }
}
