package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.ui.graphics.Color;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class BadgeInfo {
    private final BorderStroke border;
    private final Color color;
    private final String text;
    private final Color textColor;

    public /* synthetic */ BadgeInfo(String str, Color color, BorderStroke borderStroke, Color color2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, color, borderStroke, color2);
    }

    /* JADX INFO: renamed from: copy-yw5i9vo$default, reason: not valid java name */
    public static /* synthetic */ BadgeInfo m1009copyyw5i9vo$default(BadgeInfo badgeInfo, String str, Color color, BorderStroke borderStroke, Color color2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = badgeInfo.text;
        }
        if ((i3 & 2) != 0) {
            color = badgeInfo.color;
        }
        if ((i3 & 4) != 0) {
            borderStroke = badgeInfo.border;
        }
        if ((i3 & 8) != 0) {
            color2 = badgeInfo.textColor;
        }
        return badgeInfo.m1012copyyw5i9vo(str, color, borderStroke, color2);
    }

    public final String component1() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2-QN2ZGVo, reason: not valid java name */
    public final Color m1010component2QN2ZGVo() {
        return this.color;
    }

    public final BorderStroke component3() {
        return this.border;
    }

    /* JADX INFO: renamed from: component4-QN2ZGVo, reason: not valid java name */
    public final Color m1011component4QN2ZGVo() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: copy-yw5i9vo, reason: not valid java name */
    public final BadgeInfo m1012copyyw5i9vo(String str, Color color, BorderStroke borderStroke, Color color2) {
        return new BadgeInfo(str, color, borderStroke, color2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgeInfo)) {
            return false;
        }
        BadgeInfo badgeInfo = (BadgeInfo) obj;
        return Intrinsics.areEqual(this.text, badgeInfo.text) && Intrinsics.areEqual(this.color, badgeInfo.color) && Intrinsics.areEqual(this.border, badgeInfo.border) && Intrinsics.areEqual(this.textColor, badgeInfo.textColor);
    }

    public final BorderStroke getBorder() {
        return this.border;
    }

    /* JADX INFO: renamed from: getColor-QN2ZGVo, reason: not valid java name */
    public final Color m1013getColorQN2ZGVo() {
        return this.color;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: getTextColor-QN2ZGVo, reason: not valid java name */
    public final Color m1014getTextColorQN2ZGVo() {
        return this.textColor;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Color color = this.color;
        int iZ = (iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31;
        BorderStroke borderStroke = this.border;
        int iHashCode2 = (iZ + (borderStroke == null ? 0 : borderStroke.hashCode())) * 31;
        Color color2 = this.textColor;
        return iHashCode2 + (color2 != null ? Color.z(color2.B()) : 0);
    }

    public String toString() {
        return "BadgeInfo(text=" + this.text + ", color=" + this.color + ", border=" + this.border + ", textColor=" + this.textColor + ')';
    }

    private BadgeInfo(String str, Color color, BorderStroke borderStroke, Color color2) {
        this.text = str;
        this.color = color;
        this.border = borderStroke;
        this.textColor = color2;
    }

    public /* synthetic */ BadgeInfo(String str, Color color, BorderStroke borderStroke, Color color2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, color, (i3 & 4) != 0 ? null : borderStroke, (i3 & 8) != 0 ? null : color2, null);
    }
}
