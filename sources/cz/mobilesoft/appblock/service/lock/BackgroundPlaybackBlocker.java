package cz.mobilesoft.appblock.service.lock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BackgroundPlaybackBlocker {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f94758e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f94759f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f94760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f94761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f94762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f94763d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BackgroundPlaybackBlocker(Set excludedPackages, int i3, long j3) {
        Intrinsics.checkNotNullParameter(excludedPackages, "excludedPackages");
        this.f94760a = excludedPackages;
        this.f94761b = i3;
        this.f94762c = j3;
        this.f94763d = new LinkedHashMap();
    }

    private final void b(final long j3) {
        Iterator it = this.f94763d.entrySet().iterator();
        while (it.hasNext()) {
            List list = (List) ((Map.Entry) it.next()).getValue();
            CollectionsKt.removeAll(list, new Function1() { // from class: cz.mobilesoft.appblock.service.lock.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BackgroundPlaybackBlocker.c(j3, this, ((Long) obj).longValue()));
                }
            });
            if (list.isEmpty()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(long j3, BackgroundPlaybackBlocker backgroundPlaybackBlocker, long j4) {
        return j3 - j4 >= backgroundPlaybackBlocker.f94762c;
    }

    public final Set d(Set playingPackages, long j3, Function1 isBlocked) {
        Intrinsics.checkNotNullParameter(playingPackages, "playingPackages");
        Intrinsics.checkNotNullParameter(isBlocked, "isBlocked");
        b(j3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = playingPackages.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.f94760a.contains(str)) {
                if (((Boolean) isBlocked.invoke(str)).booleanValue()) {
                    Map map = this.f94763d;
                    Object arrayList = map.get(str);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put(str, arrayList);
                    }
                    List list = (List) arrayList;
                    if (list.size() < this.f94761b) {
                        list.add(Long.valueOf(j3));
                        linkedHashSet.add(str);
                    }
                } else {
                    this.f94763d.remove(str);
                }
            }
        }
        return linkedHashSet;
    }

    public /* synthetic */ BackgroundPlaybackBlocker(Set set, int i3, long j3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i4 & 2) != 0 ? 3 : i3, (i4 & 4) != 0 ? 30000L : j3);
    }
}
