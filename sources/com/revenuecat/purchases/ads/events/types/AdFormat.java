package com.revenuecat.purchases.ads.events.types;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@JvmInline
public final class AdFormat {
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final String OTHER = m477constructorimpl("other");
    private static final String BANNER = m477constructorimpl("banner");
    private static final String INTERSTITIAL = m477constructorimpl("interstitial");
    private static final String REWARDED = m477constructorimpl("rewarded");
    private static final String REWARDED_INTERSTITIAL = m477constructorimpl("rewarded_interstitial");
    private static final String NATIVE = m477constructorimpl(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
    private static final String APP_OPEN = m477constructorimpl("app_open");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX INFO: renamed from: fromString-XxFlno4, reason: not valid java name */
        public final String m483fromStringXxFlno4(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String string = StringsKt.t1(value).toString();
            switch (string.hashCode()) {
                case -1396342996:
                    if (string.equals("banner")) {
                        return m485getBANNERy0COY5Q();
                    }
                    break;
                case -1052618729:
                    if (string.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                        return m487getNATIVEy0COY5Q();
                    }
                    break;
                case -239580146:
                    if (string.equals("rewarded")) {
                        return m489getREWARDEDy0COY5Q();
                    }
                    break;
                case 106069776:
                    if (string.equals("other")) {
                        return m488getOTHERy0COY5Q();
                    }
                    break;
                case 604727084:
                    if (string.equals("interstitial")) {
                        return m486getINTERSTITIALy0COY5Q();
                    }
                    break;
                case 1167692200:
                    if (string.equals("app_open")) {
                        return m484getAPP_OPENy0COY5Q();
                    }
                    break;
                case 1911491517:
                    if (string.equals("rewarded_interstitial")) {
                        return m490getREWARDED_INTERSTITIALy0COY5Q();
                    }
                    break;
            }
            return AdFormat.m477constructorimpl(value);
        }

        /* JADX INFO: renamed from: getAPP_OPEN-y0COY5Q, reason: not valid java name */
        public final String m484getAPP_OPENy0COY5Q() {
            return AdFormat.APP_OPEN;
        }

        /* JADX INFO: renamed from: getBANNER-y0COY5Q, reason: not valid java name */
        public final String m485getBANNERy0COY5Q() {
            return AdFormat.BANNER;
        }

        /* JADX INFO: renamed from: getINTERSTITIAL-y0COY5Q, reason: not valid java name */
        public final String m486getINTERSTITIALy0COY5Q() {
            return AdFormat.INTERSTITIAL;
        }

        /* JADX INFO: renamed from: getNATIVE-y0COY5Q, reason: not valid java name */
        public final String m487getNATIVEy0COY5Q() {
            return AdFormat.NATIVE;
        }

        /* JADX INFO: renamed from: getOTHER-y0COY5Q, reason: not valid java name */
        public final String m488getOTHERy0COY5Q() {
            return AdFormat.OTHER;
        }

        /* JADX INFO: renamed from: getREWARDED-y0COY5Q, reason: not valid java name */
        public final String m489getREWARDEDy0COY5Q() {
            return AdFormat.REWARDED;
        }

        /* JADX INFO: renamed from: getREWARDED_INTERSTITIAL-y0COY5Q, reason: not valid java name */
        public final String m490getREWARDED_INTERSTITIALy0COY5Q() {
            return AdFormat.REWARDED_INTERSTITIAL;
        }

        private Companion() {
        }
    }

    private /* synthetic */ AdFormat(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdFormat m476boximpl(String str) {
        return new AdFormat(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m477constructorimpl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m478equalsimpl(String str, Object obj) {
        return (obj instanceof AdFormat) && Intrinsics.areEqual(str, ((AdFormat) obj).m482unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m479equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m480hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m481toStringimpl(String str) {
        return "AdFormat(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m478equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m480hashCodeimpl(this.value);
    }

    public String toString() {
        return m481toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m482unboximpl() {
        return this.value;
    }
}
