package com.revenuecat.purchases.ads.events.types;

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
public final class AdMediatorName {
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final String AD_MOB = m494constructorimpl("AdMob");
    private static final String APP_LOVIN = m494constructorimpl("AppLovin");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: fromString-CJOXPJU, reason: not valid java name */
        public final String m500fromStringCJOXPJU(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String string = StringsKt.t1(value).toString();
            return Intrinsics.areEqual(string, "AdMob") ? m501getAD_MOBGyoM_N4() : Intrinsics.areEqual(string, "AppLovin") ? m502getAPP_LOVINGyoM_N4() : AdMediatorName.m494constructorimpl(value);
        }

        /* JADX INFO: renamed from: getAD_MOB-GyoM_N4, reason: not valid java name */
        public final String m501getAD_MOBGyoM_N4() {
            return AdMediatorName.AD_MOB;
        }

        /* JADX INFO: renamed from: getAPP_LOVIN-GyoM_N4, reason: not valid java name */
        public final String m502getAPP_LOVINGyoM_N4() {
            return AdMediatorName.APP_LOVIN;
        }

        private Companion() {
        }
    }

    private /* synthetic */ AdMediatorName(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AdMediatorName m493boximpl(String str) {
        return new AdMediatorName(str);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m494constructorimpl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m495equalsimpl(String str, Object obj) {
        return (obj instanceof AdMediatorName) && Intrinsics.areEqual(str, ((AdMediatorName) obj).m499unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m496equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m497hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m498toStringimpl(String str) {
        return "AdMediatorName(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m495equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m497hashCodeimpl(this.value);
    }

    public String toString() {
        return m498toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m499unboximpl() {
        return this.value;
    }
}
