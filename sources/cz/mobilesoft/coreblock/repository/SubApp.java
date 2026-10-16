package cz.mobilesoft.coreblock.repository;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
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
public final class SubApp implements Parcelable, Serializable {
    private final String eventParameter;
    private final String id;
    private final String parentApp;
    private final int title;
    private final List<String> viewIds;
    public static final Parcelable.Creator<SubApp> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<SubApp> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubApp createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubApp(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubApp[] newArray(int i3) {
            return new SubApp[i3];
        }
    }

    public SubApp(String id, int i3, String parentApp, String eventParameter, List<String> viewIds) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(parentApp, "parentApp");
        Intrinsics.checkNotNullParameter(eventParameter, "eventParameter");
        Intrinsics.checkNotNullParameter(viewIds, "viewIds");
        this.id = id;
        this.title = i3;
        this.parentApp = parentApp;
        this.eventParameter = eventParameter;
        this.viewIds = viewIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubApp copy$default(SubApp subApp, String str, int i3, String str2, String str3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = subApp.id;
        }
        if ((i4 & 2) != 0) {
            i3 = subApp.title;
        }
        if ((i4 & 4) != 0) {
            str2 = subApp.parentApp;
        }
        if ((i4 & 8) != 0) {
            str3 = subApp.eventParameter;
        }
        if ((i4 & 16) != 0) {
            list = subApp.viewIds;
        }
        List list2 = list;
        String str4 = str2;
        return subApp.copy(str, i3, str4, str3, list2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.title;
    }

    public final String component3() {
        return this.parentApp;
    }

    public final String component4() {
        return this.eventParameter;
    }

    public final List<String> component5() {
        return this.viewIds;
    }

    public final SubApp copy(String id, int i3, String parentApp, String eventParameter, List<String> viewIds) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(parentApp, "parentApp");
        Intrinsics.checkNotNullParameter(eventParameter, "eventParameter");
        Intrinsics.checkNotNullParameter(viewIds, "viewIds");
        return new SubApp(id, i3, parentApp, eventParameter, viewIds);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubApp)) {
            return false;
        }
        SubApp subApp = (SubApp) obj;
        return Intrinsics.areEqual(this.id, subApp.id) && this.title == subApp.title && Intrinsics.areEqual(this.parentApp, subApp.parentApp) && Intrinsics.areEqual(this.eventParameter, subApp.eventParameter) && Intrinsics.areEqual(this.viewIds, subApp.viewIds);
    }

    public final String getEventParameter() {
        return this.eventParameter;
    }

    public final String getId() {
        return this.id;
    }

    public final String getParentApp() {
        return this.parentApp;
    }

    public final int getTitle() {
        return this.title;
    }

    public final List<String> getViewIds() {
        return this.viewIds;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + Integer.hashCode(this.title)) * 31) + this.parentApp.hashCode()) * 31) + this.eventParameter.hashCode()) * 31) + this.viewIds.hashCode();
    }

    public String toString() {
        return "SubApp(id=" + this.id + ", title=" + this.title + ", parentApp=" + this.parentApp + ", eventParameter=" + this.eventParameter + ", viewIds=" + this.viewIds + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeInt(this.title);
        dest.writeString(this.parentApp);
        dest.writeString(this.eventParameter);
        dest.writeStringList(this.viewIds);
    }
}
