package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

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
public final class CustomerCenterConstants {
    public static final int $stable = 0;
    public static final CustomerCenterConstants INSTANCE = new CustomerCenterConstants();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Card {
        public static final int $stable = 0;
        private static final float BADGE_CORNER_SIZE;
        private static final float CARD_PADDING;
        public static final long COLOR_BADGE_ACTIVE = 2568082563L;
        public static final int COLOR_BADGE_CANCELLED = 871519323;
        public static final int COLOR_BADGE_EXPIRED = 438115104;
        public static final int COLOR_BADGE_FREE_TRIAL = 1542834780;
        public static final float LIFETIME_BORDER_ALPHA = 0.29f;
        private static final float MIDDLE_CORNER_SIZE;
        private static final float ROUNDED_CORNER_SIZE;
        private static final float TITLE_ROW_BOTTOM_PADDING;
        public static final Card INSTANCE = new Card();
        private static final float BADGE_HORIZONTAL_PADDING = Dp.g(8);
        private static final float BADGE_VERTICAL_PADDING = Dp.g(2);

        static {
            float f3 = 24;
            ROUNDED_CORNER_SIZE = Dp.g(f3);
            float f4 = 4;
            MIDDLE_CORNER_SIZE = Dp.g(f4);
            BADGE_CORNER_SIZE = Dp.g(f4);
            CARD_PADDING = Dp.g(f3);
            TITLE_ROW_BOTTOM_PADDING = Dp.g(f4);
        }

        private Card() {
        }

        /* JADX INFO: renamed from: getBADGE_CORNER_SIZE-D9Ej5fM, reason: not valid java name */
        public final float m952getBADGE_CORNER_SIZED9Ej5fM() {
            return BADGE_CORNER_SIZE;
        }

        /* JADX INFO: renamed from: getBADGE_HORIZONTAL_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m953getBADGE_HORIZONTAL_PADDINGD9Ej5fM() {
            return BADGE_HORIZONTAL_PADDING;
        }

        /* JADX INFO: renamed from: getBADGE_VERTICAL_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m954getBADGE_VERTICAL_PADDINGD9Ej5fM() {
            return BADGE_VERTICAL_PADDING;
        }

        /* JADX INFO: renamed from: getCARD_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m955getCARD_PADDINGD9Ej5fM() {
            return CARD_PADDING;
        }

        /* JADX INFO: renamed from: getMIDDLE_CORNER_SIZE-D9Ej5fM, reason: not valid java name */
        public final float m956getMIDDLE_CORNER_SIZED9Ej5fM() {
            return MIDDLE_CORNER_SIZE;
        }

        /* JADX INFO: renamed from: getROUNDED_CORNER_SIZE-D9Ej5fM, reason: not valid java name */
        public final float m957getROUNDED_CORNER_SIZED9Ej5fM() {
            return ROUNDED_CORNER_SIZE;
        }

        /* JADX INFO: renamed from: getTITLE_ROW_BOTTOM_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m958getTITLE_ROW_BOTTOM_PADDINGD9Ej5fM() {
            return TITLE_ROW_BOTTOM_PADDING;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Layout {
        public static final int $stable = 0;
        private static final float BUTTONS_BOTTOM_PADDING;
        private static final float BUTTONS_TOP_PADDING;
        private static final float SECTION_SPACING;
        private static final float SECTION_TITLE_BOTTOM_PADDING;
        private static final float TOP_PADDING_AFTER_TOP_BAR;
        public static final Layout INSTANCE = new Layout();
        private static final float HORIZONTAL_PADDING = Dp.g(16);
        private static final float ITEMS_SPACING = Dp.g(2);
        private static final float BUTTONS_SPACING = Dp.g(12);

        static {
            float f3 = 8;
            TOP_PADDING_AFTER_TOP_BAR = Dp.g(f3);
            float f4 = 24;
            SECTION_SPACING = Dp.g(f4);
            SECTION_TITLE_BOTTOM_PADDING = Dp.g(f3);
            BUTTONS_TOP_PADDING = Dp.g(f4);
            BUTTONS_BOTTOM_PADDING = Dp.g(f4);
        }

        private Layout() {
        }

        /* JADX INFO: renamed from: getBUTTONS_BOTTOM_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m959getBUTTONS_BOTTOM_PADDINGD9Ej5fM() {
            return BUTTONS_BOTTOM_PADDING;
        }

        /* JADX INFO: renamed from: getBUTTONS_SPACING-D9Ej5fM, reason: not valid java name */
        public final float m960getBUTTONS_SPACINGD9Ej5fM() {
            return BUTTONS_SPACING;
        }

        /* JADX INFO: renamed from: getBUTTONS_TOP_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m961getBUTTONS_TOP_PADDINGD9Ej5fM() {
            return BUTTONS_TOP_PADDING;
        }

        /* JADX INFO: renamed from: getHORIZONTAL_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m962getHORIZONTAL_PADDINGD9Ej5fM() {
            return HORIZONTAL_PADDING;
        }

        /* JADX INFO: renamed from: getITEMS_SPACING-D9Ej5fM, reason: not valid java name */
        public final float m963getITEMS_SPACINGD9Ej5fM() {
            return ITEMS_SPACING;
        }

        /* JADX INFO: renamed from: getSECTION_SPACING-D9Ej5fM, reason: not valid java name */
        public final float m964getSECTION_SPACINGD9Ej5fM() {
            return SECTION_SPACING;
        }

        /* JADX INFO: renamed from: getSECTION_TITLE_BOTTOM_PADDING-D9Ej5fM, reason: not valid java name */
        public final float m965getSECTION_TITLE_BOTTOM_PADDINGD9Ej5fM() {
            return SECTION_TITLE_BOTTOM_PADDING;
        }

        /* JADX INFO: renamed from: getTOP_PADDING_AFTER_TOP_BAR-D9Ej5fM, reason: not valid java name */
        public final float m966getTOP_PADDING_AFTER_TOP_BARD9Ej5fM() {
            return TOP_PADDING_AFTER_TOP_BAR;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Management {
        public static final int $stable = 0;
        public static final String AMAZON_MANAGEMENT_URL = "amzn://apps/library/subscriptions";
        public static final Management INSTANCE = new Management();
        public static final String MANAGEMENT_URL = "https://play.google.com/store/account/subscriptions";

        private Management() {
        }
    }

    private CustomerCenterConstants() {
    }
}
