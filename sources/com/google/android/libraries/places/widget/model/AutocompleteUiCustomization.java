package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class AutocompleteUiCustomization implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AutocompleteListDensity f79390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f79391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AutocompleteUiIcon f79392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f79393d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f79394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f79389g = new Companion(null);
    public static final Parcelable.Creator<AutocompleteUiCustomization> CREATOR = new zzd();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public /* synthetic */ AutocompleteUiCustomization(AutocompleteListDensity autocompleteListDensity, String str, AutocompleteUiIcon autocompleteUiIcon, String str2, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this.f79390a = autocompleteListDensity;
        this.f79391b = str;
        this.f79392c = autocompleteUiIcon;
        this.f79393d = str2;
        this.f79394f = num;
    }

    public final AutocompleteListDensity c() {
        return this.f79390a;
    }

    public final AutocompleteUiIcon d() {
        return this.f79392c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Integer e() {
        return this.f79394f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteUiCustomization)) {
            return false;
        }
        AutocompleteListDensity autocompleteListDensityC = c();
        String strName = autocompleteListDensityC != null ? autocompleteListDensityC.name() : null;
        AutocompleteUiCustomization autocompleteUiCustomization = (AutocompleteUiCustomization) obj;
        AutocompleteListDensity autocompleteListDensityC2 = autocompleteUiCustomization.c();
        if (Intrinsics.areEqual(strName, autocompleteListDensityC2 != null ? autocompleteListDensityC2.name() : null) && Intrinsics.areEqual(this.f79391b, autocompleteUiCustomization.f79391b)) {
            AutocompleteUiIcon autocompleteUiIconD = d();
            Integer numValueOf = autocompleteUiIconD != null ? Integer.valueOf(autocompleteUiIconD.c()) : null;
            AutocompleteUiIcon autocompleteUiIconD2 = autocompleteUiCustomization.d();
            if (Intrinsics.areEqual(numValueOf, autocompleteUiIconD2 != null ? Integer.valueOf(autocompleteUiIconD2.c()) : null) && Intrinsics.areEqual(this.f79393d, autocompleteUiCustomization.f79393d) && Intrinsics.areEqual(e(), autocompleteUiCustomization.e())) {
                return true;
            }
        }
        return false;
    }

    public final String f() {
        return this.f79391b;
    }

    public final String g() {
        return this.f79393d;
    }

    public final int hashCode() {
        String strName;
        AutocompleteListDensity autocompleteListDensityC = c();
        int iHashCode = (autocompleteListDensityC == null || (strName = autocompleteListDensityC.name()) == null) ? 0 : strName.hashCode();
        String str = this.f79391b;
        int iHashCode2 = str != null ? str.hashCode() : 0;
        int i3 = iHashCode * 31;
        AutocompleteUiIcon autocompleteUiIconD = d();
        int iHashCode3 = (((i3 + iHashCode2) * 31) + (autocompleteUiIconD != null ? Integer.valueOf(autocompleteUiIconD.c()).hashCode() : 0)) * 31;
        String str2 = this.f79393d;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer numE = e();
        return iHashCode4 + (numE != null ? numE.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        AutocompleteListDensity autocompleteListDensity = this.f79390a;
        if (autocompleteListDensity == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            autocompleteListDensity.writeToParcel(dest, i3);
        }
        dest.writeString(this.f79391b);
        AutocompleteUiIcon autocompleteUiIcon = this.f79392c;
        if (autocompleteUiIcon == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            autocompleteUiIcon.writeToParcel(dest, i3);
        }
        dest.writeString(this.f79393d);
        Integer num = this.f79394f;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }
}
