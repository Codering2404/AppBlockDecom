package com.superwall.sdk.analytics.session;

import com.superwall.sdk.models.serialization.DateSerializer;
import java.util.Date;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class AppSession {
    public static final Companion Companion = new Companion(null);
    private Date endAt;
    private String id;
    private Date startAt;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AppSession> serializer() {
            return AppSession$$serializer.INSTANCE;
        }

        public final AppSession stub() {
            return new AppSession((String) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    public AppSession() {
        this((String) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AppSession copy$default(AppSession appSession, String str, Date date, Date date2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = appSession.id;
        }
        if ((i3 & 2) != 0) {
            date = appSession.startAt;
        }
        if ((i3 & 4) != 0) {
            date2 = appSession.endAt;
        }
        return appSession.copy(str, date, date2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(AppSession appSession, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(appSession.id, UUID.randomUUID().toString())) {
            compositeEncoder.y(serialDescriptor, 0, appSession.id);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || !Intrinsics.areEqual(appSession.startAt, new Date())) {
            compositeEncoder.C(serialDescriptor, 1, DateSerializer.INSTANCE, appSession.startAt);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && appSession.endAt == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 2, DateSerializer.INSTANCE, appSession.endAt);
    }

    public final String component1() {
        return this.id;
    }

    public final Date component2() {
        return this.startAt;
    }

    public final Date component3() {
        return this.endAt;
    }

    public final AppSession copy(String id, Date startAt, Date date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        return new AppSession(id, startAt, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSession)) {
            return false;
        }
        AppSession appSession = (AppSession) obj;
        return Intrinsics.areEqual(this.id, appSession.id) && Intrinsics.areEqual(this.startAt, appSession.startAt) && Intrinsics.areEqual(this.endAt, appSession.endAt);
    }

    public final Date getEndAt() {
        return this.endAt;
    }

    public final String getId() {
        return this.id;
    }

    public final Date getStartAt() {
        return this.startAt;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.startAt.hashCode()) * 31;
        Date date = this.endAt;
        return iHashCode + (date == null ? 0 : date.hashCode());
    }

    public final void setEndAt(Date date) {
        this.endAt = date;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setStartAt(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.startAt = date;
    }

    public String toString() {
        return "AppSession(id=" + this.id + ", startAt=" + this.startAt + ", endAt=" + this.endAt + ")";
    }

    public /* synthetic */ AppSession(int i3, String str, Date date, Date date2, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i3 & 1) == 0 ? UUID.randomUUID().toString() : str;
        if ((i3 & 2) == 0) {
            this.startAt = new Date();
        } else {
            this.startAt = date;
        }
        if ((i3 & 4) == 0) {
            this.endAt = null;
        } else {
            this.endAt = date2;
        }
    }

    public AppSession(String id, Date startAt, Date date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        this.id = id;
        this.startAt = startAt;
        this.endAt = date;
    }

    public /* synthetic */ AppSession(String str, Date date, Date date2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UUID.randomUUID().toString() : str, (i3 & 2) != 0 ? new Date() : date, (i3 & 4) != 0 ? null : date2);
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getEndAt$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getStartAt$annotations() {
    }
}
