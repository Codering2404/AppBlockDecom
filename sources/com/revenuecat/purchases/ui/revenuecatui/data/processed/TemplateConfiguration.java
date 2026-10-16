package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import android.net.Uri;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TemplateConfiguration {
    public static final int $stable = 0;
    private final PaywallData.Configuration.ColorInformation colors;
    private final PaywallData.Configuration configuration;
    private final Colors darkModeColors;
    private final Images images;
    private final Map<String, Images> imagesByTier;
    private final Colors lightModeColors;
    private final Locale locale;
    private final PaywallMode mode;
    private final PackageConfiguration packages;
    private final PaywallTemplate template;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Colors {
        public static final int $stable = 0;
        private final long accent1;
        private final long accent2;
        private final long accent3;
        private final long background;
        private final long callToActionBackground;
        private final long callToActionForeground;
        private final Color callToActionSecondaryBackground;
        private final Color closeButton;
        private final long text1;
        private final long text2;
        private final long text3;
        private final Color tierControlBackground;
        private final Color tierControlForeground;
        private final Color tierControlSelectedBackground;
        private final Color tierControlSelectedForeground;

        public /* synthetic */ Colors(long j3, long j4, long j5, long j6, long j7, long j8, Color color, long j9, long j10, long j11, Color color2, Color color3, Color color4, Color color5, Color color6, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, j4, j5, j6, j7, j8, color, j9, j10, j11, color2, color3, color4, color5, color6);
        }

        /* JADX INFO: renamed from: copy-VbAgQ-U$default, reason: not valid java name */
        public static /* synthetic */ Colors m1068copyVbAgQU$default(Colors colors, long j3, long j4, long j5, long j6, long j7, long j8, Color color, long j9, long j10, long j11, Color color2, Color color3, Color color4, Color color5, Color color6, int i3, Object obj) {
            long j12;
            long j13;
            long j14 = (i3 & 1) != 0 ? colors.background : j3;
            long j15 = (i3 & 2) != 0 ? colors.text1 : j4;
            long j16 = (i3 & 4) != 0 ? colors.text2 : j5;
            long j17 = (i3 & 8) != 0 ? colors.text3 : j6;
            long j18 = (i3 & 16) != 0 ? colors.callToActionBackground : j7;
            long j19 = (i3 & 32) != 0 ? colors.callToActionForeground : j8;
            Color color7 = (i3 & 64) != 0 ? colors.callToActionSecondaryBackground : color;
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                j12 = j14;
                j13 = colors.accent1;
            } else {
                j12 = j14;
                j13 = j9;
            }
            return colors.m1084copyVbAgQU(j12, j15, j16, j17, j18, j19, color7, j13, (i3 & Function.MAX_NARGS) != 0 ? colors.accent2 : j10, (i3 & 512) != 0 ? colors.accent3 : j11, (i3 & 1024) != 0 ? colors.closeButton : color2, (i3 & 2048) != 0 ? colors.tierControlBackground : color3, (i3 & 4096) != 0 ? colors.tierControlForeground : color4, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? colors.tierControlSelectedBackground : color5, (i3 & 16384) != 0 ? colors.tierControlSelectedForeground : color6);
        }

        /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name */
        public final long m1069component10d7_KjU() {
            return this.background;
        }

        /* JADX INFO: renamed from: component10-0d7_KjU, reason: not valid java name */
        public final long m1070component100d7_KjU() {
            return this.accent3;
        }

        /* JADX INFO: renamed from: component11-QN2ZGVo, reason: not valid java name */
        public final Color m1071component11QN2ZGVo() {
            return this.closeButton;
        }

        /* JADX INFO: renamed from: component12-QN2ZGVo, reason: not valid java name */
        public final Color m1072component12QN2ZGVo() {
            return this.tierControlBackground;
        }

        /* JADX INFO: renamed from: component13-QN2ZGVo, reason: not valid java name */
        public final Color m1073component13QN2ZGVo() {
            return this.tierControlForeground;
        }

        /* JADX INFO: renamed from: component14-QN2ZGVo, reason: not valid java name */
        public final Color m1074component14QN2ZGVo() {
            return this.tierControlSelectedBackground;
        }

        /* JADX INFO: renamed from: component15-QN2ZGVo, reason: not valid java name */
        public final Color m1075component15QN2ZGVo() {
            return this.tierControlSelectedForeground;
        }

        /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name */
        public final long m1076component20d7_KjU() {
            return this.text1;
        }

        /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name */
        public final long m1077component30d7_KjU() {
            return this.text2;
        }

        /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name */
        public final long m1078component40d7_KjU() {
            return this.text3;
        }

        /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name */
        public final long m1079component50d7_KjU() {
            return this.callToActionBackground;
        }

        /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name */
        public final long m1080component60d7_KjU() {
            return this.callToActionForeground;
        }

        /* JADX INFO: renamed from: component7-QN2ZGVo, reason: not valid java name */
        public final Color m1081component7QN2ZGVo() {
            return this.callToActionSecondaryBackground;
        }

        /* JADX INFO: renamed from: component8-0d7_KjU, reason: not valid java name */
        public final long m1082component80d7_KjU() {
            return this.accent1;
        }

        /* JADX INFO: renamed from: component9-0d7_KjU, reason: not valid java name */
        public final long m1083component90d7_KjU() {
            return this.accent2;
        }

        /* JADX INFO: renamed from: copy-VbAgQ-U, reason: not valid java name */
        public final Colors m1084copyVbAgQU(long j3, long j4, long j5, long j6, long j7, long j8, Color color, long j9, long j10, long j11, Color color2, Color color3, Color color4, Color color5, Color color6) {
            return new Colors(j3, j4, j5, j6, j7, j8, color, j9, j10, j11, color2, color3, color4, color5, color6, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Colors)) {
                return false;
            }
            Colors colors = (Colors) obj;
            return Color.t(this.background, colors.background) && Color.t(this.text1, colors.text1) && Color.t(this.text2, colors.text2) && Color.t(this.text3, colors.text3) && Color.t(this.callToActionBackground, colors.callToActionBackground) && Color.t(this.callToActionForeground, colors.callToActionForeground) && Intrinsics.areEqual(this.callToActionSecondaryBackground, colors.callToActionSecondaryBackground) && Color.t(this.accent1, colors.accent1) && Color.t(this.accent2, colors.accent2) && Color.t(this.accent3, colors.accent3) && Intrinsics.areEqual(this.closeButton, colors.closeButton) && Intrinsics.areEqual(this.tierControlBackground, colors.tierControlBackground) && Intrinsics.areEqual(this.tierControlForeground, colors.tierControlForeground) && Intrinsics.areEqual(this.tierControlSelectedBackground, colors.tierControlSelectedBackground) && Intrinsics.areEqual(this.tierControlSelectedForeground, colors.tierControlSelectedForeground);
        }

        /* JADX INFO: renamed from: getAccent1-0d7_KjU, reason: not valid java name */
        public final long m1085getAccent10d7_KjU() {
            return this.accent1;
        }

        /* JADX INFO: renamed from: getAccent2-0d7_KjU, reason: not valid java name */
        public final long m1086getAccent20d7_KjU() {
            return this.accent2;
        }

        /* JADX INFO: renamed from: getAccent3-0d7_KjU, reason: not valid java name */
        public final long m1087getAccent30d7_KjU() {
            return this.accent3;
        }

        /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
        public final long m1088getBackground0d7_KjU() {
            return this.background;
        }

        /* JADX INFO: renamed from: getCallToActionBackground-0d7_KjU, reason: not valid java name */
        public final long m1089getCallToActionBackground0d7_KjU() {
            return this.callToActionBackground;
        }

        /* JADX INFO: renamed from: getCallToActionForeground-0d7_KjU, reason: not valid java name */
        public final long m1090getCallToActionForeground0d7_KjU() {
            return this.callToActionForeground;
        }

        /* JADX INFO: renamed from: getCallToActionSecondaryBackground-QN2ZGVo, reason: not valid java name */
        public final Color m1091getCallToActionSecondaryBackgroundQN2ZGVo() {
            return this.callToActionSecondaryBackground;
        }

        /* JADX INFO: renamed from: getCloseButton-QN2ZGVo, reason: not valid java name */
        public final Color m1092getCloseButtonQN2ZGVo() {
            return this.closeButton;
        }

        /* JADX INFO: renamed from: getText1-0d7_KjU, reason: not valid java name */
        public final long m1093getText10d7_KjU() {
            return this.text1;
        }

        /* JADX INFO: renamed from: getText2-0d7_KjU, reason: not valid java name */
        public final long m1094getText20d7_KjU() {
            return this.text2;
        }

        /* JADX INFO: renamed from: getText3-0d7_KjU, reason: not valid java name */
        public final long m1095getText30d7_KjU() {
            return this.text3;
        }

        /* JADX INFO: renamed from: getTierControlBackground-QN2ZGVo, reason: not valid java name */
        public final Color m1096getTierControlBackgroundQN2ZGVo() {
            return this.tierControlBackground;
        }

        /* JADX INFO: renamed from: getTierControlForeground-QN2ZGVo, reason: not valid java name */
        public final Color m1097getTierControlForegroundQN2ZGVo() {
            return this.tierControlForeground;
        }

        /* JADX INFO: renamed from: getTierControlSelectedBackground-QN2ZGVo, reason: not valid java name */
        public final Color m1098getTierControlSelectedBackgroundQN2ZGVo() {
            return this.tierControlSelectedBackground;
        }

        /* JADX INFO: renamed from: getTierControlSelectedForeground-QN2ZGVo, reason: not valid java name */
        public final Color m1099getTierControlSelectedForegroundQN2ZGVo() {
            return this.tierControlSelectedForeground;
        }

        public int hashCode() {
            int iZ = ((((((((((Color.z(this.background) * 31) + Color.z(this.text1)) * 31) + Color.z(this.text2)) * 31) + Color.z(this.text3)) * 31) + Color.z(this.callToActionBackground)) * 31) + Color.z(this.callToActionForeground)) * 31;
            Color color = this.callToActionSecondaryBackground;
            int iZ2 = (((((((iZ + (color == null ? 0 : Color.z(color.B()))) * 31) + Color.z(this.accent1)) * 31) + Color.z(this.accent2)) * 31) + Color.z(this.accent3)) * 31;
            Color color2 = this.closeButton;
            int iZ3 = (iZ2 + (color2 == null ? 0 : Color.z(color2.B()))) * 31;
            Color color3 = this.tierControlBackground;
            int iZ4 = (iZ3 + (color3 == null ? 0 : Color.z(color3.B()))) * 31;
            Color color4 = this.tierControlForeground;
            int iZ5 = (iZ4 + (color4 == null ? 0 : Color.z(color4.B()))) * 31;
            Color color5 = this.tierControlSelectedBackground;
            int iZ6 = (iZ5 + (color5 == null ? 0 : Color.z(color5.B()))) * 31;
            Color color6 = this.tierControlSelectedForeground;
            return iZ6 + (color6 != null ? Color.z(color6.B()) : 0);
        }

        public String toString() {
            return "Colors(background=" + ((Object) Color.A(this.background)) + ", text1=" + ((Object) Color.A(this.text1)) + ", text2=" + ((Object) Color.A(this.text2)) + ", text3=" + ((Object) Color.A(this.text3)) + ", callToActionBackground=" + ((Object) Color.A(this.callToActionBackground)) + ", callToActionForeground=" + ((Object) Color.A(this.callToActionForeground)) + ", callToActionSecondaryBackground=" + this.callToActionSecondaryBackground + ", accent1=" + ((Object) Color.A(this.accent1)) + ", accent2=" + ((Object) Color.A(this.accent2)) + ", accent3=" + ((Object) Color.A(this.accent3)) + ", closeButton=" + this.closeButton + ", tierControlBackground=" + this.tierControlBackground + ", tierControlForeground=" + this.tierControlForeground + ", tierControlSelectedBackground=" + this.tierControlSelectedBackground + ", tierControlSelectedForeground=" + this.tierControlSelectedForeground + ')';
        }

        private Colors(long j3, long j4, long j5, long j6, long j7, long j8, Color color, long j9, long j10, long j11, Color color2, Color color3, Color color4, Color color5, Color color6) {
            this.background = j3;
            this.text1 = j4;
            this.text2 = j5;
            this.text3 = j6;
            this.callToActionBackground = j7;
            this.callToActionForeground = j8;
            this.callToActionSecondaryBackground = color;
            this.accent1 = j9;
            this.accent2 = j10;
            this.accent3 = j11;
            this.closeButton = color2;
            this.tierControlBackground = color3;
            this.tierControlForeground = color4;
            this.tierControlSelectedBackground = color5;
            this.tierControlSelectedForeground = color6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Images {
        public static final int $stable = 0;
        private final Uri backgroundUri;
        private final Uri headerUri;
        private final Uri iconUri;

        public Images(Uri uri, Uri uri2, Uri uri3) {
            this.iconUri = uri;
            this.backgroundUri = uri2;
            this.headerUri = uri3;
        }

        public static /* synthetic */ Images copy$default(Images images, Uri uri, Uri uri2, Uri uri3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = images.iconUri;
            }
            if ((i3 & 2) != 0) {
                uri2 = images.backgroundUri;
            }
            if ((i3 & 4) != 0) {
                uri3 = images.headerUri;
            }
            return images.copy(uri, uri2, uri3);
        }

        public final Uri component1() {
            return this.iconUri;
        }

        public final Uri component2() {
            return this.backgroundUri;
        }

        public final Uri component3() {
            return this.headerUri;
        }

        public final Images copy(Uri uri, Uri uri2, Uri uri3) {
            return new Images(uri, uri2, uri3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Images)) {
                return false;
            }
            Images images = (Images) obj;
            return Intrinsics.areEqual(this.iconUri, images.iconUri) && Intrinsics.areEqual(this.backgroundUri, images.backgroundUri) && Intrinsics.areEqual(this.headerUri, images.headerUri);
        }

        public final Uri getBackgroundUri() {
            return this.backgroundUri;
        }

        public final Uri getHeaderUri() {
            return this.headerUri;
        }

        public final Uri getIconUri() {
            return this.iconUri;
        }

        public int hashCode() {
            Uri uri = this.iconUri;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            Uri uri2 = this.backgroundUri;
            int iHashCode2 = (iHashCode + (uri2 == null ? 0 : uri2.hashCode())) * 31;
            Uri uri3 = this.headerUri;
            return iHashCode2 + (uri3 != null ? uri3.hashCode() : 0);
        }

        public String toString() {
            return "Images(iconUri=" + this.iconUri + ", backgroundUri=" + this.backgroundUri + ", headerUri=" + this.headerUri + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class PackageConfiguration {
        public static final int $stable = 0;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MultiPackage {
            public static final int $stable = 0;
            private final List<PackageInfo> all;

            /* JADX INFO: renamed from: default, reason: not valid java name */
            private final PackageInfo f31default;
            private final PackageInfo first;

            public MultiPackage(PackageInfo first, PackageInfo packageInfo, List<PackageInfo> all) {
                Intrinsics.checkNotNullParameter(first, "first");
                Intrinsics.checkNotNullParameter(packageInfo, "default");
                Intrinsics.checkNotNullParameter(all, "all");
                this.first = first;
                this.f31default = packageInfo;
                this.all = all;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MultiPackage copy$default(MultiPackage multiPackage, PackageInfo packageInfo, PackageInfo packageInfo2, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    packageInfo = multiPackage.first;
                }
                if ((i3 & 2) != 0) {
                    packageInfo2 = multiPackage.f31default;
                }
                if ((i3 & 4) != 0) {
                    list = multiPackage.all;
                }
                return multiPackage.copy(packageInfo, packageInfo2, list);
            }

            public final PackageInfo component1() {
                return this.first;
            }

            public final PackageInfo component2() {
                return this.f31default;
            }

            public final List<PackageInfo> component3() {
                return this.all;
            }

            public final MultiPackage copy(PackageInfo first, PackageInfo packageInfo, List<PackageInfo> all) {
                Intrinsics.checkNotNullParameter(first, "first");
                Intrinsics.checkNotNullParameter(packageInfo, "default");
                Intrinsics.checkNotNullParameter(all, "all");
                return new MultiPackage(first, packageInfo, all);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MultiPackage)) {
                    return false;
                }
                MultiPackage multiPackage = (MultiPackage) obj;
                return Intrinsics.areEqual(this.first, multiPackage.first) && Intrinsics.areEqual(this.f31default, multiPackage.f31default) && Intrinsics.areEqual(this.all, multiPackage.all);
            }

            public final List<PackageInfo> getAll() {
                return this.all;
            }

            public final PackageInfo getDefault() {
                return this.f31default;
            }

            public final PackageInfo getFirst() {
                return this.first;
            }

            public int hashCode() {
                return (((this.first.hashCode() * 31) + this.f31default.hashCode()) * 31) + this.all.hashCode();
            }

            public String toString() {
                return "MultiPackage(first=" + this.first + ", default=" + this.f31default + ", all=" + this.all + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MultiTier extends PackageConfiguration {
            public static final int $stable = 0;
            private final List<TierInfo> allTiers;
            private final TierInfo defaultTier;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MultiTier(TierInfo defaultTier, List<TierInfo> allTiers) {
                super(null);
                Intrinsics.checkNotNullParameter(defaultTier, "defaultTier");
                Intrinsics.checkNotNullParameter(allTiers, "allTiers");
                this.defaultTier = defaultTier;
                this.allTiers = allTiers;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MultiTier copy$default(MultiTier multiTier, TierInfo tierInfo, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    tierInfo = multiTier.defaultTier;
                }
                if ((i3 & 2) != 0) {
                    list = multiTier.allTiers;
                }
                return multiTier.copy(tierInfo, list);
            }

            public final TierInfo component1() {
                return this.defaultTier;
            }

            public final List<TierInfo> component2() {
                return this.allTiers;
            }

            public final MultiTier copy(TierInfo defaultTier, List<TierInfo> allTiers) {
                Intrinsics.checkNotNullParameter(defaultTier, "defaultTier");
                Intrinsics.checkNotNullParameter(allTiers, "allTiers");
                return new MultiTier(defaultTier, allTiers);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MultiTier)) {
                    return false;
                }
                MultiTier multiTier = (MultiTier) obj;
                return Intrinsics.areEqual(this.defaultTier, multiTier.defaultTier) && Intrinsics.areEqual(this.allTiers, multiTier.allTiers);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public List<PackageInfo> getAll() {
                List<TierInfo> list = this.allTiers;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((TierInfo) it.next()).getPackages());
                }
                return CollectionsKt.flatten(arrayList);
            }

            public final List<TierInfo> getAllTiers() {
                return this.allTiers;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public PackageInfo getDefault() {
                return this.defaultTier.getDefaultPackage();
            }

            public final TierInfo getDefaultTier() {
                return this.defaultTier;
            }

            public int hashCode() {
                return (this.defaultTier.hashCode() * 31) + this.allTiers.hashCode();
            }

            public String toString() {
                return "MultiTier(defaultTier=" + this.defaultTier + ", allTiers=" + this.allTiers + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Multiple extends PackageConfiguration {
            public static final int $stable = 0;
            private final MultiPackage multiPackage;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Multiple(MultiPackage multiPackage) {
                super(null);
                Intrinsics.checkNotNullParameter(multiPackage, "multiPackage");
                this.multiPackage = multiPackage;
            }

            public static /* synthetic */ Multiple copy$default(Multiple multiple, MultiPackage multiPackage, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    multiPackage = multiple.multiPackage;
                }
                return multiple.copy(multiPackage);
            }

            public final MultiPackage component1() {
                return this.multiPackage;
            }

            public final Multiple copy(MultiPackage multiPackage) {
                Intrinsics.checkNotNullParameter(multiPackage, "multiPackage");
                return new Multiple(multiPackage);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Multiple) && Intrinsics.areEqual(this.multiPackage, ((Multiple) obj).multiPackage);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public List<PackageInfo> getAll() {
                return this.multiPackage.getAll();
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public PackageInfo getDefault() {
                return this.multiPackage.getDefault();
            }

            public final MultiPackage getMultiPackage() {
                return this.multiPackage;
            }

            public int hashCode() {
                return this.multiPackage.hashCode();
            }

            public String toString() {
                return "Multiple(multiPackage=" + this.multiPackage + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Single extends PackageConfiguration {
            public static final int $stable = 0;
            private final PackageInfo singlePackage;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Single(PackageInfo singlePackage) {
                super(null);
                Intrinsics.checkNotNullParameter(singlePackage, "singlePackage");
                this.singlePackage = singlePackage;
            }

            public static /* synthetic */ Single copy$default(Single single, PackageInfo packageInfo, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    packageInfo = single.singlePackage;
                }
                return single.copy(packageInfo);
            }

            public final PackageInfo component1() {
                return this.singlePackage;
            }

            public final Single copy(PackageInfo singlePackage) {
                Intrinsics.checkNotNullParameter(singlePackage, "singlePackage");
                return new Single(singlePackage);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Single) && Intrinsics.areEqual(this.singlePackage, ((Single) obj).singlePackage);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public List<PackageInfo> getAll() {
                return CollectionsKt.listOf(this.singlePackage);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public PackageInfo getDefault() {
                return this.singlePackage;
            }

            public final PackageInfo getSinglePackage() {
                return this.singlePackage;
            }

            public int hashCode() {
                return this.singlePackage.hashCode();
            }

            public String toString() {
                return "Single(singlePackage=" + this.singlePackage + ')';
            }
        }

        public /* synthetic */ PackageConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract List<PackageInfo> getAll();

        public abstract PackageInfo getDefault();

        private PackageConfiguration() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PackageInfo {
        public static final int $stable = 0;
        private final Double discountRelativeToMostExpensivePerMonth;
        private final ProcessedLocalizedConfiguration localization;
        private final Package rcPackage;

        public PackageInfo(Package rcPackage, ProcessedLocalizedConfiguration localization, Double d3) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(localization, "localization");
            this.rcPackage = rcPackage;
            this.localization = localization;
            this.discountRelativeToMostExpensivePerMonth = d3;
        }

        public static /* synthetic */ PackageInfo copy$default(PackageInfo packageInfo, Package r12, ProcessedLocalizedConfiguration processedLocalizedConfiguration, Double d3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                r12 = packageInfo.rcPackage;
            }
            if ((i3 & 2) != 0) {
                processedLocalizedConfiguration = packageInfo.localization;
            }
            if ((i3 & 4) != 0) {
                d3 = packageInfo.discountRelativeToMostExpensivePerMonth;
            }
            return packageInfo.copy(r12, processedLocalizedConfiguration, d3);
        }

        public final Package component1() {
            return this.rcPackage;
        }

        public final ProcessedLocalizedConfiguration component2() {
            return this.localization;
        }

        public final Double component3() {
            return this.discountRelativeToMostExpensivePerMonth;
        }

        public final PackageInfo copy(Package rcPackage, ProcessedLocalizedConfiguration localization, Double d3) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(localization, "localization");
            return new PackageInfo(rcPackage, localization, d3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PackageInfo)) {
                return false;
            }
            PackageInfo packageInfo = (PackageInfo) obj;
            return Intrinsics.areEqual(this.rcPackage, packageInfo.rcPackage) && Intrinsics.areEqual(this.localization, packageInfo.localization) && Intrinsics.areEqual((Object) this.discountRelativeToMostExpensivePerMonth, (Object) packageInfo.discountRelativeToMostExpensivePerMonth);
        }

        public final Double getDiscountRelativeToMostExpensivePerMonth() {
            return this.discountRelativeToMostExpensivePerMonth;
        }

        public final ProcessedLocalizedConfiguration getLocalization() {
            return this.localization;
        }

        public final Package getRcPackage() {
            return this.rcPackage;
        }

        public int hashCode() {
            int iHashCode = ((this.rcPackage.hashCode() * 31) + this.localization.hashCode()) * 31;
            Double d3 = this.discountRelativeToMostExpensivePerMonth;
            return iHashCode + (d3 == null ? 0 : d3.hashCode());
        }

        public String toString() {
            return "PackageInfo(rcPackage=" + this.rcPackage + ", localization=" + this.localization + ", discountRelativeToMostExpensivePerMonth=" + this.discountRelativeToMostExpensivePerMonth + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TierInfo {
        public static final int $stable = 0;
        private final PackageInfo defaultPackage;
        private final String id;
        private final String name;
        private final List<PackageInfo> packages;

        public TierInfo(String name, String id, PackageInfo defaultPackage, List<PackageInfo> packages) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(defaultPackage, "defaultPackage");
            Intrinsics.checkNotNullParameter(packages, "packages");
            this.name = name;
            this.id = id;
            this.defaultPackage = defaultPackage;
            this.packages = packages;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TierInfo copy$default(TierInfo tierInfo, String str, String str2, PackageInfo packageInfo, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = tierInfo.name;
            }
            if ((i3 & 2) != 0) {
                str2 = tierInfo.id;
            }
            if ((i3 & 4) != 0) {
                packageInfo = tierInfo.defaultPackage;
            }
            if ((i3 & 8) != 0) {
                list = tierInfo.packages;
            }
            return tierInfo.copy(str, str2, packageInfo, list);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.id;
        }

        public final PackageInfo component3() {
            return this.defaultPackage;
        }

        public final List<PackageInfo> component4() {
            return this.packages;
        }

        public final TierInfo copy(String name, String id, PackageInfo defaultPackage, List<PackageInfo> packages) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(defaultPackage, "defaultPackage");
            Intrinsics.checkNotNullParameter(packages, "packages");
            return new TierInfo(name, id, defaultPackage, packages);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TierInfo)) {
                return false;
            }
            TierInfo tierInfo = (TierInfo) obj;
            return Intrinsics.areEqual(this.name, tierInfo.name) && Intrinsics.areEqual(this.id, tierInfo.id) && Intrinsics.areEqual(this.defaultPackage, tierInfo.defaultPackage) && Intrinsics.areEqual(this.packages, tierInfo.packages);
        }

        public final PackageInfo getDefaultPackage() {
            return this.defaultPackage;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final List<PackageInfo> getPackages() {
            return this.packages;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + this.defaultPackage.hashCode()) * 31) + this.packages.hashCode();
        }

        public String toString() {
            return "TierInfo(name=" + this.name + ", id=" + this.id + ", defaultPackage=" + this.defaultPackage + ", packages=" + this.packages + ')';
        }
    }

    public TemplateConfiguration(PaywallTemplate template, PaywallMode mode, PackageConfiguration packages, PaywallData.Configuration configuration, Images images, Map<String, Images> imagesByTier, PaywallData.Configuration.ColorInformation colors, Locale locale) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(imagesByTier, "imagesByTier");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.template = template;
        this.mode = mode;
        this.packages = packages;
        this.configuration = configuration;
        this.images = images;
        this.imagesByTier = imagesByTier;
        this.colors = colors;
        this.locale = locale;
        ColorsFactory colorsFactory = ColorsFactory.INSTANCE;
        PaywallData.Configuration.Colors dark = colors.getDark();
        this.darkModeColors = colorsFactory.create(dark == null ? colors.getLight() : dark);
        this.lightModeColors = colorsFactory.create(colors.getLight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TemplateConfiguration copy$default(TemplateConfiguration templateConfiguration, PaywallTemplate paywallTemplate, PaywallMode paywallMode, PackageConfiguration packageConfiguration, PaywallData.Configuration configuration, Images images, Map map, PaywallData.Configuration.ColorInformation colorInformation, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            paywallTemplate = templateConfiguration.template;
        }
        if ((i3 & 2) != 0) {
            paywallMode = templateConfiguration.mode;
        }
        if ((i3 & 4) != 0) {
            packageConfiguration = templateConfiguration.packages;
        }
        if ((i3 & 8) != 0) {
            configuration = templateConfiguration.configuration;
        }
        if ((i3 & 16) != 0) {
            images = templateConfiguration.images;
        }
        if ((i3 & 32) != 0) {
            map = templateConfiguration.imagesByTier;
        }
        if ((i3 & 64) != 0) {
            colorInformation = templateConfiguration.colors;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            locale = templateConfiguration.locale;
        }
        PaywallData.Configuration.ColorInformation colorInformation2 = colorInformation;
        Locale locale2 = locale;
        Images images2 = images;
        Map map2 = map;
        return templateConfiguration.copy(paywallTemplate, paywallMode, packageConfiguration, configuration, images2, map2, colorInformation2, locale2);
    }

    public final PaywallTemplate component1() {
        return this.template;
    }

    public final PaywallMode component2() {
        return this.mode;
    }

    public final PackageConfiguration component3() {
        return this.packages;
    }

    public final PaywallData.Configuration component4() {
        return this.configuration;
    }

    public final Images component5() {
        return this.images;
    }

    public final Map<String, Images> component6() {
        return this.imagesByTier;
    }

    public final PaywallData.Configuration.ColorInformation component7() {
        return this.colors;
    }

    public final Locale component8() {
        return this.locale;
    }

    public final TemplateConfiguration copy(PaywallTemplate template, PaywallMode mode, PackageConfiguration packages, PaywallData.Configuration configuration, Images images, Map<String, Images> imagesByTier, PaywallData.Configuration.ColorInformation colors, Locale locale) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(imagesByTier, "imagesByTier");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new TemplateConfiguration(template, mode, packages, configuration, images, imagesByTier, colors, locale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemplateConfiguration)) {
            return false;
        }
        TemplateConfiguration templateConfiguration = (TemplateConfiguration) obj;
        return this.template == templateConfiguration.template && this.mode == templateConfiguration.mode && Intrinsics.areEqual(this.packages, templateConfiguration.packages) && Intrinsics.areEqual(this.configuration, templateConfiguration.configuration) && Intrinsics.areEqual(this.images, templateConfiguration.images) && Intrinsics.areEqual(this.imagesByTier, templateConfiguration.imagesByTier) && Intrinsics.areEqual(this.colors, templateConfiguration.colors) && Intrinsics.areEqual(this.locale, templateConfiguration.locale);
    }

    public final PaywallData.Configuration.ColorInformation getColors() {
        return this.colors;
    }

    public final PaywallData.Configuration getConfiguration() {
        return this.configuration;
    }

    public final Colors getCurrentColors(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1598555926, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.getCurrentColors (TemplateConfiguration.kt:30)");
        }
        Colors colors = DarkThemeKt.a(composer, 0) ? this.darkModeColors : this.lightModeColors;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return colors;
    }

    public final Colors getCurrentColorsForTier(TierInfo tier, Composer composer, int i3) {
        Colors colorsCreate;
        Intrinsics.checkNotNullParameter(tier, "tier");
        if (ComposerKt.M()) {
            ComposerKt.U(844077603, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.getCurrentColorsForTier (TemplateConfiguration.kt:36)");
        }
        Map<String, PaywallData.Configuration.ColorInformation> colorsByTier = this.configuration.getColorsByTier();
        Colors currentColors = null;
        PaywallData.Configuration.ColorInformation colorInformation = colorsByTier != null ? colorsByTier.get(tier.getId()) : null;
        if (colorInformation != null) {
            if (DarkThemeKt.a(composer, 0)) {
                ColorsFactory colorsFactory = ColorsFactory.INSTANCE;
                PaywallData.Configuration.Colors dark = colorInformation.getDark();
                if (dark == null) {
                    dark = colorInformation.getLight();
                }
                colorsCreate = colorsFactory.create(dark);
            } else {
                colorsCreate = ColorsFactory.INSTANCE.create(colorInformation.getLight());
            }
            currentColors = colorsCreate;
        }
        if (currentColors == null) {
            currentColors = getCurrentColors(composer, (i3 >> 3) & 14);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return currentColors;
    }

    public final Images getImages() {
        return this.images;
    }

    public final Map<String, Images> getImagesByTier() {
        return this.imagesByTier;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final PaywallMode getMode() {
        return this.mode;
    }

    public final PackageConfiguration getPackages() {
        return this.packages;
    }

    public final PaywallTemplate getTemplate() {
        return this.template;
    }

    public int hashCode() {
        return (((((((((((((this.template.hashCode() * 31) + this.mode.hashCode()) * 31) + this.packages.hashCode()) * 31) + this.configuration.hashCode()) * 31) + this.images.hashCode()) * 31) + this.imagesByTier.hashCode()) * 31) + this.colors.hashCode()) * 31) + this.locale.hashCode();
    }

    public String toString() {
        return "TemplateConfiguration(template=" + this.template + ", mode=" + this.mode + ", packages=" + this.packages + ", configuration=" + this.configuration + ", images=" + this.images + ", imagesByTier=" + this.imagesByTier + ", colors=" + this.colors + ", locale=" + this.locale + ')';
    }
}
