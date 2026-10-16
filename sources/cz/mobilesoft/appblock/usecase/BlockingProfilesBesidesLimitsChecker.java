package cz.mobilesoft.appblock.usecase;

import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
public final class BlockingProfilesBesidesLimitsChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BlockingProfilesBesidesLimitsChecker f95108a = new BlockingProfilesBesidesLimitsChecker();

    private BlockingProfilesBesidesLimitsChecker() {
    }

    public final boolean a(List profiles, Collection packageNames, List list) {
        Set setEmptySet;
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        if (list != null) {
            setEmptySet = new LinkedHashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                setEmptySet.add(Long.valueOf(((UsageLimit) it.next()).l()));
            }
        } else {
            setEmptySet = SetsKt.emptySet();
        }
        Iterator it2 = profiles.iterator();
        while (it2.hasNext()) {
            ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) it2.next();
            if (!setEmptySet.contains(Long.valueOf(profileWithConfiguration.p().r())) && profileWithConfiguration.A(packageNames)) {
                if (profileWithConfiguration.r().isEmpty()) {
                    return true;
                }
                List<UsageLimit> listR = profileWithConfiguration.r();
                if (!(listR instanceof Collection) || !listR.isEmpty()) {
                    for (UsageLimit usageLimit : listR) {
                        if (usageLimit.f() - usageLimit.m() <= 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
