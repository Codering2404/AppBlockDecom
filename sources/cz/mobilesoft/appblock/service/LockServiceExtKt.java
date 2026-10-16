package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
public final class LockServiceExtKt {
    public static final void a(LockServiceV2 lockServiceV2, List profilesWithConfiguration) {
        LockRunnable lockRunnableH;
        LockRunnable lockRunnableH2;
        Intrinsics.checkNotNullParameter(lockServiceV2, "<this>");
        Intrinsics.checkNotNullParameter(profilesWithConfiguration, "profilesWithConfiguration");
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        Iterator it = profilesWithConfiguration.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) it.next();
            if (profileWithConfiguration.p().B() == ProfileType.STRICT_MODE) {
                z2 = true;
            } else if (profileWithConfiguration.p().o() == Profile.BlockingMode.Blocklist) {
                hashSet.add(profileWithConfiguration);
                if (profileWithConfiguration.p().U(ProfileType.USAGE_LIMIT) || profileWithConfiguration.p().U(ProfileType.LAUNCH_COUNT)) {
                    hashSet2.add(Long.valueOf(profileWithConfiguration.p().r()));
                }
            }
        }
        if (!Intrinsics.areEqual(lockServiceV2.I(), hashSet2)) {
            lockServiceV2.a0(hashSet2);
            lockServiceV2.D().clear();
            if (!hashSet2.isEmpty() && (lockRunnableH2 = lockServiceV2.H()) != null) {
                for (UsageLimit usageLimit : LockRunnable.Y(lockRunnableH2, profilesWithConfiguration, null, null, null, 14, null)) {
                    long jC = usageLimit.c();
                    if (usageLimit.e() < usageLimit.d()) {
                        lockServiceV2.D().add(Long.valueOf(jC));
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : hashSet) {
            if (!lockServiceV2.D().contains(Long.valueOf(((ProfileWithConfiguration) obj).p().r()))) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet4 = CollectionsKt.toHashSet(arrayList);
        if (!hashSet4.isEmpty() && (lockRunnableH = lockServiceV2.H()) != null) {
            Iterator it2 = lockRunnableH.K(hashSet4).iterator();
            while (it2.hasNext()) {
                hashSet3.add(((ApplicationProfileRelation) it2.next()).a());
            }
        }
        if (Intrinsics.areEqual(lockServiceV2.C(), hashSet3) && lockServiceV2.K() == z2) {
            return;
        }
        lockServiceV2.Z(z2);
        lockServiceV2.Y(hashSet3);
        lockServiceV2.f0();
    }
}
