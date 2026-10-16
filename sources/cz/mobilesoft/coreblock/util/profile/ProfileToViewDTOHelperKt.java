package cz.mobilesoft.coreblock.util.profile;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.WifiDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOption;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.koin.java.KoinJavaComponent;

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
public final class ProfileToViewDTOHelperKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f129306a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            try {
                iArr[ProfileType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProfileType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProfileType.USAGE_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProfileType.LAUNCH_COUNT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProfileType.COMBINED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f129306a = iArr;
        }
    }

    private static final boolean A(Profile profile, List list) {
        Interval intervalR = ProfileHelper.f129250a.r(profile, list);
        ProfileType profileType = ProfileType.TIME;
        return (profile.U(profileType) && ((profile.E() & (~ProfileType.STRICT_MODE.mask())) != profileType.mask()) && profile.x() == 0) ? (intervalR != null && profile.P()) || profile.Q() : intervalR != null || profile.P() || profile.Q();
    }

    public static final Object B(Context context, List list, ProfileItemType profileItemType, boolean z2, Continuation continuation) {
        List list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list2) {
            Long lE = Boxing.e(((ProfileWithConfiguration) obj).p().r());
            Object arrayList = linkedHashMap.get(lE);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lE, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((ProfileWithConfiguration) it.next()).r());
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList2.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList2.get(i4);
            i4++;
            if (((UsageLimit) obj2).i() == UsageLimit.LimitType.TIME) {
                arrayList3.add(obj2);
            } else {
                arrayList4.add(obj2);
            }
        }
        Pair pair = new Pair(arrayList3, arrayList4);
        List list3 = (List) pair.a();
        List list4 = (List) pair.b();
        PremiumRepositoryV2 premiumRepositoryV2 = (PremiumRepositoryV2) KoinJavaComponent.c(PremiumRepositoryV2.class, null, null, 6, null);
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList5.add(((ProfileWithConfiguration) it2.next()).p());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList5, 10)), 16));
        int size2 = arrayList5.size();
        while (i3 < size2) {
            Object obj3 = arrayList5.get(i3);
            i3++;
            linkedHashMap2.put(Boxing.e(((Profile) obj3).r()), obj3);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList6 = new ArrayList();
            Iterator it3 = iterable.iterator();
            while (it3.hasNext()) {
                CollectionsKt.addAll(arrayList6, ((ProfileWithConfiguration) it3.next()).g());
            }
            linkedHashMap3.put(key, arrayList6);
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            Iterable iterable2 = (Iterable) entry2.getValue();
            ArrayList arrayList7 = new ArrayList();
            Iterator it4 = iterable2.iterator();
            while (it4.hasNext()) {
                CollectionsKt.addAll(arrayList7, ((ProfileWithConfiguration) it4.next()).s());
            }
            linkedHashMap4.put(key2, arrayList7);
        }
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            Object key3 = entry3.getKey();
            Iterable iterable3 = (Iterable) entry3.getValue();
            ArrayList arrayList8 = new ArrayList();
            Iterator it5 = iterable3.iterator();
            while (it5.hasNext()) {
                CollectionsKt.addAll(arrayList8, ((ProfileWithConfiguration) it5.next()).q());
            }
            linkedHashMap5.put(key3, arrayList8);
        }
        LinkedHashMap linkedHashMap6 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry4 : linkedHashMap.entrySet()) {
            Object key4 = entry4.getKey();
            Iterable iterable4 = (Iterable) entry4.getValue();
            ArrayList arrayList9 = new ArrayList();
            Iterator it6 = iterable4.iterator();
            while (it6.hasNext()) {
                CollectionsKt.addAll(arrayList9, ((ProfileWithConfiguration) it6.next()).k());
            }
            linkedHashMap6.put(key4, arrayList9);
        }
        LinkedHashMap linkedHashMap7 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry5 : linkedHashMap.entrySet()) {
            Object key5 = entry5.getKey();
            Iterable iterable5 = (Iterable) entry5.getValue();
            ArrayList arrayList10 = new ArrayList();
            Iterator it7 = iterable5.iterator();
            while (it7.hasNext()) {
                CollectionsKt.addAll(arrayList10, ((ProfileWithConfiguration) it7.next()).t());
            }
            linkedHashMap7.put(key5, arrayList10);
        }
        LinkedHashMap linkedHashMap8 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry6 : linkedHashMap.entrySet()) {
            Object key6 = entry6.getKey();
            Iterable iterable6 = (Iterable) entry6.getValue();
            ArrayList arrayList11 = new ArrayList();
            Iterator it8 = iterable6.iterator();
            while (it8.hasNext()) {
                CollectionsKt.addAll(arrayList11, ((ProfileWithConfiguration) it8.next()).l());
            }
            linkedHashMap8.put(key6, arrayList11);
        }
        return D(context, premiumRepositoryV2.J(), profileItemType, linkedHashMap2, linkedHashMap3, linkedHashMap4, linkedHashMap5, linkedHashMap6, linkedHashMap7, linkedHashMap8, list3, list4, z2, continuation);
    }

    public static final String C(Context context, Profile.PausedUntil pausedUntil, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
        if (pausedUntil instanceof Profile.PausedUntil.Time) {
            return StringHelper.f128649a.j(context, ((Profile.PausedUntil.Time) pausedUntil).b());
        }
        if (!(pausedUntil instanceof Profile.PausedUntil.DisabledByPremium)) {
            String string = context.getString(R.string.kc);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(R.string.kc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(z2 ? R.string.Sb : R.string.pp);
        Intrinsics.checkNotNull(string3);
        return StringHelperExtKt.p(string2, string3, " • ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:129:0x0c52, B:134:0x0c5e], limit reached: 301 */
    /* JADX WARN: Path cross not found for [B:180:0x0ed5, B:186:0x0ee2], limit reached: 301 */
    /* JADX WARN: Path cross not found for [B:199:0x0f07, B:205:0x0f15], limit reached: 301 */
    /* JADX WARN: Path cross not found for [B:217:0x0f63, B:219:0x0f69], limit reached: 301 */
    /* JADX WARN: Path cross not found for [B:230:0x0f95, B:232:0x0f9b], limit reached: 301 */
    /* JADX WARN: Path cross not found for [B:238:0x0fb6, B:243:0x0fc1], limit reached: 301 */
    /* JADX WARN: Path cross not found for [B:73:0x0997, B:77:0x099f], limit reached: 301 */
    /* JADX WARN: Path cross not found for [B:77:0x099f, B:73:0x0997], limit reached: 301 */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0be4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0c03  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0c0a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0c47  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0c4a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0c65  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0c68  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0c6c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0c7b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0c8c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0c8f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0c99  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0d3a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0e6f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0ee4  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0ee9  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0eed  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0ef2  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0efa  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0efc  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0f17  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0f1c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0f20  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0f2a  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0f2c  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x1103  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x1172  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x11c3  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x11de  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x1206  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x120f  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x1214  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x1246  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x1249  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x124d  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x1250  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x1258  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x125b  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x125f  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x1262  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x1266  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x1269  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x126d  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x1270  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x1274  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x127b  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x12b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0982  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0985  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0997 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0aa2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0aa5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0af2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0b45  */
    /* JADX WARN: Type inference failed for: r0v213, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r108v11, types: [cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile] */
    /* JADX WARN: Type inference failed for: r118v4 */
    /* JADX WARN: Type inference failed for: r118v5, types: [cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile] */
    /* JADX WARN: Type inference failed for: r118v8 */
    /* JADX WARN: Type inference failed for: r1v12, types: [cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r26v11 */
    /* JADX WARN: Type inference failed for: r26v20, types: [cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile] */
    /* JADX WARN: Type inference failed for: r26v21 */
    /* JADX WARN: Type inference failed for: r8v17, types: [boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:247:0x1103 -> B:248:0x114e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object D(android.content.Context r107, cz.mobilesoft.coreblock.enums.PremiumState r108, cz.mobilesoft.coreblock.util.profile.ProfileItemType r109, java.util.Map r110, java.util.Map r111, java.util.Map r112, java.util.Map r113, java.util.Map r114, java.util.Map r115, java.util.Map r116, java.util.List r117, java.util.List r118, boolean r119, kotlin.coroutines.Continuation r120) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 5068
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.D(android.content.Context, cz.mobilesoft.coreblock.enums.PremiumState, cz.mobilesoft.coreblock.util.profile.ProfileItemType, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.List, java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x08a1  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x08cc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x09b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0809  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object E(android.content.Context r28, java.util.List r29, cz.mobilesoft.coreblock.util.profile.ProfileItemType r30, kotlin.coroutines.Continuation r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.E(android.content.Context, java.util.List, cz.mobilesoft.coreblock.util.profile.ProfileItemType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
    
        if (r12 == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c6, code lost:
    
        if (r12 == r0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object F(android.content.Context r9, java.util.Set r10, cz.mobilesoft.coreblock.util.profile.ProfileItemType r11, kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.F(android.content.Context, java.util.Set, cz.mobilesoft.coreblock.util.profile.ProfileItemType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object G(Context context, Set set, ProfileItemType profileItemType, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            set = null;
        }
        return F(context, set, profileItemType, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable H(ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!it.N());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable I(ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!it.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable J(ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(it.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable K(ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.z()) {
            return -1;
        }
        if (it.B()) {
            return Long.MAX_VALUE;
        }
        return Long.valueOf(it.l().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable L(ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable M(ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence O(WifiDTO wifi) {
        Intrinsics.checkNotNullParameter(wifi, "wifi");
        return StringHelper.w(wifi.a());
    }

    private static final Object P(Context context, final List list, Continuation continuation) throws Throwable {
        Object objA = SchedulesWidgetReceiver.f134136h.a(context, new Function1() { // from class: cz.mobilesoft.coreblock.util.profile.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileToViewDTOHelperKt.Q(list, (AppBlockWidgetState) obj);
            }
        }, continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.widgets.AppBlockWidgetState Q(java.util.List r11, cz.mobilesoft.widgets.AppBlockWidgetState r12) {
        /*
            java.lang.String r0 = "$this$updateWidget"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            cz.mobilesoft.widgets.AppBlockWidgetState$SchedulesWidgetState r0 = r12.g()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r2)
            r1.<init>(r2)
            java.util.Iterator r11 = r11.iterator()
        L1a:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L77
            java.lang.Object r2 = r11.next()
            cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r2 = (cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO) r2
            long r4 = r2.k()
            java.lang.String r6 = r2.u()
            java.lang.String r3 = r2.r()
            if (r3 == 0) goto L41
            int r3 = r3.length()
            if (r3 != 0) goto L3b
            goto L41
        L3b:
            java.lang.String r3 = r2.r()
        L3f:
            r7 = r3
            goto L66
        L41:
            java.lang.String r3 = r2.q()
            if (r3 == 0) goto L57
            java.lang.String r7 = r2.o()
            r8 = 0
            if (r7 == 0) goto L54
            r9 = 2
            java.lang.String r3 = cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt.q(r7, r3, r8, r9, r8)
            goto L55
        L54:
            r3 = r8
        L55:
            if (r3 != 0) goto L3f
        L57:
            java.lang.String r3 = r2.o()
            if (r3 != 0) goto L3f
            java.lang.String r3 = r2.q()
            if (r3 != 0) goto L3f
            java.lang.String r3 = ""
            goto L3f
        L66:
            boolean r8 = r2.x()
            java.lang.Integer r9 = r2.p()
            cz.mobilesoft.widgets.AppBlockWidgetState$SchedulesWidgetState$Schedule r3 = new cz.mobilesoft.widgets.AppBlockWidgetState$SchedulesWidgetState$Schedule
            r3.<init>(r4, r6, r7, r8, r9)
            r1.add(r3)
            goto L1a
        L77:
            cz.mobilesoft.widgets.AppBlockWidgetState$SchedulesWidgetState r6 = r0.d(r1)
            r9 = 13
            r10 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r4 = r12
            cz.mobilesoft.widgets.AppBlockWidgetState r11 = cz.mobilesoft.widgets.AppBlockWidgetState.e(r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.Q(java.util.List, cz.mobilesoft.widgets.AppBlockWidgetState):cz.mobilesoft.widgets.AppBlockWidgetState");
    }

    private static final ProfileDescription o(DescriptionContext descriptionContext, boolean z2) {
        int iD = descriptionContext.j().D(false);
        String quantityString = descriptionContext.a().getResources().getQuantityString(R.plurals.f95747h, iD, Integer.valueOf(iD));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return z2 ? new ProfileDescription(descriptionContext.a().getString(R.string.K, quantityString), null, null) : new ProfileDescription(null, null, quantityString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object p(android.content.Context r29, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r30, cz.mobilesoft.coreblock.enums.ProfileType r31, java.util.List r32, cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress r33, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit r34, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit r35, java.util.List r36, java.util.List r37, java.util.Map r38, boolean r39, kotlin.coroutines.Continuation r40) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.p(android.content.Context, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, cz.mobilesoft.coreblock.enums.ProfileType, java.util.List, cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit, java.util.List, java.util.List, java.util.Map, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object q(cz.mobilesoft.coreblock.util.profile.DescriptionContext r17, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit r18, java.util.List r19, boolean r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.q(cz.mobilesoft.coreblock.util.profile.DescriptionContext, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit, java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object r(cz.mobilesoft.coreblock.util.profile.DescriptionContext r5, cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress r6, boolean r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.r(cz.mobilesoft.coreblock.util.profile.DescriptionContext, cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final ProfileDescription s(DescriptionContext descriptionContext, List list, boolean z2) {
        List listN;
        if (z2) {
            Interval intervalD = descriptionContext.d();
            return new ProfileDescription(intervalD != null ? IntervalsHelperKt.g(intervalD, descriptionContext.a(), descriptionContext.i(), descriptionContext.k()) : null, null, null);
        }
        if (descriptionContext.h() != null) {
            return new ProfileDescription(null, null, StringHelper.r(descriptionContext.a(), descriptionContext.h(), descriptionContext.g()));
        }
        return new ProfileDescription(null, descriptionContext.e(), (list == null || (listN = IntervalsHelperKt.n(list)) == null) ? null : IntervalsHelperKt.d(listN, descriptionContext.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object t(cz.mobilesoft.coreblock.util.profile.DescriptionContext r17, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit r18, java.util.List r19, boolean r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.t(cz.mobilesoft.coreblock.util.profile.DescriptionContext, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit, java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final ProfileDescription u(DescriptionContext descriptionContext, List list, boolean z2) {
        String string;
        if (!z2) {
            String quantityString = list != null ? list.size() > 2 ? descriptionContext.a().getResources().getQuantityString(R.plurals.f95754o, list.size(), Integer.valueOf(list.size())) : CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.util.profile.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProfileToViewDTOHelperKt.v((WifiNetwork) obj);
                }
            }, 30, null) : null;
            return new ProfileDescription(null, descriptionContext.a().getString(R.string.Mq), descriptionContext.e() + ", " + quantityString);
        }
        Context contextA = descriptionContext.a();
        int i3 = R.string.H;
        if (descriptionContext.c() != null) {
            string = "\"" + descriptionContext.c() + "\"";
        } else {
            string = descriptionContext.a().getString(R.string.Mq);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        String string2 = contextA.getString(i3, string);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return new ProfileDescription(string2, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence v(WifiNetwork wifi) {
        Intrinsics.checkNotNullParameter(wifi, "wifi");
        return StringHelper.w(wifi.c());
    }

    public static final String w(Context context) {
        WifiInfo connectionInfo;
        Intrinsics.checkNotNullParameter(context, "<this>");
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
            return null;
        }
        String ssid = connectionInfo.getSSID();
        Intrinsics.checkNotNullExpressionValue(ssid, "getSSID(...)");
        return StringHelper.w(ssid);
    }

    public static final List x(ScheduleDTO scheduleDTO, PremiumState premiumState) {
        ArrayList arrayListD;
        Intrinsics.checkNotNullParameter(scheduleDTO, "<this>");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        boolean zIsSetTo = ProfileType.QUICK_BLOCK.isSetTo(scheduleDTO.z());
        Profile.BlockingMode blockingModeK = scheduleDTO.k();
        boolean zC = scheduleDTO.c();
        boolean zJ = scheduleDTO.j();
        boolean zG = scheduleDTO.g();
        ConditionDTO.TimeDTO timeDTOX = scheduleDTO.x();
        Integer numValueOf = (timeDTOX == null || (arrayListD = timeDTOX.d()) == null) ? null : Integer.valueOf(arrayListD.size());
        ConditionDTO.UsageLimitDTO usageLimitDTOA = scheduleDTO.A();
        Long lValueOf = usageLimitDTOA != null ? Long.valueOf(usageLimitDTOA.e()) : null;
        ConditionDTO.LaunchCountDTO launchCountDTOQ = scheduleDTO.q();
        Long lValueOf2 = launchCountDTOQ != null ? Long.valueOf(launchCountDTOQ.e()) : null;
        int size = scheduleDTO.e().size();
        int size2 = scheduleDTO.C().size() + scheduleDTO.p().size();
        boolean zF = scheduleDTO.f();
        ConditionDTO.TimeDTO timeDTOX2 = scheduleDTO.x();
        return z(premiumState, zIsSetTo, blockingModeK, zC, zJ, zG, zF, numValueOf, lValueOf, lValueOf2, size, size2, timeDTOX2 != null ? Integer.bitCount(timeDTOX2.c()) : 0, !scheduleDTO.w().isEmpty());
    }

    private static final List y(ScheduleDTO scheduleDTO) {
        return CollectionsKt.listOf((Object[]) new ExtraOption[]{new ExtraOption.AddNewlyInstalledApps(scheduleDTO.c()), new ExtraOption.AdultContentBlocking(scheduleDTO.f()), new ExtraOption.InAppPurchasesBlocking(scheduleDTO.g()), new ExtraOption.BlockUnsupportedBrowsers(scheduleDTO.j())});
    }

    private static final List z(PremiumState premiumState, boolean z2, Profile.BlockingMode blockingMode, boolean z3, boolean z4, boolean z5, boolean z6, Integer num, Long l3, Long l4, int i3, int i4, int i5, boolean z7) {
        ArrayList arrayList = new ArrayList();
        if (!premiumState.g()) {
            if (blockingMode == Profile.BlockingMode.Allowlist) {
                arrayList.add(Limit.ALLOWLIST);
            }
            if (z6) {
                arrayList.add(Limit.ADULT_CONTENT_BLOCKING);
            }
            if (z5) {
                arrayList.add(Limit.IN_APP_PURCHASES_BLOCKING);
            }
        }
        if (!AccessPolicyKt.a(premiumState, Capability.PremiumAccess)) {
            if (z7) {
                arrayList.add(Limit.SUB_APPS_LIMIT);
            }
            if (z3 && !premiumState.f(Product.ANIA)) {
                arrayList.add(Limit.ADD_NEW_APPS);
            }
            if (z4) {
                arrayList.add(Limit.BLOCK_UNSUPPORTED_BROWSERS);
            }
            if (!premiumState.f(Product.TIMES) && num != null) {
                Limit limit = Limit.TIMES_LIMIT;
                if (ComparableExtKt.c(num, Integer.valueOf(limit.getLimitValue()))) {
                    arrayList.add(limit);
                }
            }
            if (!premiumState.f(Product.USAGE_LIMIT) && l3 != null) {
                Limit limit2 = Limit.USAGE_LIMIT;
                if (ComparableExtKt.c(l3, Long.valueOf(((long) (limit2.getLimitValue() * 60)) * 1000))) {
                    arrayList.add(limit2);
                }
            }
            if (!premiumState.f(Product.LAUNCH_COUNT) && l4 != null) {
                Limit limit3 = Limit.LAUNCH_COUNT;
                if (ComparableExtKt.c(l4, Long.valueOf(limit3.getLimitValue()))) {
                    arrayList.add(limit3);
                }
            }
            Limit limit4 = z2 ? Limit.APP_WEB_LIMIT_QUICK_BLOCK : Limit.APP_LIMIT;
            if (!premiumState.f(Product.APPLICATIONS) && i3 > limit4.getLimitValue()) {
                arrayList.add(Limit.APP_LIMIT);
            }
            Limit limit5 = z2 ? Limit.APP_WEB_LIMIT_QUICK_BLOCK : Limit.WEBSITE_LIMIT;
            if (!premiumState.f(Product.WEBSITES) && i4 > limit5.getLimitValue()) {
                arrayList.add(Limit.WEBSITE_LIMIT);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x073c A[LOOP:0: B:211:0x073a->B:212:0x073c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0790 A[LOOP:1: B:214:0x078e->B:215:0x0790, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x07ce A[LOOP:2: B:217:0x07cc->B:218:0x07ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0823  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0888  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x088b  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x089c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x08a1  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x08be A[LOOP:4: B:238:0x08b8->B:240:0x08be, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0909  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0918  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0929  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0941  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0983 A[LOOP:5: B:265:0x097d->B:267:0x0983, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x09a6  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x09d6  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0a13  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0a3f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0a44  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0a48 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0a4d  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0a51  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0a5a  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0a6a  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0a6d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0a71  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0a74  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0a78  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0a7f  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0a82  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0363  */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r30v11 */
    /* JADX WARN: Type inference failed for: r30v12 */
    /* JADX WARN: Type inference failed for: r30v2 */
    /* JADX WARN: Type inference failed for: r30v3 */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r30v6 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v80 */
    /* JADX WARN: Type inference failed for: r3v86 */
    /* JADX WARN: Type inference failed for: r48v10 */
    /* JADX WARN: Type inference failed for: r48v14 */
    /* JADX WARN: Type inference failed for: r48v15 */
    /* JADX WARN: Type inference failed for: r48v16 */
    /* JADX WARN: Type inference failed for: r48v6 */
    /* JADX WARN: Type inference failed for: r48v7 */
    /* JADX WARN: Type inference failed for: r48v8 */
    /* JADX WARN: Type inference failed for: r48v9 */
    /* JADX WARN: Type inference failed for: r49v12 */
    /* JADX WARN: Type inference failed for: r49v13 */
    /* JADX WARN: Type inference failed for: r49v14 */
    /* JADX WARN: Type inference failed for: r49v15 */
    /* JADX WARN: Type inference failed for: r49v16 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v70 */
    /* JADX WARN: Type inference failed for: r6v75 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object N(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r47, android.content.Context r48, java.util.List r49, cz.mobilesoft.coreblock.scene.schedule.detail.LockState r50, cz.mobilesoft.coreblock.enums.PremiumState r51, java.util.List r52, boolean r53, kotlin.coroutines.Continuation r54) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.N(cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO, android.content.Context, java.util.List, cz.mobilesoft.coreblock.scene.schedule.detail.LockState, cz.mobilesoft.coreblock.enums.PremiumState, java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
