package androidx.glance.appwidget;

import android.widget.RemoteViews;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RemoteCollectionItems {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f38411e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final RemoteCollectionItems f38412f = new RemoteCollectionItems(new long[0], new RemoteViews[0], false, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f38413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RemoteViews[] f38414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f38415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f38416d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f38417a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f38418b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f38419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f38420d;

        public final Builder a(long j3, RemoteViews remoteViews) {
            this.f38417a.add(Long.valueOf(j3));
            this.f38418b.add(remoteViews);
            return this;
        }

        public final RemoteCollectionItems b() {
            if (this.f38420d < 1) {
                ArrayList arrayList = this.f38418b;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    arrayList2.add(Integer.valueOf(((RemoteViews) obj).getLayoutId()));
                }
                this.f38420d = CollectionsKt.distinct(arrayList2).size();
            }
            return new RemoteCollectionItems(CollectionsKt.toLongArray(this.f38417a), (RemoteViews[]) this.f38418b.toArray(new RemoteViews[0]), this.f38419c, Math.max(this.f38420d, 1), null);
        }

        public final Builder c(boolean z2) {
            this.f38419c = z2;
            return this;
        }

        public final Builder d(int i3) {
            this.f38420d = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RemoteCollectionItems a() {
            return RemoteCollectionItems.f38412f;
        }

        private Companion() {
        }
    }

    public /* synthetic */ RemoteCollectionItems(long[] jArr, RemoteViews[] remoteViewsArr, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr, remoteViewsArr, z2, i3);
    }

    public final int b() {
        return this.f38413a.length;
    }

    public final long c(int i3) {
        return this.f38413a[i3];
    }

    public final RemoteViews d(int i3) {
        return this.f38414b[i3];
    }

    public final int e() {
        return this.f38416d;
    }

    public final boolean f() {
        return this.f38415c;
    }

    private RemoteCollectionItems(long[] jArr, RemoteViews[] remoteViewsArr, boolean z2, int i3) {
        this.f38413a = jArr;
        this.f38414b = remoteViewsArr;
        this.f38415c = z2;
        this.f38416d = i3;
        if (jArr.length != remoteViewsArr.length) {
            throw new IllegalArgumentException("RemoteCollectionItems has different number of ids and views");
        }
        if (i3 < 1) {
            throw new IllegalArgumentException("View type count must be >= 1");
        }
        ArrayList arrayList = new ArrayList(remoteViewsArr.length);
        for (RemoteViews remoteViews : remoteViewsArr) {
            arrayList.add(Integer.valueOf(remoteViews.getLayoutId()));
        }
        int size = CollectionsKt.distinct(arrayList).size();
        if (size <= this.f38416d) {
            return;
        }
        throw new IllegalArgumentException(("View type count is set to " + this.f38416d + ", but the collection contains " + size + " different layout ids").toString());
    }
}
