package com.superwall.sdk.store.transactions.notifications;

import com.superwall.sdk.models.paywall.LocalNotification;
import com.superwall.sdk.models.paywall.LocalNotificationType;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class TrialReminderLogic {
    public static final TrialReminderLogic INSTANCE = new TrialReminderLogic();

    private TrialReminderLogic() {
    }

    public final List<LocalNotification> fallbackTrialNotifications(PaywallInfo paywallInfo, boolean z2) {
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        if (!z2) {
            return CollectionsKt.emptyList();
        }
        List<LocalNotification> localNotifications = paywallInfo.getLocalNotifications();
        ArrayList arrayList = new ArrayList();
        for (Object obj : localNotifications) {
            if (Intrinsics.areEqual(((LocalNotification) obj).getType(), LocalNotificationType.TrialStarted.INSTANCE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            LocalNotification localNotification = (LocalNotification) obj2;
            arrayList2.add(LocalNotification.copy$default(localNotification, paywallInfo.getIdentifier() + "_" + localNotification.getType().getRaw(), null, null, null, null, 0L, 62, null));
        }
        return arrayList2;
    }
}
