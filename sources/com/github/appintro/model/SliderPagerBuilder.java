package com.github.appintro.model;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SliderPagerBuilder {
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

    public final SliderPagerBuilder backgroundColor(int i3) {
        this.backgroundColor = i3;
        return this;
    }

    public final SliderPagerBuilder backgroundDrawable(int i3) {
        this.backgroundDrawable = i3;
        return this;
    }

    public final SliderPage build() {
        CharSequence charSequence = this.title;
        CharSequence charSequence2 = this.description;
        int i3 = this.imageDrawable;
        int i4 = this.backgroundColor;
        int i5 = this.titleColor;
        int i6 = this.descriptionColor;
        int i7 = this.titleTypefaceFontRes;
        String str = this.descriptionTypeface;
        return new SliderPage(charSequence, charSequence2, i3, i4, i5, i6, i7, this.descriptionTypefaceFontRes, this.titleTypeface, str, this.backgroundDrawable);
    }

    public final SliderPagerBuilder description(CharSequence description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
        return this;
    }

    public final SliderPagerBuilder descriptionColor(int i3) {
        this.descriptionColor = i3;
        return this;
    }

    public final SliderPagerBuilder descriptionTypeface(String descriptionTypeface) {
        Intrinsics.checkNotNullParameter(descriptionTypeface, "descriptionTypeface");
        this.descriptionTypeface = descriptionTypeface;
        return this;
    }

    public final SliderPagerBuilder descriptionTypefaceFontRes(int i3) {
        this.descriptionTypefaceFontRes = i3;
        return this;
    }

    public final SliderPagerBuilder imageDrawable(int i3) {
        this.imageDrawable = i3;
        return this;
    }

    public final SliderPagerBuilder title(CharSequence title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        return this;
    }

    public final SliderPagerBuilder titleColor(int i3) {
        this.titleColor = i3;
        return this;
    }

    public final SliderPagerBuilder titleTypeface(String titleTypeface) {
        Intrinsics.checkNotNullParameter(titleTypeface, "titleTypeface");
        this.titleTypeface = titleTypeface;
        return this;
    }

    public final SliderPagerBuilder titleTypefaceFontRes(int i3) {
        this.titleTypefaceFontRes = i3;
        return this;
    }
}
