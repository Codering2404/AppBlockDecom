package com.revenuecat.purchases.ads.events.types;

import coil.target.Yb.oUcQRqOVfOC;
import java.util.Locale;
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
public final class AdRevenuePrecision {
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final String EXACT = m509constructorimpl("exact");
    private static final String PUBLISHER_DEFINED = m509constructorimpl("publisher_defined");
    private static final String ESTIMATED = m509constructorimpl("estimated");
    private static final String UNKNOWN = m509constructorimpl("unknown");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getESTIMATED-rAcPn4k, reason: not valid java name */
        public final String m516getESTIMATEDrAcPn4k() {
            return AdRevenuePrecision.ESTIMATED;
        }

        /* JADX INFO: renamed from: getEXACT-rAcPn4k, reason: not valid java name */
        public final String m517getEXACTrAcPn4k() {
            return AdRevenuePrecision.EXACT;
        }

        /* JADX INFO: renamed from: getPUBLISHER_DEFINED-rAcPn4k, reason: not valid java name */
        public final String m518getPUBLISHER_DEFINEDrAcPn4k() {
            return AdRevenuePrecision.PUBLISHER_DEFINED;
        }

        /* JADX INFO: renamed from: getUNKNOWN-rAcPn4k, reason: not valid java name */
        public final String m519getUNKNOWNrAcPn4k() {
            return AdRevenuePrecision.UNKNOWN;
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fromString-QAIqrgA, reason: not valid java name */
        public final String m515fromStringQAIqrgA(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String lowerCase = value.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = StringsKt.t1(lowerCase).toString();
            switch (string.hashCode()) {
                case -623607748:
                    if (string.equals(oUcQRqOVfOC.yNCGCxHboRLSEHU)) {
                        return m516getESTIMATEDrAcPn4k();
                    }
                    break;
                case -284840886:
                    if (string.equals("unknown")) {
                        return m519getUNKNOWNrAcPn4k();
                    }
                    break;
                case 96946943:
                    if (string.equals("exact")) {
                        return m517getEXACTrAcPn4k();
                    }
                    break;
                case 655944390:
                    if (string.equals("publisher_defined")) {
                        return m518getPUBLISHER_DEFINEDrAcPn4k();
                    }
                    break;
            }
            return AdRevenuePrecision.m509constructorimpl(value);
        }
    }

    private /* synthetic */ AdRevenuePrecision(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdRevenuePrecision m508boximpl(String str) {
        return new AdRevenuePrecision(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m509constructorimpl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m510equalsimpl(String str, Object obj) {
        return (obj instanceof AdRevenuePrecision) && Intrinsics.areEqual(str, ((AdRevenuePrecision) obj).m514unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m511equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m512hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m513toStringimpl(String str) {
        return "AdRevenuePrecision(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m510equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m512hashCodeimpl(this.value);
    }

    public String toString() {
        return m513toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m514unboximpl() {
        return this.value;
    }
}
