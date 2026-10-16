package com.github.appintro.model;

import android.os.Bundle;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SliderPage {
    private int backgroundColor;
    private int backgroundDrawable;
    private CharSequence description;
    private int descriptionColor;
    private String descriptionTypeface;
    private int descriptionTypefaceFontRes;
    private int imageDrawable;
    private CharSequence title;
    private int titleColor;
    private String titleTypeface;
    private int titleTypefaceFontRes;

    public SliderPage() {
        this(null, null, 0, 0, 0, 0, 0, 0, null, null, 0, 2047, null);
    }

    public static /* synthetic */ SliderPage copy$default(SliderPage sliderPage, CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charSequence = sliderPage.title;
        }
        if ((i10 & 2) != 0) {
            charSequence2 = sliderPage.description;
        }
        if ((i10 & 4) != 0) {
            i3 = sliderPage.imageDrawable;
        }
        if ((i10 & 8) != 0) {
            i4 = sliderPage.backgroundColor;
        }
        if ((i10 & 16) != 0) {
            i5 = sliderPage.titleColor;
        }
        if ((i10 & 32) != 0) {
            i6 = sliderPage.descriptionColor;
        }
        if ((i10 & 64) != 0) {
            i7 = sliderPage.titleTypefaceFontRes;
        }
        if ((i10 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i8 = sliderPage.descriptionTypefaceFontRes;
        }
        if ((i10 & Function.MAX_NARGS) != 0) {
            str = sliderPage.titleTypeface;
        }
        if ((i10 & 512) != 0) {
            str2 = sliderPage.descriptionTypeface;
        }
        if ((i10 & 1024) != 0) {
            i9 = sliderPage.backgroundDrawable;
        }
        String str3 = str2;
        int i11 = i9;
        int i12 = i8;
        String str4 = str;
        int i13 = i6;
        int i14 = i7;
        int i15 = i5;
        int i16 = i3;
        return sliderPage.copy(charSequence, charSequence2, i16, i4, i15, i13, i14, i12, str4, str3, i11);
    }

    public final CharSequence component1() {
        return this.title;
    }

    public final String component10() {
        return this.descriptionTypeface;
    }

    public final int component11() {
        return this.backgroundDrawable;
    }

    public final CharSequence component2() {
        return this.description;
    }

    public final int component3() {
        return this.imageDrawable;
    }

    public final int component4() {
        return this.backgroundColor;
    }

    public final int component5() {
        return this.titleColor;
    }

    public final int component6() {
        return this.descriptionColor;
    }

    public final int component7() {
        return this.titleTypefaceFontRes;
    }

    public final int component8() {
        return this.descriptionTypefaceFontRes;
    }

    public final String component9() {
        return this.titleTypeface;
    }

    public final SliderPage copy(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, int i9) {
        return new SliderPage(charSequence, charSequence2, i3, i4, i5, i6, i7, i8, str, str2, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderPage)) {
            return false;
        }
        SliderPage sliderPage = (SliderPage) obj;
        return Intrinsics.areEqual(this.title, sliderPage.title) && Intrinsics.areEqual(this.description, sliderPage.description) && this.imageDrawable == sliderPage.imageDrawable && this.backgroundColor == sliderPage.backgroundColor && this.titleColor == sliderPage.titleColor && this.descriptionColor == sliderPage.descriptionColor && this.titleTypefaceFontRes == sliderPage.titleTypefaceFontRes && this.descriptionTypefaceFontRes == sliderPage.descriptionTypefaceFontRes && Intrinsics.areEqual(this.titleTypeface, sliderPage.titleTypeface) && Intrinsics.areEqual(this.descriptionTypeface, sliderPage.descriptionTypeface) && this.backgroundDrawable == sliderPage.backgroundDrawable;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final CharSequence getDescription() {
        return this.description;
    }

    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    public final String getDescriptionString() {
        CharSequence charSequence = this.description;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final String getDescriptionTypeface() {
        return this.descriptionTypeface;
    }

    public final int getDescriptionTypefaceFontRes() {
        return this.descriptionTypefaceFontRes;
    }

    public final int getImageDrawable() {
        return this.imageDrawable;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getTitleColor() {
        return this.titleColor;
    }

    public final String getTitleString() {
        CharSequence charSequence = this.title;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final String getTitleTypeface() {
        return this.titleTypeface;
    }

    public final int getTitleTypefaceFontRes() {
        return this.titleTypefaceFontRes;
    }

    public int hashCode() {
        CharSequence charSequence = this.title;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.description;
        int iHashCode2 = (((((((((((((iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31) + this.imageDrawable) * 31) + this.backgroundColor) * 31) + this.titleColor) * 31) + this.descriptionColor) * 31) + this.titleTypefaceFontRes) * 31) + this.descriptionTypefaceFontRes) * 31;
        String str = this.titleTypeface;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.descriptionTypeface;
        return ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.backgroundDrawable;
    }

    public final void setBackgroundColor(int i3) {
        this.backgroundColor = i3;
    }

    public final void setBackgroundDrawable(int i3) {
        this.backgroundDrawable = i3;
    }

    public final void setDescription(CharSequence charSequence) {
        this.description = charSequence;
    }

    public final void setDescriptionColor(int i3) {
        this.descriptionColor = i3;
    }

    public final void setDescriptionTypeface(String str) {
        this.descriptionTypeface = str;
    }

    public final void setDescriptionTypefaceFontRes(int i3) {
        this.descriptionTypefaceFontRes = i3;
    }

    public final void setImageDrawable(int i3) {
        this.imageDrawable = i3;
    }

    public final void setTitle(CharSequence charSequence) {
        this.title = charSequence;
    }

    public final void setTitleColor(int i3) {
        this.titleColor = i3;
    }

    public final void setTitleTypeface(String str) {
        this.titleTypeface = str;
    }

    public final void setTitleTypefaceFontRes(int i3) {
        this.titleTypefaceFontRes = i3;
    }

    public String toString() {
        return "SliderPage(title=" + this.title + ", description=" + this.description + ", imageDrawable=" + this.imageDrawable + ", backgroundColor=" + this.backgroundColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", titleTypefaceFontRes=" + this.titleTypefaceFontRes + ", descriptionTypefaceFontRes=" + this.descriptionTypefaceFontRes + ", titleTypeface=" + this.titleTypeface + ", descriptionTypeface=" + this.descriptionTypeface + ", backgroundDrawable=" + this.backgroundDrawable + ")";
    }

    public SliderPage(CharSequence charSequence) {
        this(charSequence, null, 0, 0, 0, 0, 0, 0, null, null, 0, 2046, null);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("title", getTitleString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, this.titleTypeface);
        bundle.putInt(rnFwbPAQmQTnL.DOQKYGk, this.titleTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC, getDescriptionString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, this.descriptionTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, this.descriptionTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descriptionColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.imageDrawable);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.backgroundColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.backgroundDrawable);
        return bundle;
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2) {
        this(charSequence, charSequence2, 0, 0, 0, 0, 0, 0, null, null, 0, 2044, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3) {
        this(charSequence, charSequence2, i3, 0, 0, 0, 0, 0, null, null, 0, 2040, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4) {
        this(charSequence, charSequence2, i3, i4, 0, 0, 0, 0, null, null, 0, 2032, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5) {
        this(charSequence, charSequence2, i3, i4, i5, 0, 0, 0, null, null, 0, 2016, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6) {
        this(charSequence, charSequence2, i3, i4, i5, i6, 0, 0, null, null, 0, 1984, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7) {
        this(charSequence, charSequence2, i3, i4, i5, i6, i7, 0, null, null, 0, 1920, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this(charSequence, charSequence2, i3, i4, i5, i6, i7, i8, null, null, 0, 1792, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, String str) {
        this(charSequence, charSequence2, i3, i4, i5, i6, i7, i8, str, null, 0, 1536, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2) {
        this(charSequence, charSequence2, i3, i4, i5, i6, i7, i8, str, str2, 0, 1024, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, int i9) {
        this.title = charSequence;
        this.description = charSequence2;
        this.imageDrawable = i3;
        this.backgroundColor = i4;
        this.titleColor = i5;
        this.descriptionColor = i6;
        this.titleTypefaceFontRes = i7;
        this.descriptionTypefaceFontRes = i8;
        this.titleTypeface = str;
        this.descriptionTypeface = str2;
        this.backgroundDrawable = i9;
    }

    public /* synthetic */ SliderPage(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : charSequence, (i10 & 2) != 0 ? null : charSequence2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0 : i8, (i10 & Function.MAX_NARGS) != 0 ? null : str, (i10 & 512) != 0 ? null : str2, (i10 & 1024) != 0 ? 0 : i9);
    }
}
