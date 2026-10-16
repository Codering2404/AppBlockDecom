package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.facebook.appevents.AppEventsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TEMPLATE_1' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
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
public final class PaywallTemplate {
    private static final /* synthetic */ PaywallTemplate[] $VALUES;
    public static final Companion Companion;
    public static final PaywallTemplate TEMPLATE_1;
    public static final PaywallTemplate TEMPLATE_2;
    public static final PaywallTemplate TEMPLATE_3;
    public static final PaywallTemplate TEMPLATE_4;
    public static final PaywallTemplate TEMPLATE_5;
    public static final PaywallTemplate TEMPLATE_7;
    private final PackageConfigurationType configurationType;
    private final String id;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallTemplate fromId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            for (PaywallTemplate paywallTemplate : PaywallTemplate.values()) {
                if (Intrinsics.areEqual(paywallTemplate.getId(), id)) {
                    return paywallTemplate;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PaywallTemplate[] $values() {
        return new PaywallTemplate[]{TEMPLATE_1, TEMPLATE_2, TEMPLATE_3, TEMPLATE_4, TEMPLATE_5, TEMPLATE_7};
    }

    static {
        PackageConfigurationType packageConfigurationType = PackageConfigurationType.SINGLE;
        TEMPLATE_1 = new PaywallTemplate("TEMPLATE_1", 0, AppEventsConstants.EVENT_PARAM_VALUE_YES, packageConfigurationType);
        PackageConfigurationType packageConfigurationType2 = PackageConfigurationType.MULTIPLE;
        TEMPLATE_2 = new PaywallTemplate("TEMPLATE_2", 1, "2", packageConfigurationType2);
        TEMPLATE_3 = new PaywallTemplate("TEMPLATE_3", 2, "3", packageConfigurationType);
        TEMPLATE_4 = new PaywallTemplate("TEMPLATE_4", 3, "4", packageConfigurationType2);
        TEMPLATE_5 = new PaywallTemplate("TEMPLATE_5", 4, "5", packageConfigurationType2);
        TEMPLATE_7 = new PaywallTemplate("TEMPLATE_7", 5, "7", PackageConfigurationType.MULTITIER);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private PaywallTemplate(String str, int i3, String str2, PackageConfigurationType packageConfigurationType) {
        this.id = str2;
        this.configurationType = packageConfigurationType;
    }

    public static PaywallTemplate valueOf(String str) {
        return (PaywallTemplate) Enum.valueOf(PaywallTemplate.class, str);
    }

    public static PaywallTemplate[] values() {
        return (PaywallTemplate[]) $VALUES.clone();
    }

    public final PackageConfigurationType getConfigurationType() {
        return this.configurationType;
    }

    public final String getId() {
        return this.id;
    }
}
