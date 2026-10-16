package androidx.core.widget;

import android.appwidget.AppWidgetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.util.SizeFCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class AppWidgetManagerApi16Impl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppWidgetManagerApi16Impl f34625a = new AppWidgetManagerApi16Impl();

    private AppWidgetManagerApi16Impl() {
    }

    private final RemoteViews a(SizeFCompat sizeFCompat, SizeFCompat sizeFCompat2, Function1 function1) {
        return Intrinsics.areEqual(sizeFCompat, sizeFCompat2) ? (RemoteViews) function1.invoke(sizeFCompat) : new RemoteViews((RemoteViews) function1.invoke(sizeFCompat), (RemoteViews) function1.invoke(sizeFCompat2));
    }

    private final LandscapePortraitSizes d(AppWidgetManager appWidgetManager, int i3) {
        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i3);
        int i4 = appWidgetOptions.getInt("appWidgetMinWidth", -1);
        int i5 = appWidgetOptions.getInt("appWidgetMaxHeight", -1);
        if (i4 >= 0 && i5 >= 0) {
            int i6 = appWidgetOptions.getInt("appWidgetMaxWidth", -1);
            int i7 = appWidgetOptions.getInt("appWidgetMinHeight", -1);
            if (i6 >= 0 && i7 >= 0) {
                return new LandscapePortraitSizes(new SizeFCompat(i6, i7), new SizeFCompat(i4, i5));
            }
        }
        return null;
    }

    public final RemoteViews b(AppWidgetManager appWidgetManager, int i3, Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        LandscapePortraitSizes landscapePortraitSizesD = d(appWidgetManager, i3);
        if (landscapePortraitSizesD != null) {
            return a(landscapePortraitSizesD.a(), landscapePortraitSizesD.b(), factory);
        }
        Log.w("AppWidgetManagerCompat", "App widget sizes not found in the options bundle, falling back to the provider size");
        return AppWidgetManagerCompat.b(appWidgetManager, i3, factory);
    }

    public final RemoteViews c(AppWidgetManager appWidgetManager, int i3, Collection<SizeFCompat> sizes, Function1<? super SizeFCompat, ? extends RemoteViews> factory) {
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Collection<SizeFCompat> collection = sizes;
        Iterator<T> it = collection.iterator();
        Object next3 = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fC = AppWidgetManagerCompat.c((SizeFCompat) next);
                do {
                    Object next4 = it.next();
                    float fC2 = AppWidgetManagerCompat.c((SizeFCompat) next4);
                    if (Float.compare(fC, fC2) > 0) {
                        next = next4;
                        fC = fC2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) next;
        if (sizeFCompat == null) {
            throw new IllegalStateException("Sizes cannot be empty");
        }
        LandscapePortraitSizes landscapePortraitSizesD = d(appWidgetManager, i3);
        if (landscapePortraitSizesD == null) {
            Log.w("AppWidgetManagerCompat", "App widget sizes not found in the options bundle, falling back to the smallest supported size (" + sizeFCompat + ')');
            landscapePortraitSizesD = new LandscapePortraitSizes(sizeFCompat, sizeFCompat);
        }
        SizeFCompat sizeFCompatA = landscapePortraitSizesD.a();
        SizeFCompat sizeFCompatB = landscapePortraitSizesD.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (AppWidgetManagerCompat.a(sizeFCompatA, (SizeFCompat) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                float fC3 = AppWidgetManagerCompat.c((SizeFCompat) next2);
                do {
                    Object next5 = it2.next();
                    float fC4 = AppWidgetManagerCompat.c((SizeFCompat) next5);
                    if (Float.compare(fC3, fC4) < 0) {
                        next2 = next5;
                        fC3 = fC4;
                    }
                } while (it2.hasNext());
            }
        } else {
            next2 = null;
        }
        SizeFCompat sizeFCompat2 = (SizeFCompat) next2;
        SizeFCompat sizeFCompat3 = sizeFCompat2 == null ? sizeFCompat : sizeFCompat2;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : collection) {
            if (AppWidgetManagerCompat.a(sizeFCompatB, (SizeFCompat) obj2)) {
                arrayList2.add(obj2);
            }
        }
        Iterator it3 = arrayList2.iterator();
        if (it3.hasNext()) {
            next3 = it3.next();
            if (it3.hasNext()) {
                float fC5 = AppWidgetManagerCompat.c((SizeFCompat) next3);
                do {
                    Object next6 = it3.next();
                    float fC6 = AppWidgetManagerCompat.c((SizeFCompat) next6);
                    if (Float.compare(fC5, fC6) < 0) {
                        next3 = next6;
                        fC5 = fC6;
                    }
                } while (it3.hasNext());
            }
        }
        SizeFCompat sizeFCompat4 = (SizeFCompat) next3;
        if (sizeFCompat4 != null) {
            sizeFCompat = sizeFCompat4;
        }
        return a(sizeFCompat3, sizeFCompat, factory);
    }
}
