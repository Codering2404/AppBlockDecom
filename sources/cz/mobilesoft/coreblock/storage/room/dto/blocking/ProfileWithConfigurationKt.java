package cz.mobilesoft.coreblock.storage.room.dto.blocking;

import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelperKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;
import org.threeten.bp.DayOfWeek;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProfileWithConfigurationKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f126378a = EnumEntriesKt.a(DayOfWeek.values());
    }

    public static final List a(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (((ProfileWithConfiguration) obj).p().o() == Profile.BlockingMode.Blocklist) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            List<ApplicationProfileRelation> listG = ((ProfileWithConfiguration) obj2).g();
            ArrayList arrayList3 = new ArrayList();
            for (ApplicationProfileRelation applicationProfileRelation : listG) {
                if (applicationProfileRelation.b() != 0) {
                    applicationProfileRelation = null;
                }
                if (applicationProfileRelation != null) {
                    arrayList3.add(applicationProfileRelation);
                }
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        return arrayList2;
    }

    public static final List b(Collection collection, String primaryPackage, String str) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(primaryPackage, "primaryPackage");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (((ProfileWithConfiguration) obj).p().o() == Profile.BlockingMode.Blocklist) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            CollectionsKt.addAll(arrayList2, ((ProfileWithConfiguration) obj2).e(primaryPackage, str));
        }
        return arrayList2;
    }

    public static final Set c(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((ProfileWithConfiguration) it.next()).h());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final Configuration d(ProfileWithConfiguration profileWithConfiguration) {
        Intrinsics.checkNotNullParameter(profileWithConfiguration, "<this>");
        EnumEntries enumEntries = EntriesMappings.f126378a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : enumEntries) {
            if ((DayFlags.Companion.b((DayOfWeek) obj).getValue() & profileWithConfiguration.p().p()) > 0) {
                arrayList.add(obj);
            }
        }
        ImmutableSet immutableSetJ = ExtensionsKt.j(arrayList);
        List<Interval> listN = IntervalsHelperKt.n(profileWithConfiguration.l());
        ArrayList arrayList2 = new ArrayList(profileWithConfiguration.l().size());
        for (Interval interval : listN) {
            arrayList2.add(new IntervalDTO(interval.b(), interval.a(), null, null, 12, null));
        }
        ImmutableList immutableListH = ExtensionsKt.h(arrayList2);
        List listL = profileWithConfiguration.l();
        boolean z2 = false;
        if (!(listL instanceof Collection) || !listL.isEmpty()) {
            Iterator it = listL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (IntervalsHelperKt.k((Interval) it.next())) {
                    z2 = true;
                    break;
                }
            }
        }
        return new Configuration(immutableSetJ, null, immutableListH, z2, false, 18, null);
    }
}
