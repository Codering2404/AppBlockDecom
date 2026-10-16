package cz.mobilesoft.coreblock.scene.more.notifications;

import cz.mobilesoft.coreblock.base.ViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class BlockedNotificationsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f107882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f107883b;

    public BlockedNotificationsViewState(boolean z2, ImmutableList limitedItems) {
        Intrinsics.checkNotNullParameter(limitedItems, "limitedItems");
        this.f107882a = z2;
        this.f107883b = limitedItems;
    }

    public static /* synthetic */ BlockedNotificationsViewState b(BlockedNotificationsViewState blockedNotificationsViewState, boolean z2, ImmutableList immutableList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = blockedNotificationsViewState.f107882a;
        }
        if ((i3 & 2) != 0) {
            immutableList = blockedNotificationsViewState.f107883b;
        }
        return blockedNotificationsViewState.a(z2, immutableList);
    }

    public final BlockedNotificationsViewState a(boolean z2, ImmutableList limitedItems) {
        Intrinsics.checkNotNullParameter(limitedItems, "limitedItems");
        return new BlockedNotificationsViewState(z2, limitedItems);
    }

    public final ImmutableList c() {
        return this.f107883b;
    }

    public final boolean d() {
        return this.f107882a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockedNotificationsViewState)) {
            return false;
        }
        BlockedNotificationsViewState blockedNotificationsViewState = (BlockedNotificationsViewState) obj;
        return this.f107882a == blockedNotificationsViewState.f107882a && Intrinsics.areEqual(this.f107883b, blockedNotificationsViewState.f107883b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f107882a) * 31) + this.f107883b.hashCode();
    }

    public String toString() {
        return "BlockedNotificationsViewState(isPremiumActive=" + this.f107882a + ", limitedItems=" + this.f107883b + ")";
    }

    public /* synthetic */ BlockedNotificationsViewState(boolean z2, ImmutableList immutableList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? ExtensionsKt.a() : immutableList);
    }
}
