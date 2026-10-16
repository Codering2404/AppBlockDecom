package com.superwall.sdk.paywall.presentation;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class CustomCallbackBehavior {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CustomCallbackBehavior[] $VALUES;
    public static final Companion Companion;
    private final String rawValue;
    public static final CustomCallbackBehavior BLOCKING = new CustomCallbackBehavior("BLOCKING", 0, "blocking");
    public static final CustomCallbackBehavior NON_BLOCKING = new CustomCallbackBehavior("NON_BLOCKING", 1, "non-blocking");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomCallbackBehavior fromRaw(String rawValue) {
            CustomCallbackBehavior next;
            Intrinsics.checkNotNullParameter(rawValue, "rawValue");
            Iterator<CustomCallbackBehavior> it = CustomCallbackBehavior.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getRawValue(), rawValue)) {
                    break;
                }
            }
            return next;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ CustomCallbackBehavior[] $values() {
        return new CustomCallbackBehavior[]{BLOCKING, NON_BLOCKING};
    }

    static {
        CustomCallbackBehavior[] customCallbackBehaviorArr$values = $values();
        $VALUES = customCallbackBehaviorArr$values;
        $ENTRIES = EnumEntriesKt.a(customCallbackBehaviorArr$values);
        Companion = new Companion(null);
    }

    private CustomCallbackBehavior(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<CustomCallbackBehavior> getEntries() {
        return $ENTRIES;
    }

    public static CustomCallbackBehavior valueOf(String str) {
        return (CustomCallbackBehavior) Enum.valueOf(CustomCallbackBehavior.class, str);
    }

    public static CustomCallbackBehavior[] values() {
        return (CustomCallbackBehavior[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
