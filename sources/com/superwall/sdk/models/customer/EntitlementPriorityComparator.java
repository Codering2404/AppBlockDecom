package com.superwall.sdk.models.customer;

import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.store.abstractions.product.receipt.LatestSubscriptionState;
import java.util.Comparator;
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
public final class EntitlementPriorityComparator implements Comparator<Entitlement> {
    public static final EntitlementPriorityComparator INSTANCE = new EntitlementPriorityComparator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LatestSubscriptionState.values().length];
            try {
                iArr[LatestSubscriptionState.SUBSCRIBED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LatestSubscriptionState.GRACE_PERIOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LatestSubscriptionState.BILLING_RETRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LatestSubscriptionState.EXPIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private EntitlementPriorityComparator() {
    }

    private final int getStateScore(LatestSubscriptionState latestSubscriptionState) {
        int i3 = latestSubscriptionState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[latestSubscriptionState.ordinal()];
        if (i3 == 1) {
            return 4;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 != 3) {
            return i3 != 4 ? 0 : 1;
        }
        return 2;
    }

    @Override // java.util.Comparator
    public int compare(Entitlement a3, Entitlement b3) {
        int stateScore;
        int stateScore2;
        int iCompareTo;
        Intrinsics.checkNotNullParameter(a3, "a");
        Intrinsics.checkNotNullParameter(b3, "b");
        if (a3.isActive() != b3.isActive()) {
            return a3.isActive() ? 1 : -1;
        }
        boolean z2 = a3.getStartsAt() != null;
        if (z2 != (b3.getStartsAt() != null)) {
            return z2 ? 1 : -1;
        }
        Boolean boolIsLifetime = a3.isLifetime();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolIsLifetime, bool) && !Intrinsics.areEqual(b3.isLifetime(), bool)) {
            return 1;
        }
        if (Intrinsics.areEqual(b3.isLifetime(), bool) && !Intrinsics.areEqual(a3.isLifetime(), bool)) {
            return -1;
        }
        if (a3.getExpiresAt() != null && b3.getExpiresAt() != null && (iCompareTo = a3.getExpiresAt().compareTo(b3.getExpiresAt())) != 0) {
            return iCompareTo;
        }
        if (Intrinsics.areEqual(a3.getWillRenew(), bool) && !Intrinsics.areEqual(b3.getWillRenew(), bool)) {
            return 1;
        }
        if (Intrinsics.areEqual(b3.getWillRenew(), bool) && !Intrinsics.areEqual(a3.getWillRenew(), bool)) {
            return -1;
        }
        LatestSubscriptionState state = a3.getState();
        LatestSubscriptionState state2 = b3.getState();
        if (state == state2 || (stateScore = getStateScore(state)) == (stateScore2 = getStateScore(state2))) {
            return 0;
        }
        return Intrinsics.compare(stateScore, stateScore2);
    }
}
