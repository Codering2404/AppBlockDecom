package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class DataCollectionState implements NumberedEnum {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DataCollectionState f89941b = new DataCollectionState("COLLECTION_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DataCollectionState f89942c = new DataCollectionState("COLLECTION_SDK_NOT_INSTALLED", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DataCollectionState f89943d = new DataCollectionState("COLLECTION_ENABLED", 2, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DataCollectionState f89944f = new DataCollectionState("COLLECTION_DISABLED", 3, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DataCollectionState f89945g = new DataCollectionState("COLLECTION_DISABLED_REMOTE", 4, 4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DataCollectionState f89946h = new DataCollectionState("COLLECTION_SAMPLED", 5, 5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ DataCollectionState[] f89947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f89948j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89949a;

    static {
        DataCollectionState[] dataCollectionStateArrA = a();
        f89947i = dataCollectionStateArrA;
        f89948j = EnumEntriesKt.a(dataCollectionStateArrA);
    }

    private DataCollectionState(String str, int i3, int i4) {
        this.f89949a = i4;
    }

    private static final /* synthetic */ DataCollectionState[] a() {
        return new DataCollectionState[]{f89941b, f89942c, f89943d, f89944f, f89945g, f89946h};
    }

    public static DataCollectionState valueOf(String str) {
        return (DataCollectionState) Enum.valueOf(DataCollectionState.class, str);
    }

    public static DataCollectionState[] values() {
        return (DataCollectionState[]) f89947i.clone();
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int J() {
        return this.f89949a;
    }
}
