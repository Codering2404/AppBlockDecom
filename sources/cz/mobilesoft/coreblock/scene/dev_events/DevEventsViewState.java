package cz.mobilesoft.coreblock.scene.dev_events;

import cz.mobilesoft.coreblock.base.ViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DevEventsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f101665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f101666b;

    public DevEventsViewState(List eventList, boolean z2) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        this.f101665a = eventList;
        this.f101666b = z2;
    }

    public static /* synthetic */ DevEventsViewState b(DevEventsViewState devEventsViewState, List list, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = devEventsViewState.f101665a;
        }
        if ((i3 & 2) != 0) {
            z2 = devEventsViewState.f101666b;
        }
        return devEventsViewState.a(list, z2);
    }

    public final DevEventsViewState a(List eventList, boolean z2) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        return new DevEventsViewState(eventList, z2);
    }

    public final List c() {
        return this.f101665a;
    }

    public final boolean d() {
        return this.f101666b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DevEventsViewState)) {
            return false;
        }
        DevEventsViewState devEventsViewState = (DevEventsViewState) obj;
        return Intrinsics.areEqual(this.f101665a, devEventsViewState.f101665a) && this.f101666b == devEventsViewState.f101666b;
    }

    public int hashCode() {
        return (this.f101665a.hashCode() * 31) + Boolean.hashCode(this.f101666b);
    }

    public String toString() {
        return "DevEventsViewState(eventList=" + this.f101665a + ", showConfirmRow=" + this.f101666b + ")";
    }

    public /* synthetic */ DevEventsViewState(List list, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? false : z2);
    }
}
