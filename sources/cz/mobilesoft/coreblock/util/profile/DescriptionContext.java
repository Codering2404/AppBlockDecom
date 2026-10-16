package cz.mobilesoft.coreblock.util.profile;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class DescriptionContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f129229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Profile f129230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f129231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f129232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Interval f129233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interval f129234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Interval f129235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f129236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f129237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final EventDataStore f129238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CoreMultiProcessDataStore f129239k;

    public DescriptionContext(Context context, Profile profile, long j3, boolean z2, Interval interval, Interval interval2, Interval interval3, String daysText, String str, EventDataStore eventDataStore, CoreMultiProcessDataStore coreMultiProcessDataStore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(daysText, "daysText");
        Intrinsics.checkNotNullParameter(eventDataStore, "eventDataStore");
        Intrinsics.checkNotNullParameter(coreMultiProcessDataStore, "coreMultiProcessDataStore");
        this.f129229a = context;
        this.f129230b = profile;
        this.f129231c = j3;
        this.f129232d = z2;
        this.f129233e = interval;
        this.f129234f = interval2;
        this.f129235g = interval3;
        this.f129236h = daysText;
        this.f129237i = str;
        this.f129238j = eventDataStore;
        this.f129239k = coreMultiProcessDataStore;
    }

    public final Context a() {
        return this.f129229a;
    }

    public final CoreMultiProcessDataStore b() {
        return this.f129239k;
    }

    public final String c() {
        return this.f129237i;
    }

    public final Interval d() {
        return this.f129233e;
    }

    public final String e() {
        return this.f129236h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DescriptionContext)) {
            return false;
        }
        DescriptionContext descriptionContext = (DescriptionContext) obj;
        return Intrinsics.areEqual(this.f129229a, descriptionContext.f129229a) && Intrinsics.areEqual(this.f129230b, descriptionContext.f129230b) && this.f129231c == descriptionContext.f129231c && this.f129232d == descriptionContext.f129232d && Intrinsics.areEqual(this.f129233e, descriptionContext.f129233e) && Intrinsics.areEqual(this.f129234f, descriptionContext.f129234f) && Intrinsics.areEqual(this.f129235g, descriptionContext.f129235g) && Intrinsics.areEqual(this.f129236h, descriptionContext.f129236h) && Intrinsics.areEqual(this.f129237i, descriptionContext.f129237i) && Intrinsics.areEqual(this.f129238j, descriptionContext.f129238j) && Intrinsics.areEqual(this.f129239k, descriptionContext.f129239k);
    }

    public final EventDataStore f() {
        return this.f129238j;
    }

    public final Interval g() {
        return this.f129235g;
    }

    public final Interval h() {
        return this.f129234f;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f129229a.hashCode() * 31) + this.f129230b.hashCode()) * 31) + Long.hashCode(this.f129231c)) * 31) + Boolean.hashCode(this.f129232d)) * 31;
        Interval interval = this.f129233e;
        int iHashCode2 = (iHashCode + (interval == null ? 0 : interval.hashCode())) * 31;
        Interval interval2 = this.f129234f;
        int iHashCode3 = (iHashCode2 + (interval2 == null ? 0 : interval2.hashCode())) * 31;
        Interval interval3 = this.f129235g;
        int iHashCode4 = (((iHashCode3 + (interval3 == null ? 0 : interval3.hashCode())) * 31) + this.f129236h.hashCode()) * 31;
        String str = this.f129237i;
        return ((((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.f129238j.hashCode()) * 31) + this.f129239k.hashCode();
    }

    public final long i() {
        return this.f129231c;
    }

    public final Profile j() {
        return this.f129230b;
    }

    public final boolean k() {
        return this.f129232d;
    }

    public String toString() {
        return "DescriptionContext(context=" + this.f129229a + ", profile=" + this.f129230b + ", nowInMinutes=" + this.f129231c + ", profileEnabledForTomorrow=" + this.f129232d + ", currentlyActiveInterval=" + this.f129233e + ", nextActiveInterval=" + this.f129234f + ", lastPassedInterval=" + this.f129235g + ", daysText=" + this.f129236h + ", currentSSID=" + this.f129237i + ", eventDataStore=" + this.f129238j + ", coreMultiProcessDataStore=" + this.f129239k + ")";
    }
}
