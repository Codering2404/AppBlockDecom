package com.revenuecat.purchases.ui.revenuecatui.composables;

import com.revenuecat.purchases.ui.revenuecatui.R;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public enum PaywallIconName {
    ADD,
    ANDROID,
    APPLE,
    ATTACH_MONEY,
    ATTACHMENT,
    BAR_CHART,
    BOOKMARK,
    BOOKMARK_NO_FILL,
    CALENDAR_TODAY,
    CHAT_BUBBLE,
    CHECK_CIRCLE,
    CLOSE,
    COLLAPSE,
    COMPARE,
    DOWNLOAD,
    EDIT,
    EMAIL,
    ERROR,
    EXPERIMENTS,
    EXTENSION,
    FILE_COPY,
    FILTER_LIST,
    FOLDER,
    GLOBE,
    HELP,
    INSERT_DRIVE_FILE,
    LAUNCH,
    LAYERS,
    LINE_CHART,
    LOCK,
    NOTIFICATION,
    PERSON,
    PHONE,
    PLAY_CIRCLE,
    REMOVE_RED_EYE,
    SEARCH,
    SHARE,
    SMARTPHONE,
    STACKED_BAR,
    STARS,
    SUBTRACT,
    TICK,
    TRANSFER,
    TWO_WAY_ARROWS,
    KEY,
    WARNING;

    public static final Companion Companion = new Companion(null);
    private static final Map<String, PaywallIconName> valueMap;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallIconName fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (PaywallIconName) PaywallIconName.valueMap.get(value);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaywallIconName.values().length];
            try {
                iArr[PaywallIconName.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallIconName.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallIconName.ANDROID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallIconName.APPLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaywallIconName.ATTACH_MONEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaywallIconName.ATTACHMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PaywallIconName.BAR_CHART.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PaywallIconName.BOOKMARK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PaywallIconName.BOOKMARK_NO_FILL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PaywallIconName.CALENDAR_TODAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PaywallIconName.CHAT_BUBBLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PaywallIconName.CHECK_CIRCLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PaywallIconName.CLOSE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PaywallIconName.COLLAPSE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PaywallIconName.COMPARE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PaywallIconName.DOWNLOAD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PaywallIconName.EDIT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PaywallIconName.EMAIL.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PaywallIconName.ERROR.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PaywallIconName.EXPERIMENTS.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PaywallIconName.EXTENSION.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PaywallIconName.FILE_COPY.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PaywallIconName.FILTER_LIST.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PaywallIconName.FOLDER.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PaywallIconName.GLOBE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PaywallIconName.HELP.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PaywallIconName.INSERT_DRIVE_FILE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[PaywallIconName.LAUNCH.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[PaywallIconName.LAYERS.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[PaywallIconName.LINE_CHART.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[PaywallIconName.LOCK.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[PaywallIconName.NOTIFICATION.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[PaywallIconName.PERSON.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[PaywallIconName.PHONE.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[PaywallIconName.PLAY_CIRCLE.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[PaywallIconName.REMOVE_RED_EYE.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[PaywallIconName.SEARCH.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[PaywallIconName.SHARE.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[PaywallIconName.SMARTPHONE.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[PaywallIconName.STACKED_BAR.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[PaywallIconName.STARS.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[PaywallIconName.SUBTRACT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[PaywallIconName.TICK.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[PaywallIconName.TRANSFER.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[PaywallIconName.TWO_WAY_ARROWS.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[PaywallIconName.KEY.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        PaywallIconName[] paywallIconNameArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(paywallIconNameArrValues.length), 16));
        for (PaywallIconName paywallIconName : paywallIconNameArrValues) {
            String lowerCase = paywallIconName.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, paywallIconName);
        }
        valueMap = linkedHashMap;
    }

    public final int drawable$revenuecatui_defaultsBc8Release() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return R.drawable.warning;
            case 2:
                return R.drawable.add;
            case 3:
                return R.drawable.f92317android;
            case 4:
                return R.drawable.apple;
            case 5:
                return R.drawable.attach_money;
            case 6:
                return R.drawable.attachment;
            case 7:
                return R.drawable.bar_chart;
            case 8:
                return R.drawable.bookmark;
            case 9:
                return R.drawable.bookmark_no_fill;
            case 10:
                return R.drawable.calendar_today;
            case 11:
                return R.drawable.chat_bubble;
            case 12:
                return R.drawable.check_circle;
            case 13:
                return R.drawable.close;
            case 14:
                return R.drawable.collapse;
            case 15:
                return R.drawable.compare;
            case 16:
                return R.drawable.download;
            case 17:
                return R.drawable.edit;
            case 18:
                return R.drawable.email;
            case 19:
                return R.drawable.error;
            case 20:
                return R.drawable.experiments;
            case 21:
                return R.drawable.extension;
            case 22:
                return R.drawable.file_copy;
            case 23:
                return R.drawable.filter_list;
            case 24:
                return R.drawable.folder;
            case 25:
                return R.drawable.globe;
            case 26:
                return R.drawable.help;
            case 27:
                return R.drawable.insert_drive_file;
            case 28:
                return R.drawable.launch;
            case 29:
                return R.drawable.layers;
            case 30:
                return R.drawable.line_chart;
            case 31:
                return R.drawable.lock;
            case 32:
                return R.drawable.notifications;
            case 33:
                return R.drawable.person;
            case 34:
                return R.drawable.phone;
            case 35:
                return R.drawable.play_circle;
            case 36:
                return R.drawable.remove_red_eye;
            case 37:
                return R.drawable.search;
            case 38:
                return R.drawable.share;
            case 39:
                return R.drawable.smartphone;
            case 40:
                return R.drawable.stacked_bar;
            case 41:
                return R.drawable.stars;
            case 42:
                return R.drawable.subtract;
            case 43:
                return R.drawable.tick;
            case 44:
                return R.drawable.transfer;
            case 45:
                return R.drawable.two_way_arrows;
            case 46:
                return R.drawable.vpn_key;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
