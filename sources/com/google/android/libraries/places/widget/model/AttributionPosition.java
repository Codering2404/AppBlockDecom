package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class AttributionPosition implements Parcelable {
    public static final Parcelable.Creator<AttributionPosition> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AttributionPosition f79378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AttributionPosition f79379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AttributionPosition[] f79380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f79381d;

    static {
        AttributionPosition attributionPosition = new AttributionPosition("TOP", 0);
        f79378a = attributionPosition;
        AttributionPosition attributionPosition2 = new AttributionPosition("BOTTOM", 1);
        f79379b = attributionPosition2;
        AttributionPosition[] attributionPositionArr = {attributionPosition, attributionPosition2};
        f79380c = attributionPositionArr;
        f79381d = EnumEntriesKt.a(attributionPositionArr);
        CREATOR = new Parcelable.Creator() { // from class: com.google.android.libraries.places.widget.model.zza
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return AttributionPosition.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i3) {
                return new AttributionPosition[i3];
            }
        };
    }

    private AttributionPosition(String str, int i3) {
    }

    public static AttributionPosition valueOf(String str) {
        return (AttributionPosition) Enum.valueOf(AttributionPosition.class, str);
    }

    public static AttributionPosition[] values() {
        return (AttributionPosition[]) f79380c.clone();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }
}
