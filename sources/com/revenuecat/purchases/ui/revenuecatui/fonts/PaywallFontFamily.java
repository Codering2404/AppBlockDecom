package com.revenuecat.purchases.ui.revenuecatui.fonts;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallFontFamily implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<PaywallFontFamily> CREATOR = new Creator();
    private final List<PaywallFont> fonts;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PaywallFontFamily> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaywallFontFamily createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList.add(parcel.readParcelable(PaywallFontFamily.class.getClassLoader()));
            }
            return new PaywallFontFamily(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaywallFontFamily[] newArray(int i3) {
            return new PaywallFontFamily[i3];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallFontFamily(List<? extends PaywallFont> fonts) {
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.fonts = fonts;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaywallFontFamily) && Intrinsics.areEqual(this.fonts, ((PaywallFontFamily) obj).fonts);
    }

    public final List<PaywallFont> getFonts() {
        return this.fonts;
    }

    public int hashCode() {
        return this.fonts.hashCode();
    }

    public String toString() {
        return "PaywallFontFamily(fonts=" + this.fonts + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        List<PaywallFont> list = this.fonts;
        out.writeInt(list.size());
        Iterator<PaywallFont> it = list.iterator();
        while (it.hasNext()) {
            out.writeParcelable(it.next(), i3);
        }
    }
}
