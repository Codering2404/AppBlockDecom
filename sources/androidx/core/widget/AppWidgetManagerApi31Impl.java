package androidx.core.widget;

import android.appwidget.AppWidgetManager;
import android.util.Log;
import android.util.SizeF;
import android.widget.RemoteViews;
import androidx.core.util.SizeFCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class AppWidgetManagerApi31Impl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppWidgetManagerApi31Impl f34626a = new AppWidgetManagerApi31Impl();

    private AppWidgetManagerApi31Impl() {
    }

    private final SizeFCompat c(SizeF sizeF) {
        SizeFCompat sizeFCompatD = SizeFCompat.d(sizeF);
        Intrinsics.checkNotNullExpressionValue(sizeFCompatD, "toSizeFCompat(this)");
        return sizeFCompatD;
    }

    public final RemoteViews a(AppWidgetManager appWidgetManager, int i3, Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ArrayList parcelableArrayList = appWidgetManager.getAppWidgetOptions(i3).getParcelableArrayList("appWidgetSizes");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            Log.w("AppWidgetManagerCompat", "App widget SizeF sizes not found in the options bundle, falling back to the min/max sizes");
            return AppWidgetManagerApi16Impl.f34625a.b(appWidgetManager, i3, factory);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(parcelableArrayList, 10)), 16));
        int size = parcelableArrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = parcelableArrayList.get(i4);
            i4++;
            SizeF it = (SizeF) obj;
            AppWidgetManagerApi31Impl appWidgetManagerApi31Impl = f34626a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            linkedHashMap.put(obj, (RemoteViews) factory.invoke(appWidgetManagerApi31Impl.c(it)));
        }
        return new RemoteViews(linkedHashMap);
    }

    public final RemoteViews b(Collection<SizeFCompat> dpSizes, Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(dpSizes, "dpSizes");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Collection<SizeFCompat> collection = dpSizes;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collection, 10)), 16));
        for (SizeFCompat sizeFCompat : collection) {
            Pair pairA = TuplesKt.a(sizeFCompat.c(), factory.invoke(sizeFCompat));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return new RemoteViews(linkedHashMap);
    }
}
